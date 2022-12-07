package com.br.NewTechSchool.presentation.controllers;

import com.br.NewTechSchool.domain.services.ICrudService;
import com.br.NewTechSchool.presentation.dto.IDTO;
import com.br.NewTechSchool.presentation.util.AppResponse;
import com.br.NewTechSchool.presentation.util.AppResponseData;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.MappedSuperclass;
import javax.validation.Valid;

@MappedSuperclass
@SuppressWarnings("unused")
public abstract class AbstractCrudController<I extends IDTO> {

    protected final ICrudService service;

    public AbstractCrudController(ICrudService service) {
        this.service = service;
    }

    @PostMapping
    public AppResponse<AppResponseData> save(@Valid @RequestBody I idto) {
        try {
            return AppResponse.success(service.save(idto), "Saved successfully");
        } catch (Exception error) {
            return AppResponse.error(error.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @GetMapping
    public AppResponse<AppResponseData> findAll(Pageable pageable) {
        try {
            return AppResponse.success(service.findAll(pageable), "Search done", HttpStatus.OK);
        } catch (Exception error) {
            return AppResponse.error(error.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/name/{name}")
    public AppResponse<AppResponseData> findByName(@PathVariable("name") String name, Pageable pageable) {
        try {
            return AppResponse.success(service.findByName(name, pageable), "Search done", HttpStatus.OK);
        } catch (Exception error) {
            return AppResponse.error(error.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public AppResponse<AppResponseData> findOne(@PathVariable("id") long id) {
        try {
            return AppResponse.success(service.findOne(id), "Search done", HttpStatus.OK);
        } catch (Exception error) {
            return AppResponse.error(error.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public AppResponse<AppResponseData> update(@PathVariable("id") long id, @Valid @RequestBody I idto) {
        try {
            return AppResponse.success(service.update(id, idto),
                    "Update successfully", HttpStatus.OK);
        } catch (Exception error) {
            return AppResponse.error(error.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public AppResponse<AppResponseData> delete(@PathVariable("id") long id) {
        try {
            service.delete(id);
            return AppResponse.success("Deletion performed!", HttpStatus.OK);
        } catch (Exception error) {
            return AppResponse.error(error.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}