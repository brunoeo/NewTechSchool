package com.br.NewTechSchool.presentation.util;

import com.br.NewTechSchool.presentation.dto.IDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class AppResponse<T extends AppResponseData> extends ResponseEntity<T> {

    public AppResponse(T body, HttpStatus status) {
        super(body, status);
    }
    public static AppResponse<AppResponseData> success(String message, HttpStatus status){
        return new AppResponse<>(new AppResponseData(message), status);
    }
    public static AppResponse<AppResponseData> success(IDTO body, String message){
        return AppResponse.success(body, message, HttpStatus.OK);
    }

    public static AppResponse<AppResponseData> success(List<? extends IDTO> body, String message, HttpStatus status){
        return new AppResponse<>(new AppResponseData(message, body), status);
    }

    public static AppResponse<AppResponseData> success(IDTO body, String message, HttpStatus status){
        return new AppResponse<>(new AppResponseData(message, body), status);
    }

    public static AppResponse<AppResponseData> error(String message, HttpStatus status){
        return new AppResponse<>(new AppResponseData(message), status);
    }

}
