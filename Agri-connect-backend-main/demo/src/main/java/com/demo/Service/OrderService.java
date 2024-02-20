package com.demo.Service;

import java.util.List;

import com.demo.Model.Order_Front;
import com.demo.Model.Order_Products;

public interface OrderService {

	Boolean insertorder(List<String> productIDs, List<String> unitPrice, List<String> unitQuantity, String subtotal,
			String uid,String token);

	List<Order_Front> getAllOrders(String usrid);

	List<Order_Products> getAllProducts(String usid);



}
