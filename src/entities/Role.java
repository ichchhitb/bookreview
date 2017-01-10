package entities;

public class Role {
	String roleid;
	String rolename;
	/**
	 * 
	 */
	public Role() {

	}
	/**
	 * 
	 * @param roleid
	 * @param rolename
	 */
	public Role(String roleid, String rolename) {
		super();
		this.roleid = roleid;
		this.rolename = rolename;
	}
	/**
	 * 
	 * @return
	 */
	public String getRoleid() {
		return roleid;
	}
	/**
	 * 
	 * @return
	 */
	public String getRolename() {
		return rolename;
	}
	/**
	 * 
	 * @param roleid
	 */
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	/**
	 * 
	 * @param rolename
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

}
