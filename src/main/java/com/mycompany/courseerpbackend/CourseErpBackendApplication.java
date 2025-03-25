package com.mycompany.courseerpbackend;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class CourseErpBackendApplication implements CommandLineRunner {

    // TODO: 1. Dockerization app: Dockerize APP and prepare server environment for frontend developers
    // TODO: 2. Implement GitHub workflows: Build docker image & Push to Dockerhub

    public static void main(String[] args) {
        SpringApplication.run(CourseErpBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }

}
