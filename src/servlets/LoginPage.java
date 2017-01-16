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

import constants.BookReviewConstants;
import database.BookDAO;
import database.ConnectionFactory;
import database.UserDAO;
import entities.Role;
import entities.User;

/**
 * Servlet implementation class LoginPage
 */
@WebServlet("/LoginPage")
public class LoginPage extends HttpServlet {
	static Logger log = Logger.getLogger(BookDAO.class);
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	Connection connection;

	public LoginPage() {
		super();
	}

	/**
	 * 
	 */
	@Override
	public void init() throws ServletException {
		super.init();
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
		String loginid = request.getParameter("loginid");
		String password = request.getParameter("password");
		User user = new User(loginid, password, null);
		UserDAO dao = new UserDAO(connection);
		try {
			user = dao.isExist(user);
			if (user != null) {
				Role role = dao.getRoleForUser(user);
				user.setRole(role);
				session.setAttribute("user", user);
				if (role != null) {
					if (BookReviewConstants.ADMIN.equals(role.getRoleName()))
						response.sendRedirect("Welcome.jsp");

					else if (BookReviewConstants.USER.equals(role.getRoleName()))
						response.sendRedirect("Welcome.jsp");
				}
			} else {
				response.getWriter().append("<center><font color='white'>Username or password is incorrect</font></center>");
			}
		} catch (SQLException e) {
			log.error(e);
			response.getWriter().append("<center><font color='white'>An error please try again!!!</font></center>");
		}
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
