package com.demo.service;


public interface LoginService {

	Boolean getValidate(String uname, String upass);

	String getOtpForgotPassword(String email, String userID);

	Boolean newPass(String whatsApp_Number, String oTP, String new_Password);


}
