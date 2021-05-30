package br.com.mercadolivre.diploma.controller;

import br.com.mercadolivre.diploma.dto.StudentDto;
import br.com.mercadolivre.diploma.dto.UniversityDegreeDto;
import br.com.mercadolivre.diploma.service.UniversityDegreeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/diplomas")
public class UniversityDegreeController {

    private UniversityDegreeService service;

    public UniversityDegreeController(UniversityDegreeService service) {
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity<UniversityDegreeDto> calculateGrade(@RequestBody StudentDto studentDto){
        UniversityDegreeDto universityDegreeDto = this.service.calculateGrade(studentDto);
        return ResponseEntity.ok().body(universityDegreeDto);
    }
}
