package com.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		public ResponseEntity<Consumer> showProfile(@RequestParam String userid,HttpServletRequest request, HttpServletResponse response){
			
				
			Consumer c = pservice.getConsumer(userid);
			
			return ResponseEntity.ok(c);
			
		}
		
		@PostMapping("/editAddress/{Userid}")
		public ResponseEntity<Boolean> editAddress(@PathVariable String Userid,@RequestParam String Address, @RequestParam String State, @RequestParam String Pincode, HttpServletRequest request, HttpServletResponse response){
			
			Boolean flag3 = pservice.editAddress(Address,State,Pincode,Userid); 
			return ResponseEntity.ok(flag3);
		}
		
		@GetMapping("/viewAddress/{Userid}")
		public ResponseEntity<Consumer> showAddress(@PathVariable String Userid ){
			
			Consumer c1 = pservice.viewAddress(Userid);
			
			return ResponseEntity.ok(c1);
		}
}
