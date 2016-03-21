package it.unisalento.pps.business;

import it.unisalento.pps.model.Articolo;

public class ArticoloManager {

private static ArticoloManager instance;
	
	public static synchronized ArticoloManager getInstance() {
		if(instance == null)
			instance = new ArticoloManager();
		return instance;
	}
	
	
	
	
	
	

}
