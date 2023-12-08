package com.poc.springsecuritydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {
    private final String[] whiteListUrls = {
            "/register", "/hello"
    };

    @Bean(name = "passwordEncoder")
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        /*http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests
                (auth -> auth.anyRequest().authenticated()).addFilter(api->api.permi).securityMatcher(WHITE_LIST_URLS);*/
//        http.csrf(AbstractHttpConfigurer::disable).securityMatcher(whiteListUrls).
        return http.build();
    }

}
