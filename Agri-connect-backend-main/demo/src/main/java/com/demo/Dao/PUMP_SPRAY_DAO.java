package com.demo.Dao;

import java.util.List;

import com.demo.Model.PUMP_SPRAY;

public interface PUMP_SPRAY_DAO {


	List<PUMP_SPRAY> getallartificialplant();

	PUMP_SPRAY getbyid(String apid);

	List<PUMP_SPRAY> getAllPotPlanterLoaded(int offset, int limit);

	List<PUMP_SPRAY> getallpotplanterloadedrating(int offset, int limit, double rating);
	
	List<PUMP_SPRAY> getAllPotPlanterLoadedByPrice(int offset, int limit, double price, double to);

	List<PUMP_SPRAY> getAllPotPlanterLoadedByRatingPrice(int offset, int limit, double rating, double from, double to);

	List<PUMP_SPRAY> getAllPotPlanterLoadedByRatingStock(int offset, int limit, double rating, int stock);

	List<PUMP_SPRAY> getAllPotPlanterLoadedByPriceStock(int offset, int limit, double from, double to, int stock);

	List<PUMP_SPRAY> getAllPotPlanterLoadedByPriceStockRating(int offset, int limit, double from, double to,
			int stock, double rating);

	List<PUMP_SPRAY> getAllPotPlanterLoadedByRatingPriceSORTTITLE_A_Z(int offset, int limit, double rating,
			double from, double to);

	List<PUMP_SPRAY> getAllPotPlanterLoadedByRatingPriceSORTTITLE_Z_A(int offset, int limit, double rating,
			double from, double to);

	List<PUMP_SPRAY> getAllPotPlanterLoadedByRatingPriceSORTPRICE_L_H(int offset, int limit, double rating,
			double from, double to);

	List<PUMP_SPRAY> getAllPotPlanterLoadedByRatingPriceSORTPRICE_H_L(int offset, int limit, double rating,
			double from, double to);

	List<PUMP_SPRAY> getAllPotPlanterLoadedByRatingStockSORTTITLE_A_Z(int offset, int limit, double rating,
			int stock);

	List<PUMP_SPRAY> getAllPotPlanterLoadedByRatingStockSORTTITLE_Z_A(int offset, int limit, double rating,
			int stock);

	List<PUMP_SPRAY> getAllPotPlanterLoadedByRatingStockSORTPRICE_L_H(int offset, int limit, double rating,
			int stock);

	List<PUMP_SPRAY> getAllPotPlanterLoadedByRatingStockSORTPRICE_H_L(int offset, int limit, double rating,
			int stock);

	List<PUMP_SPRAY> getAllPotPlanterLoadedByPriceStockSORTTITLE_A_Z(int offset, int limit, double from, double to,
			int stock);

	List<PUMP_SPRAY> getAllPotPlanterLoadedByPriceStockSORTTITLE_Z_A(int offset, int limit, double from, double to,
			int stock);

	List<PUMP_SPRAY> getAllPotPlanterLoadedByPriceStockSORTPRICE_L_H(int offset, int limit, double from, double to,
			int stock);

	List<PUMP_SPRAY> getAllPotPlanterLoadedByPriceStockSORTPRICE_H_L(int offset, int limit, double from, double to,
			int stock);

	List<PUMP_SPRAY> getAllPotPlanterLoadedByPriceStockRatingSORTTITLE_A_Z(int offset, int limit, double from,
			double to, int stock, double rating);

	List<PUMP_SPRAY> getAllPotPlanterLoadedByPriceStockRatingSORTTITLE_Z_A(int offset, int limit, double from,
			double to, int stock, double rating);

	List<PUMP_SPRAY> getAllPotPlanterLoadedByPriceStockRatingSORTPRICE_L_H(int offset, int limit, double from,
			double to, int stock, double rating);

	List<PUMP_SPRAY> getAllPotPlanterLoadedByPriceStockRatingSORTPRICE_H_L(int offset, int limit, double from,
			double to, int stock, double rating);


	List<PUMP_SPRAY> Availability(int offset, int limit);

	List<PUMP_SPRAY> sortA_Z(int offset, int limit);

	List<PUMP_SPRAY> sortZ_A(int offset, int limit);

	List<PUMP_SPRAY> Avail_A_Z(int offset, int limit);

	List<PUMP_SPRAY> Avail_Z_A(int offset, int limit);

	List<PUMP_SPRAY> getPlantsByPriceLH(int offset, int limit);

	List<PUMP_SPRAY> getPlantsByPriceHL(int offset, int limit);


	List<PUMP_SPRAY> SORTBYPRICE_L_H(int offset, int limit);

	List<PUMP_SPRAY> SORTBYPRICE_H_L(int offset, int limit);

	List<PUMP_SPRAY> getLoadedPlantsFilterSortPHL1(int offset, int limit, double from, double to);

	List<PUMP_SPRAY> getLoadedPlantsFilterSortPLH1(int offset, int limit, double from, double to);

	List<PUMP_SPRAY> getLoadedPlantFilterSortAZ1(int offset, int limit, double from, double to);

	List<PUMP_SPRAY> getLoadedPlantFilterSortZA1(int offset, int limit, double from, double to);

	List<PUMP_SPRAY> getLoadedPlantsFilterSortRHL2(int offset, int limit, double rating);

	List<PUMP_SPRAY> getLoadedPlantsFilterSortRLH2(int offset, int limit, double rating);

	List<PUMP_SPRAY> getLoadedPlantsFilterSortRAZ2(int offset, int limit, double rating);

	List<PUMP_SPRAY> getLoadedPlantsFilterSortRZA2(int offset, int limit, double rating);
}
