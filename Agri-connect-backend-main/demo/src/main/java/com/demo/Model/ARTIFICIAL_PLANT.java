package com.demo.Model;

public class ARTIFICIAL_PLANT {
	
	private String APID;
	private String APTITLE;
	private String APDESCRIPTION;
	private Double APRATING;
	private String APPRICE;
	private Integer APSTOCKAVAILABILITY;
	private String APIMAGES;
	private String APPRODUCTDETAILS;
	private Integer Quantity;
	
	public ARTIFICIAL_PLANT() {
		super();
	}

	public ARTIFICIAL_PLANT(String aPID, String aPTITLE, String aPDESCRIPTION, Double aPRATING, String aPPRICE,
			Integer aPSTOCKAVAILABILITY, String aPIMAGES, String aPPRODUCTDETAILS,Integer quantity) {
		super();
		APID = aPID;
		APTITLE = aPTITLE;
		APDESCRIPTION = aPDESCRIPTION;
		APRATING = aPRATING;
		APPRICE = aPPRICE;
		APSTOCKAVAILABILITY = aPSTOCKAVAILABILITY;
		APIMAGES = aPIMAGES;
		APPRODUCTDETAILS = aPPRODUCTDETAILS;
		Quantity = quantity;
	}

	public String getAPID() {
		return APID;
	}

	public void setAPID(String aPID) {
		APID = aPID;
	}

	public String getAPTITLE() {
		return APTITLE;
	}

	public void setAPTITLE(String aPTITLE) {
		APTITLE = aPTITLE;
	}

	public String getAPDESCRIPTION() {
		return APDESCRIPTION;
	}

	public void setAPDESCRIPTION(String aPDESCRIPTION) {
		APDESCRIPTION = aPDESCRIPTION;
	}

	public Double getAPRATING() {
		return APRATING;
	}

	public void setAPRATING(Double aPRATING) {
		APRATING = aPRATING;
	}

	public String getAPPRICE() {
		return APPRICE;
	}

	public void setAPPRICE(String aPPRICE) {
		APPRICE = aPPRICE;
	}

	public Integer getAPSTOCKAVAILABILITY() {
		return APSTOCKAVAILABILITY;
	}

	public void setAPSTOCKAVAILABILITY(Integer aPSTOCKAVAILABILITY) {
		APSTOCKAVAILABILITY = aPSTOCKAVAILABILITY;
	}

	public String getAPIMAGES() {
		return APIMAGES;
	}

	public void setAPIMAGES(String aPIMAGES) {
		APIMAGES = aPIMAGES;
	}

	public String getAPPRODUCTDETAILS() {
		return APPRODUCTDETAILS;
	}

	public void setAPPRODUCTDETAILS(String aPPRODUCTDETAILS) {
		APPRODUCTDETAILS = aPPRODUCTDETAILS;
	}
	
	
	public Integer getQuantity() {
		return Quantity;
		
	}
	
	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}
	
	
	

	@Override
	public String toString() {
		return "ARTIFICIAL_PLANT [APID=" + APID + ", APTITLE=" + APTITLE + ", APDESCRIPTION=" + APDESCRIPTION
				+ ", APRATING=" + APRATING + ", APPRICE=" + APPRICE + ", APSTOCKAVAILABILITY=" + APSTOCKAVAILABILITY
				+ ", APIMAGES=" + APIMAGES + ", APPRODUCTDETAILS=" + APPRODUCTDETAILS + "]";
	}
}
