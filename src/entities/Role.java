package entities;

import java.io.Serializable;

public class Role implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6767829038192926154L;

	private String roleId;
	private String roleName;
	/**
	 * 
	 */
	public Role() {
		/**
		 * to create empty object
		 */

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
