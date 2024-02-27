package com.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Dao.SEED_BULB_DAO;
import com.demo.Model.SEED_BULB;

@Service
public class SEED_BULB_SERVICEImpl implements SEED_BULB_SERVICE{

	@Autowired
	private SEED_BULB_DAO sbdao;
	
	
	@Override
	public List<SEED_BULB> getAllArtificialPlant() {
		// TODO Auto-generated method stub
		return sbdao.getallartificialplant();
	}

	@Override
	public SEED_BULB getById1(String apid) {
		// TODO Auto-generated method stub
		return sbdao.getbyid(apid);
	}

	@Override
	public List<SEED_BULB> getAllPotPlanterLoaded(int offset, int limit) {
		// TODO Auto-generated method stub
		return sbdao.getAllPotPlanterLoaded(offset,limit);
	}

	@Override
	public List<SEED_BULB> getAllPotPlanterLoadedRating(int offset, int limit, double rating) {
		// TODO Auto-generated method stub
		return sbdao.getallpotplanterloadedrating(offset,limit,rating);
	}

	
	@Override
	public List<SEED_BULB> getAllPotPlanterLoadedPrice(int offset, int limit, double from, double to) {
		// TODO Auto-generated method stub
		return sbdao.getAllPotPlanterLoadedByPrice(offset,limit,from, to);
	}

	@Override
	public List<SEED_BULB> getAllPotPlanterLoadedRatingPrice(int offset, int limit, double rating, double from,
			double to) {
	
		return sbdao.getAllPotPlanterLoadedByRatingPrice(offset,limit, rating,from, to);
	}

	@Override
	public List<SEED_BULB> getAllPotPlanterLoadedRatingStock(int offset, int limit, double rating, int stock) {
		
		return sbdao.getAllPotPlanterLoadedByRatingStock(offset,limit, rating,stock);
	}

	@Override
	public List<SEED_BULB> getAllPotPlanterLoadedPriceStock(int offset, int limit, double from, double to,
			int stock) {
		
		return sbdao.getAllPotPlanterLoadedByPriceStock(offset,limit, from,to,stock);
	}

	@Override
	public List<SEED_BULB> getAllPotPlanterLoadedPriceStockRating(int offset, int limit, double from, double to,
			int stock, double rating) {
		return sbdao.getAllPotPlanterLoadedByPriceStockRating(offset,limit, from,to,stock,rating);
	}

	@Override
	public List<SEED_BULB> getAllPotPlanterLoadedRatingPriceSORTTITLE_A_Z(int offset, int limit, double rating,
			double from, double to) {
		return sbdao.getAllPotPlanterLoadedByRatingPriceSORTTITLE_A_Z(offset,limit, rating,from, to);
	}

	@Override
	public List<SEED_BULB> getAllPotPlanterLoadedRatingPriceSORTTITLE_Z_A(int offset, int limit, double rating,
			double from, double to) {
		return sbdao.getAllPotPlanterLoadedByRatingPriceSORTTITLE_Z_A(offset,limit, rating,from, to);
	}

	@Override
	public List<SEED_BULB> getAllPotPlanterLoadedRatingPriceSORTBYPRICE_L_TO_H(int offset, int limit, double rating,
			double from, double to) {
		return sbdao.getAllPotPlanterLoadedByRatingPriceSORTPRICE_L_H(offset,limit, rating,from, to);
		
	}

	@Override
	public List<SEED_BULB> getAllPotPlanterLoadedRatingPriceSORTBYPRICE_H_TO_L(int offset, int limit, double rating,
			double from, double to) {
		return sbdao.getAllPotPlanterLoadedByRatingPriceSORTPRICE_H_L(offset,limit, rating,from, to);
	}

	@Override
	public List<SEED_BULB> getAllPotPlanterLoadedRatingStockSORTTITLE_A_Z(int offset, int limit, double rating,
			int stock) {
		return sbdao.getAllPotPlanterLoadedByRatingStockSORTTITLE_A_Z(offset,limit, rating, stock);	
	}

	@Override
	public List<SEED_BULB> getAllPotPlanterLoadedRatingStockSORTTITLE_Z_A(int offset, int limit, double rating,
			int stock) {
		return sbdao.getAllPotPlanterLoadedByRatingStockSORTTITLE_Z_A(offset,limit, rating, stock);
	}

	@Override
	public List<SEED_BULB> getAllPotPlanterLoadedRatingStockSORTBYPRICE_L_TO_H(int offset, int limit, double rating,
			int stock) {
		return sbdao.getAllPotPlanterLoadedByRatingStockSORTPRICE_L_H(offset,limit, rating, stock);
	}

	@Override
	public List<SEED_BULB> getAllPotPlanterLoadedRatingStockSORTBYPRICE_H_TO_L(int offset, int limit, double rating,
			int stock) {
		return sbdao.getAllPotPlanterLoadedByRatingStockSORTPRICE_H_L(offset,limit, rating, stock);
	}

	@Override
	public List<SEED_BULB> getAllPotPlanterLoadedPriceStockSORTTITLE_A_Z(int offset, int limit, double from,
			double to, int stock) {
		return sbdao.getAllPotPlanterLoadedByPriceStockSORTTITLE_A_Z(offset,limit, from,to,stock);
	}

	@Override
	public List<SEED_BULB> getAllPotPlanterLoadedPriceStockSORTTITLE_Z_A(int offset, int limit, double from,
			double to, int stock) {
		return sbdao.getAllPotPlanterLoadedByPriceStockSORTTITLE_Z_A(offset,limit, from,to,stock);
		
	}

