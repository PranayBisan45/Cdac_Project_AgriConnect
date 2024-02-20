package com.demo.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Dao.TransactionDetailsDao;

@Service
public class TransactionDetailsServiceImpl implements TransactionDetailsService {

	@Autowired
	private TransactionDetailsDao tdao;
	@Override
	public boolean Transaction(String uid, String eMAIL, long cNO, int cVV, String cNAME, String eXP_DATE,
			double aMOUNT) {
		return tdao.Transaction(uid,eMAIL,cNO,cVV,cNAME,eXP_DATE,aMOUNT);
	}

}