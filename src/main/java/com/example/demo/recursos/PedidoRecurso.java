package com.example.demo.recursos;
//segundo a ser implementado
//para cada entidade criada , será craida uma classe resource para disponibilizar os recursos , os endpoints
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Pedido;
import com.example.demo.servicos.PedidoServico;


@RestController//informando que é um controlador
@RequestMapping(value="/pedidos")//endereco do recurso  
public class PedidoRecurso {
	
	@Autowired//Spring fazer injeção de dependencia
	private PedidoServico servico;
	
	
	@GetMapping//requisição do tipo Get
	public ResponseEntity<List<Pedido>> retornarUsuario(){//ResponseEntity é um tipo especifico no springboot que retorna 
		List<Pedido> list = servico.retornarPedido();   //resposta de requisição web
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")//informando que vai id no get
	public ResponseEntity<Pedido> retornarPorID(@PathVariable Long id){//@PathVariable fala para o spring que vai receber o ID por parametro
		Pedido usuario = servico.retornarPorId(id);
		return ResponseEntity.ok().body(usuario);
	}

}
