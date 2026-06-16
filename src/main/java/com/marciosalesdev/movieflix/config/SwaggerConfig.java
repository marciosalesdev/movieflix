package com.marciosalesdev.movieflix.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI getOpenApi() {
        Contact contact = new Contact();
        contact.name("Marcio Sales");
        contact.email("marciosalesdevelop@gmail.com");

        Info info = new Info();
        info.title("MovieFlix");
        info.version("V1");
        info.description("Aplicação para geremciamento de catalogo de Filmes");
        info.contact(contact);

        return new OpenAPI().info(info);


    }
}
