package com.example.demo.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidades.Pedido;
import com.example.demo.repositorios.PedidoRepositorio;

@Service//registrando como um componente do spring 
public class PedidoServico {
	
	@Autowired //injeção de dependencia
	private PedidoRepositorio usuarioRepositorio;
	
	//metodo criado para trazer todos os pedidos 
	public List<Pedido> retornarPedido(){
		return usuarioRepositorio.findAll();
	}
	
	//metodo que traz um cliente por id
	public Pedido retornarPorId(Long id) {
		Optional<Pedido> obj = usuarioRepositorio.findById(id);
		return obj.get();//o get vai retornar um obj pedido
		
	}

}
