package com.br.NewTechSchool.data.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Addresses")
@Getter
@Setter
public class Address extends AbstractEntity {

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
