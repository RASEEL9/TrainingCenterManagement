package com.example.dto;

public class PaymentDTO {
    private Long paymentId;
    private String studentDegree;
    private String courseName;
    private String dateOfPayment;
    private String paymentMethods;
    private String paymentState;

    // ✅ No-Args Constructor
    public PaymentDTO() {}

    // ✅ All-Args Constructor
    public PaymentDTO(Long paymentId, String studentDegree, String courseName, String dateOfPayment, String paymentMethods, String paymentState) {
        this.paymentId = paymentId;
        this.studentDegree = studentDegree;
        this.courseName = courseName;
        this.dateOfPayment = dateOfPayment;
        this.paymentMethods = paymentMethods;
        this.paymentState = paymentState;
    }

    // ✅ Getters and Setters
    public Long getPaymentId() { return paymentId; }
    public void setPaymentId(Long paymentId) { this.paymentId = paymentId; }

    public String getStudentDegree() { return studentDegree; }
    public void setStudentDegree(String studentDegree) { this.studentDegree = studentDegree; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public String getDateOfPayment() { return dateOfPayment; }
    public void setDateOfPayment(String dateOfPayment) { this.dateOfPayment = dateOfPayment; }

    public String getPaymentMethods() { return paymentMethods; }
    public void setPaymentMethods(String paymentMethods) { this.paymentMethods = paymentMethods; }

    public String getPaymentState() { return paymentState; }
    public void setPaymentState(String paymentState) { this.paymentState = paymentState; }
}
