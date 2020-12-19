package com.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.entity.Cliente;

public interface ClienteDAO extends JpaRepository<Cliente, Long>{
	
	

}
