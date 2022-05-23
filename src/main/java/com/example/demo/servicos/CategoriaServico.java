package com.example.demo.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidades.Categoria;
import com.example.demo.repositorios.CategoriaRepositorio;

@Service

public class CategoriaServico {
	
	@Autowired//injeção de dependencia
	private CategoriaRepositorio categoriaRepositorio;
	
	
	//metodo criado para listar todas as categorias
	public List<Categoria> retornarCategorias(){
		return categoriaRepositorio.findAll();
		
	}
	
	//metodo que traz uma categoria por Id
	public Categoria retornarPorId(Long id) {
		Optional<Categoria> obj =categoriaRepositorio.findById(id);
		return obj.get();
		
	}
	

}
