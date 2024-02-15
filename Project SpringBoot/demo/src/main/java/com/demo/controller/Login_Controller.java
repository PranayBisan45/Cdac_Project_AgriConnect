package com.demo.controller;

import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.demo.service.LoginService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin(value="*")
public class Login_Controller {

	@Autowired
	private LoginService lservice;
	
	@GetMapping("/Login")
	public ResponseEntity <Boolean> login(@RequestParam String Uname,@RequestParam String Upass,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean flag= lservice.getValidate(Uname,Upass);
		if(flag) {
			HttpSession session=request.getSession();
			session.setAttribute("uid", Uname);
		 return ResponseEntity.ok(flag);
		}
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
	}



	@GetMapping("/Forgot_Password")
	public ResponseEntity <String> Forgot_password(@RequestParam String Email, @RequestParam String UserID){
		String otp = lservice.getOtpForgotPassword(Email,UserID);
		return ResponseEntity.ok(otp);
	}
	
	@GetMapping("/Reset_Password")
	public ResponseEntity <Boolean> Reset_Password(@RequestParam String WhatsApp_Number, @RequestParam String OTP,@RequestParam String New_Password) {
		Boolean flag=lservice.newPass(WhatsApp_Number,OTP,New_Password);
		if(flag) {
			 return ResponseEntity.ok(flag);
		}
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
	}
}
