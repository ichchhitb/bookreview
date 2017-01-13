package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import constants.BookReviewConstants;
import entities.BookType;

public class BookTypeDAO {
	static Logger log = Logger.getLogger(BookDAO.class);
	Connection con;
	PreparedStatement stmt;
	
	/**
	 * 
	 * Default constructor to establish the connection
	 */
	public BookTypeDAO() {
		con=ConnectionFactory.getConnection();
	}
	
	/**
	 * gettypeByName() to fetch the booktypeid on basis of booktypename
	 * @param booktypename
	 */
	public BookType getTypeByName(String booktypename) {
		String userid=null;
		BookType b=null;
		try {
			stmt=con.prepareStatement("select booktypeid from booktype where booktypename=?");
			stmt.setString(1,booktypename);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				userid = rs.getString(BookReviewConstants.BOOK_TYPE_ID);
			}
			b= new BookType(userid, booktypename);
		} catch (SQLException e) {
			log.error(e);
		}
	    return b;
	}
}
