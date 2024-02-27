package com.demo.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Model.Order_Front;
import com.demo.Model.Order_Products;
import com.demo.Service.OrderService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin(value="*")
public class ORDER_CONTROLLER {
	
	@Autowired
	private OrderService oservice;
	
	@GetMapping("/OrderInsert")
	public ResponseEntity<Boolean> insertOrder(@RequestParam("PID") List<String> productIDs,
	                                           @RequestParam("UPrice") List<String> unitPrices,
	                                           @RequestParam("UQuantity") List<String> unitQuantities,
	                                           @RequestParam String subtotal,
	                                           @RequestParam String uid,
	                                           @RequestParam String token,
	                                           HttpServletRequest request,
	                                           HttpServletResponse response) {
	    // Validate input parameters
	    if (productIDs == null || unitPrices == null || unitQuantities == null || subtotal == null ||
	        productIDs.isEmpty() || unitPrices.isEmpty() || unitQuantities.isEmpty()) {
	        return ResponseEntity.badRequest().body(false); // Return false for bad request
	    }

	    // Insert the order
	    boolean success = oservice.insertorder(productIDs, unitPrices, unitQuantities, subtotal, uid, token);

	    if (success) {
	        return ResponseEntity.ok().body(true); // Return true for successful insertion
	    } else {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false); // Return false for internal server error
	    }
	}


	
	
	@GetMapping("/OrderFront/{userid}")
	public ResponseEntity<List<Order_Front>> getAllOrders(@PathVariable String userid,HttpServletRequest request, HttpServletResponse response){
	
		List<Order_Front> liof = oservice.getAllOrders(userid);
		return ResponseEntity.ok(liof);
	}
	
	@GetMapping("/OrderRare/{orderid}")
	public ResponseEntity<List<Order_Products>> getAllProducts(@PathVariable String orderid,HttpServletRequest request, HttpServletResponse response){
		
		List<Order_Products> liop = oservice.getAllProducts(orderid);
		return ResponseEntity.ok(liop);
		
	}

	@GetMapping("/CancelOrder/{orderid}")
	public ResponseEntity<Boolean> deleteOrder(@PathVariable String orderid){
		Boolean flag = oservice.deleteorder(orderid);
		return ResponseEntity.ok(flag);
	}
	
}
