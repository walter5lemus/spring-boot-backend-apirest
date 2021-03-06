package com.spring.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring.entity.Cliente;
import com.spring.entity.Region;
import com.spring.services.ClienteService;
import com.spring.services.UploadService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private UploadService uploadService;

	@GetMapping("/clientes")
	public List<Cliente> index() {
		return clienteService.findAll();
	}

	@GetMapping("/clientes/page/{page}")
	public Page<Cliente> index(@PathVariable Integer page) {
		Pageable pageable = PageRequest.of(page, 4);
		return clienteService.findAll(pageable);
	}

	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@GetMapping("/clientes/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Cliente cliente = null;
		Map<String, Object> response = new HashMap<>();
		try {
			cliente = clienteService.findById(id);
		} catch (Exception e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getLocalizedMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (cliente == null) {
			response.put("mensaje", "El cliente ID " + id + " no existe en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);

	}

	@Secured("ROLE_ADMIN")
	@PostMapping("/clientes")
	public ResponseEntity<?> create(@Valid @RequestBody Cliente cliente, BindingResult result) {
		Map<String, Object> response = new HashMap<>();
		Cliente clienteNew = null;

		if (result.hasErrors()) {

			/*
			 * List<String> errors = new ArrayList<String>(); for(FieldError err :
			 * result.getFieldErrors()) { errors.add("El campo '"+ err.getField() +"' "+
			 * err.getDefaultMessage()); }
			 */

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			clienteNew = clienteService.save(cliente);
		} catch (Exception e) {
			response.put("mensaje", "Error al ingresar en la base de datos");
			response.put("error", e.getLocalizedMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El cliente ha sido creado con éxito");
		response.put("cliente", clienteNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@Secured("ROLE_ADMIN")
	@PutMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> update(@Valid @RequestBody Cliente cliente, BindingResult result, @PathVariable Long id) {
		Cliente clienteActual = clienteService.findById(id);
		Cliente clienteUpdated = null;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		if (clienteActual == null) {
			response.put("mensaje", "Error no se pudo editar, " + id + " no existe en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {
			clienteActual.setApellidos(cliente.getApellidos());
			clienteActual.setEmail(cliente.getEmail());
			clienteActual.setNombres(cliente.getNombres());
			clienteActual.setCreateAt(cliente.getCreateAt());
			clienteActual.setRegion(cliente.getRegion());
			clienteUpdated = clienteService.save(clienteActual);
		} catch (Exception e) {
			response.put("mensaje", "Error al actualizar el cliente en la base de datos");
			response.put("error", e.getLocalizedMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El cliente ha sido editado con éxito");
		response.put("cliente", clienteUpdated);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@Secured("ROLE_ADMIN")
	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			Cliente cliente = clienteService.findById(id);
			String nombreFotoAnterior = cliente.getFoto();

			uploadService.eliminar(nombreFotoAnterior);

			clienteService.delete(id);
		} catch (Exception e) {

			response.put("error", e.getLocalizedMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El cliente ha sido eliminado con éxito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}

	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@PostMapping("/clientes/upload")
	public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Long id) {
		Map<String, Object> response = new HashMap<>();

		Cliente cliente = clienteService.findById(id);
		if (!archivo.isEmpty()) {

			String nombreArchivo = null;

			try {
				nombreArchivo = uploadService.copiar(archivo);
			} catch (IOException e) {

				e.printStackTrace();
				response.put("mensaje", "Error al subir la imagen del cliente " + nombreArchivo);
				response.put("error", e.getCause());
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}

			String nombreFotoAnterior = cliente.getFoto();

			uploadService.eliminar(nombreFotoAnterior);

			cliente.setFoto(nombreArchivo);
			clienteService.save(cliente);

			response.put("cliente", cliente);
			response.put("mensaje", "has subido correctamente la imagen " + nombreArchivo);

		}

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@GetMapping("/uploads/img/{nombreFoto:.+}")
	public ResponseEntity<Resource> verFoto(@PathVariable String nombreFoto) {

		Resource recurso = null;

		try {
			recurso = uploadService.cargar(nombreFoto);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		HttpHeaders cabecera = new HttpHeaders();
		cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"");

		return new ResponseEntity<Resource>(recurso, cabecera, HttpStatus.OK);
	}
	
	@Secured("ROLE_ADMIN")
	@GetMapping("/clientes/regiones")
	public List<Region> listarRegiones() {
		return clienteService.findAllRegiones();
	}

}
