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

import com.demo.Model.PLASTIC_POTS;
import com.demo.Service.PLASTIC_POTS_SERVICE;

@RestController
public class PLASTIC_POTS_CONTROLLER {
	
	@Autowired
	PLASTIC_POTS_SERVICE plpservice;
	
	@GetMapping(value="/plastic_pots")
	public ResponseEntity<List<PLASTIC_POTS>> getAllPotPlanters(){
		List<PLASTIC_POTS> pplist = plpservice.getAllPotPlanter();
		return ResponseEntity.ok(pplist);
		
	}
	
	@GetMapping("/plastic_pots/{ppid}")
	public ResponseEntity<PLASTIC_POTS> getById(@PathVariable String ppid){
		PLASTIC_POTS p=plpservice.getById(ppid);
		if (p!=null)
			return ResponseEntity.ok(p);
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
		
	
	@GetMapping("/plastic_pots/load")
	public ResponseEntity<List<PLASTIC_POTS>> getLoadedPotPlanters(@RequestParam int offset,@RequestParam int limit) {
		List<PLASTIC_POTS> pp1list = plpservice.getAllPotPlanterLoaded(offset,limit);
		return ResponseEntity.ok(pp1list);
	}
	
	@GetMapping("/plastic_pots/load/by_rating")
	public ResponseEntity<List<PLASTIC_POTS>> getLoadedPotPlanters1(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating) {
		List<PLASTIC_POTS> pp2list = plpservice.getAllPotPlanterLoadedRating(offset, limit, rating);
		return ResponseEntity.ok(pp2list);
	} 
	
	@GetMapping("/plastic_pots/load/by_price")
	public ResponseEntity<List<PLASTIC_POTS>> getLoadedPotPlanters2(@RequestParam int offset,@RequestParam int limit, @RequestParam double from, @RequestParam double to){
		List<PLASTIC_POTS> pp3list = plpservice.getAllPotPlanterLoadedPrice(offset, limit, from, to);
		return ResponseEntity.ok(pp3list);
	}
	
	@GetMapping("/plastic_pots/load/by_rating_by_price")
	public ResponseEntity<List<PLASTIC_POTS>> getLoadedPotPlanters3(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam double from, @RequestParam double to){
		List<PLASTIC_POTS> pp4list = plpservice.getAllPotPlanterLoadedRatingPrice(offset, limit,rating, from, to);
		return ResponseEntity.ok(pp4list);
	}
	
	@GetMapping("/plastic_pots/load/by_rating_by_stock")
	public ResponseEntity<List<PLASTIC_POTS>> getLoadedPotPlanters4(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam int stock) {
		List<PLASTIC_POTS> pp5list = plpservice.getAllPotPlanterLoadedRatingStock(offset,limit,rating,stock);
		return ResponseEntity.ok(pp5list);
	}
	
	
	@GetMapping("/plastic_pots/load/by_price_by_stock")
	public ResponseEntity<List<PLASTIC_POTS>> getLoadedPotPlanters5(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock) {
		List<PLASTIC_POTS> pp6list = plpservice.getAllPotPlanterLoadedPriceStock(offset,limit,from,to,stock);
		return ResponseEntity.ok(pp6list);
	}
	
	
	@GetMapping("/plastic_pots/load/by_price_by_stock_by_rating")
	public ResponseEntity<List<PLASTIC_POTS>> getLoadedPotPlanters6(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock, @RequestParam double rating) {
		List<PLASTIC_POTS> pp7list = plpservice.getAllPotPlanterLoadedPriceStockRating(offset,limit,from,to,stock,rating);
		return ResponseEntity.ok(pp7list);
	}
	
	@GetMapping("/plastic_pots/load/by_rating_by_price_SORTBYTITLE_A-Z")
	public ResponseEntity<List<PLASTIC_POTS>> getLoadedPotPlanters7(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam double from, @RequestParam double to){
		List<PLASTIC_POTS> pp8list = plpservice.getAllPotPlanterLoadedRatingPriceSORTTITLE_A_Z(offset, limit,rating, from, to);
		return ResponseEntity.ok(pp8list);
	}
	
	@GetMapping("/plastic_pots/load/by_rating_by_price_SORTBYTITLE_Z-A")
	public ResponseEntity<List<PLASTIC_POTS>> getLoadedPotPlanters8(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam double from, @RequestParam double to){
		List<PLASTIC_POTS> pp9list = plpservice.getAllPotPlanterLoadedRatingPriceSORTTITLE_Z_A(offset, limit,rating, from, to);
		return ResponseEntity.ok(pp9list);
	}
	
	@GetMapping("/plastic_pots/load/by_rating_by_price_SORTBYPRICE_L_TO_H")
	public ResponseEntity<List<PLASTIC_POTS>> getLoadedPotPlanters9(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam double from, @RequestParam double to){
		List<PLASTIC_POTS> pp10list = plpservice.getAllPotPlanterLoadedRatingPriceSORTBYPRICE_L_TO_H(offset, limit,rating, from, to);
		return ResponseEntity.ok(pp10list);
	}
	
	@GetMapping("/plastic_pots/load/by_rating_by_price_SORTBYPRICE_H_TO_L")
	public ResponseEntity<List<PLASTIC_POTS>> getLoadedPotPlanters10(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam double from, @RequestParam double to){
		List<PLASTIC_POTS> pp11list = plpservice.getAllPotPlanterLoadedRatingPriceSORTBYPRICE_H_TO_L(offset, limit,rating, from, to);
		return ResponseEntity.ok(pp11list);
	}
	
	@GetMapping("/plastic_pots/load/by_rating_by_stock_SORTBYTITLE_A-Z")
	public ResponseEntity<List<PLASTIC_POTS>> getLoadedPotPlanters11(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam int stock) {
		List<PLASTIC_POTS> pp12list = plpservice.getAllPotPlanterLoadedRatingStockSORTTITLE_A_Z(offset,limit,rating,stock);
		return ResponseEntity.ok(pp12list);
	}
	
	@GetMapping("/plastic_pots/load/by_rating_by_stock_SORTBYTITLE_Z-A")
	public ResponseEntity<List<PLASTIC_POTS>> getLoadedPotPlanters12(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam int stock) {
		List<PLASTIC_POTS> pp13list = plpservice.getAllPotPlanterLoadedRatingStockSORTTITLE_Z_A(offset,limit,rating,stock);
		return ResponseEntity.ok(pp13list);
	}
	
	
	@GetMapping("/plastic_pots/load/by_rating_by_stock_SORTBYPRICE_L_TO_H")
	public ResponseEntity<List<PLASTIC_POTS>> getLoadedPotPlanters13(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam int stock) {
		List<PLASTIC_POTS> pp14list = plpservice.getAllPotPlanterLoadedRatingStockSORTBYPRICE_L_TO_H(offset,limit,rating,stock);
		return ResponseEntity.ok(pp14list);
	}
	
	@GetMapping("/plastic_pots/load/by_rating_by_stock_SORTBYPRICE_H_TO_L")
	public ResponseEntity<List<PLASTIC_POTS>> getLoadedPotPlanters14(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam int stock) {
		List<PLASTIC_POTS> pp15list = plpservice.getAllPotPlanterLoadedRatingStockSORTBYPRICE_H_TO_L(offset,limit,rating,stock);
		return ResponseEntity.ok(pp15list);
	}
	
	
	@GetMapping("/plastic_pots/load/by_price_by_stock_SORTBYTITLE_A-Z")
	public ResponseEntity<List<PLASTIC_POTS>> getLoadedPotPlanters15(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock) {
		List<PLASTIC_POTS> pp16list = plpservice.getAllPotPlanterLoadedPriceStockSORTTITLE_A_Z(offset,limit,from,to,stock);
		return ResponseEntity.ok(pp16list);
	}
	
	@GetMapping("/plastic_pots/load/by_price_by_stock_SORTBYTITLE_Z-A")
	public ResponseEntity<List<PLASTIC_POTS>> getLoadedPotPlanters16(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock) {
		List<PLASTIC_POTS> pp17list = plpservice.getAllPotPlanterLoadedPriceStockSORTTITLE_Z_A(offset,limit,from,to,stock);
		return ResponseEntity.ok(pp17list);
	}
	
	@GetMapping("/plastic_pots/load/by_price_by_stock_SORTBYPRICE_L_TO_H")
	public ResponseEntity<List<PLASTIC_POTS>> getLoadedPotPlanters17(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock) {
		List<PLASTIC_POTS> pp18list = plpservice.getAllPotPlanterLoadedPriceStockSORTBYPRICE_L_TO_H(offset,limit,from,to,stock);
		return ResponseEntity.ok(pp18list);
	}
	
	@GetMapping("/plastic_pots/load/by_price_by_stock_SORTBYPRICE_H_TO_L")
	public ResponseEntity<List<PLASTIC_POTS>> getLoadedPotPlanters18(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock) {
		List<PLASTIC_POTS> pp19list = plpservice.getAllPotPlanterLoadedPriceStockSORTBYPRICE_H_TO_L(offset,limit,from,to,stock);
		return ResponseEntity.ok(pp19list);
	}
	
	@GetMapping("/plastic_pots/load/by_price_by_stock_by_rating_SORTBYTITLE_A-Z")
	public ResponseEntity<List<PLASTIC_POTS>> getLoadedPotPlanters19(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock, @RequestParam double rating) {
		List<PLASTIC_POTS> pp20list = plpservice.getAllPotPlanterLoadedPriceStockRatingSORTTITLE_A_Z(offset,limit,from,to,stock,rating);
		return ResponseEntity.ok(pp20list);
	}
	
	@GetMapping("/plastic_pots/load/by_price_by_stock_by_rating_SORTBYTITLE_Z-A")
	public ResponseEntity<List<PLASTIC_POTS>> getLoadedPotPlanters20(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock, @RequestParam double rating) {
		List<PLASTIC_POTS> pp21list = plpservice.getAllPotPlanterLoadedPriceStockRatingSORTTITLE_Z_A(offset,limit,from,to,stock,rating);
		return ResponseEntity.ok(pp21list);
	}
	
	@GetMapping("/plastic_pots/load/by_price_by_stock_by_rating_SORTBYPRICE_L_TO_H")
	public ResponseEntity<List<PLASTIC_POTS>> getLoadedPotPlanters21(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock, @RequestParam double rating) {
		List<PLASTIC_POTS> pp22list = plpservice.getAllPotPlanterLoadedPriceStockRatingSORTBYPRICE_L_TO_H(offset,limit,from,to,stock,rating);
		return ResponseEntity.ok(pp22list);
	}
	
	@GetMapping("/plastic_pots/load/by_price_by_stock_by_rating_SORTBYPRICE_H_TO_L")
	public ResponseEntity<List<PLASTIC_POTS>> getLoadedPotPlanters22(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock, @RequestParam double rating) {
		List<PLASTIC_POTS> pp23list = plpservice.getAllPotPlanterLoadedPriceStockRatingSORTBYPRICE_H_TO_L(offset,limit,from,to,stock,rating);
		return ResponseEntity.ok(pp23list);
	}
	
	@GetMapping("/plastic_pots/load/SORTBYTITLE_A-Z")
	public ResponseEntity<List<PLASTIC_POTS>>  sortA_Z(@RequestParam int offset,@RequestParam int limit) {
		List<PLASTIC_POTS> psort = plpservice.sortA_Z(offset,limit);
		return ResponseEntity.ok(psort);
	}
	
	@GetMapping("/plastic_pots/load/SORTBYTITLE_Z-A")
	public ResponseEntity<List<PLASTIC_POTS>> sortZ_A(@RequestParam int offset,@RequestParam int limit) {
		List<PLASTIC_POTS> psort = plpservice.sortZ_A(offset,limit);
		return ResponseEntity.ok(psort);
	}
	
	@GetMapping("/plastic_pots/Availability")
	public ResponseEntity<List<PLASTIC_POTS>> Availability1(@RequestParam int offset,@RequestParam int limit) {
		List<PLASTIC_POTS> pavailability = plpservice.Availability(offset,limit);
		return ResponseEntity.ok(pavailability);
	}
	
	@GetMapping("/plastic_pots/Availability_SORTBYTITLE_A_Z")
	public ResponseEntity<List<PLASTIC_POTS>> Avail_By_A_Z(@RequestParam int offset,@RequestParam int limit) {
		List<PLASTIC_POTS> pavail_A_Z = plpservice.Availability_A_Z(offset, limit);
		return ResponseEntity.ok(pavail_A_Z);
	}
	
	@GetMapping("/plastic_pots/Availability_SORTBYTITLE_Z_A")
	public ResponseEntity<List<PLASTIC_POTS>> Avail_By_Z_A(@RequestParam int offset,@RequestParam int limit) {
		List<PLASTIC_POTS> pavail_Z_A = plpservice.Availability_Z_A(offset, limit);
		return ResponseEntity.ok(pavail_Z_A);
	}
	
	@GetMapping("/plastic_pots/Availability_SORTBYPRICE_Low_to_High")
	public ResponseEntity<List<PLASTIC_POTS>> SortByPriceLH1(@RequestParam int offset,@RequestParam int limit){
		List<PLASTIC_POTS> list = plpservice.getPlantByPriceLH(offset,limit);
	         if(list!=null)
	        	 return ResponseEntity.ok(list);
	         else 
	        	 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping("/plastic_pots/Availability_SORTBYPRICE_High_to_Low")
	public ResponseEntity<List<PLASTIC_POTS>> SortByPriceHL1(@RequestParam int offset,@RequestParam int limit){
		List<PLASTIC_POTS> list = plpservice.getPlantByPriceHL(offset,limit);
	         if(list!=null)
	        	 return ResponseEntity.ok(list);
	         else 
	        	 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping("/plastic_pots/SORTBYPRICE_Low_TO_High")
	public ResponseEntity<List<PLASTIC_POTS>> SORTBYPRICE_L_H(@RequestParam int offset,@RequestParam int limit) {
		List<PLASTIC_POTS> slh = plpservice.SORTBYPRICE_L_H(offset, limit);
		return ResponseEntity.ok(slh);
	}
	
	@GetMapping("/plastic_pots/SORTBYPRICE_High_TO_Low")
	public ResponseEntity<List<PLASTIC_POTS>> SORTBYPRICE_H_L(@RequestParam int offset,@RequestParam int limit) {
		List<PLASTIC_POTS> shl = plpservice.SORTBYPRICE_H_L(offset, limit);
		return ResponseEntity.ok(shl);
	}
	
	
	@GetMapping("/plastic_pots/load/by_price_High_to_Low")
	public ResponseEntity<List<PLASTIC_POTS>> getLoadedPlantsFilterSortPHL1(@RequestParam int offset,@RequestParam int limit,@RequestParam double from,@RequestParam double to){
		List<PLASTIC_POTS> list = plpservice.getLoadedPlantsFilterSortPHL1(offset,limit,from,to);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/plastic_pots/load/by_price_Low_to_High")
	public ResponseEntity<List<PLASTIC_POTS>> getLoadedPlantsFilterSortPLH1(@RequestParam int offset,@RequestParam int limit,@RequestParam double from,@RequestParam double to){
		List<PLASTIC_POTS> list = plpservice.getLoadedPlantsFilterSortPLH1(offset,limit,from,to);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/plastic_pots/load/by_price_A_to_Z")
	public ResponseEntity<List<PLASTIC_POTS>> getLoadedPlantsFilterSortAZ1(@RequestParam int offset, @RequestParam int limit, @RequestParam double from,@RequestParam double to ){
		List<PLASTIC_POTS> list =plpservice.getLoadedPlantsFilterSortAZ1(offset,limit,from,to);
		return ResponseEntity.ok(list);
	}
	@GetMapping("/plastic_pots/load/by_price_Z_to_A")
	public ResponseEntity<List<PLASTIC_POTS>> getLoadedPlantsFilterSortZA1(@RequestParam int offset, @RequestParam int limit, @RequestParam double from,@RequestParam double to ){
		List<PLASTIC_POTS> list =plpservice.getLoadedPlantsFilterSortZA1(offset,limit,from,to);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/plastic_pots/load/by_rating_SORTBYPRICE_High_to_Low")
	public ResponseEntity<List<PLASTIC_POTS>> getLoadedPlantsFilterSortRHL2(@RequestParam int offset,@RequestParam int limit,@RequestParam double rating){
		List<PLASTIC_POTS> list = plpservice.getLoadedPlantsFilterSortRHL2(offset,limit,rating);
		return ResponseEntity.ok(list);
	}
	@GetMapping("/plastic_pots/load/by_rating_SORTBYPRICE_Low_to_High")
	public ResponseEntity<List<PLASTIC_POTS>> getLoadedPlantsFilterSortRLH2(@RequestParam int offset,@RequestParam int limit,@RequestParam double rating){
		List<PLASTIC_POTS> list = plpservice.getLoadedPlantsFilterSortRLH2(offset,limit,rating);
		return ResponseEntity.ok(list);
	}
	@GetMapping("/plastic_pots/load/by_rating_A_to_Z")
	public ResponseEntity<List<PLASTIC_POTS>> getLoadedPlantsFilterSortRAZ2(@RequestParam int offset,@RequestParam int limit,@RequestParam double rating){
		List<PLASTIC_POTS> list = plpservice.getLoadedPlantsFilterSortRAZ2(offset,limit,rating);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/plastic_pots/load/by_rating_Z_to_A")
	public ResponseEntity<List<PLASTIC_POTS>> getLoadedPlantsFilterSortRZA2(@RequestParam int offset,@RequestParam int limit,@RequestParam double rating){
		List<PLASTIC_POTS> list = plpservice.getLoadedPlantsFilterSortRZA2(offset,limit,rating);
		return ResponseEntity.ok(list);
	}
		
}
	
	

