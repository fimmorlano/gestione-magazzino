package it.unisalento.pps.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ItemEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * http://docs.oracle.com/javase/tutorial/uiswing/examples/layout/CardLayoutDemoProject/src/layout/CardLayoutDemo.java
 * 
 * @author marco
 *
 */
public class MainWindow extends JFrame {//implements ItemListener {

	private static final long serialVersionUID = 1L; // richiesto da tutte le classi che implementano l'interfaccia serializable

	private JPanel cards; //a panel that uses CardLayout

	public MainWindow() {
		super("Gestione Magazzino");

        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        
//        //Schedule a job for the event dispatch thread:
//        //creating and showing this application's GUI.
//        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                createAndShowGUI();
//            }
//        });
		
		Container c = getContentPane();
		BorderLayout b = new BorderLayout();
		c.setLayout(b);

		LoginWindow loginWindow = new LoginWindow();
		RiepilogoOrdineView riepilogoOrdineView = new RiepilogoOrdineView();
		MainWindowDipendente mainWindowDipendente = new MainWindowDipendente();
		PrenotaArticoliWindow prenotaArticoliWindow = new PrenotaArticoliWindow();
		FirstWinCapoProgetto firstWinCapoProgetto = new FirstWinCapoProgetto();
		RapportoOrdiniView rapportoOrdiniView = new RapportoOrdiniView();
		FirstWinMagazziniere firstWinMagazziniere = new FirstWinMagazziniere();
		RifornisciMagazzinoView rifornisciMagazzinoView = new RifornisciMagazzinoView();
		
        // Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(loginWindow, CardPanel.LOGIN.getCardId());
        cards.add(firstWinMagazziniere, CardPanel.MAGAZZIENERE.getCardId());
		
//		this.add(loginWindow);
//		c.add(riepilogoOrdineView, BorderLayout.CENTER);
//		c.add(mainWindowDipendente, BorderLayout.CENTER);
//		c.add(prenotaArticoliWindow, BorderLayout.CENTER);
//		c.add(firstWinCapoProgetto, BorderLayout.CENTER);
//		c.add(rapportoOrdiniView, BorderLayout.CENTER);
//		c.add(firstWinMagazziniere, BorderLayout.CENTER);
//		this.add(rifornisciMagazzinoView);

        c.add(cards);

		setSize(1000,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
//		repaint();
	}

//    public void itemStateChanged(ItemEvent evt) {
//        CardLayout cl = (CardLayout)(cards.getLayout());
//        cl.show(cards, (String)evt.getItem());
//    }

    public void showPanel(String panelId) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, panelId);
    }

    public enum CardPanel {
    	LOGIN("LOGIN"),
    	// altre cards....
    	MAGAZZIENERE("MAGAZZINIERE");

    	private String cardId;
    	
    	private CardPanel(String cardId) {
			this.setCard(cardId);
		}
    	
    	/*
    	 * Get & Set
    	 */

		public String getCardId() {
			return cardId;
		}

		public void setCard(String cardId) {
			this.cardId = cardId;
		}
    }

}

