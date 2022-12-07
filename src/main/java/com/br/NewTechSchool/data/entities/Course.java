package com.br.NewTechSchool.data.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private int duration;
    @Column
    private String modality;
    @Column
    private Double monthlyFee;
    @OneToOne(orphanRemoval = true, cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name="professor_id", referencedColumnName = "id")
    private Professor professor;
}
