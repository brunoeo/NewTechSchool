package com.br.NewTechSchool.domain.mappers;

import com.br.NewTechSchool.data.entities.Professor;
import com.br.NewTechSchool.presentation.dto.IDTO;
import com.br.NewTechSchool.presentation.dto.ProfessorDTO;
import com.br.NewTechSchool.presentation.dto.ProfessorSmallPersonDTO;

public class ProfessorSmallMapper implements IDTO {

    public Professor toObject(ProfessorSmallPersonDTO professorListDTO){
        return new Professor();
    }

    public ProfessorSmallPersonDTO toDTO(Professor professor){
        ProfessorSmallPersonDTO smallPersonDTO = new ProfessorSmallPersonDTO();
        smallPersonDTO.setSpecialization(professor.getSpecialization());
        smallPersonDTO.setId(professor.getId());
        smallPersonDTO.setCpf(String.valueOf(professor.getCpf()));
        smallPersonDTO.setName(professor.getName());
        return smallPersonDTO;
    }

    public void putData(ProfessorSmallPersonDTO toDTO, ProfessorDTO professorDTO){
    }

}
