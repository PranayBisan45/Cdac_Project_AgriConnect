package com.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Model.Consumer;
import com.demo.Service.ProfileService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin(value="*")
public class PROFILE_CONTROLLER {

		@Autowired
		private ProfileService pservice;
		
		@GetMapping("/showProfile")
		public ResponseEntity<Consumer> showProfile(HttpServletRequest request, HttpServletResponse response){
			HttpSession session = request.getSession();
			String userid = (String) session.getAttribute("UserID");			
			Consumer c = pservice.getConsumer(userid);
			
			return ResponseEntity.ok(c);
			
		}
		
		
}
