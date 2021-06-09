package br.com.mercadolivre.diploma.controller;

import br.com.mercadolivre.diploma.dto.StudentDto;
import br.com.mercadolivre.diploma.dto.UniversityDegreeDto;
import br.com.mercadolivre.diploma.service.UniversityDegreeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UniversityDegreeController {

    private UniversityDegreeService service;

    public UniversityDegreeController(UniversityDegreeService service) {
        this.service = service;
    }

    @PostMapping("/analyzeNotes")
    public ResponseEntity<UniversityDegreeDto> calculateGrade(@Valid @RequestBody StudentDto studentDto){
        UniversityDegreeDto universityDegreeDto = this.service.calculateGrade(studentDto);
        return new ResponseEntity<>(universityDegreeDto, HttpStatus.CREATED);
    }
}
