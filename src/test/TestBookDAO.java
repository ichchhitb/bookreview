
package test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import database.BookDAO;
import database.ConnectionFactory;
import entities.Book;
import entities.BookType;

/**
 * Testing for BookDAO class
 * 
 * @author group4
 *
 */
public class TestBookDAO {
	Connection connection;
	BookDAO dao;
	Book book;
	BookType type;

	/**
	 * setting Objects which are used for testing
	 */
	@Before
	public void setObjects() {
		connection = ConnectionFactory.getConnection();
		dao = new BookDAO(connection);
		type = new BookType();
		type.setBookTypeId("2");
		book = new Book("12345", "Test", "Test", "test", "summary", type);
	}

	/**
	 * testing the insert() of BookDAO
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testInsert() throws SQLException {
		assertTrue(dao.insert(book));
	}

	/**
	 * testing the delete() of BookDAO
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testDelete() throws SQLException {
		assertTrue(dao.delete(book));
	}

	/**
	 * testing the getBookByName() of BookDAO
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testGetBookByName() throws SQLException {
		assertNotNull(dao.getBookByName("The Alchemist"));
	}

	/**
	 * testing the getMatchingBooks() of BookDAO
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testGetMatchingBooks() throws SQLException {
		assertNotNull(dao.getMatchingBooks("The Alchemist"));
	}

	/**
	 * testing the getFeaturedBooks() of BookDAO
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testGetFeaturedBooks() throws SQLException {
		assertNotNull(dao.getFeaturedBooks());
	}
}
