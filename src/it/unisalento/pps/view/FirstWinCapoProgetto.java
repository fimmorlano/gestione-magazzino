package it.unisalento.pps.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FirstWinCapoProgetto extends MainPanel{

	private static final long serialVersionUID = 1L;

	public FirstWinCapoProgetto() {
		super();
		
		JPanel jPanelDipendenteProgetto = new JPanel();
		jPanelDipendenteProgetto.setLayout(null);
		JLabel labelDipendenteProgetto = new JLabel("Scegliere di raggruppare gli ordini effettuati per dipendente o per progetto:");
			Dimension labelDipendenteProgettoSize = labelDipendenteProgetto.getPreferredSize();
			labelDipendenteProgetto.setBounds(100, 50, labelDipendenteProgettoSize.width, labelDipendenteProgettoSize.height);
		jPanelDipendenteProgetto.add(labelDipendenteProgetto);
		JButton dipendenteBtn = new JButton("Raggruppa gli ordini effettuati per dipendente");
			Dimension dipendenteBtnSize = dipendenteBtn.getPreferredSize();
			dipendenteBtn.setBounds(150, 100, dipendenteBtnSize.width, dipendenteBtnSize.height);
		jPanelDipendenteProgetto.add(dipendenteBtn);
		JButton progettoBtn = new JButton("Raggruppa gli ordini effettuati per progetto");
			Dimension progettoBtnSize = progettoBtn.getPreferredSize();
			progettoBtn.setBounds(158, 140, progettoBtnSize.width, progettoBtnSize.height);
		jPanelDipendenteProgetto.add(progettoBtn);
		add(jPanelDipendenteProgetto, BorderLayout.CENTER);
	
	
		
	}

}
