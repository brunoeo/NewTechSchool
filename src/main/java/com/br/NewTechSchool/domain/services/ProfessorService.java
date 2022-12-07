package com.br.NewTechSchool.domain.services;

import com.br.NewTechSchool.data.entities.Professor;
import com.br.NewTechSchool.data.repositories.ProfessorRepository;
import com.br.NewTechSchool.domain.mappers.ProfessorMapper;
import com.br.NewTechSchool.domain.mappers.ProfessorSmallMapper;
import com.br.NewTechSchool.presentation.dto.IDTO;
import com.br.NewTechSchool.presentation.dto.ProfessorDTO;
import com.br.NewTechSchool.presentation.dto.ProfessorSmallPersonDTO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProfessorService implements ICrudService {

    private final ProfessorMapper mapper;
    private final ProfessorRepository professorRepository;
    private final ProfessorSmallMapper professorSmallMapper;

    @Transactional
    public IDTO save(IDTO idto) {
        Professor professor = mapper.toObject((ProfessorDTO) idto);
        return professorSmallMapper.toDTO(professorRepository.save(professor));
    }

    public List<ProfessorSmallPersonDTO> findAll(Pageable pageable) {
        List<ProfessorSmallPersonDTO> dtos = new ArrayList<>();
        professorRepository.findAll(pageable).forEach(
                professor -> dtos.add(professorSmallMapper.toDTO(professor))
        );
        return dtos;
    }

    @Override
    public List<? extends IDTO> findByName(String name, Pageable pageable) {
        List<ProfessorSmallPersonDTO> dtos = new ArrayList<>();
        professorRepository.findAllByNameContainingIgnoreCase(name, pageable).forEach(
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
        if (professor.getCourse() != null)
            throw new Exception("Professor vinculado ao curso " + professor.getCourse().getName());
        professorRepository.delete(professor);
    }

    public IDTO update(long id, IDTO idto) throws Exception {
        Professor professor = this.findProfessor(id);
        mapper.putData(professor, (ProfessorDTO) idto);
        return mapper.toDTO(professorRepository.save(professor));
    }

    private Professor findProfessor(Long id) throws Exception {
        return this.professorRepository.findById(id).orElseThrow(()
                -> new Exception("Professor não encontrado!"));
    }
}
