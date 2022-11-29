package com.br.NewTechSchool.NewTechSchool.presentation.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ProfessorListDTO extends AbstractListDTO{

    private String specialization;
}
