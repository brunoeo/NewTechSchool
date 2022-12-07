package com.br.NewTechSchool.presentation.controllers;

import com.br.NewTechSchool.domain.services.CourseService;
import com.br.NewTechSchool.presentation.dto.CourseDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("course")
@SuppressWarnings("unused")
public class CourseController extends AbstractCrudController<CourseDTO> {

    public CourseController(CourseService service) {
        super(service);
    }

}
