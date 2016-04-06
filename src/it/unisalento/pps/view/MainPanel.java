package it.unisalento.pps.view;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L; // richiesto da tutte le classi che implementano l'interfaccia serializable

	protected JPanel nord;
	protected JPanel centro;

	public MainPanel() {
		super();

		nord = new JPanel();
		centro = new JPanel();
		
		nord.setLayout(null);
		centro.setLayout(null);
		
//		centro.add(new JLabel("test"));
		
		setLayout(new BorderLayout()); // TODO ?? a chi applica questo setLayout()?
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	
	public void redirect(String panelId) {
		MainWindow mainWindow = (MainWindow) SwingUtilities.getWindowAncestor(this);
		mainWindow.showPanel(panelId);
	}

	/*
	 * Get & Set
	 */

	public JPanel getNord() {
		return nord;
	}

	public void setNord(JPanel nord) {
		this.nord = nord;
	}

	public JPanel getCentro() {
		return centro;
	}

	public void setCentro(JPanel centro) {
		this.centro = centro;
	}

}

