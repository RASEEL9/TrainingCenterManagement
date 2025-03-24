package com.example.entity;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Enrollment")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enrollmentId;

    @ManyToOne
    @JoinColumn(name = "studentId", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "courseId", nullable = false)
    private Course course;

    @ManyToOne
    @JoinColumn(name = "trainerId", nullable = true)
    private Trainer trainer;

    @Column(nullable = false)
    private Date enrollmentDate;

    @Column(nullable = false)
    private String status;  // Pending, Completed, Canceled

    // Constructors
    public Enrollment() {}

    // Getter methods
    public Long getEnrollmentId() { return enrollmentId; }
    public Student getStudent() { return student; }
    public Course getCourse() { return course; }
    public Trainer getTrainer() { return trainer; }
    public Date getEnrollmentDate() { return enrollmentDate; }
    public String getStatus() { return status; }

    // Setter methods (NEW)
    public void setStudent(Student student) { this.student = student; }
    public void setCourse(Course course) { this.course = course; }
    public void setTrainer(Trainer trainer) { this.trainer = trainer; }
    public void setEnrollmentDate(Date enrollmentDate) { this.enrollmentDate = enrollmentDate; }
    public void setStatus(String status) { this.status = status; }
}
