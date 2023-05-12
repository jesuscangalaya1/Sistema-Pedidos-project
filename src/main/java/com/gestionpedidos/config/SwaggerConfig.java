package com.gestionpedidos.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "${open_api.tittle}",
                description = "${open_api.description}",
                contact = @Contact(
                        name = "${open_api.contact.name}",
                        email = "${open_api.contact.email}"
                )
        ),
        servers = {
                @Server(url = "${open_api.servers.local.url}",
                        description = "${open_api.servers.local.description}"),
                @Server(url = "${open_api.servers.production.url}",
                        description = "${open_api.servers.production.description}") }
)
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi sbDemoApi() {
        return GroupedOpenApi.builder()
                .group("Sistema de Pedidos")
                .pathsToMatch("/api/**")
                .build();
    }
}
