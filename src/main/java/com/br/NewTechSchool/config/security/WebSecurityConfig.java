package com.br.NewTechSchool.config.security;

import com.br.NewTechSchool.domain.services.JWTService;
import com.br.NewTechSchool.domain.services.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

@EnableWebSecurity
@SuppressWarnings("unused")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
                .and()
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/hello").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                //Spring Security will never create an HttpSession and it will never use it to obtain the SecurityContext
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                //Adciona um filtro antes do filtro padrão do Spring
                //O filtro intercepta as requisições para validar o acesso do usuario
                .addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    //Retorna um novo filtro
    public OncePerRequestFilter jwtFilter() {
        return new JwtAuthFilter(jwtService, userDetailsService);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

}
