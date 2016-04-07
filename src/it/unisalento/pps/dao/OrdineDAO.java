package it.unisalento.pps.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.unisalento.pps.model.Utente;

/**
 * Dao per la tabella utente.
 * 
 * @author fra sara
 *
 */
public class OrdineDAO {

	private static OrdineDAO instance;

	private DbConnection dbConnection = DbConnection.getInstance();

	private OrdineDAO() {
	}
	
	public static OrdineDAO getInstance() {
		if(instance==null) {	
			instance = new OrdineDAO();
		}
		return instance;
	}

	/*
	 * CRUD methods
	 */
//	public Utente getUtente(String username) {
//		Utente user = null;
//		// cerca l'utente nel db
//		// se lo trova inizializza l'oggetto user e lo popola
//		try {
//			String select = "SELECT * FROM utente WHERE username='"+username+"' ;";
//			System.out.println("Sto eseguendo la query:"+select);
//			Vector<String[]> v = dbConnection.eseguiQuery(select);
//			if(v!=null) {
//				//TODO ? prelevare le stringhe dal vettore e passarle come parametri dei setter
//				for(String[] userColumns : v) {
//					
//					user.setIdUtente(userColumns[0]);
//					user.setNome(userColumns[1]);
//					user.setCognome(userColumns[2]);
//					user.setCodiceFiscale(userColumns[3]);
//					user.setEmail(userColumns[4]);
//					user.setTipoUtente(userColumns[5]);
//					user.setUsername(userColumns[6]);
//					user.setPassword(userColumns[7]);
//				
//				}
//			} else {
//				
//				throw new Exception("ATTEZIONE!!! Non sono presenti utenti con questo username");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		//	throw new Exception(e);
//		}
//		
//		return user;
//	}
	
	

//	public Utente getUtente(long idUtente) {
//		Utente user = null;
//		
//		try {
//			String select = "SELECT * FROM utente WHERE idUtente='"+idUtente+"' ;";
//			System.out.println("Sto eseguendo la query:"+select);
//			Vector<String[]> v = dbConnection.eseguiQuery(select);
//			if(v!=null) {
//				
//				for(String[] userColumns : v) {
//					
//					
//					user.setNome(userColumns[0]);
//					user.setCognome(userColumns[1]);
//					user.setCodiceFiscale(userColumns[2]);
//					user.setEmail(userColumns[3]);
//					user.setTipoUtente(userColumns[4]);
//					user.setUsername(userColumns[5]);
//					user.setPassword(userColumns[6]);
//				
//				}
//				
//			} else {
//				
//				throw new Exception("ATTEZIONE!!! Non sono presenti utenti con questo username");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		//	throw new Exception(e);
//		}
//		
//		return user;
//	}

	/**
	 * Estrae un utente dalla riga corrente del resultset.
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private Utente exctractUtente(ResultSet rs) throws SQLException {
		Utente user = new Utente();
		user.setIdUtente(rs.getInt("id_utente"));
		user.setCodiceFiscale(rs.getString("codice_fiscale"));
		user.setCognome(rs.getString("cognome"));
		user.setNome(rs.getString("nome"));
		user.setEmail(rs.getString("email"));
		user.setTipoUtente(rs.getString("tipo_utente"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password")); // FIXME occorre criptarla con ssha prima di memoruizzarla sul db e di esporla con Utente bean?
		return user;	
	}

	/**
	 * Estrae un elenco di utenti iterando un resultset.
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private List<Utente> exctractUtenteList(ResultSet rs) throws SQLException {
		List<Utente> userList = null;
		if(rs!=null) {
			userList = new ArrayList<Utente>();
			while(rs.next()) {
				userList.add(exctractUtente(rs));
			}
		}
		return userList;
	}
	
	

	public List<Utente> findAll() throws Exception {
		String select = "SELECT * FROM utente;";
		return exctractUtenteList(dbConnection.eseguiQuery(select));
	}

	public List<Utente> findByNome(String nome) throws Exception {
		String select = "SELECT * FROM utente WHERE nome='"+nome+"' ;";
		return exctractUtenteList(dbConnection.eseguiQuery(select));
	}
	

	public Utente createUtente(Utente utente) throws Exception { // TODO ?? ritornare oggetto di tipo Utente o un booleano?
		String create = "INSERT INTO utente (nome, cognome, telefono, codice_fiscale, email, tipo_utente, username, password) "+ "VALUES ('"+utente.getNome()+"', '"+utente.getCognome()+"', '"+utente.getTelefono()+"', '"+utente.getCodiceFiscale()+"', '"+utente.getEmail()+"', 'DIPENDENTE', '"+utente.getUsername()+"', '"+utente.getPassword()+"');";
		long idUtente = dbConnection.eseguiAggiornamento(create);
		System.out.println("creato utente con id:"+idUtente);
		
		utente.setIdUtente(idUtente);

		return utente;
	}

	
	public Utente updateUtente(Utente utente) throws Exception { 
		String update = "UPDATE utente SET nome='"+utente.getNome()+"', cognome='"+utente.getCognome()+"', telefono='"+utente.getTelefono()+"', codice_fiscale='"+utente.getCodiceFiscale()+"', email='"+utente.getEmail()+"', username='"+utente.getUsername()+"', password='"+utente.getPassword()+"' WHERE id_utente="+utente.getIdUtente()+";";
		dbConnection.eseguiAggiornamento(update);
		return utente;
	}

	
	public boolean deleteUtente(Utente utente) throws Exception {
		boolean deleted = false;
		
		String update = " DELETE FROM utente WHERE nome="+utente.getNome()+", cognome="+utente.getCognome()+" ;" ;
		dbConnection.eseguiAggiornamento(update);

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
		
		String select = "SELECT * FROM utente WHERE username='"+username+"' AND password='"+password+"' ;";
		List<Utente> elencoUtente = exctractUtenteList(dbConnection.eseguiQuery(select));
		if(elencoUtente!=null && elencoUtente.size()==1) {
			userExists = true;
		} else if(elencoUtente.size()>1){
			throw new Exception("ATTEZIONE!!! sono stati trovati più utenti con le stesse credenziali!!!");
		}
		
		return userExists;
	}
	
}
