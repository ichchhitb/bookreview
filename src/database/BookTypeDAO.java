package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import constants.BookReviewConstants;
import entities.BookType;

/**
 * Data access class for BookType entity
 * 
 * @author group4
 *
 */
public class BookTypeDAO {
	private static final Logger log = Logger.getLogger(BookDAO.class);
	private Connection con;
	private PreparedStatement stmt;

	/**
	 * 
	 * Default constructor to establish the connection
	 */
	public BookTypeDAO(Connection connection) {
		this.con = connection;
	}

	/**
	 * gettypeByName() to fetch the booktypeid on basis of booktypename
	 * 
	 * @param booktypename
	 * @return BookType
	 */
	public BookType getTypeByName(String booktypename) {
		log.info("Inside getTypeByName() " + booktypename);
		String userid = null;
		BookType b = null;
		try {
			stmt = con.prepareStatement("select booktypeid from booktype where booktypename=?");
			stmt.setString(1, booktypename);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				userid = rs.getString(BookReviewConstants.BOOK_TYPE_ID);
			}
			b = new BookType(userid, booktypename);
		} catch (SQLException e) {
			log.error("Error inside getTypeByName() " + e);
		}
		log.info("Exit getTypeByName() ");
		return b;
	}
}
