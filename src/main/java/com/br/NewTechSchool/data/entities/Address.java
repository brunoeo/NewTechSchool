package com.br.NewTechSchool.data.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Addresses")
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String cep;
    @Column
    private String street;
    @Column
    private String number;
    @Column
    private String district;
    @Column
    private String city;

}