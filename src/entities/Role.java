package entities;

import java.io.Serializable;

public class Role implements Serializable {
	String roleid;
	String rolename;

	public Role(){
		
	}
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
