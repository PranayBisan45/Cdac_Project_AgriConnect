package com.demo.dao;


public interface LoginDao {

	Boolean Validate(String uname, String upass);

	String generateOtpForgotP(String email, String userID);

	Boolean newPass(String whatsApp_Number, String oTP, String new_Password);


}
