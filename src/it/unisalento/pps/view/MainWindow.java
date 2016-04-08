package it.unisalento.pps.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import it.unisalento.pps.model.Utente;

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

	protected JPanel containerPanel;

	protected JPanel header;
	protected JPanel menu;
	private JPanel cards;	// a panel that uses CardLayout

	/*
	 * il contenuto di questa variabile può essere mdificato solo
	 * dal metodo xxx del LoginPanel 
	 */
	private Utente user;	// current logged user

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

		containerPanel = new JPanel(new BorderLayout());

		/*
		 * Inizializzo i pannelli che compongono il layout
		 * generico dell'applicazione
		 */
		header = new JPanel();
		menu = new JPanel();
		cards = new JPanel(new CardLayout()); // this panel contains the "cards".

		createHeader();
		createMenu();

		/*
		 * Aggiungo i pannelli al mainPanel
		 */
		containerPanel.add(header, BorderLayout.NORTH);
		containerPanel.add(menu, BorderLayout.WEST);
		containerPanel.add(cards, BorderLayout.CENTER);

		// create all application panels (i.e. "cards")
		LoginWindow loginWindow = new LoginWindow();
		FirstWinMagazziniere firstWinMagazziniere = new FirstWinMagazziniere();
//		RiepilogoOrdineView riepilogoOrdineView = new RiepilogoOrdineView();
//		MainWindowDipendente mainWindowDipendente = new MainWindowDipendente();
//		PrenotaArticoliWindow prenotaArticoliWindow = new PrenotaArticoliWindow();
//		FirstWinCapoProgetto firstWinCapoProgetto = new FirstWinCapoProgetto();
//		RapportoOrdiniView rapportoOrdiniView = new RapportoOrdiniView();
//		RifornisciMagazzinoView rifornisciMagazzinoView = new RifornisciMagazzinoView();
		
        // add panels to cards container
        cards.add(loginWindow, CardPanel.LOGIN);
        cards.add(firstWinMagazziniere, CardPanel.MAGAZZINIERE);

        // add cards container to main content panel of this frame
        c.add(containerPanel);

		setSize(1000, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * Compone il pannello header
	 */
	protected void createHeader() {
		System.out.println("MainPanel :: createHeader()");
		if(user==null) {
			JLabel l1 = new JLabel ("Effettua il login prima di cominciare!");
			header.add(l1);
		} else {
			JLabel l1 = new JLabel ("Benvenuto "+user.getNome()+" "+user.getCognome()+ "!");
			JButton voceMenu1 = new JButton("Logout");
			header.add(l1);
			header.add(voceMenu1);
		}
	}

	/**
	 * Compone il pannello del menu
	 */
	protected void createMenu() {
		System.out.println("MainPanel :: createMenu()");
		/*
		 * Creo i bottoni
		 */
		JButton voceMenu1 = new JButton("Voce Menu 1");
		JButton voceMenu2 = new JButton("Voce Menu 2");
		JButton voceMenu3 = new JButton("Voce Menu 3");

		menu.add(voceMenu1);
		menu.add(voceMenu2);
		menu.add(voceMenu3);

		menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
	}

    /**
     * Visualizza il pannello indicato in input.
     * 
     * @param panelId		stringa identificativa dell'istanza di pannello
     */
	public void showPanel(String panelId) {
		CardLayout cl = (CardLayout) (cards.getLayout());
		cl.show(cards, panelId);
	}

	/*
	 * Get & Set
	 */

	public JPanel getHeader() {
		return header;
	}

	public void setHeader(JPanel header) {
		this.header = header;
	}

	public JPanel getMenu() {
		return menu;
	}

	public void setMenu(JPanel menu) {
		this.menu = menu;
	}

	public Utente getUser() {
		return user;
	}

	public void setUser(Utente user) {
		this.user = user;
	}

	/**
	 * Classe di costanti con gli id di tutte le
	 * istanze di pannello usate nell'applicazione.
	 * 
	 * @author sara francesco
	 *
	 */
	public class CardPanel {
		public static final String LOGIN = "LOGIN";
		public static final String MAGAZZINIERE = "MAGAZZINIERE";
	}

}

