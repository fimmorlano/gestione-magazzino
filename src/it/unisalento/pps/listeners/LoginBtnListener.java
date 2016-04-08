package it.unisalento.pps.listeners;

import it.unisalento.pps.business.UtenteBusiness;
import it.unisalento.pps.model.Utente;
import it.unisalento.pps.view.LoginPanel;
import it.unisalento.pps.view.MainWindow.CardPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class LoginBtnListener implements ActionListener {

	private LoginPanel loginPanel;
	
	public LoginBtnListener(LoginPanel loginPanel) {
		super();
		this.loginPanel = loginPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String username = loginPanel.getUsernameField().getText();
		String password = loginPanel.getPasswordField().getText();
		
		boolean utenteEsiste = UtenteBusiness.getInstance().verificaLogin(username, password);
		
		if(utenteEsiste) {
			JOptionPane.showMessageDialog(null, "Benvenuto!");
			Utente utente = new Utente();
			utente.setNome("Marco");
			utente.setCognome("Ingrosso");
			loginPanel.updateLoginStatus(utente);
			loginPanel.redirect(CardPanel.MAGAZZINIERE);
		}
		else {
			JOptionPane.showMessageDialog(null, "Utente non riconosciuto");
		}
			
		
	}

}