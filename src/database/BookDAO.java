package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import constants.BookReviewConstants;
import entities.Book;
import entities.BookType;

public class BookDAO {
	Connection connection;
	Book book;
	PreparedStatement preparedStatement;
	ResultSet resultSet;

	public BookDAO(Connection connection) {
		this.connection = connection;
	}

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
			e.printStackTrace();
		} finally {
			preparedStatement.close();
		}
	}

	public boolean delete(Book obj) {
		int numberofrowsaffected = 0;
		try {
			preparedStatement = connection.prepareStatement("delete from bookdetails where ISBN=?");
			preparedStatement.setString(1, obj.getIsbn());

			numberofrowsaffected = preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return numberofrowsaffected > 0;
	}

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

			e.printStackTrace();
		} finally {
			preparedStatement.close();
		}
		return null;

	}

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
				System.out.println(rs.getString("bookname"));
				list.add(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
