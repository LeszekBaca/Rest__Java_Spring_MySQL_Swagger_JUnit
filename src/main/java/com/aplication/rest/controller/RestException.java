package com.aplication.rest.controller;


import com.aplication.rest.Exception.BookException;
import com.aplication.rest.Exception.ErrorResp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestException {

    @ExceptionHandler(BookException.class)
    public ResponseEntity<ErrorResp> exceptionToDoHandler(Exception ex) {
        ErrorResp error = new ErrorResp();
        error.setErrorCode(HttpStatus.NOT_FOUND.value());
        error.setMessage(ex.getMessage());
        return new ResponseEntity<ErrorResp>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResp> exceptionHandler(Exception ex) {
        ErrorResp error = new ErrorResp();
        error.setErrorCode(HttpStatus.BAD_REQUEST.value());
        error.setMessage("The request could not be understood by the server due to malformed syntax");
        return new ResponseEntity<ErrorResp>(error, HttpStatus.BAD_REQUEST);
    }
}
