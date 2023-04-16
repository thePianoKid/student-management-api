package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student maria = new Student(
                    "Maria",
                    "test@test.com",
                    LocalDate.of(2000, Month.JANUARY, 1)
            );
            Student gabe = new Student(
                    "Gabe",
                    "test@test.com",
                    LocalDate.of(2000, Month.JANUARY, 1)
            );

            repository.saveAll(List.of(maria, gabe));
        };
    }
}
