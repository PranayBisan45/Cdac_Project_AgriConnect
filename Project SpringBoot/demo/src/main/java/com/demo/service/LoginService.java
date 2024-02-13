package com.demo.service;

import com.demo.model.Login;

public interface LoginService {

	Boolean getValidate(String uname, String upass);

	String getOtpForgotPassword(String email, String userID);

}
