package it.unisalento.pps.test;

import it.unisalento.pps.dao.UtenteDAO;

public class UtenteDAOTest {

	public static void main(String[] args) {
		UtenteDAO utenteDAO =  UtenteDAO.getInstance();
		try {
			boolean login = utenteDAO.login("marcoingrosso", "marcoingrosso");
			if(login) {
				System.out.println("test di login eseguito con successo!");
			} else {
				System.out.println("login fallito!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}