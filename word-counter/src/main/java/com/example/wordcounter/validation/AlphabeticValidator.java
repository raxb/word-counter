package com.example.wordcounter.validation;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class AlphabeticValidator extends ValidatorTemplate {
    @Override
    Pattern validatorPattern() {
        return Pattern.compile("^[a-zA-Z]*$");
    }
}
