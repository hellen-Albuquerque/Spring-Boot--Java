package com.farmacia10.farmacia.service;

import java.nio.charset.Charset;
import java.util.Optional;
import org.apache.commons.codec.binary.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.farmacia10.farmacia.model.UserLogin;
import com.farmacia10.farmacia.model.Usuario;
import com.farmacia10.farmacia.repository.UsuarioRepository;

//Implementar regras de negócios para cadastrar usuário e salvar senha

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Usuario CadastrarUsuario(Usuario usuario) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		//Salva senha encriptada do usuário
		String senhaEncoder = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaEncoder);
		
		return repository.save(usuario);
	}
	//Regra de negócio que dita tudo relacionado a Logar 
	public Optional<UserLogin> Logar(Optional<UserLogin> user){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuario> usuario = repository.findByUsuario(user.get().getUsuario());
		
		//Compara senha encriptada com a senha digitada
		if(usuario.isPresent()) {
			if(encoder.matches(user.get().getSenha(), usuario.get().getSenha())) {
				
				String auth = user.get().getUsuario() + ":" + user.get().getSenha();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);
				
				user.get().setToken(authHeader);
				user.get().setNome(usuario.get().getNome());
				
				return user;
			}
		}
		//Não existe usuário no Banco de Dados
		return null;
	}	
}
