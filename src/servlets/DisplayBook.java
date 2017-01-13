package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.BookDAO;
import database.ConnectionFactory;
import entities.Book;

/**
 * Servlet implementation class DisplayBook
 */
@WebServlet("/DisplayBook")
public class DisplayBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection;
	@Override
	public void init() throws ServletException {
		connection=ConnectionFactory.getConnection();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookName=request.getParameter("search");
		BookDAO dao=new BookDAO(connection);
		response.setContentType("text/html");
		HttpSession session=request.getSession();
		try {
			Book book =dao.getBookByName(bookName);
			if(book!=null)
			{
				session.setAttribute("book", book);
				response.sendRedirect("Displaybook.jsp");
			}
			else 
				response.getWriter().println("<center>No matching books found!!</center>");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd=request.getRequestDispatcher("Welcome.jsp");
		rd.include(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
