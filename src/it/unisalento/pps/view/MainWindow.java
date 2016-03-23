package it.unisalento.pps.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import it.unisalento.pps.listeners.LoginBtnListener;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L; // richiesto da tutte le classi che implementano l'interfaccia serializable

	private JTextField usernameField;
	private JPasswordField passwordField;

	public MainWindow() {
		super("Gestione Magazzino");
		
		Container c = getContentPane();
		BorderLayout b = new BorderLayout();
		c.setLayout(b);

		JPanel nord = new JPanel();
		JPanel centro = new JPanel();
		
		centro.setLayout(null);
		
		c.add(centro, BorderLayout.CENTER);
		
		
		JLabel img = new JLabel(new ImageIcon("C:\\Users\\Fra\\Desktop\\Università\\Principi di progettazione del software\\Progetto\\img.jpg"));
		nord.add(img);
		c.add(nord, BorderLayout.NORTH);
		
		setSize(1000,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

}

