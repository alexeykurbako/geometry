package com.epam.geometry.control.exceptions;

public class StringNotFoundException extends RuntimeException {
    public StringNotFoundException(String message) {
        super(message);
    }

    public StringNotFoundException(String message, Exception except) {
        super(message, except);
    }
}
