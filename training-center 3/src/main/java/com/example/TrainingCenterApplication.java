package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point of the Spring Boot application.
 */
@SpringBootApplication
public class TrainingCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrainingCenterApplication.class, args);
        System.out.println("🎉 Training Center Application Started Successfully! 🚀");
    }
}
