package com.demo.Model;

public class Login {
	private String Userid;
	private String Userpass;
	
	public Login() {
		super();
	}
	
	public Login(String userid, String userpass) {
		super();
		Userid = userid;
		Userpass = userpass;
	}
	
	public String getUserid() {
		return Userid;
	}
	
	public void setUserid(String userid) {
		Userid = userid;
	}
	
	public String getUserpass() {
		return Userpass;
	}
	
	public void setUserpass(String userpass) {
		Userpass = userpass;
	}
	
	@Override
	public String toString() {
		return "Login [Userid=" + Userid + ", Userpass=" + Userpass + "]";
	}
}