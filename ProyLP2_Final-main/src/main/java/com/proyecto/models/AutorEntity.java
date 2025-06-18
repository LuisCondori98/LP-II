package com.proyecto.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_autor")
public class AutorEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDAutor", nullable = false)
    private Integer idAutor;

    @Column(name = "NombrAutor", nullable = false, columnDefinition = "VARCHAR(100)")
    private String nombreAutor;

    @Column(name = "ApellidoAutor", nullable = false, columnDefinition = "VARCHAR(100)")
    private String apellidoAutor;

    /*@OneToMany( mappedBy = "autorEntity", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<LibroEntity> libros = new ArrayList<LibroEntity>();*/
    
	/*public AutorEntity(Integer idAutor, String nombreAutor, String apellidoAutor) {
		super();
		this.idAutor = idAutor;
		this.nombreAutor = nombreAutor;
		this.apellidoAutor = apellidoAutor;
	}

	public AutorEntity() {
		super();
	}

	public Integer getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(Integer idAutor) {
		this.idAutor = idAutor;
	}

	public String getNombreAutor() {
		return nombreAutor;
	}

	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}

	public String getApellidoAutor() {
		return apellidoAutor;
	}

	public void setApellidoAutor(String apellidoAutor) {
		this.apellidoAutor = apellidoAutor;
	}*/
}
