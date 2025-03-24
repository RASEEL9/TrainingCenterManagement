package com.example.repository;

import com.example.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    // ✅ Query method for filtering by enrollment status
    List<Enrollment> findByStatusIgnoreCase(String status);
}
