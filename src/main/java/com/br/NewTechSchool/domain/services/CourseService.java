package com.br.NewTechSchool.domain.services;

import com.br.NewTechSchool.data.entities.Course;
import com.br.NewTechSchool.data.entities.Professor;
import com.br.NewTechSchool.data.repositories.CourseRepository;
import com.br.NewTechSchool.data.repositories.ProfessorRepository;
import com.br.NewTechSchool.domain.mappers.CourseMapper;
import com.br.NewTechSchool.presentation.dto.CourseDTO;
import com.br.NewTechSchool.presentation.dto.IDTO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CourseService implements ICrudService{

    private final CourseMapper mapper;
    private final CourseRepository repository;
    private final ProfessorRepository professorRepository;

    @Transactional
    public IDTO save(IDTO idto) throws Exception {
        Course course = mapper.toObject((CourseDTO) idto);
        course.setProfessor(this.professorValidator((CourseDTO) idto));
        return mapper.toDTO(repository.save(course));
    }

    public List<CourseDTO> findAll(Pageable pageable){
        List<CourseDTO> dtos = new ArrayList<>();
        repository.findAll(pageable).forEach(
                course -> dtos.add(mapper.toDTO(course))
        );
        return dtos;
    }

    @Override
    public List<? extends IDTO> findByName(String name, Pageable pageable) {
        List<CourseDTO> dtos = new ArrayList<>();
        repository.findAllByNameContainingIgnoreCase(name, pageable).forEach(
                course -> dtos.add(mapper.toDTO(course))
        );
        return dtos;
    }

    public CourseDTO findOne(long id) throws Exception {
        Course course = this.findCourse(id);
        return mapper.toDTO(course);
    }

    public void delete(long id) throws Exception {
        Course course = this.findCourse(id);
        repository.delete(course);
    }

    public IDTO update(long id, IDTO idto) throws Exception {
        Course course = this.findCourse(id);
        course.setProfessor(this.professorValidator((CourseDTO) idto));
        mapper.putData(course, (CourseDTO) idto);
        return mapper.toDTO(repository.save(course));
    }

    private Professor professorValidator(CourseDTO courseDTO)throws Exception{
        if (courseDTO.getProfessorId() == null) return null;

        Professor professor = professorRepository.findById(courseDTO.getProfessorId()).orElseThrow(
                () -> new Exception("Professor não encontrado!"));

        if (professor.getCourse() != null)
            throw new Exception("Professor já cadastrado ao curso " + professor.getCourse().getName() + "!");

        return professor;
    }

    private Course findCourse(Long id)throws Exception{
        return repository.findById(id).orElseThrow(
                () -> new Exception("Curso não encontrado!"));
    }

}
