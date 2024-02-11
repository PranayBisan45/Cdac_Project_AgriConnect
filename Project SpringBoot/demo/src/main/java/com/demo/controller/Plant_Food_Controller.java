package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Plant_Food;
import com.demo.service.PlantFoodService;

@RestController
@CrossOrigin(value="*")
public class Plant_Food_Controller {
	@Autowired
	private PlantFoodService pfservice;
	
	@GetMapping("/Products")
	public ResponseEntity<List<Plant_Food>> getAllProducts() {
		List<Plant_Food> plist= pfservice.getAllProducts();
		 return ResponseEntity.ok(plist);
	}
	
	
	@GetMapping("/Products/{pfid}")
	public ResponseEntity<Plant_Food> getById(@PathVariable String pfid){
		Plant_Food p=pfservice.getById(pfid);
		if (p!=null)
			return ResponseEntity.ok(p);
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping("/Products/A-Z")
	public ResponseEntity<List<Plant_Food>>  sortA_Z(@RequestParam int offset,@RequestParam int limit) {
		List<Plant_Food> psort = pfservice.sortA_Z(offset,limit);
		return ResponseEntity.ok(psort);
	}
	
	@GetMapping("/Products/Z-A")
	public ResponseEntity<List<Plant_Food>> sortZ_A(@RequestParam int offset,@RequestParam int limit) {
		List<Plant_Food> psort = pfservice.sortZ_A(offset,limit);
		return ResponseEntity.ok(psort);
	}
	
	@GetMapping("/Products/Availability")
	public ResponseEntity<List<Plant_Food>> Availability(@RequestParam int offset,@RequestParam int limit) {
		List<Plant_Food> pavailability = pfservice.Availability(offset,limit);
		return ResponseEntity.ok(pavailability);
	}
}