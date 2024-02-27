package com.demo.Model;


public class Plant_Food {
	private String PFID;
	private String PFTitle;
	private String PFDescription;
	private String PFWeight;
	private Double PFRating;
	private String PFPrice;
	private Integer PFSTOCKAVAILABILITY;
	private String PFImages;
	private Integer Quantity;
	
	public Plant_Food() {
		super();
	}

	public Plant_Food(String pFID, String pFTitle, String pFDescription, String pFWeight, Double pFRating,
			String pFPrice, Integer pFSTOCKAVAILABILITY, String pFImages) {
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

	public Double getPFRating() {
		return PFRating;
	}

	public void setPFRating(Double pFRating) {
		PFRating = pFRating;
	}

	public String getPFPrice() {
		return PFPrice;
	}

	public void setPFPrice(String pFPrice) {
		PFPrice = pFPrice;
	}

	public Integer getPFSTOCKAVAILABILITY() {
		return PFSTOCKAVAILABILITY;
	}

	public void setPFSTOCKAVAILABILITY(Integer pFSTOCKAVAILABILITY) {
		PFSTOCKAVAILABILITY = pFSTOCKAVAILABILITY;
	}

	public String getPFImages() {
		return PFImages;
	}

	public void setPFImages(String pFImages) {
		PFImages = pFImages;
	}
	
	
	public Integer getQuantity() {
		return Quantity;
		
	}
	
	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}

	@Override
	public String toString() {
		return "Plant_Food [PFID=" + PFID + ", PFTitle=" + PFTitle + ", PFDescription=" + PFDescription + ", PFWeight="
				+ PFWeight + ", PFRating=" + PFRating + ", PFPrice=" + PFPrice + ", PFSTOCKAVAILABILITY="
				+ PFSTOCKAVAILABILITY + ", PFImages=" + PFImages + "]";
	}
}