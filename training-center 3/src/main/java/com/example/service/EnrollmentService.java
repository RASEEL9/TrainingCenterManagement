package com.example.service;

import com.example.dto.EnrollmentDTO;
import com.example.repository.EnrollmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnrollmentService {

    private static final Logger logger = LoggerFactory.getLogger(EnrollmentService.class);

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    //  Get Filtered Enrollments (By Status)
    public List<EnrollmentDTO> getEnrollmentsByStatus(String status) {
        logger.info("Fetching enrollments with status: {}", status);
        List<EnrollmentDTO> filteredEnrollments = enrollmentRepository.findByStatusIgnoreCase(status)
                .stream()
                .map(enrollment -> new EnrollmentDTO(enrollment.getEnrollmentId(), enrollment.getStatus(), enrollment.getEnrollmentDate().toString()))
                .collect(Collectors.toList());
        logger.info("Retrieved {} enrollments with status: {}", filteredEnrollments.size(), status);
        return filteredEnrollments;
    }
}
