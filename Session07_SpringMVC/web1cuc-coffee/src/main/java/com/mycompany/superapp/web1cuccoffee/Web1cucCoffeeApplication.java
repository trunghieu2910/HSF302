package com.mycompany.superapp.web1cuccoffee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Web1cucCoffeeApplication {
    // Bean trung tâm : nơi chứa về những khai báo về tất cả các loại Bean trong app
    // Dependency Object là những đứa có @Component, @Service, @Repository, @Controller, @RestController
    // @SpringBootApplication gộp sẵn 3 @ khác  :
    // Configuration , @Component, @EnableAutoConfiguration
    public static void main(String[] args) {
        SpringApplication.run(Web1cucCoffeeApplication.class, args);
    }

}
