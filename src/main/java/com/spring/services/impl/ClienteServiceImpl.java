package com.spring.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.ClienteDAO;
import com.spring.dao.FacturaDAO;
import com.spring.dao.ProductoDAO;
import com.spring.entity.Cliente;
import com.spring.entity.Factura;
import com.spring.entity.Producto;
import com.spring.entity.Region;
import com.spring.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteDAO clienteDAO;

	@Autowired
	private FacturaDAO facturaDAO;
	
	@Autowired
	private ProductoDAO productoDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Cliente> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return clienteDAO.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id) {
		return clienteDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		return clienteDAO.save(cliente);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clienteDAO.deleteById(id);

	}

	@Override
	@Transactional(readOnly = true)
	public List<Region> findAllRegiones() {
		return clienteDAO.findAllRegiones();
	}

	@Override
	@Transactional(readOnly = true)
	public Factura findFacturaById(Long id) {
		return facturaDAO.findById(id).orElse(null); 
	}

	@Override
	@Transactional()
	public Factura saveFactura(Factura factura) {
		return facturaDAO.save(factura);
	}

	@Override
	@Transactional()
	public void deleteFacturaById(Long id) {
		facturaDAO.deleteById(id);

	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findProductoByNombre(String term) {
		return productoDAO.findByNombreContainingIgnoreCase(term);
	}

}
