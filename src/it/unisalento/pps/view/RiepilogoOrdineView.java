package it.unisalento.pps.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RiepilogoOrdineView extends MainPanel {

	private static final long serialVersionUID = 1L;

	public RiepilogoOrdineView() {
		super();
		
		JLabel labelOrdineAutorizzato = new JLabel ("Il sistema ha autorizzato il seguente ordine di articoli:");
		Dimension labelOrdineAutorizzatoSize = labelOrdineAutorizzato.getPreferredSize();
		labelOrdineAutorizzato.setBounds(410, 10, labelOrdineAutorizzatoSize.width, labelOrdineAutorizzatoSize.height);
		body.add(labelOrdineAutorizzato, BorderLayout.NORTH); // TODO ?? perché intendiamo aggiungerlo a nord e invece il layout del panel centro è null??
		
		/*
		 * TODO ? implementare la lista che costituisce il riepilogo dell'ordine, e che andrà nella parte
		 * centrale del BorderLayout
		 */
		
		
		JPanel jPanelOperations = new JPanel();
		// TODO ? non visualizza questi due bottoni Indietro e Avanti
		jPanelOperations.setLayout(new FlowLayout());
		JButton indietroBtn = new JButton("Indietro");
		jPanelOperations.add(indietroBtn);
		JButton avantiBtn = new JButton("Avanti");
		jPanelOperations.add(avantiBtn);
		body.add(jPanelOperations);
	
	}

}
