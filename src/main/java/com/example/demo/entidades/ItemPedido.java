package com.example.demo.entidades;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.demo.entidades.pk.ItemPedidoPk;
@Entity
@Table(name="itempedido")

public class ItemPedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ItemPedidoPk id;//Classe auxiliar PK 
	private Integer quantidade;
	private Double price;
	
	public ItemPedido() {
		
	}
//instanciando o Item pedido passando o pedido o produto a quantidade e o preco
	public ItemPedido(Pedido pedido, Produto produto,Integer quantidade, Double price) {
		id.setPedido(pedido);
		id.setProduto(produto);
		this.quantidade = quantidade;
		this.price = price;
	}
	
	public Pedido getPedido() {
		return id.getPedido();
	}
	
	//conceito importante entender
	public void setPedido (Pedido pedido) {//informando um pedido
		id.setPedido(pedido);//metodo vai la no id (Primeiro atributo) e vai jogar o pedido la dentro
		
	}
	
	public Produto getProduto() {
		return id.getProduto();
	}
	
	public void setProduto (Produto produto) {
		id.setProduto(produto);
		
	}
	
	

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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
		ItemPedido other = (ItemPedido) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
	

}
