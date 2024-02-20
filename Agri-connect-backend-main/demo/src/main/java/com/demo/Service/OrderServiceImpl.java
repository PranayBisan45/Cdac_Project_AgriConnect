package com.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Dao.OrderDao;
import com.demo.Model.Order_Front;
import com.demo.Model.Order_Products;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired 
	private OrderDao odao;

	@Override
	public Boolean insertorder(List<String> productIDs, List<String> unitPrice, List<String> unitQuantity,
			String subtotal, String uid, String token) {
		// TODO Auto-generated method stub
		return odao.insertOrder(productIDs,unitPrice, unitQuantity,subtotal,uid,token);
	}

	@Override
	public List<Order_Front> getAllOrders(String usrid) {
		
		return odao.getallorders(usrid);
	}

	@Override
	public List<Order_Products> getAllProducts(String usid) {
		// TODO Auto-generated method stub
		return odao.getAllProducts(usid);
	}
	
	

}
