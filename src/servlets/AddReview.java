package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.ConnectionFactory;
import database.ReviewDAO;
import entities.Book;
import entities.Review;
import entities.Role;
import entities.User;

/**
 * Servlet implementation class AddReview
 */
@WebServlet("/AddReview")
public class AddReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
      Connection connection; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddReview() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	connection=ConnectionFactory.getConnection();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		ReviewDAO dao=new ReviewDAO(connection);
		HttpSession session= request.getSession();
		Book book=(Book)session.getAttribute("book");
		User user=(User)session.getAttribute("user");
		String reviewTitle=request.getParameter("reviewtitle");
		int rating=Integer.parseInt(request.getParameter("rating"));
		String comments=request.getParameter("comments");
		try {
			long reviewId=dao.genarateNewReviewId();
			Review review=new Review(reviewId, reviewTitle, comments, rating, user, book);
			dao.addReview(review);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("Displaybook.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
