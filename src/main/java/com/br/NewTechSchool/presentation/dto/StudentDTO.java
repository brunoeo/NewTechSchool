package com.br.NewTechSchool.presentation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO extends AbstractPersonDTO {
  private Long course_id;
}
