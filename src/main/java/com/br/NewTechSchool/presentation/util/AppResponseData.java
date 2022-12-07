package com.br.NewTechSchool.presentation.util;

import com.br.NewTechSchool.presentation.dto.IDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class AppResponseData {

    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("data")
    private Object data;

    public AppResponseData(String message, IDTO data){
        this.message = message;
        this.data = data;
    }

    public AppResponseData(String message, List<? extends IDTO> data){
        this.message = message;
        this.data = data;
    }
    public AppResponseData(Map<String, String> data, String message) {
        this.message = message;
        this.data = data;
    }

    public AppResponseData(String message) {
        this.message = message;
    }



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(IDTO data) {
        this.data = data;
    }
}
