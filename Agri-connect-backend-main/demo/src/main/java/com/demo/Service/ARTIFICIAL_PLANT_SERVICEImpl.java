package com.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Dao.ARTIFICIAL_PLANT_DAO;
import com.demo.Model.ARTIFICIAL_PLANT;
import com.demo.Model.ARTIFICIAL_PLANT;

@Service
public class ARTIFICIAL_PLANT_SERVICEImpl implements ARTIFICIAL_PLANT_SERVICE{

	@Autowired
	private ARTIFICIAL_PLANT_DAO apdao;
	
	@Override
	public List<ARTIFICIAL_PLANT> getAllArtificialPlant() {
		// TODO Auto-generated method stub
		return apdao.getallartificialplant();
	}

	@Override
	public ARTIFICIAL_PLANT getById1(String apid) {
		// TODO Auto-generated method stub
		return apdao.getbyid(apid);
	}

	@Override
	public List<ARTIFICIAL_PLANT> getAllPotPlanterLoaded(int offset, int limit) {
		// TODO Auto-generated method stub
		return apdao.getAllPotPlanterLoaded(offset,limit);
	}

	@Override
	public List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedRating(int offset, int limit, double rating) {
		// TODO Auto-generated method stub
		return apdao.getallpotplanterloadedrating(offset,limit,rating);
	}

	
	@Override
	public List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedPrice(int offset, int limit, double from, double to) {
		// TODO Auto-generated method stub
		return apdao.getAllPotPlanterLoadedByPrice(offset,limit,from, to);
	}

	@Override
	public List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedRatingPrice(int offset, int limit, double rating, double from,
			double to) {
	
		return apdao.getAllPotPlanterLoadedByRatingPrice(offset,limit, rating,from, to);
	}

	@Override
	public List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedRatingStock(int offset, int limit, double rating, int stock) {
		
		return apdao.getAllPotPlanterLoadedByRatingStock(offset,limit, rating,stock);
	}

	@Override
	public List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedPriceStock(int offset, int limit, double from, double to,
			int stock) {
		
		return apdao.getAllPotPlanterLoadedByPriceStock(offset,limit, from,to,stock);
	}

	@Override
	public List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedPriceStockRating(int offset, int limit, double from, double to,
			int stock, double rating) {
		return apdao.getAllPotPlanterLoadedByPriceStockRating(offset,limit, from,to,stock,rating);
	}

	@Override
	public List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedRatingPriceSORTTITLE_A_Z(int offset, int limit, double rating,
			double from, double to) {
		return apdao.getAllPotPlanterLoadedByRatingPriceSORTTITLE_A_Z(offset,limit, rating,from, to);
	}

	@Override
	public List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedRatingPriceSORTTITLE_Z_A(int offset, int limit, double rating,
			double from, double to) {
		return apdao.getAllPotPlanterLoadedByRatingPriceSORTTITLE_Z_A(offset,limit, rating,from, to);
	}

	@Override
	public List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedRatingPriceSORTBYPRICE_L_TO_H(int offset, int limit, double rating,
			double from, double to) {
		return apdao.getAllPotPlanterLoadedByRatingPriceSORTPRICE_L_H(offset,limit, rating,from, to);
		
	}

	@Override
	public List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedRatingPriceSORTBYPRICE_H_TO_L(int offset, int limit, double rating,
			double from, double to) {
		return apdao.getAllPotPlanterLoadedByRatingPriceSORTPRICE_H_L(offset,limit, rating,from, to);
	}

	@Override
	public List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedRatingStockSORTTITLE_A_Z(int offset, int limit, double rating,
			int stock) {
		return apdao.getAllPotPlanterLoadedByRatingStockSORTTITLE_A_Z(offset,limit, rating, stock);	
	}

	@Override
	public List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedRatingStockSORTTITLE_Z_A(int offset, int limit, double rating,
			int stock) {
		return apdao.getAllPotPlanterLoadedByRatingStockSORTTITLE_Z_A(offset,limit, rating, stock);
	}

	@Override
	public List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedRatingStockSORTBYPRICE_L_TO_H(int offset, int limit, double rating,
			int stock) {
		return apdao.getAllPotPlanterLoadedByRatingStockSORTPRICE_L_H(offset,limit, rating, stock);
	}

	@Override
	public List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedRatingStockSORTBYPRICE_H_TO_L(int offset, int limit, double rating,
			int stock) {
		return apdao.getAllPotPlanterLoadedByRatingStockSORTPRICE_H_L(offset,limit, rating, stock);
	}

	@Override
	public List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedPriceStockSORTTITLE_A_Z(int offset, int limit, double from,
			double to, int stock) {
		return apdao.getAllPotPlanterLoadedByPriceStockSORTTITLE_A_Z(offset,limit, from,to,stock);
	}

	@Override
	public List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedPriceStockSORTTITLE_Z_A(int offset, int limit, double from,
			double to, int stock) {
		return apdao.getAllPotPlanterLoadedByPriceStockSORTTITLE_Z_A(offset,limit, from,to,stock);
		
	}

	@Override
	public List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedPriceStockSORTBYPRICE_L_TO_H(int offset, int limit, double from,
			double to, int stock) {
		return apdao.getAllPotPlanterLoadedByPriceStockSORTPRICE_L_H(offset,limit, from,to,stock);
	}

