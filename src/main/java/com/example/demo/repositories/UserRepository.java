//terceiro a ser implementado
package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entidades.Cliente;

//os repositories serão interfaces extendendo o JpaRepository passando como parametro a entidade e o tipo
//da chave primaria que no caso é long
public interface UserRepository extends JpaRepository<Cliente, Long> {

}
