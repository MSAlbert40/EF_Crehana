package com.crehana.demo.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean(name = "crehanaOpenApi")
    public OpenAPI crehanaOpenApi() {
        // Swagger UI available at:
        // http://localhost:8081/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Crehana User Profile Service API Documentation").description(
                        "Crehana API implemented with Spring Boot RESTful service and documented using springdoc-openapi and OpenAPI 3."));
    }
}
