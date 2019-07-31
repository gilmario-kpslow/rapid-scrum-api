/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rapidscrum.rapidscrum;

import br.com.rapidscrum.rapidscrum.core.exception.MensagemException;
import br.com.rapidscrum.rapidscrum.core.exception.StatusMensagem;
import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author gilmario
 */
@ControllerAdvice
public class ResourceExcptionInterceptor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<MensagemException> handleUserNotFoundException(ConstraintViolationException ex, WebRequest request) {
        MensagemException errorDetails = new MensagemException(ex.getMessage(), request.getDescription(false), StatusMensagem.ERRO);
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<MensagemException> exception(Exception ex, WebRequest request) {
        MensagemException errorDetails = new MensagemException(ex.getMessage(), request.getDescription(false), StatusMensagem.ERRO);
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

}
