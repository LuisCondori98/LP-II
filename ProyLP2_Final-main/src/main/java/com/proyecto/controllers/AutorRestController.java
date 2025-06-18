package com.proyecto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.models.AutorEntity;
import com.proyecto.repositorys.AutorRepository;

@RestController
@RequestMapping("/api/autor")
public class AutorRestController {

	@Autowired
	private AutorRepository autorRepository;
	
	@GetMapping
	public ResponseEntity<List<AutorEntity>> listAutores() {
		
		try {
			
			List<AutorEntity> lista = autorRepository.findAll();
			
			for(AutorEntity a : lista) {
				
				System.out.println(a.getNombreAutor() + "se vera............." + lista);
			}
			
			return ResponseEntity.ok(lista);
		} catch (IllegalArgumentException e) {
			
			return ResponseEntity.notFound().build(); // 404
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
		}
	}
}
