/*
 * classe che permette di effettuare ordini
 */
package it.unisalento.pps.business;

import it.unisalento.pps.model.Ordine;



public class OrdineManager {

	private static OrdineManager instance;
	
	public static synchronized OrdineManager getInstance() {
		if(instance == null)
			instance = new OrdineManager();
		return instance;
	}
	
	
	
	public Ordine effettuaOrdine(String username, String codiceArticolo, int quantita, String idMagazzino, String nomeProgetto){
		
		Ordine o = new Ordine(username, codiceArticolo, quantita, idMagazzino, nomeProgetto);
		return o;
	}
	
	
	
	public void evadiOrdine (String username, String codiceArticolo, int quantita){
		
		//deve andare ad eliminare la riga nel db
		
	}
}
