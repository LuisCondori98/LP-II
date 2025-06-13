package com.mongo.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mongo.project.entity.Medico;
import com.mongo.project.entity.Paciente;
import com.mongo.project.service.MedicoService;
import com.mongo.project.service.PacienteService;

@Controller
@RequestMapping("/")
public class ViewController {
	
	@Autowired
	private PacienteService pacienteService;
	@Autowired
	private MedicoService medicoService;
	
	@GetMapping("/index")
	public String indexView(Model model) {
		
		return "index";
	}
	
	@GetMapping("/especialidad")
	public String especialidadView(Model model) {
		
		return "especialidad";
	}
	
	@GetMapping("/contacto")
	public String contactoView(Model model) {
		
		return "contacto";
	}
	
	@GetMapping("/pacientes")
	public String pacienteView(Model model) {
		
		List<Paciente> pacientes = pacienteService.readPacientes();
		
		model.addAttribute("pacientes", pacientes);
		
		return "pacientes";
	}
	
	@GetMapping("/create-paciente")
	public String createPacienteView(Model model) {
		
		return "createPaciente";
	}
	
	@GetMapping("/medicos")
	public String medicosView(Model model){
		
		List<Medico> medicos = medicoService.readMedicos();
		
		model.addAttribute("medicos", medicos);
		
		return "medicos";
	}
	
	@GetMapping("/create-medico")
	public String createMedicoView(Model model) {
		
		return "createMedico";
	}
}
