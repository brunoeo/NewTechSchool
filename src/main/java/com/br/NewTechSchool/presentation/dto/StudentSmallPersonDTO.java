package com.br.NewTechSchool.presentation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentSmallPersonDTO extends SmallPersonDTO {

    private Long course_id;
    private String course_name;
}
