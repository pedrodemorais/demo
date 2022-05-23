//essa classe nao faz parte dos pacotes do modelo de camadas, ela apenas é uma classe auxiliar
//para fazer algumas configurações e popular o banco de dados com alguns objetos
package com.example.demo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.demo.entidades.Categoria;
import com.example.demo.entidades.Cliente;
import com.example.demo.entidades.Pedido;
import com.example.demo.entidades.enums.StatusDoPedido;
import com.example.demo.repositorios.CategoriaRepositorio;
import com.example.demo.repositorios.PedidoRepositorio;
import com.example.demo.repositorios.UsuarioRepositorio;


@Configuration //annotation @Configuration do sppring avisando que é uma classe de configuração
//annotation @Profile("test") serve para indicar ai spring quando ele irá usar essa configuração,
//nesse caso usará essas configurações quando tiver no perfil test definido no application.properties
@Profile("test")
//o nome é TestCOnfig porque é exatamente uma classe de configuração especifica para o perfil teste
public class TestConfig implements CommandLineRunner {//implements CommandLineRunner serve para executar a classe quando o sistema for iniciado
	
	
	@Autowired//annotation para que o spring boot resolva a dependencia e atribua userRepository a TestConfig
	private UsuarioRepositorio userRepositorio;//declarando uma dependencia
	
	@Autowired
	private PedidoRepositorio pedidoRepositorio;
	
	@Autowired
	private CategoriaRepositorio categoriaRepositorio;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Categoria cat = new Categoria(null, "Informatica");
		Categoria cat1 = new Categoria(null, "Seguranca");
		Categoria cat2 = new Categoria(null, "Eletronica");
		
		Cliente u1 = new Cliente(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Cliente u2 = new Cliente(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		Cliente u3 = new Cliente(null, "dorim", "dorim@gmail.com", "66666666666", "123456");
		
		Pedido pedido = new Pedido(null, Instant.parse("2019-11-11T23:05:10Z"), StatusDoPedido.PAGO, u3);
		Pedido pedido2 = new Pedido(null, Instant.parse("2019-09-11T23:05:10Z"),StatusDoPedido.ENVIADO, u2);
		Pedido pedido3 = new Pedido(null, Instant.parse("2019-09-11T23:05:10Z"),StatusDoPedido.ENVIADO, u2);
		Pedido pedido4 = new Pedido(null, Instant.parse("2019-09-11T23:05:10Z"),StatusDoPedido.CANCELADO, u2);
		
		
		
		//chamando a classe userRepository com o metodo saveAll criando um array de objeto para salvar no banco
		userRepositorio.saveAll(Arrays.asList(u1,u2,u3));
		pedidoRepositorio.saveAll(Arrays.asList(pedido, pedido2,pedido3,pedido4));
		categoriaRepositorio.saveAll(Arrays.asList(cat,cat1,cat2));
		
	}
	

}
