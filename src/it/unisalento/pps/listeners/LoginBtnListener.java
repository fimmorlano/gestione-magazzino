package it.unisalento.pps.listeners;

import it.unisalento.pps.business.UtenteBusiness;
import it.unisalento.pps.view.LoginWindow;
import it.unisalento.pps.view.MainWindow.CardPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class LoginBtnListener implements ActionListener {

	private LoginWindow loginWindow;
	
	public LoginBtnListener(LoginWindow loginWindow) {
		super();
		this.loginWindow = loginWindow;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String username = loginWindow.getUsernameField().getText();
		String password = loginWindow.getPasswordField().getText();
		
		boolean utenteEsiste = UtenteBusiness.getInstance().verificaLogin(username, password);
		
		if(utenteEsiste) {
			JOptionPane.showMessageDialog(null, "Benvenuto!");
		}
		else {
			JOptionPane.showMessageDialog(null, "Utente non riconosciuto");
			loginWindow.redirect(CardPanel.MAGAZZIENERE.getCardId());
		}
			
		
	}

}