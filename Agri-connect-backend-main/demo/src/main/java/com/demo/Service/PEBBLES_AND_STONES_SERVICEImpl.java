package com.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Dao.PEBBLES_AND_STONES_DAO;
import com.demo.Model.PEBBLES_AND_STONES;

@Service
public class PEBBLES_AND_STONES_SERVICEImpl implements PEBBLES_AND_STONES_SERVICE{

	@Autowired
	private PEBBLES_AND_STONES_DAO pasdao;
	
	
	@Override
	public List<PEBBLES_AND_STONES> getAllArtificialPlant() {
		// TODO Auto-generated method stub
		return pasdao.getallartificialplant();
	}

	@Override
	public PEBBLES_AND_STONES getById1(String apid) {
		// TODO Auto-generated method stub
		return pasdao.getbyid(apid);
	}

	@Override
	public List<PEBBLES_AND_STONES> getAllPotPlanterLoaded(int offset, int limit) {
		// TODO Auto-generated method stub
		return pasdao.getAllPotPlanterLoaded(offset,limit);
	}

	@Override
	public List<PEBBLES_AND_STONES> getAllPotPlanterLoadedRating(int offset, int limit, double rating) {
		// TODO Auto-generated method stub
		return pasdao.getallpotplanterloadedrating(offset,limit,rating);
	}

	
	@Override
	public List<PEBBLES_AND_STONES> getAllPotPlanterLoadedPrice(int offset, int limit, double from, double to) {
		// TODO Auto-generated method stub
		return pasdao.getAllPotPlanterLoadedByPrice(offset,limit,from, to);
	}

	@Override
	public List<PEBBLES_AND_STONES> getAllPotPlanterLoadedRatingPrice(int offset, int limit, double rating, double from,
			double to) {
	
		return pasdao.getAllPotPlanterLoadedByRatingPrice(offset,limit, rating,from, to);
	}

	@Override
	public List<PEBBLES_AND_STONES> getAllPotPlanterLoadedRatingStock(int offset, int limit, double rating, int stock) {
		
		return pasdao.getAllPotPlanterLoadedByRatingStock(offset,limit, rating,stock);
	}

	@Override
	public List<PEBBLES_AND_STONES> getAllPotPlanterLoadedPriceStock(int offset, int limit, double from, double to,
			int stock) {
		
		return pasdao.getAllPotPlanterLoadedByPriceStock(offset,limit, from,to,stock);
	}

	@Override
	public List<PEBBLES_AND_STONES> getAllPotPlanterLoadedPriceStockRating(int offset, int limit, double from, double to,
			int stock, double rating) {
		return pasdao.getAllPotPlanterLoadedByPriceStockRating(offset,limit, from,to,stock,rating);
	}

	@Override
	public List<PEBBLES_AND_STONES> getAllPotPlanterLoadedRatingPriceSORTTITLE_A_Z(int offset, int limit, double rating,
			double from, double to) {
		return pasdao.getAllPotPlanterLoadedByRatingPriceSORTTITLE_A_Z(offset,limit, rating,from, to);
	}

	@Override
	public List<PEBBLES_AND_STONES> getAllPotPlanterLoadedRatingPriceSORTTITLE_Z_A(int offset, int limit, double rating,
			double from, double to) {
		return pasdao.getAllPotPlanterLoadedByRatingPriceSORTTITLE_Z_A(offset,limit, rating,from, to);
	}

	@Override
	public List<PEBBLES_AND_STONES> getAllPotPlanterLoadedRatingPriceSORTBYPRICE_L_TO_H(int offset, int limit, double rating,
			double from, double to) {
		return pasdao.getAllPotPlanterLoadedByRatingPriceSORTPRICE_L_H(offset,limit, rating,from, to);
		
	}

	@Override
	public List<PEBBLES_AND_STONES> getAllPotPlanterLoadedRatingPriceSORTBYPRICE_H_TO_L(int offset, int limit, double rating,
			double from, double to) {
		return pasdao.getAllPotPlanterLoadedByRatingPriceSORTPRICE_H_L(offset,limit, rating,from, to);
	}

