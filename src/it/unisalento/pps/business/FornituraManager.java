package it.unisalento.pps.business;

import it.unisalento.pps.model.Fornitura;

public class FornituraManager {

	
private static FornituraManager instance;
	
	public static synchronized FornituraManager getInstance() {
		if(instance == null)
			instance = new FornituraManager();
		return instance;
	}
	
	
	public Fornitura effettuaFornitura(String nomeMagazziniere, String cognomeMagazziniere, String nomeArticolo, String codiceArticolo, int quantita){
		
		Fornitura f = new Fornitura(nomeMagazziniere, cognomeMagazziniere, nomeArticolo, codiceArticolo, quantita);
		return f;
	}

}
