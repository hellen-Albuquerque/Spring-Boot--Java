package com.farmacia10.farmacia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmacia10.farmacia.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {	
	public Optional<Usuario> findByUsuario(String usuario);
}
