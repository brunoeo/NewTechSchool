package com.br.NewTechSchool.domain.mappers;

import com.br.NewTechSchool.data.entities.Professor;
import com.br.NewTechSchool.data.entities.Student;
import com.br.NewTechSchool.presentation.dto.ProfessorSmallPersonDTO;
import com.br.NewTechSchool.presentation.dto.StudentSmallPersonDTO;

public class StudentSmallMapper implements IMapper<Student, StudentSmallPersonDTO> {

    public Student toObject(StudentSmallPersonDTO studentSmallPersonDTO) {
        return new Student();
    }

    public StudentSmallPersonDTO toDTO(Student student) {
        StudentSmallPersonDTO studentSmallPersonDTO = new StudentSmallPersonDTO();
        studentSmallPersonDTO.setCourse_id(student.getCourse().getId());
        studentSmallPersonDTO.setCourse_name(student.getCourse().getName());
        studentSmallPersonDTO.setId(student.getId());
        studentSmallPersonDTO.setCpf(String.valueOf(student.getCpf()));
        studentSmallPersonDTO.setName(student.getName());
        return studentSmallPersonDTO;
    }

    @Override
    public void putData(Student entity, StudentSmallPersonDTO idto) {
    }
}
