package com.farmacia10.farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmacia10.farmacia.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
	public List<Categoria> findAllByDescricaoContainingIgnoreCase (String descricao);
}
