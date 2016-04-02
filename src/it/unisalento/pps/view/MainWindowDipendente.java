package it.unisalento.pps.view;

//import it.unisalento.pps.listener.UnicaFinestraListener;

import java.awt.*;

import javax.swing.*;

public class MainWindowDipendente extends MainPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//pannello del caso d'uso "visualizza storico ordini"
	private JPanel jpC1 = new JPanel();
	
	//pannello del caso d'uso "invia nuovo ordine"
	private JPanel jpC2 = new JPanel();
	
	public JPanel getJpC1() {
		return jpC1;
	}


	public JPanel getJpC2() {
		return jpC2;
	}

	public MainWindowDipendente() {
		super();
		
		//aggiungo elementi UI
		JPanel jpN = new JPanel();
		jpN.setLayout(new FlowLayout());
			jpN.add(new JButton("Comando 1"));
			jpN.add(new JButton("Comando 2"));
			jpN.add(new JButton("Comando 3"));
		nord.add(jpN, BorderLayout.NORTH);
			
		JPanel jpW = new JPanel();
		jpW.setLayout(new GridLayout(2,1));
		//	UnicaFinestraListener l = new UnicaFinestraListener(this);
			JButton b1 = new JButton("Storico ordini");
	//		b1.setActionCommand("STORICO");
	//		b1.addActionListener(l);
			JButton b2 = new JButton("Nuovo ordine");
	//		b2.setActionCommand("NUOVO");
	//		b2.addActionListener(l);
			jpW.add(b1);
			jpW.add(b2);
		centro.add(jpW, BorderLayout.WEST);
			
		JPanel jpS = new JPanel();
		jpS.setLayout(new FlowLayout());
			jpS.add(new JTextField(10));
			jpS.add(new JButton("Cerca..."));
		centro.add(jpS, BorderLayout.SOUTH);
		
		
			jpC1.setLayout(new FlowLayout());
				jpC1.add(new JLabel("Storico ordini"));
			centro.add(jpC1, BorderLayout.CENTER);
			
		
			jpC2.setLayout(new FlowLayout());
				jpC2.add(new JLabel("Invia nuovo ordine"));

	
				this.add(nord);
				this.add(centro);
	}
}
