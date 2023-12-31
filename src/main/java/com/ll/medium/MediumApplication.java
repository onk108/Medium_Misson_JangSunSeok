package com.ll.medium;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class MediumApplication {

    public static void main(String[] args) {
        SpringApplication.run(MediumApplication.class, args);
    }
}
