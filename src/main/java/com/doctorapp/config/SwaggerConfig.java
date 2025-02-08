package com.doctorapp.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean // Creates a Spring bean for OpenAPI configuration
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()    // Main documentation section
                        .title("Doctor App APIs")  // ① API Title
                        .description("By Adil") )     // ③ API Description
                .servers(List.of(
                        new Server().url("http://localhost:8080")
                                .description("Local development server")
                ));
    }
}

