package it.unisalento.pps.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.unisalento.pps.exception.DaoException;
import it.unisalento.pps.model.Magazzino;
import it.unisalento.pps.model.Utente;

/**
 * Dao per la tabella magazzino.
 * 
 * @author fra sara
 *
 */
public class MagazzinoDAO {

	private static MagazzinoDAO instance;

	private DbConnection dbConnection = DbConnection.getInstance();

	private MagazzinoDAO() {
	}
	
	public static MagazzinoDAO getInstance() {
		if(instance==null) {	
			instance = new MagazzinoDAO();
		}
		return instance;
	}

	/*
	 * CRUD methods
	 */
	
	public Magazzino get(long idMagazzino) throws DaoException {
		String select = "SELECT * FROM magazzino WHERE id_magazzino="+idMagazzino+" ;";
		Magazzino magazzino= null;
		try {
			magazzino = exctractMagazzino(dbConnection.eseguiQuery(select));
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
		return magazzino;
	}
	
	
	public Magazzino create(Magazzino magazzino) throws DaoException {
		String create = "INSERT INTO magazzino (telefono, indirizzo, citta) "+ "VALUES ('"+magazzino.getTelefono()+"', '"+magazzino.getIndirizzo()+"', '"+magazzino.getCitta()+"');";
		long idMagazzino = -1;
		try {
			idMagazzino = dbConnection.eseguiAggiornamento(create);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
		System.out.println("creato magazzino con id:"+idMagazzino);
		
		magazzino.setIdMagazzino(idMagazzino);

		return magazzino;
	}
	
	
	public Magazzino update(Magazzino magazzino) throws DaoException { 
		String update = "UPDATE magazzino SET telefono='"+magazzino.getTelefono()+"', indirizzo='"+magazzino.getIndirizzo()+"', citta='"+magazzino.getCitta()+"' WHERE id_magazzino="+magazzino.getIdMagazzino()+";";
		try {
			dbConnection.eseguiAggiornamento(update);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
		return magazzino;
	}
	
	
	public boolean delete(Magazzino magazzino) throws Exception {
		boolean deleted = false;
		
		String update = " DELETE FROM magazzino WHERE telefono="+magazzino.getTelefono()+", indirizzo="+magazzino.getIndirizzo()+", citta="+magazzino.getCitta()+" ;" ;

		try {
			dbConnection.eseguiAggiornamento(update);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return deleted;
	}

	
	public List<Magazzino> findAll() throws DaoException {
		String select = "SELECT * FROM magazzino;";
		List<Magazzino> listMagazzino = null;
		try {
			listMagazzino = exctractMagazzinoList(dbConnection.eseguiQuery(select));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(e);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
		return listMagazzino;
	}
	
	
	

	/*
	 * extra methods
	 */

	/**
	 * Restituisce true se username e password passati in input
	 * corrispondono ad una riga nella tabella Magazzino.
	 * 
	 * @param p
	 * @return
	 * @throws Exception
	 */
	
	
	
	/**
	 * Estrae un Magazzino dalla riga corrente del resultset.
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private Magazzino exctractMagazzino(ResultSet rs) throws SQLException {
		Magazzino magazzino = new Magazzino();
		magazzino.setIdMagazzino(rs.getInt("id_magazzino"));
		magazzino.setTelefono(rs.getString("telefono"));
		magazzino.setIndirizzo(rs.getString("indirizzo"));
		magazzino.setCitta(rs.getString("citta"));
		return magazzino;	
	}

	/**
	 * Estrae un elenco di magazzini iterando un resultset.
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private List<Magazzino> exctractMagazzinoList(ResultSet rs) throws SQLException {
		List<Magazzino> magazzinoList = null;
		if(rs!=null) {
			magazzinoList = new ArrayList<Magazzino>();
			while(rs.next()) {
				magazzinoList.add(exctractMagazzino(rs));
			}
		}
		return magazzinoList;
	}
	
	
}
