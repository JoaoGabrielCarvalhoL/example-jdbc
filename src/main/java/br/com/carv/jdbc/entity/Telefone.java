package br.com.carv.jdbc.entity;

public class Telefone {
	
	private Long id; 
	private String numero; 
	private String tipo;
	private Long idUser;
	public Telefone() {
		
	}
	
	public Telefone(String telefone, String tipo) {
		this.numero = telefone; 
		this.tipo = tipo;
	}
	
	public Long getId() {
		return id;
	}
	
	public void set(Long id) {
		this.id = id;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo){
		this.tipo = tipo;
	}
	
	public Long getIdUser() {
		return idUser;
	}
	
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
}
