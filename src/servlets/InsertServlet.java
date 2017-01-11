package servlets;



import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constants.BookReviewConstants;
import database.BookDAO;
import database.BookTypeDAO;

import entities.Book;
import entities.BookType;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/Insert")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookTypeDAO dao1=new BookTypeDAO();
		BookType booktype=null;
		booktype = dao1.getTypeByName(BookReviewConstants.FICTION);
		Book b=new Book();
		b.setIsbn("1007");
		b.setBookName("Half Girlfiend");
		b.setBookAuthor("Chetan Bhagat");
		b.setBookImage("https://upload.wikimedia.org/wikipedia/en/c/c6/Half_Girlfriend.jpg");
		b.setSummary( "Half Girlfriend is an Indian English coming of age, young adult romance novel by Indian author Chetan Bhagat.[1] The novel, set in rural Bihar, New Delhi, Patna, and New York, is the story of a Bihari boy in quest of winning over the girl he loves. This is Bhagat's sixth novel which was released on 1 October 2014[2] by Rupa Publications. The novel has also been published in Hindi[3] and Gujarati[4] versions as well. A Bollywood film adaptation is planned.");
		b.setBooktype(booktype);
		
		BookDAO dao;
		try {
			dao = new BookDAO();
			dao.insert(b);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		response.getWriter().append("<center>Inserted a book</center>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
