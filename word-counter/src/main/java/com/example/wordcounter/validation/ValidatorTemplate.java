package com.example.wordcounter.validation;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public abstract class ValidatorTemplate {

    public boolean validate(String input) {
        Pattern pattern = validatorPattern();
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    abstract Pattern validatorPattern();
}
