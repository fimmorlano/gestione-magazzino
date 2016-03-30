package it.unisalento.pps.view;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L; // richiesto da tutte le classi3 che implementano l'interfaccia serializable

	public MainWindow() {
		super("Gestione Magazzino");
		
		Container c = getContentPane();
		BorderLayout b = new BorderLayout();
		c.setLayout(b);

		LoginWindow loginWindow = new LoginWindow();
		RiepilogoOrdineView riepilogoOrdineView = new RiepilogoOrdineView();
		
		c.add(loginWindow, BorderLayout.CENTER);
//		c.add(riepilogoOrdineView, BorderLayout.CENTER);
		
//		loginWindow.setVisible(true);

		setSize(1000,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
//		repaint();
	}

}

