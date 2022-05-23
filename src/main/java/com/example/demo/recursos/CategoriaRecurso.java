package com.example.demo.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Categoria;
import com.example.demo.servicos.CategoriaServico;

@RestController//Os recursos fica na camada controle / essa anotation informa que o pacote é um controlador
@RequestMapping(value="/categorias")//endereco do recurso
public class CategoriaRecurso {
	
	@Autowired//injeção de dependência
	private CategoriaServico categoriaServico; 
	
	@GetMapping//requisição do tipo get
	public ResponseEntity<List <Categoria>> retornaCategoria(){
		List<Categoria> list = categoriaServico.retornarCategorias();
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity <Categoria> retornarPorId(@PathVariable Long id){
		Categoria categoria = categoriaServico.retornarPorId(id);
		return ResponseEntity.ok().body(categoria);
		
	}
	
	

}
