package com.wordcount;

import com.wordcount.helper.WordCounter;
import com.wordcount.model.WordCount;

import java.io.IOException;
import java.util.List;

/**
 * Application Starter to take in
 * a file path and print the count of
 * each word contained in the file to
 * standard output
 *
 *
 * @author Shahbaz Alam
 */
public class WordCountStarter {

    public static void main(String[] args) {
        if (args.length == 0) { // check if no filepath is passed on as the argument
            throw new IllegalArgumentException("no file path given");
        }
        String filePath = args[0];
        WordCounter wordCounter = new WordCounter();
        try{
            if (wordCounter.isValidFile(filePath)) {    // check if the filepath provided is of a valid supported file type
                List<WordCount> wordCounts = wordCounter.getWordCounts(filePath);
                wordCounts.stream()
                        .forEach(word -> System.out.print(word.toString())); //print to standard output each word with its respective count
            } else {
                System.out.println("The file provided is not a valid file. Please provide a file of type text/plain.");
            }
        } catch(IOException ex) {
           throw new RuntimeException("I/O exception caught while reading the file. Please check the given path:" + ex.getMessage());
        }
    }
}
