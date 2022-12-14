package com.br.NewTechSchool.data.repositories;

import com.br.NewTechSchool.data.entities.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    Page<Course> findAllByNameContainingIgnoreCase(String name, Pageable pageable);
}
