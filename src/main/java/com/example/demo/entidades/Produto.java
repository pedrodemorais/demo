package com.example.demo.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="produto")
public class Produto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String descricao;
	private Double preco;
	private String imgUrl;
	
	//criando tabela auxiliar da associação de muitos para muitos
	@ManyToMany
	
	//name = escolhendo o nome da tabela
	//joinColumns = @JoinColumn(name="produto_id") --- atribuindo a chave estrangeira referente a tabela de PRODUTO
	//inverseJoinColumns = @JoinColumn(name = "categoria_id") -- Atribuindo nome da chave estrangeira da outra tabela 
	@JoinTable(name = "produto_categoria", joinColumns = @JoinColumn(name="produto_id"),
	inverseJoinColumns = @JoinColumn(name = "categoria_id"))
	
	private Set<Categoria> categorias  = new HashSet<>(); 
	
	public Produto() {
		
	}

	//Atenção: Não coloca coleções no construtor, pois ja foi instanciada acima
	public Produto(Long id, String nome, String descricao, Double preco, String imgUrl) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.imgUrl = imgUrl;
	}

	public Long getId() {
		return id;
	}

	public void setIdProduto(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Set<Categoria> getCategorias() {
		return categorias;
	}

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
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
	

}
