package com.example.demo.entidades.enums;

public enum StatusDoPedido {
	AGUARDANDO_PAGAMENTO(1),//atribuindo valor numererico 
	PAGO(2),
	ENVIADO(3),
	ENTREGUE(4),
	CANCELADO(5);
	
	//codigo do tipo enumerado
	private int codigo;
	
	//construtor do tipo enumerado é do tipo private - aqui tem que ser private
	private StatusDoPedido(int codigo) {
		this.codigo = codigo;
		
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	//convertendo um valor numerico(inteiro) para o tipo enumerado
	public static StatusDoPedido valueOf(int codigo) {
		for(StatusDoPedido valor : StatusDoPedido.values()) {
			if(valor.getCodigo()==codigo) {
				return valor;
				
			}
			
		}
		throw new IllegalArgumentException("Status do Pedido Invalido");
		
	}
	
	
	
	

}
