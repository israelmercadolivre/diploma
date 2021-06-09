package br.com.mercadolivre.diploma.controller;

import br.com.mercadolivre.diploma.dto.StudentDto;
import br.com.mercadolivre.diploma.dto.SubjectDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@SpringBootTest
@AutoConfigureMockMvc
class UniversityDegreeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldBeErrorWhenRequestWithNullValues() throws Exception {
        StudentDto dto = new StudentDto();

        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/analyzeNotes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(content().string(Matchers.containsString("Name must not be null")));
    }

    @Test
    public void shouldBeErrorWhenRequestWithSubjectsNull() throws Exception {
        StudentDto dto = new StudentDto();
        SubjectDto subjectDto = new SubjectDto();
        dto.setName("Evelyn");
        dto.setSubjects(Arrays.asList(subjectDto));
        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/analyzeNotes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(content().string(Matchers.containsString("Name of subject must not be null")));
    }

    @Test
    public void shouldBeErrorWhenRequestWithInvalidValues() throws Exception {
        StudentDto dto = new StudentDto();
        SubjectDto subjectDto = new SubjectDto();
        SubjectDto subjectDto2 = new SubjectDto();
        subjectDto.setSubject("Mat");
        subjectDto.setNote(11d);
        subjectDto2.setSubject("Port");
        subjectDto2.setNote(-1d);
        dto.setName("Evelyn");
        dto.setSubjects(Arrays.asList(subjectDto, subjectDto2));
        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/analyzeNotes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(content().string(Matchers.containsString("The name of subject must have a minimum length of 8 characters and a maximum length of 50")))
                .andExpect(content().string(Matchers.containsString("The note of subject must have a maximum length of 10")))
                .andExpect(content().string(Matchers.containsString("The note of subject must have a minimum length of 0")));
    }

}