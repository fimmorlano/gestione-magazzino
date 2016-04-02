package it.unisalento.pps.business;

import it.unisalento.pps.model.Utente;

public class UtenteBusiness {

	private static UtenteBusiness instance;
	
	//SINGLETON
	public static UtenteBusiness getInstance()
	{
		if(instance == null)
			instance = new UtenteBusiness();
		return instance;
	}
	
	public boolean verificaLogin(String username, String password)
	{
		Utente p=new Utente(); //TODO ? sarebbe opportuno creare un costruttore Utente (Strin username, String password) e richiamarlo qua dentro?
		return p.login();
	}
	
}