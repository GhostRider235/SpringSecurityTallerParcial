package com.app.SpringSecurityAct.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.SpringSecurityAct.model.Comentario;
import com.app.SpringSecurityAct.model.Producto;
import com.app.SpringSecurityAct.model.dto.ProductComent;
import com.app.SpringSecurityAct.service.ArraysService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/view")
public class VistaControl {
	
	private final ArraysService service;

	public VistaControl(ArraysService service) {
		super();
		this.service = service;
	}
	
	
	
	@GetMapping("/products")
	public List<Producto> verProductos() {
		return service.listarProductos();
	}
	
	@GetMapping("/coments")
	public List<Comentario> verComentarios() {
		return service.verComentarios();
	}
	
	@GetMapping("/feedbackTienda")
	public ResponseEntity<List<ProductComent>> verComentariosProductos() {
		
		List<Producto> listadoP = service.listarProductos();
		
		List<Comentario> listadoC = service.verComentarios();
		
		Map<Integer, List<Comentario>> ProductoComentario = 
				listadoC.stream().collect(Collectors.groupingBy(c -> c.getProducto().getIdProducto()));
		
		
		List<ProductComent> respuesta = listadoP.stream().map(
				p -> new ProductComent(p, ProductoComentario.getOrDefault(p.getIdProducto(), new ArrayList<>()))
				)
				.collect(Collectors.toList());	
		
		return ResponseEntity.ok(respuesta);
	}
	
	
	
}
