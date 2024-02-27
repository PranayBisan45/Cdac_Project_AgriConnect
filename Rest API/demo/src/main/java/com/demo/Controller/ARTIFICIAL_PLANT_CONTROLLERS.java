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

import com.demo.Model.ARTIFICIAL_PLANT;
import com.demo.Service.ARTIFICIAL_PLANT_SERVICE;

@RestController
@CrossOrigin(value="*")
public class ARTIFICIAL_PLANT_CONTROLLERS {

	@Autowired
	ARTIFICIAL_PLANT_SERVICE apservice;
	
	@GetMapping(value="/artificial_plant")
	public ResponseEntity<List<ARTIFICIAL_PLANT>> getAllArtificialPlanters(){
		List<ARTIFICIAL_PLANT> aplist = apservice.getAllArtificialPlant();
		return ResponseEntity.ok(aplist);
		
	}
	
	@GetMapping("/artificial_plant/{apid}")
	public ResponseEntity<ARTIFICIAL_PLANT> getById(@PathVariable String apid){
		ARTIFICIAL_PLANT a=apservice.getById1(apid);
		if (a!=null)
			return ResponseEntity.ok(a);
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
		
	
	@GetMapping("/artificial_plant/load")
	public ResponseEntity<List<ARTIFICIAL_PLANT>> getLoadedPotPlanters(@RequestParam int offset,@RequestParam int limit) {
		List<ARTIFICIAL_PLANT> pp1list = apservice.getAllPotPlanterLoaded(offset,limit);
		return ResponseEntity.ok(pp1list);
	}
	
	@GetMapping("/artificial_plant/load/by_rating")
	public ResponseEntity<List<ARTIFICIAL_PLANT>> getLoadedPotPlanters1(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating) {
		List<ARTIFICIAL_PLANT> pp2list = apservice.getAllPotPlanterLoadedRating(offset, limit, rating);
		return ResponseEntity.ok(pp2list);
	}
	
	
	@GetMapping("/artificial_plant/load/by_price")
	public ResponseEntity<List<ARTIFICIAL_PLANT>> getLoadedPotPlanters2(@RequestParam int offset,@RequestParam int limit, @RequestParam double from, @RequestParam double to){
		List<ARTIFICIAL_PLANT> pp3list = apservice.getAllPotPlanterLoadedPrice(offset, limit, from, to);
		return ResponseEntity.ok(pp3list);
	}
	
	@GetMapping("/artificial_plant/load/by_rating_by_price")
	public ResponseEntity<List<ARTIFICIAL_PLANT>> getLoadedPotPlanters3(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam double from, @RequestParam double to){
		List<ARTIFICIAL_PLANT> pp4list = apservice.getAllPotPlanterLoadedRatingPrice(offset, limit,rating, from, to);
		return ResponseEntity.ok(pp4list);
	}
	
	@GetMapping("/artificial_plant/load/by_rating_by_stock")
	public ResponseEntity<List<ARTIFICIAL_PLANT>> getLoadedPotPlanters4(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam int stock) {
		List<ARTIFICIAL_PLANT> pp5list = apservice.getAllPotPlanterLoadedRatingStock(offset,limit,rating,stock);
		return ResponseEntity.ok(pp5list);
	}
	
	
	@GetMapping("/artificial_plant/load/by_price_by_stock")
	public ResponseEntity<List<ARTIFICIAL_PLANT>> getLoadedPotPlanters5(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock) {
		List<ARTIFICIAL_PLANT> pp6list = apservice.getAllPotPlanterLoadedPriceStock(offset,limit,from,to,stock);
		return ResponseEntity.ok(pp6list);
	}
	
	
	@GetMapping("/artificial_plant/load/by_price_by_stock_by_rating")
	public ResponseEntity<List<ARTIFICIAL_PLANT>> getLoadedPotPlanters6(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock, @RequestParam double rating) {
		List<ARTIFICIAL_PLANT> pp7list = apservice.getAllPotPlanterLoadedPriceStockRating(offset,limit,from,to,stock,rating);
		return ResponseEntity.ok(pp7list);
	}
	
	@GetMapping("/artificial_plant/load/by_rating_by_price_SORTBYTITLE_A-Z")
	public ResponseEntity<List<ARTIFICIAL_PLANT>> getLoadedPotPlanters7(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam double from, @RequestParam double to){
		List<ARTIFICIAL_PLANT> pp8list = apservice.getAllPotPlanterLoadedRatingPriceSORTTITLE_A_Z(offset, limit,rating, from, to);
		return ResponseEntity.ok(pp8list);
	}
	
	@GetMapping("/artificial_plant/load/by_rating_by_price_SORTBYTITLE_Z-A")
	public ResponseEntity<List<ARTIFICIAL_PLANT>> getLoadedPotPlanters8(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam double from, @RequestParam double to){
		List<ARTIFICIAL_PLANT> pp9list = apservice.getAllPotPlanterLoadedRatingPriceSORTTITLE_Z_A(offset, limit,rating, from, to);
		return ResponseEntity.ok(pp9list);
	}
	
	@GetMapping("/artificial_plant/load/by_rating_by_price_SORTBYPRICE_L_TO_H")
	public ResponseEntity<List<ARTIFICIAL_PLANT>> getLoadedPotPlanters9(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam double from, @RequestParam double to){
		List<ARTIFICIAL_PLANT> pp10list = apservice.getAllPotPlanterLoadedRatingPriceSORTBYPRICE_L_TO_H(offset, limit,rating, from, to);
		return ResponseEntity.ok(pp10list);
	}
	
	@GetMapping("/artificial_plant/load/by_rating_by_price_SORTBYPRICE_H_TO_L")
	public ResponseEntity<List<ARTIFICIAL_PLANT>> getLoadedPotPlanters10(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam double from, @RequestParam double to){
		List<ARTIFICIAL_PLANT> pp11list = apservice.getAllPotPlanterLoadedRatingPriceSORTBYPRICE_H_TO_L(offset, limit,rating, from, to);
		return ResponseEntity.ok(pp11list);
	}
	
	@GetMapping("/artificial_plant/load/by_rating_by_stock_SORTBYTITLE_A-Z")
	public ResponseEntity<List<ARTIFICIAL_PLANT>> getLoadedPotPlanters11(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam int stock) {
		List<ARTIFICIAL_PLANT> pp12list = apservice.getAllPotPlanterLoadedRatingStockSORTTITLE_A_Z(offset,limit,rating,stock);
		return ResponseEntity.ok(pp12list);
	}
	
	@GetMapping("/artificial_plant/load/by_rating_by_stock_SORTBYTITLE_Z-A")
	public ResponseEntity<List<ARTIFICIAL_PLANT>> getLoadedPotPlanters12(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam int stock) {
		List<ARTIFICIAL_PLANT> pp13list = apservice.getAllPotPlanterLoadedRatingStockSORTTITLE_Z_A(offset,limit,rating,stock);
		return ResponseEntity.ok(pp13list);
	}
	
	
	@GetMapping("/artificial_plant/load/by_rating_by_stock_SORTBYPRICE_L_TO_H")
	public ResponseEntity<List<ARTIFICIAL_PLANT>> getLoadedPotPlanters13(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam int stock) {
		List<ARTIFICIAL_PLANT> pp14list = apservice.getAllPotPlanterLoadedRatingStockSORTBYPRICE_L_TO_H(offset,limit,rating,stock);
		return ResponseEntity.ok(pp14list);
	}
	
	@GetMapping("/artificial_plant/load/by_rating_by_stock_SORTBYPRICE_H_TO_L")
	public ResponseEntity<List<ARTIFICIAL_PLANT>> getLoadedPotPlanters14(@RequestParam int offset,@RequestParam int limit, @RequestParam double rating, @RequestParam int stock) {
		List<ARTIFICIAL_PLANT> pp15list = apservice.getAllPotPlanterLoadedRatingStockSORTBYPRICE_H_TO_L(offset,limit,rating,stock);
		return ResponseEntity.ok(pp15list);
	}
	
	
	@GetMapping("/artificial_plant/load/by_price_by_stock_SORTBYTITLE_A-Z")
	public ResponseEntity<List<ARTIFICIAL_PLANT>> getLoadedPotPlanters15(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock) {
		List<ARTIFICIAL_PLANT> pp16list = apservice.getAllPotPlanterLoadedPriceStockSORTTITLE_A_Z(offset,limit,from,to,stock);
		return ResponseEntity.ok(pp16list);
	}
	
	@GetMapping("/artificial_plant/load/by_price_by_stock_SORTBYTITLE_Z-A")
	public ResponseEntity<List<ARTIFICIAL_PLANT>> getLoadedPotPlanters16(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock) {
		List<ARTIFICIAL_PLANT> pp17list = apservice.getAllPotPlanterLoadedPriceStockSORTTITLE_Z_A(offset,limit,from,to,stock);
		return ResponseEntity.ok(pp17list);
	}
	
	@GetMapping("/artificial_plant/load/by_price_by_stock_SORTBYPRICE_L_TO_H")
	public ResponseEntity<List<ARTIFICIAL_PLANT>> getLoadedPotPlanters17(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock) {
		List<ARTIFICIAL_PLANT> pp18list = apservice.getAllPotPlanterLoadedPriceStockSORTBYPRICE_L_TO_H(offset,limit,from,to,stock);
		return ResponseEntity.ok(pp18list);
	}
	
	@GetMapping("/artificial_plant/load/by_price_by_stock_SORTBYPRICE_H_TO_L")
	public ResponseEntity<List<ARTIFICIAL_PLANT>> getLoadedPotPlanters18(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock) {
		List<ARTIFICIAL_PLANT> pp19list = apservice.getAllPotPlanterLoadedPriceStockSORTBYPRICE_H_TO_L(offset,limit,from,to,stock);
		return ResponseEntity.ok(pp19list);
	}
	
	@GetMapping("/artificial_plant/load/by_price_by_stock_by_rating_SORTBYTITLE_A-Z")
	public ResponseEntity<List<ARTIFICIAL_PLANT>> getLoadedPotPlanters19(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock, @RequestParam double rating) {
		List<ARTIFICIAL_PLANT> pp20list = apservice.getAllPotPlanterLoadedPriceStockRatingSORTTITLE_A_Z(offset,limit,from,to,stock,rating);
		return ResponseEntity.ok(pp20list);
	}
	
	@GetMapping("/artificial_plant/load/by_price_by_stock_by_rating_SORTBYTITLE_Z-A")
	public ResponseEntity<List<ARTIFICIAL_PLANT>> getLoadedPotPlanters20(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock, @RequestParam double rating) {
		List<ARTIFICIAL_PLANT> pp21list = apservice.getAllPotPlanterLoadedPriceStockRatingSORTTITLE_Z_A(offset,limit,from,to,stock,rating);
		return ResponseEntity.ok(pp21list);
	}
	
	@GetMapping("/artificial_plant/load/by_price_by_stock_by_rating_SORTBYPRICE_L_TO_H")
	public ResponseEntity<List<ARTIFICIAL_PLANT>> getLoadedPotPlanters21(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock, @RequestParam double rating) {
		List<ARTIFICIAL_PLANT> pp22list = apservice.getAllPotPlanterLoadedPriceStockRatingSORTBYPRICE_L_TO_H(offset,limit,from,to,stock,rating);
		return ResponseEntity.ok(pp22list);
	}
	
	@GetMapping("/artificial_plant/load/by_price_by_stock_by_rating_SORTBYPRICE_H_TO_L")
	public ResponseEntity<List<ARTIFICIAL_PLANT>> getLoadedPotPlanters22(@RequestParam int offset,@RequestParam int limit, @RequestParam double from,@RequestParam double to, @RequestParam int stock, @RequestParam double rating) {
		List<ARTIFICIAL_PLANT> pp23list = apservice.getAllPotPlanterLoadedPriceStockRatingSORTBYPRICE_H_TO_L(offset,limit,from,to,stock,rating);
		return ResponseEntity.ok(pp23list);
	}
	
	@GetMapping("/artificial_plant/load/SORTBYTITLE_A-Z")
	public ResponseEntity<List<ARTIFICIAL_PLANT>>  sortA_Z(@RequestParam int offset,@RequestParam int limit) {
		List<ARTIFICIAL_PLANT> psort = apservice.sortA_Z(offset,limit);
		return ResponseEntity.ok(psort);
	}
	
	@GetMapping("/artificial_plant/load/SORTBYTITLE_Z-A")
	public ResponseEntity<List<ARTIFICIAL_PLANT>> sortZ_A(@RequestParam int offset,@RequestParam int limit) {
		List<ARTIFICIAL_PLANT> psort = apservice.sortZ_A(offset,limit);
		return ResponseEntity.ok(psort);
	}
	
	@GetMapping("/artificial_plant/Availability")
	public ResponseEntity<List<ARTIFICIAL_PLANT>> Availability1(@RequestParam int offset,@RequestParam int limit) {
		List<ARTIFICIAL_PLANT> pavailability = apservice.Availability(offset,limit);
		return ResponseEntity.ok(pavailability);
	}
	
	@GetMapping("/artificial_plant/Availability_SORTBYTITLE_A_Z")
	public ResponseEntity<List<ARTIFICIAL_PLANT>> Avail_By_A_Z(@RequestParam int offset,@RequestParam int limit) {
		List<ARTIFICIAL_PLANT> pavail_A_Z = apservice.Availability_A_Z(offset, limit);
		return ResponseEntity.ok(pavail_A_Z);
	}
	
	@GetMapping("/artificial_plant/Availability_SORTBYTITLE_Z_A")
	public ResponseEntity<List<ARTIFICIAL_PLANT>> Avail_By_Z_A(@RequestParam int offset,@RequestParam int limit) {
		List<ARTIFICIAL_PLANT> pavail_Z_A = apservice.Availability_Z_A(offset, limit);
		return ResponseEntity.ok(pavail_Z_A);
	}
	
	@GetMapping("/artificial_plant/Availability_SORTBYPRICE_Low_to_High")
	public ResponseEntity<List<ARTIFICIAL_PLANT>> SortByPriceLH1(@RequestParam int offset,@RequestParam int limit){
		List<ARTIFICIAL_PLANT> list = apservice.getPlantByPriceLH(offset,limit);
	         if(list!=null)
	        	 return ResponseEntity.ok(list);
	         else 
	        	 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping("/artificial_plant/Availability_SORTBYPRICE_High_to_Low")
	public ResponseEntity<List<ARTIFICIAL_PLANT>> SortByPriceHL1(@RequestParam int offset,@RequestParam int limit){
		List<ARTIFICIAL_PLANT> list = apservice.getPlantByPriceHL(offset,limit);
	         if(list!=null)
	        	 return ResponseEntity.ok(list);
	         else 
	        	 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping("/artificial_plant/SORTBYPRICE_Low_TO_High")
	public ResponseEntity<List<ARTIFICIAL_PLANT>> SORTBYPRICE_L_H(@RequestParam int offset,@RequestParam int limit) {
		List<ARTIFICIAL_PLANT> slh = apservice.SORTBYPRICE_L_H(offset, limit);
		return ResponseEntity.ok(slh);
	}
	
	@GetMapping("/artificial_plant/SORTBYPRICE_High_TO_Low")
	public ResponseEntity<List<ARTIFICIAL_PLANT>> SORTBYPRICE_H_L(@RequestParam int offset,@RequestParam int limit) {
		List<ARTIFICIAL_PLANT> shl = apservice.SORTBYPRICE_H_L(offset, limit);
		return ResponseEntity.ok(shl);
	}
	
	
	@GetMapping("/artificial_plant/load/by_price_High_to_Low")
	public ResponseEntity<List<ARTIFICIAL_PLANT>> getLoadedPlantsFilterSortPHL1(@RequestParam int offset,@RequestParam int limit,@RequestParam double from,@RequestParam double to){
		List<ARTIFICIAL_PLANT> list = apservice.getLoadedPlantsFilterSortPHL1(offset,limit,from,to);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/artificial_plant/load/by_price_Low_to_High")
	public ResponseEntity<List<ARTIFICIAL_PLANT>> getLoadedPlantsFilterSortPLH1(@RequestParam int offset,@RequestParam int limit,@RequestParam double from,@RequestParam double to){
		List<ARTIFICIAL_PLANT> list = apservice.getLoadedPlantsFilterSortPLH1(offset,limit,from,to);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/artificial_plant/load/by_price_A_to_Z")
	public ResponseEntity<List<ARTIFICIAL_PLANT>> getLoadedPlantsFilterSortAZ1(@RequestParam int offset, @RequestParam int limit, @RequestParam double from,@RequestParam double to ){
		List<ARTIFICIAL_PLANT> list =apservice.getLoadedPlantsFilterSortAZ1(offset,limit,from,to);
		return ResponseEntity.ok(list);
	}
	@GetMapping("/artificial_plant/load/by_price_Z_to_A")
	public ResponseEntity<List<ARTIFICIAL_PLANT>> getLoadedPlantsFilterSortZA1(@RequestParam int offset, @RequestParam int limit, @RequestParam double from,@RequestParam double to ){
		List<ARTIFICIAL_PLANT> list =apservice.getLoadedPlantsFilterSortZA1(offset,limit,from,to);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/artificial_plant/load/by_rating_SORTBYPRICE_High_to_Low")
	public ResponseEntity<List<ARTIFICIAL_PLANT>> getLoadedPlantsFilterSortRHL2(@RequestParam int offset,@RequestParam int limit,@RequestParam double rating){
		List<ARTIFICIAL_PLANT> list = apservice.getLoadedPlantsFilterSortRHL2(offset,limit,rating);
		return ResponseEntity.ok(list);
	}
	@GetMapping("/artificial_plant/load/by_rating_SORTBYPRICE_Low_to_High")
	public ResponseEntity<List<ARTIFICIAL_PLANT>> getLoadedPlantsFilterSortRLH2(@RequestParam int offset,@RequestParam int limit,@RequestParam double rating){
		List<ARTIFICIAL_PLANT> list = apservice.getLoadedPlantsFilterSortRLH2(offset,limit,rating);
		return ResponseEntity.ok(list);
	}
	@GetMapping("/artificial_plant/load/by_rating_A_to_Z")
	public ResponseEntity<List<ARTIFICIAL_PLANT>> getLoadedPlantsFilterSortRAZ2(@RequestParam int offset,@RequestParam int limit,@RequestParam double rating){
		List<ARTIFICIAL_PLANT> list = apservice.getLoadedPlantsFilterSortRAZ2(offset,limit,rating);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/artificial_plant/load/by_rating_Z_to_A")
	public ResponseEntity<List<ARTIFICIAL_PLANT>> getLoadedPlantsFilterSortRZA2(@RequestParam int offset,@RequestParam int limit,@RequestParam double rating){
		List<ARTIFICIAL_PLANT> list = apservice.getLoadedPlantsFilterSortRZA2(offset,limit,rating);
		return ResponseEntity.ok(list);
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
