package com.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.demo.Service.ConsumerService;

@RestController
@CrossOrigin("*")
public class REGISTRATION_CONTROLLER {
	
	@Autowired
	ConsumerService cService;

	@PostMapping("/upload")
    public ResponseEntity<String> uploadData(@RequestParam String Firstname,@RequestParam String Lastname,@RequestParam String EMailid,@RequestParam String Address, @RequestParam String Pincode, @RequestParam String State, @RequestParam String Gender,@RequestParam String WhatsApp_Number,@RequestParam String UserPassword) {
       
		boolean flag = cService.uploadData(  Firstname,  Lastname, EMailid, Address,   Pincode,   State,   Gender,  WhatsApp_Number,  UserPassword);
		if(flag) {
			String userid = cService.getUserIdAfterRegistration(WhatsApp_Number);
			return ResponseEntity.ok(userid);
		}
		else {
			return ResponseEntity.ok("Registration_Failed!!");
		} 
		
    }
	
}	
