package com.demo.model;

public class TransactionDetails {
	private String UID;
	private String EMAIL;
	private long CNO;
	private int CVV;
	private String CNAME;
	private String EXP_DATE;
	private double AMOUNT;
	public TransactionDetails() {
		super();
	}
	public TransactionDetails(String uID, String eMAIL, long cNO, int cVV, String cNAME, String eXP_DATE,
			double aMOUNT) {
		super();
		UID = uID;
		EMAIL = eMAIL;
		CNO = cNO;
		CVV = cVV;
		CNAME = cNAME;
		EXP_DATE = eXP_DATE;
		AMOUNT = aMOUNT;
	}
	public String getUID() {
		return UID;
	}
	public void setUID(String uID) {
		UID = uID;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public long getCNO() {
		return CNO;
	}
	public void setCNO(long cNO) {
		CNO = cNO;
	}
	public int getCVV() {
		return CVV;
	}
	public void setCVV(int cVV) {
		CVV = cVV;
	}
	public String getCNAME() {
		return CNAME;
	}
	public void setCNAME(String cNAME) {
		CNAME = cNAME;
	}
	public String getEXP_DATE() {
		return EXP_DATE;
	}
	public void setEXP_DATE(String eXP_DATE) {
		EXP_DATE = eXP_DATE;
	}
	public double getAMOUNT() {
		return AMOUNT;
	}
	public void setAMOUNT(double aMOUNT) {
		AMOUNT = aMOUNT;
	}
	@Override
	public String toString() {
		return "TransactionDetails [UID=" + UID + ", EMAIL=" + EMAIL + ", CNO=" + CNO + ", CVV=" + CVV + ", CNAME="
				+ CNAME + ", EXP_DATE=" + EXP_DATE + ", AMOUNT=" + AMOUNT + "]";
	}
}