package com.spring.services;

import com.spring.entity.Usuario;

public interface IUsuarioService {
	
	public Usuario findByUsername(String username);

}
