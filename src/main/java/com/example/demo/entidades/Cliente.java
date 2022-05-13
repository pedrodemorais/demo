//primeiro cria-se as entidades
package com.example.demo.entidades;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//mapeamento do jpa 
@Entity
public class Cliente implements Serializable {//serializable é uma interface que serve para trafegar dados do objeto na rede
	private static final long serialVersionUID = 1L;
	
	@Id//falando para o jpa qual atributo será a chave primaria no banco
	@GeneratedValue(strategy=GenerationType.IDENTITY)//falando para o jpa que o id será autoincremento no banco
	private Long id;
	


	private String nome;
	private String email;
	private String telefone;
	private String senha;
	
	@OneToMany(mappedBy = "cliente")
	private List <Pedido> pedido = new ArrayList<>();
	
	//por estar usando framework é obrigado a usar construtor vazio
	public Cliente() {
		
	}
	
	//construtor colocado por conveniencia
	public Cliente(Long id, String nome, String email, String telefone, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public List<Pedido> getPedido() {
		return pedido;
	}

	//pode ser colocado qualquer campo para comparar , depende da necessidade
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	

}
