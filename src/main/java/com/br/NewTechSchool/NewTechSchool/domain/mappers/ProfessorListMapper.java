package com.br.NewTechSchool.NewTechSchool.domain.mappers;

import com.br.NewTechSchool.NewTechSchool.data.entities.Address;
import com.br.NewTechSchool.NewTechSchool.data.entities.Credential;
import com.br.NewTechSchool.NewTechSchool.data.entities.Professor;
import com.br.NewTechSchool.NewTechSchool.presentation.dto.IDTO;
import com.br.NewTechSchool.NewTechSchool.presentation.dto.ProfessorDTO;
import com.br.NewTechSchool.NewTechSchool.presentation.dto.ProfessorListDTO;

public class ProfessorListMapper implements IDTO {

    public Professor toObject(ProfessorListDTO professorListDTO){
        return new Professor();
    }

    public ProfessorListDTO toDTO(Professor professor){
        ProfessorListDTO professorListDTO = new ProfessorListDTO();
        professorListDTO.setSpecialization(professor.getSpecialization());
        professorListDTO.setId(professor.getId());
        professorListDTO.setCpf(String.valueOf(professor.getCpf()));
        professorListDTO.setName(professor.getName());
        return professorListDTO;
    }

    public void putData(ProfessorListDTO toDTO, ProfessorDTO professorDTO){
    }

}
