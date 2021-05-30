package br.com.mercadolivre.diploma.service;

import br.com.mercadolivre.diploma.dto.StudentDto;
import br.com.mercadolivre.diploma.dto.SubjectDto;
import br.com.mercadolivre.diploma.dto.UniversityDegreeDto;
import org.springframework.stereotype.Service;

@Service
public class UniversityDegreeService {

    public UniversityDegreeDto calculateGrade(StudentDto studentDto) {
        UniversityDegreeDto dto = new UniversityDegreeDto();
        dto.setName(studentDto.getName());
        StringBuilder message = new StringBuilder();


         studentDto.getSubjectDtos()
                 .stream()
                 .mapToDouble(SubjectDto::getGrade)
                 .average()
                 .ifPresent(value -> {
             if(value > 9){
                 message.append("Parabéns, sua média de nota foi: ");
             }

             message.append(value);

         });

         dto.setMessage(message.toString());
         return dto;
    }

}
