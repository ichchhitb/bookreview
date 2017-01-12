package servlets;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.google.gson.Gson;

import database.FetchBook;
@WebServlet("/SearchController")
public class AJAXController extends HttpServlet {
        private static final long serialVersionUID = 1L;

        protected void doGet(HttpServletRequest request,
                HttpServletResponse response) throws ServletException, IOException {

                response.setContentType("application/json");
                try {
                        String term = request.getParameter("term");
                        System.out.println("Data from ajax call " + term);

                        FetchBook dataDao = new FetchBook();
                        ArrayList<String> list = dataDao.getFrameWork(term);

                        String searchList = new Gson().toJson(list);
                        response.getWriter().write(searchList);
                        
                        
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }
}