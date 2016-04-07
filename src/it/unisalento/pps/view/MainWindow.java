package it.unisalento.pps.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Finestra principale dell'applicazione.<BR />
 * E' un contenitore vuoto di tipo JFrame.<BR />
 * <BR />
 * Riferimenti per CardLayout:<BR />
 * http://docs.oracle.com/javase/tutorial/uiswing/examples/layout/CardLayoutDemoProject/src/layout/CardLayoutDemo.java
 * 
 * @author fra sara
 *
 */
public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L; // richiesto da tutte le classi che implementano l'interfaccia serializable

	private JPanel cards; // a panel that uses CardLayout

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

        // retrieve and setup main content panel
		Container c = getContentPane();
		c.setLayout(new BorderLayout());

		// create all application panels (i.e. "cards")
		LoginWindow loginWindow = new LoginWindow();
		FirstWinMagazziniere firstWinMagazziniere = new FirstWinMagazziniere();
		RiepilogoOrdineView riepilogoOrdineView = new RiepilogoOrdineView();
		MainWindowDipendente mainWindowDipendente = new MainWindowDipendente();
		PrenotaArticoliWindow prenotaArticoliWindow = new PrenotaArticoliWindow();
		FirstWinCapoProgetto firstWinCapoProgetto = new FirstWinCapoProgetto();
		RapportoOrdiniView rapportoOrdiniView = new RapportoOrdiniView();
		RifornisciMagazzinoView rifornisciMagazzinoView = new RifornisciMagazzinoView();
		
        // Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());

        // add panels to cards container
        cards.add(loginWindow, CardPanel.LOGIN);
        cards.add(firstWinMagazziniere, CardPanel.MAGAZZINIERE);

        // add cards container to main content panel of this frame
        c.add(cards);

		setSize(1000,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

    /**
     * Visualizza il pannello indicato in input.
     * 
     * @param panelId		stringa identificativa dell'istanza di pannello
     */
    public void showPanel(String panelId) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, panelId);
    }
    
   public class CardPanel {
	   public static final String LOGIN = "LOGIN";
	   public static final String MAGAZZINIERE = "MAGAZZINIERE";
   }

}

