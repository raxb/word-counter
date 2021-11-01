package com.example.wordcounter;

import com.example.wordcounter.controller.RestController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class WordCounterApplicationTests {

    @Autowired
    RestController restController;

    @Test
    void contextLoads() {
        assertThat(restController).isNotNull();
    }

}
