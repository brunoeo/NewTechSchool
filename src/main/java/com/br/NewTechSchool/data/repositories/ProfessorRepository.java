package com.br.NewTechSchool.data.repositories;

import com.br.NewTechSchool.data.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>{
}
