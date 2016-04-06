package it.unisalento.pps.model;

public class Magazzino {
	
	private long idMagazzino;
	private String telefono;
	private String indirizzo;
	private String citta;
	

	public Magazzino(long idMagazzino, String telefono, String indirizzo, String citta) {
		this.telefono = telefono;
		this.indirizzo = indirizzo;
		this.citta = citta;
	}
	
	

	public Magazzino() {
		
	}



	public long getIdMagazzino() {
		return idMagazzino;
	}

	public void setIdMagazzino(long idMagazzino) {
		this.idMagazzino = idMagazzino;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}
	
	

}
