package com.br.NewTechSchool.data.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role extends AbstractEntity implements GrantedAuthority {

    @Column
    private String type;

    @Override
    public String getAuthority() {
        return this.type;
    }
}
