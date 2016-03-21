package it.unisalento.pps.model;

public class Progetto {
	
	private String nome;
	private float budget;
	private String nomeCapoProgetto;
	private String cognomeCapoProgetto;
	

	public Progetto(String nome, float budget, String nomeCapoProgetto, String cognomeCapoProgetto) {
		this.nome = nome;
		this.budget = budget;
		this.nomeCapoProgetto = nomeCapoProgetto;
		this.cognomeCapoProgetto = cognomeCapoProgetto;
		
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public float getBudget() {
		return budget;
	}


	public void setBudget(float budget) {
		this.budget = budget;
	}


	public String getNomeCapoProgetto() {
		return nomeCapoProgetto;
	}


	public void setNomeCP(String nomeCapoProgetto) {
		this.nomeCapoProgetto = nomeCapoProgetto;
	}


	public String getCognomeCapoProgetto() {
		return cognomeCapoProgetto;
	}


	public void setCognomeCP(String cognomeCapoProgetto) {
		this.cognomeCapoProgetto = cognomeCapoProgetto;
	}

	
}
