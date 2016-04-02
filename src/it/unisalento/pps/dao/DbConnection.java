package it.unisalento.pps.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;

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
	 * Dichiarare un costruttore privato in un singleton
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
   public CachedRowSet eseguiQuery(String query) throws Exception {
      CachedRowSet cachedRowSet = new CachedRowSetImpl();
      try {
    	 connetti("gestione_magazzino", "pps", "pps");
         Statement stmt = db.createStatement();     // Creo lo Statement per l'esecuzione della query
         
         System.out.println("Sto eseguendo la query:"+query);
         
         ResultSet rs = stmt.executeQuery(query);   // Ottengo il ResultSet dell'esecuzione della query

         /*
          *  copio il RS in un oggetto cachedRowSet
          *  in modo da poter chiudere RS e la connessione
          *  senza problemi e senza perdere la lista di risultati
          *  ottenuti
          */
         cachedRowSet.populate(rs);

         rs.close();     // Chiudo il ResultSet
         stmt.close();   // Chiudo lo Statement
      } catch (Exception e) {
    	  e.printStackTrace();
    	  throw new Exception(e);
      } finally {
    	  disconnetti();
      }
      
      return cachedRowSet;
   }

   // Esegue una query di aggiornamento sul Database
   // query: una stringa che rappresenta un'istuzione SQL di tipo UPDATE da eseguire
   // ritorna TRUE se l'esecuzione e' adata a buon fine, FALSE se c'e' stata un'eccezione
   public long eseguiAggiornamento(String query) throws Exception {
      long result = -1; // id dell'ultimo oggetto iserito
      try {
    	 connetti("gestione_magazzino", "pps", "pps");
//         Statement stmt = db.createStatement();
         
         PreparedStatement statement = db.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
         
         System.out.println("Sto eseguendo la query:"+query);
         
         statement.executeUpdate();
         
         /*
          * recupero l'id dell'oggetto appena aggiornato
          */
         try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
             if (generatedKeys.next()) {
            	 result = generatedKeys.getLong(1);
             } else {
            	 result = 0;
             }
         }

         statement.close();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
    	  disconnetti();
      }
      return result;
   }

   // Chiude la connessione con il Database
   private void disconnetti() {
      try {
         db.close();
         connesso = false;
      } catch (Exception e) {
    	  e.printStackTrace();
      }
   }

   // Ritorna TRUE se la connessione con il Database e' attiva
   public boolean isConnesso() {
	   return connesso;
   }

}