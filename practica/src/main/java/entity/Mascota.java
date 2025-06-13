package entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="mascotas")
@NamedQuery(name="Mascota.findAll", query="SELECT m FROM Mascota m")
public class Mascota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMascota;

	private String colorMascota;

	private int edadMascota;

	private String nombreMascota;

	private String razaMascota;

	public Mascota() {
	}

	public int getIdMascota() {
		return this.idMascota;
	}

	public void setIdMascota(int idMascota) {
		this.idMascota = idMascota;
	}

	public String getColorMascota() {
		return this.colorMascota;
	}

	public void setColorMascota(String colorMascota) {
		this.colorMascota = colorMascota;
	}

	public int getEdadMascota() {
		return this.edadMascota;
	}

	public void setEdadMascota(int edadMascota) {
		this.edadMascota = edadMascota;
	}

	public String getNombreMascota() {
		return this.nombreMascota;
	}

	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}

	public String getRazaMascota() {
		return this.razaMascota;
	}

	public void setRazaMascota(String razaMascota) {
		this.razaMascota = razaMascota;
	}

}