package database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import constants.BookReviewConstants;
import entities.Book;
import entities.BookType;
import entities.Review;
import entities.Role;
import entities.User;
/**
 * Data access class for Review entity
 * @author ichchhitb
 *
 */
public class ReviewDAO {
	private static final Logger log = Logger.getLogger(ReviewDAO.class);
	private Connection connection;
	private PreparedStatement preparedStatement;

	/**
	 * parameterized constructor
	 * @param connection
	 */
	public ReviewDAO(Connection connection) {
		super();
		this.connection = connection;
	}

	/**
	 * 
	 * addReview() method to add the review of the book into database
	 * @param review
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean addReview(Review review) throws SQLException {
		log.info("Inside addReview()");
		int updatedRows = 0;
		try {
			preparedStatement = connection.prepareStatement("insert into reviewdetails values(?,?,?,?,?,?)");
			preparedStatement.setLong(1, review.getReviewId());
			preparedStatement.setString(2, review.getUser().getLoginId());
			preparedStatement.setString(3, review.getBook().getIsbn());
			preparedStatement.setString(4, review.getReviewTitle());
			preparedStatement.setString(5, review.getComments());
			preparedStatement.setInt(6, review.getRating());
			updatedRows = preparedStatement.executeUpdate();
		} finally {
			preparedStatement.close();
		}
		log.info("Exit addReview() ");
		return updatedRows > 0;
	}

	/**
	 * generateNewReviewId() method to generate new review id
	 * @return long
	 * @throws SQLException
	 */
	public long genarateNewReviewId() throws SQLException {
		long latestReviewId = 1;
		log.info("Inside genarateNewReviewId()");
		try {
			preparedStatement = connection.prepareStatement("select max(reviewid) as reviewid from reviewdetails");
			ResultSet result = preparedStatement.executeQuery();
			while (result.next())
				latestReviewId = result.getLong(BookReviewConstants.REVIEW_ID) + 1;
		} finally {
			preparedStatement.close();
		}log.info("Exit genarateNewReviewId() ");
		return latestReviewId;
	}

	/**
	 * getAverageRatingForBook() to get the average rating of the book searched for
	 * @param book
	 * @return
	 * @throws SQLException
	 */
	public int getAverageRatingForBook(Book book) throws SQLException {
		double averagRating = 0.0;
		log.info("Inside getAverageRatingForBook() "+book.getIsbn());
		try {
			preparedStatement = connection
					.prepareStatement("SELECT AVG(rating) AS rating FROM reviewdetails WHERE isbn=?");
			preparedStatement.setString(1, book.getIsbn());
			ResultSet result = preparedStatement.executeQuery();
			while (result.next())
				averagRating = result.getDouble(BookReviewConstants.RATING);
		} finally {
			preparedStatement.close();
		}log.info("Exit getAverageRatingForBook()");
		return (int)averagRating;
	}

	/**
	 * getAllReviewsForBook() method to get all reviews for the particular book searched 
	 * @param book
	 * @return
	 * @throws SQLException
	 */
	public List<Review> getAllReviewsForBook(Book book) throws SQLException {
		ArrayList<Review> reviewList = new ArrayList<>();
		log.info("Inside getAllReviewsForBook "+book.getIsbn());
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM booktype" + " NATURAL JOIN bookdetails "
					+ "NATURAL JOIN reviewdetails NATURAL JOIN userdetails "
					+ "NATURAL JOIN role WHERE reviewdetails.isbn=?;");
			preparedStatement.setString(1, book.getIsbn());
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				Role role = new Role(result.getString(BookReviewConstants.ROLE_ID),
						result.getString(BookReviewConstants.ROLE_NAME));
				User user = new User(result.getString(BookReviewConstants.LOGIN_ID),
						result.getString(BookReviewConstants.USER_PASS), role);
				BookType bookType = new BookType(result.getString(BookReviewConstants.BOOK_TYPE_ID),
						result.getString(BookReviewConstants.BOOK_TYPE_NAME));
				Book book1 = new Book(result.getString(BookReviewConstants.ISBN),
						result.getString(BookReviewConstants.BOOK_NAME),
						result.getString(BookReviewConstants.BOOK_AUTHOR),
						result.getString(BookReviewConstants.BOOK_IMAGE), result.getString(BookReviewConstants.SUMMARY),
						bookType);
				Review review = new Review(result.getLong(BookReviewConstants.REVIEW_ID),
						result.getString(BookReviewConstants.REVIEW_TITLE),
						result.getString(BookReviewConstants.COMMENTS), result.getInt(BookReviewConstants.RATING), user,
						book1);
				reviewList.add(review);
			}
		} finally {
			preparedStatement.close();
		}log.info("Exit getAllReviewsForBook() ");
		return reviewList;
	}
}
