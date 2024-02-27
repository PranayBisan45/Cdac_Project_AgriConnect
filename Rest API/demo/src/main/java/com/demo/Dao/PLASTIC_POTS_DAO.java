package com.demo.Dao;

import java.util.List;

import com.demo.Model.PLASTIC_POTS;

public interface PLASTIC_POTS_DAO {
	List<PLASTIC_POTS> getAllPot_Planters();

	List<PLASTIC_POTS> getLoadedPp(int offset, int limit);

	List<PLASTIC_POTS> getAllPotPlanterLoadedByRating(int offset, int limit, double rating);

	List<PLASTIC_POTS> getAllPotPlanterLoadedByPrice(int offset, int limit, double price, double to);

	List<PLASTIC_POTS> getAllPotPlanterLoadedByRatingPrice(int offset, int limit, double rating, double from, double to);

	List<PLASTIC_POTS> getAllPotPlanterLoadedByRatingStock(int offset, int limit, double rating, int stock);

	List<PLASTIC_POTS> getAllPotPlanterLoadedByPriceStock(int offset, int limit, double from, double to, int stock);

	List<PLASTIC_POTS> getAllPotPlanterLoadedByPriceStockRating(int offset, int limit, double from, double to,
			int stock, double rating);

	List<PLASTIC_POTS> getAllPotPlanterLoadedByRatingPriceSORTTITLE_A_Z(int offset, int limit, double rating,
			double from, double to);

	List<PLASTIC_POTS> getAllPotPlanterLoadedByRatingPriceSORTTITLE_Z_A(int offset, int limit, double rating,
			double from, double to);

	List<PLASTIC_POTS> getAllPotPlanterLoadedByRatingPriceSORTPRICE_L_H(int offset, int limit, double rating,
			double from, double to);

	List<PLASTIC_POTS> getAllPotPlanterLoadedByRatingPriceSORTPRICE_H_L(int offset, int limit, double rating,
			double from, double to);

	List<PLASTIC_POTS> getAllPotPlanterLoadedByRatingStockSORTTITLE_A_Z(int offset, int limit, double rating,
			int stock);

	List<PLASTIC_POTS> getAllPotPlanterLoadedByRatingStockSORTTITLE_Z_A(int offset, int limit, double rating,
			int stock);

	List<PLASTIC_POTS> getAllPotPlanterLoadedByRatingStockSORTPRICE_L_H(int offset, int limit, double rating,
			int stock);

	List<PLASTIC_POTS> getAllPotPlanterLoadedByRatingStockSORTPRICE_H_L(int offset, int limit, double rating,
			int stock);

	List<PLASTIC_POTS> getAllPotPlanterLoadedByPriceStockSORTTITLE_A_Z(int offset, int limit, double from, double to,
			int stock);

	List<PLASTIC_POTS> getAllPotPlanterLoadedByPriceStockSORTTITLE_Z_A(int offset, int limit, double from, double to,
			int stock);

	List<PLASTIC_POTS> getAllPotPlanterLoadedByPriceStockSORTPRICE_L_H(int offset, int limit, double from, double to,
			int stock);

	List<PLASTIC_POTS> getAllPotPlanterLoadedByPriceStockSORTPRICE_H_L(int offset, int limit, double from, double to,
			int stock);

	List<PLASTIC_POTS> getAllPotPlanterLoadedByPriceStockRatingSORTTITLE_A_Z(int offset, int limit, double from,
			double to, int stock, double rating);

	List<PLASTIC_POTS> getAllPotPlanterLoadedByPriceStockRatingSORTTITLE_Z_A(int offset, int limit, double from,
			double to, int stock, double rating);

	List<PLASTIC_POTS> getAllPotPlanterLoadedByPriceStockRatingSORTPRICE_L_H(int offset, int limit, double from,
			double to, int stock, double rating);

	List<PLASTIC_POTS> getAllPotPlanterLoadedByPriceStockRatingSORTPRICE_H_L(int offset, int limit, double from,
			double to, int stock, double rating);

	PLASTIC_POTS findById(String pfid);

	List<PLASTIC_POTS> Availability(int offset, int limit);

	List<PLASTIC_POTS> sortA_Z(int offset, int limit);

	List<PLASTIC_POTS> sortZ_A(int offset, int limit);

	List<PLASTIC_POTS> Avail_A_Z(int offset, int limit);

	List<PLASTIC_POTS> Avail_Z_A(int offset, int limit);

	List<PLASTIC_POTS> getPlantsByPriceLH(int offset, int limit);

	List<PLASTIC_POTS> getPlantsByPriceHL(int offset, int limit);


	List<PLASTIC_POTS> SORTBYPRICE_L_H(int offset, int limit);

	List<PLASTIC_POTS> SORTBYPRICE_H_L(int offset, int limit);

	List<PLASTIC_POTS> getLoadedPlantsFilterSortPHL1(int offset, int limit, double from, double to);

	List<PLASTIC_POTS> getLoadedPlantsFilterSortPLH1(int offset, int limit, double from, double to);

	List<PLASTIC_POTS> getLoadedPlantFilterSortAZ1(int offset, int limit, double from, double to);

	List<PLASTIC_POTS> getLoadedPlantFilterSortZA1(int offset, int limit, double from, double to);

	List<PLASTIC_POTS> getLoadedPlantsFilterSortRHL2(int offset, int limit, double rating);

	List<PLASTIC_POTS> getLoadedPlantsFilterSortRLH2(int offset, int limit, double rating);

	List<PLASTIC_POTS> getLoadedPlantsFilterSortRAZ2(int offset, int limit, double rating);

	List<PLASTIC_POTS> getLoadedPlantsFilterSortRZA2(int offset, int limit, double rating);
}
