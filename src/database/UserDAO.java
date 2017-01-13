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
	PreparedStatement preparedStatement;
	User user = null;

	/**
	 * Parameterized constructor
	 * @param connection
	 */
	public UserDAO(Connection connection) {
		super();
		this.connection = connection;
	}

	/**
	 * isExist() method to validate the authentication of user
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public User isExist(User user) throws SQLException {
		try {
			preparedStatement = connection.prepareStatement("select * from userdetails where loginid=? and password=?");
			preparedStatement.setString(1, user.getLoginId());
			preparedStatement.setString(2, user.getPassword());
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String loginIdFromDb = rs.getString(BookReviewConstants.LOGIN_ID);
				String passwordFromDb = rs.getString(BookReviewConstants.PASSWORD);
				if (loginIdFromDb.equals(user.getLoginId()) && passwordFromDb.equals(user.getPassword())) {
					this.user = new User();
					this.user.setLoginId(loginIdFromDb);
					this.user.setPassword(passwordFromDb);
				}
			}
		} finally {
			if (preparedStatement != null)
				preparedStatement.close();
		}
		return this.user;
	}

	/**
	 * getRoleForUser() method to know the user is admin or normal user
	 * @param user2
	 * @return
	 * @throws SQLException
	 */
	public Role getRoleForUser(User user2) throws SQLException {
		Role role = null;
		try {
			preparedStatement = connection.prepareStatement("select roleid from userdetails where loginid=?");
			preparedStatement.setString(1, user2.getLoginId());
			ResultSet result = preparedStatement.executeQuery();
			String roleId = "";
			while (result.next())
				roleId = result.getString(BookReviewConstants.ROLE_ID);
			preparedStatement.close();
			preparedStatement = connection.prepareStatement("select * from role where roleid=?");
			preparedStatement.setString(1, roleId);
			result = preparedStatement.executeQuery();
			while (result.next())
				role = new Role(result.getString(BookReviewConstants.ROLE_ID),
						result.getString(BookReviewConstants.ROLE_NAME));
		} finally {
			if (preparedStatement != null)
				preparedStatement.close();
		}
		return role;
	}

	/**
	 * insert() method to insert the new user to database
	 * @param user
	 * @param connection
	 * @return
	 * @throws SQLException
	 */
	public int insert(User user) throws SQLException {
		int flag = 0;
		try {
			if (user != null && connection != null) {
				preparedStatement = connection.prepareStatement("insert into userdetails values( ? , ? , ?)");

				preparedStatement.setString(1, user.getLoginId());
				preparedStatement.setString(2, user.getPassword());

				preparedStatement.setString(3, BookReviewConstants.USER_TYPE);

				flag = preparedStatement.executeUpdate();

			}
		} finally {
			preparedStatement.close();
		}
		return flag;
	}
}
