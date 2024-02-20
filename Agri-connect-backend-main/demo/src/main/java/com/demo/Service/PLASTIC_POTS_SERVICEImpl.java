package com.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Dao.PLASTIC_POTS_DAO;
import com.demo.Model.PLASTIC_POTS;

@Service
public class PLASTIC_POTS_SERVICEImpl implements PLASTIC_POTS_SERVICE{
	
	@Autowired
	private PLASTIC_POTS_DAO plpdao;
	
	
	@Override
	public List<PLASTIC_POTS> getAllPotPlanter() {
		
		return plpdao.getAllPot_Planters();
	}
	
	@Override
	public PLASTIC_POTS getById(String pfid) {
		 return plpdao.findById(pfid);
	}

	@Override
	public List<PLASTIC_POTS> getAllPotPlanterLoaded(int offset, int limit) {
		// TODO Auto-generated method stub
		return plpdao.getLoadedPp(offset,limit);
	}

	@Override
	public List<PLASTIC_POTS> getAllPotPlanterLoadedRating(int offset, int limit, double rating) {
		// TODO Auto-generated method stub
		return plpdao.getAllPotPlanterLoadedByRating(offset,limit,rating);
	}

	@Override
	public List<PLASTIC_POTS> getAllPotPlanterLoadedPrice(int offset, int limit, double from, double to) {
		// TODO Auto-generated method stub
		return plpdao.getAllPotPlanterLoadedByPrice(offset,limit,from, to);
	}

	@Override
	public List<PLASTIC_POTS> getAllPotPlanterLoadedRatingPrice(int offset, int limit, double rating, double from,
			double to) {
	
		return plpdao.getAllPotPlanterLoadedByRatingPrice(offset,limit, rating,from, to);
	}

	@Override
	public List<PLASTIC_POTS> getAllPotPlanterLoadedRatingStock(int offset, int limit, double rating, int stock) {
		
		return plpdao.getAllPotPlanterLoadedByRatingStock(offset,limit, rating,stock);
	}

	@Override
	public List<PLASTIC_POTS> getAllPotPlanterLoadedPriceStock(int offset, int limit, double from, double to,
			int stock) {
		
		return plpdao.getAllPotPlanterLoadedByPriceStock(offset,limit, from,to,stock);
	}

	@Override
	public List<PLASTIC_POTS> getAllPotPlanterLoadedPriceStockRating(int offset, int limit, double from, double to,
			int stock, double rating) {
		return plpdao.getAllPotPlanterLoadedByPriceStockRating(offset,limit, from,to,stock,rating);
	}

	@Override
	public List<PLASTIC_POTS> getAllPotPlanterLoadedRatingPriceSORTTITLE_A_Z(int offset, int limit, double rating,
			double from, double to) {
		return plpdao.getAllPotPlanterLoadedByRatingPriceSORTTITLE_A_Z(offset,limit, rating,from, to);
	}

	@Override
	public List<PLASTIC_POTS> getAllPotPlanterLoadedRatingPriceSORTTITLE_Z_A(int offset, int limit, double rating,
			double from, double to) {
		return plpdao.getAllPotPlanterLoadedByRatingPriceSORTTITLE_Z_A(offset,limit, rating,from, to);
	}

	@Override
	public List<PLASTIC_POTS> getAllPotPlanterLoadedRatingPriceSORTBYPRICE_L_TO_H(int offset, int limit, double rating,
			double from, double to) {
		return plpdao.getAllPotPlanterLoadedByRatingPriceSORTPRICE_L_H(offset,limit, rating,from, to);
		
	}

	@Override
	public List<PLASTIC_POTS> getAllPotPlanterLoadedRatingPriceSORTBYPRICE_H_TO_L(int offset, int limit, double rating,
			double from, double to) {
		return plpdao.getAllPotPlanterLoadedByRatingPriceSORTPRICE_H_L(offset,limit, rating,from, to);
	}

