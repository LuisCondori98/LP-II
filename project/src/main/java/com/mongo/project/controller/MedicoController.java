package com.mongo.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.project.entity.Medico;
import com.mongo.project.service.MedicoService;

@RestController
@RequestMapping("/api/medicos")
public class MedicoController {

	@Autowired
	private MedicoService medicoService;
	
	@PostMapping
	public ResponseEntity<Medico> createMedico(@RequestBody Medico m) {
		
		try {
		
			Medico medico = medicoService.createMedico(m);
			
			return ResponseEntity.ok(medico);			
		} catch(IllegalArgumentException e) {
			
			return ResponseEntity.notFound().build();
		} catch(Exception e) {
			
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@GetMapping
	public ResponseEntity<List<Medico>> readMedicos(){
		
		try {
			
			List<Medico> medicos = medicoService.readMedicos();
			
			return ResponseEntity.ok(medicos);
		} catch(IllegalArgumentException e) {
			
			return ResponseEntity.notFound().build();
		} catch(Exception e) {
			
			return ResponseEntity.internalServerError().build();
		}
	}
}
