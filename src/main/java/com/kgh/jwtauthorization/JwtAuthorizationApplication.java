package com.kgh.jwtauthorization;

import com.kgh.jwtauthorization.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class JwtAuthorizationApplication {
    public static void main(String[] args) {
        SpringApplication.run(JwtAuthorizationApplication.class, args);
    }
}
