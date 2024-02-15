package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.dao.ProfileDao;

@Service
public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	private ProfileDao pdao;

	@Override
	public ResponseEntity<String> editAddress(String newAddress, String uid) {

		return pdao.editAddress(newAddress,uid);
	}

}
