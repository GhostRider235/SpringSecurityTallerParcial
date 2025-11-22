package com.app.SpringSecurityAct.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.SpringSecurityAct.model.Usuario;
import com.app.SpringSecurityAct.model.dto.UserDTO;
import com.app.SpringSecurityAct.repository.UsuarioRepository;

@Service
public class AuthService implements UserDetailsService {
	
	private final UsuarioRepository rep;	

	private final PasswordEncoder codificador;
	

	public AuthService(UsuarioRepository rep, PasswordEncoder codificador) {
		super();
		this.rep = rep;
		this.codificador = codificador;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = 	rep.findByCorreoElectronico(username).orElseThrow(() -> new UsernameNotFoundException("No se pudo encontrar el usuario con el correo: "+username));
		return User.withUsername(user.getUsername())
				.password(user.getPassword())
				.roles(user.getCargo())
				.build();
	}
	
	public Usuario registrarUsuario(UserDTO u) {
		Usuario user = new Usuario(u.getNombre(),u.getCorreoElectronico(),codificador.encode(u.getContrasena()),u.getDireccion(),u.getMetodoPago(),u.getCargo());
		return rep.save(user);
	}
}
