package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Factura;
import com.spring.services.ClienteService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class FacturaController {
	
	 @Autowired
	 private ClienteService clienteService;
	 
	 @GetMapping("/facturas/{id}")
	 @ResponseStatus(HttpStatus.OK)
	 public Factura mostrar(@PathVariable Long id) {
		 return clienteService.findFacturaById(id);
	 }
	 
	 @DeleteMapping("/facturas/{id}")
	 @ResponseStatus(HttpStatus.NO_CONTENT)
	 public void delete(@PathVariable Long id) {
		 clienteService.deleteFacturaById(id); 
	 }

}