	@Override
	public List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedPriceStockSORTBYPRICE_H_TO_L(int offset, int limit, double from,
			double to, int stock) {
		return apdao.getAllPotPlanterLoadedByPriceStockSORTPRICE_H_L(offset,limit, from,to,stock);
	}

	@Override
	public List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedPriceStockRatingSORTTITLE_A_Z(int offset, int limit, double from,
			double to, int stock, double rating) {
		return apdao.getAllPotPlanterLoadedByPriceStockRatingSORTTITLE_A_Z(offset,limit, from,to,stock,rating);
	}

	@Override
	public List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedPriceStockRatingSORTTITLE_Z_A(int offset, int limit, double from,
			double to, int stock, double rating) {
		return apdao.getAllPotPlanterLoadedByPriceStockRatingSORTTITLE_Z_A(offset,limit, from,to,stock,rating);
	}

	@Override
	public List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedPriceStockRatingSORTBYPRICE_L_TO_H(int offset, int limit,
			double from, double to, int stock, double rating) {
		return apdao.getAllPotPlanterLoadedByPriceStockRatingSORTPRICE_L_H(offset,limit, from,to,stock,rating);
	}

	@Override
	public List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedPriceStockRatingSORTBYPRICE_H_TO_L(int offset, int limit,
			double from, double to, int stock, double rating) {
		return apdao.getAllPotPlanterLoadedByPriceStockRatingSORTPRICE_H_L(offset,limit, from,to,stock,rating);
	}


	@Override
	public List<ARTIFICIAL_PLANT> sortA_Z(int offset, int limit) {
		return apdao.sortA_Z(offset, limit);
	}

	@Override
	public List<ARTIFICIAL_PLANT> sortZ_A(int offset, int limit) {
		return apdao.sortZ_A(offset, limit);
	}

	@Override
	public List<ARTIFICIAL_PLANT> Availability(int offset, int limit) {
		return apdao.Availability(offset,limit);
	}

	@Override
	public List<ARTIFICIAL_PLANT> Availability_A_Z(int offset, int limit) {
		return apdao.Avail_A_Z(offset,limit);
	}

	@Override
	public List<ARTIFICIAL_PLANT> Availability_Z_A(int offset, int limit) {
		return apdao.Avail_Z_A(offset,limit);
	}

	@Override
	public List<ARTIFICIAL_PLANT> getPlantByPriceLH(int offset, int limit) {
		return apdao.getPlantsByPriceLH(offset,limit);
	}

	@Override
	public List<ARTIFICIAL_PLANT> getPlantByPriceHL(int offset, int limit) {
		return apdao.getPlantsByPriceHL(offset,limit);
	}

	@Override
	public List<ARTIFICIAL_PLANT> SORTBYPRICE_L_H(int offset, int limit) {
		// TODO Auto-generated method stub
		return apdao.SORTBYPRICE_L_H(offset,limit);
	}

	@Override
	public List<ARTIFICIAL_PLANT> SORTBYPRICE_H_L(int offset, int limit) {
		// TODO Auto-generated method stub
		return apdao.SORTBYPRICE_H_L(offset,limit);
	}
	
	
	@Override
	public List<ARTIFICIAL_PLANT> getLoadedPlantsFilterSortPHL1(int offset, int limit, double from, double to) {
		// TODO Auto-generated method stub
		return apdao.getLoadedPlantsFilterSortPHL1(offset,limit,from,to);
	}

	@Override
	public List<ARTIFICIAL_PLANT> getLoadedPlantsFilterSortPLH1(int offset, int limit, double from, double to) {
		// TODO Auto-generated method stub
		return apdao.getLoadedPlantsFilterSortPLH1(offset,limit,from,to);
	}

	@Override
	public List<ARTIFICIAL_PLANT> getLoadedPlantsFilterSortAZ1(int offset, int limit, double from, double to) {
		// TODO Auto-generated method stub
		return apdao.getLoadedPlantFilterSortAZ1(offset,limit,from,to);
	}

	@Override
	public List<ARTIFICIAL_PLANT> getLoadedPlantsFilterSortZA1(int offset, int limit, double from, double to) {
		return apdao.getLoadedPlantFilterSortZA1(offset,limit,from,to);
	}
	
	@Override
	public List<ARTIFICIAL_PLANT> getLoadedPlantsFilterSortRHL2(int offset, int limit, double rating) {
		// TODO Auto-generated method stub
		return apdao.getLoadedPlantsFilterSortRHL2(offset,limit,rating);
	}

	@Override
	public List<ARTIFICIAL_PLANT> getLoadedPlantsFilterSortRLH2(int offset, int limit, double rating) {
		
		return apdao.getLoadedPlantsFilterSortRLH2(offset,limit,rating);
	}

	@Override
	public List<ARTIFICIAL_PLANT> getLoadedPlantsFilterSortRAZ2(int offset, int limit, double rating) {
		// TODO Auto-generated method stub
	 return apdao.getLoadedPlantsFilterSortRAZ2(offset,limit,rating);
	}

	@Override
	public List<ARTIFICIAL_PLANT> getLoadedPlantsFilterSortRZA2(int offset, int limit, double rating) {
		return apdao.getLoadedPlantsFilterSortRZA2(offset,limit,rating);
	}


}
