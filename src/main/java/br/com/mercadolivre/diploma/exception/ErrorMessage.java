package br.com.mercadolivre.diploma.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.util.Map;

@Data
@AllArgsConstructor
public class ErrorMessage {
    private HttpStatus status;
    private LocalDate date;
    private Map<String, String> message;
    private String description;
}
