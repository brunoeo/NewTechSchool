package com.br.NewTechSchool.presentation.controllers;

import com.br.NewTechSchool.domain.services.ICrudService;
import com.br.NewTechSchool.presentation.dto.IDTO;
import com.br.NewTechSchool.presentation.util.AppResponse;
import com.br.NewTechSchool.presentation.util.DataResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.MappedSuperclass;
import javax.validation.Valid;

@MappedSuperclass
@AllArgsConstructor
@SuppressWarnings("unused")
public abstract class AbstractCrudController<I extends IDTO> {

    protected final ICrudService service;

    @PostMapping
    public AppResponse<DataResponse> save(@Valid @RequestBody I idto) throws Exception {
        return AppResponse.success(service.save(idto), "Saved successfully");
    }

    @GetMapping
    public AppResponse<DataResponse> findAll(Pageable pageable) {
        return AppResponse.success(service.findAll(pageable), "Search done", HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public AppResponse<DataResponse> findByName(@PathVariable("name") String name, Pageable pageable) {
        return AppResponse.success(service.findByName(name, pageable), "Search done", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public AppResponse<DataResponse> findOne(@PathVariable("id") long id) throws Exception {
        return AppResponse.success(service.findOne(id), "Search done", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public AppResponse<DataResponse> update(
            @PathVariable("id") long id,
            @Valid @RequestBody I idto)
            throws Exception {
        return AppResponse.success(service.update(id, idto),
                "Update successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public AppResponse<DataResponse> delete(@PathVariable("id") long id) throws Exception {
        service.delete(id);
        return AppResponse.success("Deletion performed!", HttpStatus.OK);
    }
}