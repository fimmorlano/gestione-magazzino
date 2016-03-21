package it.unisalento.pps.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import it.unisalento.pps.model.Magazzino;

public class PrenotaArticoliWindow extends JFrame {

	private JPanel jPanelSelezionaArticoli = new JPanel();
	
	private JPanel jPanelOperations = new JPanel();
	
	private JPanel jPanelMagazzinoProgetto = new JPanel();
	
	
	public JPanel getjPanelSelezionaArticoli() {
		return jPanelSelezionaArticoli;
	}
	
	public JPanel getjPanelOperations(){
		return jPanelOperations;
	}
	
	public JPanel getjPanelMagazzinoProgetto(){
		return jPanelMagazzinoProgetto;
	}
	
	
	
	
	
		public PrenotaArticoliWindow() {
			super("Prenota Articoli");
		
			Container c = getContentPane();
		
			c.setLayout(new BorderLayout());
		
		
			Object[][] tabellaAO = new Object[15][6]; //è una matrice classica: array di array
			tabellaAO[0][0] = "a";
			tabellaAO[0][1] = "b";
			tabellaAO[0][2] = "c";
			tabellaAO[1][0] = "d";
			tabellaAO[1][1] = "e";
			tabellaAO[1][2] = "f";
			tabellaAO[2][0] = "g";
			tabellaAO[2][1] = "h";
			tabellaAO[2][2] = "i";
			String[] columnNames1 = new String[]{"Nome", "Codice", "Prodotto", "Categoria", "Prezzo", "Quantità"}; //array di stringhe, i cui elementi sono i nomi delle colonne della matrice
			TableModel model1 = new DefaultTableModel(tabellaAO, columnNames1){//usiamo il TableModel di default: passiamo come parametri i dati e i nomi delle colonne
				public Class getColumnClass(int index) {
					switch(index) {
						default: return String.class;
					}
				}
			};
			JTable tabellaArticoliOrdine = new JTable(model1); 
			//creiamo uno ScrollPane che contiene la tabella e che aggiungeremo nel container
			JScrollPane p=new JScrollPane(tabellaArticoliOrdine);
		jPanelSelezionaArticoli.add(p);
	//	c.add(jPanelSelezionaArticoli, BorderLayout.CENTER);
	
	
	
		jPanelOperations.setLayout(new FlowLayout());
			JButton indietroBtn = new JButton("Indietro");
			jPanelOperations.add(indietroBtn);
			JButton avantiBtn = new JButton("Avanti");
			jPanelOperations.add(avantiBtn);
    //	c.add(jPanelOperations, BorderLayout.SOUTH);
			
			
			
		jPanelMagazzinoProgetto.setLayout(null);
			JLabel labelMagazzino = new JLabel("Seleziona il magazzino dal quale effettuare l'ordine: ");
				Dimension labelMagazzinoSize = labelMagazzino.getPreferredSize();
				labelMagazzino.setBounds(100, 50, labelMagazzinoSize.width, labelMagazzinoSize.height);
			jPanelMagazzinoProgetto.add(labelMagazzino);
				String[] magazzini = { "Magazzino1", "Magazzino2", "Magazzino3", "Magazzino4", "Magazzino4"};
			JComboBox JComboBoxMagazzino = new JComboBox(magazzini);
				Dimension MagazzinoSize = JComboBoxMagazzino.getPreferredSize();
				JComboBoxMagazzino.setBounds(100, 90, MagazzinoSize.width, MagazzinoSize.height);
			jPanelMagazzinoProgetto.add(JComboBoxMagazzino);
			JLabel labelProgetto = new JLabel("Selezionare il progetto su cui appoggiare la spesa: ");
				Dimension labelProgettoSize = labelProgetto.getPreferredSize();
				labelProgetto.setBounds(100, 200, labelProgettoSize.width, labelProgettoSize.height);
			jPanelMagazzinoProgetto.add(labelProgetto);
				String[] progetti = {"Progetto1", "Progetto2", "Progetto3", "Progetto4", "Progetto5"};
			JComboBox JComboBoxProgetto = new JComboBox(progetti);
				Dimension ProgettoSize = JComboBoxProgetto.getPreferredSize();
				JComboBoxProgetto.setBounds(100, 240, ProgettoSize.width, ProgettoSize.height);
			jPanelMagazzinoProgetto.add(JComboBoxProgetto);
	//	c.add(jPanelMagazzinoProgetto);
	//	c.add(jPanelOperations, BorderLayout.SOUTH);
			
		
			
	
			
			
			
	
	setSize(600,600);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);	
	}
		
}


