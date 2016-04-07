package it.unisalento.pps.view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JLabel;

public class FirstWinMagazziniere extends MainPanel {

	private static final long serialVersionUID = 1L;

	@Override
	public void paint(Graphics g) {
		JLabel l = new JLabel ("Selezionare l'operazione da effettuare:");
		Dimension lSize = l.getPreferredSize();
		l.setBounds(85, 50, lSize.width, lSize.height);
		body.add(l);
		
		JButton magazzinoBtn = new JButton("Rifornisci magazzino");
		Dimension magazzinoBtnSize = magazzinoBtn.getPreferredSize();
		magazzinoBtn.setBounds(25, 110, magazzinoBtnSize.width, magazzinoBtnSize.height);
		//magazzinoBtn.addActionListener(new LoginBtnListener(this));
		body.add(magazzinoBtn);
		
		JButton richiesteBtn = new JButton("Verifica richieste");
		Dimension richiesteBtnSize = richiesteBtn.getPreferredSize();
		richiesteBtn.setBounds(75+magazzinoBtnSize.width, 110, richiesteBtnSize.width, richiesteBtnSize.height);
		//magazzinoBtn.addActionListener(new LoginBtnListener(this));
		body.add(richiesteBtn);

		super.paint(g);
	}

}

