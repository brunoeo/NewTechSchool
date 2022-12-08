package com.br.NewTechSchool.presentation.util;

import com.br.NewTechSchool.presentation.dto.IDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class AppResponse<T extends DataResponse> extends ResponseEntity<T> {

    public AppResponse(T body, HttpStatus status) {
        super(body, status);
    }

    public static AppResponse<DataResponse> success(String message, HttpStatus status) {
        return new AppResponse<>(new DataResponse(message), status);
    }

    public static AppResponse<DataResponse> success(IDTO body, String message) {
        return AppResponse.success(body, message, HttpStatus.OK);
    }

    public static AppResponse<DataResponse> success(List<? extends IDTO> body, String message, HttpStatus status) {
        return new AppResponse<>(new DataResponse(message, body), status);
    }

    public static AppResponse<DataResponse> success(IDTO body, String message, HttpStatus status) {
        return new AppResponse<>(new DataResponse(message, body), status);
    }

    public static AppResponse<DataResponse> error(String message, HttpStatus status) {
        return new AppResponse<>(new DataResponse(message), status);
    }

}
