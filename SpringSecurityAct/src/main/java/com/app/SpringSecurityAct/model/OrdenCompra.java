package com.app.SpringSecurityAct.model;

import java.util.List;


import jakarta.persistence.*;

@Entity
@Table(name = "OrdenesComrpras")
public class OrdenCompra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCarrito;
	
    @ManyToOne
    @JoinColumn(name = "usuario_id")	
	private Usuario user;
	
	@ManyToMany
	@JoinTable(
			name = "Orden_Productos",
			joinColumns = @JoinColumn(name = "orden_id"),
			inverseJoinColumns = @JoinColumn(name = "producto_id")
			)
	private List<Producto> productos;
	private double subtotal;
	private double impuestos;
	private double envio;
	private double total;
	public OrdenCompra(int idCarrito, Usuario user, List<Producto> productos, double subtotal, double impuestos,
			double envio, double total) {
		super();
		this.idCarrito = idCarrito;
		this.user = user;
		this.productos = productos;
		this.subtotal = subtotal;
		this.impuestos = impuestos;
		this.envio = envio;
		this.total = total;
	}
	public OrdenCompra() {
		super();
	}
	public int getIdCarrito() {
		return idCarrito;
	}
	public void setIdCarrito(int idCarrito) {
		this.idCarrito = idCarrito;
	}
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	public List<Producto> getProductos() {
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public double getImpuestos() {
		return impuestos;
	}
	public void setImpuestos(double impuestos) {
		this.impuestos = impuestos;
	}
	public double getEnvio() {
		return envio;
	}
	public void setEnvio(double envio) {
		this.envio = envio;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
}
