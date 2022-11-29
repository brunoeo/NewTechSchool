package com.br.NewTechSchool.NewTechSchool.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TokenDTO implements IDTO{

    private String accessToken;
    private String expiration;

}
