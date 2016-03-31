package it.unisalento.pps.test;

import java.util.Date;
import java.util.List;

import it.unisalento.pps.dao.UtenteDAO;
import it.unisalento.pps.model.Utente;

public class UtenteDAOTest {
	
	public static void main(String[] args) {
		UtenteDAO utenteDAO =  UtenteDAO.getInstance();

		try {
			// preparo l'utente mock
			Utente utente = new Utente();
			utente.setNome("nome"+(new Date()).getTime());
			utente.setCognome("cognome"+(new Date()).getTime());
			
			// creo l'utente
			utenteDAO.createUtente(utente);
			
			utente.setNome("nome cambiato");

			utenteDAO.updateUtente(utente);
		} catch (Exception e) {
			e.printStackTrace();
		}

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
	
	private static void stampaUtente(Utente user){
		System.out.println("Trovato Utente:");
		System.out.println("\tNome: "+user.getNome());
		System.out.println("\tCognome: "+user.getCognome());
		System.out.println("\tTelefono: "+user.getTelefono());
		System.out.println("\tCodice fiscale: "+user.getCodiceFiscale());
		System.out.println("\tEmail: "+user.getEmail());
		System.out.println("\tTipo utente: "+user.getTipoUtente());
		System.out.println("\tUsername: "+user.getUsername());
		System.out.println("\tPassword: "+user.getPassword());
	}
	
	
	private static void stampaUtenti (List<Utente> utentiList){
		for (Utente u : utentiList) {
			stampaUtente(u);
		}
	}

}