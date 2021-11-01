package com.example.wordcounter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class WordCounterException extends RuntimeException {
    public WordCounterException(String message) {
        super(message);
    }

    public WordCounterException() {
        super();
    }

    public WordCounterException(String message, Throwable cause) {
        super(message, cause);
    }

    public WordCounterException(Throwable cause) {
        super(cause);
    }
}
