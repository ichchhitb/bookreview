package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
    public LoginPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			HttpSession session=request.getSession();
			String loginid=request.getParameter("loginid");
			String password=request.getParameter("password");
			User user=new User(loginid,password,null);
			try {
				UserDAO dao=new UserDAO();
				user=dao.isExist(user);
				if(user!=null)
				{
					session.setAttribute("user",user);
					Role role=user.getRole();
					if("admin".equals(role.getRolename()))
						response.sendRedirect("admin.jsp");
					else if("user".equals(role.getRolename()))
						response.sendRedirect("user.jsp");
				}
				else{
					response.getWriter().append("<center>Username or password is incorrect</center>");
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
				response.getWriter().append("<center>Some error occurred try again!!!</center>");
		}
		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		rd.include(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
