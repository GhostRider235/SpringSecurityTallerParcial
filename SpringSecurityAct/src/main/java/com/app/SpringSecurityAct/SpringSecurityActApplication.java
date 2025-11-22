package com.app.SpringSecurityAct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.app.SpringSecurityAct.model.Usuario;
import com.app.SpringSecurityAct.repository.UsuarioRepository;


@SpringBootApplication
public class SpringSecurityActApplication implements CommandLineRunner{
	
	@Autowired
	private UsuarioRepository repo;
	
	@Autowired
	private PasswordEncoder encode;
	

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityActApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		for (Usuario user : repo.findAll()) {
			user.setContrasena(encode.encode(user.getContrasena()));
			repo.save(user);
		}
		
	}

}
