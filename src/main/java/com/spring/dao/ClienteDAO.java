package com.spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.entity.Cliente;
import com.spring.entity.Region;

public interface ClienteDAO extends JpaRepository<Cliente, Long>{
	
	@Query("from Region")
	public List<Region> findAllRegiones();	

}
