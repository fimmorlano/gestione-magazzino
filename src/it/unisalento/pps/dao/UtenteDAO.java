package it.unisalento.pps.dao;

import java.util.List;
import java.util.Vector;

import it.unisalento.pps.model.Utente;

/**
 * Dao per la tabella utente.
 * 
 * @author fra sara
 *
 */
public class UtenteDAO {

	private static UtenteDAO instance;

	private DbConnection dbConnection = DbConnection.getInstance();

	private UtenteDAO() {
	}
	
	public static UtenteDAO getInstance() {
		if(instance==null) {	
			instance = new UtenteDAO();
		}
		return instance;
	}

	/*
	 * CRUD methods
	 */
	public Utente getUtente(String username) {
		Utente user = null;
		// cerca l'utente nel db
		// se lo trova inizializza l'oggetto user e lo popola
		return user;
	}

	public Utente getUtente(long idUtente) {
		Utente user = null;
		// cerca l'utente nel db
		// se lo trova inizializza l'oggetto user e lo popola
		return user;
	}

	public List<Utente> findAll() {
		List<Utente> userList = null;
		return userList;
	}

	public List<Utente> findByNome(String nome) {
		List<Utente> userList = null;
		return userList;
	}

	public Utente createUtente(Utente utente) {
		Utente user = null;

		return user;
	}

	public Utente updateUtente(Utente utente) {
		Utente user = null;

		return user;
	}

	public boolean deleteUtente(Utente utente) {
		boolean deleted = false;

		return deleted;
	}

	/*
	 * extra methods
	 */

	/**
	 * Restituisce true se username e password passati in input
	 * corrispondono ad una riga nella tabella utente.
	 * 
	 * @param p
	 * @return
	 * @throws Exception
	 */
	public boolean login(String username, String password) throws Exception {
		boolean login = false;
		
		try {
			String select = "SELECT * FROM utente WHERE username='"+username+"' AND password='"+password+"' ;";
			System.out.println("Sto eseguendo la query:"+select);
			Vector<String[]> v = dbConnection.eseguiQuery(select);
			if(v!=null && v.size()==1) {
				login = true;
			} else if(v.size()>1){
				throw new Exception("ATTEZIONE!!! sono stati trovati più utenti con le stesse credenziali!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		
		return login;
	}
	
}
