package com.Api.GoTicket.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig  implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Todos los endpoints
                .allowedOrigins("*") // Permitir todos los orígenes o puedes especificar como "http://dominio.com"
                .allowedMethods("GET", "POST", "PUT", "DELETE"); // Métodos permitidos
    }
}
