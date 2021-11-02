package com.example.wordcounter.service;

import com.example.wordcounter.exception.WordCounterException;
import com.example.wordcounter.validation.ValidatorTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Service
public class WordServiceImpl implements WordService {

    private final Map<String, Integer> wordCounter = new HashMap<>();

    @Autowired
    @Qualifier("alphabeticValidator")
    ValidatorTemplate validatorTemplate;

    @Override
    public boolean addWord(String word) {
        boolean matches = validatorTemplate.validate(word);
        if (!matches) {
            System.out.println("Invalid word! " + word);
            return false;
        }
        String wordToAdd = word.toLowerCase(Locale.ROOT);
        synchronized (this) {
            if (null != wordCounter.get(wordToAdd)) {
                wordCounter.put(wordToAdd, wordCounter.get(wordToAdd) + 1);
            } else {
                wordCounter.put(wordToAdd, 1);
            }
        }
        return true;
    }

    @Override
    public synchronized int countWord(String word) throws WordCounterException {
        int count;
        if (null != wordCounter.get(word.toLowerCase(Locale.ROOT))) {
            count = wordCounter.get(word.toLowerCase(Locale.ROOT));
        } else
            throw new WordCounterException("Word not found");
        return count;
    }

    public synchronized void print() {
        wordCounter.forEach((key, value) -> System.out.println("Key=" + key + " Value=" + value));
    }
}
