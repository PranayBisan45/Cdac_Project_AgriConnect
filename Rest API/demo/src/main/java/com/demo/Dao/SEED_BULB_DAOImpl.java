package com.demo.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.Model.SEED_BULB;

@Repository
public class SEED_BULB_DAOImpl implements SEED_BULB_DAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<SEED_BULB> getallartificialplant() {
		List<SEED_BULB> aplist = jdbcTemplate.query("Select * from SEED_BULB",(rs,num)->{
			SEED_BULB ap = new SEED_BULB();
			ap.setSBID(rs.getString(1));
			ap.setSBTITLE(rs.getString(2));
			ap.setSBDESCRIPTION(rs.getString(3));
			ap.setSB_RATING(rs.getDouble(4));
			ap.setSBPRICE(rs.getString(5));
			ap.setSB_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setSBIMAGES(rs.getString(7));
			ap.setSBDETAILS(rs.getString(8));	
			
			return ap;	
		});
			
		return aplist;
	}

	@SuppressWarnings("deprecation")
	@Override
	public SEED_BULB getbyid(String SBID) {
		String query = "select * from SEED_BULB where SBID=?";
		SEED_BULB pp = new SEED_BULB();
		try {
		    return jdbcTemplate.queryForObject(query,new Object[] {SBID},BeanPropertyRowMapper.newInstance(SEED_BULB.class));
		}catch(EmptyResultDataAccessException e) {
			return null;
		}		
	}

	@Override
	public List<SEED_BULB> getAllPotPlanterLoaded(int offset, int limit) {
		@SuppressWarnings("deprecation")
		List<SEED_BULB> aplist = jdbcTemplate.query("Select * from SEED_BULB  LIMIT ? OFFSET ?", new Object[]{limit, offset},(rs,num)->{
			SEED_BULB ap = new SEED_BULB();
			ap.setSBID(rs.getString(1));
			ap.setSBTITLE(rs.getString(2));
			ap.setSBDESCRIPTION(rs.getString(3));
			ap.setSB_RATING(rs.getDouble(4));
			ap.setSBPRICE(rs.getString(5));
			ap.setSB_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setSBIMAGES(rs.getString(7));
			ap.setSBDETAILS(rs.getString(8));
			ap.setQuantity(rs.getInt(9));
			
			return ap;	
		});
		return aplist;
	}

	@Override
	public List<SEED_BULB> getallpotplanterloadedrating(int offset, int limit, double rating) {
		@SuppressWarnings("deprecation")
		List<SEED_BULB> aplist = jdbcTemplate.query("Select * from SEED_BULB where aprating = ? LIMIT ? OFFSET ?", new Object[]{rating,limit, offset},(rs,num)->{
			SEED_BULB ap = new SEED_BULB();
			ap.setSBID(rs.getString(1));
			ap.setSBTITLE(rs.getString(2));
			ap.setSBDESCRIPTION(rs.getString(3));
			ap.setSB_RATING(rs.getDouble(4));
			ap.setSBPRICE(rs.getString(5));
			ap.setSB_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setSBIMAGES(rs.getString(7));
			ap.setSBDETAILS(rs.getString(8));
			
			return ap;	
		});
		return aplist;
	}
	
	
	@Override
	public List<SEED_BULB> getAllPotPlanterLoadedByPrice(int offset, int limit, double from, double to) {
		String query = "SELECT * FROM SEED_BULB WHERE JSON_EXTRACT(SBPRICE, '$[0].SP') BETWEEN ? AND ? LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<SEED_BULB> aplist = jdbcTemplate.query(query, new Object[]{from, to ,limit, offset}, (rs, num) -> {
	        SEED_BULB ap = new SEED_BULB();
	        ap.setSBID(rs.getString(1));
	        ap.setSBTITLE(rs.getString(2));
	        ap.setSBDESCRIPTION(rs.getString(3));
	        ap.setSB_RATING(rs.getDouble(4));
			ap.setSBPRICE(rs.getString(5));
			ap.setSB_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setSBIMAGES(rs.getString(7));
			ap.setSBDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<SEED_BULB> getAllPotPlanterLoadedByRatingPrice(int offset, int limit, double rating, double from,
			double to) {
		
		String query = "SELECT * FROM SEED_BULB WHERE SB_RATING = ? AND JSON_EXTRACT(SBPRICE, '$[0].SP') BETWEEN ? AND ? LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<SEED_BULB> aplist = jdbcTemplate.query(query, new Object[]{rating, from, to ,limit, offset}, (rs, num) -> {
		    SEED_BULB ap = new SEED_BULB();
	        ap.setSBID(rs.getString(1));
	        ap.setSBTITLE(rs.getString(2));
	        ap.setSBDESCRIPTION(rs.getString(3));
	        ap.setSB_RATING(rs.getDouble(4));
			ap.setSBPRICE(rs.getString(5));
			ap.setSB_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setSBIMAGES(rs.getString(7));
			ap.setSBDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<SEED_BULB> getAllPotPlanterLoadedByRatingStock(int offset, int limit, double rating, int stock) {
		String query = "SELECT * FROM SEED_BULB WHERE SB_RATING = ? AND SB_STOCK_AVAILABILITY = ? LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<SEED_BULB> aplist = jdbcTemplate.query(query, new Object[]{rating,stock,limit, offset}, (rs, num) -> {
		    SEED_BULB ap = new SEED_BULB();
	        ap.setSBID(rs.getString(1));
	        ap.setSBTITLE(rs.getString(2));
	        ap.setSBDESCRIPTION(rs.getString(3));
	        ap.setSB_RATING(rs.getDouble(4));
			ap.setSBPRICE(rs.getString(5));
			ap.setSB_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setSBIMAGES(rs.getString(7));
			ap.setSBDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
		
	}

	@Override
	public List<SEED_BULB> getAllPotPlanterLoadedByPriceStock(int offset, int limit, double from, double to,
			int stock) {
		String query = "SELECT * FROM SEED_BULB WHERE JSON_EXTRACT(SBPRICE, '$[0].SP') BETWEEN ? AND ? AND SB_STOCK_AVAILABILITY = ? LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<SEED_BULB> aplist = jdbcTemplate.query(query, new Object[]{from, to,stock,limit, offset}, (rs, num) -> {
		    SEED_BULB ap = new SEED_BULB();
	        ap.setSBID(rs.getString(1));
	        ap.setSBTITLE(rs.getString(2));
	        ap.setSBDESCRIPTION(rs.getString(3));
	        ap.setSB_RATING(rs.getDouble(4));
			ap.setSBPRICE(rs.getString(5));
			ap.setSB_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setSBIMAGES(rs.getString(7));
			ap.setSBDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<SEED_BULB> getAllPotPlanterLoadedByPriceStockRating(int offset, int limit, double from, double to,
			int stock, double rating) {
		
		String query = "SELECT * FROM SEED_BULB WHERE JSON_EXTRACT(SBPRICE, '$[0].SP') BETWEEN ? AND ? AND SB_STOCK_AVAILABILITY = ? AND SB_RATING = ? LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<SEED_BULB> aplist = jdbcTemplate.query(query, new Object[]{from, to,stock,rating,limit, offset}, (rs, num) -> {
		    SEED_BULB ap = new SEED_BULB();
	        ap.setSBID(rs.getString(1));
	        ap.setSBTITLE(rs.getString(2));
	        ap.setSBDESCRIPTION(rs.getString(3));
	        ap.setSB_RATING(rs.getDouble(4));
			ap.setSBPRICE(rs.getString(5));
			ap.setSB_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setSBIMAGES(rs.getString(7));
			ap.setSBDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;		
	}

	@Override
	public List<SEED_BULB> getAllPotPlanterLoadedByRatingPriceSORTTITLE_A_Z(int offset, int limit, double rating,
			double from, double to) {
		String query = "SELECT * FROM SEED_BULB WHERE SB_RATING = ? AND JSON_EXTRACT(SBPRICE, '$[0].SP') BETWEEN ? AND ? Order by SBTITLE LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<SEED_BULB> aplist = jdbcTemplate.query(query, new Object[]{rating, from, to ,limit, offset}, (rs, num) -> {
		    SEED_BULB ap = new SEED_BULB();
	        ap.setSBID(rs.getString(1));
	        ap.setSBTITLE(rs.getString(2));
	        ap.setSBDESCRIPTION(rs.getString(3));
	        ap.setSB_RATING(rs.getDouble(4));
			ap.setSBPRICE(rs.getString(5));
			ap.setSB_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setSBIMAGES(rs.getString(7));
			ap.setSBDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<SEED_BULB> getAllPotPlanterLoadedByRatingPriceSORTTITLE_Z_A(int offset, int limit, double rating,
			double from, double to) {
		String query = "SELECT * FROM SEED_BULB WHERE SB_RATING = ? AND JSON_EXTRACT(SBPRICE, '$[0].SP') BETWEEN ? AND ? Order by SBTITLE DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<SEED_BULB> aplist = jdbcTemplate.query(query, new Object[]{rating, from, to ,limit, offset}, (rs, num) -> {
		    SEED_BULB ap = new SEED_BULB();
	        ap.setSBID(rs.getString(1));
	        ap.setSBTITLE(rs.getString(2));
	        ap.setSBDESCRIPTION(rs.getString(3));
	        ap.setSB_RATING(rs.getDouble(4));
			ap.setSBPRICE(rs.getString(5));
			ap.setSB_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setSBIMAGES(rs.getString(7));
			ap.setSBDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}
	
	

	@Override
	public List<SEED_BULB> getAllPotPlanterLoadedByRatingPriceSORTPRICE_L_H(int offset, int limit, double rating,
			double from, double to) {
		String query = "SELECT * FROM SEED_BULB WHERE SB_RATING = ? AND JSON_EXTRACT(SBPRICE, '$[0].SP') BETWEEN ? AND ?  order by CAST(JSON_EXTRACT(SBPRICE, '$[0].SP') AS UNSIGNED) LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<SEED_BULB> aplist = jdbcTemplate.query(query, new Object[]{rating, from, to ,limit, offset}, (rs, num) -> {
		    SEED_BULB ap = new SEED_BULB();
	        ap.setSBID(rs.getString(1));
	        ap.setSBTITLE(rs.getString(2));
	        ap.setSBDESCRIPTION(rs.getString(3));
	        ap.setSB_RATING(rs.getDouble(4));
			ap.setSBPRICE(rs.getString(5));
			ap.setSB_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setSBIMAGES(rs.getString(7));
			ap.setSBDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;	}

	@Override
	public List<SEED_BULB> getAllPotPlanterLoadedByRatingPriceSORTPRICE_H_L(int offset, int limit, double rating,
			double from, double to) {
String query = "SELECT * FROM SEED_BULB WHERE SB_RATING = ? AND JSON_EXTRACT(SBPRICE, '$[0].SP') BETWEEN ? AND ?  order by CAST(JSON_EXTRACT(SBPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<SEED_BULB> aplist = jdbcTemplate.query(query, new Object[]{rating, from, to ,limit, offset}, (rs, num) -> {
		    SEED_BULB ap = new SEED_BULB();
	        ap.setSBID(rs.getString(1));
	        ap.setSBTITLE(rs.getString(2));
	        ap.setSBDESCRIPTION(rs.getString(3));
	        ap.setSB_RATING(rs.getDouble(4));
			ap.setSBPRICE(rs.getString(5));
			ap.setSB_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setSBIMAGES(rs.getString(7));
			ap.setSBDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<SEED_BULB> getAllPotPlanterLoadedByRatingStockSORTTITLE_A_Z(int offset, int limit, double rating,
			int stock) {
		String query = "SELECT * FROM SEED_BULB WHERE SB_RATING = ? AND SB_STOCK_AVAILABILITY = ? Order by SBTITLE LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<SEED_BULB> aplist = jdbcTemplate.query(query, new Object[]{rating,stock,limit, offset}, (rs, num) -> {
		    SEED_BULB ap = new SEED_BULB();
	        ap.setSBID(rs.getString(1));
	        ap.setSBTITLE(rs.getString(2));
	        ap.setSBDESCRIPTION(rs.getString(3));
	        ap.setSB_RATING(rs.getDouble(4));
			ap.setSBPRICE(rs.getString(5));
			ap.setSB_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setSBIMAGES(rs.getString(7));
			ap.setSBDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;	}

	@Override
	public List<SEED_BULB> getAllPotPlanterLoadedByRatingStockSORTTITLE_Z_A(int offset, int limit, double rating,
			int stock) {
		String query = "SELECT * FROM SEED_BULB WHERE SB_RATING = ? AND SB_STOCK_AVAILABILITY = ? Order by SBTITLE DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<SEED_BULB> aplist = jdbcTemplate.query(query, new Object[]{rating,stock,limit, offset}, (rs, num) -> {
		    SEED_BULB ap = new SEED_BULB();
	        ap.setSBID(rs.getString(1));
	        ap.setSBTITLE(rs.getString(2));
	        ap.setSBDESCRIPTION(rs.getString(3));
	        ap.setSB_RATING(rs.getDouble(4));
			ap.setSBPRICE(rs.getString(5));
			ap.setSB_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setSBIMAGES(rs.getString(7));
			ap.setSBDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
		
	}

	@Override
	public List<SEED_BULB> getAllPotPlanterLoadedByRatingStockSORTPRICE_L_H(int offset, int limit, double rating,
			int stock) {
		String query = "SELECT * FROM SEED_BULB WHERE SB_RATING = ? AND SB_STOCK_AVAILABILITY = ?  order by CAST(JSON_EXTRACT(SBPRICE, '$[0].SP') AS UNSIGNED) LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<SEED_BULB> aplist = jdbcTemplate.query(query, new Object[]{rating,stock,limit, offset}, (rs, num) -> {
		    SEED_BULB ap = new SEED_BULB();
	        ap.setSBID(rs.getString(1));
	        ap.setSBTITLE(rs.getString(2));
	        ap.setSBDESCRIPTION(rs.getString(3));
	        ap.setSB_RATING(rs.getDouble(4));
			ap.setSBPRICE(rs.getString(5));
			ap.setSB_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setSBIMAGES(rs.getString(7));
			ap.setSBDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<SEED_BULB> getAllPotPlanterLoadedByRatingStockSORTPRICE_H_L(int offset, int limit, double rating,
			int stock) {
String query = "SELECT * FROM SEED_BULB WHERE SB_RATING = ? AND SB_STOCK_AVAILABILITY = ?  order by CAST(JSON_EXTRACT(SBPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<SEED_BULB> aplist = jdbcTemplate.query(query, new Object[]{rating,stock,limit, offset}, (rs, num) -> {
		    SEED_BULB ap = new SEED_BULB();
	        ap.setSBID(rs.getString(1));
	        ap.setSBTITLE(rs.getString(2));
	        ap.setSBDESCRIPTION(rs.getString(3));
	        ap.setSB_RATING(rs.getDouble(4));
			ap.setSBPRICE(rs.getString(5));
			ap.setSB_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setSBIMAGES(rs.getString(7));
			ap.setSBDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<SEED_BULB> getAllPotPlanterLoadedByPriceStockSORTTITLE_A_Z(int offset, int limit, double from,
			double to, int stock) {
		String query = "SELECT * FROM SEED_BULB WHERE JSON_EXTRACT(SBPRICE, '$[0].SP') BETWEEN ? AND ? AND SB_STOCK_AVAILABILITY = ? ORDER BY SBTITLE LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<SEED_BULB> aplist = jdbcTemplate.query(query, new Object[]{from, to,stock,limit, offset}, (rs, num) -> {
		    SEED_BULB ap = new SEED_BULB();
	        ap.setSBID(rs.getString(1));
	        ap.setSBTITLE(rs.getString(2));
	        ap.setSBDESCRIPTION(rs.getString(3));
	        ap.setSB_RATING(rs.getDouble(4));
			ap.setSBPRICE(rs.getString(5));
			ap.setSB_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setSBIMAGES(rs.getString(7));
			ap.setSBDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
		
	}

	@Override
	public List<SEED_BULB> getAllPotPlanterLoadedByPriceStockSORTTITLE_Z_A(int offset, int limit, double from,
			double to, int stock) {
		String query = "SELECT * FROM SEED_BULB WHERE JSON_EXTRACT(SBPRICE, '$[0].SP') BETWEEN ? AND ? AND SB_STOCK_AVAILABILITY = ? ORDER BY SBTITLE DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<SEED_BULB> aplist = jdbcTemplate.query(query, new Object[]{from, to,stock,limit, offset}, (rs, num) -> {
		    SEED_BULB ap = new SEED_BULB();
	        ap.setSBID(rs.getString(1));
	        ap.setSBTITLE(rs.getString(2));
	        ap.setSBDESCRIPTION(rs.getString(3));
	        ap.setSB_RATING(rs.getDouble(4));
			ap.setSBPRICE(rs.getString(5));
			ap.setSB_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setSBIMAGES(rs.getString(7));
			ap.setSBDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<SEED_BULB> getAllPotPlanterLoadedByPriceStockSORTPRICE_L_H(int offset, int limit, double from,
			double to, int stock) {
		String query = "SELECT * FROM SEED_BULB WHERE JSON_EXTRACT(SBPRICE, '$[0].SP') BETWEEN ? AND ? AND SB_STOCK_AVAILABILITY = ?  order by CAST(JSON_EXTRACT(SBPRICE, '$[0].SP') AS UNSIGNED) LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<SEED_BULB> aplist = jdbcTemplate.query(query, new Object[]{from, to,stock,limit, offset}, (rs, num) -> {
		    SEED_BULB ap = new SEED_BULB();
	        ap.setSBID(rs.getString(1));
	        ap.setSBTITLE(rs.getString(2));
	        ap.setSBDESCRIPTION(rs.getString(3));
	        ap.setSB_RATING(rs.getDouble(4));
			ap.setSBPRICE(rs.getString(5));
			ap.setSB_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setSBIMAGES(rs.getString(7));
			ap.setSBDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<SEED_BULB> getAllPotPlanterLoadedByPriceStockSORTPRICE_H_L(int offset, int limit, double from,
			double to, int stock) {
		String query = "SELECT * FROM SEED_BULB WHERE JSON_EXTRACT(SBPRICE, '$[0].SP') BETWEEN ? AND ? AND SB_STOCK_AVAILABILITY = ?  order by CAST(JSON_EXTRACT(SBPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<SEED_BULB> aplist = jdbcTemplate.query(query, new Object[]{from, to,stock,limit, offset}, (rs, num) -> {
		    SEED_BULB ap = new SEED_BULB();
	        ap.setSBID(rs.getString(1));
	        ap.setSBTITLE(rs.getString(2));
	        ap.setSBDESCRIPTION(rs.getString(3));
	        ap.setSB_RATING(rs.getDouble(4));
			ap.setSBPRICE(rs.getString(5));
			ap.setSB_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setSBIMAGES(rs.getString(7));
			ap.setSBDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<SEED_BULB> getAllPotPlanterLoadedByPriceStockRatingSORTTITLE_A_Z(int offset, int limit, double from,
			double to, int stock, double rating) {
		String query = "SELECT * FROM SEED_BULB WHERE JSON_EXTRACT(SBPRICE, '$[0].SP') BETWEEN ? AND ? AND SB_STOCK_AVAILABILITY = ? AND SB_RATING = ? ORDER BY SBTITLE LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<SEED_BULB> aplist = jdbcTemplate.query(query, new Object[]{from, to,stock,rating,limit, offset}, (rs, num) -> {
		    SEED_BULB ap = new SEED_BULB();
	        ap.setSBID(rs.getString(1));
	        ap.setSBTITLE(rs.getString(2));
	        ap.setSBDESCRIPTION(rs.getString(3));
	        ap.setSB_RATING(rs.getDouble(4));
			ap.setSBPRICE(rs.getString(5));
			ap.setSB_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setSBIMAGES(rs.getString(7));
			ap.setSBDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<SEED_BULB> getAllPotPlanterLoadedByPriceStockRatingSORTTITLE_Z_A(int offset, int limit, double from,
			double to, int stock, double rating) {
		String query = "SELECT * FROM SEED_BULB WHERE JSON_EXTRACT(SBPRICE, '$[0].SP') BETWEEN ? AND ? AND SB_STOCK_AVAILABILITY = ? AND SB_RATING = ? ORDER BY SBTITLE DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<SEED_BULB> aplist = jdbcTemplate.query(query, new Object[]{from, to,stock,rating,limit, offset}, (rs, num) -> {
		    SEED_BULB ap = new SEED_BULB();
	        ap.setSBID(rs.getString(1));
	        ap.setSBTITLE(rs.getString(2));
	        ap.setSBDESCRIPTION(rs.getString(3));
	        ap.setSB_RATING(rs.getDouble(4));
			ap.setSBPRICE(rs.getString(5));
			ap.setSB_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setSBIMAGES(rs.getString(7));
			ap.setSBDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<SEED_BULB> getAllPotPlanterLoadedByPriceStockRatingSORTPRICE_L_H(int offset, int limit, double from,
			double to, int stock, double rating) {
		String query = "SELECT * FROM SEED_BULB WHERE JSON_EXTRACT(SBPRICE, '$[0].SP') BETWEEN ? AND ? AND SB_STOCK_AVAILABILITY = ? AND SB_RATING = ?  order by CAST(JSON_EXTRACT(SBPRICE, '$[0].SP') AS UNSIGNED) LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<SEED_BULB> aplist = jdbcTemplate.query(query, new Object[]{from, to,stock,rating,limit, offset}, (rs, num) -> {
		    SEED_BULB ap = new SEED_BULB();
	        ap.setSBID(rs.getString(1));
	        ap.setSBTITLE(rs.getString(2));
	        ap.setSBDESCRIPTION(rs.getString(3));
	        ap.setSB_RATING(rs.getDouble(4));
			ap.setSBPRICE(rs.getString(5));
			ap.setSB_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setSBIMAGES(rs.getString(7));
			ap.setSBDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<SEED_BULB> getAllPotPlanterLoadedByPriceStockRatingSORTPRICE_H_L(int offset, int limit, double from,
			double to, int stock, double rating) {
		String query = "SELECT * FROM SEED_BULB WHERE JSON_EXTRACT(SBPRICE, '$[0].SP') BETWEEN ? AND ? AND SB_STOCK_AVAILABILITY = ? AND SB_RATING = ?  order by CAST(JSON_EXTRACT(SBPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<SEED_BULB> aplist = jdbcTemplate.query(query, new Object[]{from, to,stock,rating,limit, offset}, (rs, num) -> {
		    SEED_BULB ap = new SEED_BULB();
	        ap.setSBID(rs.getString(1));
	        ap.setSBTITLE(rs.getString(2));
	        ap.setSBDESCRIPTION(rs.getString(3));
	        ap.setSB_RATING(rs.getDouble(4));
			ap.setSBPRICE(rs.getString(5));
			ap.setSB_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setSBIMAGES(rs.getString(7));
			ap.setSBDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}
	
	
	@Override
	public List<SEED_BULB> Availability(int offset, int limit) {
		String query = "select * from SEED_BULB where SB_STOCK_AVAILABILITY=1 limit ? offset ?";
		@SuppressWarnings("deprecation")
		List<SEED_BULB> aplist = jdbcTemplate.query(query,new Object[] {limit,offset}, (rs,num)->{
			SEED_BULB ap = new SEED_BULB();
	        ap.setSBID(rs.getString(1));
	        ap.setSBTITLE(rs.getString(2));
	        ap.setSBDESCRIPTION(rs.getString(3));
	        ap.setSB_RATING(rs.getDouble(4));
			ap.setSBPRICE(rs.getString(5));
			ap.setSB_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setSBIMAGES(rs.getString(7));
			ap.setSBDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}
	

	@Override
	public List<SEED_BULB> sortZ_A(int offset, int limit) {
		String query = "select * from SEED_BULB order by SBTITLE desc limit ? offset ?";
		@SuppressWarnings("deprecation")
		List<SEED_BULB> aplist = jdbcTemplate.query(query,new Object[] {limit,offset}, (rs,num)->{
			SEED_BULB ap = new SEED_BULB();
	        ap.setSBID(rs.getString(1));
	        ap.setSBTITLE(rs.getString(2));
	        ap.setSBDESCRIPTION(rs.getString(3));
	        ap.setSB_RATING(rs.getDouble(4));
			ap.setSBPRICE(rs.getString(5));
			ap.setSB_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setSBIMAGES(rs.getString(7));
			ap.setSBDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}
	
	@Override
	public List<SEED_BULB> Avail_A_Z(int offset, int limit) {
		String query = "select * from SEED_BULB where SB_STOCK_AVAILABILITY=1 order by SBTITLE limit ? offset ?";
		@SuppressWarnings("deprecation")
		List<SEED_BULB> aplist = jdbcTemplate.query(query,new Object[] {limit,offset}, (rs,num)->{
			SEED_BULB ap = new SEED_BULB();
	        ap.setSBID(rs.getString(1));
	        ap.setSBTITLE(rs.getString(2));
	        ap.setSBDESCRIPTION(rs.getString(3));
	        ap.setSB_RATING(rs.getDouble(4));
			ap.setSBPRICE(rs.getString(5));
			ap.setSB_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setSBIMAGES(rs.getString(7));
			ap.setSBDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<SEED_BULB> Avail_Z_A(int offset, int limit) {
		String query = "select * from SEED_BULB where SB_STOCK_AVAILABILITY=1 order by SBTITLE desc limit ? offset ?";
		@SuppressWarnings("deprecation")
		List<SEED_BULB> aplist = jdbcTemplate.query(query,new Object[] {limit,offset}, (rs,num)->{
			SEED_BULB ap = new SEED_BULB();
	        ap.setSBID(rs.getString(1));
	        ap.setSBTITLE(rs.getString(2));
	        ap.setSBDESCRIPTION(rs.getString(3));
	        ap.setSB_RATING(rs.getDouble(4));
			ap.setSBPRICE(rs.getString(5));
			ap.setSB_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setSBIMAGES(rs.getString(7));
			ap.setSBDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<SEED_BULB> getPlantsByPriceLH(int offset, int limit) {
String query = "SELECT * FROM SEED_BULB where SB_STOCK_AVAILABILITY=1 ORDER BY CAST(JSON_EXTRACT(SBPRICE, '$[0].SP') AS UNSIGNED) ASC LIMIT ? OFFSET ?";
		
	    @SuppressWarnings("deprecation")
		List<SEED_BULB> aplist = jdbcTemplate.query(query,new Object[] {limit,offset},
	        (rs, num) -> {
	        	SEED_BULB ap = new SEED_BULB();
		        ap.setSBID(rs.getString(1));
		        ap.setSBTITLE(rs.getString(2));
		        ap.setSBDESCRIPTION(rs.getString(3));
		        ap.setSB_RATING(rs.getDouble(4));
				ap.setSBPRICE(rs.getString(5));
				ap.setSB_STOCK_AVAILABILITY(rs.getInt(6));
				ap.setSBIMAGES(rs.getString(7));
				ap.setSBDETAILS(rs.getString(8));
				return ap;
		    });
			
			return aplist;
	}

	@Override
	public List<SEED_BULB> getPlantsByPriceHL(int offset, int limit) {
String query = "SELECT * FROM SEED_BULB where SB_STOCK_AVAILABILITY=1 ORDER BY CAST(JSON_EXTRACT(SBPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
		
	    @SuppressWarnings("deprecation")
		List<SEED_BULB> aplist = jdbcTemplate.query(query,new Object[] {limit,offset},
	        (rs, num) -> {
	        	SEED_BULB ap = new SEED_BULB();
		        ap.setSBID(rs.getString(1));
		        ap.setSBTITLE(rs.getString(2));
		        ap.setSBDESCRIPTION(rs.getString(3));
		        ap.setSB_RATING(rs.getDouble(4));
				ap.setSBPRICE(rs.getString(5));
				ap.setSB_STOCK_AVAILABILITY(rs.getInt(6));
				ap.setSBIMAGES(rs.getString(7));
				ap.setSBDETAILS(rs.getString(8));
				return ap;
		    });
			
			return aplist;
	}

	@Override
	public List<SEED_BULB> sortA_Z(int offset, int limit) {
		String query = "select * from SEED_BULB order by SBTITLE limit ? offset ?";
		@SuppressWarnings("deprecation")
		List<SEED_BULB> aplist = jdbcTemplate.query(query,new Object[] {limit,offset}, (rs,num)->{
			SEED_BULB ap = new SEED_BULB();
	        ap.setSBID(rs.getString(1));
	        ap.setSBTITLE(rs.getString(2));
	        ap.setSBDESCRIPTION(rs.getString(3));
	        ap.setSB_RATING(rs.getDouble(4));
			ap.setSBPRICE(rs.getString(5));
			ap.setSB_STOCK_AVAILABILITY(rs.getInt(6));
			ap.setSBIMAGES(rs.getString(7));
			ap.setSBDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
		}
		
		
	

	@Override
	public List<SEED_BULB> SORTBYPRICE_L_H(int offset, int limit) {
		String query = "SELECT * FROM SEED_BULB order by CAST(JSON_EXTRACT(SBPRICE, '$[0].SP') AS UNSIGNED) ASC LIMIT ? OFFSET ?";
		
	    @SuppressWarnings("deprecation")
		List<SEED_BULB> aplist = jdbcTemplate.query(query,new Object[] {limit,offset},
	        (rs, num) -> {
	        	SEED_BULB ap = new SEED_BULB();
		        ap.setSBID(rs.getString(1));
		        ap.setSBTITLE(rs.getString(2));
		        ap.setSBDESCRIPTION(rs.getString(3));
		        ap.setSB_RATING(rs.getDouble(4));
				ap.setSBPRICE(rs.getString(5));
				ap.setSB_STOCK_AVAILABILITY(rs.getInt(6));
				ap.setSBIMAGES(rs.getString(7));
				ap.setSBDETAILS(rs.getString(8));
				return ap;
		    });
			
			return aplist;
	    }

	

	@Override
	public List<SEED_BULB> SORTBYPRICE_H_L(int offset, int limit) {
		String query = "SELECT * FROM SEED_BULB order by CAST(JSON_EXTRACT(SBPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
		
	    @SuppressWarnings("deprecation")
		List<SEED_BULB> aplist = jdbcTemplate.query(query,new Object[] {limit,offset},
	        (rs, num) -> {
	        	SEED_BULB ap = new SEED_BULB();
		        ap.setSBID(rs.getString(1));
		        ap.setSBTITLE(rs.getString(2));
		        ap.setSBDESCRIPTION(rs.getString(3));
		        ap.setSB_RATING(rs.getDouble(4));
				ap.setSBPRICE(rs.getString(5));
				ap.setSB_STOCK_AVAILABILITY(rs.getInt(6));
				ap.setSBIMAGES(rs.getString(7));
				ap.setSBDETAILS(rs.getString(8));
				return ap;
		    });
			
			return aplist;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public List<SEED_BULB> getLoadedPlantsFilterSortPHL1(int offset, int limit, double from, double to) {
		String query="SELECT * FROM SEED_BULB WHERE JSON_EXTRACT(SBPRICE, '$[0].SP') BETWEEN ? AND ? ORDER BY cast(JSON_EXTRACT(SBPRICE, '$[0].SP') as unsigned) DESC LIMIT ? OFFSET ?";
		List<SEED_BULB> aplist = jdbcTemplate.query(query,new Object[] {from,to,limit,offset},
		        (rs, num) -> {
		        	SEED_BULB ap = new SEED_BULB();
			        ap.setSBID(rs.getString(1));
			        ap.setSBTITLE(rs.getString(2));
			        ap.setSBDESCRIPTION(rs.getString(3));
			        ap.setSB_RATING(rs.getDouble(4));
					ap.setSBPRICE(rs.getString(5));
					ap.setSB_STOCK_AVAILABILITY(rs.getInt(6));
					ap.setSBIMAGES(rs.getString(7));
					ap.setSBDETAILS(rs.getString(8));
					return ap;
			    });
				
				return aplist;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<SEED_BULB> getLoadedPlantsFilterSortPLH1(int offset, int limit, double from, double to) {
		String query="SELECT * FROM SEED_BULB WHERE JSON_EXTRACT(SBPRICE, '$[0].SP') BETWEEN ? AND ? ORDER BY cast(JSON_EXTRACT(SBPRICE, '$[0].SP') as unsigned) ASC LIMIT ? OFFSET ?";
		List<SEED_BULB> aplist = jdbcTemplate.query(query,new Object[] {from,to,limit,offset},
		        (rs, num) -> {
		        	SEED_BULB ap = new SEED_BULB();
			        ap.setSBID(rs.getString(1));
			        ap.setSBTITLE(rs.getString(2));
			        ap.setSBDESCRIPTION(rs.getString(3));
			        ap.setSB_RATING(rs.getDouble(4));
					ap.setSBPRICE(rs.getString(5));
					ap.setSB_STOCK_AVAILABILITY(rs.getInt(6));
					ap.setSBIMAGES(rs.getString(7));
					ap.setSBDETAILS(rs.getString(8));
					return ap;
			    });
				
				return aplist;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<SEED_BULB> getLoadedPlantFilterSortAZ1(int offset, int limit, double from, double to) {
		String query ="SELECT * FROM SEED_BULB WHERE JSON_EXTRACT(SBPRICE, '$[0].SP') BETWEEN ? AND ? ORDER BY SBTITLE ASC LIMIT ? OFFSET ? ";
		List<SEED_BULB> aplist = jdbcTemplate.query(query,new Object[] {from,to,limit,offset},
		        (rs, num) -> {
		        	SEED_BULB ap = new SEED_BULB();
			        ap.setSBID(rs.getString(1));
			        ap.setSBTITLE(rs.getString(2));
			        ap.setSBDESCRIPTION(rs.getString(3));
			        ap.setSB_RATING(rs.getDouble(4));
					ap.setSBPRICE(rs.getString(5));
					ap.setSB_STOCK_AVAILABILITY(rs.getInt(6));
					ap.setSBIMAGES(rs.getString(7));
					ap.setSBDETAILS(rs.getString(8));
					return ap;
			    });
				
				return aplist;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<SEED_BULB> getLoadedPlantFilterSortZA1(int offset, int limit, double from, double to) {
		String query ="SELECT * FROM SEED_BULB WHERE JSON_EXTRACT(SBPRICE, '$[0].SP') BETWEEN ? AND ? ORDER BY SBTITLE DESC LIMIT ? OFFSET ? ";
		List<SEED_BULB> aplist = jdbcTemplate.query(query,new Object[] {from,to,limit,offset},
		        (rs, num) -> {
		        	SEED_BULB ap = new SEED_BULB();
			        ap.setSBID(rs.getString(1));
			        ap.setSBTITLE(rs.getString(2));
			        ap.setSBDESCRIPTION(rs.getString(3));
			        ap.setSB_RATING(rs.getDouble(4));
					ap.setSBPRICE(rs.getString(5));
					ap.setSB_STOCK_AVAILABILITY(rs.getInt(6));
					ap.setSBIMAGES(rs.getString(7));
					ap.setSBDETAILS(rs.getString(8));
					return ap;
			    });
				
				return aplist;
	}
	
	
	@SuppressWarnings("deprecation")
	@Override
	public List<SEED_BULB> getLoadedPlantsFilterSortRHL2(int offset, int limit, double rating) {
		String query ="SELECT * FROM SEED_BULB WHERE SB_RATING = ? ORDER BY cast(JSON_EXTRACT(SBPRICE, '$[0].SP') as unsigned) DESC LIMIT ? OFFSET ? ";
		List<SEED_BULB> aplist = jdbcTemplate.query(query,new Object[] {rating,limit,offset},
		        (rs, num) -> {
		        	SEED_BULB ap = new SEED_BULB();
			        ap.setSBID(rs.getString(1));
			        ap.setSBTITLE(rs.getString(2));
			        ap.setSBDESCRIPTION(rs.getString(3));
			        ap.setSB_RATING(rs.getDouble(4));
					ap.setSBPRICE(rs.getString(5));
					ap.setSB_STOCK_AVAILABILITY(rs.getInt(6));
					ap.setSBIMAGES(rs.getString(7));
					ap.setSBDETAILS(rs.getString(8));
					return ap;
			    });
				
				return aplist;
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<SEED_BULB> getLoadedPlantsFilterSortRLH2(int offset, int limit, double rating) {
		String query ="SELECT * FROM SEED_BULB WHERE SB_RATING = ? ORDER BY ORDER BY cast(JSON_EXTRACT(SBPRICE, '$[0].SP') as unsigned) ASC LIMIT ? OFFSET ? ";
		List<SEED_BULB> aplist = jdbcTemplate.query(query,new Object[] {rating,limit,offset},
		        (rs, num) -> {
		        	SEED_BULB ap = new SEED_BULB();
			        ap.setSBID(rs.getString(1));
			        ap.setSBTITLE(rs.getString(2));
			        ap.setSBDESCRIPTION(rs.getString(3));
			        ap.setSB_RATING(rs.getDouble(4));
					ap.setSBPRICE(rs.getString(5));
					ap.setSB_STOCK_AVAILABILITY(rs.getInt(6));
					ap.setSBIMAGES(rs.getString(7));
					ap.setSBDETAILS(rs.getString(8));
					return ap;
			    });
				
				return aplist;
	}

	@Override
	public List<SEED_BULB> getLoadedPlantsFilterSortRAZ2(int offset, int limit, double rating) {
		String query = "SELECT * FROM SEED_BULB WHERE SB_RATING = ? ORDER BY SBTITLE ASC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<SEED_BULB> aplist = jdbcTemplate.query(query,new Object[] {rating,limit,offset},
		        (rs, num) -> {
		        	SEED_BULB ap = new SEED_BULB();
			        ap.setSBID(rs.getString(1));
			        ap.setSBTITLE(rs.getString(2));
			        ap.setSBDESCRIPTION(rs.getString(3));
			        ap.setSB_RATING(rs.getDouble(4));
					ap.setSBPRICE(rs.getString(5));
					ap.setSB_STOCK_AVAILABILITY(rs.getInt(6));
					ap.setSBIMAGES(rs.getString(7));
					ap.setSBDETAILS(rs.getString(8));
					return ap;
			    });
				
				return aplist;
	}

	@Override
	public List<SEED_BULB> getLoadedPlantsFilterSortRZA2(int offset, int limit, double rating) {
String query = "SELECT * FROM SEED_BULB WHERE SB_RATING = ? ORDER BY PTITLE DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<SEED_BULB> aplist = jdbcTemplate.query(query,new Object[] {rating,limit,offset},
		        (rs, num) -> {
		        	SEED_BULB ap = new SEED_BULB();
			        ap.setSBID(rs.getString(1));
			        ap.setSBTITLE(rs.getString(2));
			        ap.setSBDESCRIPTION(rs.getString(3));
			        ap.setSB_RATING(rs.getDouble(4));
					ap.setSBPRICE(rs.getString(5));
					ap.setSB_STOCK_AVAILABILITY(rs.getInt(6));
					ap.setSBIMAGES(rs.getString(7));
					ap.setSBDETAILS(rs.getString(8));
					return ap;
			    });
				
				return aplist;
	}
	

}
