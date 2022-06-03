package com.example.demo.recursos.excecoes;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.servicos.excecoes.ExcessaoDeBancoDeDados;
import com.example.demo.servicos.excecoes.RecursoNaoEncontradoExcessoes;

@ControllerAdvice //interceptar as exceções que acontecerem
public class TratamentoManualDasExcecoes {
	
	@ExceptionHandler(RecursoNaoEncontradoExcessoes.class)
	public ResponseEntity<ErroPadrao> recursoNaoEncontrado(RecursoNaoEncontradoExcessoes e, HttpServletRequest request){
		String error = "Recurso nao Encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		//HttpStatus status1 = HttpStatus.NO_CONTENT;
		
//		ErroPadrao erroPadrao = new ErroPadrao(Instant.now(),status1.value(), error, e.getMessage(),request.getRequestURI());
		ErroPadrao erroPadrao = new ErroPadrao(Instant.now(),status.value(), error, e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(erroPadrao);
	}
	
	@ExceptionHandler(ExcessaoDeBancoDeDados.class)
	public ResponseEntity<ErroPadrao> excessaoBandoDeDados(ExcessaoDeBancoDeDados e, HttpServletRequest request){
		String error = "Erro no Banco de Dados";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		//HttpStatus status1 = HttpStatus.NO_CONTENT;
		
//		ErroPadrao erroPadrao = new ErroPadrao(Instant.now(),status1.value(), error, e.getMessage(),request.getRequestURI());
		ErroPadrao erroPadrao = new ErroPadrao(Instant.now(),status.value(), error, e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(erroPadrao);
	}

}
