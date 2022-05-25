package com.example.demo.entidades.pk;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.demo.entidades.Pedido;
import com.example.demo.entidades.Produto;

//Classe auxiliar de chave primária composta não terá constrututores
//essa classe serve para atribuir as chaves estrangeiras da associação Pedido - Produto

@Embeddable
public class ItemPedidoPk implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name ="pedido_id") //Nome da chave 
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name ="produto_id") //Nome da chave 
	private Produto produto;
	
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(pedido, produto);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedidoPk other = (ItemPedidoPk) obj;
		return Objects.equals(pedido, other.pedido) && Objects.equals(produto, other.produto);
	}
	
	
	
	
	

}
