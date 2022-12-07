package com.br.NewTechSchool.presentation.controllers;

import com.br.NewTechSchool.domain.services.ProfessorService;
import com.br.NewTechSchool.presentation.dto.ProfessorDTO;
import com.br.NewTechSchool.presentation.util.AppResponse;
import com.br.NewTechSchool.presentation.util.AppResponseData;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("professor")
@SuppressWarnings("unused")
public class ProfessorController extends AbstractCrudController<ProfessorDTO> {

    public ProfessorController(ProfessorService service) {
        super(service);
    }

    @Override
    public AppResponse<AppResponseData> delete(@PathVariable("id") long id) {
        try {
            service.delete(id);
            return AppResponse.success("Deletion performed!", HttpStatus.OK);
        } catch (Exception error) {
            if (error.getMessage().contains("Professor vinculado"))
                return AppResponse.error(error.getMessage(), HttpStatus.BAD_REQUEST);
            return AppResponse.error(error.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
