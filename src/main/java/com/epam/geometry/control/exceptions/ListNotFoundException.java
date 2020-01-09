package com.epam.geometry.control.exceptions;

public class ListNotFoundException extends RuntimeException {
    public ListNotFoundException(String message) {
        super(message);
    }

    public ListNotFoundException(String message, Exception except) {
        super(message, except);
    }
}
