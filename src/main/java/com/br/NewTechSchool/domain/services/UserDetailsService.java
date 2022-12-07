package com.br.NewTechSchool.domain.services;

import com.br.NewTechSchool.data.entities.Credential;
import com.br.NewTechSchool.data.repositories.CredentialRepository;
import com.br.NewTechSchool.presentation.dto.LoginDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final CredentialRepository credentialRepository;
    private final PasswordEncoder passwordEncoder;


    //Verifica o userName
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Credential> credential = credentialRepository.findByUserName(username);
        if (credential.isPresent()) {
            return credential.get();
        }
        throw  new UsernameNotFoundException("Dados Invalidos");

    }

    public void verifyUserCredentials(LoginDTO login){
        UserDetails credential = loadUserByUsername(login.getUsername());
        //Após a validação do username, retorna um usuario e agora verifica a senha criptografada
        boolean passwordIsTheSame = passwordEncoder.matches(login.getPassword(), credential.getPassword());
        if (!passwordIsTheSame){
            throw new UsernameNotFoundException("Dados Invalidos");
        }

    }
}
