package com.algaworks.brands.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.brands.model.Usuario;

public interface Usuarios extends JpaRepository<Usuario, Long> {
}