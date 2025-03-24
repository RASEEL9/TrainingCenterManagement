package com.example.dto;

public class EnrollmentDTO {
    private Long enrollmentId;
    private String status;
    private String enrollmentDate;

    // ✅ Constructor
    public EnrollmentDTO(Long enrollmentId, String status, String enrollmentDate) {
        this.enrollmentId = enrollmentId;
        this.status = status;
        this.enrollmentDate = enrollmentDate;
    }

    // ✅ Getters
    public Long getEnrollmentId() { return enrollmentId; }
    public String getStatus() { return status; }
    public String getEnrollmentDate() { return enrollmentDate; }
}
