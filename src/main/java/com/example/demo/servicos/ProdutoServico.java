package com.example.demo.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidades.Produto;
import com.example.demo.repositorios.ProdutoRepositorio;
import com.example.demo.servicos.excecoes.RecursoNaoEncontradoExcessoes;

@Service//registrando como um componente do spring 
public class ProdutoServico {
	
	@Autowired //injeção de dependencia
	private ProdutoRepositorio produtoRepositorio;
	
	//metodo criado para trazer todos os pedidos 
	public List<Produto> retornarProduto(){
		return produtoRepositorio.findAll();
	}
	
	//metodo que traz um cliente por id
	public Produto retornarPorId(Long id) {
		Optional<Produto> obj = produtoRepositorio.findById(id);
	//	return obj.get();//o get vai retornar um obj pedido
		return obj.orElseThrow(() -> new RecursoNaoEncontradoExcessoes(id) );
		
	}

}
