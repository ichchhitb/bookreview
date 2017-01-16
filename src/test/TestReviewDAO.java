package test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Before;
import org.junit.Test;

import constants.BookReviewConstants;
import database.ConnectionFactory;
import database.ReviewDAO;
import entities.Book;
import entities.BookType;
import entities.Review;
import entities.Role;
import entities.User;

/**
 * Testing for ReviewDAO class
 * 
 * @author group4
 *
 */
public class TestReviewDAO {
	Connection connection;
	ReviewDAO dao;
	Book book;
	User user;
	BookType type;
	Role role;
	Review review;
	long next;

	/**
	 * setting Objects which are used for testing
	 * 
	 * @throws SQLException
	 */
	@Before
	public void setObjects() throws SQLException {
		connection = ConnectionFactory.getConnection();
		dao = new ReviewDAO(connection);
		type = new BookType("2", BookReviewConstants.FICTION);
		book = new Book("1000", "Test", "Test", "test", "summary", type);
		role = new Role("1", BookReviewConstants.ADMIN);
		user = new User("aayush", "123", role);
		next = dao.genarateNewReviewId();
		review = new Review(next, "good", "very good", 4, user, book);

	}

	/**
	 * testing the addReview() of ReviewDAO
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testAddReview() throws SQLException {
		assertTrue(dao.addReview(review));
	}

	/**
	 * testing the getAverageRatingForBook() of ReviewDAO
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testGetAverageRatingForBook() throws SQLException {
		assertEquals(4, dao.getAverageRatingForBook(book));
	}

	/**
	 * testing the getAllReviewsForBook() of ReviewDAO
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testGetAllReviewsForBook() throws SQLException {
		assertNotNull(dao.getAllReviewsForBook(book));
	}

}
