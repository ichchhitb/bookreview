package test;

import static org.junit.Assert.*;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Before;
import org.junit.Test;
import database.ConnectionFactory;
import database.RoleDAO;

/**
 * Testing for RoleDAO class
 * 
 * @author group4
 *
 */
public class TestRoleDAO {
	Connection connection;
	RoleDAO dao;

	/**
	 * setting Objects which are used for testing
	 */
	@Before
	public void setObjects() {
		connection = ConnectionFactory.getConnection();
		dao = new RoleDAO(connection);

	}

	/**
	 * testing the getRole() of RoleDAO
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testgetRole() throws SQLException {
		assertNotNull(dao.getRole("1"));
	}

}
