package com.br.NewTechSchool.presentation.controllers;

import com.br.NewTechSchool.domain.services.StudentService;
import com.br.NewTechSchool.presentation.dto.StudentDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("student")
@SuppressWarnings("unused")
public class StudentController extends AbstractCrudController<StudentDTO> {

  public StudentController(StudentService service) {
    super(service);
  }

}
