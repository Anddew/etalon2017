package com.netcracker.project.exception;

public class RegistrationException extends Exception {

    private static final long serialVersionUID = -1300025401732657716L;


    public RegistrationException() {
        super();
    }

    public RegistrationException(String message) {
        super(message);
    }

    public RegistrationException(String message, Throwable cause) {
        super(message, cause);
    }

    public RegistrationException(Throwable cause) {
        super(cause);
    }

}
