package com.example.wordcounter.service;

import com.example.wordcounter.exception.WordCounterException;
import com.example.wordcounter.validation.ValidatorTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class WordServiceImpl implements WordService {

    //Thread Confinement
    private static ThreadLocal<Map<String, Integer>> mapHolder = new ThreadLocal<Map<String, Integer>>() {
        public Map<String, Integer> createLocalInstance() {
            return new ConcurrentHashMap<>();
        }
    };

    public static Map<String, Integer> getLocalMap() {
        return mapHolder.get();
    }

    //Instance Confinement
    private final Map<String, Integer> wordCounter = new ConcurrentHashMap<>();

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
            return true;
        }
    }

    @Override
    public int countWord(String word) throws WordCounterException {
        boolean matches = validatorTemplate.validate(word);
        if (!matches) {
            throw new WordCounterException("Invalid word! " + word);
        }
        synchronized (this) {
            int count;
            if (null != wordCounter.get(word.toLowerCase(Locale.ROOT))) {
                count = wordCounter.get(word.toLowerCase(Locale.ROOT));
            } else
                throw new WordCounterException("Word not found");
            return count;
        }
    }

    public void print() {
        synchronized (this) {
            wordCounter.forEach((key, value) -> System.out.println("Key=" + key + " Value=" + value));
        }
    }
}
