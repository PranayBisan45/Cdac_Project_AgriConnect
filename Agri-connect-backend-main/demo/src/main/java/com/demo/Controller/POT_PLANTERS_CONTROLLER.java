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

import com.demo.Model.POT_PLANTERS;
import com.demo.Service.POT_PLANTERS_SERVICE;

@RestController
public class POT_PLANTERS_CONTROLLER {
	
	@Autowired
	POT_PLANTERS_SERVICE ppservice;
	
	@GetMapping(value="/pot_planters")
	public ResponseEntity<List<POT_PLANTERS>> getAllPotPlanters(){
		List<POT_PLANTERS> pplist = ppservice.getAllPotPlanter();
		return ResponseEntity.ok(pplist);
		
	}
	
	@GetMapping("/pot_planters/{ppid}")
	public ResponseEntity<POT_PLANTERS> getById(@PathVariable String ppid){
		POT_PLANTERS p=ppservice.getById(ppid);
		if (p!=null)
			return ResponseEntity.ok(p);
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
		
	
	@GetMapping("/pot_planters/load")
	public ResponseEntity<List<POT_PLANTERS>> getLoadedPotPlanters(@RequestParam int offset,@RequestParam int limit) {
		List<POT_PLANTERS> pp1list = ppservice.getAllPotPlanterLoaded(offset,limit);
		return ResponseEntity.ok(pp1list);
	}
	
	@GetMapping("/pot_planters/load/by_rating")
	public ResponseEntity<List<POT_PLANTERS>> getLoadedPotPlanters1(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating) {
		List<POT_PLANTERS> pp2list = ppservice.getAllPotPlanterLoadedRating(offset, limit, rating);
		return ResponseEntity.ok(pp2list);
	} 
	
	@GetMapping("/pot_planters/load/by_price")
	public ResponseEntity<List<POT_PLANTERS>> getLoadedPotPlanters2(@RequestParam int offset,@RequestParam int limit, @RequestParam double from, @RequestParam double to){
		List<POT_PLANTERS> pp3list = ppservice.getAllPotPlanterLoadedPrice(offset, limit, from, to);
		return ResponseEntity.ok(pp3list);
	}
	
	@GetMapping("/pot_planters/load/by_rating_by_price")
	public ResponseEntity<List<POT_PLANTERS>> getLoadedPotPlanters3(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam double from, @RequestParam double to){
		List<POT_PLANTERS> pp4list = ppservice.getAllPotPlanterLoadedRatingPrice(offset, limit,rating, from, to);
		return ResponseEntity.ok(pp4list);
	}
	
	@GetMapping("/pot_planters/load/by_rating_by_stock")
	public ResponseEntity<List<POT_PLANTERS>> getLoadedPotPlanters4(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam int stock) {
		List<POT_PLANTERS> pp5list = ppservice.getAllPotPlanterLoadedRatingStock(offset,limit,rating,stock);
		return ResponseEntity.ok(pp5list);
	}
	
	
	@GetMapping("/pot_planters/load/by_price_by_stock")
	public ResponseEntity<List<POT_PLANTERS>> getLoadedPotPlanters5(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock) {
		List<POT_PLANTERS> pp6list = ppservice.getAllPotPlanterLoadedPriceStock(offset,limit,from,to,stock);
		return ResponseEntity.ok(pp6list);
	}
	
	
	@GetMapping("/pot_planters/load/by_price_by_stock_by_rating")
	public ResponseEntity<List<POT_PLANTERS>> getLoadedPotPlanters6(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock, @RequestParam double rating) {
		List<POT_PLANTERS> pp7list = ppservice.getAllPotPlanterLoadedPriceStockRating(offset,limit,from,to,stock,rating);
		return ResponseEntity.ok(pp7list);
	}
	
	@GetMapping("/pot_planters/load/by_rating_by_price_SORTBYTITLE_A-Z")
	public ResponseEntity<List<POT_PLANTERS>> getLoadedPotPlanters7(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam double from, @RequestParam double to){
		List<POT_PLANTERS> pp8list = ppservice.getAllPotPlanterLoadedRatingPriceSORTTITLE_A_Z(offset, limit,rating, from, to);
		return ResponseEntity.ok(pp8list);
	}
	
	@GetMapping("/pot_planters/load/by_rating_by_price_SORTBYTITLE_Z-A")
	public ResponseEntity<List<POT_PLANTERS>> getLoadedPotPlanters8(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam double from, @RequestParam double to){
		List<POT_PLANTERS> pp9list = ppservice.getAllPotPlanterLoadedRatingPriceSORTTITLE_Z_A(offset, limit,rating, from, to);
		return ResponseEntity.ok(pp9list);
	}
	
	@GetMapping("/pot_planters/load/by_rating_by_price_SORTBYPRICE_L_TO_H")
	public ResponseEntity<List<POT_PLANTERS>> getLoadedPotPlanters9(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam double from, @RequestParam double to){
		List<POT_PLANTERS> pp10list = ppservice.getAllPotPlanterLoadedRatingPriceSORTBYPRICE_L_TO_H(offset, limit,rating, from, to);
		return ResponseEntity.ok(pp10list);
	}
	
	@GetMapping("/pot_planters/load/by_rating_by_price_SORTBYPRICE_H_TO_L")
	public ResponseEntity<List<POT_PLANTERS>> getLoadedPotPlanters10(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam double from, @RequestParam double to){
		List<POT_PLANTERS> pp11list = ppservice.getAllPotPlanterLoadedRatingPriceSORTBYPRICE_H_TO_L(offset, limit,rating, from, to);
		return ResponseEntity.ok(pp11list);
	}
	
	@GetMapping("/pot_planters/load/by_rating_by_stock_SORTBYTITLE_A-Z")
	public ResponseEntity<List<POT_PLANTERS>> getLoadedPotPlanters11(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam int stock) {
		List<POT_PLANTERS> pp12list = ppservice.getAllPotPlanterLoadedRatingStockSORTTITLE_A_Z(offset,limit,rating,stock);
		return ResponseEntity.ok(pp12list);
	}
	
	@GetMapping("/pot_planters/load/by_rating_by_stock_SORTBYTITLE_Z-A")
	public ResponseEntity<List<POT_PLANTERS>> getLoadedPotPlanters12(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam int stock) {
		List<POT_PLANTERS> pp13list = ppservice.getAllPotPlanterLoadedRatingStockSORTTITLE_Z_A(offset,limit,rating,stock);
		return ResponseEntity.ok(pp13list);
	}
	
	
	@GetMapping("/pot_planters/load/by_rating_by_stock_SORTBYPRICE_L_TO_H")
	public ResponseEntity<List<POT_PLANTERS>> getLoadedPotPlanters13(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam int stock) {
		List<POT_PLANTERS> pp14list = ppservice.getAllPotPlanterLoadedRatingStockSORTBYPRICE_L_TO_H(offset,limit,rating,stock);
		return ResponseEntity.ok(pp14list);
	}
	
	@GetMapping("/pot_planters/load/by_rating_by_stock_SORTBYPRICE_H_TO_L")
	public ResponseEntity<List<POT_PLANTERS>> getLoadedPotPlanters14(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam int stock) {
		List<POT_PLANTERS> pp15list = ppservice.getAllPotPlanterLoadedRatingStockSORTBYPRICE_H_TO_L(offset,limit,rating,stock);
		return ResponseEntity.ok(pp15list);
	}
	
	
	@GetMapping("/pot_planters/load/by_price_by_stock_SORTBYTITLE_A-Z")
	public ResponseEntity<List<POT_PLANTERS>> getLoadedPotPlanters15(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock) {
		List<POT_PLANTERS> pp16list = ppservice.getAllPotPlanterLoadedPriceStockSORTTITLE_A_Z(offset,limit,from,to,stock);
		return ResponseEntity.ok(pp16list);
	}
	
	@GetMapping("/pot_planters/load/by_price_by_stock_SORTBYTITLE_Z-A")
	public ResponseEntity<List<POT_PLANTERS>> getLoadedPotPlanters16(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock) {
		List<POT_PLANTERS> pp17list = ppservice.getAllPotPlanterLoadedPriceStockSORTTITLE_Z_A(offset,limit,from,to,stock);
		return ResponseEntity.ok(pp17list);
	}
	
	@GetMapping("/pot_planters/load/by_price_by_stock_SORTBYPRICE_L_TO_H")
	public ResponseEntity<List<POT_PLANTERS>> getLoadedPotPlanters17(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock) {
		List<POT_PLANTERS> pp18list = ppservice.getAllPotPlanterLoadedPriceStockSORTBYPRICE_L_TO_H(offset,limit,from,to,stock);
		return ResponseEntity.ok(pp18list);
	}
	
	@GetMapping("/pot_planters/load/by_price_by_stock_SORTBYPRICE_H_TO_L")
	public ResponseEntity<List<POT_PLANTERS>> getLoadedPotPlanters18(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock) {
		List<POT_PLANTERS> pp19list = ppservice.getAllPotPlanterLoadedPriceStockSORTBYPRICE_H_TO_L(offset,limit,from,to,stock);
		return ResponseEntity.ok(pp19list);
	}
	
	@GetMapping("/pot_planters/load/by_price_by_stock_by_rating_SORTBYTITLE_A-Z")
	public ResponseEntity<List<POT_PLANTERS>> getLoadedPotPlanters19(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock, @RequestParam double rating) {
		List<POT_PLANTERS> pp20list = ppservice.getAllPotPlanterLoadedPriceStockRatingSORTTITLE_A_Z(offset,limit,from,to,stock,rating);
		return ResponseEntity.ok(pp20list);
	}
	
	@GetMapping("/pot_planters/load/by_price_by_stock_by_rating_SORTBYTITLE_Z-A")
	public ResponseEntity<List<POT_PLANTERS>> getLoadedPotPlanters20(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock, @RequestParam double rating) {
		List<POT_PLANTERS> pp21list = ppservice.getAllPotPlanterLoadedPriceStockRatingSORTTITLE_Z_A(offset,limit,from,to,stock,rating);
		return ResponseEntity.ok(pp21list);
	}
	
	@GetMapping("/pot_planters/load/by_price_by_stock_by_rating_SORTBYPRICE_L_TO_H")
	public ResponseEntity<List<POT_PLANTERS>> getLoadedPotPlanters21(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock, @RequestParam double rating) {
		List<POT_PLANTERS> pp22list = ppservice.getAllPotPlanterLoadedPriceStockRatingSORTBYPRICE_L_TO_H(offset,limit,from,to,stock,rating);
		return ResponseEntity.ok(pp22list);
	}
	
	@GetMapping("/pot_planters/load/by_price_by_stock_by_rating_SORTBYPRICE_H_TO_L")
	public ResponseEntity<List<POT_PLANTERS>> getLoadedPotPlanters22(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock, @RequestParam double rating) {
		List<POT_PLANTERS> pp23list = ppservice.getAllPotPlanterLoadedPriceStockRatingSORTBYPRICE_H_TO_L(offset,limit,from,to,stock,rating);
		return ResponseEntity.ok(pp23list);
	}
	
	@GetMapping("/pot_planters/load/SORTBYTITLE_A-Z")
	public ResponseEntity<List<POT_PLANTERS>>  sortA_Z(@RequestParam int offset,@RequestParam int limit) {
		List<POT_PLANTERS> psort = ppservice.sortA_Z(offset,limit);
		return ResponseEntity.ok(psort);
	}
	
	@GetMapping("/pot_planters/load/SORTBYTITLE_Z-A")
	public ResponseEntity<List<POT_PLANTERS>> sortZ_A(@RequestParam int offset,@RequestParam int limit) {
		List<POT_PLANTERS> psort = ppservice.sortZ_A(offset,limit);
		return ResponseEntity.ok(psort);
	}
	
	@GetMapping("/pot_planters/Availability")
	public ResponseEntity<List<POT_PLANTERS>> Availability1(@RequestParam int offset,@RequestParam int limit) {
		List<POT_PLANTERS> pavailability = ppservice.Availability(offset,limit);
		return ResponseEntity.ok(pavailability);
	}
	
	@GetMapping("/pot_planters/Availability_SORTBYTITLE_A_Z")
	public ResponseEntity<List<POT_PLANTERS>> Avail_By_A_Z(@RequestParam int offset,@RequestParam int limit) {
		List<POT_PLANTERS> pavail_A_Z = ppservice.Availability_A_Z(offset, limit);
		return ResponseEntity.ok(pavail_A_Z);
	}
	
	@GetMapping("/pot_planters/Availability_SORTBYTITLE_Z_A")
	public ResponseEntity<List<POT_PLANTERS>> Avail_By_Z_A(@RequestParam int offset,@RequestParam int limit) {
		List<POT_PLANTERS> pavail_Z_A = ppservice.Availability_Z_A(offset, limit);
		return ResponseEntity.ok(pavail_Z_A);
	}
	
	@GetMapping("/pot_planters/Availability_SORTBYPRICE_Low_to_High")
	public ResponseEntity<List<POT_PLANTERS>> SortByPriceLH1(@RequestParam int offset,@RequestParam int limit){
		List<POT_PLANTERS> list = ppservice.getPlantByPriceLH(offset,limit);
	         if(list!=null)
	        	 return ResponseEntity.ok(list);
	         else 
	        	 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping("/pot_planters/Availability_SORTBYPRICE_High_to_Low")
	public ResponseEntity<List<POT_PLANTERS>> SortByPriceHL1(@RequestParam int offset,@RequestParam int limit){
		List<POT_PLANTERS> list = ppservice.getPlantByPriceHL(offset,limit);
	         if(list!=null)
	        	 return ResponseEntity.ok(list);
	         else 
	        	 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping("/pot_planters/SORTBYPRICE_Low_TO_High")
	public ResponseEntity<List<POT_PLANTERS>> SORTBYPRICE_L_H(@RequestParam int offset,@RequestParam int limit) {
		List<POT_PLANTERS> slh = ppservice.SORTBYPRICE_L_H(offset, limit);
		return ResponseEntity.ok(slh);
	}
	
	@GetMapping("/pot_planters/SORTBYPRICE_High_TO_Low")
	public ResponseEntity<List<POT_PLANTERS>> SORTBYPRICE_H_L(@RequestParam int offset,@RequestParam int limit) {
		List<POT_PLANTERS> shl = ppservice.SORTBYPRICE_H_L(offset, limit);
		return ResponseEntity.ok(shl);
	}
	
	
	@GetMapping("/pot_planters/load/by_price_High_to_Low")
	public ResponseEntity<List<POT_PLANTERS>> getLoadedPlantsFilterSortPHL1(@RequestParam int offset,@RequestParam int limit,@RequestParam double from,@RequestParam double to){
		List<POT_PLANTERS> list = ppservice.getLoadedPlantsFilterSortPHL1(offset,limit,from,to);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/pot_planters/load/by_price_Low_to_High")
	public ResponseEntity<List<POT_PLANTERS>> getLoadedPlantsFilterSortPLH1(@RequestParam int offset,@RequestParam int limit,@RequestParam double from,@RequestParam double to){
		List<POT_PLANTERS> list = ppservice.getLoadedPlantsFilterSortPLH1(offset,limit,from,to);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/pot_planters/load/by_price_A_to_Z")
	public ResponseEntity<List<POT_PLANTERS>> getLoadedPlantsFilterSortAZ1(@RequestParam int offset, @RequestParam int limit, @RequestParam double from,@RequestParam double to ){
		List<POT_PLANTERS> list =ppservice.getLoadedPlantsFilterSortAZ1(offset,limit,from,to);
		return ResponseEntity.ok(list);
	}
	@GetMapping("/pot_planters/load/by_price_Z_to_A")
	public ResponseEntity<List<POT_PLANTERS>> getLoadedPlantsFilterSortZA1(@RequestParam int offset, @RequestParam int limit, @RequestParam double from,@RequestParam double to ){
		List<POT_PLANTERS> list =ppservice.getLoadedPlantsFilterSortZA1(offset,limit,from,to);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/pot_planters/load/by_rating_SORTBYPRICE_High_to_Low")
	public ResponseEntity<List<POT_PLANTERS>> getLoadedPlantsFilterSortRHL2(@RequestParam int offset,@RequestParam int limit,@RequestParam double rating){
		List<POT_PLANTERS> list = ppservice.getLoadedPlantsFilterSortRHL2(offset,limit,rating);
		return ResponseEntity.ok(list);
	}
	@GetMapping("/pot_planters/load/by_rating_SORTBYPRICE_Low_to_High")
	public ResponseEntity<List<POT_PLANTERS>> getLoadedPlantsFilterSortRLH2(@RequestParam int offset,@RequestParam int limit,@RequestParam double rating){
		List<POT_PLANTERS> list = ppservice.getLoadedPlantsFilterSortRLH2(offset,limit,rating);
		return ResponseEntity.ok(list);
	}
	@GetMapping("/pot_planters/load/by_rating_A_to_Z")
	public ResponseEntity<List<POT_PLANTERS>> getLoadedPlantsFilterSortRAZ2(@RequestParam int offset,@RequestParam int limit,@RequestParam double rating){
		List<POT_PLANTERS> list = ppservice.getLoadedPlantsFilterSortRAZ2(offset,limit,rating);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/pot_planters/load/by_rating_Z_to_A")
	public ResponseEntity<List<POT_PLANTERS>> getLoadedPlantsFilterSortRZA2(@RequestParam int offset,@RequestParam int limit,@RequestParam double rating){
		List<POT_PLANTERS> list = ppservice.getLoadedPlantsFilterSortRZA2(offset,limit,rating);
		return ResponseEntity.ok(list);
	}
		
}
	
	

