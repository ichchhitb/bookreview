package test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import org.junit.Before;
import org.junit.Test;
import constants.BookReviewConstants;
import database.ConnectionFactory;
import database.UserDAO;
import entities.Role;
import entities.User;

/**
 * Testing for UserDAO class
 * 
 * @author group4
 *
 */
public class TestUserDAO {
	Connection connection;
	UserDAO dao;
	Role role;
	User user;

	/**
	 * setting Objects which are used for testing
	 */
	@Before
	public void setObjects() {
		connection = ConnectionFactory.getConnection();
		dao = new UserDAO(connection);
		role = new Role("2", BookReviewConstants.USER);
		user = new User("xyz", "123", role);
	}

	/**
	 * testing the isExist() of UserDAO
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testIsExist() throws SQLException {
		assertNotNull(new UserDAO(connection).isExist(user));
	}

	/**
	 * testing the getRoleForUser() of UserDAO
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testGetRoleForUser() throws SQLException {
		assertNotNull(dao.getRoleForUser(user));
	}

	/**
	 * testing the insert() of UserDAO
	 * 
	 * @throws SQLException
	 */
	@Test(expected = SQLIntegrityConstraintViolationException.class)
	public void testInsert() throws SQLException {
		dao.insert(user);
	}
}
