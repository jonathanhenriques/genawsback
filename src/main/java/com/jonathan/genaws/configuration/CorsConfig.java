package com.jonathan.genaws.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Permitir qualquer origem
        config.addAllowedOrigin("*");

        // Permitir todos os métodos (GET, POST, PUT, DELETE, etc.)
        config.addAllowedMethod("*");

        // Permitir todos os headers
        config.addAllowedHeader("*");

        // Permitir credenciais (por exemplo, para suporte a cookies)
        config.setAllowCredentials(true);

        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}
