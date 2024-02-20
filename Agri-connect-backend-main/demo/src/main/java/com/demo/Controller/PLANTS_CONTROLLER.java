package com.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Model.PLANTS;
import com.demo.Service.PLANTS_SERVICE;
import com.demo.Service.PLANTS_SERVICE;

@RestController
public class PLANTS_CONTROLLER {
	
	@Autowired
	PLANTS_SERVICE pservice;
	
	@GetMapping(value="/plants")
	public ResponseEntity<List<PLANTS>> getAllPotPlanters(){
		List<PLANTS> pplist = pservice.getAllPotPlanter();
		return ResponseEntity.ok(pplist);
		
	}
	
	@GetMapping("/plants/{ppid}")
	public ResponseEntity<PLANTS> getById(@PathVariable String ppid){
		PLANTS p=pservice.getById(ppid);
		if (p!=null)
			return ResponseEntity.ok(p);
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
		
	
	@GetMapping("/plants/load")
	public ResponseEntity<List<PLANTS>> getLoadedPotPlanters(@RequestParam int offset,@RequestParam int limit) {
		List<PLANTS> pp1list = pservice.getAllPotPlanterLoaded(offset,limit);
		return ResponseEntity.ok(pp1list);
	}
	
	@GetMapping("/plants/load/by_rating")
	public ResponseEntity<List<PLANTS>> getLoadedPotPlanters1(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating) {
		List<PLANTS> pp2list = pservice.getAllPotPlanterLoadedRating(offset, limit, rating);
		return ResponseEntity.ok(pp2list);
	} 
	
	@GetMapping("/plants/load/by_price")
	public ResponseEntity<List<PLANTS>> getLoadedPotPlanters2(@RequestParam int offset,@RequestParam int limit, @RequestParam double from, @RequestParam double to){
		List<PLANTS> pp3list = pservice.getAllPotPlanterLoadedPrice(offset, limit, from, to);
		return ResponseEntity.ok(pp3list);
	}
	
	@GetMapping("/plants/load/by_rating_by_price")
	public ResponseEntity<List<PLANTS>> getLoadedPotPlanters3(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam double from, @RequestParam double to){
		List<PLANTS> pp4list = pservice.getAllPotPlanterLoadedRatingPrice(offset, limit,rating, from, to);
		return ResponseEntity.ok(pp4list);
	}
	
	@GetMapping("/plants/load/by_rating_by_stock")
	public ResponseEntity<List<PLANTS>> getLoadedPotPlanters4(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam int stock) {
		List<PLANTS> pp5list = pservice.getAllPotPlanterLoadedRatingStock(offset,limit,rating,stock);
		return ResponseEntity.ok(pp5list);
	}
	
	
	@GetMapping("/plants/load/by_price_by_stock")
	public ResponseEntity<List<PLANTS>> getLoadedPotPlanters5(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock) {
		List<PLANTS> pp6list = pservice.getAllPotPlanterLoadedPriceStock(offset,limit,from,to,stock);
		return ResponseEntity.ok(pp6list);
	}
	
	
	@GetMapping("/plants/load/by_price_by_stock_by_rating")
	public ResponseEntity<List<PLANTS>> getLoadedPotPlanters6(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock, @RequestParam double rating) {
		List<PLANTS> pp7list = pservice.getAllPotPlanterLoadedPriceStockRating(offset,limit,from,to,stock,rating);
		return ResponseEntity.ok(pp7list);
	}
	
	@GetMapping("/plants/load/by_rating_by_price_SORTBYTITLE_A-Z")
	public ResponseEntity<List<PLANTS>> getLoadedPotPlanters7(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam double from, @RequestParam double to){
		List<PLANTS> pp8list = pservice.getAllPotPlanterLoadedRatingPriceSORTTITLE_A_Z(offset, limit,rating, from, to);
		return ResponseEntity.ok(pp8list);
	}
	
	@GetMapping("/plants/load/by_rating_by_price_SORTBYTITLE_Z-A")
	public ResponseEntity<List<PLANTS>> getLoadedPotPlanters8(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam double from, @RequestParam double to){
		List<PLANTS> pp9list = pservice.getAllPotPlanterLoadedRatingPriceSORTTITLE_Z_A(offset, limit,rating, from, to);
		return ResponseEntity.ok(pp9list);
	}
	
	@GetMapping("/plants/load/by_rating_by_price_SORTBYPRICE_L_TO_H")
	public ResponseEntity<List<PLANTS>> getLoadedPotPlanters9(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam double from, @RequestParam double to){
		List<PLANTS> pp10list = pservice.getAllPotPlanterLoadedRatingPriceSORTBYPRICE_L_TO_H(offset, limit,rating, from, to);
		return ResponseEntity.ok(pp10list);
	}
	
	@GetMapping("/plants/load/by_rating_by_price_SORTBYPRICE_H_TO_L")
	public ResponseEntity<List<PLANTS>> getLoadedPotPlanters10(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam double from, @RequestParam double to){
		List<PLANTS> pp11list = pservice.getAllPotPlanterLoadedRatingPriceSORTBYPRICE_H_TO_L(offset, limit,rating, from, to);
		return ResponseEntity.ok(pp11list);
	}
	
	@GetMapping("/plants/load/by_rating_by_stock_SORTBYTITLE_A-Z")
	public ResponseEntity<List<PLANTS>> getLoadedPotPlanters11(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam int stock) {
		List<PLANTS> pp12list = pservice.getAllPotPlanterLoadedRatingStockSORTTITLE_A_Z(offset,limit,rating,stock);
		return ResponseEntity.ok(pp12list);
	}
	
	@GetMapping("/plants/load/by_rating_by_stock_SORTBYTITLE_Z-A")
	public ResponseEntity<List<PLANTS>> getLoadedPotPlanters12(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam int stock) {
		List<PLANTS> pp13list = pservice.getAllPotPlanterLoadedRatingStockSORTTITLE_Z_A(offset,limit,rating,stock);
		return ResponseEntity.ok(pp13list);
	}
	
	
	@GetMapping("/plants/load/by_rating_by_stock_SORTBYPRICE_L_TO_H")
	public ResponseEntity<List<PLANTS>> getLoadedPotPlanters13(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam int stock) {
		List<PLANTS> pp14list = pservice.getAllPotPlanterLoadedRatingStockSORTBYPRICE_L_TO_H(offset,limit,rating,stock);
		return ResponseEntity.ok(pp14list);
	}
	
	@GetMapping("/plants/load/by_rating_by_stock_SORTBYPRICE_H_TO_L")
	public ResponseEntity<List<PLANTS>> getLoadedPotPlanters14(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam int stock) {
		List<PLANTS> pp15list = pservice.getAllPotPlanterLoadedRatingStockSORTBYPRICE_H_TO_L(offset,limit,rating,stock);
		return ResponseEntity.ok(pp15list);
	}
	
	
	@GetMapping("/plants/load/by_price_by_stock_SORTBYTITLE_A-Z")
	public ResponseEntity<List<PLANTS>> getLoadedPotPlanters15(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock) {
		List<PLANTS> pp16list = pservice.getAllPotPlanterLoadedPriceStockSORTTITLE_A_Z(offset,limit,from,to,stock);
		return ResponseEntity.ok(pp16list);
	}
	
	@GetMapping("/plants/load/by_price_by_stock_SORTBYTITLE_Z-A")
	public ResponseEntity<List<PLANTS>> getLoadedPotPlanters16(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock) {
		List<PLANTS> pp17list = pservice.getAllPotPlanterLoadedPriceStockSORTTITLE_Z_A(offset,limit,from,to,stock);
		return ResponseEntity.ok(pp17list);
	}
	
	@GetMapping("/plants/load/by_price_by_stock_SORTBYPRICE_L_TO_H")
	public ResponseEntity<List<PLANTS>> getLoadedPotPlanters17(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock) {
		List<PLANTS> pp18list = pservice.getAllPotPlanterLoadedPriceStockSORTBYPRICE_L_TO_H(offset,limit,from,to,stock);
		return ResponseEntity.ok(pp18list);
	}
	
	@GetMapping("/plants/load/by_price_by_stock_SORTBYPRICE_H_TO_L")
	public ResponseEntity<List<PLANTS>> getLoadedPotPlanters18(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock) {
		List<PLANTS> pp19list = pservice.getAllPotPlanterLoadedPriceStockSORTBYPRICE_H_TO_L(offset,limit,from,to,stock);
		return ResponseEntity.ok(pp19list);
	}
	
	@GetMapping("/plants/load/by_price_by_stock_by_rating_SORTBYTITLE_A-Z")
	public ResponseEntity<List<PLANTS>> getLoadedPotPlanters19(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock, @RequestParam double rating) {
		List<PLANTS> pp20list = pservice.getAllPotPlanterLoadedPriceStockRatingSORTTITLE_A_Z(offset,limit,from,to,stock,rating);
		return ResponseEntity.ok(pp20list);
	}
	
	@GetMapping("/plants/load/by_price_by_stock_by_rating_SORTBYTITLE_Z-A")
	public ResponseEntity<List<PLANTS>> getLoadedPotPlanters20(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock, @RequestParam double rating) {
		List<PLANTS> pp21list = pservice.getAllPotPlanterLoadedPriceStockRatingSORTTITLE_Z_A(offset,limit,from,to,stock,rating);
		return ResponseEntity.ok(pp21list);
	}
	
	@GetMapping("/plants/load/by_price_by_stock_by_rating_SORTBYPRICE_L_TO_H")
	public ResponseEntity<List<PLANTS>> getLoadedPotPlanters21(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock, @RequestParam double rating) {
		List<PLANTS> pp22list = pservice.getAllPotPlanterLoadedPriceStockRatingSORTBYPRICE_L_TO_H(offset,limit,from,to,stock,rating);
		return ResponseEntity.ok(pp22list);
	}
	
	@GetMapping("/plants/load/by_price_by_stock_by_rating_SORTBYPRICE_H_TO_L")
	public ResponseEntity<List<PLANTS>> getLoadedPotPlanters22(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock, @RequestParam double rating) {
		List<PLANTS> pp23list = pservice.getAllPotPlanterLoadedPriceStockRatingSORTBYPRICE_H_TO_L(offset,limit,from,to,stock,rating);
		return ResponseEntity.ok(pp23list);
	}
	
	@GetMapping("/plants/load/SORTBYTITLE_A-Z")
	public ResponseEntity<List<PLANTS>>  sortA_Z(@RequestParam int offset,@RequestParam int limit) {
		List<PLANTS> psort = pservice.sortA_Z(offset,limit);
		return ResponseEntity.ok(psort);
	}
	
	@GetMapping("/plants/load/SORTBYTITLE_Z-A")
	public ResponseEntity<List<PLANTS>> sortZ_A(@RequestParam int offset,@RequestParam int limit) {
		List<PLANTS> psort = pservice.sortZ_A(offset,limit);
		return ResponseEntity.ok(psort);
	}
	
	@GetMapping("/plants/Availability")
	public ResponseEntity<List<PLANTS>> Availability1(@RequestParam int offset,@RequestParam int limit) {
		List<PLANTS> pavailability = pservice.Availability(offset,limit);
		return ResponseEntity.ok(pavailability);
	}
	
	@GetMapping("/plants/Availability_SORTBYTITLE_A_Z")
	public ResponseEntity<List<PLANTS>> Avail_By_A_Z(@RequestParam int offset,@RequestParam int limit) {
		List<PLANTS> pavail_A_Z = pservice.Availability_A_Z(offset, limit);
		return ResponseEntity.ok(pavail_A_Z);
	}
	
	@GetMapping("/plants/Availability_SORTBYTITLE_Z_A")
	public ResponseEntity<List<PLANTS>> Avail_By_Z_A(@RequestParam int offset,@RequestParam int limit) {
		List<PLANTS> pavail_Z_A = pservice.Availability_Z_A(offset, limit);
		return ResponseEntity.ok(pavail_Z_A);
	}
	
	@GetMapping("/plants/Availability_SORTBYPRICE_Low_to_High")
	public ResponseEntity<List<PLANTS>> SortByPriceLH1(@RequestParam int offset,@RequestParam int limit){
		List<PLANTS> list = pservice.getPlantByPriceLH(offset,limit);
	         if(list!=null)
	        	 return ResponseEntity.ok(list);
	         else 
	        	 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping("/plants/Availability_SORTBYPRICE_High_to_Low")
	public ResponseEntity<List<PLANTS>> SortByPriceHL1(@RequestParam int offset,@RequestParam int limit){
		List<PLANTS> list = pservice.getPlantByPriceHL(offset,limit);
	         if(list!=null)
	        	 return ResponseEntity.ok(list);
	         else 
	        	 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping("/plants/SORTBYPRICE_Low_TO_High")
	public ResponseEntity<List<PLANTS>> SORTBYPRICE_L_H(@RequestParam int offset,@RequestParam int limit) {
		List<PLANTS> slh = pservice.SORTBYPRICE_L_H(offset, limit);
		return ResponseEntity.ok(slh);
	}
	
	@GetMapping("/plants/SORTBYPRICE_High_TO_Low")
	public ResponseEntity<List<PLANTS>> SORTBYPRICE_H_L(@RequestParam int offset,@RequestParam int limit) {
		List<PLANTS> shl = pservice.SORTBYPRICE_H_L(offset, limit);
		return ResponseEntity.ok(shl);
	}
	
	
	@GetMapping("/plants/load/by_price_High_to_Low")
	public ResponseEntity<List<PLANTS>> getLoadedPlantsFilterSortPHL1(@RequestParam int offset,@RequestParam int limit,@RequestParam double from,@RequestParam double to){
		List<PLANTS> list = pservice.getLoadedPlantsFilterSortPHL1(offset,limit,from,to);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/plants/load/by_price_Low_to_High")
	public ResponseEntity<List<PLANTS>> getLoadedPlantsFilterSortPLH1(@RequestParam int offset,@RequestParam int limit,@RequestParam double from,@RequestParam double to){
		List<PLANTS> list = pservice.getLoadedPlantsFilterSortPLH1(offset,limit,from,to);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/plants/load/by_price_A_to_Z")
	public ResponseEntity<List<PLANTS>> getLoadedPlantsFilterSortAZ1(@RequestParam int offset, @RequestParam int limit, @RequestParam double from,@RequestParam double to ){
		List<PLANTS> list =pservice.getLoadedPlantsFilterSortAZ1(offset,limit,from,to);
		return ResponseEntity.ok(list);
	}
	@GetMapping("/plants/load/by_price_Z_to_A")
	public ResponseEntity<List<PLANTS>> getLoadedPlantsFilterSortZA1(@RequestParam int offset, @RequestParam int limit, @RequestParam double from,@RequestParam double to ){
		List<PLANTS> list =pservice.getLoadedPlantsFilterSortZA1(offset,limit,from,to);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/plants/load/by_rating_SORTBYPRICE_High_to_Low")
	public ResponseEntity<List<PLANTS>> getLoadedPlantsFilterSortRHL2(@RequestParam int offset,@RequestParam int limit,@RequestParam double rating){
		List<PLANTS> list = pservice.getLoadedPlantsFilterSortRHL2(offset,limit,rating);
		return ResponseEntity.ok(list);
	}
	@GetMapping("/plants/load/by_rating_SORTBYPRICE_Low_to_High")
	public ResponseEntity<List<PLANTS>> getLoadedPlantsFilterSortRLH2(@RequestParam int offset,@RequestParam int limit,@RequestParam double rating){
		List<PLANTS> list = pservice.getLoadedPlantsFilterSortRLH2(offset,limit,rating);
		return ResponseEntity.ok(list);
	}
	@GetMapping("/plants/load/by_rating_A_to_Z")
	public ResponseEntity<List<PLANTS>> getLoadedPlantsFilterSortRAZ2(@RequestParam int offset,@RequestParam int limit,@RequestParam double rating){
		List<PLANTS> list = pservice.getLoadedPlantsFilterSortRAZ2(offset,limit,rating);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/plants/load/by_rating_Z_to_A")
	public ResponseEntity<List<PLANTS>> getLoadedPlantsFilterSortRZA2(@RequestParam int offset,@RequestParam int limit,@RequestParam double rating){
		List<PLANTS> list = pservice.getLoadedPlantsFilterSortRZA2(offset,limit,rating);
		return ResponseEntity.ok(list);
	}
		
}
	
	

