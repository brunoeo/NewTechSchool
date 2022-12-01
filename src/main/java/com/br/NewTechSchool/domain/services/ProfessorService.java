package com.br.NewTechSchool.domain.services;

import com.br.NewTechSchool.data.entities.Professor;
import com.br.NewTechSchool.data.repositories.ProfessorRepository;
import com.br.NewTechSchool.domain.mappers.ProfessorSmallMapper;
import com.br.NewTechSchool.domain.mappers.ProfessorMapper;
import com.br.NewTechSchool.presentation.dto.ProfessorDTO;
import com.br.NewTechSchool.presentation.dto.ProfessorSmallPersonDTO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
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
    private final ProfessorSmallMapper professorSmallMapper;


    @Transactional
    public ProfessorSmallPersonDTO save(ProfessorDTO professorDTO){
        Professor professor = mapper.toObject(professorDTO);
        return professorSmallMapper.toDTO(professorRepository.save(professor));
    }

    public List<ProfessorSmallPersonDTO> findAll(Pageable pageable){
        List<ProfessorSmallPersonDTO> dtos = new ArrayList<>();
        professorRepository.findAll(pageable).forEach(
                professor -> dtos.add(professorSmallMapper.toDTO(professor))
        );
        return dtos;
    }

    public ProfessorDTO findOne(long id) throws Exception {
        Professor professor = this.findProfessor(id);
        return mapper.toDTO(professor);
    }

    public void delete(long id) throws Exception {
        Professor professor = this.findProfessor(id);
        professorRepository.delete(professor);
    }

    public ProfessorDTO update(long id, ProfessorDTO professorDTO) throws Exception {
        Professor professor = this.findProfessor(id);
        mapper.putData(professor, professorDTO);
        return mapper.toDTO(professorRepository.save(professor));
    }

    private Professor findProfessor(Long id)throws Exception{
        Optional<Professor> professor = professorRepository.findById(id);
        if(professor.isPresent()){
            return professor.get();
        }else{
            throw new Exception("Professor não encontrado!");
        }
    }

}
