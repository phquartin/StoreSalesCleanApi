package dev.phquartin.storesalescleanapi.infra.configuration;

import dev.phquartin.storesalescleanapi.infra.presentation.response.ErroResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Log4j2
@RestControllerAdvice
public class GlobalHandlerException {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy --- HH:mm:ss");

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroResponse> handleException(Exception exception, HttpServletRequest request) {
        log.error(exception.getClass());
        ErroResponse erro = ErroResponse.builder()
                .message(exception.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .path(request.getRequestURI())
                .timestamp(LocalDateTime.now().format(formatter))
                .build();
        return ResponseEntity.status(erro.status()).body(erro);
    }

    @ExceptionHandler(org.springframework.dao.DataIntegrityViolationException.class)
    public ResponseEntity<ErroResponse> handleConstraintViolationException(DataIntegrityViolationException exception, HttpServletRequest request) {
        ErroResponse erro = ErroResponse.builder()
                .message(exception.getMessage())
                .status(HttpStatus.CONFLICT)
                .path(request.getRequestURI())
                .timestamp(LocalDateTime.now().format(formatter))
                .build();
        return ResponseEntity.status(erro.status()).body(erro);
    }

    @ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
    public ResponseEntity<ErroResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception, HttpServletRequest request) {
        String messageErros = exception.getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList()
                .toString();
        ErroResponse erro = ErroResponse.builder()
                .message(messageErros)
                .status(HttpStatus.BAD_REQUEST)
                .path(request.getRequestURI())
                .timestamp(LocalDateTime.now().format(formatter))
                .build();
        return ResponseEntity.status(erro.status()).body(erro);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErroResponse> handleIllegalArgumentException(IllegalArgumentException exception, HttpServletRequest request){
        ErroResponse erro = ErroResponse.builder()
                .message(exception.getMessage())
                .status(HttpStatus.BAD_REQUEST)
                .path(request.getRequestURI())
                .timestamp(LocalDateTime.now().format(formatter))
                .build();
        return ResponseEntity.status(erro.status()).body(erro);
    }

}
