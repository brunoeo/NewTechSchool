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
public class AppResponseData {

    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("data")
    private Object data;

    public AppResponseData(String message, IDTO data) {
        this.message = message;
        this.data = data;
    }

    public AppResponseData(String message, List<? extends IDTO> data) {
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

}
