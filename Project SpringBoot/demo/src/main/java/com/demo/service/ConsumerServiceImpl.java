package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.ConsumerDao;

@Service
public class ConsumerServiceImpl implements ConsumerService {

	@Autowired
	private ConsumerDao cdao;

	@Override
	public void regis(String fIRSTNAME, String lASTNAME, String eMAILID, String aDDRESS, String pINCODE, String sTATE,
			String gENDER, String WhatsApp_Number, String uSER_PASSWORD) {
		cdao.regis( fIRSTNAME, lASTNAME, eMAILID, aDDRESS, pINCODE, sTATE, gENDER, WhatsApp_Number, uSER_PASSWORD);
	}
	
	
		
}
