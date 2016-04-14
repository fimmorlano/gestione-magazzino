package it.unisalento.pps.view;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import it.unisalento.pps.model.Articolo;

public class AggiungiFornituraPanel extends MainPanel {

	private static final long serialVersionUID = 1L;
		
		public AggiungiFornituraPanel() {
			super();
			
			 	ArrayList<Articolo> articoloList = new ArrayList<Articolo>();
			 	int numeroRighe = articoloList.size();
			
				Object[][] data = new Object [numeroRighe][8]; //è una matrice classica: array di array
				{
					Articolo articolo = new Articolo();
					for (int i=0; i < numeroRighe; i++){
						articolo = articoloList.get(i);
						for (int j=0; j <8; j++)
						{
							switch (j) {
							 
						    	case 0:
						    		System.out.print("0");
						    		data[i][j] = articolo.getProdotto();
						    		break;
						        
						    	case 1:
						        	System.out.print("1");
						        	data[i][j] = articolo.getIdArticolo();
						        	break;
						 
						    	case 2:
						        	System.out.println("2");
						        	data[i][j] = articolo.getCategoria();
						        	break;
						        	
//						    	case 3:
//						        	System.out.println("3");
//						        	data[i][j] = articolo.getDescrizione();
//						        	break;
						 
						    	case 4:
						        	System.out.println("4");
						        	data[i][j] = articolo.getPrezzo();
						        	break;
						        	
						    	case 5:
						        	System.out.println("5");
						        	data[i][j] = true;
						        	break;
						        	
//						    	case 6:
//						        	System.out.println("6");
//						        	data[i][j] = articolo.getNumeroMax();
//									break;
						        	
						    	case 7:
						    		System.out.println("7");
						    		data [i][j] =  new JButton("Aggiorna");
						    		break;
							}
						}
					}
				}
				String[] columnNames = new String[]{"Nome prodotto", "Nome articolo", "Categoria", "Categoria", "Descrizione", "Prezzo", "Quantità", "Numero massimo", "Aggiorna"};
				DefaultTableModel tableModel = new DefaultTableModel(data, columnNames){//usiamo il TableModel di default: passiamo come parametri i dati e i nomi delle colonne
				
					

					/*
					 * questo metodo dice di che tipo sono i dati contenuti nelle diverse colonne. In uscita, infatti vuole il nome di una classe
					 */
					public Class getColumnClass(int index) {
						switch(index) {
							case 2: return Boolean.class;
							default: return String.class;
						}
					}
					
					
				};
				
				final JTable tabella = new JTable(tableModel);
				
				JScrollPane p=new JScrollPane(tabella);
				
				this.add(p);
			
		}
}