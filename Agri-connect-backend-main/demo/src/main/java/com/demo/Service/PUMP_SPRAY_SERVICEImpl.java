package com.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Dao.PUMP_SPRAY_DAO;
import com.demo.Model.PUMP_SPRAY;

@Service
public class PUMP_SPRAY_SERVICEImpl implements PUMP_SPRAY_SERVICE{
	
	@Autowired
	private PUMP_SPRAY_DAO psdao;
	
	
	@Override
	public List<PUMP_SPRAY> getAllArtificialPlant() {
		// TODO Auto-generated method stub
		return psdao.getallartificialplant();
	}

	@Override
	public PUMP_SPRAY getById1(String apid) {
		// TODO Auto-generated method stub
		return psdao.getbyid(apid);
	}

	@Override
	public List<PUMP_SPRAY> getAllPotPlanterLoaded(int offset, int limit) {
		// TODO Auto-generated method stub
		return psdao.getAllPotPlanterLoaded(offset,limit);
	}

	@Override
	public List<PUMP_SPRAY> getAllPotPlanterLoadedRating(int offset, int limit, double rating) {
		// TODO Auto-generated method stub
		return psdao.getallpotplanterloadedrating(offset,limit,rating);
	}

	
	@Override
	public List<PUMP_SPRAY> getAllPotPlanterLoadedPrice(int offset, int limit, double from, double to) {
		// TODO Auto-generated method stub
		return psdao.getAllPotPlanterLoadedByPrice(offset,limit,from, to);
	}

	@Override
	public List<PUMP_SPRAY> getAllPotPlanterLoadedRatingPrice(int offset, int limit, double rating, double from,
			double to) {
	
		return psdao.getAllPotPlanterLoadedByRatingPrice(offset,limit, rating,from, to);
	}

	@Override
	public List<PUMP_SPRAY> getAllPotPlanterLoadedRatingStock(int offset, int limit, double rating, int stock) {
		
		return psdao.getAllPotPlanterLoadedByRatingStock(offset,limit, rating,stock);
	}

	@Override
	public List<PUMP_SPRAY> getAllPotPlanterLoadedPriceStock(int offset, int limit, double from, double to,
			int stock) {
		
		return psdao.getAllPotPlanterLoadedByPriceStock(offset,limit, from,to,stock);
	}

	@Override
	public List<PUMP_SPRAY> getAllPotPlanterLoadedPriceStockRating(int offset, int limit, double from, double to,
			int stock, double rating) {
		return psdao.getAllPotPlanterLoadedByPriceStockRating(offset,limit, from,to,stock,rating);
	}

	@Override
	public List<PUMP_SPRAY> getAllPotPlanterLoadedRatingPriceSORTTITLE_A_Z(int offset, int limit, double rating,
			double from, double to) {
		return psdao.getAllPotPlanterLoadedByRatingPriceSORTTITLE_A_Z(offset,limit, rating,from, to);
	}

	@Override
	public List<PUMP_SPRAY> getAllPotPlanterLoadedRatingPriceSORTTITLE_Z_A(int offset, int limit, double rating,
			double from, double to) {
		return psdao.getAllPotPlanterLoadedByRatingPriceSORTTITLE_Z_A(offset,limit, rating,from, to);
	}

	@Override
	public List<PUMP_SPRAY> getAllPotPlanterLoadedRatingPriceSORTBYPRICE_L_TO_H(int offset, int limit, double rating,
			double from, double to) {
		return psdao.getAllPotPlanterLoadedByRatingPriceSORTPRICE_L_H(offset,limit, rating,from, to);
		
	}

	@Override
	public List<PUMP_SPRAY> getAllPotPlanterLoadedRatingPriceSORTBYPRICE_H_TO_L(int offset, int limit, double rating,
			double from, double to) {
		return psdao.getAllPotPlanterLoadedByRatingPriceSORTPRICE_H_L(offset,limit, rating,from, to);
	}

	@Override
	public List<PUMP_SPRAY> getAllPotPlanterLoadedRatingStockSORTTITLE_A_Z(int offset, int limit, double rating,
			int stock) {
		return psdao.getAllPotPlanterLoadedByRatingStockSORTTITLE_A_Z(offset,limit, rating, stock);	
	}

	@Override
	public List<PUMP_SPRAY> getAllPotPlanterLoadedRatingStockSORTTITLE_Z_A(int offset, int limit, double rating,
			int stock) {
		return psdao.getAllPotPlanterLoadedByRatingStockSORTTITLE_Z_A(offset,limit, rating, stock);
	}

	@Override
	public List<PUMP_SPRAY> getAllPotPlanterLoadedRatingStockSORTBYPRICE_L_TO_H(int offset, int limit, double rating,
			int stock) {
		return psdao.getAllPotPlanterLoadedByRatingStockSORTPRICE_L_H(offset,limit, rating, stock);
	}

	@Override
	public List<PUMP_SPRAY> getAllPotPlanterLoadedRatingStockSORTBYPRICE_H_TO_L(int offset, int limit, double rating,
			int stock) {
		return psdao.getAllPotPlanterLoadedByRatingStockSORTPRICE_H_L(offset,limit, rating, stock);
	}

	@Override
	public List<PUMP_SPRAY> getAllPotPlanterLoadedPriceStockSORTTITLE_A_Z(int offset, int limit, double from,
			double to, int stock) {
		return psdao.getAllPotPlanterLoadedByPriceStockSORTTITLE_A_Z(offset,limit, from,to,stock);
	}

	@Override
	public List<PUMP_SPRAY> getAllPotPlanterLoadedPriceStockSORTTITLE_Z_A(int offset, int limit, double from,
			double to, int stock) {
		return psdao.getAllPotPlanterLoadedByPriceStockSORTTITLE_Z_A(offset,limit, from,to,stock);
		
	}

