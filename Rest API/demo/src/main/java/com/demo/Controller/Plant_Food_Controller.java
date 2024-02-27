package com.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Model.Plant_Food;
import com.demo.Service.PlantFoodService;


@RestController
@CrossOrigin(value="*")
public class Plant_Food_Controller {
	@Autowired
	private PlantFoodService pfservice;
	
	@GetMapping("/PlantFood")
	public ResponseEntity<List<Plant_Food>> getAllProducts() {
		List<Plant_Food> plist= pfservice.getAllProducts();
		 return ResponseEntity.ok(plist);
	}
	
	
	@GetMapping("/PlantFood/{pfid}")
	public ResponseEntity<Plant_Food> getById(@PathVariable String pfid){
		Plant_Food p=pfservice.getById(pfid);
		if (p!=null) {
		return ResponseEntity.ok(p);
		}else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping("/PlantFood/A-Z")
	public ResponseEntity<List<Plant_Food>>  sortA_Z(@RequestParam int offset,@RequestParam int limit) {
		List<Plant_Food> psort = pfservice.sortA_Z(offset,limit);
		return ResponseEntity.ok(psort);
	}
	
	@GetMapping("/PlantFood/Z-A")
	public ResponseEntity<List<Plant_Food>> sortZ_A(@RequestParam int offset,@RequestParam int limit) {
		List<Plant_Food> psort = pfservice.sortZ_A(offset,limit);
		return ResponseEntity.ok(psort);
	}
	
	@GetMapping("/PlantFood/Availability")
	public ResponseEntity<List<Plant_Food>> Availability(@RequestParam int offset,@RequestParam int limit) {
		List<Plant_Food> pavailability = pfservice.Availability(offset,limit);
		return ResponseEntity.ok(pavailability);
	}
	
	@GetMapping("/PlantFood/Availability_By_A_Z")
	public ResponseEntity<List<Plant_Food>> Avail_By_A_Z(@RequestParam int offset,@RequestParam int limit) {
		List<Plant_Food> pavail_A_Z = pfservice.Availability_A_Z(offset, limit);
		return ResponseEntity.ok(pavail_A_Z);
	}
	
	@GetMapping("/PlantFood/Availability_By_Z_A")
	public ResponseEntity<List<Plant_Food>> Avail_By_Z_A(@RequestParam int offset,@RequestParam int limit) {
		List<Plant_Food> pavail_Z_A = pfservice.Availability_Z_A(offset, limit);
		return ResponseEntity.ok(pavail_Z_A);
	}
	
	@GetMapping("/PlantFood/Availability_Low_to_High")
	public ResponseEntity<List<Plant_Food>> SortByAvailPriceLH(@RequestParam int offset,@RequestParam int limit){
		List<Plant_Food> list = pfservice.getPlantByAvailPriceLH(offset,limit);
	         if(list!=null)
	        	 return ResponseEntity.ok(list);
	         else 
	        	 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping("/PlantFood/Availability_High_to_Low")
	public ResponseEntity<List<Plant_Food>> SortByAvailPriceHL(@RequestParam int offset,@RequestParam int limit){
		List<Plant_Food> list = pfservice.getPlantByAvailPriceHL(offset,limit);
	         if(list!=null)
	        	 return ResponseEntity.ok(list);
	         else 
	        	 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping("/PlantFood/load/by_price")
	public ResponseEntity<List<Plant_Food>> getLoadedPlantsFoodPrice11(@RequestParam int offset,@RequestParam int limit, @RequestParam double from, @RequestParam double to){
		List<Plant_Food> list = pfservice.getAllPlantsFoodLoadedPrice(offset, limit, from, to);
		return ResponseEntity.ok(list);
	}
	  
	@GetMapping("/PlantFood/Low_to_High")
	public ResponseEntity<List<Plant_Food>> SortByPriceLH(@RequestParam int offset,@RequestParam int limit){
		List<Plant_Food> list = pfservice.getPlantFoodByPrice(offset,limit);
	         if(list!=null)
	        	 return ResponseEntity.ok(list);
	         else 
	        	 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping("/PlantFood/High_to_Low")
	public ResponseEntity<List<Plant_Food>> SortByPriceHL(@RequestParam int offset,@RequestParam int limit){
		List<Plant_Food> list = pfservice.getPlantFoodByPriceHL(offset,limit);
	         if(list!=null)
	        	 return ResponseEntity.ok(list);
	         else 
	        	 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping("/PlantFood/load/by_price_High_to_Low")
	public ResponseEntity<List<Plant_Food>> getLoadedPlantsFilterSortPHL1(@RequestParam int offset,@RequestParam int limit,@RequestParam double from,@RequestParam double to){
		List<Plant_Food> list = pfservice.getLoadedPlantsFoodFilterSortPHL1(offset,limit,from,to);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/PlantFood/load/by_price_Low_to_High")
	public ResponseEntity<List<Plant_Food>> getLoadedPlantsFoodFilterSortPLH1(@RequestParam int offset,@RequestParam int limit,@RequestParam double from,@RequestParam double to){
		List<Plant_Food> list = pfservice.getLoadedPlantsFoodFilterSortPLH1(offset,limit,from,to);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/PlantFood/load/by_price_A_to_Z")
	public ResponseEntity<List<Plant_Food>> getLoadedPlantsFoodFilterSortAZ1(@RequestParam int offset, @RequestParam int limit, @RequestParam double from,@RequestParam double to ){
		List<Plant_Food> list =pfservice.getLoadedPlantsFoodFilterSortAZ1(offset,limit,from,to);
		return ResponseEntity.ok(list);
	}
	@GetMapping("/PlantFood/load/by_price_Z_to_A")
	public ResponseEntity<List<Plant_Food>> getLoadedPlantsFoodFilterSortZA1(@RequestParam int offset, @RequestParam int limit, @RequestParam double from,@RequestParam double to ){
		List<Plant_Food> list =pfservice.getLoadedPlantsFoodFilterSortZA1(offset,limit,from,to);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/PlantFood/load/by_rating")
	public ResponseEntity<List<Plant_Food>> getLoadedPlantsFoodRating1(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating) {
		List<Plant_Food> pp2list = pfservice.getLoadedPlantsFoodRating(offset, limit, rating);
		return ResponseEntity.ok(pp2list);
	}
	
	@GetMapping("/PlantFood/load/by_rating_High_to_Low")
	public ResponseEntity<List<Plant_Food>> getLoadedPlantsFoodFilterSortRHL2(@RequestParam int offset,@RequestParam int limit,@RequestParam double rating){
		List<Plant_Food> list = pfservice.getLoadedPlantsFoodFilterSortRHL2(offset,limit,rating);
		return ResponseEntity.ok(list);
	}
	@GetMapping("/PlantFood/load/by_rating_Low_to_High")
	public ResponseEntity<List<Plant_Food>> getLoadedPlantsFoodFilterSortRLH2(@RequestParam int offset,@RequestParam int limit,@RequestParam double rating){
		List<Plant_Food> list = pfservice.getLoadedPlantsFoodFilterSortRLH2(offset,limit,rating);
		return ResponseEntity.ok(list);
	}
	@GetMapping("/PlantFood/load/by_rating_A_to_Z")
	public ResponseEntity<List<Plant_Food>> getLoadedPlantsFoodFilterSortRAZ2(@RequestParam int offset,@RequestParam int limit,@RequestParam double rating){
		List<Plant_Food> list = pfservice.getLoadedPlantsFoodFilterSortRAZ2(offset,limit,rating);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/PlantFood/load/by_rating_Z_to_A")
	public ResponseEntity<List<Plant_Food>> getLoadedPlantsFoodFilterSortRZA2(@RequestParam int offset,@RequestParam int limit,@RequestParam double rating){
		List<Plant_Food> list = pfservice.getLoadedPlantsFoodFilterSortRZA2(offset,limit,rating);
		return ResponseEntity.ok(list);
	}

	@GetMapping("/PlantFood/load")
	public ResponseEntity<List<Plant_Food>> getLoadedPlantFoods(@RequestParam int offset,@RequestParam int limit) {
		List<Plant_Food> pp1list = pfservice.getAllPlantFoodLoaded(offset,limit);
		return ResponseEntity.ok(pp1list);
	}
	
	@GetMapping("/PlantFood/load/by_rating_by_price")
	public ResponseEntity<List<Plant_Food>> getLoadedPlantFoods3(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam double from, @RequestParam double to){
		List<Plant_Food> pp4list = pfservice.getAllPlantFoodsLoadedRatingPrice(offset, limit,rating, from, to);
		return ResponseEntity.ok(pp4list);
	}
	
	@GetMapping("/PlantFood/load/by_rating_by_stock")
	public ResponseEntity<List<Plant_Food>> getLoadedPlantFoods4(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam int stock) {
		List<Plant_Food> pp5list = pfservice.getAllPlantFoodsLoadedRatingStock(offset,limit,rating,stock);
		return ResponseEntity.ok(pp5list);
	}
	
	
	@GetMapping("/PlantFood/load/by_price_by_stock")
	public ResponseEntity<List<Plant_Food>> getLoadedPlantFoods5(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock) {
		List<Plant_Food> pp6list = pfservice.getAllPlantFoodLoadedPriceStock(offset,limit,from,to,stock);
		return ResponseEntity.ok(pp6list);
	}
	
	
	@GetMapping("/PlantFood/load/by_price_by_stock_by_rating")
	public ResponseEntity<List<Plant_Food>> getLoadedPlantFoods6(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock, @RequestParam double rating) {
		List<Plant_Food> pp7list = pfservice.getAllPlantFoodsLoadedPriceStockRating(offset,limit,from,to,stock,rating);
		return ResponseEntity.ok(pp7list);
	}
	
	@GetMapping("/PlantFood/load/by_rating_by_price_SORTBYTITLE_A-Z")
	public ResponseEntity<List<Plant_Food>> getLoadedPlantFoods7(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam double from, @RequestParam double to){
		List<Plant_Food> pp8list = pfservice.getAllPlantFoodsLoadedRatingPriceSORTTITLE_A_Z(offset, limit,rating, from, to);
		return ResponseEntity.ok(pp8list);
	}
	
	@GetMapping("/PlantFood/load/by_rating_by_price_SORTBYTITLE_Z-A")
	public ResponseEntity<List<Plant_Food>> getLoadedPlantFoods8(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam double from, @RequestParam double to){
		List<Plant_Food> pp9list = pfservice.getAllPlantFoodLoadedRatingPriceSORTTITLE_Z_A(offset, limit,rating, from, to);
		return ResponseEntity.ok(pp9list);
	}
	
	@GetMapping("/PlantFood/load/by_rating_by_price_SORTBYPRICE_L_TO_H")
	public ResponseEntity<List<Plant_Food>> getLoadedPlantFoods9(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam double from, @RequestParam double to){
		List<Plant_Food> pp10list = pfservice.getAllPlantFoodLoadedRatingPriceSORTBYPRICE_L_TO_H(offset, limit,rating, from, to);
		return ResponseEntity.ok(pp10list);
	}
	
	@GetMapping("/PlantFood/load/by_rating_by_price_SORTBYPRICE_H_TO_L")
	public ResponseEntity<List<Plant_Food>> getLoadedPlantFoods10(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam double from, @RequestParam double to){
		List<Plant_Food> pp11list = pfservice.getAllPlantFoodLoadedRatingPriceSORTBYPRICE_H_TO_L(offset, limit,rating, from, to);
		return ResponseEntity.ok(pp11list);
	}
	
	@GetMapping("/PlantFood/load/by_rating_by_stock_SORTBYTITLE_A-Z")
	public ResponseEntity<List<Plant_Food>> getLoadedPlantFoods11(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam int stock) {
		List<Plant_Food> pp12list = pfservice.getAllPlantFoodLoadedRatingStockSORTTITLE_A_Z(offset,limit,rating,stock);
		return ResponseEntity.ok(pp12list);
	}
	
	@GetMapping("/PlantFood/load/by_rating_by_stock_SORTBYTITLE_Z-A")
	public ResponseEntity<List<Plant_Food>> getLoadedPlantFoods12(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam int stock) {
		List<Plant_Food> pp13list = pfservice.getAllPlantFoodLoadedRatingStockSORTTITLE_Z_A(offset,limit,rating,stock);
		return ResponseEntity.ok(pp13list);
	}
	
	
	@GetMapping("/PlantFood/load/by_rating_by_stock_SORTBYPRICE_L_TO_H")
	public ResponseEntity<List<Plant_Food>> getLoadedPlantFoods13(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam int stock) {
		List<Plant_Food> pp14list = pfservice.getAllPlantFoodLoadedRatingStockSORTBYPRICE_L_TO_H(offset,limit,rating,stock);
		return ResponseEntity.ok(pp14list);
	}
	
	@GetMapping("/PlantFood/load/by_rating_by_stock_SORTBYPRICE_H_TO_L")
	public ResponseEntity<List<Plant_Food>> getLoadedPlantFoods14(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam int stock) {
		List<Plant_Food> pp15list = pfservice.getAllPlantFoodLoadedRatingStockSORTBYPRICE_H_TO_L(offset,limit,rating,stock);
		return ResponseEntity.ok(pp15list);
	}
	
	
	@GetMapping("/PlantFood/load/by_price_by_stock_SORTBYTITLE_A-Z")
	public ResponseEntity<List<Plant_Food>> getLoadedPlantFoods15(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock) {
		List<Plant_Food> pp16list = pfservice.getAllPlantFoodLoadedPriceStockSORTTITLE_A_Z(offset,limit,from,to,stock);
		return ResponseEntity.ok(pp16list);
	}
	
	@GetMapping("/PlantFood/load/by_price_by_stock_SORTBYTITLE_Z-A")
	public ResponseEntity<List<Plant_Food>> getLoadedPlantFoods16(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock) {
		List<Plant_Food> pp17list = pfservice.getAllPlantFoodLoadedPriceStockSORTTITLE_Z_A(offset,limit,from,to,stock);
		return ResponseEntity.ok(pp17list);
	}
	
	@GetMapping("/PlantFood/load/by_price_by_stock_SORTBYPRICE_L_TO_H")
	public ResponseEntity<List<Plant_Food>> getLoadedPlantFoods17(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock) {
		List<Plant_Food> pp18list = pfservice.getAllPlantFoodLoadedPriceStockSORTBYPRICE_L_TO_H(offset,limit,from,to,stock);
		return ResponseEntity.ok(pp18list);
	}
	
	@GetMapping("/PlantFood/load/by_price_by_stock_SORTBYPRICE_H_TO_L")
	public ResponseEntity<List<Plant_Food>> getLoadedPlantFoods18(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock) {
		List<Plant_Food> pp19list = pfservice.getAllPlantFoodLoadedPriceStockSORTBYPRICE_H_TO_L(offset,limit,from,to,stock);
		return ResponseEntity.ok(pp19list);
	}
	
	@GetMapping("/PlantFood/load/by_price_by_stock_by_rating_SORTBYTITLE_A-Z")
	public ResponseEntity<List<Plant_Food>> getLoadedPlantFoods19(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock, @RequestParam double rating) {
		List<Plant_Food> pp20list = pfservice.getAllPlantFoodLoadedPriceStockRatingSORTTITLE_A_Z(offset,limit,from,to,stock,rating);
		return ResponseEntity.ok(pp20list);
	}
	
	@GetMapping("/PlantFood/load/by_price_by_stock_by_rating_SORTBYTITLE_Z-A")
	public ResponseEntity<List<Plant_Food>> getLoadedPlantFoods20(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock, @RequestParam double rating) {
		List<Plant_Food> pp21list = pfservice.getAllPlantFoodLoadedPriceStockRatingSORTTITLE_Z_A(offset,limit,from,to,stock,rating);
		return ResponseEntity.ok(pp21list);
	}
	
	@GetMapping("/PlantFood/load/by_price_by_stock_by_rating_SORTBYPRICE_L_TO_H")
	public ResponseEntity<List<Plant_Food>> getLoadedPlantFoods21(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock, @RequestParam double rating) {
		List<Plant_Food> pp22list = pfservice.getAllPlantFoodLoadedPriceStockRatingSORTBYPRICE_L_TO_H(offset,limit,from,to,stock,rating);
		return ResponseEntity.ok(pp22list);
	}
	                                          
	@GetMapping("/PlantFood/load/by_price_by_stock_by_rating_SORTBYPRICE_H_TO_L")
	public ResponseEntity<List<Plant_Food>> getLoadedPlantFoods22(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock, @RequestParam double rating) {
		List<Plant_Food> pp23list = pfservice.getAllPlantFoodLoadedPriceStockRatingSORTBYPRICE_H_TO_L(offset,limit,from,to,stock,rating);
		return ResponseEntity.ok(pp23list);
	}
}