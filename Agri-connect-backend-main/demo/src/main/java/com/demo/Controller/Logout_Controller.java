package com.demo.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin(value="*")
public class Logout_Controller {
	
	@GetMapping("/Logout")
	public ResponseEntity<String> logout(HttpServletRequest request, HttpServletResponse response) {
	    try {
	        HttpSession session = request.getSession();
	        session.invalidate();
	        String successMessage = "Logout successful";
	        return ResponseEntity.ok(successMessage);
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Logout failed");
	    }
	}

}