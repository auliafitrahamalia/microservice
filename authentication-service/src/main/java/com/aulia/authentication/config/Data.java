package com.aulia.authentication.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.aulia.authentication.repository.UserRepository;

import com.aulia.authentication.User;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class Data {
    private final PasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner init(UserRepository repository){
        return args-> {
        if (repository.findByUsername("admin").isEmpty()){
            repository.save(
                User.builder()
                    .username("admin")
                    .email("admin@gmail.com")
                    .password(passwordEncoder.encode("password"))
                    .role("ADMIN")
                    .build()
            );
        }
    };
    }

}
