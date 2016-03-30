package it.unisalento.pps.dao;


import java.sql.*;
import java.util.Vector;

/**
 * Classe dedicata alla gestione del Database.
 * Gestisce l'apertura e la chiusura della connessione col Database
 * Fornisce i metodi per l'esecuzione delle query sul Database
 */
public class DbConnection {

	private static Connection db;       // La connessione col Database
	private static boolean connesso;    // Flag che indica se la connessione e' attiva o meno
	private static DbConnection instance; //istanza statica della classe

	/**
	 * Dichiarare un costruttore privato in un singleto
	 * evita che l'utilizzatore possa chiamare direttamente
	 * il costruttore vuoto della classe, costringendo a ottenere
	 * l'unica istanza singleton della classe tramite il metodo
	 * getInstance()
	 */
	private DbConnection() {
		// do nothing
	}

   public static DbConnection getInstance() {
	   if(instance == null)
		   instance = new DbConnection();
//	   if(connesso != true)
//			connetti("universita", "root", "root");
	   return instance;
   }
   
   // Apre la connessione con il Database
   private boolean connetti(String nomeDB, String nomeUtente, String pwdUtente) {

	  connesso = false;
      try {

         // Carico il driver JDBC per la connessione con il database MySQL
         Class.forName("com.mysql.jdbc.Driver");
         db = DriverManager.getConnection("jdbc:mysql://127.0.0.1/" + nomeDB + "?user=" + nomeUtente + "&password=" + pwdUtente);
         connesso=true;
         
      } catch (Exception e) {
    	  e.printStackTrace(); 
     }
      return connesso;
   }

   // Esegue una query di selezione dati sul Database
   // query: una stringa che rappresenta un'istruzione SQL di tipo SELECT da eseguire
   // colonne: il numero di colonne di cui sara' composta la tupla del risultato
   // ritorna un Vector contenente tutte le tuple del risultato
   public Vector<String[]> eseguiQuery(String query) throws Exception {
      Vector<String[]> v = null;
      String [] record;
      int colonne = 0;
      try {
    	 connetti("gestione_magazzino", "pps", "pps");
         Statement stmt = db.createStatement();     // Creo lo Statement per l'esecuzione della query
         ResultSet rs = stmt.executeQuery(query);   // Ottengo il ResultSet dell'esecuzione della query
         v = new Vector<String[]>();
         ResultSetMetaData rsmd = rs.getMetaData();
         colonne = rsmd.getColumnCount();

         while(rs.next()) {   // Creo il vettore risultato scorrendo tutto il ResultSet
            record = new String[colonne];
            for (int i=0; i<colonne; i++) {
            	record[i] = rs.getString("nome");
            }
            v.add( (String[]) record.clone() );
         }
         rs.close();     // Chiudo il ResultSet
         stmt.close();   // Chiudo lo Statement
      } catch (Exception e) {
    	  e.printStackTrace();
    	  throw new Exception(e);
      } finally {
    	  disconnetti();
      }
      
      return v;
   }

   // Esegue una query di aggiornamento sul Database
   // query: una stringa che rappresenta un'istuzione SQL di tipo UPDATE da eseguire
   // ritorna TRUE se l'esecuzione e' adata a buon fine, FALSE se c'e' stata un'eccezione
   public boolean eseguiAggiornamento(String query) {
      int numero = 0;
      boolean risultato = false;
      try {
         Statement stmt = db.createStatement();
         numero = stmt.executeUpdate(query);
         risultato = true;
         stmt.close();
      } catch (Exception e) {
         e.printStackTrace();
         risultato = false;
      }
      return risultato;
   }

   // Chiude la connessione con il Database
   private void disconnetti() {
      try {
         db.close();
         connesso = false;
      } catch (Exception e) { e.printStackTrace(); }
   }

   public boolean isConnesso() { return connesso; }   // Ritorna TRUE se la connessione con il Database e' attiva
}