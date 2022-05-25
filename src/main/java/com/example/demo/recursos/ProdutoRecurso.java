package com.example.demo.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Produto;
import com.example.demo.servicos.ProdutoServico;

@RestController//Os recursos fica na camada controle / essa anotation informa que o pacote é um controlador
@RequestMapping(value="/produtos")//endereco do recurso
public class ProdutoRecurso {
	
	@Autowired//injeção de dependência
	private ProdutoServico categoriaServico; 
	
	@GetMapping//requisição do tipo get
	public ResponseEntity<List <Produto>> retornaProduto(){
		List<Produto> list = categoriaServico.retornarProduto();
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity <Produto> retornarPorId(@PathVariable Long id){
		Produto categoria = categoriaServico.retornarPorId(id);
		return ResponseEntity.ok().body(categoria);
		
	}
	
	

}
