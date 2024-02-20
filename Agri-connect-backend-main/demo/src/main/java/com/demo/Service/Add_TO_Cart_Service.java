package com.demo.Service;

public interface Add_TO_Cart_Service {

	Boolean AddToCart(String pid, String ptitle, String pprice, String pimage, Integer qty);

	Boolean removeProduct(String pid);

}
