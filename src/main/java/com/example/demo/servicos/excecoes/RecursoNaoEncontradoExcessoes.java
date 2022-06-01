package com.example.demo.servicos.excecoes;

public class RecursoNaoEncontradoExcessoes extends RuntimeException{//copilador não obriga a tratar RuntimeExeption
	private static final long serialVersionUID = 1L;
	
	public RecursoNaoEncontradoExcessoes(Object id) {// id do objeto nao encontrado(Que gerou a exceção)
		super("Recurso nao encontrado - Nao Existe. Id "+id);
	}
	
	

}
