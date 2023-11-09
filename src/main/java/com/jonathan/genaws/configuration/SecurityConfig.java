package com.jonathan.genaws.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.apache.catalina.webresources.TomcatURLStreamHandlerFactory.disable;
import static org.apache.commons.lang3.BooleanUtils.and;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



import lombok.RequiredArgsConstructor;








@Configuration
public class SecurityConfig {

    private final String[] AUTH_LIST_SWAGGER = { "/swagger-ui/**", "/v3/api-docs/**", "/configuration/ui",
            "/swagger-resources", "/configuration/security", "/swagger-ui.html", "/webjars/**",
            "/swagger-resources/configuration/ui", "/swagge‌​r-ui.html", "/swagger-resources/configuration/security" };
//    private final String[] AUTH_LIST_USUARIO = { "/usuarios/cadastrar", "/usuarios/logar", "/usuarios/autenticar" };


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // habilitando o h2 console no navegador*********************
        http.headers().frameOptions().disable();
//        http.authorizeRequests().antMatchers("/h2-console/**").permitAll();
        // *************
//		return http.authorizeRequests(authorizeRequests -> authorizeRequests
//        http.authorizeRequests(authorizeRequests -> authorizeRequests.antMatchers(AUTH_LIST_SWAGGER).permitAll());
//		http.authorizeRequests().antMatchers(AUTH_LIST_SWAGGER).permitAll();
//        http.authorizeRequests().antMatchers(HttpMethod.POST, AUTH_LIST_USUARIO).permitAll();
//        http.authorizeRequests().anyRequest().permitAll()
//		http.authorizeRequests().anyRequest().permitAll()
                http.authorizeRequests()
                .antMatchers("/**").permitAll(); // Permite acesso irrestrito a todas as URLs
//                .anyRequest().permitAll()  // Todas as outras URLs exigem autenticação

        http.authorizeRequests(authorizeRequests -> authorizeRequests.antMatchers(AUTH_LIST_SWAGGER).permitAll());

                http
                .csrf().disable() // Desativa a proteção CSRF (pode ser necessário para aplicativos que usam apenas APIs)
                .cors().disable(); // Desativa o controle CORS

//                .and().cors().and().csrf();
//                .disable();// talvez tenha que ser retirada caso front end nao funcione
//		).build();

        return http.build();


    }



}
