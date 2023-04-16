/**
 * Boilerplate class that includes a student's attributes
 *
 * @author Gabe Braden, Steampunk Education
 * @author Nelson Djalo, Amigoscode
 */
package com.example.demo.student;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String name;
    private String parentsEmail;
    private LocalDate dateOfBirth;
    @Transient
    private Integer age;

    // JPA requires that the Student class has an empty constructor
    public Student() {}

    public Student(String name, String parentsEmail, LocalDate dateOfBirth) {
        this.name = name;
        this.parentsEmail = parentsEmail;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentsEmail() {
        return parentsEmail;
    }

    public void setParentsEmail(String parentsEmail) {
        this.parentsEmail = parentsEmail;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public Integer getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentsEmail='" + parentsEmail + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}