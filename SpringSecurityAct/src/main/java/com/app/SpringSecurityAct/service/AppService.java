package com.app.SpringSecurityAct.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.SpringSecurityAct.model.CarritoDeCompras;
import com.app.SpringSecurityAct.model.OrdenCompra;
import com.app.SpringSecurityAct.model.Producto;
import com.app.SpringSecurityAct.model.Usuario;
import com.app.SpringSecurityAct.model.dto.ListadoProductosCarrito;
import com.app.SpringSecurityAct.repository.CarritoComprasRepository;
import com.app.SpringSecurityAct.repository.OrdenCompraRepository;
import com.app.SpringSecurityAct.repository.ProductoRepository;

@Service
public class AppService {
	private final CarritoComprasRepository repCarrito;
	private final OrdenCompraRepository repOrden;
	private final ProductoRepository repProducto;
	public AppService(CarritoComprasRepository repCarrito, OrdenCompraRepository repOrden,
			ProductoRepository repProducto) {
		super();
		this.repCarrito = repCarrito;
		this.repOrden = repOrden;
		this.repProducto = repProducto;
	}
	
	
	
	public CarritoDeCompras generarCarrito(Usuario user, List<Integer> lista) {
		List<Producto> listaProductos = new ArrayList<>();
		CarritoDeCompras compra = new CarritoDeCompras();
		OrdenCompra orden = new OrdenCompra();

		double total = 0;
		
		for (Integer i : lista) {
			Producto p = repProducto.findById(i).orElseThrow(() -> new RuntimeException("no se pudo encontrar el producto con el id: "+i));
			listaProductos.add(p);
			total+=p.getPrecio();
		}
		
		double impuesto = total*0.19;
		compra.setProductos(listaProductos);
		compra.setUser(user);
		compra.setSubtotal(total);
		compra.setImpuesto(impuesto);
		
		orden.setEnvio(10000);
		orden.setImpuestos(impuesto);
		orden.setProductos(listaProductos);
		orden.setSubtotal(total);
		orden.setTotal(total);
		orden.setUser(user);
		
		repOrden.save(orden);
		
		repCarrito.save(compra);
		
		return compra;
	}
	
	public List<ListadoProductosCarrito> verCarritosProductos(Usuario u) {
		//Lista de carrtitos del usuario
		List<CarritoDeCompras> carritos = repCarrito.findByUser(u);
		
		//Lista de carritos para mostrar 
		List<ListadoProductosCarrito> carritosMostrar = new ArrayList<>();
		
		//Primero verifica si tiene carritos el usuario
		if (!carritos.isEmpty()) {
			
			//Ingresa los carritos a la lista que se mostrara
			for (CarritoDeCompras compras : carritos) {
				ListadoProductosCarrito l = new ListadoProductosCarrito(u,compras.getProductos(),compras.getSubtotal());
				carritosMostrar.add(l);
			}
			
			//retorna los carritos que encontraste
			return carritosMostrar;
		}
		
		return null;
	}
	
}
