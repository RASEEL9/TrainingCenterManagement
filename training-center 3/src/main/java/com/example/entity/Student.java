package com.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = true)
    private String studentDegree;

    // ✅ No-Args Constructor
    public Student() {}

    // ✅ All-Args Constructor
    public Student(Long id, String name, String email, String studentDegree) {
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
