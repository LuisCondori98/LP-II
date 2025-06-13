package com.mongo.project.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "especialidad")
public class Especialidad {

	private String id;
	private String nombre;
	private String descripcion;
}
