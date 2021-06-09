package br.com.mercadolivre.diploma.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder(value = {"message", "average", "student"})
public class UniversityDegreeDto {
    private String message;
    private Double average;
    private StudentDto student;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public StudentDto getStudent() {
        return student;
    }

    public void setStudent(StudentDto student) {
        this.student = student;
    }
}
