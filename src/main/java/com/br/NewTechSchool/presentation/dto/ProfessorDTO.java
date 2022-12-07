package com.br.NewTechSchool.presentation.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ProfessorDTO extends AbstractPersonDTO {
    @NotBlank(message = "{specialization.not.blank}")
    private String specialization;
}
