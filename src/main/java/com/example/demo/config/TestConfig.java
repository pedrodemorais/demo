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
import com.example.demo.entidades.ItemPedido;
import com.example.demo.entidades.Pagamento;
import com.example.demo.entidades.Pedido;
import com.example.demo.entidades.Produto;
import com.example.demo.entidades.enums.StatusDoPedido;
import com.example.demo.repositorios.CategoriaRepositorio;
import com.example.demo.repositorios.ClienteRepositorio;
import com.example.demo.repositorios.ItemPedidoRepositorio;
import com.example.demo.repositorios.PedidoRepositorio;
import com.example.demo.repositorios.ProdutoRepositorio;


@Configuration //annotation @Configuration do sppring avisando que é uma classe de configuração
//annotation @Profile("test") serve para indicar ai spring quando ele irá usar essa configuração,
//nesse caso usará essas configurações quando tiver no perfil test definido no application.properties
@Profile("test")
//o nome é TestCOnfig porque é exatamente uma classe de configuração especifica para o perfil teste
public class TestConfig implements CommandLineRunner {//implements CommandLineRunner serve para executar a classe quando o sistema for iniciado
	
	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	
	@Autowired//annotation para que o spring boot resolva a dependencia e atribua userRepository a TestConfig
	private ClienteRepositorio userRepositorio;//declarando uma dependencia
	
	@Autowired
	private PedidoRepositorio pedidoRepositorio;
	
	@Autowired
	private ProdutoRepositorio produtoRepositorio;
	
	@Autowired
	private ItemPedidoRepositorio itemPedidoRepositorio;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Categoria cat1= new Categoria(null, "Eletronicos");
		Categoria cat2 = new Categoria(null, "Livros");
	    Categoria cat3 = new Categoria(null, "Computadores");
		
		Produto p1 = new Produto(null, "O senhor dos Aneis", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
		Produto p2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		Produto p3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		Produto p4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		Produto p5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		//chamando a classe userRepository com o metodo saveAll criando um array de objeto 
		//para salvar no banco
		categoriaRepositorio.saveAll(Arrays.asList(cat1,cat2,cat3));
		produtoRepositorio.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		p1.getCategorias().add(cat2);
		p2.getCategorias().add(cat1);
		p2.getCategorias().add(cat3);
		p3.getCategorias().add(cat3);
		p4.getCategorias().add(cat3);
		p5.getCategorias().add(cat2);
		
		produtoRepositorio.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		
		
		
		Cliente u1 = new Cliente(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Cliente u2 = new Cliente(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		Cliente u3 = new Cliente(null, "dorim", "dorim@gmail.com", "66666666666", "123456");
		
		Pedido pedido = new Pedido(null, Instant.parse("2019-11-11T23:05:10Z"), StatusDoPedido.PAGO, u3);
		Pedido pedido2 = new Pedido(null, Instant.parse("2019-09-11T23:05:10Z"),StatusDoPedido.ENVIADO, u2);
		Pedido pedido3 = new Pedido(null, Instant.parse("2019-09-11T23:05:10Z"),StatusDoPedido.ENVIADO, u2);
		Pedido pedido4 = new Pedido(null, Instant.parse("2019-09-11T23:05:10Z"),StatusDoPedido.CANCELADO, u2);
		
		
		
		//chamando a classe userRepository com o metodo saveAll criando um array de objeto 
		//para salvar no banco
		userRepositorio.saveAll(Arrays.asList(u1,u2,u3));
		pedidoRepositorio.saveAll(Arrays.asList(pedido, pedido2,pedido3,pedido4));
		
		ItemPedido item1 = new ItemPedido(pedido,p1,2,p1.getPreco());
		ItemPedido item2 = new ItemPedido(pedido,p3,1,p3.getPreco());
		ItemPedido item3 = new ItemPedido(pedido2,p3,2,p3.getPreco());
		ItemPedido item4 = new ItemPedido(pedido3,p5,2,p5.getPreco());
		
		itemPedidoRepositorio.saveAll(Arrays.asList(item1,item2,item3,item4));
		
		Pagamento pagto1 = new Pagamento(null, Instant.parse("2019-11-11T23:45:10Z"), pedido);
		pedido.setPagamento(pagto1);// nesse caso que é de um para um não chama a classe do pagamento e sim do pedido
		pedidoRepositorio.save(pedido);
		
	}
	

}
