package com.app.SpringSecurityAct.model.dto;

public class UserDTO {
	private String nombre;
	private String correoElectronico;
	private String contrasena;
	private String direccion;
	private String metodoPago;
	private String cargo;
	public UserDTO(String nombre, String correoElectronico, String contrasena, String direccion, String metodoPago,
			String cargo) {
		super();
		this.nombre = nombre;
		this.correoElectronico = correoElectronico;
		this.contrasena = contrasena;
		this.direccion = direccion;
		this.metodoPago = metodoPago;
		this.cargo = cargo;
	}
	public UserDTO() {
		super();
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
	
	
}
