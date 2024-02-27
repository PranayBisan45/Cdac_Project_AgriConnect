package com.demo.Model;

public class SEED_BULB {

	private String SBID;
	private String SBTITLE;
	private String SBDESCRIPTION;
	private String SBDETAILS;
	private Double SB_RATING;
	private String SBPRICE;
	private Integer SB_STOCK_AVAILABILITY;
	private String SBIMAGES;
	private Integer Quantity;
	
	
	
	
	public SEED_BULB() {
		super();
	}

	public SEED_BULB(String sBID, String sBTITLE, String sBDESCRIPTION, String sBDETAILS, Double sB_RATING,
			String sBPRICE, Integer sB_STOCK_AVAILABILITY, String sBIMAGES) {
		super();
		SBID = sBID;
		SBTITLE = sBTITLE;
		SBDESCRIPTION = sBDESCRIPTION;
		SBDETAILS = sBDETAILS;
		SB_RATING = sB_RATING;
		SBPRICE = sBPRICE;
		SB_STOCK_AVAILABILITY = sB_STOCK_AVAILABILITY;
		SBIMAGES = sBIMAGES;
	}

	public String getSBID() {
		return SBID;
	}

	public void setSBID(String sBID) {
		SBID = sBID;
	}

	public String getSBTITLE() {
		return SBTITLE;
	}

	public void setSBTITLE(String sBTITLE) {
		SBTITLE = sBTITLE;
	}

	public String getSBDESCRIPTION() {
		return SBDESCRIPTION;
	}

	public void setSBDESCRIPTION(String sBDESCRIPTION) {
		SBDESCRIPTION = sBDESCRIPTION;
	}

	public String getSBDETAILS() {
		return SBDETAILS;
	}

	public void setSBDETAILS(String sBDETAILS) {
		SBDETAILS = sBDETAILS;
	}

	public Double getSB_RATING() {
		return SB_RATING;
	}

	public void setSB_RATING(Double sB_RATING) {
		SB_RATING = sB_RATING;
	}

	public String getSBPRICE() {
		return SBPRICE;
	}

	public void setSBPRICE(String sBPRICE) {
		SBPRICE = sBPRICE;
	}

	public Integer getSB_STOCK_AVAILABILITY() {
		return SB_STOCK_AVAILABILITY;
	}

	public void setSB_STOCK_AVAILABILITY(Integer sB_STOCK_AVAILABILITY) {
		SB_STOCK_AVAILABILITY = sB_STOCK_AVAILABILITY;
	}

	public String getSBIMAGES() {
		return SBIMAGES;
	}

	public void setSBIMAGES(String sBIMAGES) {
		SBIMAGES = sBIMAGES;
	}
	
	public Integer getQuantity() {
		return Quantity;
		
	}
	
	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}

	@Override
	public String toString() {
		return "SEED_BULB [SBID=" + SBID + ", SBTITLE=" + SBTITLE + ", SBDESCRIPTION=" + SBDESCRIPTION + ", SBDETAILS="
				+ SBDETAILS + ", SB_RATING=" + SB_RATING + ", SBPRICE=" + SBPRICE + ", SB_STOCK_AVAILABILITY="
				+ SB_STOCK_AVAILABILITY + ", SBIMAGES=" + SBIMAGES + "]";
	}
	
}

