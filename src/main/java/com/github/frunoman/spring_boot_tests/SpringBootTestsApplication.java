package com.github.frunoman.spring_boot_tests;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import org.springframework.context.support.SimpleThreadScope;

@SpringBootApplication
public class SpringBootTestsApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringBootTestsApplication.class, args);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringBootTestsApplication.class);
    }






}
