package com.example.wordcounter.service;

import com.example.wordcounter.exception.WordCounterException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@WebMvcTest
@RunWith(SpringRunner.class)
public class WordServiceImplTest {

    @Autowired
    WordService wordService;

    @Test(expected = WordCounterException.class)
    public void addAndCountWordTest() {
        assertTrue(wordService.addWord("abc"));
        assertFalse(wordService.addWord("123abc"));
        assertFalse(wordService.addWord("abc@123"));
        assertTrue(wordService.addWord("ABC"));
        assertTrue(wordService.addWord("abc"));
        assertTrue(wordService.addWord("foo"));
        assertTrue(wordService.addWord("bar"));
        assertTrue(wordService.addWord("bar"));
        assertTrue(wordService.addWord("foox"));
        assertTrue(wordService.addWord("abc"));
        assertTrue(wordService.addWord("bar"));

        assertEquals(4, wordService.countWord("abc"));
        assertEquals(1, wordService.countWord("foo"));
        assertEquals(3, wordService.countWord("bar"));
        assertEquals(1, wordService.countWord("foox"));
        assertEquals(0, wordService.countWord("123abc"));
    }
}