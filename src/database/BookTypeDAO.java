package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import constants.BookReviewConstants;
import entities.BookType;

public class BookTypeDAO {
	Connection con;
	PreparedStatement stmt;
	
	public BookTypeDAO() {
		con=ConnectionFactory.getConnection();
	}
	
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
			e.printStackTrace();
		}
		
	    return b;
	}
}
