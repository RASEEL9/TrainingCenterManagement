package com.example.entity;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @Column(nullable = false)
    private String courseName;

    @Column(nullable = false)
    private Double amount;  // ✅ Ensure this exists

    private Date startDate;
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "trainerId", nullable = true)
    private Trainer trainer;

    // ✅ Constructors
    public Course() {}

    public Course(String courseName, Double amount, Date startDate, Date endDate, Trainer trainer) {
        this.courseName = courseName;
        this.amount = amount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.trainer = trainer;
    }

    // ✅ Getters and Setters (Fix your issue)
    public Long getCourseId() { return courseId; }
    public void setCourseId(Long courseId) { this.courseId = courseId; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public Double getAmount() { return amount; }   // ✅ Add this
    public void setAmount(Double amount) { this.amount = amount; }  // ✅ Add this

    public Date getStartDate() { return startDate; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }

    public Date getEndDate() { return endDate; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }

    public Trainer getTrainer() { return trainer; }
    public void setTrainer(Trainer trainer) { this.trainer = trainer; }
}
