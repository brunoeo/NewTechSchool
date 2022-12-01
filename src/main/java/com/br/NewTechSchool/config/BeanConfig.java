package com.br.NewTechSchool.config;

import com.br.NewTechSchool.domain.mappers.CourseMapper;
import com.br.NewTechSchool.domain.mappers.ProfessorSmallMapper;
import com.br.NewTechSchool.domain.mappers.ProfessorMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Profile({""})
@Configuration
public class BeanConfig {

    @Bean("passwordEncoder")
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ProfessorMapper getProfessorMapper(){
        return new ProfessorMapper();
    }
    @Bean
    public ProfessorSmallMapper getProfessorListMapper(){
        return new ProfessorSmallMapper();
    }

    @Bean
    public CourseMapper getCourseMapper(){
        return new CourseMapper();
    }



}
