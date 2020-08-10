package com.farmacia10.farmacia.seguranca;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.farmacia10.farmacia.model.Usuario;

//Comparação dados do usuário com login
public class UserDetailsImpl implements UserDetails{
	
	//Controle interno
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String password;
	
	//Construtor de Classe
	public UserDetailsImpl(Usuario user) {
		this.userName = user.getUsuario();
		this.password = user.getSenha();
	}
	
	//Construtor vazio
	public UserDetailsImpl() {}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
