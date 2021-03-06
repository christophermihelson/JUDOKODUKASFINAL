package com.skzenpackage.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class Handler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<Object> handleApplicationException(ApplicationException e){
        System.out.println("Something's wrong.");
        return new ResponseEntity<>(new Response(e.getMessage()),
                new HttpHeaders(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleError(Exception e){
        e.printStackTrace();
        return new ResponseEntity<>(new Response("Server problem."),
                new HttpHeaders(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}