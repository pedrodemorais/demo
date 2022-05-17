package com.example.demo.entidades;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_pedido")//renomeando a tabela no banco de dados
public class Pedido  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private Instant momento;
	
	@ManyToOne//muitos para um
	@JoinColumn(name="client_id")
	private Cliente cliente;

	
	public Pedido() {
		
	}


	public Pedido(long id, Instant momento, Cliente cliente) {
		super();
		this.id = id;
		this.momento = momento;
		this.cliente = cliente;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Instant getMomento() {
		return momento;
	}


	public void setMomento(Instant momento) {
		this.momento = momento;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
		Pedido other = (Pedido) obj;
		return id == other.id;
	}
	
	
	
	
}
