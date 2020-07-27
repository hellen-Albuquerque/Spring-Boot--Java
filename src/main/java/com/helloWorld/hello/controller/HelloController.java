package com.helloWorld.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Hello")
public class HelloController {
	
	@GetMapping
	public String hello() {
		return "Olá Generation, na realização desta atividade ultilizei a habilidade de atenção aos detalhes e persistência, juntamente com a mentalidade de crescimento e de aprendizagem constante.";
	}
	
	

}

