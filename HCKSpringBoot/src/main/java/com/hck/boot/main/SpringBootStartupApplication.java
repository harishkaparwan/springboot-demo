package com.hck.boot.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.hck.boot.controller")

public class SpringBootStartupApplication {
    public static void main(String[] args) {
    	SpringApplication.run(SpringBootStartupApplication.class, args);
    }
}