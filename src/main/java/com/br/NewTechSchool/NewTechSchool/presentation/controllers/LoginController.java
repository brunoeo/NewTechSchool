package com.br.NewTechSchool.NewTechSchool.presentation.controllers;

import com.br.NewTechSchool.NewTechSchool.domain.services.JWTService;
import com.br.NewTechSchool.NewTechSchool.domain.services.UserDetailsService;
import com.br.NewTechSchool.NewTechSchool.presentation.dto.LoginDTO;
import com.br.NewTechSchool.NewTechSchool.presentation.dto.TokenDTO;
import com.br.NewTechSchool.NewTechSchool.presentation.util.AppResponse;
import com.br.NewTechSchool.NewTechSchool.presentation.util.AppResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("login")
@RequiredArgsConstructor
public class LoginController {

    private final UserDetailsService userDetailsService;
    private final JWTService jwtService;

    @Value("${security.jwt.expiration}")
    private String expiration;

    @PostMapping
    public AppResponse<AppResponseData> login(@Valid @RequestBody LoginDTO loginDTO){
        try{
            userDetailsService.verifyUserCredentials(loginDTO);
            String token = jwtService.generateToken(loginDTO.getUsername());
            return AppResponse.success(new TokenDTO(token, expiration), "Login efetuado com sucesso!");
        }catch (Exception error){
            return AppResponse.error(error.getMessage(), HttpStatus.OK);
        }

    }
}
