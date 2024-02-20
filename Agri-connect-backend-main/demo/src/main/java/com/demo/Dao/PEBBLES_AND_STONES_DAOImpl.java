package com.demo.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.Model.PEBBLES_AND_STONES;

@Repository
public class PEBBLES_AND_STONES_DAOImpl implements PEBBLES_AND_STONES_DAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<PEBBLES_AND_STONES> getallartificialplant() {
		List<PEBBLES_AND_STONES> aplist = jdbcTemplate.query("Select * from PEBBLES_AND_STONES",(rs,num)->{
			PEBBLES_AND_STONES ap = new PEBBLES_AND_STONES();
			ap.setPASID(rs.getString(1));
			ap.setPASTITLE(rs.getString(2));
			ap.setPASDESCRIPTION(rs.getString(3));
			ap.setPAS_RATING(rs.getDouble(4));
			ap.setPASPRICE(rs.getString(5));
			ap.setPAS_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setPASIMAGES(rs.getString(7));
			ap.setPASDETAILS(rs.getString(8));	
			
			
			return ap;	
		});
			
		return aplist;
	}

	@SuppressWarnings("deprecation")
	@Override
	public PEBBLES_AND_STONES getbyid(String PASID) {
		String query = "select * from PEBBLES_AND_STONES where PASID=?";
		PEBBLES_AND_STONES pp = new PEBBLES_AND_STONES();
		try {
		    return jdbcTemplate.queryForObject(query,new Object[] {PASID},BeanPropertyRowMapper.newInstance(PEBBLES_AND_STONES.class));
		}catch(EmptyResultDataAccessException e) {
			return null;
		}		
	}

	@Override
	public List<PEBBLES_AND_STONES> getAllPotPlanterLoaded(int offset, int limit) {
		@SuppressWarnings("deprecation")
		List<PEBBLES_AND_STONES> aplist = jdbcTemplate.query("Select * from PEBBLES_AND_STONES  LIMIT ? OFFSET ?", new Object[]{limit, offset},(rs,num)->{
			PEBBLES_AND_STONES ap = new PEBBLES_AND_STONES();
			ap.setPASID(rs.getString(1));
			ap.setPASTITLE(rs.getString(2));
			ap.setPASDESCRIPTION(rs.getString(3));
			ap.setPAS_RATING(rs.getDouble(4));
			ap.setPASPRICE(rs.getString(5));
			ap.setPAS_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setPASIMAGES(rs.getString(7));
			ap.setPASDETAILS(rs.getString(8));
			ap.setQuantity(rs.getInt(9));
			
			return ap;	
		});
		return aplist;
	}

	@Override
	public List<PEBBLES_AND_STONES> getallpotplanterloadedrating(int offset, int limit, double rating) {
		@SuppressWarnings("deprecation")
		List<PEBBLES_AND_STONES> aplist = jdbcTemplate.query("Select * from PEBBLES_AND_STONES where aprating = ? LIMIT ? OFFSET ?", new Object[]{rating,limit, offset},(rs,num)->{
			PEBBLES_AND_STONES ap = new PEBBLES_AND_STONES();
			ap.setPASID(rs.getString(1));
			ap.setPASTITLE(rs.getString(2));
			ap.setPASDESCRIPTION(rs.getString(3));
			ap.setPAS_RATING(rs.getDouble(4));
			ap.setPASPRICE(rs.getString(5));
			ap.setPAS_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setPASIMAGES(rs.getString(7));
			ap.setPASDETAILS(rs.getString(8));
			
			return ap;	
		});
		return aplist;
	}
	
	
	@Override
	public List<PEBBLES_AND_STONES> getAllPotPlanterLoadedByPrice(int offset, int limit, double from, double to) {
		String query = "SELECT * FROM PEBBLES_AND_STONES WHERE JSON_EXTRACT(PASPRICE, '$[0].SP') BETWEEN ? AND ? LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PEBBLES_AND_STONES> aplist = jdbcTemplate.query(query, new Object[]{from, to ,limit, offset}, (rs, num) -> {
	        PEBBLES_AND_STONES ap = new PEBBLES_AND_STONES();
	        ap.setPASID(rs.getString(1));
	        ap.setPASTITLE(rs.getString(2));
	        ap.setPASDESCRIPTION(rs.getString(3));
	        ap.setPAS_RATING(rs.getDouble(4));
			ap.setPASPRICE(rs.getString(5));
			ap.setPAS_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setPASIMAGES(rs.getString(7));
			ap.setPASDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<PEBBLES_AND_STONES> getAllPotPlanterLoadedByRatingPrice(int offset, int limit, double rating, double from,
			double to) {
		
		String query = "SELECT * FROM PEBBLES_AND_STONES WHERE PAS_RATING = ? AND JSON_EXTRACT(PASPRICE, '$[0].SP') BETWEEN ? AND ? LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PEBBLES_AND_STONES> aplist = jdbcTemplate.query(query, new Object[]{rating, from, to ,limit, offset}, (rs, num) -> {
		    PEBBLES_AND_STONES ap = new PEBBLES_AND_STONES();
	        ap.setPASID(rs.getString(1));
	        ap.setPASTITLE(rs.getString(2));
	        ap.setPASDESCRIPTION(rs.getString(3));
	        ap.setPAS_RATING(rs.getDouble(4));
			ap.setPASPRICE(rs.getString(5));
			ap.setPAS_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setPASIMAGES(rs.getString(7));
			ap.setPASDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<PEBBLES_AND_STONES> getAllPotPlanterLoadedByRatingStock(int offset, int limit, double rating, int stock) {
		String query = "SELECT * FROM PEBBLES_AND_STONES WHERE PAS_RATING = ? AND PAS_STOCK_AVAILABILITY = ? LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PEBBLES_AND_STONES> aplist = jdbcTemplate.query(query, new Object[]{rating,stock,limit, offset}, (rs, num) -> {
		    PEBBLES_AND_STONES ap = new PEBBLES_AND_STONES();
	        ap.setPASID(rs.getString(1));
	        ap.setPASTITLE(rs.getString(2));
	        ap.setPASDESCRIPTION(rs.getString(3));
	        ap.setPAS_RATING(rs.getDouble(4));
			ap.setPASPRICE(rs.getString(5));
			ap.setPAS_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setPASIMAGES(rs.getString(7));
			ap.setPASDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
		
	}

	@Override
	public List<PEBBLES_AND_STONES> getAllPotPlanterLoadedByPriceStock(int offset, int limit, double from, double to,
			int stock) {
		String query = "SELECT * FROM PEBBLES_AND_STONES WHERE JSON_EXTRACT(PASPRICE, '$[0].SP') BETWEEN ? AND ? AND PAS_STOCK_AVAILABILITY = ? LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PEBBLES_AND_STONES> aplist = jdbcTemplate.query(query, new Object[]{from, to,stock,limit, offset}, (rs, num) -> {
		    PEBBLES_AND_STONES ap = new PEBBLES_AND_STONES();
	        ap.setPASID(rs.getString(1));
	        ap.setPASTITLE(rs.getString(2));
	        ap.setPASDESCRIPTION(rs.getString(3));
	        ap.setPAS_RATING(rs.getDouble(4));
			ap.setPASPRICE(rs.getString(5));
			ap.setPAS_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setPASIMAGES(rs.getString(7));
			ap.setPASDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<PEBBLES_AND_STONES> getAllPotPlanterLoadedByPriceStockRating(int offset, int limit, double from, double to,
			int stock, double rating) {
		
		String query = "SELECT * FROM PEBBLES_AND_STONES WHERE JSON_EXTRACT(PASPRICE, '$[0].SP') BETWEEN ? AND ? AND PAS_STOCK_AVAILABILITY = ? AND PAS_RATING = ? LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PEBBLES_AND_STONES> aplist = jdbcTemplate.query(query, new Object[]{from, to,stock,rating,limit, offset}, (rs, num) -> {
		    PEBBLES_AND_STONES ap = new PEBBLES_AND_STONES();
	        ap.setPASID(rs.getString(1));
	        ap.setPASTITLE(rs.getString(2));
	        ap.setPASDESCRIPTION(rs.getString(3));
	        ap.setPAS_RATING(rs.getDouble(4));
			ap.setPASPRICE(rs.getString(5));
			ap.setPAS_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setPASIMAGES(rs.getString(7));
			ap.setPASDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;		
	}

	@Override
	public List<PEBBLES_AND_STONES> getAllPotPlanterLoadedByRatingPriceSORTTITLE_A_Z(int offset, int limit, double rating,
			double from, double to) {
		String query = "SELECT * FROM PEBBLES_AND_STONES WHERE PAS_RATING = ? AND JSON_EXTRACT(PASPRICE, '$[0].SP') BETWEEN ? AND ? Order by PASTITLE LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PEBBLES_AND_STONES> aplist = jdbcTemplate.query(query, new Object[]{rating, from, to ,limit, offset}, (rs, num) -> {
		    PEBBLES_AND_STONES ap = new PEBBLES_AND_STONES();
	        ap.setPASID(rs.getString(1));
	        ap.setPASTITLE(rs.getString(2));
	        ap.setPASDESCRIPTION(rs.getString(3));
	        ap.setPAS_RATING(rs.getDouble(4));
			ap.setPASPRICE(rs.getString(5));
			ap.setPAS_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setPASIMAGES(rs.getString(7));
			ap.setPASDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<PEBBLES_AND_STONES> getAllPotPlanterLoadedByRatingPriceSORTTITLE_Z_A(int offset, int limit, double rating,
			double from, double to) {
		String query = "SELECT * FROM PEBBLES_AND_STONES WHERE PAS_RATING = ? AND JSON_EXTRACT(PASPRICE, '$[0].SP') BETWEEN ? AND ? Order by PASTITLE DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PEBBLES_AND_STONES> aplist = jdbcTemplate.query(query, new Object[]{rating, from, to ,limit, offset}, (rs, num) -> {
		    PEBBLES_AND_STONES ap = new PEBBLES_AND_STONES();
	        ap.setPASID(rs.getString(1));
	        ap.setPASTITLE(rs.getString(2));
	        ap.setPASDESCRIPTION(rs.getString(3));
	        ap.setPAS_RATING(rs.getDouble(4));
			ap.setPASPRICE(rs.getString(5));
			ap.setPAS_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setPASIMAGES(rs.getString(7));
			ap.setPASDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}
	
	

	@Override
	public List<PEBBLES_AND_STONES> getAllPotPlanterLoadedByRatingPriceSORTPRICE_L_H(int offset, int limit, double rating,
			double from, double to) {
		String query = "SELECT * FROM PEBBLES_AND_STONES WHERE PAS_RATING = ? AND JSON_EXTRACT(PASPRICE, '$[0].SP') BETWEEN ? AND ?  order by CAST(JSON_EXTRACT(PASPRICE, '$[0].SP') AS UNSIGNED) LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PEBBLES_AND_STONES> aplist = jdbcTemplate.query(query, new Object[]{rating, from, to ,limit, offset}, (rs, num) -> {
		    PEBBLES_AND_STONES ap = new PEBBLES_AND_STONES();
	        ap.setPASID(rs.getString(1));
	        ap.setPASTITLE(rs.getString(2));
	        ap.setPASDESCRIPTION(rs.getString(3));
	        ap.setPAS_RATING(rs.getDouble(4));
			ap.setPASPRICE(rs.getString(5));
			ap.setPAS_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setPASIMAGES(rs.getString(7));
			ap.setPASDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;	}

	@Override
	public List<PEBBLES_AND_STONES> getAllPotPlanterLoadedByRatingPriceSORTPRICE_H_L(int offset, int limit, double rating,
			double from, double to) {
String query = "SELECT * FROM PEBBLES_AND_STONES WHERE PAS_RATING = ? AND JSON_EXTRACT(PASPRICE, '$[0].SP') BETWEEN ? AND ?  order by CAST(JSON_EXTRACT(PASPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PEBBLES_AND_STONES> aplist = jdbcTemplate.query(query, new Object[]{rating, from, to ,limit, offset}, (rs, num) -> {
		    PEBBLES_AND_STONES ap = new PEBBLES_AND_STONES();
	        ap.setPASID(rs.getString(1));
	        ap.setPASTITLE(rs.getString(2));
	        ap.setPASDESCRIPTION(rs.getString(3));
	        ap.setPAS_RATING(rs.getDouble(4));
			ap.setPASPRICE(rs.getString(5));
			ap.setPAS_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setPASIMAGES(rs.getString(7));
			ap.setPASDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<PEBBLES_AND_STONES> getAllPotPlanterLoadedByRatingStockSORTTITLE_A_Z(int offset, int limit, double rating,
			int stock) {
		String query = "SELECT * FROM PEBBLES_AND_STONES WHERE PAS_RATING = ? AND PAS_STOCK_AVAILABILITY = ? Order by PASTITLE LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PEBBLES_AND_STONES> aplist = jdbcTemplate.query(query, new Object[]{rating,stock,limit, offset}, (rs, num) -> {
		    PEBBLES_AND_STONES ap = new PEBBLES_AND_STONES();
	        ap.setPASID(rs.getString(1));
	        ap.setPASTITLE(rs.getString(2));
	        ap.setPASDESCRIPTION(rs.getString(3));
	        ap.setPAS_RATING(rs.getDouble(4));
			ap.setPASPRICE(rs.getString(5));
			ap.setPAS_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setPASIMAGES(rs.getString(7));
			ap.setPASDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;	}

	@Override
	public List<PEBBLES_AND_STONES> getAllPotPlanterLoadedByRatingStockSORTTITLE_Z_A(int offset, int limit, double rating,
			int stock) {
		String query = "SELECT * FROM PEBBLES_AND_STONES WHERE PAS_RATING = ? AND PAS_STOCK_AVAILABILITY = ? Order by PASTITLE DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PEBBLES_AND_STONES> aplist = jdbcTemplate.query(query, new Object[]{rating,stock,limit, offset}, (rs, num) -> {
		    PEBBLES_AND_STONES ap = new PEBBLES_AND_STONES();
	        ap.setPASID(rs.getString(1));
	        ap.setPASTITLE(rs.getString(2));
	        ap.setPASDESCRIPTION(rs.getString(3));
	        ap.setPAS_RATING(rs.getDouble(4));
			ap.setPASPRICE(rs.getString(5));
			ap.setPAS_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setPASIMAGES(rs.getString(7));
			ap.setPASDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
		
	}

	@Override
	public List<PEBBLES_AND_STONES> getAllPotPlanterLoadedByRatingStockSORTPRICE_L_H(int offset, int limit, double rating,
			int stock) {
		String query = "SELECT * FROM PEBBLES_AND_STONES WHERE PAS_RATING = ? AND PAS_STOCK_AVAILABILITY = ?  order by CAST(JSON_EXTRACT(PASPRICE, '$[0].SP') AS UNSIGNED) LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PEBBLES_AND_STONES> aplist = jdbcTemplate.query(query, new Object[]{rating,stock,limit, offset}, (rs, num) -> {
		    PEBBLES_AND_STONES ap = new PEBBLES_AND_STONES();
	        ap.setPASID(rs.getString(1));
	        ap.setPASTITLE(rs.getString(2));
	        ap.setPASDESCRIPTION(rs.getString(3));
	        ap.setPAS_RATING(rs.getDouble(4));
			ap.setPASPRICE(rs.getString(5));
			ap.setPAS_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setPASIMAGES(rs.getString(7));
			ap.setPASDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<PEBBLES_AND_STONES> getAllPotPlanterLoadedByRatingStockSORTPRICE_H_L(int offset, int limit, double rating,
			int stock) {
String query = "SELECT * FROM PEBBLES_AND_STONES WHERE PAS_RATING = ? AND PAS_STOCK_AVAILABILITY = ?  order by CAST(JSON_EXTRACT(PASPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PEBBLES_AND_STONES> aplist = jdbcTemplate.query(query, new Object[]{rating,stock,limit, offset}, (rs, num) -> {
		    PEBBLES_AND_STONES ap = new PEBBLES_AND_STONES();
	        ap.setPASID(rs.getString(1));
	        ap.setPASTITLE(rs.getString(2));
	        ap.setPASDESCRIPTION(rs.getString(3));
	        ap.setPAS_RATING(rs.getDouble(4));
			ap.setPASPRICE(rs.getString(5));
			ap.setPAS_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setPASIMAGES(rs.getString(7));
			ap.setPASDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<PEBBLES_AND_STONES> getAllPotPlanterLoadedByPriceStockSORTTITLE_A_Z(int offset, int limit, double from,
			double to, int stock) {
		String query = "SELECT * FROM PEBBLES_AND_STONES WHERE JSON_EXTRACT(PASPRICE, '$[0].SP') BETWEEN ? AND ? AND PAS_STOCK_AVAILABILITY = ? ORDER BY PASTITLE LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PEBBLES_AND_STONES> aplist = jdbcTemplate.query(query, new Object[]{from, to,stock,limit, offset}, (rs, num) -> {
		    PEBBLES_AND_STONES ap = new PEBBLES_AND_STONES();
	        ap.setPASID(rs.getString(1));
	        ap.setPASTITLE(rs.getString(2));
	        ap.setPASDESCRIPTION(rs.getString(3));
	        ap.setPAS_RATING(rs.getDouble(4));
			ap.setPASPRICE(rs.getString(5));
			ap.setPAS_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setPASIMAGES(rs.getString(7));
			ap.setPASDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
		
	}

	@Override
	public List<PEBBLES_AND_STONES> getAllPotPlanterLoadedByPriceStockSORTTITLE_Z_A(int offset, int limit, double from,
			double to, int stock) {
		String query = "SELECT * FROM PEBBLES_AND_STONES WHERE JSON_EXTRACT(PASPRICE, '$[0].SP') BETWEEN ? AND ? AND PAS_STOCK_AVAILABILITY = ? ORDER BY PASTITLE DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PEBBLES_AND_STONES> aplist = jdbcTemplate.query(query, new Object[]{from, to,stock,limit, offset}, (rs, num) -> {
		    PEBBLES_AND_STONES ap = new PEBBLES_AND_STONES();
	        ap.setPASID(rs.getString(1));
	        ap.setPASTITLE(rs.getString(2));
	        ap.setPASDESCRIPTION(rs.getString(3));
	        ap.setPAS_RATING(rs.getDouble(4));
			ap.setPASPRICE(rs.getString(5));
			ap.setPAS_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setPASIMAGES(rs.getString(7));
			ap.setPASDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<PEBBLES_AND_STONES> getAllPotPlanterLoadedByPriceStockSORTPRICE_L_H(int offset, int limit, double from,
			double to, int stock) {
		String query = "SELECT * FROM PEBBLES_AND_STONES WHERE JSON_EXTRACT(PASPRICE, '$[0].SP') BETWEEN ? AND ? AND PAS_STOCK_AVAILABILITY = ?  order by CAST(JSON_EXTRACT(PASPRICE, '$[0].SP') AS UNSIGNED) LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PEBBLES_AND_STONES> aplist = jdbcTemplate.query(query, new Object[]{from, to,stock,limit, offset}, (rs, num) -> {
		    PEBBLES_AND_STONES ap = new PEBBLES_AND_STONES();
	        ap.setPASID(rs.getString(1));
	        ap.setPASTITLE(rs.getString(2));
	        ap.setPASDESCRIPTION(rs.getString(3));
	        ap.setPAS_RATING(rs.getDouble(4));
			ap.setPASPRICE(rs.getString(5));
			ap.setPAS_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setPASIMAGES(rs.getString(7));
			ap.setPASDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<PEBBLES_AND_STONES> getAllPotPlanterLoadedByPriceStockSORTPRICE_H_L(int offset, int limit, double from,
			double to, int stock) {
		String query = "SELECT * FROM PEBBLES_AND_STONES WHERE JSON_EXTRACT(PASPRICE, '$[0].SP') BETWEEN ? AND ? AND PAS_STOCK_AVAILABILITY = ?  order by CAST(JSON_EXTRACT(PASPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PEBBLES_AND_STONES> aplist = jdbcTemplate.query(query, new Object[]{from, to,stock,limit, offset}, (rs, num) -> {
		    PEBBLES_AND_STONES ap = new PEBBLES_AND_STONES();
	        ap.setPASID(rs.getString(1));
	        ap.setPASTITLE(rs.getString(2));
	        ap.setPASDESCRIPTION(rs.getString(3));
	        ap.setPAS_RATING(rs.getDouble(4));
			ap.setPASPRICE(rs.getString(5));
			ap.setPAS_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setPASIMAGES(rs.getString(7));
			ap.setPASDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<PEBBLES_AND_STONES> getAllPotPlanterLoadedByPriceStockRatingSORTTITLE_A_Z(int offset, int limit, double from,
			double to, int stock, double rating) {
		String query = "SELECT * FROM PEBBLES_AND_STONES WHERE JSON_EXTRACT(PASPRICE, '$[0].SP') BETWEEN ? AND ? AND PAS_STOCK_AVAILABILITY = ? AND PAS_RATING = ? ORDER BY PASTITLE LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PEBBLES_AND_STONES> aplist = jdbcTemplate.query(query, new Object[]{from, to,stock,rating,limit, offset}, (rs, num) -> {
		    PEBBLES_AND_STONES ap = new PEBBLES_AND_STONES();
	        ap.setPASID(rs.getString(1));
	        ap.setPASTITLE(rs.getString(2));
	        ap.setPASDESCRIPTION(rs.getString(3));
	        ap.setPAS_RATING(rs.getDouble(4));
			ap.setPASPRICE(rs.getString(5));
			ap.setPAS_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setPASIMAGES(rs.getString(7));
			ap.setPASDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<PEBBLES_AND_STONES> getAllPotPlanterLoadedByPriceStockRatingSORTTITLE_Z_A(int offset, int limit, double from,
			double to, int stock, double rating) {
		String query = "SELECT * FROM PEBBLES_AND_STONES WHERE JSON_EXTRACT(PASPRICE, '$[0].SP') BETWEEN ? AND ? AND PAS_STOCK_AVAILABILITY = ? AND PAS_RATING = ? ORDER BY PASTITLE DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PEBBLES_AND_STONES> aplist = jdbcTemplate.query(query, new Object[]{from, to,stock,rating,limit, offset}, (rs, num) -> {
		    PEBBLES_AND_STONES ap = new PEBBLES_AND_STONES();
	        ap.setPASID(rs.getString(1));
	        ap.setPASTITLE(rs.getString(2));
	        ap.setPASDESCRIPTION(rs.getString(3));
	        ap.setPAS_RATING(rs.getDouble(4));
			ap.setPASPRICE(rs.getString(5));
			ap.setPAS_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setPASIMAGES(rs.getString(7));
			ap.setPASDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<PEBBLES_AND_STONES> getAllPotPlanterLoadedByPriceStockRatingSORTPRICE_L_H(int offset, int limit, double from,
			double to, int stock, double rating) {
		String query = "SELECT * FROM PEBBLES_AND_STONES WHERE JSON_EXTRACT(PASPRICE, '$[0].SP') BETWEEN ? AND ? AND PAS_STOCK_AVAILABILITY = ? AND PAS_RATING = ?  order by CAST(JSON_EXTRACT(PASPRICE, '$[0].SP') AS UNSIGNED) LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PEBBLES_AND_STONES> aplist = jdbcTemplate.query(query, new Object[]{from, to,stock,rating,limit, offset}, (rs, num) -> {
		    PEBBLES_AND_STONES ap = new PEBBLES_AND_STONES();
	        ap.setPASID(rs.getString(1));
	        ap.setPASTITLE(rs.getString(2));
	        ap.setPASDESCRIPTION(rs.getString(3));
	        ap.setPAS_RATING(rs.getDouble(4));
			ap.setPASPRICE(rs.getString(5));
			ap.setPAS_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setPASIMAGES(rs.getString(7));
			ap.setPASDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<PEBBLES_AND_STONES> getAllPotPlanterLoadedByPriceStockRatingSORTPRICE_H_L(int offset, int limit, double from,
			double to, int stock, double rating) {
		String query = "SELECT * FROM PEBBLES_AND_STONES WHERE JSON_EXTRACT(PASPRICE, '$[0].SP') BETWEEN ? AND ? AND PAS_STOCK_AVAILABILITY = ? AND PAS_RATING = ?  order by CAST(JSON_EXTRACT(PASPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PEBBLES_AND_STONES> aplist = jdbcTemplate.query(query, new Object[]{from, to,stock,rating,limit, offset}, (rs, num) -> {
		    PEBBLES_AND_STONES ap = new PEBBLES_AND_STONES();
	        ap.setPASID(rs.getString(1));
	        ap.setPASTITLE(rs.getString(2));
	        ap.setPASDESCRIPTION(rs.getString(3));
	        ap.setPAS_RATING(rs.getDouble(4));
			ap.setPASPRICE(rs.getString(5));
			ap.setPAS_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setPASIMAGES(rs.getString(7));
			ap.setPASDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}
	
	
	@Override
	public List<PEBBLES_AND_STONES> Availability(int offset, int limit) {
		String query = "select * from PEBBLES_AND_STONES where PAS_STOCK_AVAILABILITY=1 limit ? offset ?";
		@SuppressWarnings("deprecation")
		List<PEBBLES_AND_STONES> aplist = jdbcTemplate.query(query,new Object[] {limit,offset}, (rs,num)->{
			PEBBLES_AND_STONES ap = new PEBBLES_AND_STONES();
	        ap.setPASID(rs.getString(1));
	        ap.setPASTITLE(rs.getString(2));
	        ap.setPASDESCRIPTION(rs.getString(3));
	        ap.setPAS_RATING(rs.getDouble(4));
			ap.setPASPRICE(rs.getString(5));
			ap.setPAS_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setPASIMAGES(rs.getString(7));
			ap.setPASDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}
	

	@Override
	public List<PEBBLES_AND_STONES> sortZ_A(int offset, int limit) {
		String query = "select * from PEBBLES_AND_STONES order by PASTITLE desc limit ? offset ?";
		@SuppressWarnings("deprecation")
		List<PEBBLES_AND_STONES> aplist = jdbcTemplate.query(query,new Object[] {limit,offset}, (rs,num)->{
			PEBBLES_AND_STONES ap = new PEBBLES_AND_STONES();
	        ap.setPASID(rs.getString(1));
	        ap.setPASTITLE(rs.getString(2));
	        ap.setPASDESCRIPTION(rs.getString(3));
	        ap.setPAS_RATING(rs.getDouble(4));
			ap.setPASPRICE(rs.getString(5));
			ap.setPAS_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setPASIMAGES(rs.getString(7));
			ap.setPASDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}
	
	@Override
	public List<PEBBLES_AND_STONES> Avail_A_Z(int offset, int limit) {
		String query = "select * from PEBBLES_AND_STONES where PAS_STOCK_AVAILABILITY=1 order by PASTITLE limit ? offset ?";
		@SuppressWarnings("deprecation")
		List<PEBBLES_AND_STONES> aplist = jdbcTemplate.query(query,new Object[] {limit,offset}, (rs,num)->{
			PEBBLES_AND_STONES ap = new PEBBLES_AND_STONES();
	        ap.setPASID(rs.getString(1));
	        ap.setPASTITLE(rs.getString(2));
	        ap.setPASDESCRIPTION(rs.getString(3));
	        ap.setPAS_RATING(rs.getDouble(4));
			ap.setPASPRICE(rs.getString(5));
			ap.setPAS_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setPASIMAGES(rs.getString(7));
			ap.setPASDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<PEBBLES_AND_STONES> Avail_Z_A(int offset, int limit) {
		String query = "select * from PEBBLES_AND_STONES where PAS_STOCK_AVAILABILITY=1 order by PASTITLE desc limit ? offset ?";
		@SuppressWarnings("deprecation")
		List<PEBBLES_AND_STONES> aplist = jdbcTemplate.query(query,new Object[] {limit,offset}, (rs,num)->{
			PEBBLES_AND_STONES ap = new PEBBLES_AND_STONES();
	        ap.setPASID(rs.getString(1));
	        ap.setPASTITLE(rs.getString(2));
	        ap.setPASDESCRIPTION(rs.getString(3));
	        ap.setPAS_RATING(rs.getDouble(4));
			ap.setPASPRICE(rs.getString(5));
			ap.setPAS_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setPASIMAGES(rs.getString(7));
			ap.setPASDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<PEBBLES_AND_STONES> getPlantsByPriceLH(int offset, int limit) {
String query = "SELECT * FROM PEBBLES_AND_STONES where PAS_STOCK_AVAILABILITY=1 ORDER BY CAST(JSON_EXTRACT(PASPRICE, '$[0].SP') AS UNSIGNED) ASC LIMIT ? OFFSET ?";
		
	    @SuppressWarnings("deprecation")
		List<PEBBLES_AND_STONES> aplist = jdbcTemplate.query(query,new Object[] {limit,offset},
	        (rs, num) -> {
	        	PEBBLES_AND_STONES ap = new PEBBLES_AND_STONES();
		        ap.setPASID(rs.getString(1));
		        ap.setPASTITLE(rs.getString(2));
		        ap.setPASDESCRIPTION(rs.getString(3));
		        ap.setPAS_RATING(rs.getDouble(4));
				ap.setPASPRICE(rs.getString(5));
				ap.setPAS_STOCK_AVAILABILITY(rs.getInt(6));
				ap.setPASIMAGES(rs.getString(7));
				ap.setPASDETAILS(rs.getString(8));
				return ap;
		    });
			
			return aplist;
	}

	@Override
	public List<PEBBLES_AND_STONES> getPlantsByPriceHL(int offset, int limit) {
String query = "SELECT * FROM PEBBLES_AND_STONES where PAS_STOCK_AVAILABILITY=1 ORDER BY CAST(JSON_EXTRACT(PASPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
		
	    @SuppressWarnings("deprecation")
		List<PEBBLES_AND_STONES> aplist = jdbcTemplate.query(query,new Object[] {limit,offset},
	        (rs, num) -> {
	        	PEBBLES_AND_STONES ap = new PEBBLES_AND_STONES();
		        ap.setPASID(rs.getString(1));
		        ap.setPASTITLE(rs.getString(2));
		        ap.setPASDESCRIPTION(rs.getString(3));
		        ap.setPAS_RATING(rs.getDouble(4));
				ap.setPASPRICE(rs.getString(5));
				ap.setPAS_STOCK_AVAILABILITY(rs.getInt(6));
				ap.setPASIMAGES(rs.getString(7));
				ap.setPASDETAILS(rs.getString(8));
				return ap;
		    });
			
			return aplist;
	}

	@Override
	public List<PEBBLES_AND_STONES> sortA_Z(int offset, int limit) {
		String query = "select * from PEBBLES_AND_STONES order by PASTITLE limit ? offset ?";
		@SuppressWarnings("deprecation")
		List<PEBBLES_AND_STONES> aplist = jdbcTemplate.query(query,new Object[] {limit,offset}, (rs,num)->{
			PEBBLES_AND_STONES ap = new PEBBLES_AND_STONES();
	        ap.setPASID(rs.getString(1));
	        ap.setPASTITLE(rs.getString(2));
	        ap.setPASDESCRIPTION(rs.getString(3));
	        ap.setPAS_RATING(rs.getDouble(4));
			ap.setPASPRICE(rs.getString(5));
			ap.setPAS_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setPASIMAGES(rs.getString(7));
			ap.setPASDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
		}
		
		
	

	@Override
	public List<PEBBLES_AND_STONES> SORTBYPRICE_L_H(int offset, int limit) {
		String query = "SELECT * FROM PEBBLES_AND_STONES order by CAST(JSON_EXTRACT(PASPRICE, '$[0].SP') AS UNSIGNED) ASC LIMIT ? OFFSET ?";
		
	    @SuppressWarnings("deprecation")
		List<PEBBLES_AND_STONES> aplist = jdbcTemplate.query(query,new Object[] {limit,offset},
	        (rs, num) -> {
	        	PEBBLES_AND_STONES ap = new PEBBLES_AND_STONES();
		        ap.setPASID(rs.getString(1));
		        ap.setPASTITLE(rs.getString(2));
		        ap.setPASDESCRIPTION(rs.getString(3));
		        ap.setPAS_RATING(rs.getDouble(4));
				ap.setPASPRICE(rs.getString(5));
				ap.setPAS_STOCK_AVAILABILITY(rs.getInt(6));
				ap.setPASIMAGES(rs.getString(7));
				ap.setPASDETAILS(rs.getString(8));
				return ap;
		    });
			
			return aplist;
	    }

	

	@Override
	public List<PEBBLES_AND_STONES> SORTBYPRICE_H_L(int offset, int limit) {
		String query = "SELECT * FROM PEBBLES_AND_STONES order by CAST(JSON_EXTRACT(PASPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
		
	    @SuppressWarnings("deprecation")
		List<PEBBLES_AND_STONES> aplist = jdbcTemplate.query(query,new Object[] {limit,offset},
	        (rs, num) -> {
	        	PEBBLES_AND_STONES ap = new PEBBLES_AND_STONES();
		        ap.setPASID(rs.getString(1));
		        ap.setPASTITLE(rs.getString(2));
		        ap.setPASDESCRIPTION(rs.getString(3));
		        ap.setPAS_RATING(rs.getDouble(4));
				ap.setPASPRICE(rs.getString(5));
				ap.setPAS_STOCK_AVAILABILITY(rs.getInt(6));
				ap.setPASIMAGES(rs.getString(7));
				ap.setPASDETAILS(rs.getString(8));
				return ap;
		    });
			
			return aplist;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public List<PEBBLES_AND_STONES> getLoadedPlantsFilterSortPHL1(int offset, int limit, double from, double to) {
		String query="SELECT * FROM PEBBLES_AND_STONES WHERE JSON_EXTRACT(PASPRICE, '$[0].SP') BETWEEN ? AND ? ORDER BY cast(JSON_EXTRACT(PASPRICE, '$[0].SP') as unsigned) DESC LIMIT ? OFFSET ?";
		List<PEBBLES_AND_STONES> aplist = jdbcTemplate.query(query,new Object[] {from,to,limit,offset},
		        (rs, num) -> {
		        	PEBBLES_AND_STONES ap = new PEBBLES_AND_STONES();
			        ap.setPASID(rs.getString(1));
			        ap.setPASTITLE(rs.getString(2));
			        ap.setPASDESCRIPTION(rs.getString(3));
			        ap.setPAS_RATING(rs.getDouble(4));
					ap.setPASPRICE(rs.getString(5));
					ap.setPAS_STOCK_AVAILABILITY(rs.getInt(6));
					ap.setPASIMAGES(rs.getString(7));
					ap.setPASDETAILS(rs.getString(8));
					return ap;
			    });
				
				return aplist;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<PEBBLES_AND_STONES> getLoadedPlantsFilterSortPLH1(int offset, int limit, double from, double to) {
		String query="SELECT * FROM PEBBLES_AND_STONES WHERE JSON_EXTRACT(PASPRICE, '$[0].SP') BETWEEN ? AND ? ORDER BY cast(JSON_EXTRACT(PASPRICE, '$[0].SP') as unsigned) ASC LIMIT ? OFFSET ?";
		List<PEBBLES_AND_STONES> aplist = jdbcTemplate.query(query,new Object[] {from,to,limit,offset},
		        (rs, num) -> {
		        	PEBBLES_AND_STONES ap = new PEBBLES_AND_STONES();
			        ap.setPASID(rs.getString(1));
			        ap.setPASTITLE(rs.getString(2));
			        ap.setPASDESCRIPTION(rs.getString(3));
			        ap.setPAS_RATING(rs.getDouble(4));
					ap.setPASPRICE(rs.getString(5));
					ap.setPAS_STOCK_AVAILABILITY(rs.getInt(6));
					ap.setPASIMAGES(rs.getString(7));
					ap.setPASDETAILS(rs.getString(8));
					return ap;
			    });
				
				return aplist;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<PEBBLES_AND_STONES> getLoadedPlantFilterSortAZ1(int offset, int limit, double from, double to) {
		String query ="SELECT * FROM PEBBLES_AND_STONES WHERE JSON_EXTRACT(PASPRICE, '$[0].SP') BETWEEN ? AND ? ORDER BY PASTITLE ASC LIMIT ? OFFSET ? ";
		List<PEBBLES_AND_STONES> aplist = jdbcTemplate.query(query,new Object[] {from,to,limit,offset},
		        (rs, num) -> {
		        	PEBBLES_AND_STONES ap = new PEBBLES_AND_STONES();
			        ap.setPASID(rs.getString(1));
			        ap.setPASTITLE(rs.getString(2));
			        ap.setPASDESCRIPTION(rs.getString(3));
			        ap.setPAS_RATING(rs.getDouble(4));
					ap.setPASPRICE(rs.getString(5));
					ap.setPAS_STOCK_AVAILABILITY(rs.getInt(6));
					ap.setPASIMAGES(rs.getString(7));
					ap.setPASDETAILS(rs.getString(8));
					return ap;
			    });
				
				return aplist;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<PEBBLES_AND_STONES> getLoadedPlantFilterSortZA1(int offset, int limit, double from, double to) {
		String query ="SELECT * FROM PEBBLES_AND_STONES WHERE JSON_EXTRACT(PASPRICE, '$[0].SP') BETWEEN ? AND ? ORDER BY PASTITLE DESC LIMIT ? OFFSET ? ";
		List<PEBBLES_AND_STONES> aplist = jdbcTemplate.query(query,new Object[] {from,to,limit,offset},
		        (rs, num) -> {
		        	PEBBLES_AND_STONES ap = new PEBBLES_AND_STONES();
			        ap.setPASID(rs.getString(1));
			        ap.setPASTITLE(rs.getString(2));
			        ap.setPASDESCRIPTION(rs.getString(3));
			        ap.setPAS_RATING(rs.getDouble(4));
					ap.setPASPRICE(rs.getString(5));
					ap.setPAS_STOCK_AVAILABILITY(rs.getInt(6));
					ap.setPASIMAGES(rs.getString(7));
					ap.setPASDETAILS(rs.getString(8));
					return ap;
			    });
				
				return aplist;
	}
	
	
	@SuppressWarnings("deprecation")
	@Override
	public List<PEBBLES_AND_STONES> getLoadedPlantsFilterSortRHL2(int offset, int limit, double rating) {
		String query ="SELECT * FROM PEBBLES_AND_STONES WHERE PAS_RATING = ? ORDER BY cast(JSON_EXTRACT(PASPRICE, '$[0].SP') as unsigned) DESC LIMIT ? OFFSET ? ";
		List<PEBBLES_AND_STONES> aplist = jdbcTemplate.query(query,new Object[] {rating,limit,offset},
		        (rs, num) -> {
		        	PEBBLES_AND_STONES ap = new PEBBLES_AND_STONES();
			        ap.setPASID(rs.getString(1));
			        ap.setPASTITLE(rs.getString(2));
			        ap.setPASDESCRIPTION(rs.getString(3));
			        ap.setPAS_RATING(rs.getDouble(4));
					ap.setPASPRICE(rs.getString(5));
					ap.setPAS_STOCK_AVAILABILITY(rs.getInt(6));
					ap.setPASIMAGES(rs.getString(7));
					ap.setPASDETAILS(rs.getString(8));
					return ap;
			    });
				
				return aplist;
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<PEBBLES_AND_STONES> getLoadedPlantsFilterSortRLH2(int offset, int limit, double rating) {
		String query ="SELECT * FROM PEBBLES_AND_STONES WHERE PAS_RATING = ? ORDER BY ORDER BY cast(JSON_EXTRACT(PASPRICE, '$[0].SP') as unsigned) ASC LIMIT ? OFFSET ? ";
		List<PEBBLES_AND_STONES> aplist = jdbcTemplate.query(query,new Object[] {rating,limit,offset},
		        (rs, num) -> {
		        	PEBBLES_AND_STONES ap = new PEBBLES_AND_STONES();
			        ap.setPASID(rs.getString(1));
			        ap.setPASTITLE(rs.getString(2));
			        ap.setPASDESCRIPTION(rs.getString(3));
			        ap.setPAS_RATING(rs.getDouble(4));
					ap.setPASPRICE(rs.getString(5));
					ap.setPAS_STOCK_AVAILABILITY(rs.getInt(6));
					ap.setPASIMAGES(rs.getString(7));
					ap.setPASDETAILS(rs.getString(8));
					return ap;
			    });
				
				return aplist;
	}

	@Override
	public List<PEBBLES_AND_STONES> getLoadedPlantsFilterSortRAZ2(int offset, int limit, double rating) {
		String query = "SELECT * FROM PEBBLES_AND_STONES WHERE PAS_RATING = ? ORDER BY PASTITLE ASC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PEBBLES_AND_STONES> aplist = jdbcTemplate.query(query,new Object[] {rating,limit,offset},
		        (rs, num) -> {
		        	PEBBLES_AND_STONES ap = new PEBBLES_AND_STONES();
			        ap.setPASID(rs.getString(1));
			        ap.setPASTITLE(rs.getString(2));
			        ap.setPASDESCRIPTION(rs.getString(3));
			        ap.setPAS_RATING(rs.getDouble(4));
					ap.setPASPRICE(rs.getString(5));
					ap.setPAS_STOCK_AVAILABILITY(rs.getInt(6));
					ap.setPASIMAGES(rs.getString(7));
					ap.setPASDETAILS(rs.getString(8));
					return ap;
			    });
				
				return aplist;
	}

	@Override
	public List<PEBBLES_AND_STONES> getLoadedPlantsFilterSortRZA2(int offset, int limit, double rating) {
String query = "SELECT * FROM PEBBLES_AND_STONES WHERE PAS_RATING = ? ORDER BY PTITLE DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PEBBLES_AND_STONES> aplist = jdbcTemplate.query(query,new Object[] {rating,limit,offset},
		        (rs, num) -> {
		        	PEBBLES_AND_STONES ap = new PEBBLES_AND_STONES();
			        ap.setPASID(rs.getString(1));
			        ap.setPASTITLE(rs.getString(2));
			        ap.setPASDESCRIPTION(rs.getString(3));
			        ap.setPAS_RATING(rs.getDouble(4));
					ap.setPASPRICE(rs.getString(5));
					ap.setPAS_STOCK_AVAILABILITY(rs.getInt(6));
					ap.setPASIMAGES(rs.getString(7));
					ap.setPASDETAILS(rs.getString(8));
					return ap;
			    });
				
				return aplist;
	}
	
	
	
}
