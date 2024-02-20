package com.demo.Model;

public class PUMP_SPRAY {
	
	private String PSID;
	private String PSTITLE;
	private String PSDESCRIPTION;
	private Double PSRATING;
	private String PSPRICE;
	private Integer PSSTOCKAVAILABILITY;
	private String PSIMAGES;
	private String PSPRODUCTDETAILS;
	private Integer Quantity;

	
	
	public PUMP_SPRAY() {
		super();
	}


	public PUMP_SPRAY(String pSID, String pSTITLE, String pSDESCRIPTION, Double pSRATING, String pSPRICE,
			Integer pSSTOCKAVAILABILITY, String pSIMAGES, String pSPRODUCTDETAILS) {
		super();
		PSID = pSID;
		PSTITLE = pSTITLE;
		PSDESCRIPTION = pSDESCRIPTION;
		PSRATING = pSRATING;
		PSPRICE = pSPRICE;
		PSSTOCKAVAILABILITY = pSSTOCKAVAILABILITY;
		PSIMAGES = pSIMAGES;
		PSPRODUCTDETAILS = pSPRODUCTDETAILS;
	}


	public String getPSID() {
		return PSID;
	}


	public void setPSID(String pSID) {
		PSID = pSID;
	}


	public String getPSTITLE() {
		return PSTITLE;
	}


	public void setPSTITLE(String pSTITLE) {
		PSTITLE = pSTITLE;
	}


	public String getPSDESCRIPTION() {
		return PSDESCRIPTION;
	}


	public void setPSDESCRIPTION(String pSDESCRIPTION) {
		PSDESCRIPTION = pSDESCRIPTION;
	}


	public Double getPSRATING() {
		return PSRATING;
	}


	public void setPSRATING(Double pSRATING) {
		PSRATING = pSRATING;
	}


	public String getPSPRICE() {
		return PSPRICE;
	}


	public void setPSPRICE(String pSPRICE) {
		PSPRICE = pSPRICE;
	}


	public Integer getPSSTOCKAVAILABILITY() {
		return PSSTOCKAVAILABILITY;
	}


	public void setPSSTOCKAVAILABILITY(Integer pSSTOCKAVAILABILITY) {
		PSSTOCKAVAILABILITY = pSSTOCKAVAILABILITY;
	}


	public String getPSIMAGES() {
		return PSIMAGES;
	}


	public void setPSIMAGES(String pSIMAGES) {
		PSIMAGES = pSIMAGES;
	}


	public String getPSPRODUCTDETAILS() {
		return PSPRODUCTDETAILS;
	}


	public void setPSPRODUCTDETAILS(String pSPRODUCTDETAILS) {
		PSPRODUCTDETAILS = pSPRODUCTDETAILS;
	}
	
	public Integer getQuantity() {
		return Quantity;
		
	}
	
	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}

	@Override
	public String toString() {
		return "PUMP_SPRAY [PSID=" + PSID + ", PSTITLE=" + PSTITLE + ", PSDESCRIPTION=" + PSDESCRIPTION + ", PSRATING="
				+ PSRATING + ", PSPRICE=" + PSPRICE + ", PSSTOCKAVAILABILITY=" + PSSTOCKAVAILABILITY + ", PSIMAGES="
				+ PSIMAGES + ", PSPRODUCTDETAILS=" + PSPRODUCTDETAILS + "]";
	}
	
	
}
