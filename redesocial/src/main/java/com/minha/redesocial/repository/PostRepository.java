package com.minha.redesocial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minha.redesocial.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
	public List<Post> findAllByDescricaoContainingIgnoreCase(String descricao);
}