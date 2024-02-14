package com.demo.model;

public class Consumer {

    private String FIRSTNAME;
    private String LASTNAME;
    private String EMAILID;
    private String ADDRESS;
    private String PINCODE;
    private String STATE;
    private String GENDER;
    private String WhatsApp_Number;
    private String USER_PASSWORD; 
    
	public Consumer() {
		super();
	}

	public Consumer(String fIRSTNAME, String lASTNAME, String eMAILID, String aDDRESS, String pINCODE, String sTATE,
			String gENDER, String whatsApp_Number, String uSER_PASSWORD) {
		super();
		FIRSTNAME = fIRSTNAME;
		LASTNAME = lASTNAME;
		EMAILID = eMAILID;
		ADDRESS = aDDRESS;
		PINCODE = pINCODE;
		STATE = sTATE;
		GENDER = gENDER;
		WhatsApp_Number = whatsApp_Number;
		USER_PASSWORD = uSER_PASSWORD;
	}

	public String getFIRSTNAME() {
		return FIRSTNAME;
	}

	public void setFIRSTNAME(String fIRSTNAME) {
		FIRSTNAME = fIRSTNAME;
	}

	public String getLASTNAME() {
		return LASTNAME;
	}

	public void setLASTNAME(String lASTNAME) {
		LASTNAME = lASTNAME;
	}

	public String getEMAILID() {
		return EMAILID;
	}

	public void setEMAILID(String eMAILID) {
		EMAILID = eMAILID;
	}

	public String getADDRESS() {
		return ADDRESS;
	}

	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}

	public String getPINCODE() {
		return PINCODE;
	}

	public void setPINCODE(String pINCODE) {
		PINCODE = pINCODE;
	}

	public String getSTATE() {
		return STATE;
	}

	public void setSTATE(String sTATE) {
		STATE = sTATE;
	}

	public String getGENDER() {
		return GENDER;
	}

	public void setGENDER(String gENDER) {
		GENDER = gENDER;
	}

	public String getWhatsApp_Number() {
		return WhatsApp_Number;
	}

	public void setWhatsApp_Number(String whatsApp_Number) {
		WhatsApp_Number = whatsApp_Number;
	}

	public String getUSER_PASSWORD() {
		return USER_PASSWORD;
	}

	public void setUSER_PASSWORD(String uSER_PASSWORD) {
		USER_PASSWORD = uSER_PASSWORD;
	}

	@Override
	public String toString() {
		return "Consumer [FIRSTNAME=" + FIRSTNAME + ", LASTNAME=" + LASTNAME + ", EMAILID=" + EMAILID + ", ADDRESS="
				+ ADDRESS + ", PINCODE=" + PINCODE + ", STATE=" + STATE + ", GENDER=" + GENDER + ", WhatsApp_Number="
				+ WhatsApp_Number + ", USER_PASSWORD=" + USER_PASSWORD + "]";
	}
}
