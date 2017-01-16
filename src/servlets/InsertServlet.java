package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
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
	static Logger log = Logger.getLogger(InsertServlet.class);
	private static final long serialVersionUID = 1L;
	Connection connection;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertServlet() {
		super();

	}

	@Override
	public void init() throws ServletException {
		connection = ConnectionFactory.getConnection();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		HttpSession session = request.getSession();
		BookTypeDAO dao1 = new BookTypeDAO(connection);
		BookType booktype = dao1.getTypeByName(request.getParameter("bookTypeName"));
		Book b = new Book();
		b.setIsbn(request.getParameter("ISBN_insert"));
		b.setBookName(request.getParameter("bookName"));
		b.setBookAuthor(request.getParameter("author"));
		b.setBookImage(request.getParameter("image"));
		b.setSummary(request.getParameter("summary"));
		b.setBookType(booktype);

		BookDAO dao;
		try {
			dao = new BookDAO(connection);
			dao.insert(b);
		} catch (SQLException e) {

			log.error(e);
		}
		session.setAttribute("insert message", "Inserted Successfully");
		response.sendRedirect("Insert.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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
