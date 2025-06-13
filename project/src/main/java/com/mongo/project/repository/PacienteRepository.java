package com.mongo.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongo.project.entity.Paciente;

public interface PacienteRepository extends MongoRepository<Paciente, String> {

}
