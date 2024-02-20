package com.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.demo.Dao.ConsumerDao;

@Service
public class ConsumerServiceImpl implements ConsumerService{

	@Autowired
	private ConsumerDao cdao;
	
	@Override
	public boolean uploadData(String firstname, String lastname,String email, String address, String pincode, String state,
			String gender, String whatsApp_Number, String userPassword) {
		// TODO Auto-generated method stub
		return cdao.uploadData( firstname,  lastname, email, address,   pincode,   state,   gender,  whatsApp_Number,  userPassword);
	}

	@Override
	public String getUserIdAfterRegistration(String whatsApp_Number) {
		// TODO Auto-generated method stub
		return cdao.getuseridafterregistration(whatsApp_Number);
	}

}
