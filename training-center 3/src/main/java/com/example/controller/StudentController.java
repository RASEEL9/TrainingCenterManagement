package com.example.controller;

import com.example.dto.StudentDTO;
import com.example.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Get All Students
    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        logger.info("Fetching all students");
        List<StudentDTO> students = studentService.getAllStudents();
        logger.debug("Fetched {} students", students.size());
        return ResponseEntity.ok(students);
    }

    // Get Student by ID
    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id) {
        logger.info("Fetching student with ID: {}", id);
        StudentDTO studentDTO = studentService.getStudentById(id);
        logger.debug("Fetched student: {}", studentDTO);
        return ResponseEntity.ok(studentDTO);
    }

    //  Add New Student
    @PostMapping
    public ResponseEntity<StudentDTO> addStudent(@RequestBody StudentDTO studentDTO) {
        logger.info("Adding new student: {}", studentDTO);
        StudentDTO savedStudent = studentService.addStudent(studentDTO);
        logger.debug("Student added successfully: {}", savedStudent);
        return ResponseEntity.ok(savedStudent);
    }

    // Delete Student
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        logger.info("Deleting student with ID: {}", id);
        studentService.deleteStudent(id);
        logger.debug("Student with ID {} deleted successfully", id);
        return ResponseEntity.ok("Student deleted successfully");
    }

    //  Sorting Students by Specified Field
    @GetMapping("/sorted")
    public ResponseEntity<List<StudentDTO>> getAllStudentsSorted(@RequestParam(defaultValue = "studentDegree") String sortBy) {
        logger.info("Fetching sorted students by {}", sortBy);
        List<StudentDTO> students = studentService.getAllStudentsSorted(sortBy);
        logger.debug("Fetched {} sorted students", students.size());
        return ResponseEntity.ok(students);
    }
}
