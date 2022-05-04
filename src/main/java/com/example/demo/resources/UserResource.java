package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Usuario;
import com.example.demo.servicos.UsuarioServico;

@RestController
@RequestMapping(value="/usuario")
public class UserResource {
	
	@Autowired//Spring fazer injeção de dependencia
	private UsuarioServico servico;
	
	
	@GetMapping//requisição do tipo Get
	public ResponseEntity<List<Usuario>> retornarUsuario(){
		List<Usuario> list = servico.retornarUsuario();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> retornarPorID(@PathVariable Long id){
		Usuario usuario = servico.retornarPorId(id);
		return ResponseEntity.ok().body(usuario);
	}

}
