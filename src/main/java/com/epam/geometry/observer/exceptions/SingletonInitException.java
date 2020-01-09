package com.epam.geometry.observer.exceptions;

public class SingletonInitException extends RuntimeException {
    public SingletonInitException() {
    }

    public SingletonInitException(String message) {
        super(message);
    }

    public SingletonInitException(String message, Throwable cause) {
        super(message, cause);
    }

    public SingletonInitException(Throwable cause) {
        super(cause);
    }
}