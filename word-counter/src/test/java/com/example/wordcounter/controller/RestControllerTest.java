package com.example.wordcounter.controller;

import com.example.wordcounter.service.WordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class RestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WordService wordService;

    @Test
    public void addWordTest() throws Exception {
        when(wordService.addWord("Hello")).thenReturn(Boolean.TRUE);
        this.mockMvc.perform(post("/v1/addWord/Hello")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Status for word addition true")));
    }

    @Test
    public void countWordTest() throws Exception {
        String word = "Hello";
        int count = 0;
        when(wordService.countWord(word)).thenReturn(count);
        this.mockMvc.perform(get("/v1/countWord/" + word)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Word occurrence for " + word + " = " + count)));
    }

}