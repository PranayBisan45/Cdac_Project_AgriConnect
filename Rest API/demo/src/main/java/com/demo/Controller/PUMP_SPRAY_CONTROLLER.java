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

import com.demo.Model.PUMP_SPRAY;
import com.demo.Service.PUMP_SPRAY_SERVICE;

@RestController
@CrossOrigin(value="*")
public class PUMP_SPRAY_CONTROLLER {

	@Autowired
	PUMP_SPRAY_SERVICE psservice;
	
	@GetMapping(value="/pump_spray")
	public ResponseEntity<List<PUMP_SPRAY>> getAllArtificialPlanters(){
		List<PUMP_SPRAY> aplist = psservice.getAllArtificialPlant();
		return ResponseEntity.ok(aplist);
		
	}
	
	@GetMapping("/pump_spray/{apid}")
	public ResponseEntity<PUMP_SPRAY> getById(@PathVariable String apid){
		PUMP_SPRAY a=psservice.getById1(apid);
		if (a!=null)
			return ResponseEntity.ok(a);
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
		
	
	@GetMapping("/pump_spray/load")
	public ResponseEntity<List<PUMP_SPRAY>> getLoadedPotPlanters(@RequestParam int offset,@RequestParam int limit) {
		List<PUMP_SPRAY> pp1list = psservice.getAllPotPlanterLoaded(offset,limit);
		return ResponseEntity.ok(pp1list);
	}
	
	@GetMapping("/pump_spray/load/by_rating")
	public ResponseEntity<List<PUMP_SPRAY>> getLoadedPotPlanters1(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating) {
		List<PUMP_SPRAY> pp2list = psservice.getAllPotPlanterLoadedRating(offset, limit, rating);
		return ResponseEntity.ok(pp2list);
	}
	
	
	@GetMapping("/pump_spray/load/by_price")
	public ResponseEntity<List<PUMP_SPRAY>> getLoadedPotPlanters2(@RequestParam int offset,@RequestParam int limit, @RequestParam double from, @RequestParam double to){
		List<PUMP_SPRAY> pp3list = psservice.getAllPotPlanterLoadedPrice(offset, limit, from, to);
		return ResponseEntity.ok(pp3list);
	}
	
	@GetMapping("/pump_spray/load/by_rating_by_price")
	public ResponseEntity<List<PUMP_SPRAY>> getLoadedPotPlanters3(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam double from, @RequestParam double to){
		List<PUMP_SPRAY> pp4list = psservice.getAllPotPlanterLoadedRatingPrice(offset, limit,rating, from, to);
		return ResponseEntity.ok(pp4list);
	}
	
	@GetMapping("/pump_spray/load/by_rating_by_stock")
	public ResponseEntity<List<PUMP_SPRAY>> getLoadedPotPlanters4(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam int stock) {
		List<PUMP_SPRAY> pp5list = psservice.getAllPotPlanterLoadedRatingStock(offset,limit,rating,stock);
		return ResponseEntity.ok(pp5list);
	}
	
	
	@GetMapping("/pump_spray/load/by_price_by_stock")
	public ResponseEntity<List<PUMP_SPRAY>> getLoadedPotPlanters5(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock) {
		List<PUMP_SPRAY> pp6list = psservice.getAllPotPlanterLoadedPriceStock(offset,limit,from,to,stock);
		return ResponseEntity.ok(pp6list);
	}
	
	
	@GetMapping("/pump_spray/load/by_price_by_stock_by_rating")
	public ResponseEntity<List<PUMP_SPRAY>> getLoadedPotPlanters6(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock, @RequestParam double rating) {
		List<PUMP_SPRAY> pp7list = psservice.getAllPotPlanterLoadedPriceStockRating(offset,limit,from,to,stock,rating);
		return ResponseEntity.ok(pp7list);
	}
	
	@GetMapping("/pump_spray/load/by_rating_by_price_SORTBYTITLE_A-Z")
	public ResponseEntity<List<PUMP_SPRAY>> getLoadedPotPlanters7(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam double from, @RequestParam double to){
		List<PUMP_SPRAY> pp8list = psservice.getAllPotPlanterLoadedRatingPriceSORTTITLE_A_Z(offset, limit,rating, from, to);
		return ResponseEntity.ok(pp8list);
	}
	
	@GetMapping("/pump_spray/load/by_rating_by_price_SORTBYTITLE_Z-A")
	public ResponseEntity<List<PUMP_SPRAY>> getLoadedPotPlanters8(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam double from, @RequestParam double to){
		List<PUMP_SPRAY> pp9list = psservice.getAllPotPlanterLoadedRatingPriceSORTTITLE_Z_A(offset, limit,rating, from, to);
		return ResponseEntity.ok(pp9list);
	}
	
	@GetMapping("/pump_spray/load/by_rating_by_price_SORTBYPRICE_L_TO_H")
	public ResponseEntity<List<PUMP_SPRAY>> getLoadedPotPlanters9(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam double from, @RequestParam double to){
		List<PUMP_SPRAY> pp10list = psservice.getAllPotPlanterLoadedRatingPriceSORTBYPRICE_L_TO_H(offset, limit,rating, from, to);
		return ResponseEntity.ok(pp10list);
	}
	
	@GetMapping("/pump_spray/load/by_rating_by_price_SORTBYPRICE_H_TO_L")
	public ResponseEntity<List<PUMP_SPRAY>> getLoadedPotPlanters10(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam double from, @RequestParam double to){
		List<PUMP_SPRAY> pp11list = psservice.getAllPotPlanterLoadedRatingPriceSORTBYPRICE_H_TO_L(offset, limit,rating, from, to);
		return ResponseEntity.ok(pp11list);
	}
	
	@GetMapping("/pump_spray/load/by_rating_by_stock_SORTBYTITLE_A-Z")
	public ResponseEntity<List<PUMP_SPRAY>> getLoadedPotPlanters11(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam int stock) {
		List<PUMP_SPRAY> pp12list = psservice.getAllPotPlanterLoadedRatingStockSORTTITLE_A_Z(offset,limit,rating,stock);
		return ResponseEntity.ok(pp12list);
	}
	
	@GetMapping("/pump_spray/load/by_rating_by_stock_SORTBYTITLE_Z-A")
	public ResponseEntity<List<PUMP_SPRAY>> getLoadedPotPlanters12(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam int stock) {
		List<PUMP_SPRAY> pp13list = psservice.getAllPotPlanterLoadedRatingStockSORTTITLE_Z_A(offset,limit,rating,stock);
		return ResponseEntity.ok(pp13list);
	}
	
	
	@GetMapping("/pump_spray/load/by_rating_by_stock_SORTBYPRICE_L_TO_H")
	public ResponseEntity<List<PUMP_SPRAY>> getLoadedPotPlanters13(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam int stock) {
		List<PUMP_SPRAY> pp14list = psservice.getAllPotPlanterLoadedRatingStockSORTBYPRICE_L_TO_H(offset,limit,rating,stock);
		return ResponseEntity.ok(pp14list);
	}
	
	@GetMapping("/pump_spray/load/by_rating_by_stock_SORTBYPRICE_H_TO_L")
	public ResponseEntity<List<PUMP_SPRAY>> getLoadedPotPlanters14(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam int stock) {
		List<PUMP_SPRAY> pp15list = psservice.getAllPotPlanterLoadedRatingStockSORTBYPRICE_H_TO_L(offset,limit,rating,stock);
		return ResponseEntity.ok(pp15list);
	}
	
	
	@GetMapping("/pump_spray/load/by_price_by_stock_SORTBYTITLE_A-Z")
	public ResponseEntity<List<PUMP_SPRAY>> getLoadedPotPlanters15(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock) {
		List<PUMP_SPRAY> pp16list = psservice.getAllPotPlanterLoadedPriceStockSORTTITLE_A_Z(offset,limit,from,to,stock);
		return ResponseEntity.ok(pp16list);
	}
	
	@GetMapping("/pump_spray/load/by_price_by_stock_SORTBYTITLE_Z-A")
	public ResponseEntity<List<PUMP_SPRAY>> getLoadedPotPlanters16(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock) {
		List<PUMP_SPRAY> pp17list = psservice.getAllPotPlanterLoadedPriceStockSORTTITLE_Z_A(offset,limit,from,to,stock);
		return ResponseEntity.ok(pp17list);
	}
	
	@GetMapping("/pump_spray/load/by_price_by_stock_SORTBYPRICE_L_TO_H")
	public ResponseEntity<List<PUMP_SPRAY>> getLoadedPotPlanters17(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock) {
		List<PUMP_SPRAY> pp18list = psservice.getAllPotPlanterLoadedPriceStockSORTBYPRICE_L_TO_H(offset,limit,from,to,stock);
		return ResponseEntity.ok(pp18list);
	}
	
	@GetMapping("/pump_spray/load/by_price_by_stock_SORTBYPRICE_H_TO_L")
	public ResponseEntity<List<PUMP_SPRAY>> getLoadedPotPlanters18(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock) {
		List<PUMP_SPRAY> pp19list = psservice.getAllPotPlanterLoadedPriceStockSORTBYPRICE_H_TO_L(offset,limit,from,to,stock);
		return ResponseEntity.ok(pp19list);
	}
	
	@GetMapping("/pump_spray/load/by_price_by_stock_by_rating_SORTBYTITLE_A-Z")
	public ResponseEntity<List<PUMP_SPRAY>> getLoadedPotPlanters19(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock, @RequestParam double rating) {
		List<PUMP_SPRAY> pp20list = psservice.getAllPotPlanterLoadedPriceStockRatingSORTTITLE_A_Z(offset,limit,from,to,stock,rating);
		return ResponseEntity.ok(pp20list);
	}
	
	@GetMapping("/pump_spray/load/by_price_by_stock_by_rating_SORTBYTITLE_Z-A")
	public ResponseEntity<List<PUMP_SPRAY>> getLoadedPotPlanters20(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock, @RequestParam double rating) {
		List<PUMP_SPRAY> pp21list = psservice.getAllPotPlanterLoadedPriceStockRatingSORTTITLE_Z_A(offset,limit,from,to,stock,rating);
		return ResponseEntity.ok(pp21list);
	}
	
	@GetMapping("/pump_spray/load/by_price_by_stock_by_rating_SORTBYPRICE_L_TO_H")
	public ResponseEntity<List<PUMP_SPRAY>> getLoadedPotPlanters21(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock, @RequestParam double rating) {
		List<PUMP_SPRAY> pp22list = psservice.getAllPotPlanterLoadedPriceStockRatingSORTBYPRICE_L_TO_H(offset,limit,from,to,stock,rating);
		return ResponseEntity.ok(pp22list);
	}
	
	@GetMapping("/pump_spray/load/by_price_by_stock_by_rating_SORTBYPRICE_H_TO_L")
	public ResponseEntity<List<PUMP_SPRAY>> getLoadedPotPlanters22(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock, @RequestParam double rating) {
		List<PUMP_SPRAY> pp23list = psservice.getAllPotPlanterLoadedPriceStockRatingSORTBYPRICE_H_TO_L(offset,limit,from,to,stock,rating);
		return ResponseEntity.ok(pp23list);
	}
	
	@GetMapping("/pump_spray/load/SORTBYTITLE_A-Z")
	public ResponseEntity<List<PUMP_SPRAY>>  sortA_Z(@RequestParam int offset,@RequestParam int limit) {
		List<PUMP_SPRAY> psort = psservice.sortA_Z(offset,limit);
		return ResponseEntity.ok(psort);
	}
	
	@GetMapping("/pump_spray/load/SORTBYTITLE_Z-A")
	public ResponseEntity<List<PUMP_SPRAY>> sortZ_A(@RequestParam int offset,@RequestParam int limit) {
		List<PUMP_SPRAY> psort = psservice.sortZ_A(offset,limit);
		return ResponseEntity.ok(psort);
	}
	
	@GetMapping("/pump_spray/Availability")
	public ResponseEntity<List<PUMP_SPRAY>> Availability1(@RequestParam int offset,@RequestParam int limit) {
		List<PUMP_SPRAY> pavailability = psservice.Availability(offset,limit);
		return ResponseEntity.ok(pavailability);
	}
	
	@GetMapping("/pump_spray/Availability_SORTBYTITLE_A_Z")
	public ResponseEntity<List<PUMP_SPRAY>> Avail_By_A_Z(@RequestParam int offset,@RequestParam int limit) {
		List<PUMP_SPRAY> pavail_A_Z = psservice.Availability_A_Z(offset, limit);
		return ResponseEntity.ok(pavail_A_Z);
	}
	
	@GetMapping("/pump_spray/Availability_SORTBYTITLE_Z_A")
	public ResponseEntity<List<PUMP_SPRAY>> Avail_By_Z_A(@RequestParam int offset,@RequestParam int limit) {
		List<PUMP_SPRAY> pavail_Z_A = psservice.Availability_Z_A(offset, limit);
		return ResponseEntity.ok(pavail_Z_A);
	}
	
	@GetMapping("/pump_spray/Availability_SORTBYPRICE_Low_to_High")
	public ResponseEntity<List<PUMP_SPRAY>> SortByPriceLH1(@RequestParam int offset,@RequestParam int limit){
		List<PUMP_SPRAY> list = psservice.getPlantByPriceLH(offset,limit);
	         if(list!=null)
	        	 return ResponseEntity.ok(list);
	         else 
	        	 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping("/pump_spray/Availability_SORTBYPRICE_High_to_Low")
	public ResponseEntity<List<PUMP_SPRAY>> SortByPriceHL1(@RequestParam int offset,@RequestParam int limit){
		List<PUMP_SPRAY> list = psservice.getPlantByPriceHL(offset,limit);
	         if(list!=null)
	        	 return ResponseEntity.ok(list);
	         else 
	        	 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping("/pump_spray/SORTBYPRICE_Low_TO_High")
	public ResponseEntity<List<PUMP_SPRAY>> SORTBYPRICE_L_H(@RequestParam int offset,@RequestParam int limit) {
		List<PUMP_SPRAY> slh = psservice.SORTBYPRICE_L_H(offset, limit);
		return ResponseEntity.ok(slh);
	}
	
	@GetMapping("/pump_spray/SORTBYPRICE_High_TO_Low")
	public ResponseEntity<List<PUMP_SPRAY>> SORTBYPRICE_H_L(@RequestParam int offset,@RequestParam int limit) {
		List<PUMP_SPRAY> shl = psservice.SORTBYPRICE_H_L(offset, limit);
		return ResponseEntity.ok(shl);
	}
	
	
	@GetMapping("/pump_spray/load/by_price_High_to_Low")
	public ResponseEntity<List<PUMP_SPRAY>> getLoadedPlantsFilterSortPHL1(@RequestParam int offset,@RequestParam int limit,@RequestParam double from,@RequestParam double to){
		List<PUMP_SPRAY> list = psservice.getLoadedPlantsFilterSortPHL1(offset,limit,from,to);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/pump_spray/load/by_price_Low_to_High")
	public ResponseEntity<List<PUMP_SPRAY>> getLoadedPlantsFilterSortPLH1(@RequestParam int offset,@RequestParam int limit,@RequestParam double from,@RequestParam double to){
		List<PUMP_SPRAY> list = psservice.getLoadedPlantsFilterSortPLH1(offset,limit,from,to);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/pump_spray/load/by_price_A_to_Z")
	public ResponseEntity<List<PUMP_SPRAY>> getLoadedPlantsFilterSortAZ1(@RequestParam int offset, @RequestParam int limit, @RequestParam double from,@RequestParam double to ){
		List<PUMP_SPRAY> list =psservice.getLoadedPlantsFilterSortAZ1(offset,limit,from,to);
		return ResponseEntity.ok(list);
	}
	@GetMapping("/pump_spray/load/by_price_Z_to_A")
	public ResponseEntity<List<PUMP_SPRAY>> getLoadedPlantsFilterSortZA1(@RequestParam int offset, @RequestParam int limit, @RequestParam double from,@RequestParam double to ){
		List<PUMP_SPRAY> list =psservice.getLoadedPlantsFilterSortZA1(offset,limit,from,to);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/pump_spray/load/by_rating_SORTBYPRICE_High_to_Low")
	public ResponseEntity<List<PUMP_SPRAY>> getLoadedPlantsFilterSortRHL2(@RequestParam int offset,@RequestParam int limit,@RequestParam double rating){
		List<PUMP_SPRAY> list = psservice.getLoadedPlantsFilterSortRHL2(offset,limit,rating);
		return ResponseEntity.ok(list);
	}
	@GetMapping("/pump_spray/load/by_rating_SORTBYPRICE_Low_to_High")
	public ResponseEntity<List<PUMP_SPRAY>> getLoadedPlantsFilterSortRLH2(@RequestParam int offset,@RequestParam int limit,@RequestParam double rating){
		List<PUMP_SPRAY> list = psservice.getLoadedPlantsFilterSortRLH2(offset,limit,rating);
		return ResponseEntity.ok(list);
	}
	@GetMapping("/pump_spray/load/by_rating_A_to_Z")
	public ResponseEntity<List<PUMP_SPRAY>> getLoadedPlantsFilterSortRAZ2(@RequestParam int offset,@RequestParam int limit,@RequestParam double rating){
		List<PUMP_SPRAY> list = psservice.getLoadedPlantsFilterSortRAZ2(offset,limit,rating);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/pump_spray/load/by_rating_Z_to_A")
	public ResponseEntity<List<PUMP_SPRAY>> getLoadedPlantsFilterSortRZA2(@RequestParam int offset,@RequestParam int limit,@RequestParam double rating){
		List<PUMP_SPRAY> list = psservice.getLoadedPlantsFilterSortRZA2(offset,limit,rating);
		return ResponseEntity.ok(list);
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
