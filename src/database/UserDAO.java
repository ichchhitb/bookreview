package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.User;

public class UserDAO {
	Connection connection;
	PreparedStatement ps;
	public UserDAO() throws SQLException{
		connection=ConnectionFactory.getConnection();
	}
	public UserDAO(Connection connection) {
		super();
		this.connection = connection;
	}
	public User isExist(User user) throws SQLException{
		ps=connection.prepareStatement("select * from userdetails where loginid=? and password=?");
		ps.setString(1, user.getLoginid());
		ps.setString(2, user.getPassword());
		ResultSet rs=ps.executeQuery();
		User u=null;
		while(rs.next()){
			if(rs.getString(1).equals(user.getLoginid()) && rs.getString(2).equals(user.getPassword())){
				RoleDAO dao=new RoleDAO(connection);
				u=new User(rs.getString("loginid"),rs.getString("password"),dao.getRole(rs.getString("roleid")));
			}
		}
		ps.close();
		ConnectionFactory.closeConnection(connection);
		return u;
	}
}
