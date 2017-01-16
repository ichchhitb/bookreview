package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import constants.BookReviewConstants;
import entities.Book;
import entities.BookType;

public class BookDAO {
	static Logger log = Logger.getLogger(BookDAO.class);
	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;

	/**
	 * Parameterized constructor
	 * 
	 * @param connection
	 */
	public BookDAO(Connection connection) {
		this.connection = connection;
	}

	/**
	 * insert() method to inserting the book to the database
	 * 
	 * @param obj
	 * @throws SQLException
	 */

	public void insert(Book obj) throws SQLException {
		log.info("Inside insert book details " + obj.getBookName());
		try {
			preparedStatement = connection.prepareStatement("insert into bookdetails values(?,?,?,?,?,?)");
			preparedStatement.setString(1, obj.getIsbn());
			preparedStatement.setString(2, obj.getBookName());
			preparedStatement.setString(3, obj.getBookAuthor());
			preparedStatement.setString(4, obj.getBookImage());
			preparedStatement.setString(5, obj.getSummary());
			preparedStatement.setString(6, obj.getBooktype().getBooktypeid());
			preparedStatement.executeUpdate();
		} catch (SQLIntegrityConstraintViolationException e) {
			log.error("Error in insert: " + e);
		} finally {
			preparedStatement.close();
		}
		log.info("Exit insert book method");
	}

	/**
	 * delete() method to deleting the book from the database
	 * 
	 * @param obj
	 * @return boolean
	 */

	public boolean delete(Book obj) {
		log.info("Inside delete book details " + obj.getBookName());
		int numberofrowsaffected = 0;
		try {
			preparedStatement = connection.prepareStatement("delete from bookdetails where ISBN=?");
			preparedStatement.setString(1, obj.getIsbn());

			numberofrowsaffected = preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			log.error("Error in delete: " + e);
			return false;
		}
		log.info("Exit delete book method");
		return numberofrowsaffected > 0;
	}

	/**
	 * getBookByName() method to fetch the book details from the database
	 * 
	 * @param bookName
	 * @throws SQLException
	 * @return Book
	 */

	public Book getBookByName(String bookName) throws SQLException {
		log.info("Inside getBookByName() :" + bookName);
		try {
			preparedStatement = connection
					.prepareStatement("select * from bookdetails natural join booktype where bookname = ?");
			preparedStatement.setString(1, bookName);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				return new Book(resultSet.getString(BookReviewConstants.ISBN),
						resultSet.getString(BookReviewConstants.BOOK_NAME),
						resultSet.getString(BookReviewConstants.BOOK_AUTHOR),
						resultSet.getString(BookReviewConstants.BOOK_IMAGE),
						resultSet.getString(BookReviewConstants.SUMMARY),
						new BookType(resultSet.getString(BookReviewConstants.BOOK_TYPE_ID),
								resultSet.getString(BookReviewConstants.BOOK_TYPE_NAME)));
			}
		} catch (SQLException e) {

			log.error("Error in getBookByName(): " + e);
		} finally {
			preparedStatement.close();
		}
		log.info("Exit getBookByName() method");
		return null;

	}

	/**
	 * getFramework() method to search the particular book specified by the user
	 * from database
	 * 
	 * @param bookname
	 * @return ArrayList<String>
	 */

	public List<String> getMatchingBooks(String bookName) {
		log.info("Inside getMatchingBoooks() :" + bookName);

		ArrayList<String> list = new ArrayList<>();
		String data;
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM bookdetails WHERE bookname LIKE ?");
			preparedStatement.setString(1, "%" + bookName + "%");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				data = rs.getString("bookname");
				log.info(rs.getString("bookname"));
				list.add(data);
			}
		} catch (Exception e) {
			log.error("Error in getMatchingBooks(): " + e);
		}finally
		{
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				
				log.error("Error in getMatchingBooks();"+e);
			}
		}
		log.info("Exit getmatchingBooks() method");
		return list;
	}

	public List<Book> getFeaturedBooks() {
		log.info("Inside getFeaturedBooks() :");

		ArrayList<Book> list = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT * FROM bookdetails natural join booktype left outer join reviewdetails on bookdetails.isbn = reviewdetails.isbn order by rating desc limit 4");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				BookType type = new BookType(rs.getString(BookReviewConstants.BOOK_TYPE_ID),
						rs.getString(BookReviewConstants.BOOK_TYPE_NAME));
				Book book = new Book(rs.getString(BookReviewConstants.ISBN),
						rs.getString(BookReviewConstants.BOOK_NAME), rs.getString(BookReviewConstants.BOOK_AUTHOR),
						rs.getString(BookReviewConstants.BOOK_IMAGE), rs.getString(BookReviewConstants.SUMMARY), type);
				list.add(book);
			}
		} catch (Exception e) {
			log.error("Error in getFeaturedBooks(): " + e);
		}finally{
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				log.error("Error in getFeaturedBooks(): " + e);
			}
		}
		log.info("Exit getFeaturedBooks() method");
		return list;
	}

}
