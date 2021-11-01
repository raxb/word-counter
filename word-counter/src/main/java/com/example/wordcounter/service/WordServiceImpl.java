package com.example.wordcounter.service;

import com.example.wordcounter.exception.WordCounterException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class WordServiceImpl implements WordService {

    Map<String, Integer> wordCounter = new HashMap<>();

    @Override
    public boolean addWord(String word) {
        Pattern pattern = Pattern.compile("^[a-zA-Z]*$");
        Matcher matcher = pattern.matcher(word);
        boolean matches = matcher.matches();
        if (!matches) {
            System.out.println("Invalid word! " + word);
            return false;
        }
        String wordToAdd = word.toLowerCase(Locale.ROOT);
        if (null != wordCounter.get(wordToAdd)) {
            wordCounter.put(wordToAdd, wordCounter.get(wordToAdd) + 1);
        } else {
            wordCounter.put(wordToAdd, 1);
        }
        return true;
    }

    @Override
    public int countWord(String word) throws WordCounterException {
        int count = 0;
        if (null != wordCounter.get(word.toLowerCase(Locale.ROOT))) {
            count = wordCounter.get(word.toLowerCase(Locale.ROOT));
        } else
            throw new WordCounterException("Word not found");
        return count;
    }

    public void print() {
        wordCounter.entrySet().forEach(e -> System.out.println("Key=" + e.getKey() + " Value=" + e.getValue()));
    }
}
