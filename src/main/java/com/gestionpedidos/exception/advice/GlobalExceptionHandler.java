package com.gestionpedidos.exception.advice;

import com.gestionpedidos.dtos.response.ErrorResponse;
import com.gestionpedidos.exception.BusinessException;
import com.gestionpedidos.exception.InternalServerErrorException;
import com.gestionpedidos.exception.ResourceNotFoundException;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Manejo de excepciones para BusinessException personalizada
    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<ErrorResponse> businessExceptionHandler(BusinessException ex) {
        ErrorResponse error = ErrorResponse.builder()
                .date(LocalDateTime.now())
                .code(ex.getCode())
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(error, ex.getStatus());
    }

    // Manejo de excepciones para ResourceNotFoundException
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponse error = ErrorResponse.builder()
                .date(LocalDateTime.now())
                .code("P-404")
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(error, status);
    }


    // Manejo de excepciones para NotImplementedException
    @ExceptionHandler(NotImplementedException.class)
    public ResponseEntity<ErrorResponse> handleNotImplementedException(NotImplementedException ex) {
        HttpStatus status = HttpStatus.NOT_IMPLEMENTED;
        ErrorResponse error = ErrorResponse.builder()
                .date(LocalDateTime.now())
                .code("P-501")
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(error, status);
    }

    // Manejo de excepciones para MethodArgumentNotValidException (validación de argumentos)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorResponse error = ErrorResponse.builder()
                .date(LocalDateTime.now())
                .code("P-400")
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(error, status);
    }

    // Manejo de excepciones para HttpMediaTypeNotSupportedException
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<ErrorResponse> handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException ex) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorResponse error = ErrorResponse.builder()
                .date(LocalDateTime.now())
                .code("P-400")
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(error, status);
    }


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException ex) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorResponse error = ErrorResponse.builder()
                .date(LocalDateTime.now())
                .code("P-500")
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(error, status);
    }

    // Manejo de excepciones para InternalServerErrorException personalizada
    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<ErrorResponse> handleInternalServerErrorException(InternalServerErrorException ex) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorResponse error = ErrorResponse.builder()
                .date(LocalDateTime.now())
                .code("P-500")
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(error, status);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponse> handleNullPointerException(NullPointerException ex) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorResponse error = ErrorResponse.builder()
                .date(LocalDateTime.now())
                .code("P-500")
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(error, status);
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateKeyException(DuplicateKeyException ex) {
        HttpStatus status = HttpStatus.CONFLICT;
        ErrorResponse error = ErrorResponse.builder()
                .date(LocalDateTime.now())
                .code("P-409")
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(error, status);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ErrorResponse> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
        HttpStatus status = HttpStatus.METHOD_NOT_ALLOWED;
        ErrorResponse error = ErrorResponse.builder()
                .date(LocalDateTime.now())
                .code("P-405")
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(error, status);
    }

}
