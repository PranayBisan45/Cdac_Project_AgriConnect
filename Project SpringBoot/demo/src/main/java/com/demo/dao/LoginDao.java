package com.demo.dao;

import com.demo.model.Login;

public interface LoginDao {

	Boolean Validate(String uname, String upass);

	String generateOtpForgotP(String email, String userID);

}
