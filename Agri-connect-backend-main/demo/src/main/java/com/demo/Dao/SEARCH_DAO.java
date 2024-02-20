package com.demo.Dao;

import java.util.List;

import com.demo.Model.Products;

public interface SEARCH_DAO {

	List<Products> getProducts(String itemName);

}
