package com.app.SpringSecurityAct.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.SpringSecurityAct.model.CarritoDeCompras;
import com.app.SpringSecurityAct.model.Usuario;
import com.app.SpringSecurityAct.model.dto.ListadoProductosCarrito;
import com.app.SpringSecurityAct.model.dto.listaProductos;
import com.app.SpringSecurityAct.service.AppService;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/app")
public class AppController {

	private final AppService app;
	
	public AppController(AppService app) {
	super();
	this.app = app;
	}

	@GetMapping("/")
	public String aviso() {
		return "hola";
	}
	
	@PostMapping("/CrearCarrito")
	public String crearCarrito(@RequestBody listaProductos Productos) {
		//Con este objeto del contexto de seguridad de Spring Security 
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	
    	//Despues verificamos que el usuario este autenticado
    	if (auth == null || !auth.isAuthenticated()) {
			//En caso de que no entonces no se ira al login de nuevo
    		return "login";
		}
    	
    	//Y si es el caso de que esta autenticado entonces obtenemos la sesion
    	Usuario usuario = (Usuario) auth.getPrincipal();
    	
    	CarritoDeCompras carrito = app.generarCarrito(usuario, Productos.getListaProductos());
		
		return "Carrito de compras registrado";
	}
	
	@GetMapping("/carritos")
	public List<ListadoProductosCarrito> verCarritosCompra() {
		//Con este objeto del contexto de seguridad de Spring Security 
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	
    	//Despues verificamos que el usuario este autenticado
    	if (auth == null || !auth.isAuthenticated()) {
			//En caso de que no entonces no se ira al login de nuevo
    		return null;
		}
    	
    	//Y si es el caso de que esta autenticado entonces obtenemos la sesion
    	Usuario usuario = (Usuario) auth.getPrincipal();
		
		
		return app.verCarritosProductos(usuario);
	}
	
	
	
}
