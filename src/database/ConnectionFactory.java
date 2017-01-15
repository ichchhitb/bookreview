package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class ConnectionFactory {
	static Logger log = Logger.getLogger(BookDAO.class);
	/**
	 * getConnection() method to establish the database connection
	 * 
	 */
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/bookreview", "root", "root");
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
		}
		return null;
	}
}
