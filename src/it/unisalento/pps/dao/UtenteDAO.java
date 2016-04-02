package it.unisalento.pps.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.unisalento.pps.exception.DaoException;
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

	public Utente get(long idUtente) throws DaoException {
		String select = "SELECT * FROM utente WHERE idUtente="+idUtente+" ;";
		Utente utente = null;
		try {
			utente = exctractUtente(dbConnection.eseguiQuery(select));
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
		return utente;
	}

	public Utente create(Utente utente) throws DaoException {
		String create = "INSERT INTO utente (nome, cognome, telefono, codice_fiscale, email, tipo_utente, username, password) "+ "VALUES ('"+utente.getNome()+"', '"+utente.getCognome()+"', '"+utente.getTelefono()+"', '"+utente.getCodiceFiscale()+"', '"+utente.getEmail()+"', 'DIPENDENTE', '"+utente.getUsername()+"', '"+utente.getPassword()+"');";
		long idUtente = -1;
		try {
			idUtente = dbConnection.eseguiAggiornamento(create);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
		System.out.println("creato utente con id:"+idUtente);
		
		utente.setIdUtente(idUtente);

		return utente;
	}

	
	public Utente update(Utente utente) throws DaoException { 
		String update = "UPDATE utente SET nome='"+utente.getNome()+"', cognome='"+utente.getCognome()+"', telefono='"+utente.getTelefono()+"', codice_fiscale='"+utente.getCodiceFiscale()+"', email='"+utente.getEmail()+"', username='"+utente.getUsername()+"', password='"+utente.getPassword()+"' WHERE id_utente="+utente.getIdUtente()+";";
		try {
			dbConnection.eseguiAggiornamento(update);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
		return utente;
	}

	
	public boolean delete(Utente utente) throws DaoException {
		boolean deleted = false;
		
		String update = " DELETE FROM utente WHERE id_utente=" + utente.getIdUtente() + " ;" ;
		try {
			dbConnection.eseguiAggiornamento(update);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return deleted;
	}

	public Utente getByUsername(String username) throws DaoException {
		String select = "SELECT * FROM utente WHERE username='"+username+"' ;";
		Utente utente = null;
		try {
			utente = exctractUtente(dbConnection.eseguiQuery(select));
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
		return utente;
	}

	public List<Utente> findAll() throws DaoException {
		String select = "SELECT * FROM utente;";
		List<Utente> listUtente = null;
		try {
			listUtente = exctractUtenteList(dbConnection.eseguiQuery(select));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(e);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
		return listUtente;
	}

	public List<Utente> findByNome(String nome) throws DaoException {
		String select = "SELECT * FROM utente WHERE nome='"+nome+"' ;";
		List<Utente> listUtente = null;
		try {
			listUtente = exctractUtenteList(dbConnection.eseguiQuery(select));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(e);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
		return listUtente;
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
	 * @throws DaoException
	 */
	public boolean userExists(String username, String password) throws DaoException {
		boolean userExists = false;
		
		String select = "SELECT * FROM utente WHERE username='"+username+"' AND password='"+password+"' ;";
		List<Utente> elencoUtente;
		try {
			elencoUtente = exctractUtenteList(dbConnection.eseguiQuery(select));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(e);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
		if(elencoUtente!=null && elencoUtente.size()==1) {
			userExists = true;
		} else if(elencoUtente.size()>1){
			throw new DaoException("ATTEZIONE!!! sono stati trovati più utenti con le stesse credenziali!!!");
		}
		
		return userExists;
	}

	/**
	 * Estrae un utente dalla riga corrente del resultset.
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private Utente exctractUtente(ResultSet rs) throws SQLException {
		Utente user = new Utente();
		user.setIdUtente(rs.getLong("id_utente"));
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
	
}
