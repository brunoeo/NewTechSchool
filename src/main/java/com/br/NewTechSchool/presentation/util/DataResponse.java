package com.br.NewTechSchool.presentation.util;

import com.br.NewTechSchool.presentation.dto.IDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class DataResponse {

    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("data")
    private Object data;

    public DataResponse(String message, IDTO data) {
        this.message = message;
        this.data = data;
    }

    public DataResponse(String message, List<? extends IDTO> data) {
        this.message = message;
        this.data = data;
    }

    public DataResponse(Map<String, String> data, String message) {
        this.message = message;
        this.data = data;
    }

    public DataResponse(String message) {
        this.message = message;
    }

}
