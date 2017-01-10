package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import constants.BookReviewConstants;
import entities.Role;
import entities.User;

public class UserDAO {
	Connection connection;
	PreparedStatement ps;
	User user = null;
	/**
	 * 
	 * @param connection
	 */
	public UserDAO(Connection connection) {
		super();
		this.connection = connection;
	}
	/**
	 * 
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public User isExist(User user) throws SQLException {
		try {
			ps = connection.prepareStatement("select * from userdetails where loginid=? and password=?");
			ps.setString(1, user.getLoginid());
			ps.setString(2, user.getPassword());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String loginidfromdb = rs.getString(BookReviewConstants.LOGIN_ID);
				String passwordfromdb = rs.getString(BookReviewConstants.PASSWORD);
				if (loginidfromdb.equals(user.getLoginid()) && passwordfromdb.equals(user.getPassword())) {
					this.user = new User();
					this.user.setLoginid(loginidfromdb);
					this.user.setPassword(passwordfromdb);
				}
			}
		} finally {
			if (ps != null)
				ps.close();
		}
		return this.user;
	}
	/**
	 * 
	 * @param user2
	 * @return
	 * @throws SQLException
	 */
	public Role getRoleForUser(User user2) throws SQLException {
		Role role = null;
		try {
			ps = connection.prepareStatement("select roleid from userdetails where loginid=?");
			ps.setString(1, user2.getLoginid());
			ResultSet result = ps.executeQuery();
			String roleid = "";
			while (result.next())
				roleid = result.getString(BookReviewConstants.ROLE_ID);
			ps.close();
			ps = connection.prepareStatement("select * from role where roleid=?");
			ps.setString(1, roleid);
			result = ps.executeQuery();
			while (result.next())
				role = new Role(result.getString(BookReviewConstants.ROLE_ID),
						result.getString(BookReviewConstants.ROLE_NAME));
		} finally {
			if (ps != null)
				ps.close();
		}
		return role;
	}
}
