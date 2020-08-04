package com.rede.farmacia10.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import com.rede.farmacia10.model.Categoria;


@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	// public List<Categoria> findAllByDescricaoContainingIgnoreCase (String descricao);
		
}		
	