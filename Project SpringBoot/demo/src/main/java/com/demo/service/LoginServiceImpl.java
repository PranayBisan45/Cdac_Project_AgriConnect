package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.LoginDao;
import com.demo.model.Login;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginDao ldao;

	@Override
	public Boolean getValidate(String uname, String upass) {
		return ldao.Validate(uname,upass);
	}

	@Override
	public String getOtpForgotPassword(String email, String userID) {
		return ldao.generateOtpForgotP(email,userID);
	}

}
