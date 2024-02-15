package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.LoginDao;

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

	@Override
	public Boolean newPass(String whatsApp_Number, String oTP, String new_Password) {
		return ldao.newPass(whatsApp_Number,oTP,new_Password);
	}

}
