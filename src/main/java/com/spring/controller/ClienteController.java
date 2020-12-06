package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Cliente;
import com.spring.services.ClienteService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/clientes")
	public List<Cliente> index(){
		return clienteService.findAll();
	}

}
