package com.app.SpringSecurityAct.model.dto;

import java.util.List;

import com.app.SpringSecurityAct.model.Producto;
import com.app.SpringSecurityAct.model.Usuario;

public class ListadoProductosCarrito {
	private Usuario user;
	private List<Producto> listaProductos;
	private double total;
	public ListadoProductosCarrito(Usuario user, List<Producto> listaProductos, double total) {
		super();
		this.user = user;
		this.listaProductos = listaProductos;
		this.total = total;
	}
	public ListadoProductosCarrito() {
		super();
	}
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	public List<Producto> getListaProductos() {
		return listaProductos;
	}
	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
}
