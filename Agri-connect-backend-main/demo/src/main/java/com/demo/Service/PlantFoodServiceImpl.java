package com.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Dao.PlantFoodDao;
import com.demo.Model.Plant_Food;

@Service
public class PlantFoodServiceImpl implements PlantFoodService {
	
	@Autowired
	private PlantFoodDao pfdao;

	@Override
	public  List<Plant_Food> getAllProducts() {
		return pfdao.getAllProducts();
	}

	@Override
	public Plant_Food getById(String pfid) {
		 return pfdao.findById(pfid);
	}

	@Override
	public List<Plant_Food> sortA_Z(int offset, int limit) {
		return pfdao.sortA_Z(offset, limit);
	}

	@Override
	public List<Plant_Food> sortZ_A(int offset, int limit) {
		return pfdao.sortZ_A(offset, limit);
	}

	@Override
	public List<Plant_Food> Availability(int offset, int limit) {
		return pfdao.Availability(offset,limit);
	}

	@Override
	public List<Plant_Food> Availability_A_Z(int offset, int limit) {
		return pfdao.Avail_A_Z(offset,limit);
	}

	@Override
	public List<Plant_Food> Availability_Z_A(int offset, int limit) {
		return pfdao.Avail_Z_A(offset,limit);
	}

	@Override
	public List<Plant_Food> getPlantByAvailPriceLH(int offset, int limit) {
		return pfdao.getPlantsAvailByPriceLH(offset,limit);
	}

	@Override
	public List<Plant_Food> getPlantByAvailPriceHL(int offset, int limit) {
		return pfdao.getPlantsAvailByPriceHL(offset,limit);
	}

	@Override
	public List<Plant_Food> getAllPlantsFoodLoadedPrice(int offset, int limit, double from, double to) {
		return pfdao.getPlantsFoodByPrice(offset,limit);
	}

	@Override
	public List<Plant_Food> getPlantFoodByPrice(int offset, int limit) {
		return pfdao.getPlantsFoodByPrice(offset,limit);
	}

	@Override
	public List<Plant_Food> getPlantFoodByPriceHL(int offset, int limit) {
		return pfdao.getPlantsFoodByPriceHL(offset,limit);
	}

	@Override
	public List<Plant_Food> getLoadedPlantsFoodFilterSortPHL1(int offset, int limit, double from, double to) {
		return pfdao.getLoadedPlantsFilterSortPHL1(offset,limit,from,to);
	}

	@Override
	public List<Plant_Food> getLoadedPlantsFoodFilterSortPLH1(int offset, int limit, double from, double to) {
		return pfdao.getLoadedPlantsFoodFilterSortPLH1(offset,limit,from,to);
	}

	@Override
	public List<Plant_Food> getLoadedPlantsFoodFilterSortAZ1(int offset, int limit, double from, double to) {
		return pfdao.getLoadedPlantFoodFilterSortAZ1(offset,limit,from,to);
	}

	@Override
	public List<Plant_Food> getLoadedPlantsFoodFilterSortZA1(int offset, int limit, double from, double to) {
		return pfdao.getLoadedPlantFoodFilterSortZA1(offset,limit,from,to);
	}

	@Override
	public List<Plant_Food> getLoadedPlantsFoodRating(int offset, int limit, double rating) {
		return pfdao.getLoadedPlantsFoodRating(offset,limit,rating);
	}

	@Override
	public List<Plant_Food> getLoadedPlantsFoodFilterSortRHL2(int offset, int limit, double rating) {
		return pfdao.getLoadedPlantsFoodFilterSortRHL2(offset,limit,rating);
	}

	@Override
	public List<Plant_Food> getLoadedPlantsFoodFilterSortRLH2(int offset, int limit, double rating) {
		return pfdao.getLoadedPlantsFoodFilterSortRLH2(offset,limit,rating);
	}

	@Override
	public List<Plant_Food> getLoadedPlantsFoodFilterSortRAZ2(int offset, int limit, double rating) {
		 return pfdao.getLoadedPlantsFoodFilterSortRAZ2(offset,limit,rating);
	}

	@Override
	public List<Plant_Food> getLoadedPlantsFoodFilterSortRZA2(int offset, int limit, double rating) {
		return pfdao.getLoadedPlantsFoodFilterSortRZA2(offset,limit,rating);
	}

	@Override
	public List<Plant_Food> getAllPlantFoodLoaded(int offset, int limit) {
		return pfdao.getLoadedPf(offset,limit);
	}
	
	@Override
	public List<Plant_Food> getAllPlantFoodsLoadedRating(int offset, int limit, double rating) {
		return pfdao.getAllPlantFoodsLoadedByRating(offset,limit,rating);
	}

	@Override
	public List<Plant_Food> getAllPlantFoodsLoadedRatingPrice(int offset, int limit, double rating, double from,
			double to) {
		return pfdao.getAllPlantFoodsLoadedByRatingPrice(offset,limit, rating,from, to);
	}

	@Override
	public List<Plant_Food> getAllPlantFoodsLoadedPrice(int offset, int limit, double from, double to) {
		return pfdao.getAllPlantFoodsLoadedByPrice(offset,limit,from, to);
	}

	@Override
	public List<Plant_Food> getAllPlantFoodsLoadedRatingStock(int offset, int limit, double rating, int stock) {
		return pfdao.getAllPlantFoodsLoadedByRatingStock(offset,limit, rating,stock);
	}

	@Override
	public List<Plant_Food> getAllPlantFoodLoadedPriceStock(int offset, int limit, double from, double to, int stock) {
		return pfdao.getAllPlantFoodsLoadedByPriceStock(offset,limit, from,to,stock);
	}

