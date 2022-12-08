package com.br.NewTechSchool.presentation.controllers;

import com.br.NewTechSchool.domain.services.ProfessorService;
import com.br.NewTechSchool.presentation.dto.ProfessorDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("professor")
@SuppressWarnings("unused")
public class ProfessorController extends AbstractCrudController<ProfessorDTO> {

    public ProfessorController(ProfessorService service) {
        super(service);
    }

}