	@Override
	public List<PUMP_SPRAY> getAllPotPlanterLoadedPriceStockSORTBYPRICE_L_TO_H(int offset, int limit, double from,
			double to, int stock) {
		return psdao.getAllPotPlanterLoadedByPriceStockSORTPRICE_L_H(offset,limit, from,to,stock);
	}

	@Override
	public List<PUMP_SPRAY> getAllPotPlanterLoadedPriceStockSORTBYPRICE_H_TO_L(int offset, int limit, double from,
			double to, int stock) {
		return psdao.getAllPotPlanterLoadedByPriceStockSORTPRICE_H_L(offset,limit, from,to,stock);
	}

	@Override
	public List<PUMP_SPRAY> getAllPotPlanterLoadedPriceStockRatingSORTTITLE_A_Z(int offset, int limit, double from,
			double to, int stock, double rating) {
		return psdao.getAllPotPlanterLoadedByPriceStockRatingSORTTITLE_A_Z(offset,limit, from,to,stock,rating);
	}

	@Override
	public List<PUMP_SPRAY> getAllPotPlanterLoadedPriceStockRatingSORTTITLE_Z_A(int offset, int limit, double from,
			double to, int stock, double rating) {
		return psdao.getAllPotPlanterLoadedByPriceStockRatingSORTTITLE_Z_A(offset,limit, from,to,stock,rating);
	}

	@Override
	public List<PUMP_SPRAY> getAllPotPlanterLoadedPriceStockRatingSORTBYPRICE_L_TO_H(int offset, int limit,
			double from, double to, int stock, double rating) {
		return psdao.getAllPotPlanterLoadedByPriceStockRatingSORTPRICE_L_H(offset,limit, from,to,stock,rating);
	}

	@Override
	public List<PUMP_SPRAY> getAllPotPlanterLoadedPriceStockRatingSORTBYPRICE_H_TO_L(int offset, int limit,
			double from, double to, int stock, double rating) {
		return psdao.getAllPotPlanterLoadedByPriceStockRatingSORTPRICE_H_L(offset,limit, from,to,stock,rating);
	}


	@Override
	public List<PUMP_SPRAY> sortA_Z(int offset, int limit) {
		return psdao.sortA_Z(offset, limit);
	}

	@Override
	public List<PUMP_SPRAY> sortZ_A(int offset, int limit) {
		return psdao.sortZ_A(offset, limit);
	}

	@Override
	public List<PUMP_SPRAY> Availability(int offset, int limit) {
		return psdao.Availability(offset,limit);
	}

	@Override
	public List<PUMP_SPRAY> Availability_A_Z(int offset, int limit) {
		return psdao.Avail_A_Z(offset,limit);
	}

	@Override
	public List<PUMP_SPRAY> Availability_Z_A(int offset, int limit) {
		return psdao.Avail_Z_A(offset,limit);
	}

	@Override
	public List<PUMP_SPRAY> getPlantByPriceLH(int offset, int limit) {
		return psdao.getPlantsByPriceLH(offset,limit);
	}

	@Override
	public List<PUMP_SPRAY> getPlantByPriceHL(int offset, int limit) {
		return psdao.getPlantsByPriceHL(offset,limit);
	}

	@Override
	public List<PUMP_SPRAY> SORTBYPRICE_L_H(int offset, int limit) {
		// TODO Auto-generated method stub
		return psdao.SORTBYPRICE_L_H(offset,limit);
	}

	@Override
	public List<PUMP_SPRAY> SORTBYPRICE_H_L(int offset, int limit) {
		// TODO Auto-generated method stub
		return psdao.SORTBYPRICE_H_L(offset,limit);
	}
	
	
	@Override
	public List<PUMP_SPRAY> getLoadedPlantsFilterSortPHL1(int offset, int limit, double from, double to) {
		// TODO Auto-generated method stub
		return psdao.getLoadedPlantsFilterSortPHL1(offset,limit,from,to);
	}

	@Override
	public List<PUMP_SPRAY> getLoadedPlantsFilterSortPLH1(int offset, int limit, double from, double to) {
		// TODO Auto-generated method stub
		return psdao.getLoadedPlantsFilterSortPLH1(offset,limit,from,to);
	}

	@Override
	public List<PUMP_SPRAY> getLoadedPlantsFilterSortAZ1(int offset, int limit, double from, double to) {
		// TODO Auto-generated method stub
		return psdao.getLoadedPlantFilterSortAZ1(offset,limit,from,to);
	}

	@Override
	public List<PUMP_SPRAY> getLoadedPlantsFilterSortZA1(int offset, int limit, double from, double to) {
		return psdao.getLoadedPlantFilterSortZA1(offset,limit,from,to);
	}
	
	@Override
	public List<PUMP_SPRAY> getLoadedPlantsFilterSortRHL2(int offset, int limit, double rating) {
		// TODO Auto-generated method stub
		return psdao.getLoadedPlantsFilterSortRHL2(offset,limit,rating);
	}

	@Override
	public List<PUMP_SPRAY> getLoadedPlantsFilterSortRLH2(int offset, int limit, double rating) {
		
		return psdao.getLoadedPlantsFilterSortRLH2(offset,limit,rating);
	}

	@Override
	public List<PUMP_SPRAY> getLoadedPlantsFilterSortRAZ2(int offset, int limit, double rating) {
		// TODO Auto-generated method stub
	 return psdao.getLoadedPlantsFilterSortRAZ2(offset,limit,rating);
	}

	@Override
	public List<PUMP_SPRAY> getLoadedPlantsFilterSortRZA2(int offset, int limit, double rating) {
		return psdao.getLoadedPlantsFilterSortRZA2(offset,limit,rating);
	}

	

}
