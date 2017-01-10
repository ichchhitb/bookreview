package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Role;

public class RoleDAO {
	Connection connection;
	PreparedStatement ps;
	public RoleDAO() throws SQLException{
		connection=ConnectionFactory.getConnection();
	}
	public RoleDAO(Connection connection) {
		super();
		this.connection = connection;
	}
	public Role getRole(String roleid) throws SQLException{
		ps=connection.prepareStatement("select * from role where roleid=?");
		ps.setString(1, roleid);
		Role role=null;
		ResultSet rs=ps.executeQuery();
		while(rs.next())
			role=new Role(rs.getString("roleid"),rs.getString("rolename"));
		ps.close();
		ConnectionFactory.closeConnection(connection);
		return role;
	}
}
