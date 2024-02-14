package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.ConsumerService;

@RestController
@CrossOrigin(value="*")
public class Consumer_Controller {
	
	@Autowired
	private ConsumerService cservice;
	
	@PostMapping("/Registration")
	public ResponseEntity<Void> registration(
	        @RequestParam String FIRSTNAME,
	        @RequestParam String LASTNAME,
	        @RequestParam String EMAILID,
	        @RequestParam String ADDRESS,
	        @RequestParam String PINCODE,
	        @RequestParam String STATE,
	        @RequestParam String GENDER,
	        @RequestParam String WhatsApp_Number,
	        @RequestParam String USER_PASSWORD) {
	    cservice.regis( FIRSTNAME, LASTNAME, EMAILID, ADDRESS, PINCODE, STATE, GENDER, WhatsApp_Number, USER_PASSWORD);
	    
	    return ResponseEntity.noContent().build();
	}
}





 
 