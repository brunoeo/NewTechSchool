package com.br.NewTechSchool.domain.mappers;

import com.br.NewTechSchool.data.entities.Course;
import com.br.NewTechSchool.presentation.dto.CourseDTO;

public class CourseMapper implements IMapper<Course, CourseDTO> {

    public Course toObject(CourseDTO courseDTO) {
        Course course = new Course();
        this.putData(course, courseDTO);
        return course;
    }

    public CourseDTO toDTO(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(course.getId());
        courseDTO.setName(course.getName());
        courseDTO.setDuration(course.getDuration());
        courseDTO.setMonthlyFee(course.getMonthlyFee());
        courseDTO.setModality(course.getModality());
        if (course.getProfessor() != null) {
            courseDTO.setProfessorId(course.getProfessor().getId());
        }
        return courseDTO;
    }

    public void putData(Course course, CourseDTO courseDTO) {
        course.setName(courseDTO.getName());
        course.setDuration(courseDTO.getDuration());
        course.setModality(courseDTO.getModality());
        course.setMonthlyFee(courseDTO.getMonthlyFee());
    }

}
