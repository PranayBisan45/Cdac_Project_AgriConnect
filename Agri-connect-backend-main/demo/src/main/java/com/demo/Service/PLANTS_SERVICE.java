package com.demo.Service;

import java.util.List;

import com.demo.Model.PLANTS;

public interface PLANTS_SERVICE {
		
	List<PLANTS> getAllPotPlanter();

	List<PLANTS> getAllPotPlanterLoaded(int offset, int limit);

	List<PLANTS> getAllPotPlanterLoadedRating(int offset, int limit, double rating);

	List<PLANTS> getAllPotPlanterLoadedPrice(int offset, int limit, double price, double to);

	List<PLANTS> getAllPotPlanterLoadedRatingPrice(int offset, int limit, double rating, double from, double to);

	List<PLANTS> getAllPotPlanterLoadedRatingStock(int offset, int limit, double rating, int stock);

	List<PLANTS> getAllPotPlanterLoadedPriceStock(int offset, int limit, double from, double to, int stock);

	List<PLANTS> getAllPotPlanterLoadedPriceStockRating(int offset, int limit, double from, double to, int stock,
			double rating);

	List<PLANTS> getAllPotPlanterLoadedRatingPriceSORTTITLE_A_Z(int offset, int limit, double rating, double from,
			double to);

	List<PLANTS> getAllPotPlanterLoadedRatingPriceSORTTITLE_Z_A(int offset, int limit, double rating, double from,
			double to);

	List<PLANTS> getAllPotPlanterLoadedRatingPriceSORTBYPRICE_L_TO_H(int offset, int limit, double rating,
			double from, double to);

	List<PLANTS> getAllPotPlanterLoadedRatingPriceSORTBYPRICE_H_TO_L(int offset, int limit, double rating,
			double from, double to);

	List<PLANTS> getAllPotPlanterLoadedRatingStockSORTTITLE_A_Z(int offset, int limit, double rating, int stock);

	List<PLANTS> getAllPotPlanterLoadedRatingStockSORTTITLE_Z_A(int offset, int limit, double rating, int stock);

	List<PLANTS> getAllPotPlanterLoadedRatingStockSORTBYPRICE_L_TO_H(int offset, int limit, double rating,
			int stock);

	List<PLANTS> getAllPotPlanterLoadedRatingStockSORTBYPRICE_H_TO_L(int offset, int limit, double rating,
			int stock);

	List<PLANTS> getAllPotPlanterLoadedPriceStockSORTTITLE_A_Z(int offset, int limit, double from, double to,
			int stock);

	List<PLANTS> getAllPotPlanterLoadedPriceStockSORTTITLE_Z_A(int offset, int limit, double from, double to,
			int stock);

	List<PLANTS> getAllPotPlanterLoadedPriceStockSORTBYPRICE_L_TO_H(int offset, int limit, double from, double to,
			int stock);

	List<PLANTS> getAllPotPlanterLoadedPriceStockSORTBYPRICE_H_TO_L(int offset, int limit, double from, double to,
			int stock);

	List<PLANTS> getAllPotPlanterLoadedPriceStockRatingSORTTITLE_A_Z(int offset, int limit, double from,
			double to, int stock, double rating);

	List<PLANTS> getAllPotPlanterLoadedPriceStockRatingSORTTITLE_Z_A(int offset, int limit, double from,
			double to, int stock, double rating);

	List<PLANTS> getAllPotPlanterLoadedPriceStockRatingSORTBYPRICE_L_TO_H(int offset, int limit, double from,
			double to, int stock, double rating);

	List<PLANTS> getAllPotPlanterLoadedPriceStockRatingSORTBYPRICE_H_TO_L(int offset, int limit, double from,
			double to, int stock, double rating);

	PLANTS getById(String ppid);

	List<PLANTS> Availability(int offset, int limit);

	List<PLANTS> sortA_Z(int offset, int limit);

	List<PLANTS> sortZ_A(int offset, int limit);

	List<PLANTS> Availability_A_Z(int offset, int limit);

	List<PLANTS> Availability_Z_A(int offset, int limit);

	List<PLANTS> getPlantByPriceLH(int offset, int limit);

	List<PLANTS> getPlantByPriceHL(int offset, int limit);

	List<PLANTS> SORTBYPRICE_L_H(int offset, int limit);

	List<PLANTS> SORTBYPRICE_H_L(int offset, int limit);

	List<PLANTS> getLoadedPlantsFilterSortPHL1(int offset, int limit, double from, double to);

	List<PLANTS> getLoadedPlantsFilterSortPLH1(int offset, int limit, double from, double to);

	List<PLANTS> getLoadedPlantsFilterSortAZ1(int offset, int limit, double from, double to);

	List<PLANTS> getLoadedPlantsFilterSortZA1(int offset, int limit, double from, double to);

	List<PLANTS> getLoadedPlantsFilterSortRHL2(int offset, int limit, double rating);

	List<PLANTS> getLoadedPlantsFilterSortRLH2(int offset, int limit, double rating);

	List<PLANTS> getLoadedPlantsFilterSortRAZ2(int offset, int limit, double rating);

	List<PLANTS> getLoadedPlantsFilterSortRZA2(int offset, int limit, double rating);
}
