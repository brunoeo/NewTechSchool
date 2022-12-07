package com.br.NewTechSchool.domain.services;

import com.br.NewTechSchool.presentation.dto.IDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface ICrudService {

    public IDTO save(IDTO idto) throws Exception;

    public List<? extends IDTO> findAll(Pageable pageable);

    List<? extends IDTO> findByName(String name, Pageable pageable);

    public IDTO findOne(long id) throws Exception;

    public void delete(long id) throws Exception;

    public IDTO update(long id, IDTO idto) throws Exception;
}
