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

import com.demo.Model.SEED_BULB;
import com.demo.Service.SEED_BULB_SERVICE;

@RestController
@CrossOrigin(value="*")
public class SEED_BULB_CONTROLLER {
	
	@Autowired
	private SEED_BULB_SERVICE sbservice;
	
	@GetMapping(value="/seed_bulb")
	public ResponseEntity<List<SEED_BULB>> getAllArtificialPlanters(){
		List<SEED_BULB> aplist = sbservice.getAllArtificialPlant();
		return ResponseEntity.ok(aplist);
		
	}
	
	@GetMapping("/seed_bulb/{apid}")
	public ResponseEntity<SEED_BULB> getById(@PathVariable String apid){
		SEED_BULB a=sbservice.getById1(apid);
		if (a!=null)
			return ResponseEntity.ok(a);
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
		
	
	@GetMapping("/seed_bulb/load")
	public ResponseEntity<List<SEED_BULB>> getLoadedPotPlanters(@RequestParam int offset,@RequestParam int limit) {
		List<SEED_BULB> pp1list = sbservice.getAllPotPlanterLoaded(offset,limit);
		return ResponseEntity.ok(pp1list);
	}
	
	@GetMapping("/seed_bulb/load/by_rating")
	public ResponseEntity<List<SEED_BULB>> getLoadedPotPlanters1(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating) {
		List<SEED_BULB> pp2list = sbservice.getAllPotPlanterLoadedRating(offset, limit, rating);
		return ResponseEntity.ok(pp2list);
	}
	
	
	@GetMapping("/seed_bulb/load/by_price")
	public ResponseEntity<List<SEED_BULB>> getLoadedPotPlanters2(@RequestParam int offset,@RequestParam int limit, @RequestParam double from, @RequestParam double to){
		List<SEED_BULB> pp3list = sbservice.getAllPotPlanterLoadedPrice(offset, limit, from, to);
		return ResponseEntity.ok(pp3list);
	}
	
	@GetMapping("/seed_bulb/load/by_rating_by_price")
	public ResponseEntity<List<SEED_BULB>> getLoadedPotPlanters3(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam double from, @RequestParam double to){
		List<SEED_BULB> pp4list = sbservice.getAllPotPlanterLoadedRatingPrice(offset, limit,rating, from, to);
		return ResponseEntity.ok(pp4list);
	}
	
	@GetMapping("/seed_bulb/load/by_rating_by_stock")
	public ResponseEntity<List<SEED_BULB>> getLoadedPotPlanters4(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam int stock) {
		List<SEED_BULB> pp5list = sbservice.getAllPotPlanterLoadedRatingStock(offset,limit,rating,stock);
		return ResponseEntity.ok(pp5list);
	}
	
	
	@GetMapping("/seed_bulb/load/by_price_by_stock")
	public ResponseEntity<List<SEED_BULB>> getLoadedPotPlanters5(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock) {
		List<SEED_BULB> pp6list = sbservice.getAllPotPlanterLoadedPriceStock(offset,limit,from,to,stock);
		return ResponseEntity.ok(pp6list);
	}
	
	
	@GetMapping("/seed_bulb/load/by_price_by_stock_by_rating")
	public ResponseEntity<List<SEED_BULB>> getLoadedPotPlanters6(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock, @RequestParam double rating) {
		List<SEED_BULB> pp7list = sbservice.getAllPotPlanterLoadedPriceStockRating(offset,limit,from,to,stock,rating);
		return ResponseEntity.ok(pp7list);
	}
	
	@GetMapping("/seed_bulb/load/by_rating_by_price_SORTBYTITLE_A-Z")
	public ResponseEntity<List<SEED_BULB>> getLoadedPotPlanters7(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam double from, @RequestParam double to){
		List<SEED_BULB> pp8list = sbservice.getAllPotPlanterLoadedRatingPriceSORTTITLE_A_Z(offset, limit,rating, from, to);
		return ResponseEntity.ok(pp8list);
	}
	
	@GetMapping("/seed_bulb/load/by_rating_by_price_SORTBYTITLE_Z-A")
	public ResponseEntity<List<SEED_BULB>> getLoadedPotPlanters8(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam double from, @RequestParam double to){
		List<SEED_BULB> pp9list = sbservice.getAllPotPlanterLoadedRatingPriceSORTTITLE_Z_A(offset, limit,rating, from, to);
		return ResponseEntity.ok(pp9list);
	}
	
	@GetMapping("/seed_bulb/load/by_rating_by_price_SORTBYPRICE_L_TO_H")
	public ResponseEntity<List<SEED_BULB>> getLoadedPotPlanters9(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam double from, @RequestParam double to){
		List<SEED_BULB> pp10list = sbservice.getAllPotPlanterLoadedRatingPriceSORTBYPRICE_L_TO_H(offset, limit,rating, from, to);
		return ResponseEntity.ok(pp10list);
	}
	
	@GetMapping("/seed_bulb/load/by_rating_by_price_SORTBYPRICE_H_TO_L")
	public ResponseEntity<List<SEED_BULB>> getLoadedPotPlanters10(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam double from, @RequestParam double to){
		List<SEED_BULB> pp11list = sbservice.getAllPotPlanterLoadedRatingPriceSORTBYPRICE_H_TO_L(offset, limit,rating, from, to);
		return ResponseEntity.ok(pp11list);
	}
	
	@GetMapping("/seed_bulb/load/by_rating_by_stock_SORTBYTITLE_A-Z")
	public ResponseEntity<List<SEED_BULB>> getLoadedPotPlanters11(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam int stock) {
		List<SEED_BULB> pp12list = sbservice.getAllPotPlanterLoadedRatingStockSORTTITLE_A_Z(offset,limit,rating,stock);
		return ResponseEntity.ok(pp12list);
	}
	
	@GetMapping("/seed_bulb/load/by_rating_by_stock_SORTBYTITLE_Z-A")
	public ResponseEntity<List<SEED_BULB>> getLoadedPotPlanters12(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam int stock) {
		List<SEED_BULB> pp13list = sbservice.getAllPotPlanterLoadedRatingStockSORTTITLE_Z_A(offset,limit,rating,stock);
		return ResponseEntity.ok(pp13list);
	}
	
	
	@GetMapping("/seed_bulb/load/by_rating_by_stock_SORTBYPRICE_L_TO_H")
	public ResponseEntity<List<SEED_BULB>> getLoadedPotPlanters13(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam int stock) {
		List<SEED_BULB> pp14list = sbservice.getAllPotPlanterLoadedRatingStockSORTBYPRICE_L_TO_H(offset,limit,rating,stock);
		return ResponseEntity.ok(pp14list);
	}
	
	@GetMapping("/seed_bulb/load/by_rating_by_stock_SORTBYPRICE_H_TO_L")
	public ResponseEntity<List<SEED_BULB>> getLoadedPotPlanters14(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam int stock) {
		List<SEED_BULB> pp15list = sbservice.getAllPotPlanterLoadedRatingStockSORTBYPRICE_H_TO_L(offset,limit,rating,stock);
		return ResponseEntity.ok(pp15list);
	}
	
	
	@GetMapping("/seed_bulb/load/by_price_by_stock_SORTBYTITLE_A-Z")
	public ResponseEntity<List<SEED_BULB>> getLoadedPotPlanters15(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock) {
		List<SEED_BULB> pp16list = sbservice.getAllPotPlanterLoadedPriceStockSORTTITLE_A_Z(offset,limit,from,to,stock);
		return ResponseEntity.ok(pp16list);
	}
	
	@GetMapping("/seed_bulb/load/by_price_by_stock_SORTBYTITLE_Z-A")
	public ResponseEntity<List<SEED_BULB>> getLoadedPotPlanters16(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock) {
		List<SEED_BULB> pp17list = sbservice.getAllPotPlanterLoadedPriceStockSORTTITLE_Z_A(offset,limit,from,to,stock);
		return ResponseEntity.ok(pp17list);
	}
	
	@GetMapping("/seed_bulb/load/by_price_by_stock_SORTBYPRICE_L_TO_H")
	public ResponseEntity<List<SEED_BULB>> getLoadedPotPlanters17(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock) {
		List<SEED_BULB> pp18list = sbservice.getAllPotPlanterLoadedPriceStockSORTBYPRICE_L_TO_H(offset,limit,from,to,stock);
		return ResponseEntity.ok(pp18list);
	}
	
	@GetMapping("/seed_bulb/load/by_price_by_stock_SORTBYPRICE_H_TO_L")
	public ResponseEntity<List<SEED_BULB>> getLoadedPotPlanters18(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock) {
		List<SEED_BULB> pp19list = sbservice.getAllPotPlanterLoadedPriceStockSORTBYPRICE_H_TO_L(offset,limit,from,to,stock);
		return ResponseEntity.ok(pp19list);
	}
	
	@GetMapping("/seed_bulb/load/by_price_by_stock_by_rating_SORTBYTITLE_A-Z")
	public ResponseEntity<List<SEED_BULB>> getLoadedPotPlanters19(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock, @RequestParam double rating) {
		List<SEED_BULB> pp20list = sbservice.getAllPotPlanterLoadedPriceStockRatingSORTTITLE_A_Z(offset,limit,from,to,stock,rating);
		return ResponseEntity.ok(pp20list);
	}
	
	@GetMapping("/seed_bulb/load/by_price_by_stock_by_rating_SORTBYTITLE_Z-A")
	public ResponseEntity<List<SEED_BULB>> getLoadedPotPlanters20(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock, @RequestParam double rating) {
		List<SEED_BULB> pp21list = sbservice.getAllPotPlanterLoadedPriceStockRatingSORTTITLE_Z_A(offset,limit,from,to,stock,rating);
		return ResponseEntity.ok(pp21list);
	}
	
	@GetMapping("/seed_bulb/load/by_price_by_stock_by_rating_SORTBYPRICE_L_TO_H")
	public ResponseEntity<List<SEED_BULB>> getLoadedPotPlanters21(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock, @RequestParam double rating) {
		List<SEED_BULB> pp22list = sbservice.getAllPotPlanterLoadedPriceStockRatingSORTBYPRICE_L_TO_H(offset,limit,from,to,stock,rating);
		return ResponseEntity.ok(pp22list);
	}
	
	@GetMapping("/seed_bulb/load/by_price_by_stock_by_rating_SORTBYPRICE_H_TO_L")
	public ResponseEntity<List<SEED_BULB>> getLoadedPotPlanters22(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock, @RequestParam double rating) {
		List<SEED_BULB> pp23list = sbservice.getAllPotPlanterLoadedPriceStockRatingSORTBYPRICE_H_TO_L(offset,limit,from,to,stock,rating);
		return ResponseEntity.ok(pp23list);
	}
	
	@GetMapping("/seed_bulb/load/SORTBYTITLE_A-Z")
	public ResponseEntity<List<SEED_BULB>>  sortA_Z(@RequestParam int offset,@RequestParam int limit) {
		List<SEED_BULB> psort = sbservice.sortA_Z(offset,limit);
		return ResponseEntity.ok(psort);
	}
	
	@GetMapping("/seed_bulb/load/SORTBYTITLE_Z-A")
	public ResponseEntity<List<SEED_BULB>> sortZ_A(@RequestParam int offset,@RequestParam int limit) {
		List<SEED_BULB> psort = sbservice.sortZ_A(offset,limit);
		return ResponseEntity.ok(psort);
	}
	
	@GetMapping("/seed_bulb/Availability")
	public ResponseEntity<List<SEED_BULB>> Availability1(@RequestParam int offset,@RequestParam int limit) {
		List<SEED_BULB> pavailability = sbservice.Availability(offset,limit);
		return ResponseEntity.ok(pavailability);
	}
	
	@GetMapping("/seed_bulb/Availability_SORTBYTITLE_A_Z")
	public ResponseEntity<List<SEED_BULB>> Avail_By_A_Z(@RequestParam int offset,@RequestParam int limit) {
		List<SEED_BULB> pavail_A_Z = sbservice.Availability_A_Z(offset, limit);
		return ResponseEntity.ok(pavail_A_Z);
	}
	
	@GetMapping("/seed_bulb/Availability_SORTBYTITLE_Z_A")
	public ResponseEntity<List<SEED_BULB>> Avail_By_Z_A(@RequestParam int offset,@RequestParam int limit) {
		List<SEED_BULB> pavail_Z_A = sbservice.Availability_Z_A(offset, limit);
		return ResponseEntity.ok(pavail_Z_A);
	}
	
	@GetMapping("/seed_bulb/Availability_SORTBYPRICE_Low_to_High")
	public ResponseEntity<List<SEED_BULB>> SortByPriceLH1(@RequestParam int offset,@RequestParam int limit){
		List<SEED_BULB> list = sbservice.getPlantByPriceLH(offset,limit);
	         if(list!=null)
	        	 return ResponseEntity.ok(list);
	         else 
	        	 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping("/seed_bulb/Availability_SORTBYPRICE_High_to_Low")
	public ResponseEntity<List<SEED_BULB>> SortByPriceHL1(@RequestParam int offset,@RequestParam int limit){
		List<SEED_BULB> list = sbservice.getPlantByPriceHL(offset,limit);
	         if(list!=null)
	        	 return ResponseEntity.ok(list);
	         else 
	        	 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping("/seed_bulb/SORTBYPRICE_Low_TO_High")
	public ResponseEntity<List<SEED_BULB>> SORTBYPRICE_L_H(@RequestParam int offset,@RequestParam int limit) {
		List<SEED_BULB> slh = sbservice.SORTBYPRICE_L_H(offset, limit);
		return ResponseEntity.ok(slh);
	}
	
	@GetMapping("/seed_bulb/SORTBYPRICE_High_TO_Low")
	public ResponseEntity<List<SEED_BULB>> SORTBYPRICE_H_L(@RequestParam int offset,@RequestParam int limit) {
		List<SEED_BULB> shl = sbservice.SORTBYPRICE_H_L(offset, limit);
		return ResponseEntity.ok(shl);
	}
	
	
	@GetMapping("/seed_bulb/load/by_price_High_to_Low")
	public ResponseEntity<List<SEED_BULB>> getLoadedPlantsFilterSortPHL1(@RequestParam int offset,@RequestParam int limit,@RequestParam double from,@RequestParam double to){
		List<SEED_BULB> list = sbservice.getLoadedPlantsFilterSortPHL1(offset,limit,from,to);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/seed_bulb/load/by_price_Low_to_High")
	public ResponseEntity<List<SEED_BULB>> getLoadedPlantsFilterSortPLH1(@RequestParam int offset,@RequestParam int limit,@RequestParam double from,@RequestParam double to){
		List<SEED_BULB> list = sbservice.getLoadedPlantsFilterSortPLH1(offset,limit,from,to);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/seed_bulb/load/by_price_A_to_Z")
	public ResponseEntity<List<SEED_BULB>> getLoadedPlantsFilterSortAZ1(@RequestParam int offset, @RequestParam int limit, @RequestParam double from,@RequestParam double to ){
		List<SEED_BULB> list =sbservice.getLoadedPlantsFilterSortAZ1(offset,limit,from,to);
		return ResponseEntity.ok(list);
	}
	@GetMapping("/seed_bulb/load/by_price_Z_to_A")
	public ResponseEntity<List<SEED_BULB>> getLoadedPlantsFilterSortZA1(@RequestParam int offset, @RequestParam int limit, @RequestParam double from,@RequestParam double to ){
		List<SEED_BULB> list =sbservice.getLoadedPlantsFilterSortZA1(offset,limit,from,to);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/seed_bulb/load/by_rating_SORTBYPRICE_High_to_Low")
	public ResponseEntity<List<SEED_BULB>> getLoadedPlantsFilterSortRHL2(@RequestParam int offset,@RequestParam int limit,@RequestParam double rating){
		List<SEED_BULB> list = sbservice.getLoadedPlantsFilterSortRHL2(offset,limit,rating);
		return ResponseEntity.ok(list);
	}
	@GetMapping("/seed_bulb/load/by_rating_SORTBYPRICE_Low_to_High")
	public ResponseEntity<List<SEED_BULB>> getLoadedPlantsFilterSortRLH2(@RequestParam int offset,@RequestParam int limit,@RequestParam double rating){
		List<SEED_BULB> list = sbservice.getLoadedPlantsFilterSortRLH2(offset,limit,rating);
		return ResponseEntity.ok(list);
	}
	@GetMapping("/seed_bulb/load/by_rating_A_to_Z")
	public ResponseEntity<List<SEED_BULB>> getLoadedPlantsFilterSortRAZ2(@RequestParam int offset,@RequestParam int limit,@RequestParam double rating){
		List<SEED_BULB> list = sbservice.getLoadedPlantsFilterSortRAZ2(offset,limit,rating);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/seed_bulb/load/by_rating_Z_to_A")
	public ResponseEntity<List<SEED_BULB>> getLoadedPlantsFilterSortRZA2(@RequestParam int offset,@RequestParam int limit,@RequestParam double rating){
		List<SEED_BULB> list = sbservice.getLoadedPlantsFilterSortRZA2(offset,limit,rating);
		return ResponseEntity.ok(list);
	}
	
	

}
