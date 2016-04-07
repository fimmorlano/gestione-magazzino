package it.unisalento.pps.view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import it.unisalento.pps.listeners.LoginBtnListener;

public class LoginWindow extends MainPanel {

	private static final long serialVersionUID = 1L; // richiesto da tutte le classi che implementano l'interfaccia serializable

	private JTextField usernameField;
	private JPasswordField passwordField;

	/**
	 * Possiamo ometterlo se non deve eseguire codice....
	 * verrà chiamato in automatico il costruttore del padre MainPanel
	 */
	public LoginWindow() {
		super();
	}

	@Override
	public void paint(Graphics g) {
		JLabel l1 = new JLabel ("Username:");
		Dimension l1Size = l1.getPreferredSize();
		l1.setBounds(410, 10, l1Size.width, l1Size.height);
		body.add(l1);
		
		usernameField = new JTextField();
		Dimension tf1Size = usernameField.getPreferredSize();
		usernameField.setBounds(420+l1Size.width, 10, 100, tf1Size.height);
		body.add(usernameField);
		
		JLabel l2 = new JLabel ("Password:");
		Dimension l2Size = l2.getPreferredSize();
		l2.setBounds(410, 25+l1Size.height, l2Size.width, l2Size.height);
		body.add(l2);
		
		passwordField = new JPasswordField();
		Dimension tf2Size = passwordField.getPreferredSize();
		passwordField.setBounds(420+l2Size.width, 25+l1Size.height, 100, tf2Size.height);
		body.add(passwordField);
		
		JButton b1 = new JButton("Invio");
		Dimension b1Size = b1.getPreferredSize();
		b1.setBounds(410, 65+l1Size.height, b1Size.width, b1Size.height);
		b1.addActionListener(new LoginBtnListener(this));
		body.add(b1);

		super.paint(g);
	}
	
	/*
	 * Get & Set
	 */

	public JTextField getUsernameField() {
		return usernameField;
	}

	public void setUsernameField(JTextField usernameField) {
		this.usernameField = usernameField;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

}

