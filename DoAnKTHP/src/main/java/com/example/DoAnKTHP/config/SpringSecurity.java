package com.example.DoAnKTHP.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurity {
        @Bean
        public static PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                                .csrf(csrf -> csrf.disable())
                                .authorizeHttpRequests((authorize) -> authorize
                                                .requestMatchers("/signup/**", "/login/**", "/api/**").permitAll()
                                                .requestMatchers("/images/**", "/css/**", "/js/**").permitAll()
                                                .requestMatchers("/admin/**").hasAuthority("ADMIN")
                                                .anyRequest().authenticated())
                                .formLogin(
                                                form -> form
                                                                .loginPage("/login")
                                                                .loginProcessingUrl("/login")
                                                                .usernameParameter("username")
                                                                .passwordParameter("password")
                                                                .defaultSuccessUrl("/lich/timgiangvien", true)
                                                                .permitAll())
                                .logout(
                                                logout -> logout
                                                                .logoutRequestMatcher(
                                                                                new AntPathRequestMatcher("/logout"))
                                                                .permitAll());
                return http.build();
        }
}
