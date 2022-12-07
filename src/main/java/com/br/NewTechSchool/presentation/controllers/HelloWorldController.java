package com.br.NewTechSchool.presentation.controllers;

import com.br.NewTechSchool.presentation.util.AppResponse;
import com.br.NewTechSchool.presentation.util.AppResponseData;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hello")
@SuppressWarnings("unused")
public class HelloWorldController {

    @GetMapping
    public AppResponse<AppResponseData> hello() {

        return AppResponse.success("Hello World", HttpStatus.OK);
    }
}
