package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import constants.BookReviewConstants;
import database.BookDAO;
import database.ConnectionFactory;
import database.UserDAO;
import entities.Role;
import entities.User;

@WebServlet("/registration")
public class Registration extends HttpServlet {
	static Logger log = Logger.getLogger(BookDAO.class);
	private static final long serialVersionUID = 1L;
	Connection connection;

	/**
	 * 
	 */
	@Override
	public void init() throws ServletException {
		connection = ConnectionFactory.getConnection();
	}

	/**
	 * HttpServletRequest request request object
	 *  HttpServletResponse response response object
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int flag = 0;

		Role role = new Role(BookReviewConstants.USER_TYPE, BookReviewConstants.USER);
		User user = new User(request.getParameter("loginid"), request.getParameter("password"), role);

		try {
			flag = new UserDAO(connection).insert(user);
		} catch (SQLException e) {
			log.error(e);
		}

		

		response.sendRedirect("index.jsp");
	}

}
