package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findstudentByName(student.getName());
        if (studentOptional.isPresent())
            throw new IllegalArgumentException("Cannot add a student with exactly the same name");
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id))
            throw new IllegalArgumentException("Student ID does not exist");
        studentRepository.deleteById(id);
    }


    public void updateStudent(Long id, Student updatedStudent) {
        if (!studentRepository.existsById(id))
            throw new IllegalArgumentException("Student ID does not exist");
        studentRepository.save(updatedStudent);
    }
}
