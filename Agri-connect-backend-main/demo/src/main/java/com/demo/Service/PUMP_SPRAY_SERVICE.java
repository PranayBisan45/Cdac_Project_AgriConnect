package com.demo.Service;

import java.util.List;

import com.demo.Model.PUMP_SPRAY;

public interface PUMP_SPRAY_SERVICE {
	
	
	List<PUMP_SPRAY> getAllArtificialPlant();

	PUMP_SPRAY getById1(String apid);

	List<PUMP_SPRAY> getAllPotPlanterLoaded(int offset, int limit);

	List<PUMP_SPRAY> getAllPotPlanterLoadedRating(int offset, int limit, double rating);

	List<PUMP_SPRAY> getAllPotPlanterLoadedPrice(int offset, int limit, double price, double to);

	List<PUMP_SPRAY> getAllPotPlanterLoadedRatingPrice(int offset, int limit, double rating, double from, double to);

	List<PUMP_SPRAY> getAllPotPlanterLoadedRatingStock(int offset, int limit, double rating, int stock);

	List<PUMP_SPRAY> getAllPotPlanterLoadedPriceStock(int offset, int limit, double from, double to, int stock);

	List<PUMP_SPRAY> getAllPotPlanterLoadedPriceStockRating(int offset, int limit, double from, double to, int stock,
			double rating);

	List<PUMP_SPRAY> getAllPotPlanterLoadedRatingPriceSORTTITLE_A_Z(int offset, int limit, double rating, double from,
			double to);

	List<PUMP_SPRAY> getAllPotPlanterLoadedRatingPriceSORTTITLE_Z_A(int offset, int limit, double rating, double from,
			double to);

	List<PUMP_SPRAY> getAllPotPlanterLoadedRatingPriceSORTBYPRICE_L_TO_H(int offset, int limit, double rating,
			double from, double to);

	List<PUMP_SPRAY> getAllPotPlanterLoadedRatingPriceSORTBYPRICE_H_TO_L(int offset, int limit, double rating,
			double from, double to);

	List<PUMP_SPRAY> getAllPotPlanterLoadedRatingStockSORTTITLE_A_Z(int offset, int limit, double rating, int stock);

	List<PUMP_SPRAY> getAllPotPlanterLoadedRatingStockSORTTITLE_Z_A(int offset, int limit, double rating, int stock);

	List<PUMP_SPRAY> getAllPotPlanterLoadedRatingStockSORTBYPRICE_L_TO_H(int offset, int limit, double rating,
			int stock);

	List<PUMP_SPRAY> getAllPotPlanterLoadedRatingStockSORTBYPRICE_H_TO_L(int offset, int limit, double rating,
			int stock);

	List<PUMP_SPRAY> getAllPotPlanterLoadedPriceStockSORTTITLE_A_Z(int offset, int limit, double from, double to,
			int stock);

	List<PUMP_SPRAY> getAllPotPlanterLoadedPriceStockSORTTITLE_Z_A(int offset, int limit, double from, double to,
			int stock);

	List<PUMP_SPRAY> getAllPotPlanterLoadedPriceStockSORTBYPRICE_L_TO_H(int offset, int limit, double from, double to,
			int stock);

	List<PUMP_SPRAY> getAllPotPlanterLoadedPriceStockSORTBYPRICE_H_TO_L(int offset, int limit, double from, double to,
			int stock);

	List<PUMP_SPRAY> getAllPotPlanterLoadedPriceStockRatingSORTTITLE_A_Z(int offset, int limit, double from,
			double to, int stock, double rating);

	List<PUMP_SPRAY> getAllPotPlanterLoadedPriceStockRatingSORTTITLE_Z_A(int offset, int limit, double from,
			double to, int stock, double rating);

	List<PUMP_SPRAY> getAllPotPlanterLoadedPriceStockRatingSORTBYPRICE_L_TO_H(int offset, int limit, double from,
			double to, int stock, double rating);

	List<PUMP_SPRAY> getAllPotPlanterLoadedPriceStockRatingSORTBYPRICE_H_TO_L(int offset, int limit, double from,
			double to, int stock, double rating);

	

	List<PUMP_SPRAY> Availability(int offset, int limit);

	List<PUMP_SPRAY> sortA_Z(int offset, int limit);

	List<PUMP_SPRAY> sortZ_A(int offset, int limit);

	List<PUMP_SPRAY> Availability_A_Z(int offset, int limit);

	List<PUMP_SPRAY> Availability_Z_A(int offset, int limit);

	List<PUMP_SPRAY> getPlantByPriceLH(int offset, int limit);

	List<PUMP_SPRAY> getPlantByPriceHL(int offset, int limit);

	List<PUMP_SPRAY> SORTBYPRICE_L_H(int offset, int limit);

	List<PUMP_SPRAY> SORTBYPRICE_H_L(int offset, int limit);

	List<PUMP_SPRAY> getLoadedPlantsFilterSortPHL1(int offset, int limit, double from, double to);

	List<PUMP_SPRAY> getLoadedPlantsFilterSortPLH1(int offset, int limit, double from, double to);

	List<PUMP_SPRAY> getLoadedPlantsFilterSortAZ1(int offset, int limit, double from, double to);

	List<PUMP_SPRAY> getLoadedPlantsFilterSortZA1(int offset, int limit, double from, double to);

	List<PUMP_SPRAY> getLoadedPlantsFilterSortRHL2(int offset, int limit, double rating);

	List<PUMP_SPRAY> getLoadedPlantsFilterSortRLH2(int offset, int limit, double rating);

	List<PUMP_SPRAY> getLoadedPlantsFilterSortRAZ2(int offset, int limit, double rating);

	List<PUMP_SPRAY> getLoadedPlantsFilterSortRZA2(int offset, int limit, double rating);


}
