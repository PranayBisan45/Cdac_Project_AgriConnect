package com.demo.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.Model.POT_PLANTERS;

@Repository
public class POT_PLANTERS_DAO_Impl implements POT_PLANTERS_DAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<POT_PLANTERS> getAllPot_Planters() {
			
		List<POT_PLANTERS> pplist = jdbcTemplate.query("Select * from POT_PLANTERS",(rs,num)->{
			POT_PLANTERS pp = new POT_PLANTERS();
			pp.setPPID(rs.getString(1));
			pp.setPPTITLE(rs.getString(2));
			pp.setPPDESCRIPTION(rs.getString(3));
			pp.setPPDIMENSION(rs.getString(4));
			pp.setPP_RATING(rs.getDouble(5));
			pp.setPPPRICE(rs.getString(6));
			pp.setPP_STOCK_AVAILABILITY(rs.getInt(7));
			pp.setPPIMAGES(rs.getString(8));	
			
			return pp;	
		});
			
		return pplist;
	}

	@Override
	public List<POT_PLANTERS> getLoadedPp(int offset, int limit) {
	    String query = "SELECT * FROM POT_PLANTERS LIMIT ? OFFSET ?";
	    
	    @SuppressWarnings("deprecation")
		List<POT_PLANTERS> pp1list = jdbcTemplate.query(query, new Object[]{limit, offset}, (rs, num) -> {
	        POT_PLANTERS pp1 = new POT_PLANTERS();
	        pp1.setPPID(rs.getString(1));
	        pp1.setPPTITLE(rs.getString(2));
	        pp1.setPPDESCRIPTION(rs.getString(3));
	        pp1.setPPDIMENSION(rs.getString(4));
	        pp1.setPP_RATING(rs.getDouble(5));
	        pp1.setPPPRICE(rs.getString(6));
	        pp1.setPP_STOCK_AVAILABILITY(rs.getInt(7));
	        pp1.setPPIMAGES(rs.getString(8));  
	        pp1.setQuantity(rs.getInt(9));
	        return pp1;
	    });

	    return pp1list;
	}

	@Override
	public List<POT_PLANTERS> getAllPotPlanterLoadedByRating(int offset, int limit, double rating) {
        String query = "SELECT * FROM POT_PLANTERS where PP_RATING = ? LIMIT ? OFFSET ?";
	    
	    @SuppressWarnings("deprecation")
		List<POT_PLANTERS> pp2list = jdbcTemplate.query(query, new Object[]{rating ,limit, offset}, (rs, num) -> {
	        POT_PLANTERS pp2 = new POT_PLANTERS();
	        pp2.setPPID(rs.getString(1));
	        pp2.setPPTITLE(rs.getString(2));
	        pp2.setPPDESCRIPTION(rs.getString(3));
	        pp2.setPPDIMENSION(rs.getString(4));
	        pp2.setPP_RATING(rs.getDouble(5));
	        pp2.setPPPRICE(rs.getString(6));
	        pp2.setPP_STOCK_AVAILABILITY(rs.getInt(7));
	        pp2.setPPIMAGES(rs.getString(8));    
	        return pp2;
	    });

	    return pp2list;
	}

	@Override
	public List<POT_PLANTERS> getAllPotPlanterLoadedByPrice(int offset, int limit, double from, double to) {
		String query = "SELECT * FROM POT_PLANTERS WHERE JSON_EXTRACT(PPPRICE, '$[0].SP') BETWEEN ? AND ? LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<POT_PLANTERS> pp3list = jdbcTemplate.query(query, new Object[]{from, to ,limit, offset}, (rs, num) -> {
	        POT_PLANTERS pp3 = new POT_PLANTERS();
	        pp3.setPPID(rs.getString(1));
	        pp3.setPPTITLE(rs.getString(2));
	        pp3.setPPDESCRIPTION(rs.getString(3));
	        pp3.setPPDIMENSION(rs.getString(4));
	        pp3.setPP_RATING(rs.getDouble(5));
	        pp3.setPPPRICE(rs.getString(6));
	        pp3.setPP_STOCK_AVAILABILITY(rs.getInt(7));
	        pp3.setPPIMAGES(rs.getString(8));    
	        return pp3;
	    });
		
		return pp3list;
	}

	@Override
	public List<POT_PLANTERS> getAllPotPlanterLoadedByRatingPrice(int offset, int limit, double rating, double from,
			double to) {
		
		String query = "SELECT * FROM POT_PLANTERS WHERE PP_RATING = ? AND JSON_EXTRACT(PPPRICE, '$[0].SP') BETWEEN ? AND ? LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<POT_PLANTERS> pp4list = jdbcTemplate.query(query, new Object[]{rating, from, to ,limit, offset}, (rs, num) -> {
	        POT_PLANTERS pp4 = new POT_PLANTERS();
	        pp4.setPPID(rs.getString(1));
	        pp4.setPPTITLE(rs.getString(2));
	        pp4.setPPDESCRIPTION(rs.getString(3));
	        pp4.setPPDIMENSION(rs.getString(4));
	        pp4.setPP_RATING(rs.getDouble(5));
	        pp4.setPPPRICE(rs.getString(6));
	        pp4.setPP_STOCK_AVAILABILITY(rs.getInt(7));
	        pp4.setPPIMAGES(rs.getString(8));    
	        return pp4;
	    });
		return pp4list;
	}

	@Override
	public List<POT_PLANTERS> getAllPotPlanterLoadedByRatingStock(int offset, int limit, double rating, int stock) {
		String query = "SELECT * FROM POT_PLANTERS WHERE PP_RATING = ? AND PP_STOCK_AVAILABILITY = ? LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<POT_PLANTERS> pp5list = jdbcTemplate.query(query, new Object[]{rating,stock,limit, offset}, (rs, num) -> {
	        POT_PLANTERS pp5 = new POT_PLANTERS();
	        pp5.setPPID(rs.getString(1));
	        pp5.setPPTITLE(rs.getString(2));
	        pp5.setPPDESCRIPTION(rs.getString(3));
	        pp5.setPPDIMENSION(rs.getString(4));
	        pp5.setPP_RATING(rs.getDouble(5));
	        pp5.setPPPRICE(rs.getString(6));
	        pp5.setPP_STOCK_AVAILABILITY(rs.getInt(7));
	        pp5.setPPIMAGES(rs.getString(8));    
	        return pp5;
	    });
		return pp5list;
		
	}

	@Override
	public List<POT_PLANTERS> getAllPotPlanterLoadedByPriceStock(int offset, int limit, double from, double to,
			int stock) {
		String query = "SELECT * FROM POT_PLANTERS WHERE JSON_EXTRACT(PPPRICE, '$[0].SP') BETWEEN ? AND ? AND PP_STOCK_AVAILABILITY = ? LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<POT_PLANTERS> pp6list = jdbcTemplate.query(query, new Object[]{from, to,stock,limit, offset}, (rs, num) -> {
	        POT_PLANTERS pp6 = new POT_PLANTERS();
	        pp6.setPPID(rs.getString(1));
	        pp6.setPPTITLE(rs.getString(2));
	        pp6.setPPDESCRIPTION(rs.getString(3));
	        pp6.setPPDIMENSION(rs.getString(4));
	        pp6.setPP_RATING(rs.getDouble(5));
	        pp6.setPPPRICE(rs.getString(6));
	        pp6.setPP_STOCK_AVAILABILITY(rs.getInt(7));
	        pp6.setPPIMAGES(rs.getString(8));    
	        return pp6;
	    });
		return pp6list;
	}

	@Override
	public List<POT_PLANTERS> getAllPotPlanterLoadedByPriceStockRating(int offset, int limit, double from, double to,
			int stock, double rating) {
		
		String query = "SELECT * FROM POT_PLANTERS WHERE JSON_EXTRACT(PPPRICE, '$[0].SP') BETWEEN ? AND ? AND PP_STOCK_AVAILABILITY = ? AND PP_RATING = ? LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<POT_PLANTERS> pp7list = jdbcTemplate.query(query, new Object[]{from, to,stock,rating,limit, offset}, (rs, num) -> {
	        POT_PLANTERS pp7 = new POT_PLANTERS();
	        pp7.setPPID(rs.getString(1));
	        pp7.setPPTITLE(rs.getString(2));
	        pp7.setPPDESCRIPTION(rs.getString(3));
	        pp7.setPPDIMENSION(rs.getString(4));
	        pp7.setPP_RATING(rs.getDouble(5));
	        pp7.setPPPRICE(rs.getString(6));
	        pp7.setPP_STOCK_AVAILABILITY(rs.getInt(7));
	        pp7.setPPIMAGES(rs.getString(8));    
	        return pp7;
	    });
		return pp7list;
		
	}

	@Override
	public List<POT_PLANTERS> getAllPotPlanterLoadedByRatingPriceSORTTITLE_A_Z(int offset, int limit, double rating,
			double from, double to) {
		String query = "SELECT * FROM POT_PLANTERS WHERE PP_RATING = ? AND JSON_EXTRACT(PPPRICE, '$[0].SP') BETWEEN ? AND ? Order by PPTITLE LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<POT_PLANTERS> pp8list = jdbcTemplate.query(query, new Object[]{rating, from, to ,limit, offset}, (rs, num) -> {
	        POT_PLANTERS pp8 = new POT_PLANTERS();
	        pp8.setPPID(rs.getString(1));
	        pp8.setPPTITLE(rs.getString(2));
	        pp8.setPPDESCRIPTION(rs.getString(3));
	        pp8.setPPDIMENSION(rs.getString(4));
	        pp8.setPP_RATING(rs.getDouble(5));
	        pp8.setPPPRICE(rs.getString(6));
	        pp8.setPP_STOCK_AVAILABILITY(rs.getInt(7));
	        pp8.setPPIMAGES(rs.getString(8));    
	        return pp8;
	    });
		return pp8list;
	}

	@Override
	public List<POT_PLANTERS> getAllPotPlanterLoadedByRatingPriceSORTTITLE_Z_A(int offset, int limit, double rating,
			double from, double to) {
		String query = "SELECT * FROM POT_PLANTERS WHERE PP_RATING = ? AND JSON_EXTRACT(PPPRICE, '$[0].SP') BETWEEN ? AND ? Order by PPTITLE DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<POT_PLANTERS> pp9list = jdbcTemplate.query(query, new Object[]{rating, from, to ,limit, offset}, (rs, num) -> {
	        POT_PLANTERS pp9 = new POT_PLANTERS();
	        pp9.setPPID(rs.getString(1));
	        pp9.setPPTITLE(rs.getString(2));
	        pp9.setPPDESCRIPTION(rs.getString(3));
	        pp9.setPPDIMENSION(rs.getString(4));
	        pp9.setPP_RATING(rs.getDouble(5));
	        pp9.setPPPRICE(rs.getString(6));
	        pp9.setPP_STOCK_AVAILABILITY(rs.getInt(7));
	        pp9.setPPIMAGES(rs.getString(8));    
	        return pp9;
	    });
		return pp9list;
	}
	
	

	@Override
	public List<POT_PLANTERS> getAllPotPlanterLoadedByRatingPriceSORTPRICE_L_H(int offset, int limit, double rating,
			double from, double to) {
		String query = "SELECT * FROM POT_PLANTERS WHERE PP_RATING = ? AND JSON_EXTRACT(PPPRICE, '$[0].SP') BETWEEN ? AND ?  order by CAST(JSON_EXTRACT(PPPRICE, '$[0].SP') AS UNSIGNED) LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<POT_PLANTERS> pp10list = jdbcTemplate.query(query, new Object[]{rating, from, to ,limit, offset}, (rs, num) -> {
	        POT_PLANTERS pp10 = new POT_PLANTERS();
	        pp10.setPPID(rs.getString(1));
	        pp10.setPPTITLE(rs.getString(2));
	        pp10.setPPDESCRIPTION(rs.getString(3));
	        pp10.setPPDIMENSION(rs.getString(4));
	        pp10.setPP_RATING(rs.getDouble(5));
	        pp10.setPPPRICE(rs.getString(6));
	        pp10.setPP_STOCK_AVAILABILITY(rs.getInt(7));
	        pp10.setPPIMAGES(rs.getString(8));    
	        return pp10;
	    });
		return pp10list;
	}

	@Override
	public List<POT_PLANTERS> getAllPotPlanterLoadedByRatingPriceSORTPRICE_H_L(int offset, int limit, double rating,
			double from, double to) {
String query = "SELECT * FROM POT_PLANTERS WHERE PP_RATING = ? AND JSON_EXTRACT(PPPRICE, '$[0].SP') BETWEEN ? AND ?  order by CAST(JSON_EXTRACT(PPPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<POT_PLANTERS> pp11list = jdbcTemplate.query(query, new Object[]{rating, from, to ,limit, offset}, (rs, num) -> {
	        POT_PLANTERS pp11 = new POT_PLANTERS();
	        pp11.setPPID(rs.getString(1));
	        pp11.setPPTITLE(rs.getString(2));
	        pp11.setPPDESCRIPTION(rs.getString(3));
	        pp11.setPPDIMENSION(rs.getString(4));
	        pp11.setPP_RATING(rs.getDouble(5));
	        pp11.setPPPRICE(rs.getString(6));
	        pp11.setPP_STOCK_AVAILABILITY(rs.getInt(7));
	        pp11.setPPIMAGES(rs.getString(8));    
	        return pp11;
	    });
		return pp11list;
	}

	@Override
	public List<POT_PLANTERS> getAllPotPlanterLoadedByRatingStockSORTTITLE_A_Z(int offset, int limit, double rating,
			int stock) {
		String query = "SELECT * FROM POT_PLANTERS WHERE PP_RATING = ? AND PP_STOCK_AVAILABILITY = ? Order by PPTITLE LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<POT_PLANTERS> pp12list = jdbcTemplate.query(query, new Object[]{rating,stock,limit, offset}, (rs, num) -> {
	        POT_PLANTERS pp12 = new POT_PLANTERS();
	        pp12.setPPID(rs.getString(1));
	        pp12.setPPTITLE(rs.getString(2));
	        pp12.setPPDESCRIPTION(rs.getString(3));
	        pp12.setPPDIMENSION(rs.getString(4));
	        pp12.setPP_RATING(rs.getDouble(5));
	        pp12.setPPPRICE(rs.getString(6));
	        pp12.setPP_STOCK_AVAILABILITY(rs.getInt(7));
	        pp12.setPPIMAGES(rs.getString(8));    
	        return pp12;
	    });
		return pp12list;
	}

	@Override
	public List<POT_PLANTERS> getAllPotPlanterLoadedByRatingStockSORTTITLE_Z_A(int offset, int limit, double rating,
			int stock) {
		String query = "SELECT * FROM POT_PLANTERS WHERE PP_RATING = ? AND PP_STOCK_AVAILABILITY = ? Order by PPTITLE DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<POT_PLANTERS> pp13list = jdbcTemplate.query(query, new Object[]{rating,stock,limit, offset}, (rs, num) -> {
	        POT_PLANTERS pp13 = new POT_PLANTERS();
	        pp13.setPPID(rs.getString(1));
	        pp13.setPPTITLE(rs.getString(2));
	        pp13.setPPDESCRIPTION(rs.getString(3));
	        pp13.setPPDIMENSION(rs.getString(4));
	        pp13.setPP_RATING(rs.getDouble(5));
	        pp13.setPPPRICE(rs.getString(6));
	        pp13.setPP_STOCK_AVAILABILITY(rs.getInt(7));
	        pp13.setPPIMAGES(rs.getString(8));    
	        return pp13;
	    });
		return pp13list;
		
	}

	@Override
	public List<POT_PLANTERS> getAllPotPlanterLoadedByRatingStockSORTPRICE_L_H(int offset, int limit, double rating,
			int stock) {
		String query = "SELECT * FROM POT_PLANTERS WHERE PP_RATING = ? AND PP_STOCK_AVAILABILITY = ?  order by CAST(JSON_EXTRACT(PPPRICE, '$[0].SP') AS UNSIGNED) LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<POT_PLANTERS> pp14list = jdbcTemplate.query(query, new Object[]{rating,stock,limit, offset}, (rs, num) -> {
	        POT_PLANTERS pp14 = new POT_PLANTERS();
	        pp14.setPPID(rs.getString(1));
	        pp14.setPPTITLE(rs.getString(2));
	        pp14.setPPDESCRIPTION(rs.getString(3));
	        pp14.setPPDIMENSION(rs.getString(4));
	        pp14.setPP_RATING(rs.getDouble(5));
	        pp14.setPPPRICE(rs.getString(6));
	        pp14.setPP_STOCK_AVAILABILITY(rs.getInt(7));
	        pp14.setPPIMAGES(rs.getString(8));    
	        return pp14;
	    });
		return pp14list;
	}

	@Override
	public List<POT_PLANTERS> getAllPotPlanterLoadedByRatingStockSORTPRICE_H_L(int offset, int limit, double rating,
			int stock) {
String query = "SELECT * FROM POT_PLANTERS WHERE PP_RATING = ? AND PP_STOCK_AVAILABILITY = ?  order by CAST(JSON_EXTRACT(PPPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<POT_PLANTERS> pp15list = jdbcTemplate.query(query, new Object[]{rating,stock,limit, offset}, (rs, num) -> {
	        POT_PLANTERS pp15 = new POT_PLANTERS();
	        pp15.setPPID(rs.getString(1));
	        pp15.setPPTITLE(rs.getString(2));
	        pp15.setPPDESCRIPTION(rs.getString(3));
	        pp15.setPPDIMENSION(rs.getString(4));
	        pp15.setPP_RATING(rs.getDouble(5));
	        pp15.setPPPRICE(rs.getString(6));
	        pp15.setPP_STOCK_AVAILABILITY(rs.getInt(7));
	        pp15.setPPIMAGES(rs.getString(8));    
	        return pp15;
	    });
		return pp15list;
	}

	@Override
	public List<POT_PLANTERS> getAllPotPlanterLoadedByPriceStockSORTTITLE_A_Z(int offset, int limit, double from,
			double to, int stock) {
		String query = "SELECT * FROM POT_PLANTERS WHERE JSON_EXTRACT(PPPRICE, '$[0].SP') BETWEEN ? AND ? AND PP_STOCK_AVAILABILITY = ? ORDER BY PPTITLE LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<POT_PLANTERS> pp16list = jdbcTemplate.query(query, new Object[]{from, to,stock,limit, offset}, (rs, num) -> {
	        POT_PLANTERS pp16 = new POT_PLANTERS();
	        pp16.setPPID(rs.getString(1));
	        pp16.setPPTITLE(rs.getString(2));
	        pp16.setPPDESCRIPTION(rs.getString(3));
	        pp16.setPPDIMENSION(rs.getString(4));
	        pp16.setPP_RATING(rs.getDouble(5));
	        pp16.setPPPRICE(rs.getString(6));
	        pp16.setPP_STOCK_AVAILABILITY(rs.getInt(7));
	        pp16.setPPIMAGES(rs.getString(8));    
	        return pp16;
	    });
		return pp16list;
		
	}

	@Override
	public List<POT_PLANTERS> getAllPotPlanterLoadedByPriceStockSORTTITLE_Z_A(int offset, int limit, double from,
			double to, int stock) {
		String query = "SELECT * FROM POT_PLANTERS WHERE JSON_EXTRACT(PPPRICE, '$[0].SP') BETWEEN ? AND ? AND PP_STOCK_AVAILABILITY = ? ORDER BY PPTITLE DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<POT_PLANTERS> pp17list = jdbcTemplate.query(query, new Object[]{from, to,stock,limit, offset}, (rs, num) -> {
	        POT_PLANTERS pp17 = new POT_PLANTERS();
	        pp17.setPPID(rs.getString(1));
	        pp17.setPPTITLE(rs.getString(2));
	        pp17.setPPDESCRIPTION(rs.getString(3));
	        pp17.setPPDIMENSION(rs.getString(4));
	        pp17.setPP_RATING(rs.getDouble(5));
	        pp17.setPPPRICE(rs.getString(6));
	        pp17.setPP_STOCK_AVAILABILITY(rs.getInt(7));
	        pp17.setPPIMAGES(rs.getString(8));    
	        return pp17;
	    });
		return pp17list;
	}

	@Override
	public List<POT_PLANTERS> getAllPotPlanterLoadedByPriceStockSORTPRICE_L_H(int offset, int limit, double from,
			double to, int stock) {
		String query = "SELECT * FROM POT_PLANTERS WHERE JSON_EXTRACT(PPPRICE, '$[0].SP') BETWEEN ? AND ? AND PP_STOCK_AVAILABILITY = ?  order by CAST(JSON_EXTRACT(PPPRICE, '$[0].SP') AS UNSIGNED) LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<POT_PLANTERS> pp18list = jdbcTemplate.query(query, new Object[]{from, to,stock,limit, offset}, (rs, num) -> {
	        POT_PLANTERS pp18 = new POT_PLANTERS();
	        pp18.setPPID(rs.getString(1));
	        pp18.setPPTITLE(rs.getString(2));
	        pp18.setPPDESCRIPTION(rs.getString(3));
	        pp18.setPPDIMENSION(rs.getString(4));
	        pp18.setPP_RATING(rs.getDouble(5));
	        pp18.setPPPRICE(rs.getString(6));
	        pp18.setPP_STOCK_AVAILABILITY(rs.getInt(7));
	        pp18.setPPIMAGES(rs.getString(8));    
	        return pp18;
	    });
		return pp18list;
	}

	@Override
	public List<POT_PLANTERS> getAllPotPlanterLoadedByPriceStockSORTPRICE_H_L(int offset, int limit, double from,
			double to, int stock) {
		String query = "SELECT * FROM POT_PLANTERS WHERE JSON_EXTRACT(PPPRICE, '$[0].SP') BETWEEN ? AND ? AND PP_STOCK_AVAILABILITY = ?  order by CAST(JSON_EXTRACT(PPPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<POT_PLANTERS> pp19list = jdbcTemplate.query(query, new Object[]{from, to,stock,limit, offset}, (rs, num) -> {
	        POT_PLANTERS pp19 = new POT_PLANTERS();
	        pp19.setPPID(rs.getString(1));
	        pp19.setPPTITLE(rs.getString(2));
	        pp19.setPPDESCRIPTION(rs.getString(3));
	        pp19.setPPDIMENSION(rs.getString(4));
	        pp19.setPP_RATING(rs.getDouble(5));
	        pp19.setPPPRICE(rs.getString(6));
	        pp19.setPP_STOCK_AVAILABILITY(rs.getInt(7));
	        pp19.setPPIMAGES(rs.getString(8));    
	        return pp19;
	    });
		return pp19list;
	}

	@Override
	public List<POT_PLANTERS> getAllPotPlanterLoadedByPriceStockRatingSORTTITLE_A_Z(int offset, int limit, double from,
			double to, int stock, double rating) {
		String query = "SELECT * FROM POT_PLANTERS WHERE JSON_EXTRACT(PPPRICE, '$[0].SP') BETWEEN ? AND ? AND PP_STOCK_AVAILABILITY = ? AND PP_RATING = ? ORDER BY PPTITLE LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<POT_PLANTERS> pp20list = jdbcTemplate.query(query, new Object[]{from, to,stock,rating,limit, offset}, (rs, num) -> {
	        POT_PLANTERS pp20 = new POT_PLANTERS();
	        pp20.setPPID(rs.getString(1));
	        pp20.setPPTITLE(rs.getString(2));
	        pp20.setPPDESCRIPTION(rs.getString(3));
	        pp20.setPPDIMENSION(rs.getString(4));
	        pp20.setPP_RATING(rs.getDouble(5));
	        pp20.setPPPRICE(rs.getString(6));
	        pp20.setPP_STOCK_AVAILABILITY(rs.getInt(7));
	        pp20.setPPIMAGES(rs.getString(8));    
	        return pp20;
	    });
		return pp20list;
	}

	@Override
	public List<POT_PLANTERS> getAllPotPlanterLoadedByPriceStockRatingSORTTITLE_Z_A(int offset, int limit, double from,
			double to, int stock, double rating) {
		String query = "SELECT * FROM POT_PLANTERS WHERE JSON_EXTRACT(PPPRICE, '$[0].SP') BETWEEN ? AND ? AND PP_STOCK_AVAILABILITY = ? AND PP_RATING = ? ORDER BY PPTITLE DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<POT_PLANTERS> pp21list = jdbcTemplate.query(query, new Object[]{from, to,stock,rating,limit, offset}, (rs, num) -> {
	        POT_PLANTERS pp21 = new POT_PLANTERS();
	        pp21.setPPID(rs.getString(1));
	        pp21.setPPTITLE(rs.getString(2));
	        pp21.setPPDESCRIPTION(rs.getString(3));
	        pp21.setPPDIMENSION(rs.getString(4));
	        pp21.setPP_RATING(rs.getDouble(5));
	        pp21.setPPPRICE(rs.getString(6));
	        pp21.setPP_STOCK_AVAILABILITY(rs.getInt(7));
	        pp21.setPPIMAGES(rs.getString(8));    
	        return pp21;
	    });
		return pp21list;
	}

	@Override
	public List<POT_PLANTERS> getAllPotPlanterLoadedByPriceStockRatingSORTPRICE_L_H(int offset, int limit, double from,
			double to, int stock, double rating) {
		String query = "SELECT * FROM POT_PLANTERS WHERE JSON_EXTRACT(PPPRICE, '$[0].SP') BETWEEN ? AND ? AND PP_STOCK_AVAILABILITY = ? AND PP_RATING = ?  order by CAST(JSON_EXTRACT(PPPRICE, '$[0].SP') AS UNSIGNED) LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<POT_PLANTERS> pp22list = jdbcTemplate.query(query, new Object[]{from, to,stock,rating,limit, offset}, (rs, num) -> {
	        POT_PLANTERS pp22 = new POT_PLANTERS();
	        pp22.setPPID(rs.getString(1));
	        pp22.setPPTITLE(rs.getString(2));
	        pp22.setPPDESCRIPTION(rs.getString(3));
	        pp22.setPPDIMENSION(rs.getString(4));
	        pp22.setPP_RATING(rs.getDouble(5));
	        pp22.setPPPRICE(rs.getString(6));
	        pp22.setPP_STOCK_AVAILABILITY(rs.getInt(7));
	        pp22.setPPIMAGES(rs.getString(8));    
	        return pp22;
	    });
		return pp22list;
	}

	@Override
	public List<POT_PLANTERS> getAllPotPlanterLoadedByPriceStockRatingSORTPRICE_H_L(int offset, int limit, double from,
			double to, int stock, double rating) {
		String query = "SELECT * FROM POT_PLANTERS WHERE JSON_EXTRACT(PPPRICE, '$[0].SP') BETWEEN ? AND ? AND PP_STOCK_AVAILABILITY = ? AND PP_RATING = ?  order by CAST(JSON_EXTRACT(PPPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<POT_PLANTERS> pp23list = jdbcTemplate.query(query, new Object[]{from, to,stock,rating,limit, offset}, (rs, num) -> {
	        POT_PLANTERS pp23 = new POT_PLANTERS();
	        pp23.setPPID(rs.getString(1));
	        pp23.setPPTITLE(rs.getString(2));
	        pp23.setPPDESCRIPTION(rs.getString(3));
	        pp23.setPPDIMENSION(rs.getString(4));
	        pp23.setPP_RATING(rs.getDouble(5));
	        pp23.setPPPRICE(rs.getString(6));
	        pp23.setPP_STOCK_AVAILABILITY(rs.getInt(7));
	        pp23.setPPIMAGES(rs.getString(8));    
	        return pp23;
	    });
		return pp23list;
	}

	@SuppressWarnings("deprecation")
	@Override
	public POT_PLANTERS findById(String pfid) {
		String query = "select * from POT_PLANTERS where ppid=?";
		POT_PLANTERS pp = new POT_PLANTERS();
		try {
		    return jdbcTemplate.queryForObject(query,new Object[] {pfid},BeanPropertyRowMapper.newInstance(POT_PLANTERS.class));
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<POT_PLANTERS> Availability(int offset, int limit) {
		String query = "select * from POT_PLANTERS where PP_STOCK_AVAILABILITY=1 limit ? offset ?";
		@SuppressWarnings("deprecation")
		List<POT_PLANTERS> availablelist = jdbcTemplate.query(query,new Object[] {limit,offset}, (rs,num)->{
			POT_PLANTERS pp24 = new POT_PLANTERS();
	        pp24.setPPID(rs.getString(1));
	        pp24.setPPTITLE(rs.getString(2));
	        pp24.setPPDESCRIPTION(rs.getString(3));
	        pp24.setPPDIMENSION(rs.getString(4));
	        pp24.setPP_RATING(rs.getDouble(5));
	        pp24.setPPPRICE(rs.getString(6));
	        pp24.setPP_STOCK_AVAILABILITY(rs.getInt(7));
	        pp24.setPPIMAGES(rs.getString(8));    
	        return pp24;
		});
		
		return availablelist;
	}
	

	@Override
	public List<POT_PLANTERS> sortZ_A(int offset, int limit) {
		String query = "select * from POT_PLANTERS order by pptitle desc limit ? offset ?";
		@SuppressWarnings("deprecation")
		List<POT_PLANTERS> sortlist = jdbcTemplate.query(query,new Object[] {limit,offset}, (rs,num)->{
			POT_PLANTERS pp24 = new POT_PLANTERS();
	        pp24.setPPID(rs.getString(1));
	        pp24.setPPTITLE(rs.getString(2));
	        pp24.setPPDESCRIPTION(rs.getString(3));
	        pp24.setPPDIMENSION(rs.getString(4));
	        pp24.setPP_RATING(rs.getDouble(5));
	        pp24.setPPPRICE(rs.getString(6));
	        pp24.setPP_STOCK_AVAILABILITY(rs.getInt(7));
	        pp24.setPPIMAGES(rs.getString(8));    
	        return pp24;
		});
		
		return sortlist;
	}
	
	@Override
	public List<POT_PLANTERS> Avail_A_Z(int offset, int limit) {
		String query = "select * from POT_PLANTERS where PP_STOCK_AVAILABILITY=1 order by PPTitle limit ? offset ?";
		@SuppressWarnings("deprecation")
		List<POT_PLANTERS> availablelist_A_Z = jdbcTemplate.query(query,new Object[] {limit,offset}, (rs,num)->{
			POT_PLANTERS pp24 = new POT_PLANTERS();
	        pp24.setPPID(rs.getString(1));
	        pp24.setPPTITLE(rs.getString(2));
	        pp24.setPPDESCRIPTION(rs.getString(3));
	        pp24.setPPDIMENSION(rs.getString(4));
	        pp24.setPP_RATING(rs.getDouble(5));
	        pp24.setPPPRICE(rs.getString(6));
	        pp24.setPP_STOCK_AVAILABILITY(rs.getInt(7));
	        pp24.setPPIMAGES(rs.getString(8));    
	        return pp24;
		});
		
		return availablelist_A_Z;
	}

	@Override
	public List<POT_PLANTERS> Avail_Z_A(int offset, int limit) {
		String query = "select * from POT_PLANTERS where PP_STOCK_AVAILABILITY=1 order by PPTitle desc limit ? offset ?";
		@SuppressWarnings("deprecation")
		List<POT_PLANTERS> availablelist_Z_A = jdbcTemplate.query(query,new Object[] {limit,offset}, (rs,num)->{
			POT_PLANTERS pp24 = new POT_PLANTERS();
	        pp24.setPPID(rs.getString(1));
	        pp24.setPPTITLE(rs.getString(2));
	        pp24.setPPDESCRIPTION(rs.getString(3));
	        pp24.setPPDIMENSION(rs.getString(4));
	        pp24.setPP_RATING(rs.getDouble(5));
	        pp24.setPPPRICE(rs.getString(6));
	        pp24.setPP_STOCK_AVAILABILITY(rs.getInt(7));
	        pp24.setPPIMAGES(rs.getString(8));    
	        return pp24;
		});
		
		return availablelist_Z_A;
	}

	@Override
	public List<POT_PLANTERS> getPlantsByPriceLH(int offset, int limit) {
String query = "SELECT * FROM POT_PLANTERS where PP_STOCK_AVAILABILITY=1 ORDER BY CAST(JSON_EXTRACT(PPPRICE, '$[0].SP') AS UNSIGNED) ASC LIMIT ? OFFSET ?";
		
	    @SuppressWarnings("deprecation")
		List<POT_PLANTERS> plist = jdbcTemplate.query(query,new Object[] {limit,offset},
	        (rs, num) -> {
	        	POT_PLANTERS pp24 = new POT_PLANTERS();
		        pp24.setPPID(rs.getString(1));
		        pp24.setPPTITLE(rs.getString(2));
		        pp24.setPPDESCRIPTION(rs.getString(3));
		        pp24.setPPDIMENSION(rs.getString(4));
		        pp24.setPP_RATING(rs.getDouble(5));
		        pp24.setPPPRICE(rs.getString(6));
		        pp24.setPP_STOCK_AVAILABILITY(rs.getInt(7));
		        pp24.setPPIMAGES(rs.getString(8));    
		        return pp24;
	        });
	    return plist;
	}

	@Override
	public List<POT_PLANTERS> getPlantsByPriceHL(int offset, int limit) {
String query = "SELECT * FROM POT_PLANTERS where PP_STOCK_AVAILABILITY=1 ORDER BY CAST(JSON_EXTRACT(PPPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
		
	    @SuppressWarnings("deprecation")
		List<POT_PLANTERS> plist = jdbcTemplate.query(query,new Object[] {limit,offset},
	        (rs, num) -> {
	        	POT_PLANTERS pp24 = new POT_PLANTERS();
		        pp24.setPPID(rs.getString(1));
		        pp24.setPPTITLE(rs.getString(2));
		        pp24.setPPDESCRIPTION(rs.getString(3));
		        pp24.setPPDIMENSION(rs.getString(4));
		        pp24.setPP_RATING(rs.getDouble(5));
		        pp24.setPPPRICE(rs.getString(6));
		        pp24.setPP_STOCK_AVAILABILITY(rs.getInt(7));
		        pp24.setPPIMAGES(rs.getString(8));    
		        return pp24;
	        });
	    return plist;
	}

	@Override
	public List<POT_PLANTERS> sortA_Z(int offset, int limit) {
		String query = "select * from POT_PLANTERS order by pptitle limit ? offset ?";
		@SuppressWarnings("deprecation")
		List<POT_PLANTERS> sortlist = jdbcTemplate.query(query,new Object[] {limit,offset}, (rs,num)->{
			POT_PLANTERS pp24 = new POT_PLANTERS();
	        pp24.setPPID(rs.getString(1));
	        pp24.setPPTITLE(rs.getString(2));
	        pp24.setPPDESCRIPTION(rs.getString(3));
	        pp24.setPPDIMENSION(rs.getString(4));
	        pp24.setPP_RATING(rs.getDouble(5));
	        pp24.setPPPRICE(rs.getString(6));
	        pp24.setPP_STOCK_AVAILABILITY(rs.getInt(7));
	        pp24.setPPIMAGES(rs.getString(8));    
	        return pp24;
		});
		
		return sortlist;
	}

	@Override
	public List<POT_PLANTERS> SORTBYPRICE_L_H(int offset, int limit) {
		String query = "SELECT * FROM POT_PLANTERS order by CAST(JSON_EXTRACT(PPPRICE, '$[0].SP') AS UNSIGNED) ASC LIMIT ? OFFSET ?";
		
	    @SuppressWarnings("deprecation")
		List<POT_PLANTERS> plist = jdbcTemplate.query(query,new Object[] {limit,offset},
	        (rs, num) -> {
	        	POT_PLANTERS pp24 = new POT_PLANTERS();
		        pp24.setPPID(rs.getString(1));
		        pp24.setPPTITLE(rs.getString(2));
		        pp24.setPPDESCRIPTION(rs.getString(3));
		        pp24.setPPDIMENSION(rs.getString(4));
		        pp24.setPP_RATING(rs.getDouble(5));
		        pp24.setPPPRICE(rs.getString(6));
		        pp24.setPP_STOCK_AVAILABILITY(rs.getInt(7));
		        pp24.setPPIMAGES(rs.getString(8));    
		        return pp24;
	        });
	    return plist;	
	    }

	

	@Override
	public List<POT_PLANTERS> SORTBYPRICE_H_L(int offset, int limit) {
		String query = "SELECT * FROM POT_PLANTERS order by CAST(JSON_EXTRACT(PPPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
		
	    @SuppressWarnings("deprecation")
		List<POT_PLANTERS> plist = jdbcTemplate.query(query,new Object[] {limit,offset},
	        (rs, num) -> {
	        	POT_PLANTERS pp24 = new POT_PLANTERS();
		        pp24.setPPID(rs.getString(1));
		        pp24.setPPTITLE(rs.getString(2));
		        pp24.setPPDESCRIPTION(rs.getString(3));
		        pp24.setPPDIMENSION(rs.getString(4));
		        pp24.setPP_RATING(rs.getDouble(5));
		        pp24.setPPPRICE(rs.getString(6));
		        pp24.setPP_STOCK_AVAILABILITY(rs.getInt(7));
		        pp24.setPPIMAGES(rs.getString(8));    
		        return pp24;
	        });
	    return plist;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public List<POT_PLANTERS> getLoadedPlantsFilterSortPHL1(int offset, int limit, double from, double to) {
		String query="SELECT * FROM POT_PLANTERS WHERE JSON_EXTRACT(PPPRICE, '$[0].SP') BETWEEN ? AND ? ORDER BY cast(JSON_EXTRACT(PPPRICE, '$[0].SP') as unsigned) DESC LIMIT ? OFFSET ?";
		List<POT_PLANTERS> plist = jdbcTemplate.query(query,new Object[] {from,to,limit,offset},
		        (rs, num) -> {
		        	POT_PLANTERS pp24 = new POT_PLANTERS();
			        pp24.setPPID(rs.getString(1));
			        pp24.setPPTITLE(rs.getString(2));
			        pp24.setPPDESCRIPTION(rs.getString(3));
			        pp24.setPPDIMENSION(rs.getString(4));
			        pp24.setPP_RATING(rs.getDouble(5));
			        pp24.setPPPRICE(rs.getString(6));
			        pp24.setPP_STOCK_AVAILABILITY(rs.getInt(7));
			        pp24.setPPIMAGES(rs.getString(8));    
			        return pp24;
		        });
		    return plist;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<POT_PLANTERS> getLoadedPlantsFilterSortPLH1(int offset, int limit, double from, double to) {
		String query="SELECT * FROM POT_PLANTERS WHERE JSON_EXTRACT(PPPRICE, '$[0].SP') BETWEEN ? AND ? ORDER BY cast(JSON_EXTRACT(PPPRICE, '$[0].SP') as unsigned) ASC LIMIT ? OFFSET ?";
		List<POT_PLANTERS> plist = jdbcTemplate.query(query,new Object[] {from,to,limit,offset},
		        (rs, num) -> {
		        	POT_PLANTERS pp24 = new POT_PLANTERS();
			        pp24.setPPID(rs.getString(1));
			        pp24.setPPTITLE(rs.getString(2));
			        pp24.setPPDESCRIPTION(rs.getString(3));
			        pp24.setPPDIMENSION(rs.getString(4));
			        pp24.setPP_RATING(rs.getDouble(5));
			        pp24.setPPPRICE(rs.getString(6));
			        pp24.setPP_STOCK_AVAILABILITY(rs.getInt(7));
			        pp24.setPPIMAGES(rs.getString(8));    
			        return pp24;
		        });
		    return plist;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<POT_PLANTERS> getLoadedPlantFilterSortAZ1(int offset, int limit, double from, double to) {
		String query ="SELECT * FROM POT_PLANTERS WHERE JSON_EXTRACT(PPPRICE, '$[0].SP') BETWEEN ? AND ? ORDER BY PPTITLE ASC LIMIT ? OFFSET ? ";
		List<POT_PLANTERS> plist = jdbcTemplate.query(query,new Object[] {from,to,limit,offset},
		        (rs, num) -> {
		        	POT_PLANTERS pp24 = new POT_PLANTERS();
			        pp24.setPPID(rs.getString(1));
			        pp24.setPPTITLE(rs.getString(2));
			        pp24.setPPDESCRIPTION(rs.getString(3));
			        pp24.setPPDIMENSION(rs.getString(4));
			        pp24.setPP_RATING(rs.getDouble(5));
			        pp24.setPPPRICE(rs.getString(6));
			        pp24.setPP_STOCK_AVAILABILITY(rs.getInt(7));
			        pp24.setPPIMAGES(rs.getString(8));    
			        return pp24;
		        });
		    return plist;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<POT_PLANTERS> getLoadedPlantFilterSortZA1(int offset, int limit, double from, double to) {
		String query ="SELECT * FROM POT_PLANTERS WHERE JSON_EXTRACT(PPPRICE, '$[0].SP') BETWEEN ? AND ? ORDER BY PPTITLE DESC LIMIT ? OFFSET ? ";
		List<POT_PLANTERS> plist = jdbcTemplate.query(query,new Object[] {from,to,limit,offset},
		        (rs, num) -> {
		        	POT_PLANTERS pp24 = new POT_PLANTERS();
			        pp24.setPPID(rs.getString(1));
			        pp24.setPPTITLE(rs.getString(2));
			        pp24.setPPDESCRIPTION(rs.getString(3));
			        pp24.setPPDIMENSION(rs.getString(4));
			        pp24.setPP_RATING(rs.getDouble(5));
			        pp24.setPPPRICE(rs.getString(6));
			        pp24.setPP_STOCK_AVAILABILITY(rs.getInt(7));
			        pp24.setPPIMAGES(rs.getString(8));    
			        return pp24;
		        });
		    return plist;
	}
	
	
	@SuppressWarnings("deprecation")
	@Override
	public List<POT_PLANTERS> getLoadedPlantsFilterSortRHL2(int offset, int limit, double rating) {
		String query ="SELECT * FROM POT_PLANTERS WHERE PP_RATING = ? ORDER BY cast(JSON_EXTRACT(PPPRICE, '$[0].SP') as unsigned) DESC LIMIT ? OFFSET ? ";
		List<POT_PLANTERS> plist = jdbcTemplate.query(query,new Object[] {rating,limit,offset},
		        (rs, num) -> {
		        	POT_PLANTERS pp24 = new POT_PLANTERS();
			        pp24.setPPID(rs.getString(1));
			        pp24.setPPTITLE(rs.getString(2));
			        pp24.setPPDESCRIPTION(rs.getString(3));
			        pp24.setPPDIMENSION(rs.getString(4));
			        pp24.setPP_RATING(rs.getDouble(5));
			        pp24.setPPPRICE(rs.getString(6));
			        pp24.setPP_STOCK_AVAILABILITY(rs.getInt(7));
			        pp24.setPPIMAGES(rs.getString(8));    
			        return pp24;
		        });
		    return plist;
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<POT_PLANTERS> getLoadedPlantsFilterSortRLH2(int offset, int limit, double rating) {
		String query ="SELECT * FROM POT_PLANTERS WHERE PP_RATING = ? ORDER BY ORDER BY cast(JSON_EXTRACT(PPPRICE, '$[0].SP') as unsigned) ASC LIMIT ? OFFSET ? ";
		List<POT_PLANTERS> plist = jdbcTemplate.query(query,new Object[] {rating,limit,offset},
		        (rs, num) -> {
		        	POT_PLANTERS pp24 = new POT_PLANTERS();
			        pp24.setPPID(rs.getString(1));
			        pp24.setPPTITLE(rs.getString(2));
			        pp24.setPPDESCRIPTION(rs.getString(3));
			        pp24.setPPDIMENSION(rs.getString(4));
			        pp24.setPP_RATING(rs.getDouble(5));
			        pp24.setPPPRICE(rs.getString(6));
			        pp24.setPP_STOCK_AVAILABILITY(rs.getInt(7));
			        pp24.setPPIMAGES(rs.getString(8));    
			        return pp24;
		        });
		    return plist;
	}

	@Override
	public List<POT_PLANTERS> getLoadedPlantsFilterSortRAZ2(int offset, int limit, double rating) {
		String query = "SELECT * FROM POT_PLANTERS WHERE PP_RATING = ? ORDER BY PPTITLE ASC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<POT_PLANTERS> plist = jdbcTemplate.query(query,new Object[] {rating,limit,offset},
		        (rs, num) -> {
		        	POT_PLANTERS pp24 = new POT_PLANTERS();
			        pp24.setPPID(rs.getString(1));
			        pp24.setPPTITLE(rs.getString(2));
			        pp24.setPPDESCRIPTION(rs.getString(3));
			        pp24.setPPDIMENSION(rs.getString(4));
			        pp24.setPP_RATING(rs.getDouble(5));
			        pp24.setPPPRICE(rs.getString(6));
			        pp24.setPP_STOCK_AVAILABILITY(rs.getInt(7));
			        pp24.setPPIMAGES(rs.getString(8));    
			        return pp24;
		        });
		    return plist;
	}

	@Override
	public List<POT_PLANTERS> getLoadedPlantsFilterSortRZA2(int offset, int limit, double rating) {
String query = "SELECT * FROM POT_PLANTERS WHERE PP_RATING = ? ORDER BY PTITLE DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<POT_PLANTERS> plist = jdbcTemplate.query(query,new Object[] {rating,limit,offset},
		        (rs, num) -> {
		        	POT_PLANTERS pp24 = new POT_PLANTERS();
			        pp24.setPPID(rs.getString(1));
			        pp24.setPPTITLE(rs.getString(2));
			        pp24.setPPDESCRIPTION(rs.getString(3));
			        pp24.setPPDIMENSION(rs.getString(4));
			        pp24.setPP_RATING(rs.getDouble(5));
			        pp24.setPPPRICE(rs.getString(6));
			        pp24.setPP_STOCK_AVAILABILITY(rs.getInt(7));
			        pp24.setPPIMAGES(rs.getString(8));    
			        return pp24;
		        });
		    return plist;
	}
}
