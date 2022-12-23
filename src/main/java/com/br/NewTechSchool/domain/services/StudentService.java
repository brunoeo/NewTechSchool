package com.br.NewTechSchool.domain.services;

import com.br.NewTechSchool.data.entities.Course;
import com.br.NewTechSchool.data.entities.Student;
import com.br.NewTechSchool.data.repositories.CourseRepository;
import com.br.NewTechSchool.data.repositories.StudentRepository;
import com.br.NewTechSchool.domain.mappers.StudentMapper;
import com.br.NewTechSchool.domain.mappers.StudentSmallMapper;
import com.br.NewTechSchool.presentation.dto.IDTO;
import com.br.NewTechSchool.presentation.dto.StudentDTO;
import com.br.NewTechSchool.presentation.dto.StudentSmallPersonDTO;
import com.br.NewTechSchool.presentation.util.ExceptionResponse;
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
public class StudentService implements ICrudService {

    private final StudentMapper mapper;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final StudentSmallMapper studentSmallMapper;

    @Transactional
    public IDTO save(IDTO idto) throws ExceptionResponse {
        Student student = mapper.toObject((StudentDTO) idto);
        Optional<Course> course = courseRepository.findById(student.getCourse().getId());
        if (course.isEmpty()) {
            throw new ExceptionResponse("Course not found!", HttpStatus.NOT_FOUND);
        }
        student.setCourse(course.get());
        return mapper.toDTO(studentRepository.save(student));
    }

    public List<StudentSmallPersonDTO> findAll(Pageable pageable) {
        List<StudentSmallPersonDTO> dtos = new ArrayList<>();
        studentRepository.findAll(pageable).forEach(
                student -> dtos.add(studentSmallMapper.toDTO(student))
        );
        return dtos;
    }

    @Override
    public List<? extends IDTO> findByName(String name, Pageable pageable) {
        List<StudentDTO> dtos = new ArrayList<>();
        studentRepository.findAllByNameContainingIgnoreCase(name, pageable).forEach(
                student -> dtos.add(mapper.toDTO(student))
        );
        return dtos;
    }

    public StudentDTO findOne(long id) throws Exception {
        Student student = this.findStudent(id);
        return mapper.toDTO(student);
    }

    public void delete(long id) throws Exception {
        Student student = this.findStudent(id);
        Course course = student.getCourse();
        course.removeStudent(id);
        courseRepository.save(course);
        studentRepository.delete(student);
    }

    public IDTO update(long id, IDTO idto) throws Exception {
        Student student = this.findStudent(id);
        mapper.putData(student, (StudentDTO) idto);
        Optional<Course> course = courseRepository.findById(student.getCourse().getId());
        if (course.isEmpty()) {
            throw new ExceptionResponse("Course not found!", HttpStatus.NOT_FOUND);
        }
        student.setCourse(course.get());
        return mapper.toDTO(studentRepository.save(student));
    }

    private Student findStudent(Long id) throws Exception {
        return this.studentRepository.findById(id).orElseThrow(()
                -> new ExceptionResponse("Estudante não encontrado!", HttpStatus.NOT_FOUND));
    }
}
