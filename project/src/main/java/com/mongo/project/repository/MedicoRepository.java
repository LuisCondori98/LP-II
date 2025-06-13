package com.mongo.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongo.project.entity.Medico;

public interface MedicoRepository extends MongoRepository<Medico, String> {

}
