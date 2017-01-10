package entities;

public class User {
	String loginid;
	String password;
	Role role;

	public User(String loginid, String password, Role role) {
		super();
		this.loginid = loginid;
		this.password = password;
		this.role = role;
	}
	public User(){
		
	}
	public String getLoginid() {
		return loginid;
	}
	public String getPassword() {
		return password;
	}
	public Role getRole() {
		return role;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
}
