package com.br.NewTechSchool.presentation.controllers;

import com.br.NewTechSchool.domain.services.ProfessorService;
import com.br.NewTechSchool.presentation.dto.ProfessorDTO;
import com.br.NewTechSchool.presentation.util.AppResponse;
import com.br.NewTechSchool.presentation.util.AppResponseData;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("professor")
@AllArgsConstructor
public class ProfessorController {

    private final ProfessorService service;


    @PostMapping
    @SuppressWarnings("unused")
    public AppResponse<AppResponseData> save(@Valid @RequestBody ProfessorDTO professorDTO) {
        try {
            return AppResponse.success(service.save(professorDTO), "Cadastro efetuado!", HttpStatus.OK);
        } catch (Exception error) {
            error.printStackTrace();
            return AppResponse.error(error.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping
    @SuppressWarnings("unused")
    public AppResponse<AppResponseData> findAll(Pageable pageable) {
        try {
            return AppResponse.success(service.findAll(pageable), "Busca realizada!", HttpStatus.OK);
        } catch (Exception error) {
            error.printStackTrace();
            return AppResponse.error(error.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/{id}")
    @SuppressWarnings("unused")
    public AppResponse<AppResponseData> findOne(@PathVariable("id") long id){
        try{
            return AppResponse.success(service.findOne(id), "Busca realizada", HttpStatus.OK);
        }catch (Exception error) {
            return AppResponse.error(error.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    @SuppressWarnings("unused")
    public AppResponse<AppResponseData> update(@PathVariable("id") long id, @Valid @RequestBody ProfessorDTO professorDTO){
        try{
            return AppResponse.success(service.update(id, professorDTO), "Registro atualizado", HttpStatus.OK);
        }catch (Exception error) {
            return AppResponse.error(error.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @SuppressWarnings("unused")
    public AppResponse<AppResponseData> delete(@PathVariable("id") long id){
        try{
            service.delete(id);
            return AppResponse.success("Deleção realizada!", HttpStatus.OK);
        }catch (Exception error) {
            return AppResponse.error(error.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
