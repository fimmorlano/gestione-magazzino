package it.unisalento.pps.test;

import it.unisalento.pps.dao.DbConnection;

public class DatabaseTest {

	public static void main(String[] args) {
		DbConnection dbConnection =  DbConnection.getInstance();
		dbConnection.eseguiQuery("SELECT 1;");
	}
}