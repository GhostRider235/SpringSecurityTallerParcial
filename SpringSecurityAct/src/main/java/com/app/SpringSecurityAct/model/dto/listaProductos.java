package com.app.SpringSecurityAct.model.dto;

import java.util.List;

import com.app.SpringSecurityAct.model.Producto;

public class listaProductos {
	private List<Integer> listaProductos;

	public listaProductos() {
		super();
	}

	public listaProductos(List<Integer> listaProductos) {
		super();
		this.listaProductos = listaProductos;
	}

	public List<Integer> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<Integer> listaProductos) {
		this.listaProductos = listaProductos;
	}

	
	
	
	
}
