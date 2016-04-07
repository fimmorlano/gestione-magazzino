package it.unisalento.pps.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Pannello generico con metodi e caratteristiche
 * comuni a tutti i pannelli.
 * 
 * @author
 *
 */
public class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L; // richiesto da tutte le classi che implementano l'interfaccia serializable

	protected JPanel header;
	protected JPanel menu;
	protected JPanel body;

	public MainPanel() {
		super(new BorderLayout());

		/*
		 * Inizializzo i pannelli che compongono il layout
		 * generico dell'applicazione
		 */
		header = new JPanel();
		menu = new JPanel();
		body = new JPanel();

		/*
		 * Imposto il layout per ogni pannello creato
		 */
		header.setLayout(new BorderLayout());
		menu.setLayout(new BorderLayout());
		body.setLayout(new BorderLayout());

		/*
		 * Aggiungo i pannelli al mainPanel
		 */
		this.add(header);
		this.add(menu);
		this.add(body);
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

	public JPanel getHeader() {
		return header;
	}

	public void setHeader(JPanel header) {
		this.header = header;
	}

	public JPanel getMenu() {
		return menu;
	}

	public void setMenu(JPanel menu) {
		this.menu = menu;
	}

	public JPanel getBody() {
		return body;
	}

	public void setBody(JPanel body) {
		this.body = body;
	}

}

