package com.example.demo.entidades;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.demo.entidades.enums.StatusDoPedido;
import com.example.demo.entidades.pk.ItemPedidoPk;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="pedido")//renomeando a tabela no banco de dados
public class Pedido  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss'Z'",timezone="GMT")
	private Instant momento;
	
	//dizendo exmplicitamente que esta sendo gravado no banco um numero inteiro
	private Integer statusDoPedido;
	
	//@JsonIgnore
	@ManyToOne//muitos para um
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	@OneToMany(mappedBy="id.pedido")//esse id é o que está declarado em ItemPedido private ItemPedidoPk id = new ItemPedidoPk() ja o pedido é private Pedido pedido dentro de ItemPedidoPk
	private Set<ItemPedido> itensPedido = new HashSet<>();
	
	@OneToOne(mappedBy = "pedido", cascade= CascadeType.ALL) //verificar o  nome do atributo dentro da classe pagamento que nesse caso é private Pedido pedido;
	// cascade= CascadeType.ALL está mapeando para que o pedido e o pagamento tenha o mesmo id
	private Pagamento pagamento;

	
	public Pedido() {
		
	}


	public Pedido(Long id, Instant momento,StatusDoPedido statusDoPedido, Cliente cliente) {
		this.id = id;
		this.momento = momento;
		setStatusDoPedido(statusDoPedido);
		this.cliente = cliente;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Instant getMomento() {
		return momento;
	}


	public void setMomento(Instant momento) {
		this.momento = momento;
	}
	
	public StatusDoPedido getStatusDoPedido() {
		return StatusDoPedido.valueOf( statusDoPedido);
	}


	public void setStatusDoPedido(StatusDoPedido statusDoPedido) {
		if(statusDoPedido!=null) {
		this.statusDoPedido = statusDoPedido.getCodigo();
		}
	}

	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Set<ItemPedido> getItems(){
		return itensPedido;
	}
	

	public Pagamento getPagamento() {
		return pagamento;
	}


	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
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
