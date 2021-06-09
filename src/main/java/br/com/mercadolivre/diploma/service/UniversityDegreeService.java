package br.com.mercadolivre.diploma.service;

import br.com.mercadolivre.diploma.dto.StudentDto;
import br.com.mercadolivre.diploma.dto.SubjectDto;
import br.com.mercadolivre.diploma.dto.UniversityDegreeDto;
import org.springframework.stereotype.Service;

@Service
public class UniversityDegreeService {

    public UniversityDegreeDto calculateGrade(StudentDto studentDto) {
        UniversityDegreeDto dto = new UniversityDegreeDto();
        dto.setStudent(studentDto);
        StringBuilder message = new StringBuilder();


         dto.setAverage(studentDto.getSubjects()
                 .stream()
                 .mapToDouble(SubjectDto::getNote)
                 .average().getAsDouble());

             if(dto.getAverage() > 9){
                 message.append("Congratulation, your average is: "+dto.getAverage());
             }

         dto.setMessage(message.toString());
         return dto;
    }

}
