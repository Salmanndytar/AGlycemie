package com.ndytar.aglycemie.handler;

//import com.flickr4java.flickr.FlickrException;
import com.ndytar.aglycemie.exception.*;
import lombok.Builder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.oauth2.jwt.JwtValidationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Collections;
import java.util.Objects;

@Builder
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDto> handlerException(EntityNotFoundException exception) {
        final HttpStatus notFound = HttpStatus.NOT_FOUND;
        
        final ErrorDto errorDto = ErrorDto.builder()
                .code(exception.getErrorCodes())
                .httpCode(notFound.value())
                .message(exception.getMessage())
                .build();
        return new ResponseEntity<>(errorDto, notFound);
    }

    @ExceptionHandler(InvalidEntityException.class)
    public ResponseEntity<ErrorDto> handlerException(InvalidEntityException exception) {
        final HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        final ErrorDto errorDto = ErrorDto.builder()
                .code(exception.getErrorCodes())
                .httpCode(badRequest.value())
                .message(exception.getMessage())
                .errors(exception.getErrors())
                .build();
        return new ResponseEntity<>(errorDto, badRequest);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorDto> handlerException(BadCredentialsException exception) {
        final HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        final ErrorDto errorDto = ErrorDto.builder()
                .code(ErrorCodes.BAD_CREDENTIALS)
                .httpCode(badRequest.value())
                .message(exception.getMessage())
                .errors(Collections.singletonList("Mot de passe incorrecte"))
                .build();
        return new ResponseEntity<>(errorDto, badRequest);
    }

    /***  Exception d'accès aux données de résultat vide*  a l'exemple de suppression avec un id qui n'existe pas***/
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<ErrorDto> handlerException(EmptyResultDataAccessException exception) {
        final HttpStatus acceptable = HttpStatus.NOT_ACCEPTABLE;
        final ErrorDto errorDto = ErrorDto.builder()
                .code(ErrorCodes.EMPTY_RESULT)
                .httpCode(acceptable.value())
                .message(Objects.requireNonNull(exception.getMessage()).substring(58))
                .errors(Collections.singletonList("Les donnees fournis non acceptabes"))
                .build();
        return new ResponseEntity<>(errorDto, acceptable);
    }

    @ExceptionHandler(InvalidOperationException.class)
    public ResponseEntity<ErrorDto> handlerException(InvalidOperationException exception) {
        final HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        final ErrorDto errorDto = ErrorDto.builder()
                .code(exception.getErrorCodes())
                .httpCode(badRequest.value())
                .message(exception.getMessage())
                .errors(exception.getErrors())
                .build();
        return new ResponseEntity<>(errorDto, badRequest);
    }
    
    @ExceptionHandler(  JwtValidationException.class)
    public ResponseEntity<ErrorDto> handlerException(  JwtValidationException exception) {
        final HttpStatus badRequest = HttpStatus.NON_AUTHORITATIVE_INFORMATION;
        final ErrorDto errorDto = ErrorDto.builder()
                .code(ErrorCodes.EXPIRED_JWT)
                .httpCode(badRequest.value())
                .message(exception.getMessage())
                .errors(Collections.singletonList("Reauthentification"))
                .build();
        return new ResponseEntity<>(errorDto, badRequest);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDto> handlerException(IllegalArgumentException exception) {
        final HttpStatus badRequest = HttpStatus.NOT_ACCEPTABLE;
        final ErrorDto errorDto = ErrorDto.builder()
                .httpCode(badRequest.value())
                .code(ErrorCodes.NOT_ACCEPTABLE)
                .message(exception.getMessage())
                .errors(Collections.singletonList("Le parametre n'est pas acceptable"))
                .build();
        return new ResponseEntity<>(errorDto, badRequest);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ErrorDto> handlerException(SQLIntegrityConstraintViolationException exception) {
        final HttpStatus badRequest = HttpStatus.NOT_ACCEPTABLE;
        final ErrorDto errorDto = ErrorDto.builder()
                .httpCode(badRequest.value())
                .code(ErrorCodes.NOT_ACCEPTABLE)
                .message(exception.getMessage())
                .errors(Collections.singletonList("Reasisir une autre valeur"))
                .build();
        return new ResponseEntity<>(errorDto, badRequest);
    }

//    @ExceptionHandler(FlickrException.class)
//    public ResponseEntity<ErrorDto> handlerException(FlickrException exception, WebRequest webRequest) {
//        final HttpStatus badRequest = HttpStatus.NOT_ACCEPTABLE;
//        final ErrorDto errorDto = ErrorDto.builder()
//                .httpCode(badRequest.value())
//                .code(ErrorCodes.NOT_ACCEPTABLE)
//                .message(exception.getMessage())
//                .errors(Collections.singletonList("Impossible de charger l'image"))
//                .build();
//        return new ResponseEntity<>(errorDto, badRequest);
//    }
    @ExceptionHandler(SocketTimeoutException.class)
    public ResponseEntity<ErrorDto> handlerException(SocketTimeoutException exception) {
        final HttpStatus badRequest = HttpStatus.GATEWAY_TIMEOUT;
        final ErrorDto errorDto = ErrorDto.builder()
                .httpCode(badRequest.value())
                .code(ErrorCodes.LIMITE_ATTEND_CONN_SMTP)
                .message(exception.getMessage())
                .errors(Collections.singletonList("L'accés au serveur messagerie smtp a pris trop de tems,veuillez ressayez "))
                .build();
        return new ResponseEntity<>(errorDto, badRequest);
    }
    @ExceptionHandler(SocketException.class)
        public ResponseEntity<ErrorDto> handlerException(SocketException exception) {
        final HttpStatus badRequest = HttpStatus.INSUFFICIENT_STORAGE;
        final ErrorDto errorDto = ErrorDto.builder()
                .httpCode(badRequest.value())
                .code(ErrorCodes.CONNECTION_PROBLEM)
                .message(exception.getMessage())
                .errors(Collections.singletonList("L'accés au serveur messagerie smtp a pris trop de tems,veuillez ressayez "))
                .build();
        return new ResponseEntity<>(errorDto, badRequest);

    }
    @ExceptionHandler(SMTPSendFailedExceptions.class)
    public ResponseEntity<ErrorDto> handlerException(SMTPSendFailedExceptions exception) {
        final HttpStatus badRequest = HttpStatus.INSUFFICIENT_STORAGE;
        final ErrorDto errorDto = ErrorDto.builder()
                .httpCode(badRequest.value())
                .code(ErrorCodes.SMTP_OPERATION_NOT_SUCCESS)
                .message(exception.getMessage())
                .errors(Collections.singletonList("Veuillez reessayez plustart"))
                .build();
        return new ResponseEntity<>(errorDto, badRequest);
    }
    @ExceptionHandler(UnknownHostException.class)
    public ResponseEntity<ErrorDto> handlerException(UnknownHostException exception) {
        final HttpStatus badRequest = HttpStatus.INSUFFICIENT_STORAGE;
        final ErrorDto errorDto = ErrorDto.builder()
                .httpCode(badRequest.value())
                .code(ErrorCodes.SMTP_OPERATION_NOT_SUCCESS)
                .message(exception.getMessage())
                .errors(Collections.singletonList("Veuillez ressayez plutart"))
                .build();
        return new ResponseEntity<>(errorDto, badRequest);
    }
}