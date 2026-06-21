package com.javas.yoedu_be;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ConfigurationPropertiesScan
@EnableJpaRepositories("com.javas.yoedu_be.repositories")
public class YoeduBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(YoeduBeApplication.class, args);
    }
}