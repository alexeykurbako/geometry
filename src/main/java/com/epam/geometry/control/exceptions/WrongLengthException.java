package com.epam.geometry.control.exceptions;

public class WrongLengthException extends Exception {
    public WrongLengthException(String message) {
        super(message);
    }

    public WrongLengthException(String message, Exception except) {
        super(message, except);
    }
}
