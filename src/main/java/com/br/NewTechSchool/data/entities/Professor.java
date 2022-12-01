package com.br.NewTechSchool.data.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "professors")
@Getter
@Setter
public class Professor extends AbstractPerson{

    @Column
    private String specialization;
}
