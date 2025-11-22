package com.app.SpringSecurityAct.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.SpringSecurityAct.model.Comentario;
import com.app.SpringSecurityAct.model.Producto;
import com.app.SpringSecurityAct.repository.ComentarioRepository;
import com.app.SpringSecurityAct.repository.ProductoRepository;

@Service
public class ArraysService {
	
	private final ProductoRepository repProduct;
	
	private final ComentarioRepository repComent;
	


	public ArraysService(ProductoRepository repProduct, ComentarioRepository repComent) {
		super();
		this.repProduct = repProduct;
		this.repComent = repComent;
	}

	public List<Comentario> verComentarios() {
		return repComent.findAll();
	}

	public List<Producto> listarProductos() {
		return repProduct.findAll();
	}
}
