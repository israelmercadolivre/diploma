package br.com.mercadolivre.diploma.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.util.List;
@Data
public class StudentDto {
    private String name;
    @JsonAlias("subject")
    private List<SubjectDto> subjectDtos;
}