	@Override
	public List<SEED_BULB> getAllPotPlanterLoadedPriceStockSORTBYPRICE_L_TO_H(int offset, int limit, double from,
			double to, int stock) {
		return sbdao.getAllPotPlanterLoadedByPriceStockSORTPRICE_L_H(offset,limit, from,to,stock);
	}

	@Override
	public List<SEED_BULB> getAllPotPlanterLoadedPriceStockSORTBYPRICE_H_TO_L(int offset, int limit, double from,
			double to, int stock) {
		return sbdao.getAllPotPlanterLoadedByPriceStockSORTPRICE_H_L(offset,limit, from,to,stock);
	}

	@Override
	public List<SEED_BULB> getAllPotPlanterLoadedPriceStockRatingSORTTITLE_A_Z(int offset, int limit, double from,
			double to, int stock, double rating) {
		return sbdao.getAllPotPlanterLoadedByPriceStockRatingSORTTITLE_A_Z(offset,limit, from,to,stock,rating);
	}

	@Override
	public List<SEED_BULB> getAllPotPlanterLoadedPriceStockRatingSORTTITLE_Z_A(int offset, int limit, double from,
			double to, int stock, double rating) {
		return sbdao.getAllPotPlanterLoadedByPriceStockRatingSORTTITLE_Z_A(offset,limit, from,to,stock,rating);
	}

	@Override
	public List<SEED_BULB> getAllPotPlanterLoadedPriceStockRatingSORTBYPRICE_L_TO_H(int offset, int limit,
			double from, double to, int stock, double rating) {
		return sbdao.getAllPotPlanterLoadedByPriceStockRatingSORTPRICE_L_H(offset,limit, from,to,stock,rating);
	}

	@Override
	public List<SEED_BULB> getAllPotPlanterLoadedPriceStockRatingSORTBYPRICE_H_TO_L(int offset, int limit,
			double from, double to, int stock, double rating) {
		return sbdao.getAllPotPlanterLoadedByPriceStockRatingSORTPRICE_H_L(offset,limit, from,to,stock,rating);
	}


	@Override
	public List<SEED_BULB> sortA_Z(int offset, int limit) {
		return sbdao.sortA_Z(offset, limit);
	}

	@Override
	public List<SEED_BULB> sortZ_A(int offset, int limit) {
		return sbdao.sortZ_A(offset, limit);
	}

	@Override
	public List<SEED_BULB> Availability(int offset, int limit) {
		return sbdao.Availability(offset,limit);
	}

	@Override
	public List<SEED_BULB> Availability_A_Z(int offset, int limit) {
		return sbdao.Avail_A_Z(offset,limit);
	}

	@Override
	public List<SEED_BULB> Availability_Z_A(int offset, int limit) {
		return sbdao.Avail_Z_A(offset,limit);
	}

	@Override
	public List<SEED_BULB> getPlantByPriceLH(int offset, int limit) {
		return sbdao.getPlantsByPriceLH(offset,limit);
	}

	@Override
	public List<SEED_BULB> getPlantByPriceHL(int offset, int limit) {
		return sbdao.getPlantsByPriceHL(offset,limit);
	}

	@Override
	public List<SEED_BULB> SORTBYPRICE_L_H(int offset, int limit) {
		// TODO Auto-generated method stub
		return sbdao.SORTBYPRICE_L_H(offset,limit);
	}

	@Override
	public List<SEED_BULB> SORTBYPRICE_H_L(int offset, int limit) {
		// TODO Auto-generated method stub
		return sbdao.SORTBYPRICE_H_L(offset,limit);
	}
	
	
	@Override
	public List<SEED_BULB> getLoadedPlantsFilterSortPHL1(int offset, int limit, double from, double to) {
		// TODO Auto-generated method stub
		return sbdao.getLoadedPlantsFilterSortPHL1(offset,limit,from,to);
	}

	@Override
	public List<SEED_BULB> getLoadedPlantsFilterSortPLH1(int offset, int limit, double from, double to) {
		// TODO Auto-generated method stub
		return sbdao.getLoadedPlantsFilterSortPLH1(offset,limit,from,to);
	}

	@Override
	public List<SEED_BULB> getLoadedPlantsFilterSortAZ1(int offset, int limit, double from, double to) {
		// TODO Auto-generated method stub
		return sbdao.getLoadedPlantFilterSortAZ1(offset,limit,from,to);
	}

	@Override
	public List<SEED_BULB> getLoadedPlantsFilterSortZA1(int offset, int limit, double from, double to) {
		return sbdao.getLoadedPlantFilterSortZA1(offset,limit,from,to);
	}
	
	@Override
	public List<SEED_BULB> getLoadedPlantsFilterSortRHL2(int offset, int limit, double rating) {
		// TODO Auto-generated method stub
		return sbdao.getLoadedPlantsFilterSortRHL2(offset,limit,rating);
	}

	@Override
	public List<SEED_BULB> getLoadedPlantsFilterSortRLH2(int offset, int limit, double rating) {
		
		return sbdao.getLoadedPlantsFilterSortRLH2(offset,limit,rating);
	}

	@Override
	public List<SEED_BULB> getLoadedPlantsFilterSortRAZ2(int offset, int limit, double rating) {
		// TODO Auto-generated method stub
	 return sbdao.getLoadedPlantsFilterSortRAZ2(offset,limit,rating);
	}

	@Override
	public List<SEED_BULB> getLoadedPlantsFilterSortRZA2(int offset, int limit, double rating) {
		return sbdao.getLoadedPlantsFilterSortRZA2(offset,limit,rating);
	}

}
