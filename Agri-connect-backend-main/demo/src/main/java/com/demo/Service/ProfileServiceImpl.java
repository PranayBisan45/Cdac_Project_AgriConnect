package com.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Dao.ProfileDao;
import com.demo.Model.Consumer;

@Service
public class ProfileServiceImpl implements ProfileService{

	@Autowired
	private ProfileDao pdao;

	@Override
	public Consumer getConsumer(String userid) {
		// TODO Auto-generated method stub
		return pdao.getConsumer(userid);
	}

	@Override
	public Boolean editAddress(String address, String state, String pincode, String userid1) {
		// TODO Auto-generated method stub
		return pdao.editaddress(address,state,pincode,userid1);
	}
	
}
