package com.demo.Model;


public class Plant_Food {
	private String PFID;
	private String PFTitle;
	private String PFDescription;
	private String PFWeight;
	private double PFRating;
	private String PFPrice;
	private int PFSTOCKAVAILABILITY;
	private String PFImages;
	
	public Plant_Food() {
		super();
	}

	public Plant_Food(String pFID, String pFTitle, String pFDescription, String pFWeight, double pFRating,
			String pFPrice, int pFSTOCKAVAILABILITY, String pFImages) {
		super();
		PFID = pFID;
		PFTitle = pFTitle;
		PFDescription = pFDescription;
		PFWeight = pFWeight;
		PFRating = pFRating;
		PFPrice = pFPrice;
		PFSTOCKAVAILABILITY = pFSTOCKAVAILABILITY;
		PFImages = pFImages;
	}

	public String getPFID() {
		return PFID;
	}

	public void setPFID(String pFID) {
		PFID = pFID;
	}

	public String getPFTitle() {
		return PFTitle;
	}

	public void setPFTitle(String pFTitle) {
		PFTitle = pFTitle;
	}

	public String getPFDescription() {
		return PFDescription;
	}

	public void setPFDescription(String pFDescription) {
		PFDescription = pFDescription;
	}

	public String getPFWeight() {
		return PFWeight;
	}

	public void setPFWeight(String pFWeight) {
		PFWeight = pFWeight;
	}

	public double getPFRating() {
		return PFRating;
	}

	public void setPFRating(double pFRating) {
		PFRating = pFRating;
	}

	public String getPFPrice() {
		return PFPrice;
	}

	public void setPFPrice(String pFPrice) {
		PFPrice = pFPrice;
	}

	public int getPFSTOCKAVAILABILITY() {
		return PFSTOCKAVAILABILITY;
	}

	public void setPFSTOCKAVAILABILITY(int pFSTOCKAVAILABILITY) {
		PFSTOCKAVAILABILITY = pFSTOCKAVAILABILITY;
	}

	public String getPFImages() {
		return PFImages;
	}

	public void setPFImages(String pFImages) {
		PFImages = pFImages;
	}

	@Override
	public String toString() {
		return "Plant_Food [PFID=" + PFID + ", PFTitle=" + PFTitle + ", PFDescription=" + PFDescription + ", PFWeight="
				+ PFWeight + ", PFRating=" + PFRating + ", PFPrice=" + PFPrice + ", PFSTOCKAVAILABILITY="
				+ PFSTOCKAVAILABILITY + ", PFImages=" + PFImages + "]";
	}
}