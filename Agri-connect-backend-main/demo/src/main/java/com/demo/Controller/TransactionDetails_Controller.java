package com.demo.Controller;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Service.TransactionDetailsService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin(value="*")
public class TransactionDetails_Controller {
	@Autowired
	private TransactionDetailsService tService;
	
	@PostMapping("/TransactionDetails")
	public ResponseEntity <Boolean> Transaction(String EMAIL,long CNO,int CVV,String CNAME,String EXP_DATE,double AMOUNT,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String uid=(String) session.getAttribute("UserID");
		boolean flag= tService.Transaction(uid,EMAIL,CNO,CVV,CNAME,EXP_DATE,AMOUNT);
		if(flag) {
			
			 return ResponseEntity.ok(flag);
		}
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
	}
}