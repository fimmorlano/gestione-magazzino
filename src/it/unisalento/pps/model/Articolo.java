package it.unisalento.pps.model;

public class Articolo {
	
	private long idArticolo;
	private String nome;
	private String categoria;
	private String prodotto;
	private float prezzo;
	
	

	public Articolo(long idArticolo, String nome, String categoria, String prodotto, float prezzo) {
		this.idArticolo = idArticolo;
		this.nome = nome;
		this.categoria = categoria;
		this.prodotto = prodotto;
		this.prezzo = prezzo;
	}
	
	
	public Articolo() {
		
	}



	
	

	/*
	 * Get & Set
	 */
	

	public long getIdArticolo() {
		return idArticolo;
	}


	public void setIdArticolo(long idArticolo) {
		this.idArticolo = idArticolo;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
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
