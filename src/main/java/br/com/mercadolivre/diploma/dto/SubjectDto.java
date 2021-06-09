package br.com.mercadolivre.diploma.dto;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

@Validated
public class SubjectDto {
    @NotNull(message = "Name of subject must not be null")
    @Size(min = 8, max = 50, message = "The name of subject must have a minimum length of 3 characters and a maximum length of 50")
    @Pattern(regexp = "^[A-Za-z ]*$", message = "The name of subject must have just letter")
    private String subject;
    @Min(value = 0, message = "The name of subject must have a minimum length of 0")
    @Max(value = 10, message = "The name of subject must have a maximum length of 10")
    private Double note;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Double getNote() {
        return note;
    }

    public void setNote(Double note) {
        this.note = note;
    }
}
