package com.example.entity;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Certification")
public class Certification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long certificationId;

    @ManyToOne
    @JoinColumn(name = "enrollmentId", nullable = false)
    private Enrollment enrollment;

    @ManyToOne
    @JoinColumn(name = "studentId", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "courseId", nullable = false)
    private Course course;

    @ManyToOne
    @JoinColumn(name = "trainerId", nullable = true)
    private Trainer trainer;

  private Date certificationDate;

public Date getCertificationDate() {
	return certificationDate;
}

public void setCertificationDate(Date certificationDate) {
	this.certificationDate = certificationDate;
}
  

}
