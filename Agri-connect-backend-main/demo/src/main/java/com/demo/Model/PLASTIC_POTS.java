package com.demo.Model;

public class PLASTIC_POTS {

	private String PPOID;
	private String PPOTITLE;
	private String PPODESCRIPTION;
	private String PPODIMENSION;
	private Double PPO_RATING;
	private String PPOPRICE;
	private Integer PPO_STOCK_AVAILABILITY;
	private String PPOIMAGES;
	private Integer Quantity;
	
	public PLASTIC_POTS() {
		super();
	}


	public PLASTIC_POTS(String pPOID, String pPOTITLE, String pPODESCRIPTION, String pPODIMENSION, Double pPO_RATING,
			String pPOPRICE, Integer pPO_STOCK_AVAILABILITY, String pPOIMAGES) {
		super();
		PPOID = pPOID;
		PPOTITLE = pPOTITLE;
		PPODESCRIPTION = pPODESCRIPTION;
		PPODIMENSION = pPODIMENSION;
		PPO_RATING = pPO_RATING;
		PPOPRICE = pPOPRICE;
		PPO_STOCK_AVAILABILITY = pPO_STOCK_AVAILABILITY;
		PPOIMAGES = pPOIMAGES;
	}


	public String getPPOID() {
		return PPOID;
	}


	public void setPPOID(String pPOID) {
		PPOID = pPOID;
	}


	public String getPPOTITLE() {
		return PPOTITLE;
	}


	public void setPPOTITLE(String pPOTITLE) {
		PPOTITLE = pPOTITLE;
	}


	public String getPPODESCRIPTION() {
		return PPODESCRIPTION;
	}


	public void setPPODESCRIPTION(String pPODESCRIPTION) {
		PPODESCRIPTION = pPODESCRIPTION;
	}


	public String getPPODIMENSION() {
		return PPODIMENSION;
	}


	public void setPPODIMENSION(String pPODIMENSION) {
		PPODIMENSION = pPODIMENSION;
	}


	public Double getPPO_RATING() {
		return PPO_RATING;
	}


	public void setPPO_RATING(Double pPO_RATING) {
		PPO_RATING = pPO_RATING;
	}


	public String getPPOPRICE() {
		return PPOPRICE;
	}


	public void setPPOPRICE(String pPOPRICE) {
		PPOPRICE = pPOPRICE;
	}


	public Integer getPPO_STOCK_AVAILABILITY() {
		return PPO_STOCK_AVAILABILITY;
	}


	public void setPPO_STOCK_AVAILABILITY(Integer pPO_STOCK_AVAILABILITY) {
		PPO_STOCK_AVAILABILITY = pPO_STOCK_AVAILABILITY;
	}


	public String getPPOIMAGES() {
		return PPOIMAGES;
	}


	public void setPPOIMAGES(String pPOIMAGES) {
		PPOIMAGES = pPOIMAGES;
	}
	
	public Integer getQuantity() {
		return Quantity;
		
	}
	
	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}

	@Override
	public String toString() {
		return "PLASTIC_POTS [PPOID=" + PPOID + ", PPOTITLE=" + PPOTITLE + ", PPODESCRIPTION=" + PPODESCRIPTION
				+ ", PPODIMENSION=" + PPODIMENSION + ", PPO_RATING=" + PPO_RATING + ", PPOPRICE=" + PPOPRICE
				+ ", PPO_STOCK_AVAILABILITY=" + PPO_STOCK_AVAILABILITY + ", PPOIMAGES=" + PPOIMAGES + "]";
	}
	
	
	
	
}
