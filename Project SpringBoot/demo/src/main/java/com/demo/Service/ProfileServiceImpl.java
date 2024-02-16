package com.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Dao.ProfileDao;

@Service
public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	private ProfileDao pdao;

	@Override
	public boolean editAddress(String newAddress, String uid) {

		return pdao.editAddress(newAddress,uid);
	}

}