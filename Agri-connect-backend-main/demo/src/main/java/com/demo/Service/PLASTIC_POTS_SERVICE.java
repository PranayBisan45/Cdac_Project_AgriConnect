package com.demo.Service;

import java.util.List;

import com.demo.Model.PLASTIC_POTS;

public interface PLASTIC_POTS_SERVICE {
	List<PLASTIC_POTS> getAllPotPlanter();

	List<PLASTIC_POTS> getAllPotPlanterLoaded(int offset, int limit);

	List<PLASTIC_POTS> getAllPotPlanterLoadedRating(int offset, int limit, double rating);

	List<PLASTIC_POTS> getAllPotPlanterLoadedPrice(int offset, int limit, double price, double to);

	List<PLASTIC_POTS> getAllPotPlanterLoadedRatingPrice(int offset, int limit, double rating, double from, double to);

	List<PLASTIC_POTS> getAllPotPlanterLoadedRatingStock(int offset, int limit, double rating, int stock);

	List<PLASTIC_POTS> getAllPotPlanterLoadedPriceStock(int offset, int limit, double from, double to, int stock);

	List<PLASTIC_POTS> getAllPotPlanterLoadedPriceStockRating(int offset, int limit, double from, double to, int stock,
			double rating);

	List<PLASTIC_POTS> getAllPotPlanterLoadedRatingPriceSORTTITLE_A_Z(int offset, int limit, double rating, double from,
			double to);

	List<PLASTIC_POTS> getAllPotPlanterLoadedRatingPriceSORTTITLE_Z_A(int offset, int limit, double rating, double from,
			double to);

	List<PLASTIC_POTS> getAllPotPlanterLoadedRatingPriceSORTBYPRICE_L_TO_H(int offset, int limit, double rating,
			double from, double to);

	List<PLASTIC_POTS> getAllPotPlanterLoadedRatingPriceSORTBYPRICE_H_TO_L(int offset, int limit, double rating,
			double from, double to);

	List<PLASTIC_POTS> getAllPotPlanterLoadedRatingStockSORTTITLE_A_Z(int offset, int limit, double rating, int stock);

	List<PLASTIC_POTS> getAllPotPlanterLoadedRatingStockSORTTITLE_Z_A(int offset, int limit, double rating, int stock);

	List<PLASTIC_POTS> getAllPotPlanterLoadedRatingStockSORTBYPRICE_L_TO_H(int offset, int limit, double rating,
			int stock);

	List<PLASTIC_POTS> getAllPotPlanterLoadedRatingStockSORTBYPRICE_H_TO_L(int offset, int limit, double rating,
			int stock);

	List<PLASTIC_POTS> getAllPotPlanterLoadedPriceStockSORTTITLE_A_Z(int offset, int limit, double from, double to,
			int stock);

	List<PLASTIC_POTS> getAllPotPlanterLoadedPriceStockSORTTITLE_Z_A(int offset, int limit, double from, double to,
			int stock);

	List<PLASTIC_POTS> getAllPotPlanterLoadedPriceStockSORTBYPRICE_L_TO_H(int offset, int limit, double from, double to,
			int stock);

	List<PLASTIC_POTS> getAllPotPlanterLoadedPriceStockSORTBYPRICE_H_TO_L(int offset, int limit, double from, double to,
			int stock);

	List<PLASTIC_POTS> getAllPotPlanterLoadedPriceStockRatingSORTTITLE_A_Z(int offset, int limit, double from,
			double to, int stock, double rating);

	List<PLASTIC_POTS> getAllPotPlanterLoadedPriceStockRatingSORTTITLE_Z_A(int offset, int limit, double from,
			double to, int stock, double rating);

	List<PLASTIC_POTS> getAllPotPlanterLoadedPriceStockRatingSORTBYPRICE_L_TO_H(int offset, int limit, double from,
			double to, int stock, double rating);

	List<PLASTIC_POTS> getAllPotPlanterLoadedPriceStockRatingSORTBYPRICE_H_TO_L(int offset, int limit, double from,
			double to, int stock, double rating);

	PLASTIC_POTS getById(String ppid);

	List<PLASTIC_POTS> Availability(int offset, int limit);

	List<PLASTIC_POTS> sortA_Z(int offset, int limit);

	List<PLASTIC_POTS> sortZ_A(int offset, int limit);

	List<PLASTIC_POTS> Availability_A_Z(int offset, int limit);

	List<PLASTIC_POTS> Availability_Z_A(int offset, int limit);

	List<PLASTIC_POTS> getPlantByPriceLH(int offset, int limit);

	List<PLASTIC_POTS> getPlantByPriceHL(int offset, int limit);

	List<PLASTIC_POTS> SORTBYPRICE_L_H(int offset, int limit);

	List<PLASTIC_POTS> SORTBYPRICE_H_L(int offset, int limit);

	List<PLASTIC_POTS> getLoadedPlantsFilterSortPHL1(int offset, int limit, double from, double to);

	List<PLASTIC_POTS> getLoadedPlantsFilterSortPLH1(int offset, int limit, double from, double to);

	List<PLASTIC_POTS> getLoadedPlantsFilterSortAZ1(int offset, int limit, double from, double to);

	List<PLASTIC_POTS> getLoadedPlantsFilterSortZA1(int offset, int limit, double from, double to);

	List<PLASTIC_POTS> getLoadedPlantsFilterSortRHL2(int offset, int limit, double rating);

	List<PLASTIC_POTS> getLoadedPlantsFilterSortRLH2(int offset, int limit, double rating);

	List<PLASTIC_POTS> getLoadedPlantsFilterSortRAZ2(int offset, int limit, double rating);

	List<PLASTIC_POTS> getLoadedPlantsFilterSortRZA2(int offset, int limit, double rating);

}
