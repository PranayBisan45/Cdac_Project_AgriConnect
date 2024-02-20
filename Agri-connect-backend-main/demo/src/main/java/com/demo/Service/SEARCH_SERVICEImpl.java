package com.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Dao.SEARCH_DAO;
import com.demo.Model.Products;

@Service
public class SEARCH_SERVICEImpl implements SEARCH_SERVICE{

	
	
	@Autowired 
	private SEARCH_DAO sdao;

	@Override
	public List<Products> getproducts(String itemName) {
		// TODO Auto-generated method stub
		return sdao.getProducts(itemName);
	}
	
}
