package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entidades.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Long> {

}
