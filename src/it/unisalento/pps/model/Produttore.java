package it.unisalento.pps.model;

public class Produttore {
	
	private long idProduttore;
	private String nome;
	private String telefono;
	private String email;
//	private String indirizzo; TODO ?? serve l'indirizzo
	private String citta;

	public Produttore(String nome, String telefono, String email, String indirizzo) {
		this.nome = nome;
		this.telefono = telefono;
		this.email = email;
//		this.indirizzo = indirizzo;
		this.citta = citta;
		
	}
	

	
	public Produttore() {
		
	}



	public long getIdProduttore() {
		return idProduttore;
	}



	public void setIdProduttore(long idProduttore) {
		this.idProduttore = idProduttore;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public String getIndirizzo() {
//		return indirizzo;
//	}

//	public void setIndirizzo(String indirizzo) {
//		this.indirizzo = indirizzo;
//	}
	
	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

}
