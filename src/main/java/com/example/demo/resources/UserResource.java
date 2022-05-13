package com.example.demo.resources;
//segundo a ser implementado
//para cada entidade criada , será craida uma classe resource para disponibilizar os recursos , os endpoints
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Cliente;
import com.example.demo.servicos.UsuarioServico;


@RestController//informando que é um controlador
@RequestMapping(value="/usuario")//endereco do recurso  
public class UserResource {
	
	@Autowired//Spring fazer injeção de dependencia
	private UsuarioServico servico;
	
	
	@GetMapping//requisição do tipo Get
	public ResponseEntity<List<Cliente>> retornarUsuario(){//ResponseEntity é um tipo especifico no springboot que retorna 
		List<Cliente> list = servico.retornarUsuario();   //resposta de requisição web
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")//informando que vai id no get
	public ResponseEntity<Cliente> retornarPorID(@PathVariable Long id){//@PathVariable fala para o spring que vai receber o ID por parametro
		Cliente usuario = servico.retornarPorId(id);
		return ResponseEntity.ok().body(usuario);
	}

}
