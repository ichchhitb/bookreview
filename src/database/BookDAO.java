package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import constants.BookReviewConstants;
import entities.Book;
import entities.BookType;

public class BookDAO {
	static Logger log = Logger.getLogger(BookDAO.class);
	Connection connection;
	Book book;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	/**
	 * Parameterized constructor
	 * @param connection
	 */
	public BookDAO(Connection connection) {
		this.connection = connection;
	}
	/**
	 * insert() method to inserting the book to the database
	 * @param obj
	 * @throws SQLException
	 */
    
	public void insert(Book obj) throws SQLException {
		log.info("Inside insert book details " + book.getBookName());
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
			log.error(e);
		} finally {
			preparedStatement.close();
		}
	}
	/**
	 * delete() method to deleting the book from the database
	 * @param obj
	 */

	public boolean delete(Book obj) {
		int numberofrowsaffected = 0;
		try {
			preparedStatement = connection.prepareStatement("delete from bookdetails where ISBN=?");
			preparedStatement.setString(1, obj.getIsbn());

			numberofrowsaffected = preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			log.error(e);
			return false;
		}

		return numberofrowsaffected > 0;
	}
	/**
	 * getBookByName() method to fetch the book details from the database
	 * @param bookName
	 * @throws SQLException
	 */

	public Book getBookByName(String bookName) throws SQLException {

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

			log.error(e);
		} finally {
			preparedStatement.close();
		}
		return null;

	}
	/**
	 * getFramework() method to search the particular book specified by the user from database
	 * @param bookname
	 */

	public ArrayList<String> getFrameWork(String bookname) {
		ArrayList<String> list = new ArrayList<String>();
		PreparedStatement ps = null;
		String data;
		try {
			ps = connection.prepareStatement("SELECT * FROM bookdetails WHERE bookname LIKE ?");
			ps.setString(1, "%" + bookname + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				data = rs.getString("bookname");
				log.info(rs.getString("bookname"));
				list.add(data);
			}
		} catch (Exception e) {
			log.error(e);
		}
		return list;
	}

}
