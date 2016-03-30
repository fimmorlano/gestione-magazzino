package it.unisalento.pps.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RiepilogoOrdineView extends MainPanel {

	private static final long serialVersionUID = 1L;

	public RiepilogoOrdineView() {
		super();
		
		JLabel labelOrdineAutorizzato = new JLabel ("Il sistema ha autorizzato il seguente ordine di articoli:");
		centro.add(labelOrdineAutorizzato, BorderLayout.NORTH);
		
		/*
		 * TODO implementare la lista che costituisce il riepilogo dell'ordine, e che andrà nella parte
		 * centrale del BorderLayout
		 */
		
		
		JPanel jPanelOperations = new JPanel();
		jPanelOperations.setLayout(new FlowLayout());
		JButton indietroBtn = new JButton("Indietro");
		jPanelOperations.add(indietroBtn);
		JButton avantiBtn = new JButton("Avanti");
		jPanelOperations.add(avantiBtn);
		centro.add(jPanelOperations, BorderLayout.SOUTH);
	
		this.add(nord);
		this.add(centro);
	}

}
