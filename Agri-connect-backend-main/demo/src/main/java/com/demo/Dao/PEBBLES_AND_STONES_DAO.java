package com.demo.Dao;

import java.util.List;

import com.demo.Model.PEBBLES_AND_STONES;

public interface PEBBLES_AND_STONES_DAO {

	List<PEBBLES_AND_STONES> getallartificialplant();

	PEBBLES_AND_STONES getbyid(String apid);

	List<PEBBLES_AND_STONES> getAllPotPlanterLoaded(int offset, int limit);

	List<PEBBLES_AND_STONES> getallpotplanterloadedrating(int offset, int limit, double rating);
	
	List<PEBBLES_AND_STONES> getAllPotPlanterLoadedByPrice(int offset, int limit, double price, double to);

	List<PEBBLES_AND_STONES> getAllPotPlanterLoadedByRatingPrice(int offset, int limit, double rating, double from, double to);

	List<PEBBLES_AND_STONES> getAllPotPlanterLoadedByRatingStock(int offset, int limit, double rating, int stock);

	List<PEBBLES_AND_STONES> getAllPotPlanterLoadedByPriceStock(int offset, int limit, double from, double to, int stock);

	List<PEBBLES_AND_STONES> getAllPotPlanterLoadedByPriceStockRating(int offset, int limit, double from, double to,
			int stock, double rating);

	List<PEBBLES_AND_STONES> getAllPotPlanterLoadedByRatingPriceSORTTITLE_A_Z(int offset, int limit, double rating,
			double from, double to);

	List<PEBBLES_AND_STONES> getAllPotPlanterLoadedByRatingPriceSORTTITLE_Z_A(int offset, int limit, double rating,
			double from, double to);

	List<PEBBLES_AND_STONES> getAllPotPlanterLoadedByRatingPriceSORTPRICE_L_H(int offset, int limit, double rating,
			double from, double to);

	List<PEBBLES_AND_STONES> getAllPotPlanterLoadedByRatingPriceSORTPRICE_H_L(int offset, int limit, double rating,
			double from, double to);

	List<PEBBLES_AND_STONES> getAllPotPlanterLoadedByRatingStockSORTTITLE_A_Z(int offset, int limit, double rating,
			int stock);

	List<PEBBLES_AND_STONES> getAllPotPlanterLoadedByRatingStockSORTTITLE_Z_A(int offset, int limit, double rating,
			int stock);

	List<PEBBLES_AND_STONES> getAllPotPlanterLoadedByRatingStockSORTPRICE_L_H(int offset, int limit, double rating,
			int stock);

	List<PEBBLES_AND_STONES> getAllPotPlanterLoadedByRatingStockSORTPRICE_H_L(int offset, int limit, double rating,
			int stock);

	List<PEBBLES_AND_STONES> getAllPotPlanterLoadedByPriceStockSORTTITLE_A_Z(int offset, int limit, double from, double to,
			int stock);

	List<PEBBLES_AND_STONES> getAllPotPlanterLoadedByPriceStockSORTTITLE_Z_A(int offset, int limit, double from, double to,
			int stock);

	List<PEBBLES_AND_STONES> getAllPotPlanterLoadedByPriceStockSORTPRICE_L_H(int offset, int limit, double from, double to,
			int stock);

	List<PEBBLES_AND_STONES> getAllPotPlanterLoadedByPriceStockSORTPRICE_H_L(int offset, int limit, double from, double to,
			int stock);

	List<PEBBLES_AND_STONES> getAllPotPlanterLoadedByPriceStockRatingSORTTITLE_A_Z(int offset, int limit, double from,
			double to, int stock, double rating);

	List<PEBBLES_AND_STONES> getAllPotPlanterLoadedByPriceStockRatingSORTTITLE_Z_A(int offset, int limit, double from,
			double to, int stock, double rating);

	List<PEBBLES_AND_STONES> getAllPotPlanterLoadedByPriceStockRatingSORTPRICE_L_H(int offset, int limit, double from,
			double to, int stock, double rating);

	List<PEBBLES_AND_STONES> getAllPotPlanterLoadedByPriceStockRatingSORTPRICE_H_L(int offset, int limit, double from,
			double to, int stock, double rating);


	List<PEBBLES_AND_STONES> Availability(int offset, int limit);

	List<PEBBLES_AND_STONES> sortA_Z(int offset, int limit);

	List<PEBBLES_AND_STONES> sortZ_A(int offset, int limit);

	List<PEBBLES_AND_STONES> Avail_A_Z(int offset, int limit);

	List<PEBBLES_AND_STONES> Avail_Z_A(int offset, int limit);

	List<PEBBLES_AND_STONES> getPlantsByPriceLH(int offset, int limit);

	List<PEBBLES_AND_STONES> getPlantsByPriceHL(int offset, int limit);


	List<PEBBLES_AND_STONES> SORTBYPRICE_L_H(int offset, int limit);

	List<PEBBLES_AND_STONES> SORTBYPRICE_H_L(int offset, int limit);

	List<PEBBLES_AND_STONES> getLoadedPlantsFilterSortPHL1(int offset, int limit, double from, double to);

	List<PEBBLES_AND_STONES> getLoadedPlantsFilterSortPLH1(int offset, int limit, double from, double to);

	List<PEBBLES_AND_STONES> getLoadedPlantFilterSortAZ1(int offset, int limit, double from, double to);

	List<PEBBLES_AND_STONES> getLoadedPlantFilterSortZA1(int offset, int limit, double from, double to);

	List<PEBBLES_AND_STONES> getLoadedPlantsFilterSortRHL2(int offset, int limit, double rating);

	List<PEBBLES_AND_STONES> getLoadedPlantsFilterSortRLH2(int offset, int limit, double rating);

	List<PEBBLES_AND_STONES> getLoadedPlantsFilterSortRAZ2(int offset, int limit, double rating);

	List<PEBBLES_AND_STONES> getLoadedPlantsFilterSortRZA2(int offset, int limit, double rating);


	
}
