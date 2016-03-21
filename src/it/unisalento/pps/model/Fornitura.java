package it.unisalento.pps.model;

public class Fornitura {
	
	private String nomeMagazziniere;
	private String cognomeMagazziniere;
	private String nomeArticolo;
	private String codiceArticolo;
	private int quantita;
	

	public Fornitura(String nomeMagazziniere, String cognomeMagazziniere, String nomeArticolo, String codiceArticolo, int quantita) {
		
		this.nomeMagazziniere = nomeMagazziniere;
		this.cognomeMagazziniere = cognomeMagazziniere;
		this.nomeArticolo = nomeArticolo;
		this.codiceArticolo = codiceArticolo;
		this.quantita = quantita;
	}


	public String getNomeMagazziniere() {
		return nomeMagazziniere;
	}


	public void setNomeMagazziniere(String nomeMagazziniere) {
		this.nomeMagazziniere = nomeMagazziniere;
	}


	public String getCognomeMagazziniere() {
		return cognomeMagazziniere;
	}


	public void setCognomeMagazziniere(String cognomeMagazziniere) {
		this.cognomeMagazziniere = cognomeMagazziniere;
	}


	public String getNomeArticolo() {
		return nomeArticolo;
	}


	public void setNomeArticolo(String nomeArticolo) {
		this.nomeArticolo = nomeArticolo;
	}


	public String getCodiceArticolo() {
		return codiceArticolo;
	}


	public void setCodiceArticolo(String codicerticolo) {
		this.codiceArticolo = codicerticolo;
	}


	public int getQuantita() {
		return quantita;
	}


	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	
	

}
