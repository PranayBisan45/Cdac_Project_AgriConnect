package com.demo.Model;

public class PLANTS {

	private String PID;
	private String PTITLE;
	private String PDESCRIPTION;
	private Double PRATING;
	private String PPRICE;
	private Integer PSTOCKAVAILABILITY;
	private String PIMAGES;
	private Integer Quantity;
	
	public PLANTS() {
		super();
	}


	public PLANTS(String pID, String pTITLE, String pDESCRIPTION, Double pRATING, String pPRICE,
			Integer pSTOCKAVAILABILITY, String pIMAGES) {
		super();
		PID = pID;
		PTITLE = pTITLE;
		PDESCRIPTION = pDESCRIPTION;
		PRATING = pRATING;
		PPRICE = pPRICE;
		PSTOCKAVAILABILITY = pSTOCKAVAILABILITY;
		PIMAGES = pIMAGES;
	}


	public String getPID() {
		return PID;
	}


	public void setPID(String pID) {
		PID = pID;
	}


	public String getPTITLE() {
		return PTITLE;
	}


	public void setPTITLE(String pTITLE) {
		PTITLE = pTITLE;
	}


	public String getPDESCRIPTION() {
		return PDESCRIPTION;
	}


	public void setPDESCRIPTION(String pDESCRIPTION) {
		PDESCRIPTION = pDESCRIPTION;
	}


	public Double getPRATING() {
		return PRATING;
	}


	public void setPRATING(Double pRATING) {
		PRATING = pRATING;
	}


	public String getPPRICE() {
		return PPRICE;
	}


	public void setPPRICE(String pPRICE) {
		PPRICE = pPRICE;
	}


	public Integer getPSTOCKAVAILABILITY() {
		return PSTOCKAVAILABILITY;
	}


	public void setPSTOCKAVAILABILITY(Integer pSTOCKAVAILABILITY) {
		PSTOCKAVAILABILITY = pSTOCKAVAILABILITY;
	}


	public String getPIMAGES() {
		return PIMAGES;
	}


	public void setPIMAGES(String pIMAGES) {
		PIMAGES = pIMAGES;
	}

	public Integer getQuantity() {
		return Quantity;
		
	}
	
	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}

	@Override
	public String toString() {
		return "PLANTS [PID=" + PID + ", PTITLE=" + PTITLE + ", PDESCRIPTION=" + PDESCRIPTION + ", PRATING=" + PRATING
				+ ", PPRICE=" + PPRICE + ", PSTOCKAVAILABILITY=" + PSTOCKAVAILABILITY + ", PIMAGES=" + PIMAGES + "]";
	}
	
}



