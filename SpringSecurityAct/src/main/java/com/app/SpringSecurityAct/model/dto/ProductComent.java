package com.app.SpringSecurityAct.model.dto;

import java.util.List;

import com.app.SpringSecurityAct.model.Comentario;
import com.app.SpringSecurityAct.model.Producto;

public class ProductComent {
	
	private Producto producto;
	private List<Comentario> comentarios;
	public ProductComent(Producto producto, List<Comentario> comentarios) {
		super();
		this.producto = producto;
		this.comentarios = comentarios;
	}
	public ProductComent() {
		super();
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public List<Comentario> getComentarios() {
		return comentarios;
	}
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	
}
