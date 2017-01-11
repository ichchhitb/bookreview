package entities;

public class User {
	String loginId;
	String password;
	Role role;
	/**
	 * 
	 */
	public User() {
	}
	/**
	 * 
	 * @param loginid
	 * @param password
	 * @param role
	 */
	public User(String loginId, String password, Role role) {
		super();
		this.loginId = loginId;
		this.password = password;
		this.role = role;
	}
	/**
	 * 
	 * @return
	 */
	public String getLoginId() {
		return loginId;
	}
	/**
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 
	 * @return
	 */
	public Role getRole() {
		return role;
	}
	/**
	 * 
	 * @param loginid
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 
	 * @param role
	 */
	public void setRole(Role role) {
		this.role = role;
	}

}
