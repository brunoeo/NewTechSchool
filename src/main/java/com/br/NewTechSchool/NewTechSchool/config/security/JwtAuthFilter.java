package com.br.NewTechSchool.NewTechSchool.config.security;

import com.br.NewTechSchool.NewTechSchool.domain.services.JWTService;
import com.br.NewTechSchool.NewTechSchool.domain.services.UserDetailsService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthFilter extends OncePerRequestFilter {

    private final JWTService jwtService;
    private final UserDetailsService userDetailsService;

    public JwtAuthFilter(JWTService jwtService, UserDetailsService userDetailsService) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    //Método que será executado na intercptação das requisições
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        //Recupera o token
        String authorization = request.getHeader("Authorization");

        //Verifica se existe o token e se ele começa com "Bearer"
        if (authorization != null && authorization.startsWith("Bearer")){

            //Separa o token do Bearer
            String token = authorization.split(" ")[1];
            //Recupera o userName criptografado no token
            String username = jwtService.getUserName(token);

            //Chama o método que valida o usuario pelo userName
            UserDetails user = userDetailsService.loadUserByUsername(username);

            //Cria um usuario que será inserido no contexto do spring security
            UsernamePasswordAuthenticationToken userCtx = new UsernamePasswordAuthenticationToken(user,
                    null, user.getAuthorities());

            //Configurando o spring security como uma autenticação web
            userCtx.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            //Inserindo o usuario dentro do contexto do spring security
            SecurityContextHolder.getContext().setAuthentication(userCtx);
        }
        filterChain.doFilter(request, response);

    }
}
