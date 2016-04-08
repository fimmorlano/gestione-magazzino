package it.unisalento.pps.view;

import java.awt.Graphics;
import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import it.unisalento.pps.model.Utente;

/**
 * Pannello generico con metodi e caratteristiche
 * comuni a tutti i pannelli.
 * 
 * @author sara francesco
 *
 */
public class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L; // richiesto da tutte le classi che implementano l'interfaccia serializable
	
	public MainPanel() {
		super();
	}

	public MainPanel(LayoutManager l) {
		super(l);
	}

	@Override
	public void paint(Graphics g) {
		System.out.println("MainPanel :: paint()");
		super.paint(g);
	}

	/**
	 * Fornisce l'informazione sull'utente attualmente loggato
	 * conservata nella classe della finestra principale dell'applicazione.
	 * @return
	 */
	protected Utente getLoggedUser(){
		// reperisco la mainWindow
		MainWindow mainWindow = (MainWindow) SwingUtilities.getWindowAncestor(this);
		return mainWindow.getUser();
	}

	/**
	 * Richiede al contenitore MainWindow la visualizzazione di
	 * un altro pannello tra quelli disponibili nella collezione di cards.
	 * 
	 * @param panelId
	 */
	public void redirect(String panelId) {
		// reperisco la mainWindow
		MainWindow mainWindow = (MainWindow) SwingUtilities.getWindowAncestor(this);
		// visualizzo il pannello desiderato contenuto nella mainWindow
		mainWindow.showPanel(panelId);
	}

	/*
	 * Get & Set
	 */

}

