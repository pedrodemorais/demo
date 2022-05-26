//terceiro a ser implementado
package com.example.demo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entidades.ItemPedido;

//os repositories serão interfaces extendendo o JpaRepository passando como parametro a entidade e o tipo
//da chave primaria que no caso é long
//como usuario repositorio extends JpaRepository que ja é uma classe do Spring nesse caso é opcional 
//colotar o @service


public interface ItemPedidoRepositorio extends JpaRepository<ItemPedido, Long> {
	
	

}
