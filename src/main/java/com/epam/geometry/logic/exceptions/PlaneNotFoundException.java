package com.epam.geometry.logic.exceptions;

public class PlaneNotFoundException extends RuntimeException {
    public PlaneNotFoundException(String message) {
        super(message);
    }

    public PlaneNotFoundException(String message, Exception except) {
        super(message, except);
    }
}
