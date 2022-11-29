package com.br.NewTechSchool.NewTechSchool.data.repositories;

import com.br.NewTechSchool.NewTechSchool.data.entities.AbstractPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AbstractPerson, Long> {
}
