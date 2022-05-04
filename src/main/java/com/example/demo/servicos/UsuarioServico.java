package com.example.demo.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidades.Usuario;
import com.example.demo.repositories.UserRepository;

@Service
public class UsuarioServico {
	@Autowired
	private UserRepository repository;
	
	public List<Usuario> retornarUsuario(){
		
		return repository.findAll();
	}
	
	public Usuario retornarPorId(Long id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.get();
		
	}

}
