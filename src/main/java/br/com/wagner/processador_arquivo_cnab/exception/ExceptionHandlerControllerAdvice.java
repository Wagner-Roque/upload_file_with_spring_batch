package br.com.wagner.processador_arquivo_cnab.exception;

import org.springframework.batch.core.launch.JobInstanceAlreadyExistsException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {
    @ExceptionHandler(JobInstanceAlreadyCompleteException.class)
    private ResponseEntity<Object> handleFileAlreadyImported(JobInstanceAlreadyExistsException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body("The file already imported in system!");
    }
}
