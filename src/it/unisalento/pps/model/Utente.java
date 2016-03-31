package it.unisalento.pps.model;

import it.unisalento.pps.dao.UtenteDAO;


public class Utente {
	
	private int idUtente;
	private String nome;
	private String cognome;
	private String telefono;
	private String codiceFiscale;
	private String email;
	private String tipoUtente;
	private String username;
	private String password;
	
	
	public Utente(){
		
	}
	
	public Utente(int idUtente, String nome, String cognome, String telefono, String codiceFiscale, String email, String tipoUtente, String username, String password) {
		this.idUtente = idUtente;
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
		this.codiceFiscale = codiceFiscale;
		this.email = email;
		this.tipoUtente = tipoUtente;
		this.username = username;
		this.password = password;
	}
 
	
	
	
	public int getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCognome() {
		return cognome;
	}



	public void setCognome(String cognome) {
		this.cognome = cognome;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public String getCodiceFiscale() {
		return codiceFiscale;
	}



	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getTipoUtente() {
		return tipoUtente;
	}



	public void setTipoUtente(String tipoUtente) {
		this.tipoUtente = tipoUtente;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public boolean login()
	{
	
		//TODO ? gestire l'eccezione lanciata da userExists
//		return UtenteDAO.getInstance().userExists(username, password);
		return false;
	}
	
	
}
