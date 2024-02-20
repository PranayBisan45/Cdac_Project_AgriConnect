package com.demo.Service;

import java.util.List;

import com.demo.Model.PEBBLES_AND_STONES;

public interface PEBBLES_AND_STONES_SERVICE {
	
	List<PEBBLES_AND_STONES> getAllArtificialPlant();

	PEBBLES_AND_STONES getById1(String apid);

	List<PEBBLES_AND_STONES> getAllPotPlanterLoaded(int offset, int limit);

	List<PEBBLES_AND_STONES> getAllPotPlanterLoadedRating(int offset, int limit, double rating);

	List<PEBBLES_AND_STONES> getAllPotPlanterLoadedPrice(int offset, int limit, double price, double to);

	List<PEBBLES_AND_STONES> getAllPotPlanterLoadedRatingPrice(int offset, int limit, double rating, double from, double to);

	List<PEBBLES_AND_STONES> getAllPotPlanterLoadedRatingStock(int offset, int limit, double rating, int stock);

	List<PEBBLES_AND_STONES> getAllPotPlanterLoadedPriceStock(int offset, int limit, double from, double to, int stock);

	List<PEBBLES_AND_STONES> getAllPotPlanterLoadedPriceStockRating(int offset, int limit, double from, double to, int stock,
			double rating);

	List<PEBBLES_AND_STONES> getAllPotPlanterLoadedRatingPriceSORTTITLE_A_Z(int offset, int limit, double rating, double from,
			double to);

	List<PEBBLES_AND_STONES> getAllPotPlanterLoadedRatingPriceSORTTITLE_Z_A(int offset, int limit, double rating, double from,
			double to);

	List<PEBBLES_AND_STONES> getAllPotPlanterLoadedRatingPriceSORTBYPRICE_L_TO_H(int offset, int limit, double rating,
			double from, double to);

	List<PEBBLES_AND_STONES> getAllPotPlanterLoadedRatingPriceSORTBYPRICE_H_TO_L(int offset, int limit, double rating,
			double from, double to);

	List<PEBBLES_AND_STONES> getAllPotPlanterLoadedRatingStockSORTTITLE_A_Z(int offset, int limit, double rating, int stock);

	List<PEBBLES_AND_STONES> getAllPotPlanterLoadedRatingStockSORTTITLE_Z_A(int offset, int limit, double rating, int stock);

	List<PEBBLES_AND_STONES> getAllPotPlanterLoadedRatingStockSORTBYPRICE_L_TO_H(int offset, int limit, double rating,
			int stock);

	List<PEBBLES_AND_STONES> getAllPotPlanterLoadedRatingStockSORTBYPRICE_H_TO_L(int offset, int limit, double rating,
			int stock);

	List<PEBBLES_AND_STONES> getAllPotPlanterLoadedPriceStockSORTTITLE_A_Z(int offset, int limit, double from, double to,
			int stock);

	List<PEBBLES_AND_STONES> getAllPotPlanterLoadedPriceStockSORTTITLE_Z_A(int offset, int limit, double from, double to,
			int stock);

	List<PEBBLES_AND_STONES> getAllPotPlanterLoadedPriceStockSORTBYPRICE_L_TO_H(int offset, int limit, double from, double to,
			int stock);

	List<PEBBLES_AND_STONES> getAllPotPlanterLoadedPriceStockSORTBYPRICE_H_TO_L(int offset, int limit, double from, double to,
			int stock);

	List<PEBBLES_AND_STONES> getAllPotPlanterLoadedPriceStockRatingSORTTITLE_A_Z(int offset, int limit, double from,
			double to, int stock, double rating);

	List<PEBBLES_AND_STONES> getAllPotPlanterLoadedPriceStockRatingSORTTITLE_Z_A(int offset, int limit, double from,
			double to, int stock, double rating);

	List<PEBBLES_AND_STONES> getAllPotPlanterLoadedPriceStockRatingSORTBYPRICE_L_TO_H(int offset, int limit, double from,
			double to, int stock, double rating);

	List<PEBBLES_AND_STONES> getAllPotPlanterLoadedPriceStockRatingSORTBYPRICE_H_TO_L(int offset, int limit, double from,
			double to, int stock, double rating);

	

	List<PEBBLES_AND_STONES> Availability(int offset, int limit);

	List<PEBBLES_AND_STONES> sortA_Z(int offset, int limit);

	List<PEBBLES_AND_STONES> sortZ_A(int offset, int limit);

	List<PEBBLES_AND_STONES> Availability_A_Z(int offset, int limit);

	List<PEBBLES_AND_STONES> Availability_Z_A(int offset, int limit);

	List<PEBBLES_AND_STONES> getPlantByPriceLH(int offset, int limit);

	List<PEBBLES_AND_STONES> getPlantByPriceHL(int offset, int limit);

	List<PEBBLES_AND_STONES> SORTBYPRICE_L_H(int offset, int limit);

	List<PEBBLES_AND_STONES> SORTBYPRICE_H_L(int offset, int limit);

	List<PEBBLES_AND_STONES> getLoadedPlantsFilterSortPHL1(int offset, int limit, double from, double to);

	List<PEBBLES_AND_STONES> getLoadedPlantsFilterSortPLH1(int offset, int limit, double from, double to);

	List<PEBBLES_AND_STONES> getLoadedPlantsFilterSortAZ1(int offset, int limit, double from, double to);

	List<PEBBLES_AND_STONES> getLoadedPlantsFilterSortZA1(int offset, int limit, double from, double to);

	List<PEBBLES_AND_STONES> getLoadedPlantsFilterSortRHL2(int offset, int limit, double rating);

	List<PEBBLES_AND_STONES> getLoadedPlantsFilterSortRLH2(int offset, int limit, double rating);

	List<PEBBLES_AND_STONES> getLoadedPlantsFilterSortRAZ2(int offset, int limit, double rating);

	List<PEBBLES_AND_STONES> getLoadedPlantsFilterSortRZA2(int offset, int limit, double rating);


}
