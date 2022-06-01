package com.example.demo.recursos.excecoes;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.servicos.excecoes.RecursoNaoEncontradoExcessoes;

@ControllerAdvice //interceptar as exceções que acontecerem
public class TratamentoManualDasExcecoes {
	
	@ExceptionHandler(RecursoNaoEncontradoExcessoes.class)
	public ResponseEntity<ErroPadrao> recursoNaoEncontrado(RecursoNaoEncontradoExcessoes e, HttpServletRequest request){
		String error = "Recurso nao Encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErroPadrao erroPadrao = new ErroPadrao(Instant.now(),status.value(), error, e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(erroPadrao);
	}

}
