package it.unisalento.pps.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.unisalento.pps.exception.DaoException;
import it.unisalento.pps.model.Produttore;

/**
 * Dao per la tabella Produttore.
 * 
 * @author fra sara
 *
 */
public class ProduttoreDAO {

	private static ProduttoreDAO instance;

	private DbConnection dbConnection = DbConnection.getInstance();

	private ProduttoreDAO() {
	}
	
	public static ProduttoreDAO getInstance() {
		if(instance==null) {	
			instance = new ProduttoreDAO();
		}
		return instance;
	}

	/*
	 * CRUD methods
	 */

	public Produttore get(long idProduttore) throws DaoException {
		String select = "SELECT * FROM produttore WHERE id_produttore="+idProduttore+" ;";
		Produttore produttore = null;
		try {
			produttore = exctractProduttore(dbConnection.eseguiQuery(select));
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
		return produttore;
	}

	public Produttore create(Produttore produttore) throws DaoException {
		String create = "INSERT INTO produttore (nome, telefono, email, citta) "+ "VALUES ('"+produttore.getNome()+"', '"+produttore.getTelefono()+"', '"+produttore.getEmail()+"', '"+produttore.getCitta()+"');";
		long idProduttore = -1;
		try {
			idProduttore = dbConnection.eseguiAggiornamento(create);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
		System.out.println("creato produttore con id:"+idProduttore);
		
		produttore.setIdProduttore(idProduttore);

		return produttore;
	}

	
	public Produttore update(Produttore produttore) throws DaoException { 
		String update = "UPDATE produttore SET nome='"+produttore.getNome()+"', telefono='"+produttore.getTelefono()+"', email='"+produttore.getEmail()+"', citta='"+produttore.getCitta()+"' WHERE id_produttore="+produttore.getIdProduttore()+";";
		try {
			dbConnection.eseguiAggiornamento(update);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
		return produttore;
	}

	
	public boolean delete(Produttore produttore) throws DaoException {
		boolean deleted = false;
		
		String update = " DELETE FROM produttore WHERE id_produttore=" + produttore.getIdProduttore() + " ;" ;
		try {
			dbConnection.eseguiAggiornamento(update);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return deleted;
	}


	public List<Produttore> findAll() throws DaoException {
		String select = "SELECT * FROM Produttore;";
		List<Produttore> listProduttore = null;
		try {
			listProduttore = exctractProduttoreList(dbConnection.eseguiQuery(select));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(e);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
		return listProduttore;
	}

	public List<Produttore> findByNome(String nome) throws DaoException {
		String select = "SELECT * FROM produttore WHERE nome='"+nome+"' ;";
		List<Produttore> listProduttore = null;
		try {
			listProduttore = exctractProduttoreList(dbConnection.eseguiQuery(select));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(e);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
		return listProduttore;
	}

	/*
	 * extra methods
	 */

	

	/**
	 * Estrae un Produttore dalla riga corrente del resultset.
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private Produttore exctractProduttore(ResultSet rs) throws SQLException {
		Produttore produttore = new Produttore();
		produttore.setIdProduttore(rs.getLong("id_produttore"));
		produttore.setNome(rs.getString("nome"));
		produttore.setTelefono(rs.getString("telefono"));
		produttore.setEmail(rs.getString("email"));
		produttore.setCitta(rs.getString("citta"));
		
		return produttore;	
	}

	/**
	 * Estrae un elenco di utenti iterando un resultset.
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private List<Produttore> exctractProduttoreList(ResultSet rs) throws SQLException {
		List<Produttore> userList = null;
		if(rs!=null) {
			userList = new ArrayList<Produttore>();
			while(rs.next()) {
				userList.add(exctractProduttore(rs));
			}
		}
		return userList;
	}
	
}
