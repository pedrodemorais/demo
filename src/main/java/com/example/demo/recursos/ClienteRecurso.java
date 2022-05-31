package com.example.demo.recursos;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entidades.Cliente;
import com.example.demo.servicos.ClienteServico;

@RestController//Os recursos fica na camada controle / essa anotation informa que o pacote é um controlador
@RequestMapping(value="/clientes")//endereco do recurso
public class ClienteRecurso {
	
	@Autowired//injeção de dependência
	private ClienteServico clienteServico; 
	
	
	@GetMapping//requisição do tipo get
	public ResponseEntity<List <Cliente>> retornaCategoria(){
		List<Cliente> list = clienteServico.retornarCliente();
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity <Cliente> retornarPorId(@PathVariable Long id){
		Cliente cliente = clienteServico.retornarClientePorId(id);
		return ResponseEntity.ok().body(cliente);
		
	}
	
	@PostMapping
	public ResponseEntity<Cliente> inserir (@RequestBody Cliente obj){
		obj= clienteServico.inserir(obj);
		URI uri= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		//comando para gerar o retorno 201
		return ResponseEntity.created(uri).body(obj);
		
		
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){//ResponseEntity VOID por não retornar nenhuma mensagem
		
		clienteServico.delete(id);
		return ResponseEntity.noContent().build();//noContent retorna uma resposta vazia, e mensagem sem corpo o codido é o 204 e ele 
												 //vai tratar isso também.
		
		
	}
	
	

}
