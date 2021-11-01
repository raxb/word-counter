package com.example.wordcounter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.wordcounter.*")
public class WordCounterApplication {

    public static void main(String[] args) {
        SpringApplication.run(WordCounterApplication.class, args);
    }

}
