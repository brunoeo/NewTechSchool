package com.br.NewTechSchool.config;

import com.br.NewTechSchool.domain.mappers.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("unused")
@Configuration
public class BeanConfig {

    @Bean("passwordEncoder")
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ProfessorMapper getProfessorMapper() {
        return new ProfessorMapper();
    }

  @Bean
  public ProfessorSmallMapper getProfessorListMapper() {
    return new ProfessorSmallMapper();
  }

  @Bean
  public CourseMapper getCourseMapper() {
    return new CourseMapper();
  }

  @Bean
  public StudentMapper getStudentMapper() {
    return new StudentMapper();
  }
  @Bean
  public StudentSmallMapper getStudentSmallMapper() {
    return new StudentSmallMapper();
  }


}