	@Override
	public List<PEBBLES_AND_STONES> getAllPotPlanterLoadedRatingStockSORTTITLE_A_Z(int offset, int limit, double rating,
			int stock) {
		return pasdao.getAllPotPlanterLoadedByRatingStockSORTTITLE_A_Z(offset,limit, rating, stock);	
	}

	@Override
	public List<PEBBLES_AND_STONES> getAllPotPlanterLoadedRatingStockSORTTITLE_Z_A(int offset, int limit, double rating,
			int stock) {
		return pasdao.getAllPotPlanterLoadedByRatingStockSORTTITLE_Z_A(offset,limit, rating, stock);
	}

	@Override
	public List<PEBBLES_AND_STONES> getAllPotPlanterLoadedRatingStockSORTBYPRICE_L_TO_H(int offset, int limit, double rating,
			int stock) {
		return pasdao.getAllPotPlanterLoadedByRatingStockSORTPRICE_L_H(offset,limit, rating, stock);
	}

	@Override
	public List<PEBBLES_AND_STONES> getAllPotPlanterLoadedRatingStockSORTBYPRICE_H_TO_L(int offset, int limit, double rating,
			int stock) {
		return pasdao.getAllPotPlanterLoadedByRatingStockSORTPRICE_H_L(offset,limit, rating, stock);
	}

	@Override
	public List<PEBBLES_AND_STONES> getAllPotPlanterLoadedPriceStockSORTTITLE_A_Z(int offset, int limit, double from,
			double to, int stock) {
		return pasdao.getAllPotPlanterLoadedByPriceStockSORTTITLE_A_Z(offset,limit, from,to,stock);
	}

	@Override
	public List<PEBBLES_AND_STONES> getAllPotPlanterLoadedPriceStockSORTTITLE_Z_A(int offset, int limit, double from,
			double to, int stock) {
		return pasdao.getAllPotPlanterLoadedByPriceStockSORTTITLE_Z_A(offset,limit, from,to,stock);
		
	}

	@Override
	public List<PEBBLES_AND_STONES> getAllPotPlanterLoadedPriceStockSORTBYPRICE_L_TO_H(int offset, int limit, double from,
			double to, int stock) {
		return pasdao.getAllPotPlanterLoadedByPriceStockSORTPRICE_L_H(offset,limit, from,to,stock);
	}

	@Override
	public List<PEBBLES_AND_STONES> getAllPotPlanterLoadedPriceStockSORTBYPRICE_H_TO_L(int offset, int limit, double from,
			double to, int stock) {
		return pasdao.getAllPotPlanterLoadedByPriceStockSORTPRICE_H_L(offset,limit, from,to,stock);
	}

	@Override
	public List<PEBBLES_AND_STONES> getAllPotPlanterLoadedPriceStockRatingSORTTITLE_A_Z(int offset, int limit, double from,
			double to, int stock, double rating) {
		return pasdao.getAllPotPlanterLoadedByPriceStockRatingSORTTITLE_A_Z(offset,limit, from,to,stock,rating);
	}

	@Override
	public List<PEBBLES_AND_STONES> getAllPotPlanterLoadedPriceStockRatingSORTTITLE_Z_A(int offset, int limit, double from,
			double to, int stock, double rating) {
		return pasdao.getAllPotPlanterLoadedByPriceStockRatingSORTTITLE_Z_A(offset,limit, from,to,stock,rating);
	}

	@Override
	public List<PEBBLES_AND_STONES> getAllPotPlanterLoadedPriceStockRatingSORTBYPRICE_L_TO_H(int offset, int limit,
			double from, double to, int stock, double rating) {
		return pasdao.getAllPotPlanterLoadedByPriceStockRatingSORTPRICE_L_H(offset,limit, from,to,stock,rating);
	}

