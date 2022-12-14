package com.br.NewTechSchool.data.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractPerson extends AbstractEntity {

    @Column
    private String name;
    @Column(unique = true)
    @Size(max = 12)
    private String rg;
    @Column(unique = true)
    @CPF
    private String cpf;
    @Column
    @Size(max = 2)
    private String ddd;
    @Column
    @Size(max = 9)
    private String phonenumber;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "credential_id", referencedColumnName = "id")
    private Credential credential;

}
