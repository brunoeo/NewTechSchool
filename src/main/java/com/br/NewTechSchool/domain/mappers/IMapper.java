package com.br.NewTechSchool.domain.mappers;

import com.br.NewTechSchool.data.entities.AbstractEntity;
import com.br.NewTechSchool.presentation.dto.IDTO;

public interface IMapper<E extends AbstractEntity, I extends IDTO> {

    E toObject(I idto);

    I toDTO(E entity);

    void putData(E entity, I idto);

}
