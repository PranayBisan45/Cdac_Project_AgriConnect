package com.demo.Dao;

import java.util.List;

import com.demo.Model.ARTIFICIAL_PLANT;



public interface ARTIFICIAL_PLANT_DAO {

	List<ARTIFICIAL_PLANT> getallartificialplant();

	ARTIFICIAL_PLANT getbyid(String apid);

	List<ARTIFICIAL_PLANT> getAllPotPlanterLoaded(int offset, int limit);

	List<ARTIFICIAL_PLANT> getallpotplanterloadedrating(int offset, int limit, double rating);
	
	List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedByPrice(int offset, int limit, double price, double to);

	List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedByRatingPrice(int offset, int limit, double rating, double from, double to);

	List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedByRatingStock(int offset, int limit, double rating, int stock);

	List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedByPriceStock(int offset, int limit, double from, double to, int stock);

	List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedByPriceStockRating(int offset, int limit, double from, double to,
			int stock, double rating);

	List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedByRatingPriceSORTTITLE_A_Z(int offset, int limit, double rating,
			double from, double to);

	List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedByRatingPriceSORTTITLE_Z_A(int offset, int limit, double rating,
			double from, double to);

	List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedByRatingPriceSORTPRICE_L_H(int offset, int limit, double rating,
			double from, double to);

	List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedByRatingPriceSORTPRICE_H_L(int offset, int limit, double rating,
			double from, double to);

	List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedByRatingStockSORTTITLE_A_Z(int offset, int limit, double rating,
			int stock);

	List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedByRatingStockSORTTITLE_Z_A(int offset, int limit, double rating,
			int stock);

	List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedByRatingStockSORTPRICE_L_H(int offset, int limit, double rating,
			int stock);

	List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedByRatingStockSORTPRICE_H_L(int offset, int limit, double rating,
			int stock);

	List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedByPriceStockSORTTITLE_A_Z(int offset, int limit, double from, double to,
			int stock);

	List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedByPriceStockSORTTITLE_Z_A(int offset, int limit, double from, double to,
			int stock);

	List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedByPriceStockSORTPRICE_L_H(int offset, int limit, double from, double to,
			int stock);

	List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedByPriceStockSORTPRICE_H_L(int offset, int limit, double from, double to,
			int stock);

	List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedByPriceStockRatingSORTTITLE_A_Z(int offset, int limit, double from,
			double to, int stock, double rating);

	List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedByPriceStockRatingSORTTITLE_Z_A(int offset, int limit, double from,
			double to, int stock, double rating);

	List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedByPriceStockRatingSORTPRICE_L_H(int offset, int limit, double from,
			double to, int stock, double rating);

	List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedByPriceStockRatingSORTPRICE_H_L(int offset, int limit, double from,
			double to, int stock, double rating);


	List<ARTIFICIAL_PLANT> Availability(int offset, int limit);

	List<ARTIFICIAL_PLANT> sortA_Z(int offset, int limit);

	List<ARTIFICIAL_PLANT> sortZ_A(int offset, int limit);

	List<ARTIFICIAL_PLANT> Avail_A_Z(int offset, int limit);

	List<ARTIFICIAL_PLANT> Avail_Z_A(int offset, int limit);

	List<ARTIFICIAL_PLANT> getPlantsByPriceLH(int offset, int limit);

	List<ARTIFICIAL_PLANT> getPlantsByPriceHL(int offset, int limit);


	List<ARTIFICIAL_PLANT> SORTBYPRICE_L_H(int offset, int limit);

	List<ARTIFICIAL_PLANT> SORTBYPRICE_H_L(int offset, int limit);

	List<ARTIFICIAL_PLANT> getLoadedPlantsFilterSortPHL1(int offset, int limit, double from, double to);

	List<ARTIFICIAL_PLANT> getLoadedPlantsFilterSortPLH1(int offset, int limit, double from, double to);

	List<ARTIFICIAL_PLANT> getLoadedPlantFilterSortAZ1(int offset, int limit, double from, double to);

	List<ARTIFICIAL_PLANT> getLoadedPlantFilterSortZA1(int offset, int limit, double from, double to);

	List<ARTIFICIAL_PLANT> getLoadedPlantsFilterSortRHL2(int offset, int limit, double rating);

	List<ARTIFICIAL_PLANT> getLoadedPlantsFilterSortRLH2(int offset, int limit, double rating);

	List<ARTIFICIAL_PLANT> getLoadedPlantsFilterSortRAZ2(int offset, int limit, double rating);

	List<ARTIFICIAL_PLANT> getLoadedPlantsFilterSortRZA2(int offset, int limit, double rating);


}
