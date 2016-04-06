package it.unisalento.pps.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.unisalento.pps.exception.DaoException;
import it.unisalento.pps.model.Progetto;

/**
 * Dao per la tabella Progetto.
 * 
 * @author fra sara
 *
 */
public class ProgettoDAO {

	private static ProgettoDAO instance;

	private DbConnection dbConnection = DbConnection.getInstance();

	private ProgettoDAO() {
	}
	
	public static ProgettoDAO getInstance() {
		if(instance==null) {	
			instance = new ProgettoDAO();
		}
		return instance;
	}

	/*
	 * CRUD methods
	 */

	public Progetto get (long idProgetto) throws DaoException {
		
		String select = "SELECT * FROM progetto WHERE id_progetto = '"+idProgetto+"';";
		Progetto progetto = null;
		try {
			progetto = exctractProgetto(dbConnection.eseguiQuery(select));
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
		return progetto;
	}

	
	public Progetto create(Progetto progetto) throws DaoException {
		String create = "INSERT INTO progetto (nome, budget) "+ "VALUES ('"+progetto.getNome()+"', '"+progetto.getBudget()+"');";
		long idProgetto = -1;
		try {
			idProgetto = dbConnection.eseguiAggiornamento(create);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
		System.out.println("creato progetto con id:"+idProgetto);
		
		progetto.setIdProgetto(idProgetto);

		return progetto;
	}
	
	
	public Progetto update(Progetto progetto) throws DaoException { 
		String update = "UPDATE progetto SET nome='"+progetto.getNome()+"', budget='"+progetto.getBudget()+"' WHERE id_progetto="+progetto.getIdProgetto()+";";
		try {
			dbConnection.eseguiAggiornamento(update);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
		return progetto;
	}
	
	
	public boolean delete(Progetto progetto) throws DaoException {
		boolean deleted = false;
		
		String update = " DELETE FROM progetto WHERE nome="+progetto.getNome()+", budget="+progetto.getBudget()+" ;" ;
		try {
			dbConnection.eseguiAggiornamento(update);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return deleted;
	}
	
	
	public List<Progetto> findAll() throws DaoException {
		String select = "SELECT * FROM progetto;";
		List<Progetto> listProgetto = null;
		try {
			listProgetto = exctractProgettoList(dbConnection.eseguiQuery(select));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(e);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
		return listProgetto;
	}

	
	

	/*
	 * extra methods
	 */

	/**
	 * 
	 * @param p
	 * @return
	 * @throws Exception
	 */
	
	/**
	 * Estrae un Progetto dalla riga corrente del resultset.
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private Progetto exctractProgetto(ResultSet rs) throws SQLException {
		Progetto progetto = new Progetto();
		progetto.setIdProgetto(rs.getInt("id_progetto"));
		progetto.setNome(rs.getString("nome"));
		progetto.setBudget(rs.getFloat("budget"));
		return progetto;	
	}

	/**
	 * Estrae un elenco di utenti iterando un resultset.
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private List<Progetto> exctractProgettoList(ResultSet rs) throws SQLException {
		List<Progetto> progettoList = null;
		if(rs!=null) {
			progettoList = new ArrayList<Progetto>();
			while(rs.next()) {
				progettoList.add(exctractProgetto(rs));
			}
		}
		return progettoList;
	}
}
