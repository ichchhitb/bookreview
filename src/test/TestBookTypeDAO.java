package test;

import static org.junit.Assert.*;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Before;
import org.junit.Test;

import constants.BookReviewConstants;
import database.BookTypeDAO;
import database.ConnectionFactory;

/**
 * Testing for BookTypeDAO class
 * 
 * @author group4
 *
 */
public class TestBookTypeDAO {
	Connection connection;
	BookTypeDAO dao;

	/**
	 * setting Objects which are used for testing
	 */
	@Before
	public void setObjects() {
		connection = ConnectionFactory.getConnection();
		dao = new BookTypeDAO(connection);

	}

	/**
	 * testing the getTypeByName() of BookTypeDAO
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testGetTypeByName() throws SQLException {
		assertNotNull(dao.getTypeByName(BookReviewConstants.FICTION));
	}
}
