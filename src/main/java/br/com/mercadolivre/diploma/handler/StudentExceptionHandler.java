package br.com.mercadolivre.diploma.handler;

import br.com.mercadolivre.diploma.exception.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class StudentExceptionHandler {
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorMessage> getExceptions(MethodArgumentNotValidException e, WebRequest request) {

        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        ErrorMessage messageError = new ErrorMessage(
                HttpStatus.BAD_REQUEST,
                LocalDate.now(),
                errors,
                request.getDescription(false));
        return new ResponseEntity<>(messageError, HttpStatus.BAD_REQUEST);
    }
}
