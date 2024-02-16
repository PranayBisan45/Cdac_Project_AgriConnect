package com.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Dao.ConsumerDao;

@Service
public class ConsumerServiceImpl implements ConsumerService {

	@Autowired
	private ConsumerDao cdao;
	
	@Override
	public boolean uploadData(String firstname, String lastname, String eMailid, String address, String pincode,
			String state, String gender, String whatsApp_Number, String userPassword) {
		return cdao.uploadData( firstname,  lastname, eMailid, address,   pincode,   state,   gender,  whatsApp_Number,  userPassword);
	}

	@Override
	public String getUID(String wno) {
		return cdao.getUID(wno);
	}

}
