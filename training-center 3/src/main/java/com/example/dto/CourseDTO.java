package com.example.dto;

public class CourseDTO {
    private Long courseId;
    private String courseName;
    private Double amount;

    // ✅ Constructor
    public CourseDTO(Long courseId, String courseName, Double amount) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.amount = amount;
    }

    // ✅ Getters
    public Long getCourseId() { return courseId; }
    public String getCourseName() { return courseName; }
    public Double getAmount() { return amount; }
}
