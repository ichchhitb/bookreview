package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import constants.BookReviewConstants;
import entities.Role;

public class RoleDAO {
	Connection connection;
	PreparedStatement ps;

	public RoleDAO() throws SQLException {
		connection = ConnectionFactory.getConnection();
	}

	public RoleDAO(Connection connection) {
		super();
		this.connection = connection;
	}
	/**
	 * 
	 * @param roleid
	 * @return
	 * @throws SQLException
	 */
	public Role getRole(String roleid) throws SQLException {
		Role role = null;
		try {
			ps = connection.prepareStatement("select * from role where roleid=?");
			ps.setString(1, roleid);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
				role = new Role(rs.getString(BookReviewConstants.ROLE_ID), rs.getString(BookReviewConstants.ROLE_NAME));
		} finally {
			ps.close();
		}
		return role;
	}
}
