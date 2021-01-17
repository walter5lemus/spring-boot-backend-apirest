package com.spring.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.entity.Factura;

public interface FacturaDAO extends CrudRepository<Factura, Long> {
	
	

}
