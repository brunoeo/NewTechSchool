package com.br.NewTechSchool.NewTechSchool.data.repositories;

import com.br.NewTechSchool.NewTechSchool.data.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>{
}
