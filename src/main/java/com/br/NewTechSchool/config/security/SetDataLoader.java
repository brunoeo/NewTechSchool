package com.br.NewTechSchool.config.security;

import com.br.NewTechSchool.data.entities.Credential;
import com.br.NewTechSchool.data.repositories.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@SuppressWarnings("unused")
public class SetDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;
    @Autowired
    private CredentialRepository credentialRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (!alreadySetup) {
            Credential credential = new Credential();
            credential.setPassword(passwordEncoder.encode("123456"));
            credential.setUserName("teste@gmail.com");
            createUserIfNotFound(credential);
            alreadySetup = true;
        }
    }

    private void createUserIfNotFound(Credential root) {

        Optional<Credential> user = credentialRepository.findByUserName(root.getUsername());
        if (user.isEmpty()) {
            credentialRepository.save(root);
        }
    }
}



