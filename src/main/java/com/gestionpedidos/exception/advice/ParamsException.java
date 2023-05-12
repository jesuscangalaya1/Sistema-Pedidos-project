package com.gestionpedidos.exception.advice;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.*;

@RestControllerAdvice
public class ParamsException extends ResponseEntityExceptionHandler {

    // Manejo de Excepciones del @RequestBody
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {
        Map<String, Object> responseBody = new LinkedHashMap<>();
        responseBody.put("timestamp", new Date());
        responseBody.put("status", status.value());

        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        List<String> listErrors = new ArrayList<>();
        for (FieldError fieldError : fieldErrors){
            String errorMessage = fieldError.getDefaultMessage();
            listErrors.add(errorMessage);
        }

        responseBody.put("errors", listErrors);
        return new ResponseEntity<>(responseBody,headers,status);
    }

    // Manejo de Excepciones del @PathVariable
    @ExceptionHandler({MethodArgumentTypeMismatchException.class, ConstraintViolationException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object handleRequestPathVariablesValidationException(Exception ex, HttpServletRequest request){
        Map<String, Object> responseBodyA = new LinkedHashMap<>();
        responseBodyA.put("timestamp", new Date());
        responseBodyA.put("status", HttpStatus.BAD_REQUEST.value());
        responseBodyA.put("error", ex.getMessage());
        responseBodyA.put("path", request.getServletPath());
        return responseBodyA;
    }
}
