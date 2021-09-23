package com.inflearn.lecture.exception;

//HTTP STATUS CODE
//2xx -> OK
//4xx -> Client error
//5xx -> Server error

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
