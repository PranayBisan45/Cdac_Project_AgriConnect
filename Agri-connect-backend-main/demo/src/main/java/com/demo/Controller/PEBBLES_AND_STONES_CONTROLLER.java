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

import com.demo.Model.PEBBLES_AND_STONES;
import com.demo.Service.PEBBLES_AND_STONES_SERVICE;

@RestController
@CrossOrigin(value="*")
public class PEBBLES_AND_STONES_CONTROLLER {
	
	@Autowired
	private PEBBLES_AND_STONES_SERVICE passervice;
	
	@GetMapping(value="/pebbles_and_stones")
	public ResponseEntity<List<PEBBLES_AND_STONES>> getAllArtificialPlanters(){
		List<PEBBLES_AND_STONES> aplist = passervice.getAllArtificialPlant();
		return ResponseEntity.ok(aplist);
		
	}
	
	@GetMapping("/pebbles_and_stones/{apid}")
	public ResponseEntity<PEBBLES_AND_STONES> getById(@PathVariable String apid){
		PEBBLES_AND_STONES a=passervice.getById1(apid);
		if (a!=null)
			return ResponseEntity.ok(a);
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
		
	
	@GetMapping("/pebbles_and_stones/load")
	public ResponseEntity<List<PEBBLES_AND_STONES>> getLoadedPotPlanters(@RequestParam int offset,@RequestParam int limit) {
		List<PEBBLES_AND_STONES> pp1list = passervice.getAllPotPlanterLoaded(offset,limit);
		return ResponseEntity.ok(pp1list);
	}
	
	@GetMapping("/pebbles_and_stones/load/by_rating")
	public ResponseEntity<List<PEBBLES_AND_STONES>> getLoadedPotPlanters1(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating) {
		List<PEBBLES_AND_STONES> pp2list = passervice.getAllPotPlanterLoadedRating(offset, limit, rating);
		return ResponseEntity.ok(pp2list);
	}
	
	
	@GetMapping("/pebbles_and_stones/load/by_price")
	public ResponseEntity<List<PEBBLES_AND_STONES>> getLoadedPotPlanters2(@RequestParam int offset,@RequestParam int limit, @RequestParam double from, @RequestParam double to){
		List<PEBBLES_AND_STONES> pp3list = passervice.getAllPotPlanterLoadedPrice(offset, limit, from, to);
		return ResponseEntity.ok(pp3list);
	}
	
	@GetMapping("/pebbles_and_stones/load/by_rating_by_price")
	public ResponseEntity<List<PEBBLES_AND_STONES>> getLoadedPotPlanters3(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam double from, @RequestParam double to){
		List<PEBBLES_AND_STONES> pp4list = passervice.getAllPotPlanterLoadedRatingPrice(offset, limit,rating, from, to);
		return ResponseEntity.ok(pp4list);
	}
	
	@GetMapping("/pebbles_and_stones/load/by_rating_by_stock")
	public ResponseEntity<List<PEBBLES_AND_STONES>> getLoadedPotPlanters4(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam int stock) {
		List<PEBBLES_AND_STONES> pp5list = passervice.getAllPotPlanterLoadedRatingStock(offset,limit,rating,stock);
		return ResponseEntity.ok(pp5list);
	}
	
	
	@GetMapping("/pebbles_and_stones/load/by_price_by_stock")
	public ResponseEntity<List<PEBBLES_AND_STONES>> getLoadedPotPlanters5(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock) {
		List<PEBBLES_AND_STONES> pp6list = passervice.getAllPotPlanterLoadedPriceStock(offset,limit,from,to,stock);
		return ResponseEntity.ok(pp6list);
	}
	
	
	@GetMapping("/pebbles_and_stones/load/by_price_by_stock_by_rating")
	public ResponseEntity<List<PEBBLES_AND_STONES>> getLoadedPotPlanters6(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock, @RequestParam double rating) {
		List<PEBBLES_AND_STONES> pp7list = passervice.getAllPotPlanterLoadedPriceStockRating(offset,limit,from,to,stock,rating);
		return ResponseEntity.ok(pp7list);
	}
	
	@GetMapping("/pebbles_and_stones/load/by_rating_by_price_SORTBYTITLE_A-Z")
	public ResponseEntity<List<PEBBLES_AND_STONES>> getLoadedPotPlanters7(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam double from, @RequestParam double to){
		List<PEBBLES_AND_STONES> pp8list = passervice.getAllPotPlanterLoadedRatingPriceSORTTITLE_A_Z(offset, limit,rating, from, to);
		return ResponseEntity.ok(pp8list);
	}
	
	@GetMapping("/pebbles_and_stones/load/by_rating_by_price_SORTBYTITLE_Z-A")
	public ResponseEntity<List<PEBBLES_AND_STONES>> getLoadedPotPlanters8(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam double from, @RequestParam double to){
		List<PEBBLES_AND_STONES> pp9list = passervice.getAllPotPlanterLoadedRatingPriceSORTTITLE_Z_A(offset, limit,rating, from, to);
		return ResponseEntity.ok(pp9list);
	}
	
	@GetMapping("/pebbles_and_stones/load/by_rating_by_price_SORTBYPRICE_L_TO_H")
	public ResponseEntity<List<PEBBLES_AND_STONES>> getLoadedPotPlanters9(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam double from, @RequestParam double to){
		List<PEBBLES_AND_STONES> pp10list = passervice.getAllPotPlanterLoadedRatingPriceSORTBYPRICE_L_TO_H(offset, limit,rating, from, to);
		return ResponseEntity.ok(pp10list);
	}
	
	@GetMapping("/pebbles_and_stones/load/by_rating_by_price_SORTBYPRICE_H_TO_L")
	public ResponseEntity<List<PEBBLES_AND_STONES>> getLoadedPotPlanters10(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam double from, @RequestParam double to){
		List<PEBBLES_AND_STONES> pp11list = passervice.getAllPotPlanterLoadedRatingPriceSORTBYPRICE_H_TO_L(offset, limit,rating, from, to);
		return ResponseEntity.ok(pp11list);
	}
	
	@GetMapping("/pebbles_and_stones/load/by_rating_by_stock_SORTBYTITLE_A-Z")
	public ResponseEntity<List<PEBBLES_AND_STONES>> getLoadedPotPlanters11(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam int stock) {
		List<PEBBLES_AND_STONES> pp12list = passervice.getAllPotPlanterLoadedRatingStockSORTTITLE_A_Z(offset,limit,rating,stock);
		return ResponseEntity.ok(pp12list);
	}
	
	@GetMapping("/pebbles_and_stones/load/by_rating_by_stock_SORTBYTITLE_Z-A")
	public ResponseEntity<List<PEBBLES_AND_STONES>> getLoadedPotPlanters12(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam int stock) {
		List<PEBBLES_AND_STONES> pp13list = passervice.getAllPotPlanterLoadedRatingStockSORTTITLE_Z_A(offset,limit,rating,stock);
		return ResponseEntity.ok(pp13list);
	}
	
	
	@GetMapping("/pebbles_and_stones/load/by_rating_by_stock_SORTBYPRICE_L_TO_H")
	public ResponseEntity<List<PEBBLES_AND_STONES>> getLoadedPotPlanters13(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam int stock) {
		List<PEBBLES_AND_STONES> pp14list = passervice.getAllPotPlanterLoadedRatingStockSORTBYPRICE_L_TO_H(offset,limit,rating,stock);
		return ResponseEntity.ok(pp14list);
	}
	
	@GetMapping("/pebbles_and_stones/load/by_rating_by_stock_SORTBYPRICE_H_TO_L")
	public ResponseEntity<List<PEBBLES_AND_STONES>> getLoadedPotPlanters14(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam int stock) {
		List<PEBBLES_AND_STONES> pp15list = passervice.getAllPotPlanterLoadedRatingStockSORTBYPRICE_H_TO_L(offset,limit,rating,stock);
		return ResponseEntity.ok(pp15list);
	}
	
	
	@GetMapping("/pebbles_and_stones/load/by_price_by_stock_SORTBYTITLE_A-Z")
	public ResponseEntity<List<PEBBLES_AND_STONES>> getLoadedPotPlanters15(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock) {
		List<PEBBLES_AND_STONES> pp16list = passervice.getAllPotPlanterLoadedPriceStockSORTTITLE_A_Z(offset,limit,from,to,stock);
		return ResponseEntity.ok(pp16list);
	}
	
	@GetMapping("/pebbles_and_stones/load/by_price_by_stock_SORTBYTITLE_Z-A")
	public ResponseEntity<List<PEBBLES_AND_STONES>> getLoadedPotPlanters16(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock) {
		List<PEBBLES_AND_STONES> pp17list = passervice.getAllPotPlanterLoadedPriceStockSORTTITLE_Z_A(offset,limit,from,to,stock);
		return ResponseEntity.ok(pp17list);
	}
	
	@GetMapping("/pebbles_and_stones/load/by_price_by_stock_SORTBYPRICE_L_TO_H")
	public ResponseEntity<List<PEBBLES_AND_STONES>> getLoadedPotPlanters17(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock) {
		List<PEBBLES_AND_STONES> pp18list = passervice.getAllPotPlanterLoadedPriceStockSORTBYPRICE_L_TO_H(offset,limit,from,to,stock);
		return ResponseEntity.ok(pp18list);
	}
	
	@GetMapping("/pebbles_and_stones/load/by_price_by_stock_SORTBYPRICE_H_TO_L")
	public ResponseEntity<List<PEBBLES_AND_STONES>> getLoadedPotPlanters18(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock) {
		List<PEBBLES_AND_STONES> pp19list = passervice.getAllPotPlanterLoadedPriceStockSORTBYPRICE_H_TO_L(offset,limit,from,to,stock);
		return ResponseEntity.ok(pp19list);
	}
	
	@GetMapping("/pebbles_and_stones/load/by_price_by_stock_by_rating_SORTBYTITLE_A-Z")
	public ResponseEntity<List<PEBBLES_AND_STONES>> getLoadedPotPlanters19(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock, @RequestParam double rating) {
		List<PEBBLES_AND_STONES> pp20list = passervice.getAllPotPlanterLoadedPriceStockRatingSORTTITLE_A_Z(offset,limit,from,to,stock,rating);
		return ResponseEntity.ok(pp20list);
	}
	
	@GetMapping("/pebbles_and_stones/load/by_price_by_stock_by_rating_SORTBYTITLE_Z-A")
	public ResponseEntity<List<PEBBLES_AND_STONES>> getLoadedPotPlanters20(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock, @RequestParam double rating) {
		List<PEBBLES_AND_STONES> pp21list = passervice.getAllPotPlanterLoadedPriceStockRatingSORTTITLE_Z_A(offset,limit,from,to,stock,rating);
		return ResponseEntity.ok(pp21list);
	}
	
	@GetMapping("/pebbles_and_stones/load/by_price_by_stock_by_rating_SORTBYPRICE_L_TO_H")
	public ResponseEntity<List<PEBBLES_AND_STONES>> getLoadedPotPlanters21(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock, @RequestParam double rating) {
		List<PEBBLES_AND_STONES> pp22list = passervice.getAllPotPlanterLoadedPriceStockRatingSORTBYPRICE_L_TO_H(offset,limit,from,to,stock,rating);
		return ResponseEntity.ok(pp22list);
	}
	
	@GetMapping("/pebbles_and_stones/load/by_price_by_stock_by_rating_SORTBYPRICE_H_TO_L")
	public ResponseEntity<List<PEBBLES_AND_STONES>> getLoadedPotPlanters22(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock, @RequestParam double rating) {
		List<PEBBLES_AND_STONES> pp23list = passervice.getAllPotPlanterLoadedPriceStockRatingSORTBYPRICE_H_TO_L(offset,limit,from,to,stock,rating);
		return ResponseEntity.ok(pp23list);
	}
	
	@GetMapping("/pebbles_and_stones/load/SORTBYTITLE_A-Z")
	public ResponseEntity<List<PEBBLES_AND_STONES>>  sortA_Z(@RequestParam int offset,@RequestParam int limit) {
		List<PEBBLES_AND_STONES> psort = passervice.sortA_Z(offset,limit);
		return ResponseEntity.ok(psort);
	}
	
	@GetMapping("/pebbles_and_stones/load/SORTBYTITLE_Z-A")
	public ResponseEntity<List<PEBBLES_AND_STONES>> sortZ_A(@RequestParam int offset,@RequestParam int limit) {
		List<PEBBLES_AND_STONES> psort = passervice.sortZ_A(offset,limit);
		return ResponseEntity.ok(psort);
	}
	
	@GetMapping("/pebbles_and_stones/Availability")
	public ResponseEntity<List<PEBBLES_AND_STONES>> Availability1(@RequestParam int offset,@RequestParam int limit) {
		List<PEBBLES_AND_STONES> pavailability = passervice.Availability(offset,limit);
		return ResponseEntity.ok(pavailability);
	}
	
	@GetMapping("/pebbles_and_stones/Availability_SORTBYTITLE_A_Z")
	public ResponseEntity<List<PEBBLES_AND_STONES>> Avail_By_A_Z(@RequestParam int offset,@RequestParam int limit) {
		List<PEBBLES_AND_STONES> pavail_A_Z = passervice.Availability_A_Z(offset, limit);
		return ResponseEntity.ok(pavail_A_Z);
	}
	
	@GetMapping("/pebbles_and_stones/Availability_SORTBYTITLE_Z_A")
	public ResponseEntity<List<PEBBLES_AND_STONES>> Avail_By_Z_A(@RequestParam int offset,@RequestParam int limit) {
		List<PEBBLES_AND_STONES> pavail_Z_A = passervice.Availability_Z_A(offset, limit);
		return ResponseEntity.ok(pavail_Z_A);
	}
	
	@GetMapping("/pebbles_and_stones/Availability_SORTBYPRICE_Low_to_High")
	public ResponseEntity<List<PEBBLES_AND_STONES>> SortByPriceLH1(@RequestParam int offset,@RequestParam int limit){
		List<PEBBLES_AND_STONES> list = passervice.getPlantByPriceLH(offset,limit);
	         if(list!=null)
	        	 return ResponseEntity.ok(list);
	         else 
	        	 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping("/pebbles_and_stones/Availability_SORTBYPRICE_High_to_Low")
	public ResponseEntity<List<PEBBLES_AND_STONES>> SortByPriceHL1(@RequestParam int offset,@RequestParam int limit){
		List<PEBBLES_AND_STONES> list = passervice.getPlantByPriceHL(offset,limit);
	         if(list!=null)
	        	 return ResponseEntity.ok(list);
	         else 
	        	 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping("/pebbles_and_stones/SORTBYPRICE_Low_TO_High")
	public ResponseEntity<List<PEBBLES_AND_STONES>> SORTBYPRICE_L_H(@RequestParam int offset,@RequestParam int limit) {
		List<PEBBLES_AND_STONES> slh = passervice.SORTBYPRICE_L_H(offset, limit);
		return ResponseEntity.ok(slh);
	}
	
	@GetMapping("/pebbles_and_stones/SORTBYPRICE_High_TO_Low")
	public ResponseEntity<List<PEBBLES_AND_STONES>> SORTBYPRICE_H_L(@RequestParam int offset,@RequestParam int limit) {
		List<PEBBLES_AND_STONES> shl = passervice.SORTBYPRICE_H_L(offset, limit);
		return ResponseEntity.ok(shl);
	}
	
	
	@GetMapping("/pebbles_and_stones/load/by_price_High_to_Low")
	public ResponseEntity<List<PEBBLES_AND_STONES>> getLoadedPlantsFilterSortPHL1(@RequestParam int offset,@RequestParam int limit,@RequestParam double from,@RequestParam double to){
		List<PEBBLES_AND_STONES> list = passervice.getLoadedPlantsFilterSortPHL1(offset,limit,from,to);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/pebbles_and_stones/load/by_price_Low_to_High")
	public ResponseEntity<List<PEBBLES_AND_STONES>> getLoadedPlantsFilterSortPLH1(@RequestParam int offset,@RequestParam int limit,@RequestParam double from,@RequestParam double to){
		List<PEBBLES_AND_STONES> list = passervice.getLoadedPlantsFilterSortPLH1(offset,limit,from,to);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/pebbles_and_stones/load/by_price_A_to_Z")
	public ResponseEntity<List<PEBBLES_AND_STONES>> getLoadedPlantsFilterSortAZ1(@RequestParam int offset, @RequestParam int limit, @RequestParam double from,@RequestParam double to ){
		List<PEBBLES_AND_STONES> list =passervice.getLoadedPlantsFilterSortAZ1(offset,limit,from,to);
		return ResponseEntity.ok(list);
	}
	@GetMapping("/pebbles_and_stones/load/by_price_Z_to_A")
	public ResponseEntity<List<PEBBLES_AND_STONES>> getLoadedPlantsFilterSortZA1(@RequestParam int offset, @RequestParam int limit, @RequestParam double from,@RequestParam double to ){
		List<PEBBLES_AND_STONES> list =passervice.getLoadedPlantsFilterSortZA1(offset,limit,from,to);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/pebbles_and_stones/load/by_rating_SORTBYPRICE_High_to_Low")
	public ResponseEntity<List<PEBBLES_AND_STONES>> getLoadedPlantsFilterSortRHL2(@RequestParam int offset,@RequestParam int limit,@RequestParam double rating){
		List<PEBBLES_AND_STONES> list = passervice.getLoadedPlantsFilterSortRHL2(offset,limit,rating);
		return ResponseEntity.ok(list);
	}
	@GetMapping("/pebbles_and_stones/load/by_rating_SORTBYPRICE_Low_to_High")
	public ResponseEntity<List<PEBBLES_AND_STONES>> getLoadedPlantsFilterSortRLH2(@RequestParam int offset,@RequestParam int limit,@RequestParam double rating){
		List<PEBBLES_AND_STONES> list = passervice.getLoadedPlantsFilterSortRLH2(offset,limit,rating);
		return ResponseEntity.ok(list);
	}
	@GetMapping("/pebbles_and_stones/load/by_rating_A_to_Z")
	public ResponseEntity<List<PEBBLES_AND_STONES>> getLoadedPlantsFilterSortRAZ2(@RequestParam int offset,@RequestParam int limit,@RequestParam double rating){
		List<PEBBLES_AND_STONES> list = passervice.getLoadedPlantsFilterSortRAZ2(offset,limit,rating);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/pebbles_and_stones/load/by_rating_Z_to_A")
	public ResponseEntity<List<PEBBLES_AND_STONES>> getLoadedPlantsFilterSortRZA2(@RequestParam int offset,@RequestParam int limit,@RequestParam double rating){
		List<PEBBLES_AND_STONES> list = passervice.getLoadedPlantsFilterSortRZA2(offset,limit,rating);
		return ResponseEntity.ok(list);
	}
	
	

}
