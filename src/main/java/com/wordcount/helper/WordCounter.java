package com.wordcount.helper;

import com.wordcount.model.WordCount;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * WordCounter utility to count
 * the occurance of each word in
 * a given file.
 *
 * @author Shahbaz Alam
 */
public class WordCounter {
    private static final String regex = "[\\p{Punct}\\s]+";
    private static final String FILE_TYPE_PLAIN_TEXT = "text/plain";

    /**
     * utility method to count the frequency
     * of words in a file.
     * It splits the lines in a file,
     * ignores the punctuations and spaces
     * in between, and maps each word
     * with the number of its occurance in
     * the file.
     * It returns a sorted list based on the
     * count of each word, with the words
     * having the maximum count first.
     *
     * @param filePath
     * @return List<WordCount>
     * @throws IOException
     */
    public List<WordCount> getWordCounts(String filePath) throws IOException {
        List<WordCount> wordCounts = new ArrayList<>();
        Files.lines(Paths.get(filePath))
                .parallel()
                .flatMap(s -> Arrays.asList(s.split(regex)).stream())
                .collect(Collectors.toConcurrentMap(w -> w.toLowerCase(), w -> 1, Integer::sum))
                .forEach((word, count) -> wordCounts.add(new WordCount(word, count)));
        return wordCounts.stream()
                .sorted(Comparator.comparing(WordCount::getCount).reversed()).collect(Collectors.toList());
    }

    /**
     * checks if the file is of a valid type.
     *
     * @param filePath
     * @return boolean
     * @throws IOException
     */
    public boolean isValidFile(String filePath) throws IOException {
        String fileType = Files.probeContentType(Paths.get(filePath));
        if (fileType == null ||
                !fileType.equalsIgnoreCase(FILE_TYPE_PLAIN_TEXT)) {
            return false;
        }
        return true;
    }
}
