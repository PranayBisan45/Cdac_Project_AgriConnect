package com.demo.Service;

import java.util.List;

import com.demo.Model.ARTIFICIAL_PLANT;


public interface ARTIFICIAL_PLANT_SERVICE {

	List<ARTIFICIAL_PLANT> getAllArtificialPlant();

	ARTIFICIAL_PLANT getById1(String apid);

	List<ARTIFICIAL_PLANT> getAllPotPlanterLoaded(int offset, int limit);

	List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedRating(int offset, int limit, double rating);

	List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedPrice(int offset, int limit, double price, double to);

	List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedRatingPrice(int offset, int limit, double rating, double from, double to);

	List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedRatingStock(int offset, int limit, double rating, int stock);

	List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedPriceStock(int offset, int limit, double from, double to, int stock);

	List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedPriceStockRating(int offset, int limit, double from, double to, int stock,
			double rating);

	List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedRatingPriceSORTTITLE_A_Z(int offset, int limit, double rating, double from,
			double to);

	List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedRatingPriceSORTTITLE_Z_A(int offset, int limit, double rating, double from,
			double to);

	List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedRatingPriceSORTBYPRICE_L_TO_H(int offset, int limit, double rating,
			double from, double to);

	List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedRatingPriceSORTBYPRICE_H_TO_L(int offset, int limit, double rating,
			double from, double to);

	List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedRatingStockSORTTITLE_A_Z(int offset, int limit, double rating, int stock);

	List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedRatingStockSORTTITLE_Z_A(int offset, int limit, double rating, int stock);

	List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedRatingStockSORTBYPRICE_L_TO_H(int offset, int limit, double rating,
			int stock);

	List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedRatingStockSORTBYPRICE_H_TO_L(int offset, int limit, double rating,
			int stock);

	List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedPriceStockSORTTITLE_A_Z(int offset, int limit, double from, double to,
			int stock);

	List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedPriceStockSORTTITLE_Z_A(int offset, int limit, double from, double to,
			int stock);

	List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedPriceStockSORTBYPRICE_L_TO_H(int offset, int limit, double from, double to,
			int stock);

	List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedPriceStockSORTBYPRICE_H_TO_L(int offset, int limit, double from, double to,
			int stock);

	List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedPriceStockRatingSORTTITLE_A_Z(int offset, int limit, double from,
			double to, int stock, double rating);

	List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedPriceStockRatingSORTTITLE_Z_A(int offset, int limit, double from,
			double to, int stock, double rating);

	List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedPriceStockRatingSORTBYPRICE_L_TO_H(int offset, int limit, double from,
			double to, int stock, double rating);

	List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedPriceStockRatingSORTBYPRICE_H_TO_L(int offset, int limit, double from,
			double to, int stock, double rating);

	

	List<ARTIFICIAL_PLANT> Availability(int offset, int limit);

	List<ARTIFICIAL_PLANT> sortA_Z(int offset, int limit);

	List<ARTIFICIAL_PLANT> sortZ_A(int offset, int limit);

	List<ARTIFICIAL_PLANT> Availability_A_Z(int offset, int limit);

	List<ARTIFICIAL_PLANT> Availability_Z_A(int offset, int limit);

	List<ARTIFICIAL_PLANT> getPlantByPriceLH(int offset, int limit);

	List<ARTIFICIAL_PLANT> getPlantByPriceHL(int offset, int limit);

	List<ARTIFICIAL_PLANT> SORTBYPRICE_L_H(int offset, int limit);

	List<ARTIFICIAL_PLANT> SORTBYPRICE_H_L(int offset, int limit);

	List<ARTIFICIAL_PLANT> getLoadedPlantsFilterSortPHL1(int offset, int limit, double from, double to);

	List<ARTIFICIAL_PLANT> getLoadedPlantsFilterSortPLH1(int offset, int limit, double from, double to);

	List<ARTIFICIAL_PLANT> getLoadedPlantsFilterSortAZ1(int offset, int limit, double from, double to);

	List<ARTIFICIAL_PLANT> getLoadedPlantsFilterSortZA1(int offset, int limit, double from, double to);

	List<ARTIFICIAL_PLANT> getLoadedPlantsFilterSortRHL2(int offset, int limit, double rating);

	List<ARTIFICIAL_PLANT> getLoadedPlantsFilterSortRLH2(int offset, int limit, double rating);

	List<ARTIFICIAL_PLANT> getLoadedPlantsFilterSortRAZ2(int offset, int limit, double rating);

	List<ARTIFICIAL_PLANT> getLoadedPlantsFilterSortRZA2(int offset, int limit, double rating);



}
