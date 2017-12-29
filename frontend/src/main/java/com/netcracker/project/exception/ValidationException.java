package com.netcracker.project.exception;

public class ValidationException extends Exception {

    private static final long serialVersionUID = 6952447049331521383L;


    public ValidationException() {
        super();
    }

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidationException(Throwable cause) {
        super(cause);
    }

}
