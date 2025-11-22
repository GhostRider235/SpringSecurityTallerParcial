package com.app.SpringSecurityAct.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.SpringSecurityAct.model.CarritoDeCompras;
import com.app.SpringSecurityAct.model.Usuario;

import java.util.List;


public interface CarritoComprasRepository extends JpaRepository<CarritoDeCompras, Integer>{
	List<CarritoDeCompras> findByUser(Usuario user);
}
