package com.br.NewTechSchool.config;

import com.br.NewTechSchool.presentation.util.AppResponse;
import com.br.NewTechSchool.presentation.util.DataResponse;
import com.br.NewTechSchool.presentation.util.ExceptionResponse;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@SuppressWarnings("unused")
public class ValidationHandler {

//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(
//            MethodArgumentNotValidException ex,
//            HttpHeaders headers,
//            HttpStatus status,
//            WebRequest request
//    ) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String message = error.getDefaultMessage();
//            errors.put(fieldName, message);
//        });
//        return new ResponseEntity<>(new DataResponse(errors, "Requisição possui campos inválidos"), status);
//    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public AppResponse<DataResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });
        return AppResponse.error(errors, "Request with invalid fields!", HttpStatus.BAD_REQUEST);
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