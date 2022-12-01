package com.br.NewTechSchool.domain.services;

import com.br.NewTechSchool.data.entities.Course;
import com.br.NewTechSchool.data.entities.Professor;
import com.br.NewTechSchool.data.repositories.CourseRepository;
import com.br.NewTechSchool.data.repositories.ProfessorRepository;
import com.br.NewTechSchool.domain.mappers.CourseMapper;
import com.br.NewTechSchool.presentation.dto.CourseDTO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CourseService {

    private final CourseMapper mapper;
    private final CourseRepository repository;
    private final ProfessorRepository professorRepository;


    @Transactional
    public CourseDTO save(CourseDTO courseDTO) throws Exception {
        Course course = mapper.toObject(courseDTO);
        course.setProfessor(this.findProfessor(courseDTO.getProfessorId()));
        return mapper.toDTO(repository.save(course));
    }

    public List<CourseDTO> findAll(Pageable pageable){
        List<CourseDTO> dtos = new ArrayList<>();
        repository.findAll(pageable).forEach(
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

    public CourseDTO update(long id, CourseDTO courseDTO) throws Exception {
        Course course = this.findCourse(id);
        course.setProfessor(this.findProfessor(courseDTO.getProfessorId()));
        mapper.putData(course, courseDTO);
        return mapper.toDTO(repository.save(course));
    }

    private Professor findProfessor(Long id)throws Exception{
        Optional<Professor> professor = professorRepository.findById(id);
        if(professor.isPresent()){
            return professor.get();
        }else{
            throw new Exception("Professor não encontrado!");
        }
    }

    private Course findCourse(Long id)throws Exception{
        Optional<Course> course = repository.findById(id);
        if(course.isPresent()){
            return course.get();
        }else{
            throw new Exception("Curso não encontrado!");
        }
    }
}
