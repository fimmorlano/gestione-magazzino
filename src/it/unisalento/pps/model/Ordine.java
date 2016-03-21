package it.unisalento.pps.model;

public class Ordine {
	
	
	private String username;
	private String codiceArticolo;
	private int quantita;
	private String idMagazzino;
	private String nomeProgetto;

	public Ordine(String username, String codiceArticolo, int quantita, String idMagazzino, String nomeProgetto) {
		this.codiceArticolo = codiceArticolo;
		this.quantita = quantita;
		this.idMagazzino = idMagazzino;
		this.nomeProgetto = nomeProgetto;
	}

	public String getCodiceArticolo() {
		return codiceArticolo;
	}

	public void setCodiceArticolo(String codiceArticolo) {
		this.codiceArticolo = codiceArticolo;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public String getIdMagazzino() {
		return idMagazzino;
	}

	public void setIdMagazzino(String idMagazzino) {
		this.idMagazzino = idMagazzino;
	}

	public String getNomeProgetto() {
		return nomeProgetto;
	}

	public void setNomeProgetto(String nomeProgetto) {
		this.nomeProgetto = nomeProgetto;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	

}
