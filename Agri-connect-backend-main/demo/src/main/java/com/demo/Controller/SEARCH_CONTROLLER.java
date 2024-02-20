package com.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Model.Products;
import com.demo.Service.SEARCH_SERVICE;

@RestController
@CrossOrigin("*")
public class SEARCH_CONTROLLER {
	
	@Autowired 
	private SEARCH_SERVICE sservice;

	
	@GetMapping("/Search")
	public ResponseEntity<List<Products>> getProduct(@RequestParam String ItemName){
		
		 List<Products> plist = sservice.getproducts(ItemName);
	        
	        if (plist.isEmpty()) {
	            // Return a 404 Not Found response if no products are found
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	        }
	        
	        // Return the list of products if found
	        return ResponseEntity.ok(plist);
	}
	

}
