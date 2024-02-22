package com.demo.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Dao.LoginDao;
import com.demo.Model.Login;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginDao ldao;

	@Override
	public Boolean getValidate(String uname, String upass) {
		return ldao.Validate(uname,upass);
	}

	@Override
	public String getOtpForgotPassword(String Phone, String userID) {
		return ldao.generateOtpForgotP(Phone,userID);
	}

	@Override
	public Boolean verifyOtp(String otp) {
		// TODO Auto-generated method stub
		return ldao.verifyOtp(otp);
	}

	@Override
	public Boolean updatePass(String password, String userid) {
		// TODO Auto-generated method stub
		return ldao.updatePassword(password,userid);
	}

	@Override
	public void saveLogin(String useriD) {
		
		ldao.savelogin(useriD);
		
	}

	

}