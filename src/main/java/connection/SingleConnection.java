package connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Class responsible to connect with the DB
 */
public class SingleConnection {
	
	private static String dbUrl = "jdbc:postgresql://localhost:5433/jsp-course";
	private static String password = "Cav3000";
	private static String user = "postgres";
	private static Connection db = null;
	
	/**
	 * From the moment the 'SingleConnection' class is invoked, the method 'connect()' will be executed 
	 * from an static call
	 */
	static {
		connect();
	}
	
	/**
	 * Class constructor
	 */
	public SingleConnection() {
		connect();
	}

	/**
	 * Method that creates a connection
	 */
	private static void connect() {
		try {
			if(db == null) {
				Class.forName("org.postgresql.Driver");
				db = DriverManager.getConnection(dbUrl, user, password);
				db.setAutoCommit(false);
			}
				
		} catch (Exception e) {
			throw new RuntimeException("Error to connect with the database");
		}
	}
	
	/**
	 * Method that returns the connection
	 */
	public static Connection getConnection() {
		return db;
	}
}
