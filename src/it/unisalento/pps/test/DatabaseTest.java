package it.unisalento.pps.test;

import it.unisalento.pps.dao.DbConnection;

public class DatabaseTest {

	public static void main(String[] args) {
		DbConnection dbConnection =  DbConnection.getInstance();
		try {
			dbConnection.eseguiQuery("SELECT 1;");
			System.out.println("test di connessione eseguito con successo!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}