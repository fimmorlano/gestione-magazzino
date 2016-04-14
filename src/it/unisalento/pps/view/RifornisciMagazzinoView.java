package it.unisalento.pps.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class RifornisciMagazzinoView extends MainPanel {
	
	private static final long serialVersionUID = 1L;

		//pannello del caso d'uso "visualizza articoli da aggiungere in magazzino"
		private JPanel jPanelSelezionaArticoliMagazzino = new JPanel();
		
	//pannello del caso d'uso "invia aggiungi nuovo articolo"
		private JPanel jPanelNuovoArticolo = new JPanel();
		
	//pannello del caso d'uso "modifica articolo"
		private JPanel jPanelModificaArticolo = new JPanel();
	
	//pannello delle operazioni da effettuare per la rifornitura del magazzino
		private JPanel jPanelOperations = new JPanel();
		
	//pannello delle operazioni da effettuare per la rifornitura del magazzino
			private JPanel jPanelOperazioniDettagli = new JPanel();

		
		
		public RifornisciMagazzinoView() {
			super();
			
			
			JPanel jpN = new JPanel();
				jpN.setLayout(new FlowLayout());
				jpN.add(new JButton("Comando 1"));
				jpN.add(new JButton("Comando 2"));
				jpN.add(new JButton("Comando 3"));
		//	centro.add(jpN, BorderLayout.NORTH);
		
				
			
			
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
		//	centro.add(jpW, BorderLayout.WEST);
				
			
					
			//JPanel jPanelTable = new JPanel();
				Object[][] tabellaAM = new Object[15][6]; //è una matrice classica: array di array
				tabellaAM[0][0] = "a";
				tabellaAM[0][1] = "b";
				tabellaAM[0][2] = "c";
				tabellaAM[1][0] = "d";
				tabellaAM[1][1] = "e";
				tabellaAM[1][2] = "f";
				tabellaAM[2][0] = "g";
				tabellaAM[2][1] = "h";
				tabellaAM[2][2] = "i";
				String[] columnNames1 = new String[]{"Nome", "Codice", "Prodotto", "Categoria", "Prezzo", "Quantità"}; //array di stringhe, i cui elementi sono i nomi delle colonne della matrice
				TableModel model1 = new DefaultTableModel(tabellaAM, columnNames1){//usiamo il TableModel di default: passiamo come parametri i dati e i nomi delle colonne
					private static final long serialVersionUID = 1L;

					@SuppressWarnings({ "unchecked", "rawtypes" })
					public Class getColumnClass(int index) {
						switch(index) {
							default: return String.class;
						}
					}
				};
				JTable tabellaArticoliMagazzino = new JTable(model1); 
				//creiamo uno ScrollPane che contiene la tabella e che aggiungeremo nel container
				JScrollPane p=new JScrollPane(tabellaArticoliMagazzino);
			jPanelSelezionaArticoliMagazzino.add(p);
		//	c.add(jPanelTabella, BorderLayout.CENTER);
			
			
			jPanelOperations.setLayout(new FlowLayout());
				JButton addNewBtn = new JButton("Aggiungi nuovo articolo");
				jPanelOperations.add(addNewBtn);
				JButton modifyBtn = new JButton("Modifica articolo");
				jPanelOperations.add(modifyBtn);
				JButton deleteBtn = new JButton("Elimina articolo");
				jPanelOperations.add(deleteBtn);
				this.add(jPanelOperations, BorderLayout.SOUTH);
			
			
			
			/*
			 * Tabella che deve essere richiamata quando il magazziniere
			 * decide di aggiungere un nuovo articolo che non è mai stato presente nel suo magazzino.
			 */
			Object[][] tabellaA = new Object[15][6]; //è una matrice classica: array di array
			tabellaA[0][0] = "a";
			tabellaA[0][1] = "b";
			tabellaA[0][2] = "c";
			tabellaA[1][0] = "d";
			tabellaA[1][1] = "e";
			tabellaA[1][2] = "f";
			tabellaA[2][0] = "g";
			tabellaA[2][1] = "h";
			tabellaA[2][2] = "i";
			String[] columnNames2 = new String[]{"Nome", "Codice", "Prodotto", "Categoria", "Prezzo", "Quantità"}; //array di stringhe, i cui elementi sono i nomi delle colonne della matrice
			@SuppressWarnings("serial")
			TableModel model2 = new DefaultTableModel(tabellaA, columnNames2){//usiamo il TableModel di default: passiamo come parametri i dati e i nomi delle colonne
				@SuppressWarnings({ "unchecked", "rawtypes" })
				public Class getColumnClass(int index) {
					switch(index) {
						default: return String.class;
					}
				}
			};
		
			JTable tabellaArticoli = new JTable(model2); 
			//creiamo uno ScrollPane che contiene la tabella e che aggiungeremo nel container
			JScrollPane pNuovoArticolo=new JScrollPane(tabellaArticoli);
		jPanelNuovoArticolo.add(pNuovoArticolo);
	//	centro.add(jPanelNuovoArticolo, BorderLayout.CENTER);
		
		
		jPanelOperazioniDettagli.setLayout(new FlowLayout());
			JButton confermaBtn = new JButton("Conferma");
			jPanelOperazioniDettagli.add(confermaBtn);
			JButton annullaBtn = new JButton("Annulla");
			jPanelOperazioniDettagli.add(annullaBtn);
	//	c.add(jPanelOperazioniDettagli, BorderLayout.SOUTH);
		
		
		/*
		 * Pannello che viene richiamato quando il magazziniere decide di modificare qualche 
		 * articolo presente nel suo magazzino
		 */
		jPanelModificaArticolo.setLayout(new BorderLayout());
			JPanel jpinterno = new JPanel();
				jpinterno.setLayout(new FlowLayout());
				JLabel etichetta = new JLabel("Dettagli articolo selezionato:");
				jpinterno.add(etichetta);
			jPanelModificaArticolo.add(jpinterno, BorderLayout.NORTH);
			Object[][] tabellaD = new Object[6][2];
				tabellaD[0][0] = "Nome";
				tabellaD[0][1] = "";
				tabellaD[1][0] = "Codice";
				tabellaD[1][1] = "";
				tabellaD[2][0] = "Prodotto";
				tabellaD[2][1] = "";
				tabellaD[3][0] = "Categoria";
				tabellaD[3][1] = "";
				tabellaD[4][0] = "Prezzo";
				tabellaD[4][1] = "";
				tabellaD[5][0] = "Quantità";
				tabellaD[5][1] = "";
			String[] columnNames3 = new String[]{"", "Dati"}; //array di stringhe, i cui elementi sono i nomi delle colonne della matrice
			TableModel model3 = new DefaultTableModel(tabellaD, columnNames3){//usiamo il TableModel di default: passiamo come parametri i dati e i nomi delle colonne
				private static final long serialVersionUID = 1L;

					@SuppressWarnings({ "unchecked", "rawtypes" })
					public Class getColumnClass(int index) {
						switch(index) {
							default: return String.class;
						}
					}
				};
				JTable tabellaDettagli = new JTable(model3); 
				//creiamo uno ScrollPane che contiene la tabella e che aggiungeremo nel container
				JScrollPane pDettagliArticolo = new JScrollPane(tabellaDettagli);
			jPanelModificaArticolo.add(pDettagliArticolo, BorderLayout.CENTER);
		//	c.add(jPanelModificaArticolo, BorderLayout.CENTER);
			
		//	c.add(jPanelOperazioniDettagli, BorderLayout.SOUTH);
			
	
		}
		
		/*
		 * Get & Set
		 */
		
		public JPanel getjPanelTabella() {
			return jPanelSelezionaArticoliMagazzino;
		}


		public JPanel getjPanelNuovoArticolo() {
			return jPanelNuovoArticolo;
		}
		
		public JPanel getjPanelModificaArticolo() {
			return jPanelModificaArticolo;
		}
		
		public JPanel getjPanelOperations() {
			return jPanelOperations;
		}

		public JPanel getjPanelOperazioniDettagli(){
			return jPanelOperazioniDettagli;
		}

}
