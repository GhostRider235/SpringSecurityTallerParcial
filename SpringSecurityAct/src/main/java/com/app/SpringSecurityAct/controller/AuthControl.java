package com.app.SpringSecurityAct.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.SpringSecurityAct.model.Usuario;
import com.app.SpringSecurityAct.model.dto.Login;
import com.app.SpringSecurityAct.model.dto.UserDTO;
import com.app.SpringSecurityAct.service.AuthService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class AuthControl {
	
	private final AuthService auth;
	
	private final PasswordEncoder encode;
	
	
	public AuthControl(AuthService auth, PasswordEncoder encode) {
		super();
		this.auth = auth;
		this.encode = encode;
	}


	@PostMapping("/login")
	public ResponseEntity<?> inicioSesion(@RequestBody Login request) {
		
		try {
			UserDetails user = auth.loadUserByUsername(request.getUsername());
			
			if (encode.matches(request.getPassword(), user.getPassword())) {
				return ResponseEntity.ok("Login correcto");
			} else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
			}
			
		} catch (UsernameNotFoundException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Usuario no encontrado");		
			}

	}


	@PostMapping("/register")
	public String registrarUsuario(@RequestBody UserDTO nuevoUsuario) {
		auth.registrarUsuario(nuevoUsuario);
		return "Nuevo usuario registrado: "+nuevoUsuario.getNombre();
	}
	
}
