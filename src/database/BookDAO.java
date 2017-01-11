package database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import entities.Book;

public class BookDAO {
	Connection con;
	PreparedStatement stmt;
	public BookDAO() {
		con=ConnectionFactory.getConnection();
	}
	
	public void insert(Book obj) throws SQLException
	{
	    try{
		   stmt=con.prepareStatement("insert into bookdetails values(?,?,?,?,?,?)");
		   stmt.setString(1, obj.getIsbn());
		   stmt.setString(2, obj.getBookName());
		   stmt.setString(3, obj.getBookAuthor());
		   stmt.setString(4, obj.getBookImage());
		   stmt.setString(5, obj.getSummary());
		   stmt.setString(6, obj.getBooktype().getBooktypeid());
	       stmt.executeUpdate();
		}catch(SQLIntegrityConstraintViolationException e)
		{
			e.printStackTrace();
		}
		finally{
		stmt.close();
		}
	}
	
	
	
}
