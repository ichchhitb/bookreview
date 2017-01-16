package entities;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 369696028452298037L;
	private String loginId;
	private String password;
	private Role role;
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
