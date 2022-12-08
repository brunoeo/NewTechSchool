package com.br.NewTechSchool.presentation.controllers;

import com.br.NewTechSchool.domain.services.JWTService;
import com.br.NewTechSchool.domain.services.UserDetailsService;
import com.br.NewTechSchool.presentation.dto.LoginDTO;
import com.br.NewTechSchool.presentation.dto.TokenDTO;
import com.br.NewTechSchool.presentation.util.AppResponse;
import com.br.NewTechSchool.presentation.util.DataResponse;
import com.br.NewTechSchool.presentation.util.ExceptionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
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
    @SuppressWarnings("unused")
    public AppResponse<DataResponse> login(@Valid @RequestBody LoginDTO loginDTO) throws ExceptionResponse {
        userDetailsService.verifyUserCredentials(loginDTO);
        String token = jwtService.generateToken(loginDTO.getUserName());
        return AppResponse.success(new TokenDTO(token, expiration), "Login efetuado com sucesso!");
    }
}
