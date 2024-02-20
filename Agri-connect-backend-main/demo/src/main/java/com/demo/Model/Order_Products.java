package com.demo.Model;

public class Order_Products {
	
	private String ProductImage;
	private String ProductTitle;
	private String ProductDescription;
	private String ProductQuantity;
	private String ProductTotalPrice;
	
	
	public Order_Products() {
		super();
	}


	public Order_Products(String productImage, String productTitle, String productDescription, String productQuantity,
			String productTotalPrice) {
		super();
		ProductImage = productImage;
		ProductTitle = productTitle;
		ProductDescription = productDescription;
		ProductQuantity = productQuantity;
		ProductTotalPrice = productTotalPrice;
	}


	public String getProductImage() {
		return ProductImage;
	}


	public void setProductImage(String productImage) {
		ProductImage = productImage;
	}


	public String getProductTitle() {
		return ProductTitle;
	}


	public void setProductTitle(String productTitle) {
		ProductTitle = productTitle;
	}


	public String getProductDescription() {
		return ProductDescription;
	}


	public void setProductDescription(String productDescription) {
		ProductDescription = productDescription;
	}


	public String getProductQuantity() {
		return ProductQuantity;
	}


	public void setProductQuantity(String productQuantity) {
		ProductQuantity = productQuantity;
	}


	public String getProductTotalPrice() {
		return ProductTotalPrice;
	}


	public void setProductTotalPrice(String productTotalPrice) {
		ProductTotalPrice = productTotalPrice;
	}


	@Override
	public String toString() {
		return "Order_Products [ProductImage=" + ProductImage + ", ProductTitle=" + ProductTitle
				+ ", ProductDescription=" + ProductDescription + ", ProductQuantity=" + ProductQuantity
				+ ", ProductTotalPrice=" + ProductTotalPrice + "]";
	}
	
	

}
