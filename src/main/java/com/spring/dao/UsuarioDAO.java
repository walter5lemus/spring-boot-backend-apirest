package com.spring.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.spring.entity.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Long>{
	
	 public Usuario findByUsername(String username);
	 
	 @Query("select u from Usuario u where u.username=?1")
	 public Usuario findByUsername2(String username);

}
