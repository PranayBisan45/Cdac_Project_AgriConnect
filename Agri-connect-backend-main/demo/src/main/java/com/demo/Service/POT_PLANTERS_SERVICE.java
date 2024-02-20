package com.demo.Service;

import java.util.List;

import com.demo.Model.POT_PLANTERS;

public interface POT_PLANTERS_SERVICE {

	List<POT_PLANTERS> getAllPotPlanter();

	List<POT_PLANTERS> getAllPotPlanterLoaded(int offset, int limit);

	List<POT_PLANTERS> getAllPotPlanterLoadedRating(int offset, int limit, double rating);

	List<POT_PLANTERS> getAllPotPlanterLoadedPrice(int offset, int limit, double price, double to);

	List<POT_PLANTERS> getAllPotPlanterLoadedRatingPrice(int offset, int limit, double rating, double from, double to);

	List<POT_PLANTERS> getAllPotPlanterLoadedRatingStock(int offset, int limit, double rating, int stock);

	List<POT_PLANTERS> getAllPotPlanterLoadedPriceStock(int offset, int limit, double from, double to, int stock);

	List<POT_PLANTERS> getAllPotPlanterLoadedPriceStockRating(int offset, int limit, double from, double to, int stock,
			double rating);

	List<POT_PLANTERS> getAllPotPlanterLoadedRatingPriceSORTTITLE_A_Z(int offset, int limit, double rating, double from,
			double to);

	List<POT_PLANTERS> getAllPotPlanterLoadedRatingPriceSORTTITLE_Z_A(int offset, int limit, double rating, double from,
			double to);

	List<POT_PLANTERS> getAllPotPlanterLoadedRatingPriceSORTBYPRICE_L_TO_H(int offset, int limit, double rating,
			double from, double to);

	List<POT_PLANTERS> getAllPotPlanterLoadedRatingPriceSORTBYPRICE_H_TO_L(int offset, int limit, double rating,
			double from, double to);

	List<POT_PLANTERS> getAllPotPlanterLoadedRatingStockSORTTITLE_A_Z(int offset, int limit, double rating, int stock);

	List<POT_PLANTERS> getAllPotPlanterLoadedRatingStockSORTTITLE_Z_A(int offset, int limit, double rating, int stock);

	List<POT_PLANTERS> getAllPotPlanterLoadedRatingStockSORTBYPRICE_L_TO_H(int offset, int limit, double rating,
			int stock);

	List<POT_PLANTERS> getAllPotPlanterLoadedRatingStockSORTBYPRICE_H_TO_L(int offset, int limit, double rating,
			int stock);

	List<POT_PLANTERS> getAllPotPlanterLoadedPriceStockSORTTITLE_A_Z(int offset, int limit, double from, double to,
			int stock);

	List<POT_PLANTERS> getAllPotPlanterLoadedPriceStockSORTTITLE_Z_A(int offset, int limit, double from, double to,
			int stock);

	List<POT_PLANTERS> getAllPotPlanterLoadedPriceStockSORTBYPRICE_L_TO_H(int offset, int limit, double from, double to,
			int stock);

	List<POT_PLANTERS> getAllPotPlanterLoadedPriceStockSORTBYPRICE_H_TO_L(int offset, int limit, double from, double to,
			int stock);

	List<POT_PLANTERS> getAllPotPlanterLoadedPriceStockRatingSORTTITLE_A_Z(int offset, int limit, double from,
			double to, int stock, double rating);

	List<POT_PLANTERS> getAllPotPlanterLoadedPriceStockRatingSORTTITLE_Z_A(int offset, int limit, double from,
			double to, int stock, double rating);

	List<POT_PLANTERS> getAllPotPlanterLoadedPriceStockRatingSORTBYPRICE_L_TO_H(int offset, int limit, double from,
			double to, int stock, double rating);

	List<POT_PLANTERS> getAllPotPlanterLoadedPriceStockRatingSORTBYPRICE_H_TO_L(int offset, int limit, double from,
			double to, int stock, double rating);

	POT_PLANTERS getById(String ppid);

	List<POT_PLANTERS> Availability(int offset, int limit);

	List<POT_PLANTERS> sortA_Z(int offset, int limit);

	List<POT_PLANTERS> sortZ_A(int offset, int limit);

	List<POT_PLANTERS> Availability_A_Z(int offset, int limit);

	List<POT_PLANTERS> Availability_Z_A(int offset, int limit);

	List<POT_PLANTERS> getPlantByPriceLH(int offset, int limit);

	List<POT_PLANTERS> getPlantByPriceHL(int offset, int limit);

	List<POT_PLANTERS> SORTBYPRICE_L_H(int offset, int limit);

	List<POT_PLANTERS> SORTBYPRICE_H_L(int offset, int limit);

	List<POT_PLANTERS> getLoadedPlantsFilterSortPHL1(int offset, int limit, double from, double to);

	List<POT_PLANTERS> getLoadedPlantsFilterSortPLH1(int offset, int limit, double from, double to);

	List<POT_PLANTERS> getLoadedPlantsFilterSortAZ1(int offset, int limit, double from, double to);

	List<POT_PLANTERS> getLoadedPlantsFilterSortZA1(int offset, int limit, double from, double to);

	List<POT_PLANTERS> getLoadedPlantsFilterSortRHL2(int offset, int limit, double rating);

	List<POT_PLANTERS> getLoadedPlantsFilterSortRLH2(int offset, int limit, double rating);

	List<POT_PLANTERS> getLoadedPlantsFilterSortRAZ2(int offset, int limit, double rating);

	List<POT_PLANTERS> getLoadedPlantsFilterSortRZA2(int offset, int limit, double rating);



																															

}
