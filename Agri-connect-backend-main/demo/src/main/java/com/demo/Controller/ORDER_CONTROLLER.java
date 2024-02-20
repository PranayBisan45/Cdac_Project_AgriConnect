package com.demo.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@PostMapping("/OrderInsert")
	public ResponseEntity<Object> insertOrder(@RequestParam("PID") List<String> productIDs,
	                                          @RequestParam("UPrice") List<String> unitPrices,
	                                          @RequestParam("UQuantity") List<String> unitQuantities,
	                                          @RequestParam String subtotal,@RequestParam String token,
	                                          HttpServletRequest request,
	                                          HttpServletResponse response) {
	    // Retrieve user ID from session
	    HttpSession session = request.getSession();
	    String uid = (String) session.getAttribute("UserID");

	    // Validate input parameters
	    if (productIDs == null || unitPrices == null || unitQuantities == null || subtotal == null ||
	        productIDs.isEmpty() || unitPrices.isEmpty() || unitQuantities.isEmpty()) {
	        return ResponseEntity.badRequest().body("Missing or empty parameters");
	    }

	    // Insert the order
	    boolean success = oservice.insertorder(productIDs, unitPrices, unitQuantities, subtotal, uid,token);

	    if (success) {
	        return ResponseEntity.ok().body("Order inserted successfully");
	    } else {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to insert order");
	    }
	}

	
	
	@GetMapping("/OrderFront")
	public ResponseEntity<List<Order_Front>> getAllOrders(HttpServletRequest request, HttpServletResponse response){
		HttpSession session  = request.getSession();
		String usrid = (String) session.getAttribute("UserID");
		List<Order_Front> liof = oservice.getAllOrders(usrid);
		return ResponseEntity.ok(liof);
	}
	
	@GetMapping("/OrderRare")
	public ResponseEntity<List<Order_Products>> getAllProducts(@RequestParam String orderid,HttpServletRequest request, HttpServletResponse response){
		
		List<Order_Products> liop = oservice.getAllProducts(orderid);
		return ResponseEntity.ok(liop);
		
	}


	
	
}
