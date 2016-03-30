package it.unisalento.pps.test;

import java.util.List;

import it.unisalento.pps.dao.UtenteDAO;
import it.unisalento.pps.model.Utente;

public class UtenteDAOTest {
	
	
	
	private static void stampaUtente(Utente user){
		System.out.println("Nome: "+user.getNome());
		System.out.println("Cognome: "+user.getCognome());
		System.out.println("Telefono: "+user.getTelefono());
		System.out.println("Codice fiscale: "+user.getCodiceFiscale());
		System.out.println("Email: "+user.getEmail());
		System.out.println("Tipo utente: "+user.getTipoUtente());
		System.out.println("Username: "+user.getUsername());
		System.out.println("Password: "+user.getPassword());
	}
	
	
	private static void stampaUtenti (List<Utente> utentiList){
		for (Utente u : utentiList) {
			stampaUtente(u);
		}
	}

	public static void main(String[] args) {
		UtenteDAO utenteDAO =  UtenteDAO.getInstance();
		
		try {
			boolean userExists = utenteDAO.userExists("marcoingrosso", "marcoingrosso");
			if(userExists) {
				System.out.println("test di login eseguito con successo!");
			} else {
				System.out.println("login fallito!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try{
			List<Utente> findAll = utenteDAO.findAll();
			if(findAll != null){
				System.out.println("test di find all eseguito con successo");
				stampaUtenti(findAll);
			} else {
				System.out.println("test fallito");
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
			
	}
}