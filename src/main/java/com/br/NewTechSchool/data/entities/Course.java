package com.br.NewTechSchool.data.entities;

import com.br.NewTechSchool.presentation.util.ExceptionResponse;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "courses")
public class Course extends AbstractEntity {

    @Column(unique = true)
    private String name;
    @Column
    private int duration;
    @Column
    private String modality;
    @Column
    private Double monthlyFee;
    @OneToOne
    @JoinColumn(name = "professor_id", referencedColumnName = "id")
    private Professor professor;
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Student> students = new HashSet<>();


    public Student getAllStudent(Long id) throws Exception {
        Optional<Student> studentOptional = students.stream().filter(student
                -> student.getId().equals(id)).findFirst();

        if (studentOptional.isEmpty()) {
            throw new ExceptionResponse("Student not found!", HttpStatus.NOT_FOUND);
        }
        return studentOptional.get();
    }

    public void removeStudent(Long id) throws Exception {
        Student student = this.getAllStudent(id);
        students.remove(student);
    }

}
