package com.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Service.ConsumerService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin(value="*")
public class Registration_Controller {

	@Autowired
	ConsumerService cService;

	@PostMapping("/upload")
	public ResponseEntity<Boolean> uploadData(@RequestParam String Firstname, @RequestParam String Lastname,
			@RequestParam String EMailid, @RequestParam String Address, @RequestParam String Pincode,
			@RequestParam String State, @RequestParam String Gender, @RequestParam String WhatsApp_Number,
			@RequestParam String UserPassword,HttpServletRequest request,HttpServletResponse response) {

		boolean flag = cService.uploadData(Firstname, Lastname, EMailid, Address, Pincode, State, Gender,
				WhatsApp_Number, UserPassword);
		if (flag) {
			HttpSession session = request.getSession();
			session.setAttribute("WhatsappNo",WhatsApp_Number);
			
			return ResponseEntity.ok(flag);
		} else {
			return ResponseEntity.ok(false);
		}

	}
	
	@GetMapping("/GetUserId")
	public ResponseEntity<String> sendUID(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		String wno=(String) session.getAttribute("WhatsappNo");
		String uid=cService.getUID(wno);
		if(uid!=null) {
			return ResponseEntity.ok(uid);
		}
		else {
	        String errorMessage = "User ID not available.";
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
	    }
	}

}
