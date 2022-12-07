package com.br.NewTechSchool.data.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role  extends AbstractEntity implements GrantedAuthority {

    @Column
    private String type;

    @Override
    public String getAuthority() {
        return this.type;
    }
}
