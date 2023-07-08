package com.proyectofinal.proyectofinal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;

import com.proyectofinal.proyectofinal.Model.service.UserService;

@Configuration
public class SpringSecurityConfig {

    @Autowired
    private UserService userService;

    @Bean
    public static BCryptPasswordEncoder encriptarPaassword(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void criptografiaPassword(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(encriptarPaassword());
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests()
        .requestMatchers("/*", "/autenticacion*").permitAll()
        .anyRequest().authenticated()
        .and().formLogin(login -> login.loginPage("/autenticacion").defaultSuccessUrl("/panel/", true)).logout(logout -> logout.permitAll());
        return http.build();
    }
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() throws Exception{
        return (web)->web.ignoring().requestMatchers("/css/**","/js/**","/images/**");
    }
}