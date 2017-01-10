package entities;

public class Role {
	String roleid;
	String rolename;

	public Role(String roleid, String rolename) {
		super();
		this.roleid = roleid;
		this.rolename = rolename;
	}
	public String getRoleid() {
		return roleid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
}
