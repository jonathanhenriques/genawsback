//package com.jonathan.genaws.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//    private final String[] AUTH_LIST_SWAGGER = {
//            "/swagger-ui/**", "/v3/api-docs/**", "/configuration/ui",
//            "/swagger-resources", "/configuration/security", "/swagger-ui.html", "/webjars/**",
//            "/swagger-resources/configuration/ui", "/swagge‌​r-ui.html", "/swagger-resources/configuration/security"
//    };
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//        // Habilitando o h2 console no navegador
//        http.headers().disable();
//
//        http.authorizeRequests(authorizeRequests -> authorizeRequests
//                .antMatchers(AUTH_LIST_SWAGGER).permitAll()
//                .anyRequest().permitAll()
//        );
//
//        http.csrf().disable() // Desativa a proteção CSRF (pode ser necessário para aplicativos que usam apenas APIs)
//                .cors().disable() // Desativa o controle CORS
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//        return http.build();
//    }
//}
