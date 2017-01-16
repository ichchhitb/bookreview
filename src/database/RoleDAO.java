package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import constants.BookReviewConstants;
import entities.Role;

/**
 * Data access class for Role entity
 * 
 * @author group4
 *
 */
public class RoleDAO {
	private static final Logger log = Logger.getLogger(RoleDAO.class);
	private Connection connection;
	private PreparedStatement ps;

	/**
	 * Non-parameterized constructor
	 * 
	 * @throws SQLException
	 */
	public RoleDAO() throws SQLException {
		connection = ConnectionFactory.getConnection();
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param connection
	 */
	public RoleDAO(Connection connection) {
		super();
		this.connection = connection;
	}

	/**
	 * getRole() method to determine the role user/admin
	 * 
	 * @param roleid
	 * @return role
	 * @throws SQLException
	 */
	public Role getRole(String roleid) throws SQLException {
		Role role = null;
		log.info("Inside getRole() " + roleid);
		try {
			ps = connection.prepareStatement("select * from role where roleid=?");
			ps.setString(1, roleid);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
				role = new Role(rs.getString(BookReviewConstants.ROLE_ID), rs.getString(BookReviewConstants.ROLE_NAME));
		} finally {
			ps.close();
		}
		log.info("Exit getRole() ");
		return role;
	}
}
