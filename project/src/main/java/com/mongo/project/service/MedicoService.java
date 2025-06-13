package com.mongo.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mongo.project.entity.Medico;
import com.mongo.project.repository.MedicoRepository;

@Service
public class MedicoService {

	@Autowired
	private MedicoRepository medicoRepository;
	
	@Transactional
	public Medico createMedico(Medico m) {
		
		return medicoRepository.save(m);
	}
	
	public List<Medico> readMedicos(){
		
		return medicoRepository.findAll();
	}
}
