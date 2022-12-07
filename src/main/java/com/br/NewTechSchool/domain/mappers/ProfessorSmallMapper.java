package com.br.NewTechSchool.domain.mappers;

import com.br.NewTechSchool.data.entities.Professor;
import com.br.NewTechSchool.presentation.dto.ProfessorSmallPersonDTO;

public class ProfessorSmallMapper implements IMapper<Professor, ProfessorSmallPersonDTO> {

    public Professor toObject(ProfessorSmallPersonDTO professorListDTO) {
        return new Professor();
    }

    public ProfessorSmallPersonDTO toDTO(Professor professor) {
        ProfessorSmallPersonDTO smallPersonDTO = new ProfessorSmallPersonDTO();
        smallPersonDTO.setSpecialization(professor.getSpecialization());
        smallPersonDTO.setId(professor.getId());
        smallPersonDTO.setCpf(String.valueOf(professor.getCpf()));
        smallPersonDTO.setName(professor.getName());
        return smallPersonDTO;
    }

    @Override
    public void putData(Professor entity, ProfessorSmallPersonDTO idto) {
    }
}
