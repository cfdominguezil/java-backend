package com.prueba.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

	@Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de TAREAS")
                        .version("1.0")
                        .description("API REST para la gestión de TAREAS")
                        .contact(new Contact()
                                .name("Equipo de Desarrollo")
                                .email("prueba@correo.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")));
	}
}
