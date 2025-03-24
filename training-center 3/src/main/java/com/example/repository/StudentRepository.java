package com.example.repository;

import com.example.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    // Check if a student exists by email
    boolean existsByEmail(String email);

    // Optional: Find student by email
    Optional<Student> findByEmail(String email);
}
