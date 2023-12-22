package com.jonathan.genawsapp.core.config;


//import org.springdoc.core.customizers.OpenApiCustomiser;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

import java.util.Arrays;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI springBlogPessoalOpenAPI() {
        final String securitySchemeName = "bearerAuth";
        /**
         * Cria um Objeto da Classe OpenAPI, que gera a documentação no Swagger
         * utilizando a especificação OpenAPI.
         *
         */

        return new OpenAPI()
				.info(
                        new Info()
                            .title("Sprint Quiz")
                            .description("Projeto de API para escolas, apenas um CRUD, desenvolvido por mim, Jonathan :)")
                            .version("v0.0.1")
						    .license(new License().name("Não definido").url("https://github.com/jonathanhenriques"))
                            .contact(
                        new Contact().name("Jonathan").url("https://www.linkedin.com/in/jonathan-henrique-/")
                            .email("silva.henriquejonas@gmail.com")))
                            .externalDocs(
						new ExternalDocumentation()
                            .description("Github")
                            .url("https://github.com/jonathanhenriques/"))
				/**
				 *
				 * Tags servem para dar nomes especificos aos nossos controllers na exibicao do swagger, e nao expor os nomes reais
				 */

				.tags(
						Arrays.asList(
								new Tag().name("Sala").description("salas de aula"),
								new Tag().name("Professor").description("professores da sala"),
								new Tag().name("Aluno").description("alunos da sala")
						)
				)


            /**
             * Configura o Componente OpenApi Aqui declaramos que o token será pedido para
             * todas as operações no Swagger da aplicação
             *
             * @return
             */
                            .addSecurityItem(new SecurityRequirement()
                            .addList(securitySchemeName))
                            .components(new Components()
                            .addSecuritySchemes(securitySchemeName, new SecurityScheme()
						    .name(securitySchemeName)
                            .type(SecurityScheme.Type.HTTP)
                            .scheme("bearer")
						    .description(
								"Forneça o Token JWT. JWT token pode ser obtido ao fazer login na API." +
                                " Credenciais para testes <strong>madruguinha/12345678</strong> futuramente...")
						    .bearerFormat("JWT")));
    }


}



