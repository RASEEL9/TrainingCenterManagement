package com.example.repository;

import com.example.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    // ✅ Query method for filtering by course name
    List<Course> findByCourseNameContainingIgnoreCase(String name);
}
