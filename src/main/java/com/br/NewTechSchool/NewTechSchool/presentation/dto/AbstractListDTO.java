package com.br.NewTechSchool.NewTechSchool.presentation.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public abstract class AbstractListDTO implements IDTO{

    private Long id;
    @NotBlank(message = "{name.not.blank}")
    private String name;
    @CPF
    private String cpf;

}
