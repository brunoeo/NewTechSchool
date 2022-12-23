package com.br.NewTechSchool.presentation.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CourseDTO implements IDTO {
    private Long id;
    @NotBlank(message = "{name.not.blank}")
    private String name;
    @NotNull(message = "{duration.not.NotNull}")
    private int duration;
    @NotBlank(message = "{modality.not.blank}")
    private String modality;
    @NotNull(message = "{monthlyFee.not.NotNull}")
    private Double monthlyFee;
    private Long professorId;
  private String professorName;
}
