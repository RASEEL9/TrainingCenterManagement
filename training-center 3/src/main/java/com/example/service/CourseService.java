package com.example.service;

import com.example.dto.CourseDTO;
import com.example.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private static final Logger logger = LoggerFactory.getLogger(CourseService.class);

    @Autowired
    private CourseRepository courseRepository;

    // Get All Courses
    public List<CourseDTO> getAllCourses() {
        logger.info("Fetching all courses");
        List<CourseDTO> courses = courseRepository.findAll()
                .stream()
                .map(course -> new CourseDTO(course.getCourseId(), course.getCourseName(), course.getAmount()))
                .collect(Collectors.toList());
        logger.info("Retrieved {} courses", courses.size());
        return courses;
    }

    // Get Sorted Courses
    public List<CourseDTO> getAllCoursesSorted(String sortBy) {
        logger.info("Fetching all courses sorted by {}", sortBy);
        List<CourseDTO> sortedCourses = courseRepository.findAll(Sort.by(Sort.Direction.ASC, sortBy))
                .stream()
                .map(course -> new CourseDTO(course.getCourseId(), course.getCourseName(), course.getAmount()))
                .collect(Collectors.toList());
        logger.info("Retrieved {} courses sorted by {}", sortedCourses.size(), sortBy);
        return sortedCourses;
    }

    // Get Filtered Courses (By Name)
    public List<CourseDTO> getCoursesByName(String name) {
        logger.info("Fetching courses containing the name: {}", name);
        List<CourseDTO> filteredCourses = courseRepository.findByCourseNameContainingIgnoreCase(name)
                .stream()
                .map(course -> new CourseDTO(course.getCourseId(), course.getCourseName(), course.getAmount()))
                .collect(Collectors.toList());
        logger.info("Retrieved {} courses with name containing: {}", filteredCourses.size(), name);
        return filteredCourses;
    }
}
