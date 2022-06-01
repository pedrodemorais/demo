package com.example.demo.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidades.Cliente;
import com.example.demo.repositorios.ClienteRepositorio;
import com.example.demo.servicos.excecoes.RecursoNaoEncontradoExcessoes;

@Service//registrando como um componente do spring 
public class ClienteServico {//Usuario na camada serviço dependerá do usuario na camada do repositorio
	
	@Autowired //injeção de dependencia
	private ClienteRepositorio clienteRepositorio;
	
	//metodo criado para trazer todos usuarios 
	public List<Cliente> retornarCliente(){
		return clienteRepositorio.findAll();
	}
	
	//metodo que traz um cliente por id
	public Cliente retornarClientePorId(Long id) {
		Optional<Cliente> obj = clienteRepositorio.findById(id);
		//return obj.get();//o get vai retornar um obj Usuario
		return obj.orElseThrow(() -> new RecursoNaoEncontradoExcessoes(id));
		
	}
	//metodo insert
	public Cliente insert(Cliente obj) {
		return clienteRepositorio.save(obj);
		
		
	}
	//metodo delete
	public void delete (Long id) {
		clienteRepositorio.deleteById(id);
		
	}
	
	public Cliente update(Long id, Cliente obj) {
		Cliente entidade = clienteRepositorio.getOne(id);
		updateCliente(entidade, obj);
		return clienteRepositorio.save(entidade);
		
	}

	private void updateCliente(Cliente entidade, Cliente obj) {
		entidade.setNome(obj.getNome());
		entidade.setEmail(obj.getEmail());
		entidade.setTelefone(obj.getTelefone());
		
		
	}

}
