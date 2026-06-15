package com.marciosalesdev.movieflix.exception;

public class UsernameOrPasswordInvalidException extends RuntimeException {

    public UsernameOrPasswordInvalidException(String message) {
        super(message);
    }
}
