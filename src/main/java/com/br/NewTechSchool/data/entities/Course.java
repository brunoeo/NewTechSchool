package com.br.NewTechSchool.data.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
}
