package com.masterpiecebrouillon.brouillon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.DefaultSecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityFilterChain {
    @Bean
    public DefaultSecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/v1/**").permitAll()
                        .anyRequest().authenticated()
                );
        http
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                );

        http
                .csrf(AbstractHttpConfigurer::disable // desactivation de la protection csrf / CORS
                )
                .formLogin(Customizer.withDefaults());



        return http.build();
    }
}
//https://stackoverflow.com/questions/76339307/spring-security-deprecated-issue
//https://docs.spring.io/spring-security/reference/migration-7/configuration.html#_use_the_lambda_dsl