package com.mongo.project.entity;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "pacientes")
public class Paciente {

	private String id;
    private int dniPaciente;
    private String nombresPaciente;
    private String apellidosPaciente;
    private Date nacimientoPaciente;
    private char generoPaciente;
    private String direccionPaciente;
    private int telefonoPaciente;
    private String emailPaciente;
}
