package com.example.swaggerstarter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseWrapper<Void> defaultErrorHandler(
            HttpServletRequest request,
            Exception e
    ) {
        return new ResponseWrapper<>(
                "error",
                e.toString(),
                null);
    }
}