	@Override
	public List<PEBBLES_AND_STONES> getAllPotPlanterLoadedPriceStockRatingSORTBYPRICE_H_TO_L(int offset, int limit,
			double from, double to, int stock, double rating) {
		return pasdao.getAllPotPlanterLoadedByPriceStockRatingSORTPRICE_H_L(offset,limit, from,to,stock,rating);
	}


	@Override
	public List<PEBBLES_AND_STONES> sortA_Z(int offset, int limit) {
		return pasdao.sortA_Z(offset, limit);
	}

	@Override
	public List<PEBBLES_AND_STONES> sortZ_A(int offset, int limit) {
		return pasdao.sortZ_A(offset, limit);
	}

	@Override
	public List<PEBBLES_AND_STONES> Availability(int offset, int limit) {
		return pasdao.Availability(offset,limit);
	}

	@Override
	public List<PEBBLES_AND_STONES> Availability_A_Z(int offset, int limit) {
		return pasdao.Avail_A_Z(offset,limit);
	}

	@Override
	public List<PEBBLES_AND_STONES> Availability_Z_A(int offset, int limit) {
		return pasdao.Avail_Z_A(offset,limit);
	}

	@Override
	public List<PEBBLES_AND_STONES> getPlantByPriceLH(int offset, int limit) {
		return pasdao.getPlantsByPriceLH(offset,limit);
	}

	@Override
	public List<PEBBLES_AND_STONES> getPlantByPriceHL(int offset, int limit) {
		return pasdao.getPlantsByPriceHL(offset,limit);
	}

	@Override
	public List<PEBBLES_AND_STONES> SORTBYPRICE_L_H(int offset, int limit) {
		// TODO Auto-generated method stub
		return pasdao.SORTBYPRICE_L_H(offset,limit);
	}

	@Override
	public List<PEBBLES_AND_STONES> SORTBYPRICE_H_L(int offset, int limit) {
		// TODO Auto-generated method stub
		return pasdao.SORTBYPRICE_H_L(offset,limit);
	}
	
	
	@Override
	public List<PEBBLES_AND_STONES> getLoadedPlantsFilterSortPHL1(int offset, int limit, double from, double to) {
		// TODO Auto-generated method stub
		return pasdao.getLoadedPlantsFilterSortPHL1(offset,limit,from,to);
	}

	@Override
	public List<PEBBLES_AND_STONES> getLoadedPlantsFilterSortPLH1(int offset, int limit, double from, double to) {
		// TODO Auto-generated method stub
		return pasdao.getLoadedPlantsFilterSortPLH1(offset,limit,from,to);
	}

	@Override
	public List<PEBBLES_AND_STONES> getLoadedPlantsFilterSortAZ1(int offset, int limit, double from, double to) {
		// TODO Auto-generated method stub
		return pasdao.getLoadedPlantFilterSortAZ1(offset,limit,from,to);
	}

	@Override
	public List<PEBBLES_AND_STONES> getLoadedPlantsFilterSortZA1(int offset, int limit, double from, double to) {
		return pasdao.getLoadedPlantFilterSortZA1(offset,limit,from,to);
	}
	
	@Override
	public List<PEBBLES_AND_STONES> getLoadedPlantsFilterSortRHL2(int offset, int limit, double rating) {
		// TODO Auto-generated method stub
		return pasdao.getLoadedPlantsFilterSortRHL2(offset,limit,rating);
	}

	@Override
	public List<PEBBLES_AND_STONES> getLoadedPlantsFilterSortRLH2(int offset, int limit, double rating) {
		
		return pasdao.getLoadedPlantsFilterSortRLH2(offset,limit,rating);
	}

	@Override
	public List<PEBBLES_AND_STONES> getLoadedPlantsFilterSortRAZ2(int offset, int limit, double rating) {
		// TODO Auto-generated method stub
	 return pasdao.getLoadedPlantsFilterSortRAZ2(offset,limit,rating);
	}

	@Override
	public List<PEBBLES_AND_STONES> getLoadedPlantsFilterSortRZA2(int offset, int limit, double rating) {
		return pasdao.getLoadedPlantsFilterSortRZA2(offset,limit,rating);
	}

	
}
