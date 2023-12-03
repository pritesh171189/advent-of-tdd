package org.advent.exception;

public class InvalidFileNameException extends RuntimeException {
    public InvalidFileNameException(String errorMessage) {
        super(errorMessage);
    }
}