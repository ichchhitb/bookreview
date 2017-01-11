package entities;

import java.io.Serializable;

public class Role implements Serializable {
<<<<<<< HEAD
	/**
	 * 
	 */
	private static final long serialVersionUID = 6767829038192926154L;
=======
	private static final long serialVersionUID = 6767829038192926154L;
	
	
>>>>>>> b1b04a5c12d58640714a12ece8ede37d94a3b977
	String roleId;
	String roleName;
	/**
	 * 
	 */
	public Role() {

	}
	/**
	 * 
	 * @param roleId
	 * @param roleName
	 */
	public Role(String roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}
	/**
	 * 
	 * @return
	 */
	public String getRoleId() {
		return roleId;
	}
	/**
	 * 
	 * @return
	 */
	public String getRoleName() {
		return roleName;
	}
	/**
	 * 
	 * @param roleid
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	/**
	 * 
	 * @param rolename
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
