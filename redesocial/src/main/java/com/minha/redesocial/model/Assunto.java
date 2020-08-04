package com.minha.redesocial.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name ="tb_Tema")
public class Assunto{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
     
	@NotNull
	@Size (min = 5, max = 100)
	private String descricao;
	
	@OneToMany(mappedBy = "assunto", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("assunto")
	private List<Post> post;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public List<Post> getPost() {
		return post;
	}

	public void setPostagens(List<Post> post) {
		this.post = post;
	}


}
