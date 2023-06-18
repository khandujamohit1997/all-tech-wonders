package com.khanduja.techwonders.configuration.cors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/employee/**")
            .allowedOrigins("http://localhost:3000")
            .allowedMethods("GET")
            .allowCredentials(true)
            .maxAge(3600);
    }
}
