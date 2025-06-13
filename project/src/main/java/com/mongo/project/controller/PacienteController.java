package com.mongo.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.project.entity.Paciente;
import com.mongo.project.service.PacienteService;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

	@Autowired
	private PacienteService pacienteService;
	
	@PostMapping
	public ResponseEntity<Paciente> createPaciente(@RequestBody Paciente p){
		
		Paciente ps = pacienteService.createPaciente(p);
		
		return ResponseEntity.ok(ps);
	}
	
	@GetMapping
	public ResponseEntity<List<Paciente>> readPacientes(){
		
		List<Paciente> pacientes = pacienteService.readPacientes(); 
		
		return ResponseEntity.ok(pacientes);
	}
}
