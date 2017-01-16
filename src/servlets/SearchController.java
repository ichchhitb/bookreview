package servlets;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import database.BookDAO;
import database.ConnectionFactory;
@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	static Logger log = Logger.getLogger(SearchController.class);
        private static final long serialVersionUID = 1L;
        Connection connection;
        /**
         * 
         */
        @Override
        public void init() throws ServletException {
        	connection=ConnectionFactory.getConnection();
        }
        /**
         *@param  HttpServletRequest request HttpServletResponse response
         *@throws ServletException IOException
         */
        protected void doGet(HttpServletRequest request,
                HttpServletResponse response) throws ServletException, IOException {

                response.setContentType("application/json");
                try {
                        String term = request.getParameter("term");
                        log.info("Data from ajax call " + term);

                        BookDAO dataDao = new BookDAO(connection);
                        List<String> list = dataDao.getMatchingBooks(term);

                        String searchList = new Gson().toJson(list);
                        response.getWriter().write(searchList);
                        
                        
                } catch (Exception e) {
                        log.error(e);
                }
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