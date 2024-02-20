package com.demo.Service;


public interface TransactionDetailsService {

	boolean Transaction(String uid, String eMAIL, long cNO, int cVV, String cNAME, String eXP_DATE, double aMOUNT);

}