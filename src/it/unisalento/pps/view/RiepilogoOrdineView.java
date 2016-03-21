package it.unisalento.pps.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RiepilogoOrdineView extends JFrame {

	public RiepilogoOrdineView() {
		super("Riepilogo Ordine");
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		JLabel labelOrdineAutorizzato = new JLabel ("Il sistema ha autorizzato il seguente ordine di articoli:");
		c.add(labelOrdineAutorizzato, BorderLayout.NORTH);
		
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
	c.add(jPanelOperations, BorderLayout.SOUTH);
		
		
	
	
	setSize(600,600);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);	 
	}

}