	@Override
	public List<PLASTIC_POTS> getAllPotPlanterLoadedRatingStockSORTTITLE_A_Z(int offset, int limit, double rating,
			int stock) {
		return plpdao.getAllPotPlanterLoadedByRatingStockSORTTITLE_A_Z(offset,limit, rating, stock);	
	}

	@Override
	public List<PLASTIC_POTS> getAllPotPlanterLoadedRatingStockSORTTITLE_Z_A(int offset, int limit, double rating,
			int stock) {
		return plpdao.getAllPotPlanterLoadedByRatingStockSORTTITLE_Z_A(offset,limit, rating, stock);
	}

	@Override
	public List<PLASTIC_POTS> getAllPotPlanterLoadedRatingStockSORTBYPRICE_L_TO_H(int offset, int limit, double rating,
			int stock) {
		return plpdao.getAllPotPlanterLoadedByRatingStockSORTPRICE_L_H(offset,limit, rating, stock);
	}

	@Override
	public List<PLASTIC_POTS> getAllPotPlanterLoadedRatingStockSORTBYPRICE_H_TO_L(int offset, int limit, double rating,
			int stock) {
		return plpdao.getAllPotPlanterLoadedByRatingStockSORTPRICE_H_L(offset,limit, rating, stock);
	}

	@Override
	public List<PLASTIC_POTS> getAllPotPlanterLoadedPriceStockSORTTITLE_A_Z(int offset, int limit, double from,
			double to, int stock) {
		return plpdao.getAllPotPlanterLoadedByPriceStockSORTTITLE_A_Z(offset,limit, from,to,stock);
	}

	@Override
	public List<PLASTIC_POTS> getAllPotPlanterLoadedPriceStockSORTTITLE_Z_A(int offset, int limit, double from,
			double to, int stock) {
		return plpdao.getAllPotPlanterLoadedByPriceStockSORTTITLE_Z_A(offset,limit, from,to,stock);
		
	}

	@Override
	public List<PLASTIC_POTS> getAllPotPlanterLoadedPriceStockSORTBYPRICE_L_TO_H(int offset, int limit, double from,
			double to, int stock) {
		return plpdao.getAllPotPlanterLoadedByPriceStockSORTPRICE_L_H(offset,limit, from,to,stock);
	}

	@Override
	public List<PLASTIC_POTS> getAllPotPlanterLoadedPriceStockSORTBYPRICE_H_TO_L(int offset, int limit, double from,
			double to, int stock) {
		return plpdao.getAllPotPlanterLoadedByPriceStockSORTPRICE_H_L(offset,limit, from,to,stock);
	}

	@Override
	public List<PLASTIC_POTS> getAllPotPlanterLoadedPriceStockRatingSORTTITLE_A_Z(int offset, int limit, double from,
			double to, int stock, double rating) {
		return plpdao.getAllPotPlanterLoadedByPriceStockRatingSORTTITLE_A_Z(offset,limit, from,to,stock,rating);
	}

	@Override
	public List<PLASTIC_POTS> getAllPotPlanterLoadedPriceStockRatingSORTTITLE_Z_A(int offset, int limit, double from,
			double to, int stock, double rating) {
		return plpdao.getAllPotPlanterLoadedByPriceStockRatingSORTTITLE_Z_A(offset,limit, from,to,stock,rating);
	}

	@Override
	public List<PLASTIC_POTS> getAllPotPlanterLoadedPriceStockRatingSORTBYPRICE_L_TO_H(int offset, int limit,
			double from, double to, int stock, double rating) {
		return plpdao.getAllPotPlanterLoadedByPriceStockRatingSORTPRICE_L_H(offset,limit, from,to,stock,rating);
	}

