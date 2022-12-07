package com.br.NewTechSchool.presentation.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CourseDTO implements IDTO{
    private Long id;
    @NotBlank(message = "{name.not.blank}")
    private String name;
    @NotNull
    private int duration;
    @NotBlank
    private String modality;
    @NotNull
    private Double monthlyFee;
    private Long professorId;
}
