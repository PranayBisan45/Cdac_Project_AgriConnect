package com.demo.Dao;



import com.demo.Model.Login;

public interface LoginDao {

	Boolean Validate(String uname, String upass);

	String generateOtpForgotP(String Phone, String userID);

	Boolean verifyOtp(String otp);

	Boolean updatePassword(String password, String uid);

	void savelogin(String useriD);

	

}