package com.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Service.Add_TO_Cart_Service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin(value="*")
public class Add_TO_Cart_Controller {
	
	@Autowired
	private Add_TO_Cart_Service pservice;
	
	@PostMapping("/Add_TO_Cart")
	public ResponseEntity <Boolean> addProduct (@RequestBody String pid,@RequestBody String ptitle,@RequestBody String pprice,@RequestBody String pimage,@RequestBody Integer qty,HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String uid=(String) session.getAttribute("UserID");
		if(uid==null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
	} 
		Boolean flag=pservice.AddToCart(pid,ptitle,pprice,pimage,qty);
		if(flag) {
			return ResponseEntity.ok(true);
		}else {
			return ResponseEntity.ok(flag);
		}
	}
	
	@DeleteMapping("/DeleteProduct/{pid}")
	public ResponseEntity <Boolean> removeProduct(@PathVariable String pid) {
		Boolean flag=pservice.removeProduct(pid);
		if(flag) {
			return ResponseEntity.ok(true);
		}else {
			return ResponseEntity.ok(flag);
		}
	}
	
}