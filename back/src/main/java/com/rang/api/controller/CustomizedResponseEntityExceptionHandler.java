package com.rang.api.controller;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rang.api.exceptions.ExceptionResponse;
import com.rang.api.exceptions.others.NotFoundException;
import com.rang.api.exceptions.others.UnsupportedException;


@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler
{
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", status.value());

        List<String> errors = ex.getBindingResult()
                                .getFieldErrors()
                                .stream()
                                .map(error -> error.getDefaultMessage())
                                .collect(Collectors.toList());

        body.put("errors", errors);

        return new ResponseEntity<>(body, headers, status);
    }
    
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions( Exception ex, WebRequest request) 
    {
       ExceptionResponse exceptionResponse= new ExceptionResponse( 
            null,
            ex.getMessage(),
            request.getDescription(false));

        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnsupportedException.class)
    public final ResponseEntity<ExceptionResponse> handleBadRequestExceptions( Exception ex, WebRequest request)
    {
        ExceptionResponse exceptionResponse= new ExceptionResponse( 
            null,
            ex.getMessage(),
            request.getDescription(false));

        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundExceptions(Exception ex, WebRequest request) 
    {
        ExceptionResponse exceptionResponse= new ExceptionResponse(
            null,
            ex.getMessage(),
            request.getDescription(false)
        );
            
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

}
    