package com.minha.redesocial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minha.redesocial.model.Assunto;
import com.minha.redesocial.model.Usuario;
import com.minha.redesocial.repository.AssuntoRepository;
import com.minha.redesocial.repository.UsuarioRepository;

@RestController 
@RequestMapping("/assunto")
@CrossOrigin("*")
public class AssuntoController {

	@Autowired
	private AssuntoRepository repository;

	
	@GetMapping
	public ResponseEntity<List<Assunto>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public  ResponseEntity<Assunto> getById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Assunto> post (@RequestBody Assunto assunto){
		return ResponseEntity.status(HttpStatus.CREATED)
			.body(repository.save(assunto));
	}
	
	@PutMapping
	public ResponseEntity<Assunto> put (@RequestBody Assunto assunto){
		return ResponseEntity.ok(repository.save(assunto));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}
