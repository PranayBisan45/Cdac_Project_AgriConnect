package com.demo.Service;

import java.util.List;

import com.demo.Model.SEED_BULB;

public interface SEED_BULB_SERVICE {
	
	List<SEED_BULB> getAllArtificialPlant();

	SEED_BULB getById1(String apid);

	List<SEED_BULB> getAllPotPlanterLoaded(int offset, int limit);

	List<SEED_BULB> getAllPotPlanterLoadedRating(int offset, int limit, double rating);

	List<SEED_BULB> getAllPotPlanterLoadedPrice(int offset, int limit, double price, double to);

	List<SEED_BULB> getAllPotPlanterLoadedRatingPrice(int offset, int limit, double rating, double from, double to);

	List<SEED_BULB> getAllPotPlanterLoadedRatingStock(int offset, int limit, double rating, int stock);

	List<SEED_BULB> getAllPotPlanterLoadedPriceStock(int offset, int limit, double from, double to, int stock);

	List<SEED_BULB> getAllPotPlanterLoadedPriceStockRating(int offset, int limit, double from, double to, int stock,
			double rating);

	List<SEED_BULB> getAllPotPlanterLoadedRatingPriceSORTTITLE_A_Z(int offset, int limit, double rating, double from,
			double to);

	List<SEED_BULB> getAllPotPlanterLoadedRatingPriceSORTTITLE_Z_A(int offset, int limit, double rating, double from,
			double to);

	List<SEED_BULB> getAllPotPlanterLoadedRatingPriceSORTBYPRICE_L_TO_H(int offset, int limit, double rating,
			double from, double to);

	List<SEED_BULB> getAllPotPlanterLoadedRatingPriceSORTBYPRICE_H_TO_L(int offset, int limit, double rating,
			double from, double to);

	List<SEED_BULB> getAllPotPlanterLoadedRatingStockSORTTITLE_A_Z(int offset, int limit, double rating, int stock);

	List<SEED_BULB> getAllPotPlanterLoadedRatingStockSORTTITLE_Z_A(int offset, int limit, double rating, int stock);

	List<SEED_BULB> getAllPotPlanterLoadedRatingStockSORTBYPRICE_L_TO_H(int offset, int limit, double rating,
			int stock);

	List<SEED_BULB> getAllPotPlanterLoadedRatingStockSORTBYPRICE_H_TO_L(int offset, int limit, double rating,
			int stock);

	List<SEED_BULB> getAllPotPlanterLoadedPriceStockSORTTITLE_A_Z(int offset, int limit, double from, double to,
			int stock);

	List<SEED_BULB> getAllPotPlanterLoadedPriceStockSORTTITLE_Z_A(int offset, int limit, double from, double to,
			int stock);

	List<SEED_BULB> getAllPotPlanterLoadedPriceStockSORTBYPRICE_L_TO_H(int offset, int limit, double from, double to,
			int stock);

	List<SEED_BULB> getAllPotPlanterLoadedPriceStockSORTBYPRICE_H_TO_L(int offset, int limit, double from, double to,
			int stock);

	List<SEED_BULB> getAllPotPlanterLoadedPriceStockRatingSORTTITLE_A_Z(int offset, int limit, double from,
			double to, int stock, double rating);

	List<SEED_BULB> getAllPotPlanterLoadedPriceStockRatingSORTTITLE_Z_A(int offset, int limit, double from,
			double to, int stock, double rating);

	List<SEED_BULB> getAllPotPlanterLoadedPriceStockRatingSORTBYPRICE_L_TO_H(int offset, int limit, double from,
			double to, int stock, double rating);

	List<SEED_BULB> getAllPotPlanterLoadedPriceStockRatingSORTBYPRICE_H_TO_L(int offset, int limit, double from,
			double to, int stock, double rating);

	

	List<SEED_BULB> Availability(int offset, int limit);

	List<SEED_BULB> sortA_Z(int offset, int limit);

	List<SEED_BULB> sortZ_A(int offset, int limit);

	List<SEED_BULB> Availability_A_Z(int offset, int limit);

	List<SEED_BULB> Availability_Z_A(int offset, int limit);

	List<SEED_BULB> getPlantByPriceLH(int offset, int limit);

	List<SEED_BULB> getPlantByPriceHL(int offset, int limit);

	List<SEED_BULB> SORTBYPRICE_L_H(int offset, int limit);

	List<SEED_BULB> SORTBYPRICE_H_L(int offset, int limit);

	List<SEED_BULB> getLoadedPlantsFilterSortPHL1(int offset, int limit, double from, double to);

	List<SEED_BULB> getLoadedPlantsFilterSortPLH1(int offset, int limit, double from, double to);

	List<SEED_BULB> getLoadedPlantsFilterSortAZ1(int offset, int limit, double from, double to);

	List<SEED_BULB> getLoadedPlantsFilterSortZA1(int offset, int limit, double from, double to);

	List<SEED_BULB> getLoadedPlantsFilterSortRHL2(int offset, int limit, double rating);

	List<SEED_BULB> getLoadedPlantsFilterSortRLH2(int offset, int limit, double rating);

	List<SEED_BULB> getLoadedPlantsFilterSortRAZ2(int offset, int limit, double rating);

	List<SEED_BULB> getLoadedPlantsFilterSortRZA2(int offset, int limit, double rating);


}
