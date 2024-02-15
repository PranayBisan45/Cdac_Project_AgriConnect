
package com.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.demo.Service.LoginService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin(value="*")
public class LOGIN_CONTROLLER {
	
	@Autowired
	private LoginService lservice;
	
	@GetMapping("/Login")
	public ResponseEntity <Boolean> login(@RequestParam String UseriD,@RequestParam String Upass,  HttpServletRequest request, HttpServletResponse response) {
		Boolean flag= lservice.getValidate(UseriD,Upass);
		if(flag) {
			HttpSession session = request.getSession();
			session.setAttribute("UserID", UseriD);
			session.setAttribute("Userpass", Upass);
			lservice.saveLogin(UseriD);
		 return ResponseEntity.ok(flag);
		}
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
	}
	
	@GetMapping("/Forgot_Password")
	public ResponseEntity <String> Forgot_password(@RequestParam String Phone, @RequestParam String UserID, HttpServletRequest request, HttpServletResponse response){
					
		String otp = lservice.getOtpForgotPassword(Phone,UserID);
		HttpSession session = request.getSession();
		session.setAttribute("UserID_ForgotP", UserID);
		return ResponseEntity.ok(otp);
		
		
	}
	
	@GetMapping("/Verify_Otp")
	public ResponseEntity<Boolean> CheckOtp(@RequestParam String OTP){
		Boolean flag = lservice.verifyOtp(OTP);
		if(flag) {
			return ResponseEntity.ok(true);
		}else {
			return ResponseEntity.ok(false);
		}
	}
	
	@PostMapping("/Update_Password")
	public ResponseEntity<Boolean> UpdatePassword(@RequestParam String Password,HttpServletRequest request, HttpServletResponse response ){
		HttpSession session = request.getSession();
		String uid = (String) session.getAttribute("UserID_ForgotP");
		Boolean flag1 = lservice.updatePass(Password,uid);
		if(flag1) {
			return ResponseEntity.ok(true);
		}else {
			return ResponseEntity.ok(false);
		}
	}
}