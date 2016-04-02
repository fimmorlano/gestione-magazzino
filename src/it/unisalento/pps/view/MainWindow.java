package it.unisalento.pps.view;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L; // richiesto da tutte le classi che implementano l'interfaccia serializable

	public MainWindow() {
		super("Gestione Magazzino");
		
		Container c = getContentPane();
		BorderLayout b = new BorderLayout();
		c.setLayout(b);

		LoginWindow loginWindow = new LoginWindow();
		RiepilogoOrdineView riepilogoOrdineView = new RiepilogoOrdineView();
		MainWindowDipendente mainWindowDipendente = new MainWindowDipendente();
		PrenotaArticoliWindow prenotaArticoliWindow = new PrenotaArticoliWindow();
		FirstWinCapoProgetto firstWinCapoProgetto = new FirstWinCapoProgetto();
		RapportoOrdiniView rapportoOrdiniView = new RapportoOrdiniView();
		FirstWinMagazziniere firstWinMagazziniere = new FirstWinMagazziniere();
		RifornisciMagazzinoView rifornisciMagazzinoView = new RifornisciMagazzinoView();
		
//		c.add(loginWindow, BorderLayout.CENTER);
//		c.add(riepilogoOrdineView, BorderLayout.CENTER);
//		c.add(mainWindowDipendente, BorderLayout.CENTER);
//		c.add(prenotaArticoliWindow, BorderLayout.CENTER);
//		c.add(firstWinCapoProgetto, BorderLayout.CENTER);
//		c.add(rapportoOrdiniView, BorderLayout.CENTER);
//		c.add(firstWinMagazziniere, BorderLayout.CENTER);
		c.add(rifornisciMagazzinoView, BorderLayout.CENTER);
		
//		loginWindow.setVisible(true);

		setSize(1000,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
//		repaint();
	}

}

