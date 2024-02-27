package com.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Model.Products;
import com.demo.Service.Add_TO_Cart_Service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin(value="*")
public class Add_TO_Cart_Controller {
	
	@Autowired
	private Add_TO_Cart_Service pservice;
	
	@GetMapping("/Add_TO_Cart")
	public ResponseEntity <Boolean> addProduct (@RequestParam String pid,@RequestParam String ptitle,@RequestParam String pprice,@RequestParam String pimage,@RequestParam Integer qty,HttpServletRequest request, HttpServletResponse response) {
//		HttpSession session = request.getSession();
//		String uid=(String) session.getAttribute("UserID");
//		if(uid==null) {
//			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
//	} 
		Boolean flag=pservice.AddToCart(pid,ptitle,pprice,pimage,qty);
		if(flag) {
			return ResponseEntity.ok(true);
		}else {
			return ResponseEntity.ok(flag);
		}
	}
	
	@GetMapping("/DeleteProduct/{pid}")
	public ResponseEntity <Boolean> removeProduct(@PathVariable String pid) {
		Boolean flag=pservice.removeProduct(pid);
		if(flag) {
			return ResponseEntity.ok(true);
		}else {
			return ResponseEntity.ok(flag);
		}
	}
	
	@GetMapping("/ShowCart")
	public ResponseEntity <List<Products>> getAll() {
		List<Products> plist = pservice.getAll();
		return ResponseEntity.ok(plist);
	}
	
	@PutMapping("/ChangeQuantity/{pid}/{qty}")
	public ResponseEntity <Boolean> changeQty(@PathVariable String pid,@PathVariable int qty) {
		Boolean flag=pservice.changeQty(pid,qty);
		if(flag) {
			return ResponseEntity.ok(true);
		}
		else {
			return ResponseEntity.ok(false);
		}
	}
}