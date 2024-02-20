package com.demo.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.Model.PUMP_SPRAY;


@Repository
public class PUMP_SPRAY_DAOImpl implements PUMP_SPRAY_DAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<PUMP_SPRAY> getallartificialplant() {
		List<PUMP_SPRAY> aplist = jdbcTemplate.query("Select * from PUMP_SPRAY",(rs,num)->{
			PUMP_SPRAY ap = new PUMP_SPRAY();
			ap.setPSID(rs.getString(1));
			ap.setPSTITLE(rs.getString(2));
			ap.setPSDESCRIPTION(rs.getString(3));
			ap.setPSRATING(rs.getDouble(4));
			ap.setPSPRICE(rs.getString(5));
			ap.setPSSTOCKAVAILABILITY(rs.getInt(6));
			ap.setPSIMAGES(rs.getString(7));
			ap.setPSPRODUCTDETAILS(rs.getString(8));	
			
			return ap;	
		});
			
		return aplist;
	}

	@SuppressWarnings("deprecation")
	@Override
	public PUMP_SPRAY getbyid(String PSID) {
		String query = "select * from PUMP_SPRAY where PSID=?";
		PUMP_SPRAY pp = new PUMP_SPRAY();
		try {
		    return jdbcTemplate.queryForObject(query,new Object[] {PSID},BeanPropertyRowMapper.newInstance(PUMP_SPRAY.class));
		}catch(EmptyResultDataAccessException e) {
			return null;
		}		
	}

	@Override
	public List<PUMP_SPRAY> getAllPotPlanterLoaded(int offset, int limit) {
		@SuppressWarnings("deprecation")
		List<PUMP_SPRAY> aplist = jdbcTemplate.query("Select * from PUMP_SPRAY  LIMIT ? OFFSET ?", new Object[]{limit, offset},(rs,num)->{
			PUMP_SPRAY ap = new PUMP_SPRAY();
			ap.setPSID(rs.getString(1));
			ap.setPSTITLE(rs.getString(2));
			ap.setPSDESCRIPTION(rs.getString(3));
			ap.setPSRATING(rs.getDouble(4));
			ap.setPSPRICE(rs.getString(5));
			ap.setPSSTOCKAVAILABILITY(rs.getInt(6));
			ap.setPSIMAGES(rs.getString(7));
			ap.setPSPRODUCTDETAILS(rs.getString(8));
			ap.setQuantity(rs.getInt(9));
			
			return ap;	
		});
		return aplist;
	}

	@Override
	public List<PUMP_SPRAY> getallpotplanterloadedrating(int offset, int limit, double rating) {
		@SuppressWarnings("deprecation")
		List<PUMP_SPRAY> aplist = jdbcTemplate.query("Select * from PUMP_SPRAY where aprating = ? LIMIT ? OFFSET ?", new Object[]{rating,limit, offset},(rs,num)->{
			PUMP_SPRAY ap = new PUMP_SPRAY();
			ap.setPSID(rs.getString(1));
			ap.setPSTITLE(rs.getString(2));
			ap.setPSDESCRIPTION(rs.getString(3));
			ap.setPSRATING(rs.getDouble(4));
			ap.setPSPRICE(rs.getString(5));
			ap.setPSSTOCKAVAILABILITY(rs.getInt(6));
			ap.setPSIMAGES(rs.getString(7));
			ap.setPSPRODUCTDETAILS(rs.getString(8));
			
			return ap;	
		});
		return aplist;
	}
	
	
	@Override
	public List<PUMP_SPRAY> getAllPotPlanterLoadedByPrice(int offset, int limit, double from, double to) {
		String query = "SELECT * FROM PUMP_SPRAY WHERE JSON_EXTRACT(PSPRICE, '$[0].SP') BETWEEN ? AND ? LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PUMP_SPRAY> aplist = jdbcTemplate.query(query, new Object[]{from, to ,limit, offset}, (rs, num) -> {
	        PUMP_SPRAY ap = new PUMP_SPRAY();
	        ap.setPSID(rs.getString(1));
	        ap.setPSTITLE(rs.getString(2));
	        ap.setPSDESCRIPTION(rs.getString(3));
	        ap.setPSRATING(rs.getDouble(4));
			ap.setPSPRICE(rs.getString(5));
			ap.setPSSTOCKAVAILABILITY(rs.getInt(6));
			ap.setPSIMAGES(rs.getString(7));
			ap.setPSPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<PUMP_SPRAY> getAllPotPlanterLoadedByRatingPrice(int offset, int limit, double rating, double from,
			double to) {
		
		String query = "SELECT * FROM PUMP_SPRAY WHERE PSRATING = ? AND JSON_EXTRACT(PSPRICE, '$[0].SP') BETWEEN ? AND ? LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PUMP_SPRAY> aplist = jdbcTemplate.query(query, new Object[]{rating, from, to ,limit, offset}, (rs, num) -> {
		    PUMP_SPRAY ap = new PUMP_SPRAY();
	        ap.setPSID(rs.getString(1));
	        ap.setPSTITLE(rs.getString(2));
	        ap.setPSDESCRIPTION(rs.getString(3));
	        ap.setPSRATING(rs.getDouble(4));
			ap.setPSPRICE(rs.getString(5));
			ap.setPSSTOCKAVAILABILITY(rs.getInt(6));
			ap.setPSIMAGES(rs.getString(7));
			ap.setPSPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<PUMP_SPRAY> getAllPotPlanterLoadedByRatingStock(int offset, int limit, double rating, int stock) {
		String query = "SELECT * FROM PUMP_SPRAY WHERE PSRATING = ? AND PSSTOCKAVAILABILITY = ? LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PUMP_SPRAY> aplist = jdbcTemplate.query(query, new Object[]{rating,stock,limit, offset}, (rs, num) -> {
		    PUMP_SPRAY ap = new PUMP_SPRAY();
	        ap.setPSID(rs.getString(1));
	        ap.setPSTITLE(rs.getString(2));
	        ap.setPSDESCRIPTION(rs.getString(3));
	        ap.setPSRATING(rs.getDouble(4));
			ap.setPSPRICE(rs.getString(5));
			ap.setPSSTOCKAVAILABILITY(rs.getInt(6));
			ap.setPSIMAGES(rs.getString(7));
			ap.setPSPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
		
	}

	@Override
	public List<PUMP_SPRAY> getAllPotPlanterLoadedByPriceStock(int offset, int limit, double from, double to,
			int stock) {
		String query = "SELECT * FROM PUMP_SPRAY WHERE JSON_EXTRACT(PSPRICE, '$[0].SP') BETWEEN ? AND ? AND PSSTOCKAVAILABILITY = ? LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PUMP_SPRAY> aplist = jdbcTemplate.query(query, new Object[]{from, to,stock,limit, offset}, (rs, num) -> {
		    PUMP_SPRAY ap = new PUMP_SPRAY();
	        ap.setPSID(rs.getString(1));
	        ap.setPSTITLE(rs.getString(2));
	        ap.setPSDESCRIPTION(rs.getString(3));
	        ap.setPSRATING(rs.getDouble(4));
			ap.setPSPRICE(rs.getString(5));
			ap.setPSSTOCKAVAILABILITY(rs.getInt(6));
			ap.setPSIMAGES(rs.getString(7));
			ap.setPSPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<PUMP_SPRAY> getAllPotPlanterLoadedByPriceStockRating(int offset, int limit, double from, double to,
			int stock, double rating) {
		
		String query = "SELECT * FROM PUMP_SPRAY WHERE JSON_EXTRACT(PSPRICE, '$[0].SP') BETWEEN ? AND ? AND PSSTOCKAVAILABILITY = ? AND PSRATING = ? LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PUMP_SPRAY> aplist = jdbcTemplate.query(query, new Object[]{from, to,stock,rating,limit, offset}, (rs, num) -> {
		    PUMP_SPRAY ap = new PUMP_SPRAY();
	        ap.setPSID(rs.getString(1));
	        ap.setPSTITLE(rs.getString(2));
	        ap.setPSDESCRIPTION(rs.getString(3));
	        ap.setPSRATING(rs.getDouble(4));
			ap.setPSPRICE(rs.getString(5));
			ap.setPSSTOCKAVAILABILITY(rs.getInt(6));
			ap.setPSIMAGES(rs.getString(7));
			ap.setPSPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;		
	}

	@Override
	public List<PUMP_SPRAY> getAllPotPlanterLoadedByRatingPriceSORTTITLE_A_Z(int offset, int limit, double rating,
			double from, double to) {
		String query = "SELECT * FROM PUMP_SPRAY WHERE PSRATING = ? AND JSON_EXTRACT(PSPRICE, '$[0].SP') BETWEEN ? AND ? Order by PSTITLE LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PUMP_SPRAY> aplist = jdbcTemplate.query(query, new Object[]{rating, from, to ,limit, offset}, (rs, num) -> {
		    PUMP_SPRAY ap = new PUMP_SPRAY();
	        ap.setPSID(rs.getString(1));
	        ap.setPSTITLE(rs.getString(2));
	        ap.setPSDESCRIPTION(rs.getString(3));
	        ap.setPSRATING(rs.getDouble(4));
			ap.setPSPRICE(rs.getString(5));
			ap.setPSSTOCKAVAILABILITY(rs.getInt(6));
			ap.setPSIMAGES(rs.getString(7));
			ap.setPSPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<PUMP_SPRAY> getAllPotPlanterLoadedByRatingPriceSORTTITLE_Z_A(int offset, int limit, double rating,
			double from, double to) {
		String query = "SELECT * FROM PUMP_SPRAY WHERE PSRATING = ? AND JSON_EXTRACT(PSPRICE, '$[0].SP') BETWEEN ? AND ? Order by PSTITLE DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PUMP_SPRAY> aplist = jdbcTemplate.query(query, new Object[]{rating, from, to ,limit, offset}, (rs, num) -> {
		    PUMP_SPRAY ap = new PUMP_SPRAY();
	        ap.setPSID(rs.getString(1));
	        ap.setPSTITLE(rs.getString(2));
	        ap.setPSDESCRIPTION(rs.getString(3));
	        ap.setPSRATING(rs.getDouble(4));
			ap.setPSPRICE(rs.getString(5));
			ap.setPSSTOCKAVAILABILITY(rs.getInt(6));
			ap.setPSIMAGES(rs.getString(7));
			ap.setPSPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}
	
	

	@Override
	public List<PUMP_SPRAY> getAllPotPlanterLoadedByRatingPriceSORTPRICE_L_H(int offset, int limit, double rating,
			double from, double to) {
		String query = "SELECT * FROM PUMP_SPRAY WHERE PSRATING = ? AND JSON_EXTRACT(PSPRICE, '$[0].SP') BETWEEN ? AND ?  order by CAST(JSON_EXTRACT(PSPRICE, '$[0].SP') AS UNSIGNED) LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PUMP_SPRAY> aplist = jdbcTemplate.query(query, new Object[]{rating, from, to ,limit, offset}, (rs, num) -> {
		    PUMP_SPRAY ap = new PUMP_SPRAY();
	        ap.setPSID(rs.getString(1));
	        ap.setPSTITLE(rs.getString(2));
	        ap.setPSDESCRIPTION(rs.getString(3));
	        ap.setPSRATING(rs.getDouble(4));
			ap.setPSPRICE(rs.getString(5));
			ap.setPSSTOCKAVAILABILITY(rs.getInt(6));
			ap.setPSIMAGES(rs.getString(7));
			ap.setPSPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;	}

	@Override
	public List<PUMP_SPRAY> getAllPotPlanterLoadedByRatingPriceSORTPRICE_H_L(int offset, int limit, double rating,
			double from, double to) {
String query = "SELECT * FROM PUMP_SPRAY WHERE PSRATING = ? AND JSON_EXTRACT(PSPRICE, '$[0].SP') BETWEEN ? AND ?  order by CAST(JSON_EXTRACT(PSPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PUMP_SPRAY> aplist = jdbcTemplate.query(query, new Object[]{rating, from, to ,limit, offset}, (rs, num) -> {
		    PUMP_SPRAY ap = new PUMP_SPRAY();
	        ap.setPSID(rs.getString(1));
	        ap.setPSTITLE(rs.getString(2));
	        ap.setPSDESCRIPTION(rs.getString(3));
	        ap.setPSRATING(rs.getDouble(4));
			ap.setPSPRICE(rs.getString(5));
			ap.setPSSTOCKAVAILABILITY(rs.getInt(6));
			ap.setPSIMAGES(rs.getString(7));
			ap.setPSPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<PUMP_SPRAY> getAllPotPlanterLoadedByRatingStockSORTTITLE_A_Z(int offset, int limit, double rating,
			int stock) {
		String query = "SELECT * FROM PUMP_SPRAY WHERE PSRATING = ? AND PSSTOCKAVAILABILITY = ? Order by PSTITLE LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PUMP_SPRAY> aplist = jdbcTemplate.query(query, new Object[]{rating,stock,limit, offset}, (rs, num) -> {
		    PUMP_SPRAY ap = new PUMP_SPRAY();
	        ap.setPSID(rs.getString(1));
	        ap.setPSTITLE(rs.getString(2));
	        ap.setPSDESCRIPTION(rs.getString(3));
	        ap.setPSRATING(rs.getDouble(4));
			ap.setPSPRICE(rs.getString(5));
			ap.setPSSTOCKAVAILABILITY(rs.getInt(6));
			ap.setPSIMAGES(rs.getString(7));
			ap.setPSPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;	}

	@Override
	public List<PUMP_SPRAY> getAllPotPlanterLoadedByRatingStockSORTTITLE_Z_A(int offset, int limit, double rating,
			int stock) {
		String query = "SELECT * FROM PUMP_SPRAY WHERE PSRATING = ? AND PSSTOCKAVAILABILITY = ? Order by PSTITLE DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PUMP_SPRAY> aplist = jdbcTemplate.query(query, new Object[]{rating,stock,limit, offset}, (rs, num) -> {
		    PUMP_SPRAY ap = new PUMP_SPRAY();
	        ap.setPSID(rs.getString(1));
	        ap.setPSTITLE(rs.getString(2));
	        ap.setPSDESCRIPTION(rs.getString(3));
	        ap.setPSRATING(rs.getDouble(4));
			ap.setPSPRICE(rs.getString(5));
			ap.setPSSTOCKAVAILABILITY(rs.getInt(6));
			ap.setPSIMAGES(rs.getString(7));
			ap.setPSPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
		
	}

	@Override
	public List<PUMP_SPRAY> getAllPotPlanterLoadedByRatingStockSORTPRICE_L_H(int offset, int limit, double rating,
			int stock) {
		String query = "SELECT * FROM PUMP_SPRAY WHERE PSRATING = ? AND PSSTOCKAVAILABILITY = ?  order by CAST(JSON_EXTRACT(PSPRICE, '$[0].SP') AS UNSIGNED) LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PUMP_SPRAY> aplist = jdbcTemplate.query(query, new Object[]{rating,stock,limit, offset}, (rs, num) -> {
		    PUMP_SPRAY ap = new PUMP_SPRAY();
	        ap.setPSID(rs.getString(1));
	        ap.setPSTITLE(rs.getString(2));
	        ap.setPSDESCRIPTION(rs.getString(3));
	        ap.setPSRATING(rs.getDouble(4));
			ap.setPSPRICE(rs.getString(5));
			ap.setPSSTOCKAVAILABILITY(rs.getInt(6));
			ap.setPSIMAGES(rs.getString(7));
			ap.setPSPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<PUMP_SPRAY> getAllPotPlanterLoadedByRatingStockSORTPRICE_H_L(int offset, int limit, double rating,
			int stock) {
String query = "SELECT * FROM PUMP_SPRAY WHERE PSRATING = ? AND PSSTOCKAVAILABILITY = ?  order by CAST(JSON_EXTRACT(PSPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PUMP_SPRAY> aplist = jdbcTemplate.query(query, new Object[]{rating,stock,limit, offset}, (rs, num) -> {
		    PUMP_SPRAY ap = new PUMP_SPRAY();
	        ap.setPSID(rs.getString(1));
	        ap.setPSTITLE(rs.getString(2));
	        ap.setPSDESCRIPTION(rs.getString(3));
	        ap.setPSRATING(rs.getDouble(4));
			ap.setPSPRICE(rs.getString(5));
			ap.setPSSTOCKAVAILABILITY(rs.getInt(6));
			ap.setPSIMAGES(rs.getString(7));
			ap.setPSPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<PUMP_SPRAY> getAllPotPlanterLoadedByPriceStockSORTTITLE_A_Z(int offset, int limit, double from,
			double to, int stock) {
		String query = "SELECT * FROM PUMP_SPRAY WHERE JSON_EXTRACT(PSPRICE, '$[0].SP') BETWEEN ? AND ? AND PSSTOCKAVAILABILITY = ? ORDER BY PSTITLE LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PUMP_SPRAY> aplist = jdbcTemplate.query(query, new Object[]{from, to,stock,limit, offset}, (rs, num) -> {
		    PUMP_SPRAY ap = new PUMP_SPRAY();
	        ap.setPSID(rs.getString(1));
	        ap.setPSTITLE(rs.getString(2));
	        ap.setPSDESCRIPTION(rs.getString(3));
	        ap.setPSRATING(rs.getDouble(4));
			ap.setPSPRICE(rs.getString(5));
			ap.setPSSTOCKAVAILABILITY(rs.getInt(6));
			ap.setPSIMAGES(rs.getString(7));
			ap.setPSPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
		
	}

	@Override
	public List<PUMP_SPRAY> getAllPotPlanterLoadedByPriceStockSORTTITLE_Z_A(int offset, int limit, double from,
			double to, int stock) {
		String query = "SELECT * FROM PUMP_SPRAY WHERE JSON_EXTRACT(PSPRICE, '$[0].SP') BETWEEN ? AND ? AND PSSTOCKAVAILABILITY = ? ORDER BY PSTITLE DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PUMP_SPRAY> aplist = jdbcTemplate.query(query, new Object[]{from, to,stock,limit, offset}, (rs, num) -> {
		    PUMP_SPRAY ap = new PUMP_SPRAY();
	        ap.setPSID(rs.getString(1));
	        ap.setPSTITLE(rs.getString(2));
	        ap.setPSDESCRIPTION(rs.getString(3));
	        ap.setPSRATING(rs.getDouble(4));
			ap.setPSPRICE(rs.getString(5));
			ap.setPSSTOCKAVAILABILITY(rs.getInt(6));
			ap.setPSIMAGES(rs.getString(7));
			ap.setPSPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<PUMP_SPRAY> getAllPotPlanterLoadedByPriceStockSORTPRICE_L_H(int offset, int limit, double from,
			double to, int stock) {
		String query = "SELECT * FROM PUMP_SPRAY WHERE JSON_EXTRACT(PSPRICE, '$[0].SP') BETWEEN ? AND ? AND PSSTOCKAVAILABILITY = ?  order by CAST(JSON_EXTRACT(PSPRICE, '$[0].SP') AS UNSIGNED) LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PUMP_SPRAY> aplist = jdbcTemplate.query(query, new Object[]{from, to,stock,limit, offset}, (rs, num) -> {
		    PUMP_SPRAY ap = new PUMP_SPRAY();
	        ap.setPSID(rs.getString(1));
	        ap.setPSTITLE(rs.getString(2));
	        ap.setPSDESCRIPTION(rs.getString(3));
	        ap.setPSRATING(rs.getDouble(4));
			ap.setPSPRICE(rs.getString(5));
			ap.setPSSTOCKAVAILABILITY(rs.getInt(6));
			ap.setPSIMAGES(rs.getString(7));
			ap.setPSPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<PUMP_SPRAY> getAllPotPlanterLoadedByPriceStockSORTPRICE_H_L(int offset, int limit, double from,
			double to, int stock) {
		String query = "SELECT * FROM PUMP_SPRAY WHERE JSON_EXTRACT(PSPRICE, '$[0].SP') BETWEEN ? AND ? AND PSSTOCKAVAILABILITY = ?  order by CAST(JSON_EXTRACT(PSPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PUMP_SPRAY> aplist = jdbcTemplate.query(query, new Object[]{from, to,stock,limit, offset}, (rs, num) -> {
		    PUMP_SPRAY ap = new PUMP_SPRAY();
	        ap.setPSID(rs.getString(1));
	        ap.setPSTITLE(rs.getString(2));
	        ap.setPSDESCRIPTION(rs.getString(3));
	        ap.setPSRATING(rs.getDouble(4));
			ap.setPSPRICE(rs.getString(5));
			ap.setPSSTOCKAVAILABILITY(rs.getInt(6));
			ap.setPSIMAGES(rs.getString(7));
			ap.setPSPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<PUMP_SPRAY> getAllPotPlanterLoadedByPriceStockRatingSORTTITLE_A_Z(int offset, int limit, double from,
			double to, int stock, double rating) {
		String query = "SELECT * FROM PUMP_SPRAY WHERE JSON_EXTRACT(PSPRICE, '$[0].SP') BETWEEN ? AND ? AND PSSTOCKAVAILABILITY = ? AND PSRATING = ? ORDER BY PSTITLE LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PUMP_SPRAY> aplist = jdbcTemplate.query(query, new Object[]{from, to,stock,rating,limit, offset}, (rs, num) -> {
		    PUMP_SPRAY ap = new PUMP_SPRAY();
	        ap.setPSID(rs.getString(1));
	        ap.setPSTITLE(rs.getString(2));
	        ap.setPSDESCRIPTION(rs.getString(3));
	        ap.setPSRATING(rs.getDouble(4));
			ap.setPSPRICE(rs.getString(5));
			ap.setPSSTOCKAVAILABILITY(rs.getInt(6));
			ap.setPSIMAGES(rs.getString(7));
			ap.setPSPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<PUMP_SPRAY> getAllPotPlanterLoadedByPriceStockRatingSORTTITLE_Z_A(int offset, int limit, double from,
			double to, int stock, double rating) {
		String query = "SELECT * FROM PUMP_SPRAY WHERE JSON_EXTRACT(PSPRICE, '$[0].SP') BETWEEN ? AND ? AND PSSTOCKAVAILABILITY = ? AND PSRATING = ? ORDER BY PSTITLE DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PUMP_SPRAY> aplist = jdbcTemplate.query(query, new Object[]{from, to,stock,rating,limit, offset}, (rs, num) -> {
		    PUMP_SPRAY ap = new PUMP_SPRAY();
	        ap.setPSID(rs.getString(1));
	        ap.setPSTITLE(rs.getString(2));
	        ap.setPSDESCRIPTION(rs.getString(3));
	        ap.setPSRATING(rs.getDouble(4));
			ap.setPSPRICE(rs.getString(5));
			ap.setPSSTOCKAVAILABILITY(rs.getInt(6));
			ap.setPSIMAGES(rs.getString(7));
			ap.setPSPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<PUMP_SPRAY> getAllPotPlanterLoadedByPriceStockRatingSORTPRICE_L_H(int offset, int limit, double from,
			double to, int stock, double rating) {
		String query = "SELECT * FROM PUMP_SPRAY WHERE JSON_EXTRACT(PSPRICE, '$[0].SP') BETWEEN ? AND ? AND PSSTOCKAVAILABILITY = ? AND PSRATING = ?  order by CAST(JSON_EXTRACT(PSPRICE, '$[0].SP') AS UNSIGNED) LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PUMP_SPRAY> aplist = jdbcTemplate.query(query, new Object[]{from, to,stock,rating,limit, offset}, (rs, num) -> {
		    PUMP_SPRAY ap = new PUMP_SPRAY();
	        ap.setPSID(rs.getString(1));
	        ap.setPSTITLE(rs.getString(2));
	        ap.setPSDESCRIPTION(rs.getString(3));
	        ap.setPSRATING(rs.getDouble(4));
			ap.setPSPRICE(rs.getString(5));
			ap.setPSSTOCKAVAILABILITY(rs.getInt(6));
			ap.setPSIMAGES(rs.getString(7));
			ap.setPSPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<PUMP_SPRAY> getAllPotPlanterLoadedByPriceStockRatingSORTPRICE_H_L(int offset, int limit, double from,
			double to, int stock, double rating) {
		String query = "SELECT * FROM PUMP_SPRAY WHERE JSON_EXTRACT(PSPRICE, '$[0].SP') BETWEEN ? AND ? AND PSSTOCKAVAILABILITY = ? AND PSRATING = ?  order by CAST(JSON_EXTRACT(PSPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PUMP_SPRAY> aplist = jdbcTemplate.query(query, new Object[]{from, to,stock,rating,limit, offset}, (rs, num) -> {
		    PUMP_SPRAY ap = new PUMP_SPRAY();
	        ap.setPSID(rs.getString(1));
	        ap.setPSTITLE(rs.getString(2));
	        ap.setPSDESCRIPTION(rs.getString(3));
	        ap.setPSRATING(rs.getDouble(4));
			ap.setPSPRICE(rs.getString(5));
			ap.setPSSTOCKAVAILABILITY(rs.getInt(6));
			ap.setPSIMAGES(rs.getString(7));
			ap.setPSPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}
	
	
	@Override
	public List<PUMP_SPRAY> Availability(int offset, int limit) {
		String query = "select * from PUMP_SPRAY where PSSTOCKAVAILABILITY=1 limit ? offset ?";
		@SuppressWarnings("deprecation")
		List<PUMP_SPRAY> aplist = jdbcTemplate.query(query,new Object[] {limit,offset}, (rs,num)->{
			PUMP_SPRAY ap = new PUMP_SPRAY();
	        ap.setPSID(rs.getString(1));
	        ap.setPSTITLE(rs.getString(2));
	        ap.setPSDESCRIPTION(rs.getString(3));
	        ap.setPSRATING(rs.getDouble(4));
			ap.setPSPRICE(rs.getString(5));
			ap.setPSSTOCKAVAILABILITY(rs.getInt(6));
			ap.setPSIMAGES(rs.getString(7));
			ap.setPSPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}
	

	@Override
	public List<PUMP_SPRAY> sortZ_A(int offset, int limit) {
		String query = "select * from PUMP_SPRAY order by PSTITLE desc limit ? offset ?";
		@SuppressWarnings("deprecation")
		List<PUMP_SPRAY> aplist = jdbcTemplate.query(query,new Object[] {limit,offset}, (rs,num)->{
			PUMP_SPRAY ap = new PUMP_SPRAY();
	        ap.setPSID(rs.getString(1));
	        ap.setPSTITLE(rs.getString(2));
	        ap.setPSDESCRIPTION(rs.getString(3));
	        ap.setPSRATING(rs.getDouble(4));
			ap.setPSPRICE(rs.getString(5));
			ap.setPSSTOCKAVAILABILITY(rs.getInt(6));
			ap.setPSIMAGES(rs.getString(7));
			ap.setPSPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}
	
	@Override
	public List<PUMP_SPRAY> Avail_A_Z(int offset, int limit) {
		String query = "select * from PUMP_SPRAY where PSSTOCKAVAILABILITY=1 order by PSTITLE limit ? offset ?";
		@SuppressWarnings("deprecation")
		List<PUMP_SPRAY> aplist = jdbcTemplate.query(query,new Object[] {limit,offset}, (rs,num)->{
			PUMP_SPRAY ap = new PUMP_SPRAY();
	        ap.setPSID(rs.getString(1));
	        ap.setPSTITLE(rs.getString(2));
	        ap.setPSDESCRIPTION(rs.getString(3));
	        ap.setPSRATING(rs.getDouble(4));
			ap.setPSPRICE(rs.getString(5));
			ap.setPSSTOCKAVAILABILITY(rs.getInt(6));
			ap.setPSIMAGES(rs.getString(7));
			ap.setPSPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<PUMP_SPRAY> Avail_Z_A(int offset, int limit) {
		String query = "select * from PUMP_SPRAY where PSSTOCKAVAILABILITY=1 order by PSTITLE desc limit ? offset ?";
		@SuppressWarnings("deprecation")
		List<PUMP_SPRAY> aplist = jdbcTemplate.query(query,new Object[] {limit,offset}, (rs,num)->{
			PUMP_SPRAY ap = new PUMP_SPRAY();
	        ap.setPSID(rs.getString(1));
	        ap.setPSTITLE(rs.getString(2));
	        ap.setPSDESCRIPTION(rs.getString(3));
	        ap.setPSRATING(rs.getDouble(4));
			ap.setPSPRICE(rs.getString(5));
			ap.setPSSTOCKAVAILABILITY(rs.getInt(6));
			ap.setPSIMAGES(rs.getString(7));
			ap.setPSPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
	}

	@Override
	public List<PUMP_SPRAY> getPlantsByPriceLH(int offset, int limit) {
String query = "SELECT * FROM PUMP_SPRAY where PSSTOCKAVAILABILITY=1 ORDER BY CAST(JSON_EXTRACT(PSPRICE, '$[0].SP') AS UNSIGNED) ASC LIMIT ? OFFSET ?";
		
	    @SuppressWarnings("deprecation")
		List<PUMP_SPRAY> aplist = jdbcTemplate.query(query,new Object[] {limit,offset},
	        (rs, num) -> {
	        	PUMP_SPRAY ap = new PUMP_SPRAY();
		        ap.setPSID(rs.getString(1));
		        ap.setPSTITLE(rs.getString(2));
		        ap.setPSDESCRIPTION(rs.getString(3));
		        ap.setPSRATING(rs.getDouble(4));
				ap.setPSPRICE(rs.getString(5));
				ap.setPSSTOCKAVAILABILITY(rs.getInt(6));
				ap.setPSIMAGES(rs.getString(7));
				ap.setPSPRODUCTDETAILS(rs.getString(8));
				return ap;
		    });
			
			return aplist;
	}

	@Override
	public List<PUMP_SPRAY> getPlantsByPriceHL(int offset, int limit) {
String query = "SELECT * FROM PUMP_SPRAY where PSSTOCKAVAILABILITY=1 ORDER BY CAST(JSON_EXTRACT(PSPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
		
	    @SuppressWarnings("deprecation")
		List<PUMP_SPRAY> aplist = jdbcTemplate.query(query,new Object[] {limit,offset},
	        (rs, num) -> {
	        	PUMP_SPRAY ap = new PUMP_SPRAY();
		        ap.setPSID(rs.getString(1));
		        ap.setPSTITLE(rs.getString(2));
		        ap.setPSDESCRIPTION(rs.getString(3));
		        ap.setPSRATING(rs.getDouble(4));
				ap.setPSPRICE(rs.getString(5));
				ap.setPSSTOCKAVAILABILITY(rs.getInt(6));
				ap.setPSIMAGES(rs.getString(7));
				ap.setPSPRODUCTDETAILS(rs.getString(8));
				return ap;
		    });
			
			return aplist;
	}

	@Override
	public List<PUMP_SPRAY> sortA_Z(int offset, int limit) {
		String query = "select * from PUMP_SPRAY order by PSTITLE limit ? offset ?";
		@SuppressWarnings("deprecation")
		List<PUMP_SPRAY> aplist = jdbcTemplate.query(query,new Object[] {limit,offset}, (rs,num)->{
			PUMP_SPRAY ap = new PUMP_SPRAY();
	        ap.setPSID(rs.getString(1));
	        ap.setPSTITLE(rs.getString(2));
	        ap.setPSDESCRIPTION(rs.getString(3));
	        ap.setPSRATING(rs.getDouble(4));
			ap.setPSPRICE(rs.getString(5));
			ap.setPSSTOCKAVAILABILITY(rs.getInt(6));
			ap.setPSIMAGES(rs.getString(7));
			ap.setPSPRODUCTDETAILS(rs.getString(8));
			return ap;
	    });
		
		return aplist;
		}
		
		
	

	@Override
	public List<PUMP_SPRAY> SORTBYPRICE_L_H(int offset, int limit) {
		String query = "SELECT * FROM PUMP_SPRAY order by CAST(JSON_EXTRACT(PSPRICE, '$[0].SP') AS UNSIGNED) ASC LIMIT ? OFFSET ?";
		
	    @SuppressWarnings("deprecation")
		List<PUMP_SPRAY> aplist = jdbcTemplate.query(query,new Object[] {limit,offset},
	        (rs, num) -> {
	        	PUMP_SPRAY ap = new PUMP_SPRAY();
		        ap.setPSID(rs.getString(1));
		        ap.setPSTITLE(rs.getString(2));
		        ap.setPSDESCRIPTION(rs.getString(3));
		        ap.setPSRATING(rs.getDouble(4));
				ap.setPSPRICE(rs.getString(5));
				ap.setPSSTOCKAVAILABILITY(rs.getInt(6));
				ap.setPSIMAGES(rs.getString(7));
				ap.setPSPRODUCTDETAILS(rs.getString(8));
				return ap;
		    });
			
			return aplist;
	    }

	

	@Override
	public List<PUMP_SPRAY> SORTBYPRICE_H_L(int offset, int limit) {
		String query = "SELECT * FROM PUMP_SPRAY order by CAST(JSON_EXTRACT(PSPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
		
	    @SuppressWarnings("deprecation")
		List<PUMP_SPRAY> aplist = jdbcTemplate.query(query,new Object[] {limit,offset},
	        (rs, num) -> {
	        	PUMP_SPRAY ap = new PUMP_SPRAY();
		        ap.setPSID(rs.getString(1));
		        ap.setPSTITLE(rs.getString(2));
		        ap.setPSDESCRIPTION(rs.getString(3));
		        ap.setPSRATING(rs.getDouble(4));
				ap.setPSPRICE(rs.getString(5));
				ap.setPSSTOCKAVAILABILITY(rs.getInt(6));
				ap.setPSIMAGES(rs.getString(7));
				ap.setPSPRODUCTDETAILS(rs.getString(8));
				return ap;
		    });
			
			return aplist;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public List<PUMP_SPRAY> getLoadedPlantsFilterSortPHL1(int offset, int limit, double from, double to) {
		String query="SELECT * FROM PUMP_SPRAY WHERE JSON_EXTRACT(PSPRICE, '$[0].SP') BETWEEN ? AND ? ORDER BY cast(JSON_EXTRACT(PSPRICE, '$[0].SP') as unsigned) DESC LIMIT ? OFFSET ?";
		List<PUMP_SPRAY> aplist = jdbcTemplate.query(query,new Object[] {from,to,limit,offset},
		        (rs, num) -> {
		        	PUMP_SPRAY ap = new PUMP_SPRAY();
			        ap.setPSID(rs.getString(1));
			        ap.setPSTITLE(rs.getString(2));
			        ap.setPSDESCRIPTION(rs.getString(3));
			        ap.setPSRATING(rs.getDouble(4));
					ap.setPSPRICE(rs.getString(5));
					ap.setPSSTOCKAVAILABILITY(rs.getInt(6));
					ap.setPSIMAGES(rs.getString(7));
					ap.setPSPRODUCTDETAILS(rs.getString(8));
					return ap;
			    });
				
				return aplist;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<PUMP_SPRAY> getLoadedPlantsFilterSortPLH1(int offset, int limit, double from, double to) {
		String query="SELECT * FROM PUMP_SPRAY WHERE JSON_EXTRACT(PSPRICE, '$[0].SP') BETWEEN ? AND ? ORDER BY cast(JSON_EXTRACT(PSPRICE, '$[0].SP') as unsigned) ASC LIMIT ? OFFSET ?";
		List<PUMP_SPRAY> aplist = jdbcTemplate.query(query,new Object[] {from,to,limit,offset},
		        (rs, num) -> {
		        	PUMP_SPRAY ap = new PUMP_SPRAY();
			        ap.setPSID(rs.getString(1));
			        ap.setPSTITLE(rs.getString(2));
			        ap.setPSDESCRIPTION(rs.getString(3));
			        ap.setPSRATING(rs.getDouble(4));
					ap.setPSPRICE(rs.getString(5));
					ap.setPSSTOCKAVAILABILITY(rs.getInt(6));
					ap.setPSIMAGES(rs.getString(7));
					ap.setPSPRODUCTDETAILS(rs.getString(8));
					return ap;
			    });
				
				return aplist;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<PUMP_SPRAY> getLoadedPlantFilterSortAZ1(int offset, int limit, double from, double to) {
		String query ="SELECT * FROM PUMP_SPRAY WHERE JSON_EXTRACT(PSPRICE, '$[0].SP') BETWEEN ? AND ? ORDER BY PSTITLE ASC LIMIT ? OFFSET ? ";
		List<PUMP_SPRAY> aplist = jdbcTemplate.query(query,new Object[] {from,to,limit,offset},
		        (rs, num) -> {
		        	PUMP_SPRAY ap = new PUMP_SPRAY();
			        ap.setPSID(rs.getString(1));
			        ap.setPSTITLE(rs.getString(2));
			        ap.setPSDESCRIPTION(rs.getString(3));
			        ap.setPSRATING(rs.getDouble(4));
					ap.setPSPRICE(rs.getString(5));
					ap.setPSSTOCKAVAILABILITY(rs.getInt(6));
					ap.setPSIMAGES(rs.getString(7));
					ap.setPSPRODUCTDETAILS(rs.getString(8));
					return ap;
			    });
				
				return aplist;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<PUMP_SPRAY> getLoadedPlantFilterSortZA1(int offset, int limit, double from, double to) {
		String query ="SELECT * FROM PUMP_SPRAY WHERE JSON_EXTRACT(PSPRICE, '$[0].SP') BETWEEN ? AND ? ORDER BY PSTITLE DESC LIMIT ? OFFSET ? ";
		List<PUMP_SPRAY> aplist = jdbcTemplate.query(query,new Object[] {from,to,limit,offset},
		        (rs, num) -> {
		        	PUMP_SPRAY ap = new PUMP_SPRAY();
			        ap.setPSID(rs.getString(1));
			        ap.setPSTITLE(rs.getString(2));
			        ap.setPSDESCRIPTION(rs.getString(3));
			        ap.setPSRATING(rs.getDouble(4));
					ap.setPSPRICE(rs.getString(5));
					ap.setPSSTOCKAVAILABILITY(rs.getInt(6));
					ap.setPSIMAGES(rs.getString(7));
					ap.setPSPRODUCTDETAILS(rs.getString(8));
					return ap;
			    });
				
				return aplist;
	}
	
	
	@SuppressWarnings("deprecation")
	@Override
	public List<PUMP_SPRAY> getLoadedPlantsFilterSortRHL2(int offset, int limit, double rating) {
		String query ="SELECT * FROM PUMP_SPRAY WHERE PSRATING = ? ORDER BY cast(JSON_EXTRACT(PSPRICE, '$[0].SP') as unsigned) DESC LIMIT ? OFFSET ? ";
		List<PUMP_SPRAY> aplist = jdbcTemplate.query(query,new Object[] {rating,limit,offset},
		        (rs, num) -> {
		        	PUMP_SPRAY ap = new PUMP_SPRAY();
			        ap.setPSID(rs.getString(1));
			        ap.setPSTITLE(rs.getString(2));
			        ap.setPSDESCRIPTION(rs.getString(3));
			        ap.setPSRATING(rs.getDouble(4));
					ap.setPSPRICE(rs.getString(5));
					ap.setPSSTOCKAVAILABILITY(rs.getInt(6));
					ap.setPSIMAGES(rs.getString(7));
					ap.setPSPRODUCTDETAILS(rs.getString(8));
					return ap;
			    });
				
				return aplist;
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<PUMP_SPRAY> getLoadedPlantsFilterSortRLH2(int offset, int limit, double rating) {
		String query ="SELECT * FROM PUMP_SPRAY WHERE PSRATING = ? ORDER BY ORDER BY cast(JSON_EXTRACT(PSPRICE, '$[0].SP') as unsigned) ASC LIMIT ? OFFSET ? ";
		List<PUMP_SPRAY> aplist = jdbcTemplate.query(query,new Object[] {rating,limit,offset},
		        (rs, num) -> {
		        	PUMP_SPRAY ap = new PUMP_SPRAY();
			        ap.setPSID(rs.getString(1));
			        ap.setPSTITLE(rs.getString(2));
			        ap.setPSDESCRIPTION(rs.getString(3));
			        ap.setPSRATING(rs.getDouble(4));
					ap.setPSPRICE(rs.getString(5));
					ap.setPSSTOCKAVAILABILITY(rs.getInt(6));
					ap.setPSIMAGES(rs.getString(7));
					ap.setPSPRODUCTDETAILS(rs.getString(8));
					return ap;
			    });
				
				return aplist;
	}

	@Override
	public List<PUMP_SPRAY> getLoadedPlantsFilterSortRAZ2(int offset, int limit, double rating) {
		String query = "SELECT * FROM PUMP_SPRAY WHERE PSRATING = ? ORDER BY PSTITLE ASC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PUMP_SPRAY> aplist = jdbcTemplate.query(query,new Object[] {rating,limit,offset},
		        (rs, num) -> {
		        	PUMP_SPRAY ap = new PUMP_SPRAY();
			        ap.setPSID(rs.getString(1));
			        ap.setPSTITLE(rs.getString(2));
			        ap.setPSDESCRIPTION(rs.getString(3));
			        ap.setPSRATING(rs.getDouble(4));
					ap.setPSPRICE(rs.getString(5));
					ap.setPSSTOCKAVAILABILITY(rs.getInt(6));
					ap.setPSIMAGES(rs.getString(7));
					ap.setPSPRODUCTDETAILS(rs.getString(8));
					return ap;
			    });
				
				return aplist;
	}

	@Override
	public List<PUMP_SPRAY> getLoadedPlantsFilterSortRZA2(int offset, int limit, double rating) {
String query = "SELECT * FROM PUMP_SPRAY WHERE PSRATING = ? ORDER BY PTITLE DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PUMP_SPRAY> aplist = jdbcTemplate.query(query,new Object[] {rating,limit,offset},
		        (rs, num) -> {
		        	PUMP_SPRAY ap = new PUMP_SPRAY();
			        ap.setPSID(rs.getString(1));
			        ap.setPSTITLE(rs.getString(2));
			        ap.setPSDESCRIPTION(rs.getString(3));
			        ap.setPSRATING(rs.getDouble(4));
					ap.setPSPRICE(rs.getString(5));
					ap.setPSSTOCKAVAILABILITY(rs.getInt(6));
					ap.setPSIMAGES(rs.getString(7));
					ap.setPSPRODUCTDETAILS(rs.getString(8));
					return ap;
			    });
				
				return aplist;
	}
	
}
