package com.demo.Model;

public class POT_PLANTERS {
	
	private String PPID;
	private String PPTITLE;
	private String PPDESCRIPTION;
	private String PPDIMENSION;
	private Double PP_RATING;
	private String PPPRICE;
	private Integer PP_STOCKAVAILABILITY;
	private String PPIMAGES;
	
	
	public POT_PLANTERS() {
		super();
	}
	public POT_PLANTERS(String pPID, String pPTITLE, String pPDESCRIPTION, String pPDIMENSION, Double pP_RATING,
			String pPPRICE, Integer pP_STOCKAVAILABILITY, String pPIMAGES) {
		super();
		PPID = pPID;
		PPTITLE = pPTITLE;
		PPDESCRIPTION = pPDESCRIPTION;
		PPDIMENSION = pPDIMENSION;
		PP_RATING = pP_RATING;
		PPPRICE = pPPRICE;
		PP_STOCKAVAILABILITY = pP_STOCKAVAILABILITY;
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
	public Integer getPP_STOCKAVAILABILITY() {
		return PP_STOCKAVAILABILITY;
	}
	public void setPP_STOCKAVAILABILITY(Integer pP_STOCKAVAILABILITY) {
		PP_STOCKAVAILABILITY = pP_STOCKAVAILABILITY;
	}
	public String getPPIMAGES() {
		return PPIMAGES;
	}
	public void setPPIMAGES(String pPIMAGES) {
		PPIMAGES = pPIMAGES;
	}
	@Override
	public String toString() {
		return "POT_PLANTERS [PPID=" + PPID + ", PPTITLE=" + PPTITLE + ", PPDESCRIPTION=" + PPDESCRIPTION
				+ ", PPDIMENSION=" + PPDIMENSION + ", PP_RATING=" + PP_RATING + ", PPPRICE=" + PPPRICE
				+ ", PP_STOCKAVAILABILITY=" + PP_STOCKAVAILABILITY + ", PPIMAGES=" + PPIMAGES + "]";
	}	
	
}
