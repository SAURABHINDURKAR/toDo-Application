package com.fable.todo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

 @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<ArrayList<String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
            ArrayList<String> errors = new ArrayList<>();

            // Extracting all field errors
            ex.getBindingResult().getAllErrors().forEach(error -> {
               // String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                errors.add(errorMessage);
            });

            return new ResponseEntity<>(errors, HttpStatus.BAD_GATEWAY);
        }
    }


