package com.app.SpringSecurityAct.model;



import jakarta.persistence.*;

@Entity
@Table(name = "Comentarios")
public class Comentario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idComentario;
	
	@ManyToOne
    @JoinColumn(name = "producto_id")
	private Producto producto;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario user;
	private String comentario;
	private String fecha;
	public Comentario(int idComentario, Producto producto, Usuario user, String comentario, String fecha) {
		super();
		this.idComentario = idComentario;
		this.producto = producto;
		this.user = user;
		this.comentario = comentario;
		this.fecha = fecha;
	}
	public Comentario() {
		super();
	}
	public int getIdComentario() {
		return idComentario;
	}
	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
}
