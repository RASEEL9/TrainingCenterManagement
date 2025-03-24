package com.example.controller;

import com.example.dto.EnrollmentDTO;
import com.example.service.EnrollmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    private static final Logger logger = LoggerFactory.getLogger(EnrollmentController.class);

    @Autowired
    private EnrollmentService enrollmentService;

    //  Get Filtered Enrollments (By Status)
    @GetMapping("/filter")
    public ResponseEntity<List<EnrollmentDTO>> filterEnrollments(@RequestParam String status) {
        logger.info("Filtering enrollments by status: {}", status);
        List<EnrollmentDTO> enrollments = enrollmentService.getEnrollmentsByStatus(status);
        logger.debug("Fetched {} enrollments with status: {}", enrollments.size(), status);
        return ResponseEntity.ok(enrollments);
    }
}
