package com.br.NewTechSchool.NewTechSchool.domain.mappers;

import com.br.NewTechSchool.NewTechSchool.data.entities.Address;
import com.br.NewTechSchool.NewTechSchool.data.entities.Credential;
import com.br.NewTechSchool.NewTechSchool.data.entities.Professor;
import com.br.NewTechSchool.NewTechSchool.presentation.dto.ProfessorDTO;

public class ProfessorMapper {

    public Professor toObject(ProfessorDTO professorDTO){
        Professor professor = new Professor();
        Credential credential = new Credential();
        Address address = new Address();

        professor.setSpecialization(professorDTO.getSpecialization());
        professor.setCpf(professorDTO.getCpf());
        professor.setName(professorDTO.getName());
        professor.setRg(professorDTO.getRg());
        professor.setDdd(professorDTO.getDdd());
        professor.setPhonenumber(professorDTO.getPhonenumber());

        address.setCep(professorDTO.getCep());
        address.setCity(professorDTO.getCity());
        address.setDistrict(professorDTO.getDistrict());
        address.setNumber(professorDTO.getNumber());
        address.setStreet(professorDTO.getStreet());

        credential.setUserName(professorDTO.getUserName());
        credential.setPassword(professorDTO.getPassword());

        professor.setCredential(credential);
        professor.setAddress(address);
        return professor;
    }

    public ProfessorDTO toDTO(Professor professor){
        ProfessorDTO professorDTO = new ProfessorDTO();
        professorDTO.setSpecialization(professor.getSpecialization());
        professorDTO.setId(professor.getId());
        professorDTO.setCpf(String.valueOf(professor.getCpf()));
        professorDTO.setName(professor.getName());
        professorDTO.setRg(String.valueOf(professor.getRg()));
        professorDTO.setDdd(professor.getDdd());
        professorDTO.setPhonenumber(String.valueOf(professor.getPhonenumber()));
        professorDTO.setCep(String.valueOf(professor.getAddress().getCep()));
        professorDTO.setNumber(professor.getAddress().getNumber());
        professorDTO.setCity(professor.getAddress().getCity());
        professorDTO.setDistrict(professor.getAddress().getDistrict());
        professorDTO.setStreet(professor.getAddress().getStreet());

        return professorDTO;
    }

    public void putData(Professor professor, ProfessorDTO professorDTO){
        professor.setSpecialization(professorDTO.getSpecialization());
        professor.setCpf(professorDTO.getCpf());
        professor.setName(professorDTO.getName());
        professor.setRg(professorDTO.getRg());
        professor.setDdd(professorDTO.getDdd());
        professor.setPhonenumber(professorDTO.getPhonenumber());

        professor.getAddress().setCep(professorDTO.getCep());
        professor.getAddress().setCity(professorDTO.getCity());
        professor.getAddress().setDistrict(professorDTO.getDistrict());
        professor.getAddress().setNumber(professorDTO.getNumber());
        professor.getAddress().setStreet(professorDTO.getStreet());

        professor.getCredential().setUserName(professorDTO.getUserName());
        professor.getCredential().setPassword(professorDTO.getPassword());

    }

}
