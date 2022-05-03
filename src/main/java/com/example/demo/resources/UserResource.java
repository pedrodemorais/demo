package com.example.demo.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Usuario;

@RestController
@RequestMapping(value="/usuario")
public class UserResource {
	@GetMapping
	public ResponseEntity<Usuario> retornarUsuario(){
		Usuario usuario = new Usuario(1L, "Pedro", "pedro@email.com", "33333333", "1234");
		return ResponseEntity.ok().body(usuario);
	}

}
