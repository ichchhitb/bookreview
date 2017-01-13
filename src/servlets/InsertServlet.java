package servlets;



import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constants.BookReviewConstants;
import database.BookDAO;
import database.BookTypeDAO;
import database.ConnectionFactory;
import entities.Book;
import entities.BookType;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/Insert")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection;
	@Override
	public void init() throws ServletException {
		connection=ConnectionFactory.getConnection();
	}
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
		response.setContentType("text/html");
		BookTypeDAO dao1=new BookTypeDAO();
		BookType booktype=null;
		booktype = dao1.getTypeByName(request.getParameter("bookTypeName"));
		Book b=new Book();
		b.setIsbn(request.getParameter("ISBN_insert"));
		b.setBookName(request.getParameter("bookName"));
		b.setBookAuthor(request.getParameter("author"));
		b.setBookImage(request.getParameter("image"));
		b.setSummary(request.getParameter("summary"));
		b.setBooktype(booktype);
		
		BookDAO dao;
		try {
			dao = new BookDAO(connection);
			dao.insert(b);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		response.sendRedirect("Insert.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
