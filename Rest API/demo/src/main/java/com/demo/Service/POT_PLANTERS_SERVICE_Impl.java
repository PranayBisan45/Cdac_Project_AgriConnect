package com.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Dao.POT_PLANTERS_DAO;
import com.demo.Model.POT_PLANTERS;

@Service
public class POT_PLANTERS_SERVICE_Impl implements POT_PLANTERS_SERVICE{

	@Autowired
	POT_PLANTERS_DAO ppdao;
	
	
	
	@Override
	public List<POT_PLANTERS> getAllPotPlanter() {
		
		return ppdao.getAllPot_Planters();
	}
	
	@Override
	public POT_PLANTERS getById(String pfid) {
		 return ppdao.findById(pfid);
	}

	@Override
	public List<POT_PLANTERS> getAllPotPlanterLoaded(int offset, int limit) {
		// TODO Auto-generated method stub
		return ppdao.getLoadedPp(offset,limit);
	}

	@Override
	public List<POT_PLANTERS> getAllPotPlanterLoadedRating(int offset, int limit, double rating) {
		// TODO Auto-generated method stub
		return ppdao.getAllPotPlanterLoadedByRating(offset,limit,rating);
	}

	@Override
	public List<POT_PLANTERS> getAllPotPlanterLoadedPrice(int offset, int limit, double from, double to) {
		// TODO Auto-generated method stub
		return ppdao.getAllPotPlanterLoadedByPrice(offset,limit,from, to);
	}

	@Override
	public List<POT_PLANTERS> getAllPotPlanterLoadedRatingPrice(int offset, int limit, double rating, double from,
			double to) {
	
		return ppdao.getAllPotPlanterLoadedByRatingPrice(offset,limit, rating,from, to);
	}

	@Override
	public List<POT_PLANTERS> getAllPotPlanterLoadedRatingStock(int offset, int limit, double rating, int stock) {
		
		return ppdao.getAllPotPlanterLoadedByRatingStock(offset,limit, rating,stock);
	}

	@Override
	public List<POT_PLANTERS> getAllPotPlanterLoadedPriceStock(int offset, int limit, double from, double to,
			int stock) {
		
		return ppdao.getAllPotPlanterLoadedByPriceStock(offset,limit, from,to,stock);
	}

	@Override
	public List<POT_PLANTERS> getAllPotPlanterLoadedPriceStockRating(int offset, int limit, double from, double to,
			int stock, double rating) {
		return ppdao.getAllPotPlanterLoadedByPriceStockRating(offset,limit, from,to,stock,rating);
	}

	@Override
	public List<POT_PLANTERS> getAllPotPlanterLoadedRatingPriceSORTTITLE_A_Z(int offset, int limit, double rating,
			double from, double to) {
		return ppdao.getAllPotPlanterLoadedByRatingPriceSORTTITLE_A_Z(offset,limit, rating,from, to);
	}

	@Override
	public List<POT_PLANTERS> getAllPotPlanterLoadedRatingPriceSORTTITLE_Z_A(int offset, int limit, double rating,
			double from, double to) {
		return ppdao.getAllPotPlanterLoadedByRatingPriceSORTTITLE_Z_A(offset,limit, rating,from, to);
	}

	@Override
	public List<POT_PLANTERS> getAllPotPlanterLoadedRatingPriceSORTBYPRICE_L_TO_H(int offset, int limit, double rating,
			double from, double to) {
		return ppdao.getAllPotPlanterLoadedByRatingPriceSORTPRICE_L_H(offset,limit, rating,from, to);
		
	}

	@Override
	public List<POT_PLANTERS> getAllPotPlanterLoadedRatingPriceSORTBYPRICE_H_TO_L(int offset, int limit, double rating,
			double from, double to) {
		return ppdao.getAllPotPlanterLoadedByRatingPriceSORTPRICE_H_L(offset,limit, rating,from, to);
	}

	@Override
	public List<POT_PLANTERS> getAllPotPlanterLoadedRatingStockSORTTITLE_A_Z(int offset, int limit, double rating,
			int stock) {
		return ppdao.getAllPotPlanterLoadedByRatingStockSORTTITLE_A_Z(offset,limit, rating, stock);	
	}

	@Override
	public List<POT_PLANTERS> getAllPotPlanterLoadedRatingStockSORTTITLE_Z_A(int offset, int limit, double rating,
			int stock) {
		return ppdao.getAllPotPlanterLoadedByRatingStockSORTTITLE_Z_A(offset,limit, rating, stock);
	}

	@Override
	public List<POT_PLANTERS> getAllPotPlanterLoadedRatingStockSORTBYPRICE_L_TO_H(int offset, int limit, double rating,
			int stock) {
		return ppdao.getAllPotPlanterLoadedByRatingStockSORTPRICE_L_H(offset,limit, rating, stock);
	}

	@Override
	public List<POT_PLANTERS> getAllPotPlanterLoadedRatingStockSORTBYPRICE_H_TO_L(int offset, int limit, double rating,
			int stock) {
		return ppdao.getAllPotPlanterLoadedByRatingStockSORTPRICE_H_L(offset,limit, rating, stock);
	}

	@Override
	public List<POT_PLANTERS> getAllPotPlanterLoadedPriceStockSORTTITLE_A_Z(int offset, int limit, double from,
			double to, int stock) {
		return ppdao.getAllPotPlanterLoadedByPriceStockSORTTITLE_A_Z(offset,limit, from,to,stock);
	}

	@Override
	public List<POT_PLANTERS> getAllPotPlanterLoadedPriceStockSORTTITLE_Z_A(int offset, int limit, double from,
			double to, int stock) {
		return ppdao.getAllPotPlanterLoadedByPriceStockSORTTITLE_Z_A(offset,limit, from,to,stock);
		
	}

