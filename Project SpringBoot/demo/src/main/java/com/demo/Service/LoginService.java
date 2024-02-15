package com.demo.Service;

public interface LoginService {
	Boolean getValidate(String uname, String upass);

	String getOtpForgotPassword(String email, String userID);

	Boolean verifyOtp(String oTP);

	Boolean updatePass(String password, String usid);

	void saveLogin(String useriD);
}
