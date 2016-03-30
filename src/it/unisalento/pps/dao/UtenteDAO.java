package it.unisalento.pps.dao;

import java.util.ArrayList;
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
		try {
			String select = "SELECT * FROM utente WHERE username='"+username+"' ;";
			System.out.println("Sto eseguendo la query:"+select);
			Vector<String[]> v = dbConnection.eseguiQuery(select);
			if(v!=null) {
				//TODO ? prelevare le stringhe dal vettore e passarle come parametri dei setter
				for(String[] userColumns : v) {
					
					user.setIdUtente(userColumns[0]);
					user.setNome(userColumns[1]);
					user.setCognome(userColumns[2]);
					user.setCodiceFiscale(userColumns[3]);
					user.setEmail(userColumns[4]);
					user.setTipoUtente(userColumns[5]);
					user.setUsername(userColumns[6]);
					user.setPassword(userColumns[7]);
				
				}
			} else {
				
				throw new Exception("ATTEZIONE!!! Non sono presenti utenti con questo username");
			}
		} catch (Exception e) {
			e.printStackTrace();
		//	throw new Exception(e);
		}
		
		return user;
	}
	
	

	public Utente getUtente(long idUtente) {
		Utente user = null;
		
		try {
			String select = "SELECT * FROM utente WHERE idUtente='"+idUtente+"' ;";
			System.out.println("Sto eseguendo la query:"+select);
			Vector<String[]> v = dbConnection.eseguiQuery(select);
			if(v!=null) {
				
				for(String[] userColumns : v) {
					
					
					user.setNome(userColumns[0]);
					user.setCognome(userColumns[1]);
					user.setCodiceFiscale(userColumns[2]);
					user.setEmail(userColumns[3]);
					user.setTipoUtente(userColumns[4]);
					user.setUsername(userColumns[5]);
					user.setPassword(userColumns[6]);
				
				}
				
			} else {
				
				throw new Exception("ATTEZIONE!!! Non sono presenti utenti con questo username");
			}
		} catch (Exception e) {
			e.printStackTrace();
		//	throw new Exception(e);
		}
		
		return user;
	}
	
	private Utente makeUtente(String[] userArray) {
		
		Utente user = new Utente();
			
			user.setNome(userArray[0]);
			user.setCognome(userArray[1]);
			user.setCodiceFiscale(userArray[2]);
			user.setEmail(userArray[3]);
			user.setTipoUtente(userArray[4]);
			user.setUsername(userArray[5]);
			user.setPassword(userArray[6]);
		
		return user;	
	}
	
	

	public List<Utente> findAll() {
		
		List<Utente> userList = null;
		
		try {
			String select = "SELECT * FROM utente;";
			System.out.println("Sto eseguendo la query:"+select);
			Vector<String[]> v = dbConnection.eseguiQuery(select);
			
			if(v!=null) {
				userList = new ArrayList<Utente>();
				Utente user = new Utente();
				
				// ciclo il vettore per leggere gli utenti uno ad uno
				for (String[] userColumns : v){
					user = makeUtente(userColumns);
					// aggiungo l'utente i-esimo alla lista
					userList.add(user);
				}
				
				
				
				
			} else {
				
				throw new Exception("ATTEZIONE!!! Non sono presenti utenti con questo username");
			}
		} catch (Exception e) {
			e.printStackTrace();
		//	throw new Exception(e);
		}
		
		return userList;
		
	}

	public List<Utente> findByNome(String nome) {
		List<Utente> userList = null;
		
		try {
			String select = "SELECT * FROM utente WHERE nome='"+nome+"' ;";
			System.out.println("Sto eseguendo la query:"+select);
			Vector<String[]> v = dbConnection.eseguiQuery(select);
			if(v!=null) {
				
				userList = new ArrayList<Utente>();
				Utente user = new Utente();
				
				// ciclo il vettore per leggere gli utenti uno ad uno
				for (String[] userColumns : v){
					user = makeUtente(userColumns);
					
				}
				
				// aggiungo l'utente i-esimo alla lista
				userList.add(user);
				
			} else {
				
				throw new Exception("ATTEZIONE!!! Non sono presenti utenti con questo username");
			}
		} catch (Exception e) {
			e.printStackTrace();
		//	throw new Exception(e);
		}
		
		return userList;
	}
	

	public Utente createUtente(Utente utente) { // TODO ?? ritornare oggetto di tipo Utente o un booleano?
		
		Utente user = null;
		
		try {
			String create = "INSERT INTO utente (nome, cognome, telefono, codice_fiscale, email, tipo_utente, username, password) VALUES ("+utente.getNome()+","+utente.getCognome()+","+utente.getTelefono()+","+utente.getCodiceFiscale()+","+utente.getEmail()+","+utente.getUsername()+","+utente.getPassword()+"); ";
			System.out.println("Sto eseguendo la query:"+create);
			Vector<String[]> v = dbConnection.eseguiQuery(create);
			
			user.setNome(utente.getNome());
			user.setCognome(utente.getCognome());
			user.setCodiceFiscale(utente.getCodiceFiscale());
			user.setEmail(utente.getEmail());
			user.setTipoUtente(utente.getTipoUtente());
			user.setUsername(utente.getUsername());
			user.setPassword(utente.getPassword());
			
		} catch (Exception e) {
			e.printStackTrace();
		//	throw new Exception(e);
		}

		return user;
	}

	
	public Utente updateUtente(Utente utente) { 
		Utente user = null;
		
		try {
			String update = "UPDATE utente SET nome="+utente.getNome()+", cognome="+utente.getCognome()+", telefono="+utente.getTelefono()+", codice_fiscale="+utente.getCodiceFiscale()+", email="+utente.getEmail()+", username="+utente.getUsername()+", password="+utente.getPassword()+" WHERE nome="+utente.getNome()+", cognome="+utente.getCognome()+" ;";
			System.out.println("Sto eseguendo la query:"+update);
			Vector<String[]> v = dbConnection.eseguiQuery(update);
			if(v!=null) {
				
				user.setNome(utente.getNome());
				user.setCognome(utente.getCognome());
				user.setCodiceFiscale(utente.getCodiceFiscale());
				user.setEmail(utente.getEmail());
				user.setTipoUtente(utente.getTipoUtente());
				user.setUsername(utente.getUsername());
				user.setPassword(utente.getPassword());
				
			} else {
				
				throw new Exception("ATTEZIONE!!! Non sono presenti utenti con questo username");
			}
		} catch (Exception e) {
			e.printStackTrace();
		//	throw new Exception(e);
		}

		return user;
	}

	
	public boolean deleteUtente(Utente utente) {
		boolean deleted = false;
		
		try {
			String update = " DELETE FROM utente WHERE nome="+utente.getNome()+", cognome="+utente.getCognome()+" ;" ;
			System.out.println("Sto eseguendo la query:"+update);
			Vector<String[]> v = dbConnection.eseguiQuery(update);
			if(v!=null) {
				
				deleted = true;
				
			} else {
				
				throw new Exception("ATTEZIONE!!! Non sono presenti utenti con questo username");
			}
		} catch (Exception e) {
			e.printStackTrace();
		//	throw new Exception(e);
		}

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
	public boolean userExists(String username, String password) throws Exception {
		boolean userExists = false;
		
		try {
			String select = "SELECT * FROM utente WHERE username='"+username+"' AND password='"+password+"' ;";
			System.out.println("Sto eseguendo la query:"+select);
			Vector<String[]> v = dbConnection.eseguiQuery(select);
			if(v!=null && v.size()==1) {
				userExists = true;
			} else if(v.size()>1){
				throw new Exception("ATTEZIONE!!! sono stati trovati più utenti con le stesse credenziali!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		
		return userExists;
	}
	
}
