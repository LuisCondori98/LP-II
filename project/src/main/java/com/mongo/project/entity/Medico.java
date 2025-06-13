package com.mongo.project.entity;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "doctores")
public class Medico {

	private String id;
	private String nombresMedico;
	private String apellidosMedico;
	private String especialidadMedico;
	private String direccionMedico;
	private int telefonoMedico;
	private String emailMedico;
	private int dniMedico;
	private Date nacimientoMedico;
	private boolean estado = true;
}
