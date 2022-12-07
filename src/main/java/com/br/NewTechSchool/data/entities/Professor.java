package com.br.NewTechSchool.data.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "professors")
@Getter
@Setter
public class Professor extends AbstractPerson {

    @Column
    private String specialization;
    @OneToOne(mappedBy = "professor", orphanRemoval = true)
    Course course;
}
