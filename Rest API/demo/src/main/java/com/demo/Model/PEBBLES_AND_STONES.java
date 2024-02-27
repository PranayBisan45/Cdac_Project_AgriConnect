package com.demo.Model;

public class PEBBLES_AND_STONES {

	private String PASID;
	private String PASTITLE;
	private String PASDESCRIPTION;
	private String PASDETAILS;
	private Double PAS_RATING;
	private String PASPRICE;
	private Integer PAS_STOCK_AVAILABILITY;
	private String PASIMAGES;
	private Integer Quantity;
	
	
	public PEBBLES_AND_STONES() {
		super();
	}

	public PEBBLES_AND_STONES(String pASID, String pASTITLE, String pASDESCRIPTION, String pASDETAILS,
			Double pAS_RATING, String pASPRICE, Integer pAS_STOCK_AVAILABILITY, String pASIMAGES) {
		super();
		PASID = pASID;
		PASTITLE = pASTITLE;
		PASDESCRIPTION = pASDESCRIPTION;
		PASDETAILS = pASDETAILS;
		PAS_RATING = pAS_RATING;
		PASPRICE = pASPRICE;
		PAS_STOCK_AVAILABILITY = pAS_STOCK_AVAILABILITY;
		PASIMAGES = pASIMAGES;
	}

	public String getPASID() {
		return PASID;
	}

	public void setPASID(String pASID) {
		PASID = pASID;
	}

	public String getPASTITLE() {
		return PASTITLE;
	}

	public void setPASTITLE(String pASTITLE) {
		PASTITLE = pASTITLE;
	}

	public String getPASDESCRIPTION() {
		return PASDESCRIPTION;
	}

	public void setPASDESCRIPTION(String pASDESCRIPTION) {
		PASDESCRIPTION = pASDESCRIPTION;
	}

	public String getPASDETAILS() {
		return PASDETAILS;
	}

	public void setPASDETAILS(String pASDETAILS) {
		PASDETAILS = pASDETAILS;
	}

	public Double getPAS_RATING() {
		return PAS_RATING;
	}

	public void setPAS_RATING(Double pAS_RATING) {
		PAS_RATING = pAS_RATING;
	}

	public String getPASPRICE() {
		return PASPRICE;
	}

	public void setPASPRICE(String pASPRICE) {
		PASPRICE = pASPRICE;
	}

	public Integer getPAS_STOCK_AVAILABILITY() {
		return PAS_STOCK_AVAILABILITY;
	}

	public void setPAS_STOCK_AVAILABILITY(Integer pAS_STOCK_AVAILABILITY) {
		PAS_STOCK_AVAILABILITY = pAS_STOCK_AVAILABILITY;
	}

	public String getPASIMAGES() {
		return PASIMAGES;
	}

	public void setPASIMAGES(String pASIMAGES) {
		PASIMAGES = pASIMAGES;
	}
	
	public Integer getQuantity() {
		return Quantity;
		
	}
	
	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}

	@Override
	public String toString() {
		return "PEBBLES_AND_STONES [PASID=" + PASID + ", PASTITLE=" + PASTITLE + ", PASDESCRIPTION=" + PASDESCRIPTION
				+ ", PASDETAILS=" + PASDETAILS + ", PAS_RATING=" + PAS_RATING + ", PASPRICE=" + PASPRICE
				+ ", PAS_STOCK_AVAILABILITY=" + PAS_STOCK_AVAILABILITY + ", PASIMAGES=" + PASIMAGES + "]";
	}
	
}



