package com.br.NewTechSchool.presentation.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionResponse extends Exception {

    private String message;
    private HttpStatus status;

}
