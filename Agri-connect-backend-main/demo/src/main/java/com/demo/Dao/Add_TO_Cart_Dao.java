package com.demo.Dao;

public interface Add_TO_Cart_Dao {

	Boolean AddTOCart(String pid, String ptitle, String pprice, String pimage, Integer qty);

	Boolean RemoveToCart(String pid);

}
