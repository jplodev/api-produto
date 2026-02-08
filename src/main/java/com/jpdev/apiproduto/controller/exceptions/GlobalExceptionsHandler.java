package com.jpdev.apiproduto.controller.exceptions;

import com.jpdev.apiproduto.infrastructure.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionsHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> handleResourceNotFoundException(ResourceNotFoundException ex,
                                                                   HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(buildError(HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                request.getRequestURI(),
                "Not Found"));
    }

    public StandardError buildError(Integer status, String message, String path, String error){
        return StandardError.builder()
                .timestamp(LocalDateTime.now())
                .status(status)
                .message(message)
                .error(error)
                .path(path)
                .build();
    }
}
