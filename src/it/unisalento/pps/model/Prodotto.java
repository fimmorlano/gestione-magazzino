package it.unisalento.pps.model;

public class Prodotto {
	
	private String nome;
	private String categoria;
	private String descrizione;
	private boolean disponibilita;
	private int numMax;

	public Prodotto(String nome, String categoria, String descrizione, boolean disponibilita, int numMax) {
		this.nome = nome;
		this.categoria = categoria;
		this.descrizione = descrizione;
		this.disponibilita = disponibilita;
		this.numMax = numMax;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public boolean isDisponibilita() {
		return disponibilita;
	}

	public void setDisponibilita(boolean disponibilita) {
		this.disponibilita = disponibilita;
	}

	public int getNumMax() {
		return numMax;
	}

	public void setNumMax(int numMax) {
		this.numMax = numMax;
	}
	
	

}
