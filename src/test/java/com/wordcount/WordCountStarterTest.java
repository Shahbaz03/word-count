package com.wordcount;

import org.junit.Test;

public class WordCountStarterTest {
    @Test(expected = IllegalArgumentException.class)
    public void testWithIllegalArgument() {
        String[] args = {};
        WordCountStarter.main(args);
    }

    @Test(expected = RuntimeException.class)
    public void testWithIncorrectFilePath() {
        String[] args = {System.getProperty("user.dir") + "/wrongFilePath.txt"};
        WordCountStarter.main(args);
    }
}
