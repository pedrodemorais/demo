package com.example.demo.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Categoria;
import com.example.demo.entidades.Cliente;
import com.example.demo.servicos.ClienteServico;

@RestController//Os recursos fica na camada controle / essa anotation informa que o pacote é um controlador
@RequestMapping(value="/clientes")//endereco do recurso
public class ClienteRecurso {
	
	@Autowired//injeção de dependência
	private ClienteServico clienteServico; 
	
	@GetMapping//requisição do tipo get
	public ResponseEntity<List <Cliente>> retornaCategoria(){
		List<Cliente> list = clienteServico.retornarUsuario();
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity <Cliente> retornarPorId(@PathVariable Long id){
		Cliente cliente = clienteServico.retornarPorId(id);
		return ResponseEntity.ok().body(cliente);
		
	}
	
	

}
