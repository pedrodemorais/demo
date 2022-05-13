//essa classe nao faz parte dos pacotes do modelo de camadas, ela apenas é uma classe auxiliar
//para fazer algumas configurações e popular o banco de dados com alguns objetos
package com.example.demo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.demo.entidades.Usuario;
import com.example.demo.repositories.UserRepository;


@Configuration //annotation @Configuration do sppring avisando que é uma classe de configuração
//annotation @Profile("test") serve para indicar ai spring quando ele irá usar essa configuração,
//nesse caso usará essas configurações quando tiver no perfil test definido no application.properties
@Profile("test")
//o nome é TestCOnfig porque é exatamente uma classe de configuração especifica para o perfil teste
public class TestConfig implements CommandLineRunner {//implements CommandLineRunner serve para executar a classe quando o sistema for iniciado
	
	
	@Autowired//annotation para que o spring boot resolva a dependencia e atribua userRepository a TestConfig
	private UserRepository userRepository;//declarando uma dependencia

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		Usuario u3 = new Usuario(null, "dorim", "dorim@gmail.com", "66666666666", "123456");
		
		//chamando a classe userRepository com o metodo saveAll criando um array de objeto para salvar no banco
		userRepository.saveAll(Arrays.asList(u1,u2,u3));
	}
	

}
