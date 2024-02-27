package com.demo.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.Model.ARTIFICIAL_PLANT;
import com.demo.Model.ARTIFICIAL_PLANT;
import com.demo.Model.ARTIFICIAL_PLANT;

@Repository
public class ARTIFICIAL_PLANT_DAOImpl implements ARTIFICIAL_PLANT_DAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<ARTIFICIAL_PLANT> getallartificialplant() {
		List<ARTIFICIAL_PLANT> aplist = jdbcTemplate.query("Select * from ARTIFICIAL_PLANT",(rs,num)->{
			ARTIFICIAL_PLANT ap = new ARTIFICIAL_PLANT();
			ap.setAPID(rs.getString(1));
			ap.setAPTITLE(rs.getString(2));
			ap.setAPDESCRIPTION(rs.getString(3));
			ap.setAPRATING(rs.getDouble(4));
			ap.setAPPRICE(rs.getString(5));
			ap.setAPSTOCKAVAILABILITY(rs.getInt(6));
			ap.setAPIMAGES(rs.getString(7));
			ap.setAPPRODUCTDETAILS(rs.getString(8));	
			
			return ap;	
		});
			
		return aplist;
	}

	@SuppressWarnings("deprecation")
	@Override
	public ARTIFICIAL_PLANT getbyid(String apid) {
		String query = "select * from ARTIFICIAL_PLANT where apid=?";
		ARTIFICIAL_PLANT pp = new ARTIFICIAL_PLANT();
		try {
		    return jdbcTemplate.queryForObject(query,new Object[] {apid},BeanPropertyRowMapper.newInstance(ARTIFICIAL_PLANT.class));
		}catch(EmptyResultDataAccessException e) {
			return null;
		}		
	}

	@Override
	public List<ARTIFICIAL_PLANT> getAllPotPlanterLoaded(int offset, int limit) {
		@SuppressWarnings("deprecation")
		List<ARTIFICIAL_PLANT> aplist = jdbcTemplate.query("Select * from ARTIFICIAL_PLANT  LIMIT ? OFFSET ?", new Object[]{limit, offset},(rs,num)->{
			ARTIFICIAL_PLANT ap = new ARTIFICIAL_PLANT();
			ap.setAPID(rs.getString(1));
			ap.setAPTITLE(rs.getString(2));
			ap.setAPDESCRIPTION(rs.getString(3));
			ap.setAPRATING(rs.getDouble(4));
			ap.setAPPRICE(rs.getString(5));
			ap.setAPSTOCKAVAILABILITY(rs.getInt(6));
			ap.setAPIMAGES(rs.getString(7));
			ap.setAPPRODUCTDETAILS(rs.getString(8));
			ap.setQuantity(rs.getInt(9));
			
			return ap;	
		});
		return aplist;
	}

	@Override
	public List<ARTIFICIAL_PLANT> getallpotplanterloadedrating(int offset, int limit, double rating) {
		@SuppressWarnings("deprecation")
		List<ARTIFICIAL_PLANT> aplist = jdbcTemplate.query("Select * from ARTIFICIAL_PLANT where aprating = ? LIMIT ? OFFSET ?", new Object[]{rating,limit, offset},(rs,num)->{
			ARTIFICIAL_PLANT ap = new ARTIFICIAL_PLANT();
			ap.setAPID(rs.getString(1));
			ap.setAPTITLE(rs.getString(2));
			ap.setAPDESCRIPTION(rs.getString(3));
			ap.setAPRATING(rs.getDouble(4));
			ap.setAPPRICE(rs.getString(5));
			ap.setAPSTOCKAVAILABILITY(rs.getInt(6));
			ap.setAPIMAGES(rs.getString(7));
			ap.setAPPRODUCTDETAILS(rs.getString(8));
			
			return ap;	
		});
		return aplist;
	}
	
	
	@Override
	public List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedByPrice(int offset, int limit, double from, double to) {
		String query = "SELECT * FROM ARTIFICIAL_PLANT WHERE JSON_EXTRACT(APPRICE, '$[0].SP') BETWEEN ? AND ? LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<ARTIFICIAL_PLANT> aplist = jdbcTemplate.query(query, new Object[]{from, to ,limit, offset}, (rs, num) -> {
	        ARTIFICIAL_PLANT ap = new ARTIFICIAL_PLANT();
	        ap.setAPID(rs.getString(1));
	        ap.setAPTITLE(rs.getString(2));
	        ap.setAPDESCRIPTION(rs.getString(3));
	        ap.setAPRATING(rs.getDouble(4));
			ap.setAPPRICE(rs.getString(5));
			ap.setAPSTOCKAVAILABILITY(rs.getInt(6));
			ap.setAPIMAGES(rs.getString(7));
			ap.setAPPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedByRatingPrice(int offset, int limit, double rating, double from,
			double to) {
		
		String query = "SELECT * FROM ARTIFICIAL_PLANT WHERE APRATING = ? AND JSON_EXTRACT(APPRICE, '$[0].SP') BETWEEN ? AND ? LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<ARTIFICIAL_PLANT> aplist = jdbcTemplate.query(query, new Object[]{rating, from, to ,limit, offset}, (rs, num) -> {
		    ARTIFICIAL_PLANT ap = new ARTIFICIAL_PLANT();
	        ap.setAPID(rs.getString(1));
	        ap.setAPTITLE(rs.getString(2));
	        ap.setAPDESCRIPTION(rs.getString(3));
	        ap.setAPRATING(rs.getDouble(4));
			ap.setAPPRICE(rs.getString(5));
			ap.setAPSTOCKAVAILABILITY(rs.getInt(6));
			ap.setAPIMAGES(rs.getString(7));
			ap.setAPPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedByRatingStock(int offset, int limit, double rating, int stock) {
		String query = "SELECT * FROM ARTIFICIAL_PLANT WHERE APRATING = ? AND APSTOCKAVAILABILITY = ? LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<ARTIFICIAL_PLANT> aplist = jdbcTemplate.query(query, new Object[]{rating,stock,limit, offset}, (rs, num) -> {
		    ARTIFICIAL_PLANT ap = new ARTIFICIAL_PLANT();
	        ap.setAPID(rs.getString(1));
	        ap.setAPTITLE(rs.getString(2));
	        ap.setAPDESCRIPTION(rs.getString(3));
	        ap.setAPRATING(rs.getDouble(4));
			ap.setAPPRICE(rs.getString(5));
			ap.setAPSTOCKAVAILABILITY(rs.getInt(6));
			ap.setAPIMAGES(rs.getString(7));
			ap.setAPPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
		
	}

	@Override
	public List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedByPriceStock(int offset, int limit, double from, double to,
			int stock) {
		String query = "SELECT * FROM ARTIFICIAL_PLANT WHERE JSON_EXTRACT(APPRICE, '$[0].SP') BETWEEN ? AND ? AND APSTOCKAVAILABILITY = ? LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<ARTIFICIAL_PLANT> aplist = jdbcTemplate.query(query, new Object[]{from, to,stock,limit, offset}, (rs, num) -> {
		    ARTIFICIAL_PLANT ap = new ARTIFICIAL_PLANT();
	        ap.setAPID(rs.getString(1));
	        ap.setAPTITLE(rs.getString(2));
	        ap.setAPDESCRIPTION(rs.getString(3));
	        ap.setAPRATING(rs.getDouble(4));
			ap.setAPPRICE(rs.getString(5));
			ap.setAPSTOCKAVAILABILITY(rs.getInt(6));
			ap.setAPIMAGES(rs.getString(7));
			ap.setAPPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedByPriceStockRating(int offset, int limit, double from, double to,
			int stock, double rating) {
		
		String query = "SELECT * FROM ARTIFICIAL_PLANT WHERE JSON_EXTRACT(APPRICE, '$[0].SP') BETWEEN ? AND ? AND APSTOCKAVAILABILITY = ? AND APRATING = ? LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<ARTIFICIAL_PLANT> aplist = jdbcTemplate.query(query, new Object[]{from, to,stock,rating,limit, offset}, (rs, num) -> {
		    ARTIFICIAL_PLANT ap = new ARTIFICIAL_PLANT();
	        ap.setAPID(rs.getString(1));
	        ap.setAPTITLE(rs.getString(2));
	        ap.setAPDESCRIPTION(rs.getString(3));
	        ap.setAPRATING(rs.getDouble(4));
			ap.setAPPRICE(rs.getString(5));
			ap.setAPSTOCKAVAILABILITY(rs.getInt(6));
			ap.setAPIMAGES(rs.getString(7));
			ap.setAPPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;		
	}

	@Override
	public List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedByRatingPriceSORTTITLE_A_Z(int offset, int limit, double rating,
			double from, double to) {
		String query = "SELECT * FROM ARTIFICIAL_PLANT WHERE APRATING = ? AND JSON_EXTRACT(APPRICE, '$[0].SP') BETWEEN ? AND ? Order by APTITLE LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<ARTIFICIAL_PLANT> aplist = jdbcTemplate.query(query, new Object[]{rating, from, to ,limit, offset}, (rs, num) -> {
		    ARTIFICIAL_PLANT ap = new ARTIFICIAL_PLANT();
	        ap.setAPID(rs.getString(1));
	        ap.setAPTITLE(rs.getString(2));
	        ap.setAPDESCRIPTION(rs.getString(3));
	        ap.setAPRATING(rs.getDouble(4));
			ap.setAPPRICE(rs.getString(5));
			ap.setAPSTOCKAVAILABILITY(rs.getInt(6));
			ap.setAPIMAGES(rs.getString(7));
			ap.setAPPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedByRatingPriceSORTTITLE_Z_A(int offset, int limit, double rating,
			double from, double to) {
		String query = "SELECT * FROM ARTIFICIAL_PLANT WHERE APRATING = ? AND JSON_EXTRACT(APPRICE, '$[0].SP') BETWEEN ? AND ? Order by APTITLE DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<ARTIFICIAL_PLANT> aplist = jdbcTemplate.query(query, new Object[]{rating, from, to ,limit, offset}, (rs, num) -> {
		    ARTIFICIAL_PLANT ap = new ARTIFICIAL_PLANT();
	        ap.setAPID(rs.getString(1));
	        ap.setAPTITLE(rs.getString(2));
	        ap.setAPDESCRIPTION(rs.getString(3));
	        ap.setAPRATING(rs.getDouble(4));
			ap.setAPPRICE(rs.getString(5));
			ap.setAPSTOCKAVAILABILITY(rs.getInt(6));
			ap.setAPIMAGES(rs.getString(7));
			ap.setAPPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}
	
	

	@Override
	public List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedByRatingPriceSORTPRICE_L_H(int offset, int limit, double rating,
			double from, double to) {
		String query = "SELECT * FROM ARTIFICIAL_PLANT WHERE APRATING = ? AND JSON_EXTRACT(APPRICE, '$[0].SP') BETWEEN ? AND ?  order by CAST(JSON_EXTRACT(APPRICE, '$[0].SP') AS UNSIGNED) LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<ARTIFICIAL_PLANT> aplist = jdbcTemplate.query(query, new Object[]{rating, from, to ,limit, offset}, (rs, num) -> {
		    ARTIFICIAL_PLANT ap = new ARTIFICIAL_PLANT();
	        ap.setAPID(rs.getString(1));
	        ap.setAPTITLE(rs.getString(2));
	        ap.setAPDESCRIPTION(rs.getString(3));
	        ap.setAPRATING(rs.getDouble(4));
			ap.setAPPRICE(rs.getString(5));
			ap.setAPSTOCKAVAILABILITY(rs.getInt(6));
			ap.setAPIMAGES(rs.getString(7));
			ap.setAPPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;	}

	@Override
	public List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedByRatingPriceSORTPRICE_H_L(int offset, int limit, double rating,
			double from, double to) {
String query = "SELECT * FROM ARTIFICIAL_PLANT WHERE APRATING = ? AND JSON_EXTRACT(APPRICE, '$[0].SP') BETWEEN ? AND ?  order by CAST(JSON_EXTRACT(APPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<ARTIFICIAL_PLANT> aplist = jdbcTemplate.query(query, new Object[]{rating, from, to ,limit, offset}, (rs, num) -> {
		    ARTIFICIAL_PLANT ap = new ARTIFICIAL_PLANT();
	        ap.setAPID(rs.getString(1));
	        ap.setAPTITLE(rs.getString(2));
	        ap.setAPDESCRIPTION(rs.getString(3));
	        ap.setAPRATING(rs.getDouble(4));
			ap.setAPPRICE(rs.getString(5));
			ap.setAPSTOCKAVAILABILITY(rs.getInt(6));
			ap.setAPIMAGES(rs.getString(7));
			ap.setAPPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedByRatingStockSORTTITLE_A_Z(int offset, int limit, double rating,
			int stock) {
		String query = "SELECT * FROM ARTIFICIAL_PLANT WHERE APRATING = ? AND APSTOCKAVAILABILITY = ? Order by APTITLE LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<ARTIFICIAL_PLANT> aplist = jdbcTemplate.query(query, new Object[]{rating,stock,limit, offset}, (rs, num) -> {
		    ARTIFICIAL_PLANT ap = new ARTIFICIAL_PLANT();
	        ap.setAPID(rs.getString(1));
	        ap.setAPTITLE(rs.getString(2));
	        ap.setAPDESCRIPTION(rs.getString(3));
	        ap.setAPRATING(rs.getDouble(4));
			ap.setAPPRICE(rs.getString(5));
			ap.setAPSTOCKAVAILABILITY(rs.getInt(6));
			ap.setAPIMAGES(rs.getString(7));
			ap.setAPPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;	}

	@Override
	public List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedByRatingStockSORTTITLE_Z_A(int offset, int limit, double rating,
			int stock) {
		String query = "SELECT * FROM ARTIFICIAL_PLANT WHERE APRATING = ? AND APSTOCKAVAILABILITY = ? Order by APTITLE DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<ARTIFICIAL_PLANT> aplist = jdbcTemplate.query(query, new Object[]{rating,stock,limit, offset}, (rs, num) -> {
		    ARTIFICIAL_PLANT ap = new ARTIFICIAL_PLANT();
	        ap.setAPID(rs.getString(1));
	        ap.setAPTITLE(rs.getString(2));
	        ap.setAPDESCRIPTION(rs.getString(3));
	        ap.setAPRATING(rs.getDouble(4));
			ap.setAPPRICE(rs.getString(5));
			ap.setAPSTOCKAVAILABILITY(rs.getInt(6));
			ap.setAPIMAGES(rs.getString(7));
			ap.setAPPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
		
	}

	@Override
	public List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedByRatingStockSORTPRICE_L_H(int offset, int limit, double rating,
			int stock) {
		String query = "SELECT * FROM ARTIFICIAL_PLANT WHERE APRATING = ? AND APSTOCKAVAILABILITY = ?  order by CAST(JSON_EXTRACT(APPRICE, '$[0].SP') AS UNSIGNED) LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<ARTIFICIAL_PLANT> aplist = jdbcTemplate.query(query, new Object[]{rating,stock,limit, offset}, (rs, num) -> {
		    ARTIFICIAL_PLANT ap = new ARTIFICIAL_PLANT();
	        ap.setAPID(rs.getString(1));
	        ap.setAPTITLE(rs.getString(2));
	        ap.setAPDESCRIPTION(rs.getString(3));
	        ap.setAPRATING(rs.getDouble(4));
			ap.setAPPRICE(rs.getString(5));
			ap.setAPSTOCKAVAILABILITY(rs.getInt(6));
			ap.setAPIMAGES(rs.getString(7));
			ap.setAPPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedByRatingStockSORTPRICE_H_L(int offset, int limit, double rating,
			int stock) {
String query = "SELECT * FROM ARTIFICIAL_PLANT WHERE APRATING = ? AND APSTOCKAVAILABILITY = ?  order by CAST(JSON_EXTRACT(APPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<ARTIFICIAL_PLANT> aplist = jdbcTemplate.query(query, new Object[]{rating,stock,limit, offset}, (rs, num) -> {
		    ARTIFICIAL_PLANT ap = new ARTIFICIAL_PLANT();
	        ap.setAPID(rs.getString(1));
	        ap.setAPTITLE(rs.getString(2));
	        ap.setAPDESCRIPTION(rs.getString(3));
	        ap.setAPRATING(rs.getDouble(4));
			ap.setAPPRICE(rs.getString(5));
			ap.setAPSTOCKAVAILABILITY(rs.getInt(6));
			ap.setAPIMAGES(rs.getString(7));
			ap.setAPPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedByPriceStockSORTTITLE_A_Z(int offset, int limit, double from,
			double to, int stock) {
		String query = "SELECT * FROM ARTIFICIAL_PLANT WHERE JSON_EXTRACT(APPRICE, '$[0].SP') BETWEEN ? AND ? AND APSTOCKAVAILABILITY = ? ORDER BY APTITLE LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<ARTIFICIAL_PLANT> aplist = jdbcTemplate.query(query, new Object[]{from, to,stock,limit, offset}, (rs, num) -> {
		    ARTIFICIAL_PLANT ap = new ARTIFICIAL_PLANT();
	        ap.setAPID(rs.getString(1));
	        ap.setAPTITLE(rs.getString(2));
	        ap.setAPDESCRIPTION(rs.getString(3));
	        ap.setAPRATING(rs.getDouble(4));
			ap.setAPPRICE(rs.getString(5));
			ap.setAPSTOCKAVAILABILITY(rs.getInt(6));
			ap.setAPIMAGES(rs.getString(7));
			ap.setAPPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
		
	}

	@Override
	public List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedByPriceStockSORTTITLE_Z_A(int offset, int limit, double from,
			double to, int stock) {
		String query = "SELECT * FROM ARTIFICIAL_PLANT WHERE JSON_EXTRACT(APPRICE, '$[0].SP') BETWEEN ? AND ? AND APSTOCKAVAILABILITY = ? ORDER BY APTITLE DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<ARTIFICIAL_PLANT> aplist = jdbcTemplate.query(query, new Object[]{from, to,stock,limit, offset}, (rs, num) -> {
		    ARTIFICIAL_PLANT ap = new ARTIFICIAL_PLANT();
	        ap.setAPID(rs.getString(1));
	        ap.setAPTITLE(rs.getString(2));
	        ap.setAPDESCRIPTION(rs.getString(3));
	        ap.setAPRATING(rs.getDouble(4));
			ap.setAPPRICE(rs.getString(5));
			ap.setAPSTOCKAVAILABILITY(rs.getInt(6));
			ap.setAPIMAGES(rs.getString(7));
			ap.setAPPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedByPriceStockSORTPRICE_L_H(int offset, int limit, double from,
			double to, int stock) {
		String query = "SELECT * FROM ARTIFICIAL_PLANT WHERE JSON_EXTRACT(APPRICE, '$[0].SP') BETWEEN ? AND ? AND APSTOCKAVAILABILITY = ?  order by CAST(JSON_EXTRACT(APPRICE, '$[0].SP') AS UNSIGNED) LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<ARTIFICIAL_PLANT> aplist = jdbcTemplate.query(query, new Object[]{from, to,stock,limit, offset}, (rs, num) -> {
		    ARTIFICIAL_PLANT ap = new ARTIFICIAL_PLANT();
	        ap.setAPID(rs.getString(1));
	        ap.setAPTITLE(rs.getString(2));
	        ap.setAPDESCRIPTION(rs.getString(3));
	        ap.setAPRATING(rs.getDouble(4));
			ap.setAPPRICE(rs.getString(5));
			ap.setAPSTOCKAVAILABILITY(rs.getInt(6));
			ap.setAPIMAGES(rs.getString(7));
			ap.setAPPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedByPriceStockSORTPRICE_H_L(int offset, int limit, double from,
			double to, int stock) {
		String query = "SELECT * FROM ARTIFICIAL_PLANT WHERE JSON_EXTRACT(APPRICE, '$[0].SP') BETWEEN ? AND ? AND APSTOCKAVAILABILITY = ?  order by CAST(JSON_EXTRACT(APPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<ARTIFICIAL_PLANT> aplist = jdbcTemplate.query(query, new Object[]{from, to,stock,limit, offset}, (rs, num) -> {
		    ARTIFICIAL_PLANT ap = new ARTIFICIAL_PLANT();
	        ap.setAPID(rs.getString(1));
	        ap.setAPTITLE(rs.getString(2));
	        ap.setAPDESCRIPTION(rs.getString(3));
	        ap.setAPRATING(rs.getDouble(4));
			ap.setAPPRICE(rs.getString(5));
			ap.setAPSTOCKAVAILABILITY(rs.getInt(6));
			ap.setAPIMAGES(rs.getString(7));
			ap.setAPPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedByPriceStockRatingSORTTITLE_A_Z(int offset, int limit, double from,
			double to, int stock, double rating) {
		String query = "SELECT * FROM ARTIFICIAL_PLANT WHERE JSON_EXTRACT(APPRICE, '$[0].SP') BETWEEN ? AND ? AND APSTOCKAVAILABILITY = ? AND APRATING = ? ORDER BY APTITLE LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<ARTIFICIAL_PLANT> aplist = jdbcTemplate.query(query, new Object[]{from, to,stock,rating,limit, offset}, (rs, num) -> {
		    ARTIFICIAL_PLANT ap = new ARTIFICIAL_PLANT();
	        ap.setAPID(rs.getString(1));
	        ap.setAPTITLE(rs.getString(2));
	        ap.setAPDESCRIPTION(rs.getString(3));
	        ap.setAPRATING(rs.getDouble(4));
			ap.setAPPRICE(rs.getString(5));
			ap.setAPSTOCKAVAILABILITY(rs.getInt(6));
			ap.setAPIMAGES(rs.getString(7));
			ap.setAPPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedByPriceStockRatingSORTTITLE_Z_A(int offset, int limit, double from,
			double to, int stock, double rating) {
		String query = "SELECT * FROM ARTIFICIAL_PLANT WHERE JSON_EXTRACT(APPRICE, '$[0].SP') BETWEEN ? AND ? AND APSTOCKAVAILABILITY = ? AND APRATING = ? ORDER BY APTITLE DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<ARTIFICIAL_PLANT> aplist = jdbcTemplate.query(query, new Object[]{from, to,stock,rating,limit, offset}, (rs, num) -> {
		    ARTIFICIAL_PLANT ap = new ARTIFICIAL_PLANT();
	        ap.setAPID(rs.getString(1));
	        ap.setAPTITLE(rs.getString(2));
	        ap.setAPDESCRIPTION(rs.getString(3));
	        ap.setAPRATING(rs.getDouble(4));
			ap.setAPPRICE(rs.getString(5));
			ap.setAPSTOCKAVAILABILITY(rs.getInt(6));
			ap.setAPIMAGES(rs.getString(7));
			ap.setAPPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedByPriceStockRatingSORTPRICE_L_H(int offset, int limit, double from,
			double to, int stock, double rating) {
		String query = "SELECT * FROM ARTIFICIAL_PLANT WHERE JSON_EXTRACT(APPRICE, '$[0].SP') BETWEEN ? AND ? AND APSTOCKAVAILABILITY = ? AND APRATING = ?  order by CAST(JSON_EXTRACT(APPRICE, '$[0].SP') AS UNSIGNED) LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<ARTIFICIAL_PLANT> aplist = jdbcTemplate.query(query, new Object[]{from, to,stock,rating,limit, offset}, (rs, num) -> {
		    ARTIFICIAL_PLANT ap = new ARTIFICIAL_PLANT();
	        ap.setAPID(rs.getString(1));
	        ap.setAPTITLE(rs.getString(2));
	        ap.setAPDESCRIPTION(rs.getString(3));
	        ap.setAPRATING(rs.getDouble(4));
			ap.setAPPRICE(rs.getString(5));
			ap.setAPSTOCKAVAILABILITY(rs.getInt(6));
			ap.setAPIMAGES(rs.getString(7));
			ap.setAPPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<ARTIFICIAL_PLANT> getAllPotPlanterLoadedByPriceStockRatingSORTPRICE_H_L(int offset, int limit, double from,
			double to, int stock, double rating) {
		String query = "SELECT * FROM ARTIFICIAL_PLANT WHERE JSON_EXTRACT(APPRICE, '$[0].SP') BETWEEN ? AND ? AND APSTOCKAVAILABILITY = ? AND APRATING = ?  order by CAST(JSON_EXTRACT(APPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<ARTIFICIAL_PLANT> aplist = jdbcTemplate.query(query, new Object[]{from, to,stock,rating,limit, offset}, (rs, num) -> {
		    ARTIFICIAL_PLANT ap = new ARTIFICIAL_PLANT();
	        ap.setAPID(rs.getString(1));
	        ap.setAPTITLE(rs.getString(2));
	        ap.setAPDESCRIPTION(rs.getString(3));
	        ap.setAPRATING(rs.getDouble(4));
			ap.setAPPRICE(rs.getString(5));
			ap.setAPSTOCKAVAILABILITY(rs.getInt(6));
			ap.setAPIMAGES(rs.getString(7));
			ap.setAPPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}
	
	
	@Override
	public List<ARTIFICIAL_PLANT> Availability(int offset, int limit) {
		String query = "select * from ARTIFICIAL_PLANT where APSTOCKAVAILABILITY=1 limit ? offset ?";
		@SuppressWarnings("deprecation")
		List<ARTIFICIAL_PLANT> aplist = jdbcTemplate.query(query,new Object[] {limit,offset}, (rs,num)->{
			ARTIFICIAL_PLANT ap = new ARTIFICIAL_PLANT();
	        ap.setAPID(rs.getString(1));
	        ap.setAPTITLE(rs.getString(2));
	        ap.setAPDESCRIPTION(rs.getString(3));
	        ap.setAPRATING(rs.getDouble(4));
			ap.setAPPRICE(rs.getString(5));
			ap.setAPSTOCKAVAILABILITY(rs.getInt(6));
			ap.setAPIMAGES(rs.getString(7));
			ap.setAPPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}
	

	@Override
	public List<ARTIFICIAL_PLANT> sortZ_A(int offset, int limit) {
		String query = "select * from ARTIFICIAL_PLANT order by APTITLE desc limit ? offset ?";
		@SuppressWarnings("deprecation")
		List<ARTIFICIAL_PLANT> aplist = jdbcTemplate.query(query,new Object[] {limit,offset}, (rs,num)->{
			ARTIFICIAL_PLANT ap = new ARTIFICIAL_PLANT();
	        ap.setAPID(rs.getString(1));
	        ap.setAPTITLE(rs.getString(2));
	        ap.setAPDESCRIPTION(rs.getString(3));
	        ap.setAPRATING(rs.getDouble(4));
			ap.setAPPRICE(rs.getString(5));
			ap.setAPSTOCKAVAILABILITY(rs.getInt(6));
			ap.setAPIMAGES(rs.getString(7));
			ap.setAPPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}
	
	@Override
	public List<ARTIFICIAL_PLANT> Avail_A_Z(int offset, int limit) {
		String query = "select * from ARTIFICIAL_PLANT where APSTOCKAVAILABILITY=1 order by APTITLE limit ? offset ?";
		@SuppressWarnings("deprecation")
		List<ARTIFICIAL_PLANT> aplist = jdbcTemplate.query(query,new Object[] {limit,offset}, (rs,num)->{
			ARTIFICIAL_PLANT ap = new ARTIFICIAL_PLANT();
	        ap.setAPID(rs.getString(1));
	        ap.setAPTITLE(rs.getString(2));
	        ap.setAPDESCRIPTION(rs.getString(3));
	        ap.setAPRATING(rs.getDouble(4));
			ap.setAPPRICE(rs.getString(5));
			ap.setAPSTOCKAVAILABILITY(rs.getInt(6));
			ap.setAPIMAGES(rs.getString(7));
			ap.setAPPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<ARTIFICIAL_PLANT> Avail_Z_A(int offset, int limit) {
		String query = "select * from ARTIFICIAL_PLANT where APSTOCKAVAILABILITY=1 order by APTITLE desc limit ? offset ?";
		@SuppressWarnings("deprecation")
		List<ARTIFICIAL_PLANT> aplist = jdbcTemplate.query(query,new Object[] {limit,offset}, (rs,num)->{
			ARTIFICIAL_PLANT ap = new ARTIFICIAL_PLANT();
	        ap.setAPID(rs.getString(1));
	        ap.setAPTITLE(rs.getString(2));
	        ap.setAPDESCRIPTION(rs.getString(3));
	        ap.setAPRATING(rs.getDouble(4));
			ap.setAPPRICE(rs.getString(5));
			ap.setAPSTOCKAVAILABILITY(rs.getInt(6));
			ap.setAPIMAGES(rs.getString(7));
			ap.setAPPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<ARTIFICIAL_PLANT> getPlantsByPriceLH(int offset, int limit) {
String query = "SELECT * FROM ARTIFICIAL_PLANT where APSTOCKAVAILABILITY=1 ORDER BY CAST(JSON_EXTRACT(APPRICE, '$[0].SP') AS UNSIGNED) ASC LIMIT ? OFFSET ?";
		
	    @SuppressWarnings("deprecation")
		List<ARTIFICIAL_PLANT> aplist = jdbcTemplate.query(query,new Object[] {limit,offset},
	        (rs, num) -> {
	        	ARTIFICIAL_PLANT ap = new ARTIFICIAL_PLANT();
		        ap.setAPID(rs.getString(1));
		        ap.setAPTITLE(rs.getString(2));
		        ap.setAPDESCRIPTION(rs.getString(3));
		        ap.setAPRATING(rs.getDouble(4));
				ap.setAPPRICE(rs.getString(5));
				ap.setAPSTOCKAVAILABILITY(rs.getInt(6));
				ap.setAPIMAGES(rs.getString(7));
				ap.setAPPRODUCTDETAILS(rs.getString(8));
				return ap;
		    });
			
			return aplist;
	}

	@Override
	public List<ARTIFICIAL_PLANT> getPlantsByPriceHL(int offset, int limit) {
String query = "SELECT * FROM ARTIFICIAL_PLANT where APSTOCKAVAILABILITY=1 ORDER BY CAST(JSON_EXTRACT(APPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
		
	    @SuppressWarnings("deprecation")
		List<ARTIFICIAL_PLANT> aplist = jdbcTemplate.query(query,new Object[] {limit,offset},
	        (rs, num) -> {
	        	ARTIFICIAL_PLANT ap = new ARTIFICIAL_PLANT();
		        ap.setAPID(rs.getString(1));
		        ap.setAPTITLE(rs.getString(2));
		        ap.setAPDESCRIPTION(rs.getString(3));
		        ap.setAPRATING(rs.getDouble(4));
				ap.setAPPRICE(rs.getString(5));
				ap.setAPSTOCKAVAILABILITY(rs.getInt(6));
				ap.setAPIMAGES(rs.getString(7));
				ap.setAPPRODUCTDETAILS(rs.getString(8));
				return ap;
		    });
			
			return aplist;
	}

	@Override
	public List<ARTIFICIAL_PLANT> sortA_Z(int offset, int limit) {
		String query = "select * from ARTIFICIAL_PLANT order by APTITLE limit ? offset ?";
		@SuppressWarnings("deprecation")
		List<ARTIFICIAL_PLANT> aplist = jdbcTemplate.query(query,new Object[] {limit,offset}, (rs,num)->{
			ARTIFICIAL_PLANT ap = new ARTIFICIAL_PLANT();
	        ap.setAPID(rs.getString(1));
	        ap.setAPTITLE(rs.getString(2));
	        ap.setAPDESCRIPTION(rs.getString(3));
	        ap.setAPRATING(rs.getDouble(4));
			ap.setAPPRICE(rs.getString(5));
			ap.setAPSTOCKAVAILABILITY(rs.getInt(6));
			ap.setAPIMAGES(rs.getString(7));
			ap.setAPPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
		}
		
		
	

	@Override
	public List<ARTIFICIAL_PLANT> SORTBYPRICE_L_H(int offset, int limit) {
		String query = "SELECT * FROM ARTIFICIAL_PLANT order by CAST(JSON_EXTRACT(APPRICE, '$[0].SP') AS UNSIGNED) ASC LIMIT ? OFFSET ?";
		
	    @SuppressWarnings("deprecation")
		List<ARTIFICIAL_PLANT> aplist = jdbcTemplate.query(query,new Object[] {limit,offset},
	        (rs, num) -> {
	        	ARTIFICIAL_PLANT ap = new ARTIFICIAL_PLANT();
		        ap.setAPID(rs.getString(1));
		        ap.setAPTITLE(rs.getString(2));
		        ap.setAPDESCRIPTION(rs.getString(3));
		        ap.setAPRATING(rs.getDouble(4));
				ap.setAPPRICE(rs.getString(5));
				ap.setAPSTOCKAVAILABILITY(rs.getInt(6));
				ap.setAPIMAGES(rs.getString(7));
				ap.setAPPRODUCTDETAILS(rs.getString(8));
				return ap;
		    });
			
			return aplist;
	    }

	

	@Override
	public List<ARTIFICIAL_PLANT> SORTBYPRICE_H_L(int offset, int limit) {
		String query = "SELECT * FROM ARTIFICIAL_PLANT order by CAST(JSON_EXTRACT(APPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
		
	    @SuppressWarnings("deprecation")
		List<ARTIFICIAL_PLANT> aplist = jdbcTemplate.query(query,new Object[] {limit,offset},
	        (rs, num) -> {
	        	ARTIFICIAL_PLANT ap = new ARTIFICIAL_PLANT();
		        ap.setAPID(rs.getString(1));
		        ap.setAPTITLE(rs.getString(2));
		        ap.setAPDESCRIPTION(rs.getString(3));
		        ap.setAPRATING(rs.getDouble(4));
				ap.setAPPRICE(rs.getString(5));
				ap.setAPSTOCKAVAILABILITY(rs.getInt(6));
				ap.setAPIMAGES(rs.getString(7));
				ap.setAPPRODUCTDETAILS(rs.getString(8));
				return ap;
		    });
			
			return aplist;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public List<ARTIFICIAL_PLANT> getLoadedPlantsFilterSortPHL1(int offset, int limit, double from, double to) {
		String query="SELECT * FROM ARTIFICIAL_PLANT WHERE JSON_EXTRACT(APPRICE, '$[0].SP') BETWEEN ? AND ? ORDER BY cast(JSON_EXTRACT(APPRICE, '$[0].SP') as unsigned) DESC LIMIT ? OFFSET ?";
		List<ARTIFICIAL_PLANT> aplist = jdbcTemplate.query(query,new Object[] {from,to,limit,offset},
		        (rs, num) -> {
		        	ARTIFICIAL_PLANT ap = new ARTIFICIAL_PLANT();
			        ap.setAPID(rs.getString(1));
			        ap.setAPTITLE(rs.getString(2));
			        ap.setAPDESCRIPTION(rs.getString(3));
			        ap.setAPRATING(rs.getDouble(4));
					ap.setAPPRICE(rs.getString(5));
					ap.setAPSTOCKAVAILABILITY(rs.getInt(6));
					ap.setAPIMAGES(rs.getString(7));
					ap.setAPPRODUCTDETAILS(rs.getString(8));
					return ap;
			    });
				
				return aplist;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<ARTIFICIAL_PLANT> getLoadedPlantsFilterSortPLH1(int offset, int limit, double from, double to) {
		String query="SELECT * FROM ARTIFICIAL_PLANT WHERE JSON_EXTRACT(APPRICE, '$[0].SP') BETWEEN ? AND ? ORDER BY cast(JSON_EXTRACT(APPRICE, '$[0].SP') as unsigned) ASC LIMIT ? OFFSET ?";
		List<ARTIFICIAL_PLANT> aplist = jdbcTemplate.query(query,new Object[] {from,to,limit,offset},
		        (rs, num) -> {
		        	ARTIFICIAL_PLANT ap = new ARTIFICIAL_PLANT();
			        ap.setAPID(rs.getString(1));
			        ap.setAPTITLE(rs.getString(2));
			        ap.setAPDESCRIPTION(rs.getString(3));
			        ap.setAPRATING(rs.getDouble(4));
					ap.setAPPRICE(rs.getString(5));
					ap.setAPSTOCKAVAILABILITY(rs.getInt(6));
					ap.setAPIMAGES(rs.getString(7));
					ap.setAPPRODUCTDETAILS(rs.getString(8));
					return ap;
			    });
				
				return aplist;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<ARTIFICIAL_PLANT> getLoadedPlantFilterSortAZ1(int offset, int limit, double from, double to) {
		String query ="SELECT * FROM ARTIFICIAL_PLANT WHERE JSON_EXTRACT(APPRICE, '$[0].SP') BETWEEN ? AND ? ORDER BY APTITLE ASC LIMIT ? OFFSET ? ";
		List<ARTIFICIAL_PLANT> aplist = jdbcTemplate.query(query,new Object[] {from,to,limit,offset},
		        (rs, num) -> {
		        	ARTIFICIAL_PLANT ap = new ARTIFICIAL_PLANT();
			        ap.setAPID(rs.getString(1));
			        ap.setAPTITLE(rs.getString(2));
			        ap.setAPDESCRIPTION(rs.getString(3));
			        ap.setAPRATING(rs.getDouble(4));
					ap.setAPPRICE(rs.getString(5));
					ap.setAPSTOCKAVAILABILITY(rs.getInt(6));
					ap.setAPIMAGES(rs.getString(7));
					ap.setAPPRODUCTDETAILS(rs.getString(8));
					return ap;
			    });
				
				return aplist;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<ARTIFICIAL_PLANT> getLoadedPlantFilterSortZA1(int offset, int limit, double from, double to) {
		String query ="SELECT * FROM ARTIFICIAL_PLANT WHERE JSON_EXTRACT(APPRICE, '$[0].SP') BETWEEN ? AND ? ORDER BY APTITLE DESC LIMIT ? OFFSET ? ";
		List<ARTIFICIAL_PLANT> aplist = jdbcTemplate.query(query,new Object[] {from,to,limit,offset},
		        (rs, num) -> {
		        	ARTIFICIAL_PLANT ap = new ARTIFICIAL_PLANT();
			        ap.setAPID(rs.getString(1));
			        ap.setAPTITLE(rs.getString(2));
			        ap.setAPDESCRIPTION(rs.getString(3));
			        ap.setAPRATING(rs.getDouble(4));
					ap.setAPPRICE(rs.getString(5));
					ap.setAPSTOCKAVAILABILITY(rs.getInt(6));
					ap.setAPIMAGES(rs.getString(7));
					ap.setAPPRODUCTDETAILS(rs.getString(8));
					return ap;
			    });
				
				return aplist;
	}
	
	
	@SuppressWarnings("deprecation")
	@Override
	public List<ARTIFICIAL_PLANT> getLoadedPlantsFilterSortRHL2(int offset, int limit, double rating) {
		String query ="SELECT * FROM ARTIFICIAL_PLANT WHERE APRATING = ? ORDER BY cast(JSON_EXTRACT(APPRICE, '$[0].SP') as unsigned) DESC LIMIT ? OFFSET ? ";
		List<ARTIFICIAL_PLANT> aplist = jdbcTemplate.query(query,new Object[] {rating,limit,offset},
		        (rs, num) -> {
		        	ARTIFICIAL_PLANT ap = new ARTIFICIAL_PLANT();
			        ap.setAPID(rs.getString(1));
			        ap.setAPTITLE(rs.getString(2));
			        ap.setAPDESCRIPTION(rs.getString(3));
			        ap.setAPRATING(rs.getDouble(4));
					ap.setAPPRICE(rs.getString(5));
					ap.setAPSTOCKAVAILABILITY(rs.getInt(6));
					ap.setAPIMAGES(rs.getString(7));
					ap.setAPPRODUCTDETAILS(rs.getString(8));
					return ap;
			    });
				
				return aplist;
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<ARTIFICIAL_PLANT> getLoadedPlantsFilterSortRLH2(int offset, int limit, double rating) {
		String query ="SELECT * FROM ARTIFICIAL_PLANT WHERE APRATING = ? ORDER BY ORDER BY cast(JSON_EXTRACT(APPRICE, '$[0].SP') as unsigned) ASC LIMIT ? OFFSET ? ";
		List<ARTIFICIAL_PLANT> aplist = jdbcTemplate.query(query,new Object[] {rating,limit,offset},
		        (rs, num) -> {
		        	ARTIFICIAL_PLANT ap = new ARTIFICIAL_PLANT();
			        ap.setAPID(rs.getString(1));
			        ap.setAPTITLE(rs.getString(2));
			        ap.setAPDESCRIPTION(rs.getString(3));
			        ap.setAPRATING(rs.getDouble(4));
					ap.setAPPRICE(rs.getString(5));
					ap.setAPSTOCKAVAILABILITY(rs.getInt(6));
					ap.setAPIMAGES(rs.getString(7));
					ap.setAPPRODUCTDETAILS(rs.getString(8));
					return ap;
			    });
				
				return aplist;
	}

	@Override
	public List<ARTIFICIAL_PLANT> getLoadedPlantsFilterSortRAZ2(int offset, int limit, double rating) {
		String query = "SELECT * FROM ARTIFICIAL_PLANT WHERE APRATING = ? ORDER BY APTITLE ASC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<ARTIFICIAL_PLANT> aplist = jdbcTemplate.query(query,new Object[] {rating,limit,offset},
		        (rs, num) -> {
		        	ARTIFICIAL_PLANT ap = new ARTIFICIAL_PLANT();
			        ap.setAPID(rs.getString(1));
			        ap.setAPTITLE(rs.getString(2));
			        ap.setAPDESCRIPTION(rs.getString(3));
			        ap.setAPRATING(rs.getDouble(4));
					ap.setAPPRICE(rs.getString(5));
					ap.setAPSTOCKAVAILABILITY(rs.getInt(6));
					ap.setAPIMAGES(rs.getString(7));
					ap.setAPPRODUCTDETAILS(rs.getString(8));
					return ap;
			    });
				
				return aplist;
	}

	@Override
	public List<ARTIFICIAL_PLANT> getLoadedPlantsFilterSortRZA2(int offset, int limit, double rating) {
String query = "SELECT * FROM ARTIFICIAL_PLANT WHERE APRATING = ? ORDER BY PTITLE DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<ARTIFICIAL_PLANT> aplist = jdbcTemplate.query(query,new Object[] {rating,limit,offset},
		        (rs, num) -> {
		        	ARTIFICIAL_PLANT ap = new ARTIFICIAL_PLANT();
			        ap.setAPID(rs.getString(1));
			        ap.setAPTITLE(rs.getString(2));
			        ap.setAPDESCRIPTION(rs.getString(3));
			        ap.setAPRATING(rs.getDouble(4));
					ap.setAPPRICE(rs.getString(5));
					ap.setAPSTOCKAVAILABILITY(rs.getInt(6));
					ap.setAPIMAGES(rs.getString(7));
					ap.setAPPRODUCTDETAILS(rs.getString(8));
					return ap;
			    });
				
				return aplist;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
