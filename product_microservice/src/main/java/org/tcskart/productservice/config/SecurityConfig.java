package org.tcskart.productservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.tcskart.productservice.filter.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers(HttpMethod.POST,"/api/v1.0/products").hasRole("ADMIN") // POST (if you split GET/POST)
                        .requestMatchers(HttpMethod.PUT,"/api/v1.0/products/update/**").hasRole("ADMIN")
                        .requestMatchers("/api/v1.0/products/**").permitAll()   // All users can view
                        .requestMatchers("/auth/token").permitAll() 
                        .anyRequest().authenticated()) .addFilterBefore(new JwtAuthenticationFilter(), org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.class)
                
                ;

        return http.build();
    }
}
