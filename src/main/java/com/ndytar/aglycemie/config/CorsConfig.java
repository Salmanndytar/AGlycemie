package com.ndytar.aglycemie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


import java.util.Arrays;
import java.util.List;

@Configuration
public class CorsConfig {
@Bean
CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(List.of("http://localhost:4200"));
    configuration.setAllowCredentials(true);
    //configuration.setMaxAge(3600L);
    configuration.setExposedHeaders(Arrays.asList("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
    configuration.setAllowedMethods(List.of("*"));
    configuration.setAllowedHeaders(Arrays.asList("Authorization","Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
            "Access-Control-Request-Headers"));
    configuration.setAllowCredentials(true);
    UrlBasedCorsConfigurationSource source =new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**",configuration);
    return source;
    
}
}





