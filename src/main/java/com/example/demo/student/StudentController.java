/**
 * REST class that enables users to add students to the application's database via CRUD operations
 *
 * @author Gabe Braden, Steampunk Education
 * @author Nelson Djalo, Amigoscode
 */
package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id) {
        studentService.deleteStudent(id);
    }

    @PutMapping(path = "{studentId}")
    public void putStudent(@PathVariable("studentId") Long id, @RequestBody Student updatedStudent) {
        studentService.updateStudent(id, updatedStudent);
    }
}
