package br.com.mercadolivre.diploma.dto;


import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Validated
public class StudentDto {
    @NotNull(message = "Name must not be null")
    @Size(min = 6, max = 50, message = "The name must have a minimum length of 6 characters and a maximum length of 50")
    @Pattern(regexp = "^[A-Za-z ]*$", message = "The name must have just letter")
    private String name;
    @Valid
    private List<SubjectDto> subjects;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubjectDto> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectDto> subjects) {
        this.subjects = subjects;
    }
}
