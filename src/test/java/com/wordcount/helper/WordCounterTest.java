package com.wordcount.helper;

import com.wordcount.model.WordCount;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WordCounterTest {

    @Test
    public void testWordCounter() {
        WordCounter wordCounter = new WordCounter();
        try {
            List<WordCount> wordCounts = wordCounter.getWordCounts(System.getProperty("user.dir") + "/text.txt");
            assertEquals("the", wordCounts.get(0).getWord());
            assertEquals(3, wordCounts.get(0).getCount());
            assertEquals("test", wordCounts.get(1).getWord());
            assertEquals(2, wordCounts.get(1).getCount());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
