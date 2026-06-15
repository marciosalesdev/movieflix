package com.marciosalesdev.movieflix.config;

import com.marciosalesdev.movieflix.exception.UsernameOrPasswordInvalidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(UsernameOrPasswordInvalidException.class)
    public String handlerFoundException(UsernameOrPasswordInvalidException exception){
        return exception.getMessage();
    }
}
