package com.example.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @Column(nullable = false)
    private LocalDate dateOfPayment;

    @Column(nullable = false)
    private String paymentMethods;

    @Column(nullable = false)
    private String paymentState;

    // ✅ No-Args Constructor
    public Payment() {}

    // ✅ All-Args Constructor
    public Payment(Long paymentId, Student student, Course course, LocalDate dateOfPayment, String paymentMethods, String paymentState) {
        this.paymentId = paymentId;
        this.student = student;
        this.course = course;
        this.dateOfPayment = dateOfPayment;
        this.paymentMethods = paymentMethods;
        this.paymentState = paymentState;
    }

    // ✅ Getters and Setters
    public Long getPaymentId() { return paymentId; }
    public void setPaymentId(Long paymentId) { this.paymentId = paymentId; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }

    public LocalDate getDateOfPayment() { return dateOfPayment; }
    public void setDateOfPayment(LocalDate dateOfPayment) { this.dateOfPayment = dateOfPayment; }

    public String getPaymentMethods() { return paymentMethods; }
    public void setPaymentMethods(String paymentMethods) { this.paymentMethods = paymentMethods; }

    public String getPaymentState() { return paymentState; }
    public void setPaymentState(String paymentState) { this.paymentState = paymentState; }
}
