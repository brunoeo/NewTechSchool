package com.br.NewTechSchool.data.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "professors")
@Getter
@Setter
public class Professor extends AbstractPerson{

    @Column
    private String specialization;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "professor", orphanRemoval = true)
    Course course;
}
