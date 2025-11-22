package com.app.SpringSecurityAct.model;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;
@Entity
@Table(name = "Usuarios")
public class Usuario  implements UserDetails{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	
	private String nombre;
	private String correoElectronico;
	private String contrasena;
	private String direccion;
	private String metodoPago;
	private String cargo;
	
	
	public Usuario() {
		super();
	}
	
	public Usuario(String nombre, String correoElectronico, String contrasena, String direccion, String metodoPago,
			String cargo) {
		super();
		this.nombre = nombre;
		this.correoElectronico = correoElectronico;
		this.contrasena = contrasena;
		this.direccion = direccion;
		this.metodoPago = metodoPago;
		this.cargo = cargo;
	}

	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getMetodoPago() {
		return metodoPago;
	}
	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}
	
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String rol = this.cargo.toUpperCase();
		return Collections.singleton(new SimpleGrantedAuthority("ROLE_"+rol));
	}
	@Override
	public String getPassword() {
		return this.getContrasena();
	}
	@Override
	public String getUsername() {
		return this.getCorreoElectronico();
	}
	
	
	
}
