package com.br.NewTechSchool.domain.mappers;

import com.br.NewTechSchool.data.entities.Address;
import com.br.NewTechSchool.data.entities.Course;
import com.br.NewTechSchool.data.entities.Credential;
import com.br.NewTechSchool.data.entities.Student;
import com.br.NewTechSchool.presentation.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;


public class StudentMapper implements IMapper<Student, StudentDTO> {

    @Autowired
    @SuppressWarnings("unused")
    private PasswordEncoder passwordEncoder;

    public Student toObject(StudentDTO studentDTO) {
        Student student = new Student();
        Credential credential = new Credential();
        Address address = new Address();
        Course course = new Course();

        student.setCourse(course);
        student.getCourse().setId(studentDTO.getCourse_id());
        student.setCpf(studentDTO.getCpf());
        student.setName(studentDTO.getName());
        student.setRg(studentDTO.getRg());
        student.setDdd(studentDTO.getDdd());
        student.setPhonenumber(studentDTO.getPhonenumber());

        address.setCep(studentDTO.getCep());
        address.setCity(studentDTO.getCity());
        address.setDistrict(studentDTO.getDistrict());
        address.setNumber(studentDTO.getNumber());
        address.setStreet(studentDTO.getStreet());

        credential.setUserName(studentDTO.getUserName());
        credential.setPassword(passwordEncoder.encode(studentDTO.getPassword()));

        student.setCredential(credential);
        student.setAddress(address);
        return student;
    }

    public StudentDTO toDTO(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setCourse_id(student.getCourse().getId());
        studentDTO.setId(student.getId());
        studentDTO.setCpf(String.valueOf(student.getCpf()));
        studentDTO.setName(student.getName());
        studentDTO.setRg(String.valueOf(student.getRg()));
        studentDTO.setDdd(student.getDdd());
        studentDTO.setPhonenumber(String.valueOf(student.getPhonenumber()));
        studentDTO.setCep(String.valueOf(student.getAddress().getCep()));
        studentDTO.setNumber(student.getAddress().getNumber());
        studentDTO.setCity(student.getAddress().getCity());
        studentDTO.setDistrict(student.getAddress().getDistrict());
        studentDTO.setStreet(student.getAddress().getStreet());

        return studentDTO;
    }

    public void putData(Student student, StudentDTO studentDTO) {

        Course course = new Course();

        student.setCourse(course);
        student.getCourse().setId(studentDTO.getCourse_id());
        student.setCpf(studentDTO.getCpf());
        student.setName(studentDTO.getName());
        student.setRg(studentDTO.getRg());
        student.setDdd(studentDTO.getDdd());
        student.setPhonenumber(studentDTO.getPhonenumber());

        student.getAddress().setCep(studentDTO.getCep());
        student.getAddress().setCity(studentDTO.getCity());
        student.getAddress().setDistrict(studentDTO.getDistrict());
        student.getAddress().setNumber(studentDTO.getNumber());
        student.getAddress().setStreet(studentDTO.getStreet());

        student.getCredential().setUserName(studentDTO.getUserName());
        student.getCredential().setPassword(studentDTO.getPassword());

    }

}
