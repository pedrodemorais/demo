package com.example.demo.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidades.Cliente;
import com.example.demo.repositories.UserRepository;

@Service
public class UsuarioServico {//Usuario na camada serviço dependerá do usuario na camada do repositorio
	
	@Autowired //injeção de dependencia
	private UserRepository repository;
	
	//metodo criado para trazer todos usuarios 
	public List<Cliente> retornarUsuario(){
		
		return repository.findAll();
	}
	
	public Cliente retornarPorId(Long id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.get();//o get vai retornar um obj Usuario
		
	}

}
