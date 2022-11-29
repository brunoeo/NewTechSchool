package com.br.NewTechSchool.NewTechSchool.config;

import com.br.NewTechSchool.NewTechSchool.domain.mappers.ProfessorListMapper;
import com.br.NewTechSchool.NewTechSchool.domain.mappers.ProfessorMapper;
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
    public ProfessorListMapper getProfessorListMapper(){
        return new ProfessorListMapper();
    }


}
