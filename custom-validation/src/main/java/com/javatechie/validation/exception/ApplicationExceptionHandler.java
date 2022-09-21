package com.javatechie.validation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String , String> handleMethodArgumentException(MethodArgumentNotValidException argumentNotValidException){
        Map<String , String> errorMap = new HashMap<>();
        argumentNotValidException.getBindingResult().getFieldErrors().forEach(
                error -> errorMap.put(error.getField() , error.getDefaultMessage()));
        return errorMap;
    }
}
