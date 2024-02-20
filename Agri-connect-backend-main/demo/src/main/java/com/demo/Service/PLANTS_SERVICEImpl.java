package com.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Dao.PLANTS_DAO;
import com.demo.Model.PLANTS;

@Service
public class PLANTS_SERVICEImpl implements PLANTS_SERVICE{

	@Autowired
	private PLANTS_DAO pdao;
	
	
	@Override
	public List<PLANTS> getAllPotPlanter() {
		
		return pdao.getAllPot_Planters();
	}
	
	@Override
	public PLANTS getById(String pfid) {
		 return pdao.findById(pfid);
	}

	@Override
	public List<PLANTS> getAllPotPlanterLoaded(int offset, int limit) {
		// TODO Auto-generated method stub
		return pdao.getLoadedPp(offset,limit);
	}

	@Override
	public List<PLANTS> getAllPotPlanterLoadedRating(int offset, int limit, double rating) {
		// TODO Auto-generated method stub
		return pdao.getAllPotPlanterLoadedByRating(offset,limit,rating);
	}

	@Override
	public List<PLANTS> getAllPotPlanterLoadedPrice(int offset, int limit, double from, double to) {
		// TODO Auto-generated method stub
		return pdao.getAllPotPlanterLoadedByPrice(offset,limit,from, to);
	}

	@Override
	public List<PLANTS> getAllPotPlanterLoadedRatingPrice(int offset, int limit, double rating, double from,
			double to) {
	
		return pdao.getAllPotPlanterLoadedByRatingPrice(offset,limit, rating,from, to);
	}

	@Override
	public List<PLANTS> getAllPotPlanterLoadedRatingStock(int offset, int limit, double rating, int stock) {
		
		return pdao.getAllPotPlanterLoadedByRatingStock(offset,limit, rating,stock);
	}

	@Override
	public List<PLANTS> getAllPotPlanterLoadedPriceStock(int offset, int limit, double from, double to,
			int stock) {
		
		return pdao.getAllPotPlanterLoadedByPriceStock(offset,limit, from,to,stock);
	}

	@Override
	public List<PLANTS> getAllPotPlanterLoadedPriceStockRating(int offset, int limit, double from, double to,
			int stock, double rating) {
		return pdao.getAllPotPlanterLoadedByPriceStockRating(offset,limit, from,to,stock,rating);
	}

	@Override
	public List<PLANTS> getAllPotPlanterLoadedRatingPriceSORTTITLE_A_Z(int offset, int limit, double rating,
			double from, double to) {
		return pdao.getAllPotPlanterLoadedByRatingPriceSORTTITLE_A_Z(offset,limit, rating,from, to);
	}

	@Override
	public List<PLANTS> getAllPotPlanterLoadedRatingPriceSORTTITLE_Z_A(int offset, int limit, double rating,
			double from, double to) {
		return pdao.getAllPotPlanterLoadedByRatingPriceSORTTITLE_Z_A(offset,limit, rating,from, to);
	}

	@Override
	public List<PLANTS> getAllPotPlanterLoadedRatingPriceSORTBYPRICE_L_TO_H(int offset, int limit, double rating,
			double from, double to) {
		return pdao.getAllPotPlanterLoadedByRatingPriceSORTPRICE_L_H(offset,limit, rating,from, to);
		
	}

	@Override
	public List<PLANTS> getAllPotPlanterLoadedRatingPriceSORTBYPRICE_H_TO_L(int offset, int limit, double rating,
			double from, double to) {
		return pdao.getAllPotPlanterLoadedByRatingPriceSORTPRICE_H_L(offset,limit, rating,from, to);
	}

	@Override
	public List<PLANTS> getAllPotPlanterLoadedRatingStockSORTTITLE_A_Z(int offset, int limit, double rating,
			int stock) {
		return pdao.getAllPotPlanterLoadedByRatingStockSORTTITLE_A_Z(offset,limit, rating, stock);	
	}

	@Override
	public List<PLANTS> getAllPotPlanterLoadedRatingStockSORTTITLE_Z_A(int offset, int limit, double rating,
			int stock) {
		return pdao.getAllPotPlanterLoadedByRatingStockSORTTITLE_Z_A(offset,limit, rating, stock);
	}

	@Override
	public List<PLANTS> getAllPotPlanterLoadedRatingStockSORTBYPRICE_L_TO_H(int offset, int limit, double rating,
			int stock) {
		return pdao.getAllPotPlanterLoadedByRatingStockSORTPRICE_L_H(offset,limit, rating, stock);
	}

	@Override
	public List<PLANTS> getAllPotPlanterLoadedRatingStockSORTBYPRICE_H_TO_L(int offset, int limit, double rating,
			int stock) {
		return pdao.getAllPotPlanterLoadedByRatingStockSORTPRICE_H_L(offset,limit, rating, stock);
	}

	@Override
	public List<PLANTS> getAllPotPlanterLoadedPriceStockSORTTITLE_A_Z(int offset, int limit, double from,
			double to, int stock) {
		return pdao.getAllPotPlanterLoadedByPriceStockSORTTITLE_A_Z(offset,limit, from,to,stock);
	}

	@Override
	public List<PLANTS> getAllPotPlanterLoadedPriceStockSORTTITLE_Z_A(int offset, int limit, double from,
			double to, int stock) {
		return pdao.getAllPotPlanterLoadedByPriceStockSORTTITLE_Z_A(offset,limit, from,to,stock);
		
	}

