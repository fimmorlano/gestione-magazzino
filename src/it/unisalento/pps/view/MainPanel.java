package it.unisalento.pps.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

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
//		setVisible(false); // TODO false per default?
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

