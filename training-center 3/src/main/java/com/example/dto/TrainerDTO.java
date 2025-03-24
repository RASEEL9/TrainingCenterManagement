package com.example.dto;

public class TrainerDTO {
    private Long trainerId;
    private String subjects;
    private String contactInfo;
    private String specialty;

    public TrainerDTO(Long trainerId, String subjects, String contactInfo, String specialty) {
        this.trainerId = trainerId;
        this.subjects = subjects;
        this.contactInfo = contactInfo;
        this.specialty = specialty;
    }

    public Long getTrainerId() { return trainerId; }
    public String getSubjects() { return subjects; }
    public String getContactInfo() { return contactInfo; }
    public String getSpecialty() { return specialty; }
}
