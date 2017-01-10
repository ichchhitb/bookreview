package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Role;
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
		User u=new User();
		Role role=new Role();
		ps=connection.prepareStatement("select * from userdetails where loginid=? and password=?");
		ps.setString(1, user.getLoginid());
		ps.setString(2, user.getPassword());
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()){
			if(rs.getString(1).equals(user.getLoginid()) && rs.getString(2).equals(user.getPassword())){
				//RoleDAO dao=new RoleDAO(connection);
				u.setLoginid(rs.getString(1));
				role.setRoleid(rs.getString(3));
				u.setRole(role);
				
			
			}
		}
		ps.close();
		ConnectionFactory.closeConnection(connection);
		return u;
	}
	public Role getUserRole(User user) throws SQLException{
		User u=new User();
		Role role=new Role();
		connection=ConnectionFactory.getConnection();
		ps=connection.prepareStatement("select * from role where roleid=? ");
		ps.setString(1, user.getRole().getRoleid());
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()){
			
				//RoleDAO dao=new RoleDAO(connection);
				role.setRoleid(rs.getString(1));
				role.setRolename(rs.getString(2));
			
		}
		ps.close();
		ConnectionFactory.closeConnection(connection);
		return role;
	}
}
