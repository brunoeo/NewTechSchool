package com.br.NewTechSchool.NewTechSchool.domain.services;

import com.br.NewTechSchool.NewTechSchool.data.entities.Professor;
import com.br.NewTechSchool.NewTechSchool.data.repositories.ProfessorRepository;
import com.br.NewTechSchool.NewTechSchool.domain.mappers.ProfessorListMapper;
import com.br.NewTechSchool.NewTechSchool.domain.mappers.ProfessorMapper;
import com.br.NewTechSchool.NewTechSchool.presentation.dto.ProfessorDTO;
import com.br.NewTechSchool.NewTechSchool.presentation.dto.ProfessorListDTO;
import com.br.NewTechSchool.NewTechSchool.presentation.util.AppResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProfessorService {

    private final ProfessorMapper mapper;
    private final ProfessorRepository professorRepository;
    private final ProfessorListMapper professorListMapper;


    @Transactional
    public ProfessorListDTO save(ProfessorDTO professorDTO){
        Professor professor = mapper.toObject(professorDTO);
        return professorListMapper.toDTO(professorRepository.save(professor));
    }

    public List<ProfessorListDTO> findAll(Pageable pageable){
        List<ProfessorListDTO> dtos = new ArrayList<>();
        professorRepository.findAll(pageable).forEach(
                professor -> dtos.add(professorListMapper.toDTO(professor))
        );
        return dtos;
    }

    public ProfessorDTO findOne(long id) throws Exception {
        Optional<Professor> professor = professorRepository.findById(id);
        if(professor.isPresent()){
            return mapper.toDTO(professor.get());
        }
        throw new Exception("Usuario não encontrado!");
    }

    public void delete(long id) throws Exception {
        Optional<Professor> professor = professorRepository.findById(id);
        if(professor.isPresent()){
            professorRepository.delete(professor.get());
        }else{
            throw new Exception("Usuario não encontrado!");
        }
    }

    public ProfessorDTO update(long id, ProfessorDTO professorDTO) throws Exception {
        Optional<Professor> professor = professorRepository.findById(id);
        if(professor.isPresent()){
            mapper.putData(professor.get(), professorDTO);
            return mapper.toDTO(professorRepository.save(professor.get()));
        }else{
            throw new Exception("Usuario não encontrado!");
        }
    }
}
