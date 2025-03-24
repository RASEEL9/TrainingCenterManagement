package com.example.service;

import com.example.dto.StudentDTO;
import com.example.entity.Student;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Get All Students (Manually mapping DTO)
    public List<StudentDTO> getAllStudents() {
        logger.info("Fetching all students");
        List<StudentDTO> students = studentRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        logger.info("Fetched {} students", students.size());
        return students;
    }

    // Get Student by ID (Manually mapping DTO)
    public StudentDTO getStudentById(Long id) {
        logger.info("Fetching student by ID: {}", id);
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Student with ID {} not found", id);
                    return new ResourceNotFoundException("Student with ID " + id + " not found");
                });

        logger.info("Found student with ID: {}", id);
        return convertToDTO(student);
    }

    //  Add New Student (Manually mapping DTO)
    public StudentDTO addStudent(StudentDTO studentDTO) {
        logger.info("Adding new student: {}", studentDTO.getName());
        Student student = convertToEntity(studentDTO);
        Student savedStudent = studentRepository.save(student);
        logger.info("Saved new student with ID: {}", savedStudent.getId());
        return convertToDTO(savedStudent);
    }

    // Delete Student by ID
    public void deleteStudent(Long id) {
        logger.info("Deleting student with ID: {}", id);
        if (!studentRepository.existsById(id)) {
            logger.error("Cannot delete: Student with ID {} not found", id);
            throw new ResourceNotFoundException("Cannot delete: Student with ID " + id + " not found");
        }
        studentRepository.deleteById(id);
        logger.info("Deleted student with ID: {}", id);
    }

    // Sorting Students by a Specific Field
    public List<StudentDTO> getAllStudentsSorted(String sortBy) {
        logger.info("Fetching sorted students by {}", sortBy);
        List<Student> students = studentRepository.findAll(Sort.by(Sort.Direction.ASC, sortBy));
        logger.info("Fetched {} sorted students", students.size());
        return students.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    //  Helper Method: Convert Student -> StudentDTO
    private StudentDTO convertToDTO(Student student) {
        logger.debug("Converting student with ID {} to DTO", student.getId());
        return new StudentDTO(student.getId(), student.getName(), student.getEmail(), student.getStudentDegree());
    }

    // Helper Method: Convert StudentDTO -> Student
    private Student convertToEntity(StudentDTO studentDTO) {
        logger.debug("Converting student DTO to entity: {}", studentDTO.getName());
        return new Student(studentDTO.getId(), studentDTO.getName(), studentDTO.getEmail(), studentDTO.getStudentDegree());
    }
}
