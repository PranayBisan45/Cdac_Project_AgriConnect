package com.demo.Model;

public class POT_PLANTERS {
	
	private String PPID;
	private String PPTITLE;
	private String PPDESCRIPTION;
	private String PPDIMENSION;
	private Double PP_RATING;
	private String PPPRICE;
	private Integer PP_STOCK_AVAILABILITY;
	private String PPIMAGES;
	private Integer Quantity;
	
	public POT_PLANTERS() {
		super();
	}
	public POT_PLANTERS(String pPID, String pPTITLE, String pPDESCRIPTION, String pPDIMENSION, Double pP_RATING,
			String pPPRICE, Integer PP_STOCK_AVAILABILITY, String pPIMAGES) {
		super();
		PPID = pPID;
		PPTITLE = pPTITLE;
		PPDESCRIPTION = pPDESCRIPTION;
		PPDIMENSION = pPDIMENSION;
		PP_RATING = pP_RATING;
		PPPRICE = pPPRICE;
		this.PP_STOCK_AVAILABILITY = PP_STOCK_AVAILABILITY;
		PPIMAGES = pPIMAGES;
	}
	public String getPPID() {
		return PPID;
	}
	public void setPPID(String pPID) {
		PPID = pPID;
	}
	public String getPPTITLE() {
		return PPTITLE;
	}
	public void setPPTITLE(String pPTITLE) {
		PPTITLE = pPTITLE;
	}
	public String getPPDESCRIPTION() {
		return PPDESCRIPTION;
	}
	public void setPPDESCRIPTION(String pPDESCRIPTION) {
		PPDESCRIPTION = pPDESCRIPTION;
	}
	public String getPPDIMENSION() {
		return PPDIMENSION;
	}
	public void setPPDIMENSION(String pPDIMENSION) {
		PPDIMENSION = pPDIMENSION;
	}
	public Double getPP_RATING() {
		return PP_RATING;
	}
	public void setPP_RATING(Double pP_RATING) {
		PP_RATING = pP_RATING;
	}
	public String getPPPRICE() {
		return PPPRICE;
	}
	public void setPPPRICE(String pPPRICE) {
		PPPRICE = pPPRICE;
	}
	public Integer getPP_STOCK_AVAILABILITY() {
		return PP_STOCK_AVAILABILITY;
	}
	public void setPP_STOCK_AVAILABILITY(Integer PP_STOCK_AVAILABILITY) {
		this.PP_STOCK_AVAILABILITY = PP_STOCK_AVAILABILITY;
	}
	public String getPPIMAGES() {
		return PPIMAGES;
	}
	public void setPPIMAGES(String pPIMAGES) {
		PPIMAGES = pPIMAGES;
	}
	
	
	public Integer getQuantity() {
		return Quantity;
		
	}
	
	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "POT_PLANTERS [PPID=" + PPID + ", PPTITLE=" + PPTITLE + ", PPDESCRIPTION=" + PPDESCRIPTION
				+ ", PPDIMENSION=" + PPDIMENSION + ", PP_RATING=" + PP_RATING + ", PPPRICE=" + PPPRICE
				+ ", PP_STOCK_AVAILABILITY=" + PP_STOCK_AVAILABILITY + ", PPIMAGES=" + PPIMAGES + "]";
	}	
	
}
