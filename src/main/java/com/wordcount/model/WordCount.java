package com.wordcount.model;

/**
 * WordCount Object to hold the
 * words and its count
 *
 * @author Shahbaz Alam
 */
public class WordCount {
    private String word;
    private int count;

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    public WordCount(String word, int count) {
        this.word = word;
        this.count = count;
    }
    @Override
    public String toString() {
        return word + ": " + count +"\r\n";
    }
}
