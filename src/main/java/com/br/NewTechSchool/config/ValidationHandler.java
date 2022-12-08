package com.br.NewTechSchool.config;

import com.br.NewTechSchool.presentation.util.AppResponse;
import com.br.NewTechSchool.presentation.util.DataResponse;
import com.br.NewTechSchool.presentation.util.ExceptionResponse;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@SuppressWarnings("unused")
public class ValidationHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request
    ) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });
        return new ResponseEntity<>(new DataResponse(errors, "Requisição possui campos inválidos"), status);
    }

    @ExceptionHandler({ExceptionResponse.class})
    public AppResponse<DataResponse> handleException(ExceptionResponse ex) {
        return AppResponse.error(ex.getMessage(), ex.getStatus());
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public AppResponse<DataResponse> handleConstraintException(ConstraintViolationException ex) {
        return AppResponse.error(ex.getSQLException().getMessage().split("Detalhe: ")[1], HttpStatus.BAD_REQUEST);
    }

}