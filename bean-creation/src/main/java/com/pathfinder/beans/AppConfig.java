package com.pathfinder.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig{


    @Bean
    public Product product() {
        return  new Product();
    }
}
