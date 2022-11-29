package com.br.NewTechSchool.NewTechSchool.presentation.controllers;

import com.br.NewTechSchool.NewTechSchool.presentation.dto.LoginDTO;
import com.br.NewTechSchool.NewTechSchool.presentation.dto.TokenDTO;
import com.br.NewTechSchool.NewTechSchool.presentation.util.AppResponse;
import com.br.NewTechSchool.NewTechSchool.presentation.util.AppResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("hello")
public class HelloWorldController {


    @GetMapping
    public AppResponse<AppResponseData> hello(){

        return AppResponse.success("Hello World", HttpStatus.OK);
    }
}
