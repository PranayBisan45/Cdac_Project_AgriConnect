package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.demo.service.ProfileService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@RestController
@CrossOrigin(value="*")
public class Profile_Controller {

	@Autowired
	private ProfileService PService;
	
	@PostMapping("/EditAddress")
	public ResponseEntity <String> editAddress(@RequestBody String newAddress,HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		String uid=(String) session.getAttribute("UserID");
		ResponseEntity<String> Add=PService.editAddress(newAddress,uid);
		if(Add!=null) {
			return Add;
		}
		else {
			String errorMessage = "Failed to edit address";
	        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}