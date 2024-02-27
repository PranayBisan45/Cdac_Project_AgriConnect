package com.demo.Service;

import java.util.List;

import com.demo.Model.Products;

public interface Add_TO_Cart_Service {

	Boolean AddToCart(String pid, String ptitle, String pprice, String pimage, Integer qty);

	Boolean removeProduct(String pid);

	List<Products> getAll();

	Boolean changeQty(String pid, int qty);

}