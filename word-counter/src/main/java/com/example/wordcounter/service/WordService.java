package com.example.wordcounter.service;

import com.example.wordcounter.exception.WordCounterException;
import org.springframework.stereotype.Service;

@Service
public interface WordService {
    boolean addWord(String word);

    int countWord(String word) throws WordCounterException;
}
