package com.demo.Dao;

import java.util.List;

import com.demo.Model.SEED_BULB;

public interface SEED_BULB_DAO {

	
	List<SEED_BULB> getallartificialplant();

	SEED_BULB getbyid(String apid);

	List<SEED_BULB> getAllPotPlanterLoaded(int offset, int limit);

	List<SEED_BULB> getallpotplanterloadedrating(int offset, int limit, double rating);
	
	List<SEED_BULB> getAllPotPlanterLoadedByPrice(int offset, int limit, double price, double to);

	List<SEED_BULB> getAllPotPlanterLoadedByRatingPrice(int offset, int limit, double rating, double from, double to);

	List<SEED_BULB> getAllPotPlanterLoadedByRatingStock(int offset, int limit, double rating, int stock);

	List<SEED_BULB> getAllPotPlanterLoadedByPriceStock(int offset, int limit, double from, double to, int stock);

	List<SEED_BULB> getAllPotPlanterLoadedByPriceStockRating(int offset, int limit, double from, double to,
			int stock, double rating);

	List<SEED_BULB> getAllPotPlanterLoadedByRatingPriceSORTTITLE_A_Z(int offset, int limit, double rating,
			double from, double to);

	List<SEED_BULB> getAllPotPlanterLoadedByRatingPriceSORTTITLE_Z_A(int offset, int limit, double rating,
			double from, double to);

	List<SEED_BULB> getAllPotPlanterLoadedByRatingPriceSORTPRICE_L_H(int offset, int limit, double rating,
			double from, double to);

	List<SEED_BULB> getAllPotPlanterLoadedByRatingPriceSORTPRICE_H_L(int offset, int limit, double rating,
			double from, double to);

	List<SEED_BULB> getAllPotPlanterLoadedByRatingStockSORTTITLE_A_Z(int offset, int limit, double rating,
			int stock);

	List<SEED_BULB> getAllPotPlanterLoadedByRatingStockSORTTITLE_Z_A(int offset, int limit, double rating,
			int stock);

	List<SEED_BULB> getAllPotPlanterLoadedByRatingStockSORTPRICE_L_H(int offset, int limit, double rating,
			int stock);

	List<SEED_BULB> getAllPotPlanterLoadedByRatingStockSORTPRICE_H_L(int offset, int limit, double rating,
			int stock);

	List<SEED_BULB> getAllPotPlanterLoadedByPriceStockSORTTITLE_A_Z(int offset, int limit, double from, double to,
			int stock);

	List<SEED_BULB> getAllPotPlanterLoadedByPriceStockSORTTITLE_Z_A(int offset, int limit, double from, double to,
			int stock);

	List<SEED_BULB> getAllPotPlanterLoadedByPriceStockSORTPRICE_L_H(int offset, int limit, double from, double to,
			int stock);

	List<SEED_BULB> getAllPotPlanterLoadedByPriceStockSORTPRICE_H_L(int offset, int limit, double from, double to,
			int stock);

	List<SEED_BULB> getAllPotPlanterLoadedByPriceStockRatingSORTTITLE_A_Z(int offset, int limit, double from,
			double to, int stock, double rating);

	List<SEED_BULB> getAllPotPlanterLoadedByPriceStockRatingSORTTITLE_Z_A(int offset, int limit, double from,
			double to, int stock, double rating);

	List<SEED_BULB> getAllPotPlanterLoadedByPriceStockRatingSORTPRICE_L_H(int offset, int limit, double from,
			double to, int stock, double rating);

	List<SEED_BULB> getAllPotPlanterLoadedByPriceStockRatingSORTPRICE_H_L(int offset, int limit, double from,
			double to, int stock, double rating);


	List<SEED_BULB> Availability(int offset, int limit);

	List<SEED_BULB> sortA_Z(int offset, int limit);

	List<SEED_BULB> sortZ_A(int offset, int limit);

	List<SEED_BULB> Avail_A_Z(int offset, int limit);

	List<SEED_BULB> Avail_Z_A(int offset, int limit);

	List<SEED_BULB> getPlantsByPriceLH(int offset, int limit);

	List<SEED_BULB> getPlantsByPriceHL(int offset, int limit);


	List<SEED_BULB> SORTBYPRICE_L_H(int offset, int limit);

	List<SEED_BULB> SORTBYPRICE_H_L(int offset, int limit);

	List<SEED_BULB> getLoadedPlantsFilterSortPHL1(int offset, int limit, double from, double to);

	List<SEED_BULB> getLoadedPlantsFilterSortPLH1(int offset, int limit, double from, double to);

	List<SEED_BULB> getLoadedPlantFilterSortAZ1(int offset, int limit, double from, double to);

	List<SEED_BULB> getLoadedPlantFilterSortZA1(int offset, int limit, double from, double to);

	List<SEED_BULB> getLoadedPlantsFilterSortRHL2(int offset, int limit, double rating);

	List<SEED_BULB> getLoadedPlantsFilterSortRLH2(int offset, int limit, double rating);

	List<SEED_BULB> getLoadedPlantsFilterSortRAZ2(int offset, int limit, double rating);

	List<SEED_BULB> getLoadedPlantsFilterSortRZA2(int offset, int limit, double rating);
}
