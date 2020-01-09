package com.epam.geometry.logic.exceptions;

public class CubeNotFoundException extends RuntimeException {
    public CubeNotFoundException(String message) {
        super(message);
    }

    public CubeNotFoundException(String message, Exception except) {
        super(message, except);
    }
}
