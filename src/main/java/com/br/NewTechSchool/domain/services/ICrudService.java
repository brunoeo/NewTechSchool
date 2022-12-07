package com.br.NewTechSchool.domain.services;

import com.br.NewTechSchool.presentation.dto.IDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICrudService {

    IDTO save(IDTO idto) throws Exception;

    List<? extends IDTO> findAll(Pageable pageable);

    List<? extends IDTO> findByName(String name, Pageable pageable);

    IDTO findOne(long id) throws Exception;

    void delete(long id) throws Exception;

    IDTO update(long id, IDTO idto) throws Exception;
}
