package model;

import jakarta.persistence.*;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codUsuario;
	private String nomUsuario;
	private String apeUsuario;
	private String usrUsuario;
	private String claUsuario;
	private String fnaUsuario;
	private int idTipo;
	private int estUsuario;
	
	public int getCodUsuario() {
		
		return codUsuario;
	}
	
	public void setCodUsuario(int codUsuario) {
		
		this.codUsuario = codUsuario;
	}
	
	public String getNomUsuario() {
		
		return nomUsuario;
	}
	
	public void setNomUsuario(String nomUsuario) {
		
		this.nomUsuario = nomUsuario;
	}
	
	public String getApeUsuario() {
		
		return apeUsuario;
	}
	
	public void setApeUsuario(String apeUsuario) {
		
		this.apeUsuario = apeUsuario;
	}
	
	public String getUsrUsuario() {
		
		return usrUsuario;
	}
	
	public void setUsrUsuario(String usrUsuario) {
		
		this.usrUsuario = usrUsuario;
	}
	
	public String getClaUsuario() {
		
		return claUsuario;
	}
	
	public void setClaUsuario(String claUsuario) {
		
		this.claUsuario = claUsuario;
	}
	
	public String getFnaUsuario() {
		
		return fnaUsuario;
	}
	
	public void setFnaUsuario(String fnaUsuario) {
		
		this.fnaUsuario = fnaUsuario;
	}
	
	public int getIdTipo() {
		
		return idTipo;
	}
	
	public void setIdTipo(int idTipo) {
		
		this.idTipo = idTipo;
	}
	
	public int getEstUsuario() {
		
		return estUsuario;
	}
	
	public void setEstUsuario(int estUsuario) {
		
		this.estUsuario = estUsuario;
	}
}