	@Override
	public List<PLASTIC_POTS> getAllPotPlanterLoadedPriceStockRatingSORTBYPRICE_H_TO_L(int offset, int limit,
			double from, double to, int stock, double rating) {
		return plpdao.getAllPotPlanterLoadedByPriceStockRatingSORTPRICE_H_L(offset,limit, from,to,stock,rating);
	}


	@Override
	public List<PLASTIC_POTS> sortA_Z(int offset, int limit) {
		return plpdao.sortA_Z(offset, limit);
	}

	@Override
	public List<PLASTIC_POTS> sortZ_A(int offset, int limit) {
		return plpdao.sortZ_A(offset, limit);
	}

	@Override
	public List<PLASTIC_POTS> Availability(int offset, int limit) {
		return plpdao.Availability(offset,limit);
	}

	@Override
	public List<PLASTIC_POTS> Availability_A_Z(int offset, int limit) {
		return plpdao.Avail_A_Z(offset,limit);
	}

	@Override
	public List<PLASTIC_POTS> Availability_Z_A(int offset, int limit) {
		return plpdao.Avail_Z_A(offset,limit);
	}

	@Override
	public List<PLASTIC_POTS> getPlantByPriceLH(int offset, int limit) {
		return plpdao.getPlantsByPriceLH(offset,limit);
	}

	@Override
	public List<PLASTIC_POTS> getPlantByPriceHL(int offset, int limit) {
		return plpdao.getPlantsByPriceHL(offset,limit);
	}

	@Override
	public List<PLASTIC_POTS> SORTBYPRICE_L_H(int offset, int limit) {
		// TODO Auto-generated method stub
		return plpdao.SORTBYPRICE_L_H(offset,limit);
	}

	@Override
	public List<PLASTIC_POTS> SORTBYPRICE_H_L(int offset, int limit) {
		// TODO Auto-generated method stub
		return plpdao.SORTBYPRICE_H_L(offset,limit);
	}
	
	
	@Override
	public List<PLASTIC_POTS> getLoadedPlantsFilterSortPHL1(int offset, int limit, double from, double to) {
		// TODO Auto-generated method stub
		return plpdao.getLoadedPlantsFilterSortPHL1(offset,limit,from,to);
	}

	@Override
	public List<PLASTIC_POTS> getLoadedPlantsFilterSortPLH1(int offset, int limit, double from, double to) {
		// TODO Auto-generated method stub
		return plpdao.getLoadedPlantsFilterSortPLH1(offset,limit,from,to);
	}

	@Override
	public List<PLASTIC_POTS> getLoadedPlantsFilterSortAZ1(int offset, int limit, double from, double to) {
		// TODO Auto-generated method stub
		return plpdao.getLoadedPlantFilterSortAZ1(offset,limit,from,to);
	}

	@Override
	public List<PLASTIC_POTS> getLoadedPlantsFilterSortZA1(int offset, int limit, double from, double to) {
		return plpdao.getLoadedPlantFilterSortZA1(offset,limit,from,to);
	}
	
	@Override
	public List<PLASTIC_POTS> getLoadedPlantsFilterSortRHL2(int offset, int limit, double rating) {
		// TODO Auto-generated method stub
		return plpdao.getLoadedPlantsFilterSortRHL2(offset,limit,rating);
	}

	@Override
	public List<PLASTIC_POTS> getLoadedPlantsFilterSortRLH2(int offset, int limit, double rating) {
		
		return plpdao.getLoadedPlantsFilterSortRLH2(offset,limit,rating);
	}

	@Override
	public List<PLASTIC_POTS> getLoadedPlantsFilterSortRAZ2(int offset, int limit, double rating) {
		// TODO Auto-generated method stub
	 return plpdao.getLoadedPlantsFilterSortRAZ2(offset,limit,rating);
	}

	@Override
	public List<PLASTIC_POTS> getLoadedPlantsFilterSortRZA2(int offset, int limit, double rating) {
		return plpdao.getLoadedPlantsFilterSortRZA2(offset,limit,rating);
	}

		
}
