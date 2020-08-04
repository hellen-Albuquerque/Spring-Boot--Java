package com.minha.redesocial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minha.redesocial.model.Assunto;
import com.minha.redesocial.model.Post;


@Repository
public interface AssuntoRepository extends JpaRepository<Assunto, Long>{
	public List<Assunto> findAllByDescricaoContainingIgnoreCase (String descricao);
}

