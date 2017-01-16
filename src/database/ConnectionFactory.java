package database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;
/**
 * Class which provides connection when required
 * @author ichchhitb
 *
 */
public class ConnectionFactory {
	private static final Logger log = Logger.getLogger(BookDAO.class);

	private ConnectionFactory() {

	}

	/**
	 * getConnection() method to establish the database connection
	 * 
	 * @return connection
	 */
	public static Connection getConnection() {
		log.info("Inside getConnection() ");
		Properties properties = new Properties();
		InputStream inputStream = ConnectionFactory.class.getClassLoader().getResourceAsStream("config.properties");
		try {
			if (inputStream != null)
				properties.load(inputStream);
			String driver = properties.getProperty("driver");
			String url = properties.getProperty("url");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");
			Class.forName(driver);
			return DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			log.error("Error inside getConnection() " + e);
		}
		log.info("Exit getConnection() ");
		return null;
	}
}
