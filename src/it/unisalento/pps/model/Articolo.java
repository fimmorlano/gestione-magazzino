package it.unisalento.pps.model;

public class Articolo {
	
	private String categoria;
	private String prodotto;
	private String nome;
	private String codice;
	private float prezzo;
	
	

	public Articolo(String categoria, String prodotto, String nome, String codice, float prezzo) {
		this.categoria = categoria;
		this.prodotto = prodotto;
		this.nome = nome;
		this.codice = codice;
		this.prezzo = prezzo;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCodice() {
		return codice;
	}



	public void setCodice(String codice) {
		this.codice = codice;
	}



	public float getPrezzo() {
		return prezzo;
	}



	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}



	public String getCategoria() {
		return categoria;
	}



	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}



	public String getProdotto() {
		return prodotto;
	}



	public void setProdotto(String prodotto) {
		this.prodotto = prodotto;
	}
	
	

	
}
