package com.spring.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.entity.Cliente;

public interface ClienteDAO extends CrudRepository<Cliente, Long>{
	
	

}
