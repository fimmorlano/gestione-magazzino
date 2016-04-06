package it.unisalento.pps.model;

public class Progetto {
	
	private long idProgetto;
	private String nome;
	private float budget;
//	private String nomeCapoProgetto; TODO ??? cosa fare con questi attributi
//	private String cognomeCapoProgetto;
	

	public Progetto(long idProgetto, String nome, float budget, String nomeCapoProgetto, String cognomeCapoProgetto) {
		this.idProgetto = idProgetto;
		this.nome = nome;
		this.budget = budget;
//		this.nomeCapoProgetto = nomeCapoProgetto;
//		this.cognomeCapoProgetto = cognomeCapoProgetto;
		
	}

	public Progetto() {
		
	}

	public long getIdProgetto() {
		return idProgetto;
	}


	public void setIdProgetto(long idProgetto) {
		this.idProgetto = idProgetto;
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


//	public String getNomeCapoProgetto() {
//		return nomeCapoProgetto;
//	}


//	public void setNomeCP(String nomeCapoProgetto) {
//		this.nomeCapoProgetto = nomeCapoProgetto;
//	}


//	public String getCognomeCapoProgetto() {
//		return cognomeCapoProgetto;
//	}


//	public void setCognomeCP(String cognomeCapoProgetto) {
//		this.cognomeCapoProgetto = cognomeCapoProgetto;
//	}

	
}
