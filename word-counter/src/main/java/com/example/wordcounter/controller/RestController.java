package com.example.wordcounter.controller;

import com.example.wordcounter.exception.WordCounterException;
import com.example.wordcounter.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/v1")
@CrossOrigin
public class RestController {

    @Autowired
    WordService wordService;

    @GetMapping
    public String welcome() {
        return "Welcome to Word Counter Program";
    }

    @PostMapping("/addWord/{word}")
    public ResponseEntity addWord(@PathVariable String word) {
        return ResponseEntity.ok("Status for word addition " + wordService.addWord(word));
    }

    @GetMapping("/countWord/{word}")
    public ResponseEntity countWord(@PathVariable String word) throws WordCounterException {
        int count = wordService.countWord(word);
        return ResponseEntity.ok("Word occurrence for " + word + " = " + count);
    }
}
