package com.br.NewTechSchool.presentation.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class StudentDTO extends AbstractPersonDTO {
  @NotNull(message = "{course_id.not.blank}")
  private Long course_id;
}