	@Override
	public List<PLANTS> getAllPotPlanterLoadedPriceStockSORTBYPRICE_L_TO_H(int offset, int limit, double from,
			double to, int stock) {
		return pdao.getAllPotPlanterLoadedByPriceStockSORTPRICE_L_H(offset,limit, from,to,stock);
	}

	@Override
	public List<PLANTS> getAllPotPlanterLoadedPriceStockSORTBYPRICE_H_TO_L(int offset, int limit, double from,
			double to, int stock) {
		return pdao.getAllPotPlanterLoadedByPriceStockSORTPRICE_H_L(offset,limit, from,to,stock);
	}

	@Override
	public List<PLANTS> getAllPotPlanterLoadedPriceStockRatingSORTTITLE_A_Z(int offset, int limit, double from,
			double to, int stock, double rating) {
		return pdao.getAllPotPlanterLoadedByPriceStockRatingSORTTITLE_A_Z(offset,limit, from,to,stock,rating);
	}

	@Override
	public List<PLANTS> getAllPotPlanterLoadedPriceStockRatingSORTTITLE_Z_A(int offset, int limit, double from,
			double to, int stock, double rating) {
		return pdao.getAllPotPlanterLoadedByPriceStockRatingSORTTITLE_Z_A(offset,limit, from,to,stock,rating);
	}

	@Override
	public List<PLANTS> getAllPotPlanterLoadedPriceStockRatingSORTBYPRICE_L_TO_H(int offset, int limit,
			double from, double to, int stock, double rating) {
		return pdao.getAllPotPlanterLoadedByPriceStockRatingSORTPRICE_L_H(offset,limit, from,to,stock,rating);
	}

	@Override
	public List<PLANTS> getAllPotPlanterLoadedPriceStockRatingSORTBYPRICE_H_TO_L(int offset, int limit,
			double from, double to, int stock, double rating) {
		return pdao.getAllPotPlanterLoadedByPriceStockRatingSORTPRICE_H_L(offset,limit, from,to,stock,rating);
	}


	@Override
	public List<PLANTS> sortA_Z(int offset, int limit) {
		return pdao.sortA_Z(offset, limit);
	}

	@Override
	public List<PLANTS> sortZ_A(int offset, int limit) {
		return pdao.sortZ_A(offset, limit);
	}

	@Override
	public List<PLANTS> Availability(int offset, int limit) {
		return pdao.Availability(offset,limit);
	}

	@Override
	public List<PLANTS> Availability_A_Z(int offset, int limit) {
		return pdao.Avail_A_Z(offset,limit);
	}

	@Override
	public List<PLANTS> Availability_Z_A(int offset, int limit) {
		return pdao.Avail_Z_A(offset,limit);
	}

	@Override
	public List<PLANTS> getPlantByPriceLH(int offset, int limit) {
		return pdao.getPlantsByPriceLH(offset,limit);
	}

	@Override
	public List<PLANTS> getPlantByPriceHL(int offset, int limit) {
		return pdao.getPlantsByPriceHL(offset,limit);
	}

	@Override
	public List<PLANTS> SORTBYPRICE_L_H(int offset, int limit) {
		// TODO Auto-generated method stub
		return pdao.SORTBYPRICE_L_H(offset,limit);
	}

	@Override
	public List<PLANTS> SORTBYPRICE_H_L(int offset, int limit) {
		// TODO Auto-generated method stub
		return pdao.SORTBYPRICE_H_L(offset,limit);
	}
	
	
	@Override
	public List<PLANTS> getLoadedPlantsFilterSortPHL1(int offset, int limit, double from, double to) {
		// TODO Auto-generated method stub
		return pdao.getLoadedPlantsFilterSortPHL1(offset,limit,from,to);
	}

	@Override
	public List<PLANTS> getLoadedPlantsFilterSortPLH1(int offset, int limit, double from, double to) {
		// TODO Auto-generated method stub
		return pdao.getLoadedPlantsFilterSortPLH1(offset,limit,from,to);
	}

	@Override
	public List<PLANTS> getLoadedPlantsFilterSortAZ1(int offset, int limit, double from, double to) {
		// TODO Auto-generated method stub
		return pdao.getLoadedPlantFilterSortAZ1(offset,limit,from,to);
	}

	@Override
	public List<PLANTS> getLoadedPlantsFilterSortZA1(int offset, int limit, double from, double to) {
		return pdao.getLoadedPlantFilterSortZA1(offset,limit,from,to);
	}
	
	@Override
	public List<PLANTS> getLoadedPlantsFilterSortRHL2(int offset, int limit, double rating) {
		// TODO Auto-generated method stub
		return pdao.getLoadedPlantsFilterSortRHL2(offset,limit,rating);
	}

	@Override
	public List<PLANTS> getLoadedPlantsFilterSortRLH2(int offset, int limit, double rating) {
		
		return pdao.getLoadedPlantsFilterSortRLH2(offset,limit,rating);
	}

	@Override
	public List<PLANTS> getLoadedPlantsFilterSortRAZ2(int offset, int limit, double rating) {
		// TODO Auto-generated method stub
	 return pdao.getLoadedPlantsFilterSortRAZ2(offset,limit,rating);
	}

	@Override
	public List<PLANTS> getLoadedPlantsFilterSortRZA2(int offset, int limit, double rating) {
		return pdao.getLoadedPlantsFilterSortRZA2(offset,limit,rating);
	}

	
	
	
	
	
}
