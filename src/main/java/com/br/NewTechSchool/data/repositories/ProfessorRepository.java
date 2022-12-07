package com.br.NewTechSchool.data.repositories;

import com.br.NewTechSchool.data.entities.Professor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    Page<Professor> findAllByNameContainingIgnoreCase(String name, Pageable pageable);
}
