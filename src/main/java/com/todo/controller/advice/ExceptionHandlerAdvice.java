package com.todo.controller.advice;

import com.todo.dto.response.ExceptionResponse;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(value = {EntityExistsException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public ExceptionResponse entityExistsException(EntityExistsException exception) {
        return ExceptionResponse.builder()
                .code(HttpStatus.CONFLICT.value())
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler(value = {EntityNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse entityExistsException(EntityNotFoundException exception) {
        return ExceptionResponse.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler(value = {NoHandlerFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse entityExistsException(NoHandlerFoundException exception) {
        return ExceptionResponse.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse methodArgumentNotValidException(BindingResult bindingResult) {
        Map<String, String> errors = bindingResult.getFieldErrors().stream()
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage, (field1, field2) -> field1));

        return ExceptionResponse.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .message("Bad method arguments")
                .errors(errors)
                .build();
    }
}
