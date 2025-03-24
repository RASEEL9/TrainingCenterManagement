package com.example.service;

import com.example.dto.PaymentDTO;
import com.example.entity.Payment;
import com.example.entity.Student;
import com.example.entity.Course;
import com.example.repository.PaymentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    private static final Logger logger = LoggerFactory.getLogger(PaymentService.class);

    @Autowired
    private PaymentRepository paymentRepository;

    //  Get All Payments
    public List<PaymentDTO> getAllPayments() {
        logger.info("Fetching all payments");
        List<PaymentDTO> payments = paymentRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        logger.info("Fetched {} payments", payments.size());
        return payments;
    }

    //  Get Sorted Payments
    public List<PaymentDTO> getAllPaymentsSorted(String sortBy) {
        logger.info("Fetching sorted payments by {}", sortBy);
        List<String> allowedSortFields = List.of("dateOfPayment", "paymentMethods", "paymentState");
        if (!allowedSortFields.contains(sortBy)) {
            logger.warn("Invalid sort field '{}' provided. Defaulting to 'dateOfPayment'", sortBy);
            sortBy = "dateOfPayment";  // Default if an invalid field is passed
        }

        List<PaymentDTO> sortedPayments = paymentRepository.findAll(Sort.by(Sort.Direction.ASC, sortBy))
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        logger.info("Fetched {} sorted payments", sortedPayments.size());
        return sortedPayments;
    }

    // Helper Method: Convert Payment -> PaymentDTO
    private PaymentDTO convertToDTO(Payment payment) {
        String studentDegree = "Unknown Student";
        String courseName = "Unknown Course";

        Student student = payment.getStudent();
        if (student != null) {
            studentDegree = (student.getStudentDegree() != null) ? student.getStudentDegree() : "No Degree Info";
        }

        Course course = payment.getCourse();
        if (course != null) {
            courseName = (course.getCourseName() != null) ? course.getCourseName() : "No Course Info";
        }

        PaymentDTO paymentDTO = new PaymentDTO(
                payment.getPaymentId(),
                studentDegree,
                courseName,
                (payment.getDateOfPayment() != null) ? payment.getDateOfPayment().toString() : "No Date",
                payment.getPaymentMethods(),
                payment.getPaymentState()
        );

        logger.debug("Converted payment with ID {} to DTO", payment.getPaymentId());
        return paymentDTO;
    }
}
