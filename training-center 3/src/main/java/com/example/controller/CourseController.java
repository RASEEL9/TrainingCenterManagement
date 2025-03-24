package com.example.controller;

import com.example.dto.CourseDTO;
import com.example.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private static final Logger logger = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    private CourseService courseService;

    //  Get All Courses
    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAllCourses() {
        logger.info("Fetching all courses");
        List<CourseDTO> courses = courseService.getAllCourses();
        logger.debug("Fetched {} courses", courses.size());
        return ResponseEntity.ok(courses);
    }

    // Get Sorted Courses
    @GetMapping("/sorted")
    public ResponseEntity<List<CourseDTO>> getAllCoursesSorted(@RequestParam(defaultValue = "courseName") String sortBy) {
        logger.info("Fetching sorted courses by {}", sortBy);
        List<CourseDTO> courses = courseService.getAllCoursesSorted(sortBy);
        logger.debug("Fetched {} sorted courses", courses.size());
        return ResponseEntity.ok(courses);
    }

    // Get Filtered Courses (By Name)
    @GetMapping("/filter")
    public ResponseEntity<List<CourseDTO>> filterCourses(@RequestParam String name) {
        logger.info("Filtering courses by name: {}", name);
        List<CourseDTO> courses = courseService.getCoursesByName(name);
        logger.debug("Fetched {} filtered courses", courses.size());
        return ResponseEntity.ok(courses);
    }
}
