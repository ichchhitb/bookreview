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

import org.apache.log4j.Logger;

import database.BookDAO;
import database.ConnectionFactory;
import entities.Book;

/**
 * Servlet implementation class DisplayBook
 */
@WebServlet("/DisplayBook")
public class DisplayBook extends HttpServlet {
	static Logger log = Logger.getLogger(DisplayBook.class);
	private static final long serialVersionUID = 1L;
	Connection connection;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayBook() {
        super();
        
    }
	@Override
	public void init() throws ServletException {
		connection=ConnectionFactory.getConnection();
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
			log.error(e);
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
	/**
	 * Destroy()
	 */
	@Override
	public void destroy() {
		super.destroy();
		try {
			connection.close();
		} catch (SQLException e) {
			log.error("error in destroy()" + e);
		}
	}
}
