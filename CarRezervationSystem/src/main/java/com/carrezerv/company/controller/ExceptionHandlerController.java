package com.carrezerv.company.controller;

import com.carrezerv.company.controller.response.ErrorResponse;
import com.carrezerv.company.enums.ErrorCodeEnum;
import com.carrezerv.company.enums.RezervedCarsErrorCodeEnum;
import com.carrezerv.company.exception.CustomNotFoundException;
import com.carrezerv.company.exception.RezervedCarsException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(CustomNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleCustomNotFoundException(CustomNotFoundException e) {
        return ErrorResponse.builder()
                .code(e.getCode())
                .message(e.getMessage())
                .build();
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handlerInputParam(MethodArgumentTypeMismatchException t) {
        String paramName = t.getParameter().getParameterName();
        return ErrorResponse.builder()
                .code(ErrorCodeEnum.VALIDATION_ERROR.getCode())
                .message(paramName + ErrorCodeEnum.VALIDATION_ERROR.getMessage())
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleValidation(MethodArgumentNotValidException valid) {
        String fieldName = valid.getBindingResult().getFieldError().getField();
        return ErrorResponse.builder()
                .code(ErrorCodeEnum.VALIDATION_ERROR.getCode())
                .message(fieldName + ErrorCodeEnum.VALIDATION_ERROR)
                .build();
    }

    @ExceptionHandler(RezervedCarsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleUnknown(RezervedCarsException e) {
        return ErrorResponse.builder()
                .code(RezervedCarsErrorCodeEnum.ALREADY_EXIST.getCode())
                .message(RezervedCarsErrorCodeEnum.ALREADY_EXIST.getMessage())
                .build();
    }
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleUnknown(Exception e) {
        return ErrorResponse.builder()
                .code(ErrorCodeEnum.UNKNOWN_ERROR.getCode())
                .message(ErrorCodeEnum.UNKNOWN_ERROR.getMessage())
                .build();
    }

}
