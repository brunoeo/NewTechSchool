package com.br.NewTechSchool.presentation.controllers;

import com.br.NewTechSchool.domain.services.CourseService;
import com.br.NewTechSchool.presentation.dto.CourseDTO;
import com.br.NewTechSchool.presentation.util.AppResponse;
import com.br.NewTechSchool.presentation.util.AppResponseData;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("course")
@AllArgsConstructor
public class CourseController {

    private final CourseService service;


    @PostMapping
    @SuppressWarnings("unused")
    public AppResponse<AppResponseData> save(@Valid @RequestBody CourseDTO courseDTO) {
        try {
            return AppResponse.success(service.save(courseDTO), "Cadastro efetuado!", HttpStatus.OK);
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
    public AppResponse<AppResponseData> update(@PathVariable("id") long id, @Valid @RequestBody CourseDTO courseDTO){
        try{
            return AppResponse.success(service.update(id, courseDTO), "Registro atualizado", HttpStatus.OK);
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
