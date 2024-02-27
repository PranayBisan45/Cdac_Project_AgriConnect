package com.demo.Dao;

import java.util.List;

import com.demo.Model.Plant_Food;

public interface PlantFoodDao {
	
	List<Plant_Food> getAllProducts();

	Plant_Food findById(String pfid);

	List<Plant_Food> sortA_Z(int offset, int limit);

	List<Plant_Food> sortZ_A(int offset, int limit);

	List<Plant_Food> Availability(int offset, int limit);

	List<Plant_Food> Avail_A_Z(int offset, int limit);

	List<Plant_Food> Avail_Z_A(int offset, int limit);

	List<Plant_Food> getPlantsAvailByPriceLH(int offset, int limit);

	List<Plant_Food> getPlantsAvailByPriceHL(int offset, int limit);

	List<Plant_Food> getPlantsFoodByPrice(int offset, int limit);

	List<Plant_Food> getPlantsFoodByPriceHL(int offset, int limit);

	List<Plant_Food> getLoadedPlantsFilterSortPHL1(int offset, int limit, double from, double to);

	List<Plant_Food> getLoadedPlantsFoodFilterSortPLH1(int offset, int limit, double from, double to);

	List<Plant_Food> getLoadedPlantFoodFilterSortAZ1(int offset, int limit, double from, double to);

	List<Plant_Food> getLoadedPlantFoodFilterSortZA1(int offset, int limit, double from, double to);

	List<Plant_Food> getLoadedPlantsFoodRating(int offset, int limit, double rating);

	List<Plant_Food> getLoadedPlantsFoodFilterSortRHL2(int offset, int limit, double rating);

	List<Plant_Food> getLoadedPlantsFoodFilterSortRLH2(int offset, int limit, double rating);

	List<Plant_Food> getLoadedPlantsFoodFilterSortRAZ2(int offset, int limit, double rating);

	List<Plant_Food> getLoadedPlantsFoodFilterSortRZA2(int offset, int limit, double rating);

	List<Plant_Food> getLoadedPf(int offset, int limit);

	List<Plant_Food> getAllPlantFoodsLoadedByRating(int offset, int limit, double rating);
	
	List<Plant_Food> getAllPlantFoodsLoadedByPrice(int offset, int limit, double from, double to);

	List<Plant_Food> getAllPlantFoodsLoadedByRatingPrice(int offset, int limit, double rating, double from, double to);

	List<Plant_Food> getAllPlantFoodsLoadedByRatingStock(int offset, int limit, double rating, int stock);

	List<Plant_Food> getAllPlantFoodsLoadedByPriceStock(int offset, int limit, double from, double to, int stock);

	List<Plant_Food> getAllPlantFoodsLoadedByPriceStockRating(int offset, int limit, double from, double to, int stock,
			double rating);

	List<Plant_Food> getAllPlantFoodLoadedByRatingPriceSORTTITLE_A_Z(int offset, int limit, double rating, double from,
			double to);

	List<Plant_Food> getAllPlantFoodLoadedByRatingPriceSORTTITLE_Z_A(int offset, int limit, double rating, double from,
			double to);

	List<Plant_Food> getAllPlantFoodLoadedByRatingPriceSORTPRICE_L_H(int offset, int limit, double rating, double from,
			double to);

	List<Plant_Food> getAllPlantFoodLoadedByRatingPriceSORTPRICE_H_L(int offset, int limit, double rating, double from,
			double to);

	List<Plant_Food> getAllPlantFoodLoadedByRatingStockSORTTITLE_A_Z(int offset, int limit, double rating, int stock);

	List<Plant_Food> getAllPlantFoodLoadedByRatingStockSORTTITLE_Z_A(int offset, int limit, double rating, int stock);

	List<Plant_Food> getAllPlantFoodLoadedByRatingStockSORTPRICE_L_H(int offset, int limit, double rating, int stock);

	List<Plant_Food> getAllPlantFoodLoadedByRatingStockSORTPRICE_H_L(int offset, int limit, double rating, int stock);

	List<Plant_Food> getAllPlantFoodLoadedByPriceStockSORTTITLE_A_Z(int offset, int limit, double from, double to,
			int stock);

	List<Plant_Food> getAllPlantFoodLoadedByPriceStockSORTTITLE_Z_A(int offset, int limit, double from, double to,
			int stock);

	List<Plant_Food> getAllPlantFoodLoadedByPriceStockSORTPRICE_L_H(int offset, int limit, double from, double to,
			int stock);

	List<Plant_Food> getAllPlantFoodLoadedByPriceStockSORTPRICE_H_L(int offset, int limit, double from, double to,
			int stock);

	List<Plant_Food> getAllPlantFoodLoadedByPriceStockRatingSORTTITLE_A_Z(int offset, int limit, double from, double to,
			int stock, double rating);

	List<Plant_Food> getAllPlantFoodLoadedByPriceStockRatingSORTTITLE_Z_A(int offset, int limit, double from, double to,
			int stock, double rating);

	List<Plant_Food> getAllPlantFoodLoadedByPriceStockRatingSORTPRICE_L_H(int offset, int limit, double from, double to,
			int stock, double rating);

	List<Plant_Food> getAllPlantFoodLoadedByPriceStockRatingSORTPRICE_H_L(int offset, int limit, double from, double to,
			int stock, double rating);

}