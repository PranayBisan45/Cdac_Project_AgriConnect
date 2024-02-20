package com.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Dao.Add_TO_Cart_Dao;

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

}
