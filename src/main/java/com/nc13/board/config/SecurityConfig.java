package com.nc13.board.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/","/boards","/users/**")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/users/signIn")
                        .usernameParameter("email")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/users/auth")
                )
                .logout((logout)->logout
                        .logoutSuccessUrl("/boards")
                        .invalidateHttpSession(true));
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}