package com.demo.Service;

import java.util.List;

import com.demo.Model.Plant_Food;

public interface PlantFoodService {

	List<Plant_Food> getAllProducts();

	Plant_Food getById(String pfid);

	List<Plant_Food> sortA_Z(int offset, int limit);

	List<Plant_Food> sortZ_A(int offset, int limit);

	List<Plant_Food> Availability(int offset, int limit);

	List<Plant_Food> Availability_A_Z(int offset, int limit);

	List<Plant_Food> Availability_Z_A(int offset, int limit);

	List<Plant_Food> getPlantByAvailPriceLH(int offset, int limit);

	List<Plant_Food> getPlantByAvailPriceHL(int offset, int limit);

	List<Plant_Food> getAllPlantsFoodLoadedPrice(int offset, int limit, double from, double to);

	List<Plant_Food> getPlantFoodByPrice(int offset, int limit);

	List<Plant_Food> getPlantFoodByPriceHL(int offset, int limit);

	List<Plant_Food> getLoadedPlantsFoodFilterSortPHL1(int offset, int limit, double from, double to);

	List<Plant_Food> getLoadedPlantsFoodFilterSortPLH1(int offset, int limit, double from, double to);

	List<Plant_Food> getLoadedPlantsFoodFilterSortAZ1(int offset, int limit, double from, double to);

	List<Plant_Food> getLoadedPlantsFoodFilterSortZA1(int offset, int limit, double from, double to);

	List<Plant_Food> getLoadedPlantsFoodRating(int offset, int limit, double rating);

	List<Plant_Food> getLoadedPlantsFoodFilterSortRHL2(int offset, int limit, double rating);

	List<Plant_Food> getLoadedPlantsFoodFilterSortRLH2(int offset, int limit, double rating);

	List<Plant_Food> getLoadedPlantsFoodFilterSortRAZ2(int offset, int limit, double rating);

	List<Plant_Food> getLoadedPlantsFoodFilterSortRZA2(int offset, int limit, double rating);

	List<Plant_Food> getAllPlantFoodLoaded(int offset, int limit);
	
	List<Plant_Food> getAllPlantFoodsLoadedRating(int offset, int limit, double rating);
	
	List<Plant_Food> getAllPlantFoodsLoadedPrice(int offset, int limit, double from, double to);

	List<Plant_Food> getAllPlantFoodsLoadedRatingPrice(int offset, int limit, double rating, double from, double to);

	List<Plant_Food> getAllPlantFoodsLoadedRatingStock(int offset, int limit, double rating, int stock);

	List<Plant_Food> getAllPlantFoodLoadedPriceStock(int offset, int limit, double from, double to, int stock);

	List<Plant_Food> getAllPlantFoodsLoadedPriceStockRating(int offset, int limit, double from, double to, int stock,
			double rating);

	List<Plant_Food> getAllPlantFoodsLoadedRatingPriceSORTTITLE_A_Z(int offset, int limit, double rating, double from,
			double to);

	List<Plant_Food> getAllPlantFoodLoadedRatingPriceSORTTITLE_Z_A(int offset, int limit, double rating, double from,
			double to);

	List<Plant_Food> getAllPlantFoodLoadedRatingPriceSORTBYPRICE_L_TO_H(int offset, int limit, double rating,
			double from, double to);

	List<Plant_Food> getAllPlantFoodLoadedRatingPriceSORTBYPRICE_H_TO_L(int offset, int limit, double rating,
			double from, double to);

	List<Plant_Food> getAllPlantFoodLoadedRatingStockSORTTITLE_A_Z(int offset, int limit, double rating, int stock);

	List<Plant_Food> getAllPlantFoodLoadedRatingStockSORTTITLE_Z_A(int offset, int limit, double rating, int stock);

	List<Plant_Food> getAllPlantFoodLoadedRatingStockSORTBYPRICE_L_TO_H(int offset, int limit, double rating,
			int stock);

	List<Plant_Food> getAllPlantFoodLoadedRatingStockSORTBYPRICE_H_TO_L(int offset, int limit, double rating,
			int stock);

	List<Plant_Food> getAllPlantFoodLoadedPriceStockSORTTITLE_A_Z(int offset, int limit, double from, double to,
			int stock);

	List<Plant_Food> getAllPlantFoodLoadedPriceStockSORTTITLE_Z_A(int offset, int limit, double from, double to,
			int stock);

	List<Plant_Food> getAllPlantFoodLoadedPriceStockSORTBYPRICE_L_TO_H(int offset, int limit, double from, double to,
			int stock);

	List<Plant_Food> getAllPlantFoodLoadedPriceStockSORTBYPRICE_H_TO_L(int offset, int limit, double from, double to,
			int stock);

	List<Plant_Food> getAllPlantFoodLoadedPriceStockRatingSORTTITLE_A_Z(int offset, int limit, double from, double to,
			int stock, double rating);

	List<Plant_Food> getAllPlantFoodLoadedPriceStockRatingSORTTITLE_Z_A(int offset, int limit, double from, double to,
			int stock, double rating);

	List<Plant_Food> getAllPlantFoodLoadedPriceStockRatingSORTBYPRICE_L_TO_H(int offset, int limit, double from,
			double to, int stock, double rating);

	List<Plant_Food> getAllPlantFoodLoadedPriceStockRatingSORTBYPRICE_H_TO_L(int offset, int limit, double from,
			double to, int stock, double rating);
}