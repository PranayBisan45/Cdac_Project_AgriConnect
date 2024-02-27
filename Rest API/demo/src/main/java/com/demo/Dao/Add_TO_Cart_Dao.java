package com.demo.Dao;

import java.util.List;

import com.demo.Model.Products;

public interface Add_TO_Cart_Dao {

	Boolean AddTOCart(String pid, String ptitle, String pprice, String pimage, Integer qty);

	Boolean RemoveToCart(String pid);

	List<Products> getAll();

	Boolean changeQty(String pid, int qty);

}