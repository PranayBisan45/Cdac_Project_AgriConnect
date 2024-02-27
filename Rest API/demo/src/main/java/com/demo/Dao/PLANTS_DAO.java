package com.demo.Dao;

import java.util.List;

import com.demo.Model.PLANTS;

public interface PLANTS_DAO {

	
	List<PLANTS> getAllPot_Planters();

	List<PLANTS> getLoadedPp(int offset, int limit);

	List<PLANTS> getAllPotPlanterLoadedByRating(int offset, int limit, double rating);

	List<PLANTS> getAllPotPlanterLoadedByPrice(int offset, int limit, double price, double to);

	List<PLANTS> getAllPotPlanterLoadedByRatingPrice(int offset, int limit, double rating, double from, double to);

	List<PLANTS> getAllPotPlanterLoadedByRatingStock(int offset, int limit, double rating, int stock);

	List<PLANTS> getAllPotPlanterLoadedByPriceStock(int offset, int limit, double from, double to, int stock);

	List<PLANTS> getAllPotPlanterLoadedByPriceStockRating(int offset, int limit, double from, double to,
			int stock, double rating);

	List<PLANTS> getAllPotPlanterLoadedByRatingPriceSORTTITLE_A_Z(int offset, int limit, double rating,
			double from, double to);

	List<PLANTS> getAllPotPlanterLoadedByRatingPriceSORTTITLE_Z_A(int offset, int limit, double rating,
			double from, double to);

	List<PLANTS> getAllPotPlanterLoadedByRatingPriceSORTPRICE_L_H(int offset, int limit, double rating,
			double from, double to);

	List<PLANTS> getAllPotPlanterLoadedByRatingPriceSORTPRICE_H_L(int offset, int limit, double rating,
			double from, double to);

	List<PLANTS> getAllPotPlanterLoadedByRatingStockSORTTITLE_A_Z(int offset, int limit, double rating,
			int stock);

	List<PLANTS> getAllPotPlanterLoadedByRatingStockSORTTITLE_Z_A(int offset, int limit, double rating,
			int stock);

	List<PLANTS> getAllPotPlanterLoadedByRatingStockSORTPRICE_L_H(int offset, int limit, double rating,
			int stock);

	List<PLANTS> getAllPotPlanterLoadedByRatingStockSORTPRICE_H_L(int offset, int limit, double rating,
			int stock);

	List<PLANTS> getAllPotPlanterLoadedByPriceStockSORTTITLE_A_Z(int offset, int limit, double from, double to,
			int stock);

	List<PLANTS> getAllPotPlanterLoadedByPriceStockSORTTITLE_Z_A(int offset, int limit, double from, double to,
			int stock);

	List<PLANTS> getAllPotPlanterLoadedByPriceStockSORTPRICE_L_H(int offset, int limit, double from, double to,
			int stock);

	List<PLANTS> getAllPotPlanterLoadedByPriceStockSORTPRICE_H_L(int offset, int limit, double from, double to,
			int stock);

	List<PLANTS> getAllPotPlanterLoadedByPriceStockRatingSORTTITLE_A_Z(int offset, int limit, double from,
			double to, int stock, double rating);

	List<PLANTS> getAllPotPlanterLoadedByPriceStockRatingSORTTITLE_Z_A(int offset, int limit, double from,
			double to, int stock, double rating);

	List<PLANTS> getAllPotPlanterLoadedByPriceStockRatingSORTPRICE_L_H(int offset, int limit, double from,
			double to, int stock, double rating);

	List<PLANTS> getAllPotPlanterLoadedByPriceStockRatingSORTPRICE_H_L(int offset, int limit, double from,
			double to, int stock, double rating);

	PLANTS findById(String pfid);

	List<PLANTS> Availability(int offset, int limit);

	List<PLANTS> sortA_Z(int offset, int limit);

	List<PLANTS> sortZ_A(int offset, int limit);

	List<PLANTS> Avail_A_Z(int offset, int limit);

	List<PLANTS> Avail_Z_A(int offset, int limit);

	List<PLANTS> getPlantsByPriceLH(int offset, int limit);

	List<PLANTS> getPlantsByPriceHL(int offset, int limit);


	List<PLANTS> SORTBYPRICE_L_H(int offset, int limit);

	List<PLANTS> SORTBYPRICE_H_L(int offset, int limit);

	List<PLANTS> getLoadedPlantsFilterSortPHL1(int offset, int limit, double from, double to);

	List<PLANTS> getLoadedPlantsFilterSortPLH1(int offset, int limit, double from, double to);

	List<PLANTS> getLoadedPlantFilterSortAZ1(int offset, int limit, double from, double to);

	List<PLANTS> getLoadedPlantFilterSortZA1(int offset, int limit, double from, double to);

	List<PLANTS> getLoadedPlantsFilterSortRHL2(int offset, int limit, double rating);

	List<PLANTS> getLoadedPlantsFilterSortRLH2(int offset, int limit, double rating);

	List<PLANTS> getLoadedPlantsFilterSortRAZ2(int offset, int limit, double rating);

	List<PLANTS> getLoadedPlantsFilterSortRZA2(int offset, int limit, double rating);
}