	@Override
	public List<POT_PLANTERS> getAllPotPlanterLoadedPriceStockSORTBYPRICE_L_TO_H(int offset, int limit, double from,
			double to, int stock) {
		return ppdao.getAllPotPlanterLoadedByPriceStockSORTPRICE_L_H(offset,limit, from,to,stock);
	}

	@Override
	public List<POT_PLANTERS> getAllPotPlanterLoadedPriceStockSORTBYPRICE_H_TO_L(int offset, int limit, double from,
			double to, int stock) {
		return ppdao.getAllPotPlanterLoadedByPriceStockSORTPRICE_H_L(offset,limit, from,to,stock);
	}

	@Override
	public List<POT_PLANTERS> getAllPotPlanterLoadedPriceStockRatingSORTTITLE_A_Z(int offset, int limit, double from,
			double to, int stock, double rating) {
		return ppdao.getAllPotPlanterLoadedByPriceStockRatingSORTTITLE_A_Z(offset,limit, from,to,stock,rating);
	}

	@Override
	public List<POT_PLANTERS> getAllPotPlanterLoadedPriceStockRatingSORTTITLE_Z_A(int offset, int limit, double from,
			double to, int stock, double rating) {
		return ppdao.getAllPotPlanterLoadedByPriceStockRatingSORTTITLE_Z_A(offset,limit, from,to,stock,rating);
	}

	@Override
	public List<POT_PLANTERS> getAllPotPlanterLoadedPriceStockRatingSORTBYPRICE_L_TO_H(int offset, int limit,
			double from, double to, int stock, double rating) {
		return ppdao.getAllPotPlanterLoadedByPriceStockRatingSORTPRICE_L_H(offset,limit, from,to,stock,rating);
	}

	@Override
	public List<POT_PLANTERS> getAllPotPlanterLoadedPriceStockRatingSORTBYPRICE_H_TO_L(int offset, int limit,
			double from, double to, int stock, double rating) {
		return ppdao.getAllPotPlanterLoadedByPriceStockRatingSORTPRICE_H_L(offset,limit, from,to,stock,rating);
	}


	@Override
	public List<POT_PLANTERS> sortA_Z(int offset, int limit) {
		return ppdao.sortA_Z(offset, limit);
	}

	@Override
	public List<POT_PLANTERS> sortZ_A(int offset, int limit) {
		return ppdao.sortZ_A(offset, limit);
	}

	@Override
	public List<POT_PLANTERS> Availability(int offset, int limit) {
		return ppdao.Availability(offset,limit);
	}

	@Override
	public List<POT_PLANTERS> Availability_A_Z(int offset, int limit) {
		return ppdao.Avail_A_Z(offset,limit);
	}

	@Override
	public List<POT_PLANTERS> Availability_Z_A(int offset, int limit) {
		return ppdao.Avail_Z_A(offset,limit);
	}

	@Override
	public List<POT_PLANTERS> getPlantByPriceLH(int offset, int limit) {
		return ppdao.getPlantsByPriceLH(offset,limit);
	}

	@Override
	public List<POT_PLANTERS> getPlantByPriceHL(int offset, int limit) {
		return ppdao.getPlantsByPriceHL(offset,limit);
	}

	@Override
	public List<POT_PLANTERS> SORTBYPRICE_L_H(int offset, int limit) {
		// TODO Auto-generated method stub
		return ppdao.SORTBYPRICE_L_H(offset,limit);
	}

	@Override
	public List<POT_PLANTERS> SORTBYPRICE_H_L(int offset, int limit) {
		// TODO Auto-generated method stub
		return ppdao.SORTBYPRICE_H_L(offset,limit);
	}
	
	
	@Override
	public List<POT_PLANTERS> getLoadedPlantsFilterSortPHL1(int offset, int limit, double from, double to) {
		// TODO Auto-generated method stub
		return ppdao.getLoadedPlantsFilterSortPHL1(offset,limit,from,to);
	}

	@Override
	public List<POT_PLANTERS> getLoadedPlantsFilterSortPLH1(int offset, int limit, double from, double to) {
		// TODO Auto-generated method stub
		return ppdao.getLoadedPlantsFilterSortPLH1(offset,limit,from,to);
	}

	@Override
	public List<POT_PLANTERS> getLoadedPlantsFilterSortAZ1(int offset, int limit, double from, double to) {
		// TODO Auto-generated method stub
		return ppdao.getLoadedPlantFilterSortAZ1(offset,limit,from,to);
	}

	@Override
	public List<POT_PLANTERS> getLoadedPlantsFilterSortZA1(int offset, int limit, double from, double to) {
		return ppdao.getLoadedPlantFilterSortZA1(offset,limit,from,to);
	}
	
	@Override
	public List<POT_PLANTERS> getLoadedPlantsFilterSortRHL2(int offset, int limit, double rating) {
		// TODO Auto-generated method stub
		return ppdao.getLoadedPlantsFilterSortRHL2(offset,limit,rating);
	}

	@Override
	public List<POT_PLANTERS> getLoadedPlantsFilterSortRLH2(int offset, int limit, double rating) {
		
		return ppdao.getLoadedPlantsFilterSortRLH2(offset,limit,rating);
	}

	@Override
	public List<POT_PLANTERS> getLoadedPlantsFilterSortRAZ2(int offset, int limit, double rating) {
		// TODO Auto-generated method stub
	 return ppdao.getLoadedPlantsFilterSortRAZ2(offset,limit,rating);
	}

	@Override
	public List<POT_PLANTERS> getLoadedPlantsFilterSortRZA2(int offset, int limit, double rating) {
		return ppdao.getLoadedPlantsFilterSortRZA2(offset,limit,rating);
	}

		
	
}
