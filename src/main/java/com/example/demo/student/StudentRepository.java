/**
 * Uses the JPA interface to easily manipulate the application's database
 *
 * @author Gabe Braden, Steampunk Education
 * @author Nelson Djalo, Amigoscode
 */
package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT s FROM Student s WHERE s.name = ?1")
    Optional<Student> findstudentByName(String name);
}
