package com.apiproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class ApiProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiProjectApplication.class, args);
    }

}
