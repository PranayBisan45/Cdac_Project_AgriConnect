package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.demo.service.LoginService;

@RestController
@CrossOrigin(value="*")
public class Login_Controller {
	
	@Autowired
	private LoginService lservice;
	
	@GetMapping("/Login")
	public ResponseEntity <Boolean> login(@RequestParam String Uname,@RequestParam String Upass) {
		Boolean flag= lservice.getValidate(Uname,Upass);
		if(flag) {
		 return ResponseEntity.ok(flag);
		}
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
	}
	
	@GetMapping("/Forgot_Password")
	public ResponseEntity <String> Forgot_password(@RequestParam String Email, @RequestParam String UserID){
		String otp = lservice.getOtpForgotPassword(Email,UserID);
		return ResponseEntity.ok(otp);
	}
}