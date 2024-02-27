package com.demo.Dao;

public interface TransactionDetailsDao {

	boolean Transaction(String uid, String eMAIL, long cNO, int cVV, String cNAME, String eXP_DATE, double aMOUNT);

}