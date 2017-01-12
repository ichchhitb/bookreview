package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FetchBook {
        private Connection connection;

        public FetchBook() throws Exception {
                connection = ConnectionFactory.getConnection();
        }

        public ArrayList<String> getFrameWork(String bookname) {
        ArrayList<String> list = new ArrayList<String>();
        PreparedStatement ps = null;
        String data;
        try {
        ps = connection.prepareStatement("SELECT * FROM bookdetails WHERE bookname LIKE ?");
                ps.setString(1, "%" + bookname + "%");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                        data = rs.getString("bookname");
                        System.out.println(rs.getString("bookname"));
                        list.add(data);
                }
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return list;
}
}