package com.nc13.board.config;

import com.nc13.board.service.UserAuthService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, UserAuthService userAuthService) throws Exception{
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/","/boards","/users/signUp","/users/signIn","/error/**", "/users")
                        .permitAll()
                        .requestMatchers("/boards/*").hasRole("USER")
                        .anyRequest().authenticated()
                )
                .formLogin((formLogin) -> formLogin
                        .loginPage("/users/signIn")
                        .failureForwardUrl("/error/logInFailure")
                        .usernameParameter("email")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/boards")
                        .loginProcessingUrl("/users/auth")
                )
                .logout((logout)->logout
                        .logoutUrl("/logOut")
                        .logoutSuccessUrl("/boards")
                        .invalidateHttpSession(true))
                .userDetailsService(userAuthService);
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}