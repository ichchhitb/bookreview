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

import constants.BookReviewConstants;
import database.ConnectionFactory;
import database.UserDAO;
import entities.Role;
import entities.User;

/**
 * Servlet implementation class LoginPage
 */
@WebServlet("/LoginPage")
public class LoginPage extends HttpServlet {
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
				session.setAttribute("user", user);
				if (role != null) {
					if (BookReviewConstants.ADMIN.equals(role.getRolename()))
						response.sendRedirect("admin.jsp");

					else if (BookReviewConstants.USER.equals(role.getRolename()))
						response.sendRedirect("user.jsp");
				}
			} else {
				response.getWriter().append("<center>Username or password is incorrect</center>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().append("<center>An error please try again!!!</center>");
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
