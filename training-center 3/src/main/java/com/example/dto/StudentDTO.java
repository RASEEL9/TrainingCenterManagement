package com.example.dto;

public class StudentDTO {
    private Long id;
    private String name;
    private String email;
    private String studentDegree;

    // ✅ No-Args Constructor
    public StudentDTO() {}

    // ✅ All-Args Constructor
    public StudentDTO(Long id, String name, String email, String studentDegree) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.studentDegree = studentDegree;
    }

    // ✅ Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getStudentDegree() { return studentDegree; }
    public void setStudentDegree(String studentDegree) { this.studentDegree = studentDegree; }
}
