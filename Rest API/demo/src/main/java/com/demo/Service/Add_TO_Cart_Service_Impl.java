package com.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Dao.Add_TO_Cart_Dao;
import com.demo.Model.Products;

@Service
public class Add_TO_Cart_Service_Impl implements Add_TO_Cart_Service {

	@Autowired
	private Add_TO_Cart_Dao Adao;
	
	@Override
	public Boolean AddToCart(String pid, String ptitle, String pprice, String pimage, Integer qty) {
		return Adao.AddTOCart(pid,ptitle,pprice,pimage,qty);
	}

	@Override
	public Boolean removeProduct(String pid) {
		return Adao.RemoveToCart(pid);
	}

	@Override
	public List<Products> getAll() {
		return Adao.getAll();
	}

	@Override
	public Boolean changeQty(String pid,int qty) {
		return Adao.changeQty(pid,qty);
	}

}