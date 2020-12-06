package com.spring.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.ClienteDAO;
import com.spring.entity.Cliente;
import com.spring.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteDAO clienteDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {  
		return (List<Cliente>) clienteDAO.findAll();
	}
	

}
