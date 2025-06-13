package com.mongo.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongo.project.entity.Paciente;
import com.mongo.project.repository.PacienteRepository;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository pacienteRepository;
	
	public Paciente createPaciente(Paciente p) {
		
		return pacienteRepository.save(p);
	}
	
	public List<Paciente> readPacientes(){
		
		return pacienteRepository.findAll();
	}
}
