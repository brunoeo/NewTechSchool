package com.br.NewTechSchool.presentation.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class LoginDTO implements IDTO {

    @Email
    private String userName;
    @NotBlank(message = "{password.not.blank}")
    private String password;

}
