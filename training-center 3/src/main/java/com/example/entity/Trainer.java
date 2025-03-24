package com.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Trainer")
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainerId;

    @Column(nullable = false)
    private String subjects;

    @Column(nullable = false)
    private String contactInfo;

    @Column(nullable = false)
    private String specialty;

    // Constructors
    public Trainer() {}

    public Trainer(String subjects, String contactInfo, String specialty) {
        this.subjects = subjects;
        this.contactInfo = contactInfo;
        this.specialty = specialty;
    }

    // Getters and Setters
    public Long getTrainerId() { return trainerId; }
    public void setTrainerId(Long trainerId) { this.trainerId = trainerId; }

    public String getSubjects() { return subjects; }
    public void setSubjects(String subjects) { this.subjects = subjects; }

    public String getContactInfo() { return contactInfo; }
    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }

    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }
}
