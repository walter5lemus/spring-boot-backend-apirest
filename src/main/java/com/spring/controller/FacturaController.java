package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Factura;
import com.spring.entity.Producto;
import com.spring.services.ClienteService;

@CrossOrigin(origins = {"http://localhost:4200", "*"})
@RestController
@RequestMapping("/api")
public class FacturaController {
	
	 @Autowired
	 private ClienteService clienteService;
	 
	 @Secured({"ROLE_ADMIN","ROLE_USER"})
	 @GetMapping("/facturas/{id}")
	 @ResponseStatus(HttpStatus.OK)
	 public Factura mostrar(@PathVariable Long id) {
		 return clienteService.findFacturaById(id);
	 }
	 
	 @Secured({"ROLE_ADMIN"})
	 @DeleteMapping("/facturas/{id}")
	 @ResponseStatus(HttpStatus.NO_CONTENT)
	 public void delete(@PathVariable Long id) {
		 clienteService.deleteFacturaById(id); 
	 }
	 
	 @Secured({"ROLE_ADMIN"})
	 @GetMapping("/facturas/filtrar-productos/{term}")
	 @ResponseStatus(HttpStatus.OK)
	 public List<Producto> filtrarProductos(@PathVariable String term){
		 return clienteService.findProductoByNombre(term);
	 }
	 
	 @Secured({"ROLE_ADMIN"})
	 @PostMapping("/facturas")
	 @ResponseStatus(HttpStatus.CREATED)
	 public Factura crear(@RequestBody Factura factura) {
		 return clienteService.saveFactura(factura);
	 }

}
