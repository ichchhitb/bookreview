package entities;

public class User {
	String loginid;
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
	public User(String loginid, String password, Role role) {
		super();
		this.loginid = loginid;
		this.password = password;
		this.role = role;
	}
	/**
	 * 
	 * @return
	 */
	public String getLoginid() {
		return loginid;
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
	public void setLoginid(String loginid) {
		this.loginid = loginid;
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
