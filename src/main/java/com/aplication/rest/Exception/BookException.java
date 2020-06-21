package com.aplication.rest.Exception;

public class BookException extends Exception {

    private static final long serialVersionUID = 70702930378161014L;

    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;

    }

    public BookException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;

    }


    public BookException() {
        super();
    }

}