	@Override
	public List<Plant_Food> getAllPlantFoodsLoadedPriceStockRating(int offset, int limit, double from, double to,
			int stock, double rating) {
		return pfdao.getAllPlantFoodsLoadedByPriceStockRating(offset,limit, from,to,stock,rating);
	}

	@Override
	public List<Plant_Food> getAllPlantFoodsLoadedRatingPriceSORTTITLE_A_Z(int offset, int limit, double rating,
			double from, double to) {
		return pfdao.getAllPlantFoodLoadedByRatingPriceSORTTITLE_A_Z(offset,limit, rating,from, to);
	}

	@Override
	public List<Plant_Food> getAllPlantFoodLoadedRatingPriceSORTTITLE_Z_A(int offset, int limit, double rating,
			double from, double to) {
		return pfdao.getAllPlantFoodLoadedByRatingPriceSORTTITLE_Z_A(offset,limit, rating,from, to);
	}

	@Override
	public List<Plant_Food> getAllPlantFoodLoadedRatingPriceSORTBYPRICE_L_TO_H(int offset, int limit, double rating,
			double from, double to) {
		return pfdao.getAllPlantFoodLoadedByRatingPriceSORTPRICE_L_H(offset,limit, rating,from, to);
	}

	@Override
	public List<Plant_Food> getAllPlantFoodLoadedRatingPriceSORTBYPRICE_H_TO_L(int offset, int limit, double rating,
			double from, double to) {
		return pfdao.getAllPlantFoodLoadedByRatingPriceSORTPRICE_H_L(offset,limit, rating,from, to);
	}

	@Override
	public List<Plant_Food> getAllPlantFoodLoadedRatingStockSORTTITLE_A_Z(int offset, int limit, double rating,
			int stock) {
		return pfdao.getAllPlantFoodLoadedByRatingStockSORTTITLE_A_Z(offset,limit, rating, stock);
	}

	@Override
	public List<Plant_Food> getAllPlantFoodLoadedRatingStockSORTTITLE_Z_A(int offset, int limit, double rating,
			int stock) {
		return pfdao.getAllPlantFoodLoadedByRatingStockSORTTITLE_Z_A(offset,limit, rating, stock);
	}

	@Override
	public List<Plant_Food> getAllPlantFoodLoadedRatingStockSORTBYPRICE_L_TO_H(int offset, int limit, double rating,
			int stock) {
		return pfdao.getAllPlantFoodLoadedByRatingStockSORTPRICE_L_H(offset,limit, rating, stock);
	}

	@Override
	public List<Plant_Food> getAllPlantFoodLoadedRatingStockSORTBYPRICE_H_TO_L(int offset, int limit, double rating,
			int stock) {
		return pfdao.getAllPlantFoodLoadedByRatingStockSORTPRICE_H_L(offset,limit, rating, stock);
	}

	@Override
	public List<Plant_Food> getAllPlantFoodLoadedPriceStockSORTTITLE_A_Z(int offset, int limit, double from, double to,
			int stock) {
		return pfdao.getAllPlantFoodLoadedByPriceStockSORTTITLE_A_Z(offset,limit, from,to,stock);
	}

	@Override
	public List<Plant_Food> getAllPlantFoodLoadedPriceStockSORTTITLE_Z_A(int offset, int limit, double from, double to,
			int stock) {
		return pfdao.getAllPlantFoodLoadedByPriceStockSORTTITLE_Z_A(offset,limit, from,to,stock);
	}

	@Override
	public List<Plant_Food> getAllPlantFoodLoadedPriceStockSORTBYPRICE_L_TO_H(int offset, int limit, double from,
			double to, int stock) {
		return pfdao.getAllPlantFoodLoadedByPriceStockSORTPRICE_L_H(offset,limit, from,to,stock);
	}

	@Override
	public List<Plant_Food> getAllPlantFoodLoadedPriceStockSORTBYPRICE_H_TO_L(int offset, int limit, double from,
			double to, int stock) {
		return pfdao.getAllPlantFoodLoadedByPriceStockSORTPRICE_H_L(offset,limit, from,to,stock);
	}

	@Override
	public List<Plant_Food> getAllPlantFoodLoadedPriceStockRatingSORTTITLE_A_Z(int offset, int limit, double from,
			double to, int stock, double rating) {
		return pfdao.getAllPlantFoodLoadedByPriceStockRatingSORTTITLE_A_Z(offset,limit, from,to,stock,rating);
	}

	@Override
	public List<Plant_Food> getAllPlantFoodLoadedPriceStockRatingSORTTITLE_Z_A(int offset, int limit, double from,
			double to, int stock, double rating) {
		return pfdao.getAllPlantFoodLoadedByPriceStockRatingSORTTITLE_Z_A(offset,limit, from,to,stock,rating);
	}

	@Override
	public List<Plant_Food> getAllPlantFoodLoadedPriceStockRatingSORTBYPRICE_L_TO_H(int offset, int limit, double from,
			double to, int stock, double rating) {
		return pfdao.getAllPlantFoodLoadedByPriceStockRatingSORTPRICE_L_H(offset,limit, from,to,stock,rating);
	}

	@Override
	public List<Plant_Food> getAllPlantFoodLoadedPriceStockRatingSORTBYPRICE_H_TO_L(int offset, int limit, double from,
			double to, int stock, double rating) {
		return pfdao.getAllPlantFoodLoadedByPriceStockRatingSORTPRICE_H_L(offset,limit, from,to,stock,rating);
	}

}