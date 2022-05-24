package com.example.demo.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidades.Cliente;
import com.example.demo.repositorios.ClienteRepositorio;

@Service//registrando como um componente do spring 
public class ClienteServico {//Usuario na camada serviço dependerá do usuario na camada do repositorio
	
	@Autowired //injeção de dependencia
	private ClienteRepositorio usuarioRepositorio;
	
	//metodo criado para trazer todos usuarios 
	public List<Cliente> retornarUsuario(){
		return usuarioRepositorio.findAll();
	}
	
	//metodo que traz um cliente por id
	public Cliente retornarPorId(Long id) {
		Optional<Cliente> obj = usuarioRepositorio.findById(id);
		return obj.get();//o get vai retornar um obj Usuario
		
	}

}
