package it.unisalento.pps.dao;

import java.util.Vector;

//import it.unisalento.pps.DbInterface.DbConnection;
import it.unisalento.pps.model.Utente;

public class UtenteDAO {

	private static UtenteDAO instance;
	
	public static UtenteDAO getInstance()
	{
		if(instance==null)
		{	
			instance = new UtenteDAO();
		}
		return instance;
	}
	
	public boolean userExists(Utente p)
	{
		String username = p.getUsername();
		String password = p.getPassword();
		
		// TODO creare tabella su base di dati e verififcare esistenzA UTENTE SU TABELLA
		//SINGLETON
		//Vector<String[]> result=DbConnection.getInstance().eseguiQuery("select * from Persona where username=\""+ username +"\" and password=\""+password+"\"");
		
		return (true);
	}
	
}
