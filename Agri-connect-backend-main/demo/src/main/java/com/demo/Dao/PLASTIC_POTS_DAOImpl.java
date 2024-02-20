package com.demo.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.Model.PLASTIC_POTS;

@Repository
public class PLASTIC_POTS_DAOImpl implements PLASTIC_POTS_DAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<PLASTIC_POTS> getAllPot_Planters() {
			
		List<PLASTIC_POTS> pplist = jdbcTemplate.query("Select * from PLASTIC_POTS",(rs,num)->{
			PLASTIC_POTS pp = new PLASTIC_POTS();
			pp.setPPOID(rs.getString(1));
			pp.setPPOTITLE(rs.getString(2));
			pp.setPPODESCRIPTION(rs.getString(3));
			pp.setPPODIMENSION(rs.getString(4));
			pp.setPPO_RATING(rs.getDouble(5));
			pp.setPPOPRICE(rs.getString(6));
			pp.setPPO_STOCK_AVAILABILITY(rs.getInt(7));
			pp.setPPOIMAGES(rs.getString(8));	
			pp.setQuantity(rs.getInt(9));
			
			return pp;	
		});
			
		return pplist;
	}

	@Override
	public List<PLASTIC_POTS> getLoadedPp(int offset, int limit) {
	    String query = "SELECT * FROM PLASTIC_POTS LIMIT ? OFFSET ?";
	    
	    @SuppressWarnings("deprecation")
		List<PLASTIC_POTS> pp1list = jdbcTemplate.query(query, new Object[]{limit, offset}, (rs, num) -> {
	        PLASTIC_POTS pp1 = new PLASTIC_POTS();
	        pp1.setPPOID(rs.getString(1));
	        pp1.setPPOTITLE(rs.getString(2));
	        pp1.setPPODESCRIPTION(rs.getString(3));
	        pp1.setPPODIMENSION(rs.getString(4));
	        pp1.setPPO_RATING(rs.getDouble(5));
	        pp1.setPPOPRICE(rs.getString(6));
	        pp1.setPPO_STOCK_AVAILABILITY(rs.getInt(7));
	        pp1.setPPOIMAGES(rs.getString(8));    
	        return pp1;
	    });

	    return pp1list;
	}

	@Override
	public List<PLASTIC_POTS> getAllPotPlanterLoadedByRating(int offset, int limit, double rating) {
        String query = "SELECT * FROM PLASTIC_POTS where PPO_RATING = ? LIMIT ? OFFSET ?";
	    
	    @SuppressWarnings("deprecation")
		List<PLASTIC_POTS> pp2list = jdbcTemplate.query(query, new Object[]{rating ,limit, offset}, (rs, num) -> {
	        PLASTIC_POTS pp2 = new PLASTIC_POTS();
	        pp2.setPPOID(rs.getString(1));
	        pp2.setPPOTITLE(rs.getString(2));
	        pp2.setPPODESCRIPTION(rs.getString(3));
	        pp2.setPPODIMENSION(rs.getString(4));
	        pp2.setPPO_RATING(rs.getDouble(5));
	        pp2.setPPOPRICE(rs.getString(6));
	        pp2.setPPO_STOCK_AVAILABILITY(rs.getInt(7));
	        pp2.setPPOIMAGES(rs.getString(8));    
	        return pp2;
	    });

	    return pp2list;
	}

	@Override
	public List<PLASTIC_POTS> getAllPotPlanterLoadedByPrice(int offset, int limit, double from, double to) {
		String query = "SELECT * FROM PLASTIC_POTS WHERE JSON_EXTRACT(PPOPRICE, '$[0].SP') BETWEEN ? AND ? LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PLASTIC_POTS> pp3list = jdbcTemplate.query(query, new Object[]{from, to ,limit, offset}, (rs, num) -> {
	        PLASTIC_POTS pp3 = new PLASTIC_POTS();
	        pp3.setPPOID(rs.getString(1));
	        pp3.setPPOTITLE(rs.getString(2));
	        pp3.setPPODESCRIPTION(rs.getString(3));
	        pp3.setPPODIMENSION(rs.getString(4));
	        pp3.setPPO_RATING(rs.getDouble(5));
	        pp3.setPPOPRICE(rs.getString(6));
	        pp3.setPPO_STOCK_AVAILABILITY(rs.getInt(7));
	        pp3.setPPOIMAGES(rs.getString(8));    
	        return pp3;
	    });
		
		return pp3list;
	}

	@Override
	public List<PLASTIC_POTS> getAllPotPlanterLoadedByRatingPrice(int offset, int limit, double rating, double from,
			double to) {
		
		String query = "SELECT * FROM PLASTIC_POTS WHERE PPO_RATING = ? AND JSON_EXTRACT(PPOPRICE, '$[0].SP') BETWEEN ? AND ? LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PLASTIC_POTS> pp4list = jdbcTemplate.query(query, new Object[]{rating, from, to ,limit, offset}, (rs, num) -> {
	        PLASTIC_POTS pp4 = new PLASTIC_POTS();
	        pp4.setPPOID(rs.getString(1));
	        pp4.setPPOTITLE(rs.getString(2));
	        pp4.setPPODESCRIPTION(rs.getString(3));
	        pp4.setPPODIMENSION(rs.getString(4));
	        pp4.setPPO_RATING(rs.getDouble(5));
	        pp4.setPPOPRICE(rs.getString(6));
	        pp4.setPPO_STOCK_AVAILABILITY(rs.getInt(7));
	        pp4.setPPOIMAGES(rs.getString(8));    
	        return pp4;
	    });
		return pp4list;
	}

	@Override
	public List<PLASTIC_POTS> getAllPotPlanterLoadedByRatingStock(int offset, int limit, double rating, int stock) {
		String query = "SELECT * FROM PLASTIC_POTS WHERE PPO_RATING = ? AND PPO_STOCK_AVAILABILITY = ? LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PLASTIC_POTS> pp5list = jdbcTemplate.query(query, new Object[]{rating,stock,limit, offset}, (rs, num) -> {
	        PLASTIC_POTS pp5 = new PLASTIC_POTS();
	        pp5.setPPOID(rs.getString(1));
	        pp5.setPPOTITLE(rs.getString(2));
	        pp5.setPPODESCRIPTION(rs.getString(3));
	        pp5.setPPODIMENSION(rs.getString(4));
	        pp5.setPPO_RATING(rs.getDouble(5));
	        pp5.setPPOPRICE(rs.getString(6));
	        pp5.setPPO_STOCK_AVAILABILITY(rs.getInt(7));
	        pp5.setPPOIMAGES(rs.getString(8));    
	        return pp5;
	    });
		return pp5list;
		
	}

	@Override
	public List<PLASTIC_POTS> getAllPotPlanterLoadedByPriceStock(int offset, int limit, double from, double to,
			int stock) {
		String query = "SELECT * FROM PLASTIC_POTS WHERE JSON_EXTRACT(PPOPRICE, '$[0].SP') BETWEEN ? AND ? AND PPO_STOCK_AVAILABILITY = ? LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PLASTIC_POTS> pp6list = jdbcTemplate.query(query, new Object[]{from, to,stock,limit, offset}, (rs, num) -> {
	        PLASTIC_POTS pp6 = new PLASTIC_POTS();
	        pp6.setPPOID(rs.getString(1));
	        pp6.setPPOTITLE(rs.getString(2));
	        pp6.setPPODESCRIPTION(rs.getString(3));
	        pp6.setPPODIMENSION(rs.getString(4));
	        pp6.setPPO_RATING(rs.getDouble(5));
	        pp6.setPPOPRICE(rs.getString(6));
	        pp6.setPPO_STOCK_AVAILABILITY(rs.getInt(7));
	        pp6.setPPOIMAGES(rs.getString(8));    
	        return pp6;
	    });
		return pp6list;
	}

	@Override
	public List<PLASTIC_POTS> getAllPotPlanterLoadedByPriceStockRating(int offset, int limit, double from, double to,
			int stock, double rating) {
		
		String query = "SELECT * FROM PLASTIC_POTS WHERE JSON_EXTRACT(PPOPRICE, '$[0].SP') BETWEEN ? AND ? AND PPO_STOCK_AVAILABILITY = ? AND PPO_RATING = ? LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PLASTIC_POTS> pp7list = jdbcTemplate.query(query, new Object[]{from, to,stock,rating,limit, offset}, (rs, num) -> {
	        PLASTIC_POTS pp7 = new PLASTIC_POTS();
	        pp7.setPPOID(rs.getString(1));
	        pp7.setPPOTITLE(rs.getString(2));
	        pp7.setPPODESCRIPTION(rs.getString(3));
	        pp7.setPPODIMENSION(rs.getString(4));
	        pp7.setPPO_RATING(rs.getDouble(5));
	        pp7.setPPOPRICE(rs.getString(6));
	        pp7.setPPO_STOCK_AVAILABILITY(rs.getInt(7));
	        pp7.setPPOIMAGES(rs.getString(8));    
	        return pp7;
	    });
		return pp7list;
		
	}

	@Override
	public List<PLASTIC_POTS> getAllPotPlanterLoadedByRatingPriceSORTTITLE_A_Z(int offset, int limit, double rating,
			double from, double to) {
		String query = "SELECT * FROM PLASTIC_POTS WHERE PPO_RATING = ? AND JSON_EXTRACT(PPOPRICE, '$[0].SP') BETWEEN ? AND ? Order by PPOTITLE LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PLASTIC_POTS> pp8list = jdbcTemplate.query(query, new Object[]{rating, from, to ,limit, offset}, (rs, num) -> {
	        PLASTIC_POTS pp8 = new PLASTIC_POTS();
	        pp8.setPPOID(rs.getString(1));
	        pp8.setPPOTITLE(rs.getString(2));
	        pp8.setPPODESCRIPTION(rs.getString(3));
	        pp8.setPPODIMENSION(rs.getString(4));
	        pp8.setPPO_RATING(rs.getDouble(5));
	        pp8.setPPOPRICE(rs.getString(6));
	        pp8.setPPO_STOCK_AVAILABILITY(rs.getInt(7));
	        pp8.setPPOIMAGES(rs.getString(8));    
	        return pp8;
	    });
		return pp8list;
	}

	@Override
	public List<PLASTIC_POTS> getAllPotPlanterLoadedByRatingPriceSORTTITLE_Z_A(int offset, int limit, double rating,
			double from, double to) {
		String query = "SELECT * FROM PLASTIC_POTS WHERE PPO_RATING = ? AND JSON_EXTRACT(PPOPRICE, '$[0].SP') BETWEEN ? AND ? Order by PPOTITLE DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PLASTIC_POTS> pp9list = jdbcTemplate.query(query, new Object[]{rating, from, to ,limit, offset}, (rs, num) -> {
	        PLASTIC_POTS pp9 = new PLASTIC_POTS();
	        pp9.setPPOID(rs.getString(1));
	        pp9.setPPOTITLE(rs.getString(2));
	        pp9.setPPODESCRIPTION(rs.getString(3));
	        pp9.setPPODIMENSION(rs.getString(4));
	        pp9.setPPO_RATING(rs.getDouble(5));
	        pp9.setPPOPRICE(rs.getString(6));
	        pp9.setPPO_STOCK_AVAILABILITY(rs.getInt(7));
	        pp9.setPPOIMAGES(rs.getString(8));    
	        return pp9;
	    });
		return pp9list;
	}
	
	

	@Override
	public List<PLASTIC_POTS> getAllPotPlanterLoadedByRatingPriceSORTPRICE_L_H(int offset, int limit, double rating,
			double from, double to) {
		String query = "SELECT * FROM PLASTIC_POTS WHERE PPO_RATING = ? AND JSON_EXTRACT(PPOPRICE, '$[0].SP') BETWEEN ? AND ?  order by CAST(JSON_EXTRACT(PPOPRICE, '$[0].SP') AS UNSIGNED) LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PLASTIC_POTS> pp10list = jdbcTemplate.query(query, new Object[]{rating, from, to ,limit, offset}, (rs, num) -> {
	        PLASTIC_POTS pp10 = new PLASTIC_POTS();
	        pp10.setPPOID(rs.getString(1));
	        pp10.setPPOTITLE(rs.getString(2));
	        pp10.setPPODESCRIPTION(rs.getString(3));
	        pp10.setPPODIMENSION(rs.getString(4));
	        pp10.setPPO_RATING(rs.getDouble(5));
	        pp10.setPPOPRICE(rs.getString(6));
	        pp10.setPPO_STOCK_AVAILABILITY(rs.getInt(7));
	        pp10.setPPOIMAGES(rs.getString(8));    
	        return pp10;
	    });
		return pp10list;
	}

	@Override
	public List<PLASTIC_POTS> getAllPotPlanterLoadedByRatingPriceSORTPRICE_H_L(int offset, int limit, double rating,
			double from, double to) {
String query = "SELECT * FROM PLASTIC_POTS WHERE PPO_RATING = ? AND JSON_EXTRACT(PPOPRICE, '$[0].SP') BETWEEN ? AND ?  order by CAST(JSON_EXTRACT(PPOPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PLASTIC_POTS> pp11list = jdbcTemplate.query(query, new Object[]{rating, from, to ,limit, offset}, (rs, num) -> {
	        PLASTIC_POTS pp11 = new PLASTIC_POTS();
	        pp11.setPPOID(rs.getString(1));
	        pp11.setPPOTITLE(rs.getString(2));
	        pp11.setPPODESCRIPTION(rs.getString(3));
	        pp11.setPPODIMENSION(rs.getString(4));
	        pp11.setPPO_RATING(rs.getDouble(5));
	        pp11.setPPOPRICE(rs.getString(6));
	        pp11.setPPO_STOCK_AVAILABILITY(rs.getInt(7));
	        pp11.setPPOIMAGES(rs.getString(8));    
	        return pp11;
	    });
		return pp11list;
	}

	@Override
	public List<PLASTIC_POTS> getAllPotPlanterLoadedByRatingStockSORTTITLE_A_Z(int offset, int limit, double rating,
			int stock) {
		String query = "SELECT * FROM PLASTIC_POTS WHERE PPO_RATING = ? AND PPO_STOCK_AVAILABILITY = ? Order by PPOTITLE LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PLASTIC_POTS> pp12list = jdbcTemplate.query(query, new Object[]{rating,stock,limit, offset}, (rs, num) -> {
	        PLASTIC_POTS pp12 = new PLASTIC_POTS();
	        pp12.setPPOID(rs.getString(1));
	        pp12.setPPOTITLE(rs.getString(2));
	        pp12.setPPODESCRIPTION(rs.getString(3));
	        pp12.setPPODIMENSION(rs.getString(4));
	        pp12.setPPO_RATING(rs.getDouble(5));
	        pp12.setPPOPRICE(rs.getString(6));
	        pp12.setPPO_STOCK_AVAILABILITY(rs.getInt(7));
	        pp12.setPPOIMAGES(rs.getString(8));    
	        return pp12;
	    });
		return pp12list;
	}

	@Override
	public List<PLASTIC_POTS> getAllPotPlanterLoadedByRatingStockSORTTITLE_Z_A(int offset, int limit, double rating,
			int stock) {
		String query = "SELECT * FROM PLASTIC_POTS WHERE PPO_RATING = ? AND PPO_STOCK_AVAILABILITY = ? Order by PPOTITLE DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PLASTIC_POTS> pp13list = jdbcTemplate.query(query, new Object[]{rating,stock,limit, offset}, (rs, num) -> {
	        PLASTIC_POTS pp13 = new PLASTIC_POTS();
	        pp13.setPPOID(rs.getString(1));
	        pp13.setPPOTITLE(rs.getString(2));
	        pp13.setPPODESCRIPTION(rs.getString(3));
	        pp13.setPPODIMENSION(rs.getString(4));
	        pp13.setPPO_RATING(rs.getDouble(5));
	        pp13.setPPOPRICE(rs.getString(6));
	        pp13.setPPO_STOCK_AVAILABILITY(rs.getInt(7));
	        pp13.setPPOIMAGES(rs.getString(8));    
	        return pp13;
	    });
		return pp13list;
		
	}

	@Override
	public List<PLASTIC_POTS> getAllPotPlanterLoadedByRatingStockSORTPRICE_L_H(int offset, int limit, double rating,
			int stock) {
		String query = "SELECT * FROM PLASTIC_POTS WHERE PPO_RATING = ? AND PPO_STOCK_AVAILABILITY = ?  order by CAST(JSON_EXTRACT(PPOPRICE, '$[0].SP') AS UNSIGNED) LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PLASTIC_POTS> pp14list = jdbcTemplate.query(query, new Object[]{rating,stock,limit, offset}, (rs, num) -> {
	        PLASTIC_POTS pp14 = new PLASTIC_POTS();
	        pp14.setPPOID(rs.getString(1));
	        pp14.setPPOTITLE(rs.getString(2));
	        pp14.setPPODESCRIPTION(rs.getString(3));
	        pp14.setPPODIMENSION(rs.getString(4));
	        pp14.setPPO_RATING(rs.getDouble(5));
	        pp14.setPPOPRICE(rs.getString(6));
	        pp14.setPPO_STOCK_AVAILABILITY(rs.getInt(7));
	        pp14.setPPOIMAGES(rs.getString(8));    
	        return pp14;
	    });
		return pp14list;
	}

	@Override
	public List<PLASTIC_POTS> getAllPotPlanterLoadedByRatingStockSORTPRICE_H_L(int offset, int limit, double rating,
			int stock) {
String query = "SELECT * FROM PLASTIC_POTS WHERE PPO_RATING = ? AND PPO_STOCK_AVAILABILITY = ?  order by CAST(JSON_EXTRACT(PPOPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PLASTIC_POTS> pp15list = jdbcTemplate.query(query, new Object[]{rating,stock,limit, offset}, (rs, num) -> {
	        PLASTIC_POTS pp15 = new PLASTIC_POTS();
	        pp15.setPPOID(rs.getString(1));
	        pp15.setPPOTITLE(rs.getString(2));
	        pp15.setPPODESCRIPTION(rs.getString(3));
	        pp15.setPPODIMENSION(rs.getString(4));
	        pp15.setPPO_RATING(rs.getDouble(5));
	        pp15.setPPOPRICE(rs.getString(6));
	        pp15.setPPO_STOCK_AVAILABILITY(rs.getInt(7));
	        pp15.setPPOIMAGES(rs.getString(8));    
	        return pp15;
	    });
		return pp15list;
	}

	@Override
	public List<PLASTIC_POTS> getAllPotPlanterLoadedByPriceStockSORTTITLE_A_Z(int offset, int limit, double from,
			double to, int stock) {
		String query = "SELECT * FROM PLASTIC_POTS WHERE JSON_EXTRACT(PPOPRICE, '$[0].SP') BETWEEN ? AND ? AND PPO_STOCK_AVAILABILITY = ? ORDER BY PPOTITLE LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PLASTIC_POTS> pp16list = jdbcTemplate.query(query, new Object[]{from, to,stock,limit, offset}, (rs, num) -> {
	        PLASTIC_POTS pp16 = new PLASTIC_POTS();
	        pp16.setPPOID(rs.getString(1));
	        pp16.setPPOTITLE(rs.getString(2));
	        pp16.setPPODESCRIPTION(rs.getString(3));
	        pp16.setPPODIMENSION(rs.getString(4));
	        pp16.setPPO_RATING(rs.getDouble(5));
	        pp16.setPPOPRICE(rs.getString(6));
	        pp16.setPPO_STOCK_AVAILABILITY(rs.getInt(7));
	        pp16.setPPOIMAGES(rs.getString(8));    
	        return pp16;
	    });
		return pp16list;
		
	}

	@Override
	public List<PLASTIC_POTS> getAllPotPlanterLoadedByPriceStockSORTTITLE_Z_A(int offset, int limit, double from,
			double to, int stock) {
		String query = "SELECT * FROM PLASTIC_POTS WHERE JSON_EXTRACT(PPOPRICE, '$[0].SP') BETWEEN ? AND ? AND PPO_STOCK_AVAILABILITY = ? ORDER BY PPOTITLE DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PLASTIC_POTS> pp17list = jdbcTemplate.query(query, new Object[]{from, to,stock,limit, offset}, (rs, num) -> {
	        PLASTIC_POTS pp17 = new PLASTIC_POTS();
	        pp17.setPPOID(rs.getString(1));
	        pp17.setPPOTITLE(rs.getString(2));
	        pp17.setPPODESCRIPTION(rs.getString(3));
	        pp17.setPPODIMENSION(rs.getString(4));
	        pp17.setPPO_RATING(rs.getDouble(5));
	        pp17.setPPOPRICE(rs.getString(6));
	        pp17.setPPO_STOCK_AVAILABILITY(rs.getInt(7));
	        pp17.setPPOIMAGES(rs.getString(8));    
	        return pp17;
	    });
		return pp17list;
	}

	@Override
	public List<PLASTIC_POTS> getAllPotPlanterLoadedByPriceStockSORTPRICE_L_H(int offset, int limit, double from,
			double to, int stock) {
		String query = "SELECT * FROM PLASTIC_POTS WHERE JSON_EXTRACT(PPOPRICE, '$[0].SP') BETWEEN ? AND ? AND PPO_STOCK_AVAILABILITY = ?  order by CAST(JSON_EXTRACT(PPOPRICE, '$[0].SP') AS UNSIGNED) LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PLASTIC_POTS> pp18list = jdbcTemplate.query(query, new Object[]{from, to,stock,limit, offset}, (rs, num) -> {
	        PLASTIC_POTS pp18 = new PLASTIC_POTS();
	        pp18.setPPOID(rs.getString(1));
	        pp18.setPPOTITLE(rs.getString(2));
	        pp18.setPPODESCRIPTION(rs.getString(3));
	        pp18.setPPODIMENSION(rs.getString(4));
	        pp18.setPPO_RATING(rs.getDouble(5));
	        pp18.setPPOPRICE(rs.getString(6));
	        pp18.setPPO_STOCK_AVAILABILITY(rs.getInt(7));
	        pp18.setPPOIMAGES(rs.getString(8));    
	        return pp18;
	    });
		return pp18list;
	}

	@Override
	public List<PLASTIC_POTS> getAllPotPlanterLoadedByPriceStockSORTPRICE_H_L(int offset, int limit, double from,
			double to, int stock) {
		String query = "SELECT * FROM PLASTIC_POTS WHERE JSON_EXTRACT(PPOPRICE, '$[0].SP') BETWEEN ? AND ? AND PPO_STOCK_AVAILABILITY = ?  order by CAST(JSON_EXTRACT(PPOPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PLASTIC_POTS> pp19list = jdbcTemplate.query(query, new Object[]{from, to,stock,limit, offset}, (rs, num) -> {
	        PLASTIC_POTS pp19 = new PLASTIC_POTS();
	        pp19.setPPOID(rs.getString(1));
	        pp19.setPPOTITLE(rs.getString(2));
	        pp19.setPPODESCRIPTION(rs.getString(3));
	        pp19.setPPODIMENSION(rs.getString(4));
	        pp19.setPPO_RATING(rs.getDouble(5));
	        pp19.setPPOPRICE(rs.getString(6));
	        pp19.setPPO_STOCK_AVAILABILITY(rs.getInt(7));
	        pp19.setPPOIMAGES(rs.getString(8));    
	        return pp19;
	    });
		return pp19list;
	}

	@Override
	public List<PLASTIC_POTS> getAllPotPlanterLoadedByPriceStockRatingSORTTITLE_A_Z(int offset, int limit, double from,
			double to, int stock, double rating) {
		String query = "SELECT * FROM PLASTIC_POTS WHERE JSON_EXTRACT(PPOPRICE, '$[0].SP') BETWEEN ? AND ? AND PPO_STOCK_AVAILABILITY = ? AND PPO_RATING = ? ORDER BY PPOTITLE LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PLASTIC_POTS> pp20list = jdbcTemplate.query(query, new Object[]{from, to,stock,rating,limit, offset}, (rs, num) -> {
	        PLASTIC_POTS pp20 = new PLASTIC_POTS();
	        pp20.setPPOID(rs.getString(1));
	        pp20.setPPOTITLE(rs.getString(2));
	        pp20.setPPODESCRIPTION(rs.getString(3));
	        pp20.setPPODIMENSION(rs.getString(4));
	        pp20.setPPO_RATING(rs.getDouble(5));
	        pp20.setPPOPRICE(rs.getString(6));
	        pp20.setPPO_STOCK_AVAILABILITY(rs.getInt(7));
	        pp20.setPPOIMAGES(rs.getString(8));    
	        return pp20;
	    });
		return pp20list;
	}

	@Override
	public List<PLASTIC_POTS> getAllPotPlanterLoadedByPriceStockRatingSORTTITLE_Z_A(int offset, int limit, double from,
			double to, int stock, double rating) {
		String query = "SELECT * FROM PLASTIC_POTS WHERE JSON_EXTRACT(PPOPRICE, '$[0].SP') BETWEEN ? AND ? AND PPO_STOCK_AVAILABILITY = ? AND PPO_RATING = ? ORDER BY PPOTITLE DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PLASTIC_POTS> pp21list = jdbcTemplate.query(query, new Object[]{from, to,stock,rating,limit, offset}, (rs, num) -> {
	        PLASTIC_POTS pp21 = new PLASTIC_POTS();
	        pp21.setPPOID(rs.getString(1));
	        pp21.setPPOTITLE(rs.getString(2));
	        pp21.setPPODESCRIPTION(rs.getString(3));
	        pp21.setPPODIMENSION(rs.getString(4));
	        pp21.setPPO_RATING(rs.getDouble(5));
	        pp21.setPPOPRICE(rs.getString(6));
	        pp21.setPPO_STOCK_AVAILABILITY(rs.getInt(7));
	        pp21.setPPOIMAGES(rs.getString(8));    
	        return pp21;
	    });
		return pp21list;
	}

	@Override
	public List<PLASTIC_POTS> getAllPotPlanterLoadedByPriceStockRatingSORTPRICE_L_H(int offset, int limit, double from,
			double to, int stock, double rating) {
		String query = "SELECT * FROM PLASTIC_POTS WHERE JSON_EXTRACT(PPOPRICE, '$[0].SP') BETWEEN ? AND ? AND PPO_STOCK_AVAILABILITY = ? AND PPO_RATING = ?  order by CAST(JSON_EXTRACT(PPOPRICE, '$[0].SP') AS UNSIGNED) LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PLASTIC_POTS> pp22list = jdbcTemplate.query(query, new Object[]{from, to,stock,rating,limit, offset}, (rs, num) -> {
	        PLASTIC_POTS pp22 = new PLASTIC_POTS();
	        pp22.setPPOID(rs.getString(1));
	        pp22.setPPOTITLE(rs.getString(2));
	        pp22.setPPODESCRIPTION(rs.getString(3));
	        pp22.setPPODIMENSION(rs.getString(4));
	        pp22.setPPO_RATING(rs.getDouble(5));
	        pp22.setPPOPRICE(rs.getString(6));
	        pp22.setPPO_STOCK_AVAILABILITY(rs.getInt(7));
	        pp22.setPPOIMAGES(rs.getString(8));    
	        return pp22;
	    });
		return pp22list;
	}

	@Override
	public List<PLASTIC_POTS> getAllPotPlanterLoadedByPriceStockRatingSORTPRICE_H_L(int offset, int limit, double from,
			double to, int stock, double rating) {
		String query = "SELECT * FROM PLASTIC_POTS WHERE JSON_EXTRACT(PPOPRICE, '$[0].SP') BETWEEN ? AND ? AND PPO_STOCK_AVAILABILITY = ? AND PPO_RATING = ?  order by CAST(JSON_EXTRACT(PPOPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PLASTIC_POTS> pp23list = jdbcTemplate.query(query, new Object[]{from, to,stock,rating,limit, offset}, (rs, num) -> {
	        PLASTIC_POTS pp23 = new PLASTIC_POTS();
	        pp23.setPPOID(rs.getString(1));
	        pp23.setPPOTITLE(rs.getString(2));
	        pp23.setPPODESCRIPTION(rs.getString(3));
	        pp23.setPPODIMENSION(rs.getString(4));
	        pp23.setPPO_RATING(rs.getDouble(5));
	        pp23.setPPOPRICE(rs.getString(6));
	        pp23.setPPO_STOCK_AVAILABILITY(rs.getInt(7));
	        pp23.setPPOIMAGES(rs.getString(8));    
	        return pp23;
	    });
		return pp23list;
	}

	@SuppressWarnings("deprecation")
	@Override
	public PLASTIC_POTS findById(String pfid) {
		String query = "select * from PLASTIC_POTS where PPOID=?";
		PLASTIC_POTS pp = new PLASTIC_POTS();
		try {
		    return jdbcTemplate.queryForObject(query,new Object[] {pfid},BeanPropertyRowMapper.newInstance(PLASTIC_POTS.class));
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<PLASTIC_POTS> Availability(int offset, int limit) {
		String query = "select * from PLASTIC_POTS where PPO_STOCK_AVAILABILITY=1 limit ? offset ?";
		@SuppressWarnings("deprecation")
		List<PLASTIC_POTS> availablelist = jdbcTemplate.query(query,new Object[] {limit,offset}, (rs,num)->{
			PLASTIC_POTS pp24 = new PLASTIC_POTS();
	        pp24.setPPOID(rs.getString(1));
	        pp24.setPPOTITLE(rs.getString(2));
	        pp24.setPPODESCRIPTION(rs.getString(3));
	        pp24.setPPODIMENSION(rs.getString(4));
	        pp24.setPPO_RATING(rs.getDouble(5));
	        pp24.setPPOPRICE(rs.getString(6));
	        pp24.setPPO_STOCK_AVAILABILITY(rs.getInt(7));
	        pp24.setPPOIMAGES(rs.getString(8));    
	        return pp24;
		});
		
		return availablelist;
	}
	

	@Override
	public List<PLASTIC_POTS> sortZ_A(int offset, int limit) {
		String query = "select * from PLASTIC_POTS order by PPOTITLE desc limit ? offset ?";
		@SuppressWarnings("deprecation")
		List<PLASTIC_POTS> sortlist = jdbcTemplate.query(query,new Object[] {limit,offset}, (rs,num)->{
			PLASTIC_POTS pp24 = new PLASTIC_POTS();
	        pp24.setPPOID(rs.getString(1));
	        pp24.setPPOTITLE(rs.getString(2));
	        pp24.setPPODESCRIPTION(rs.getString(3));
	        pp24.setPPODIMENSION(rs.getString(4));
	        pp24.setPPO_RATING(rs.getDouble(5));
	        pp24.setPPOPRICE(rs.getString(6));
	        pp24.setPPO_STOCK_AVAILABILITY(rs.getInt(7));
	        pp24.setPPOIMAGES(rs.getString(8));    
	        return pp24;
		});
		
		return sortlist;
	}
	
	@Override
	public List<PLASTIC_POTS> Avail_A_Z(int offset, int limit) {
		String query = "select * from PLASTIC_POTS where PPO_STOCK_AVAILABILITY=1 order by PPTitle limit ? offset ?";
		@SuppressWarnings("deprecation")
		List<PLASTIC_POTS> availablelist_A_Z = jdbcTemplate.query(query,new Object[] {limit,offset}, (rs,num)->{
			PLASTIC_POTS pp24 = new PLASTIC_POTS();
	        pp24.setPPOID(rs.getString(1));
	        pp24.setPPOTITLE(rs.getString(2));
	        pp24.setPPODESCRIPTION(rs.getString(3));
	        pp24.setPPODIMENSION(rs.getString(4));
	        pp24.setPPO_RATING(rs.getDouble(5));
	        pp24.setPPOPRICE(rs.getString(6));
	        pp24.setPPO_STOCK_AVAILABILITY(rs.getInt(7));
	        pp24.setPPOIMAGES(rs.getString(8));    
	        return pp24;
		});
		
		return availablelist_A_Z;
	}

	@Override
	public List<PLASTIC_POTS> Avail_Z_A(int offset, int limit) {
		String query = "select * from PLASTIC_POTS where PPO_STOCK_AVAILABILITY=1 order by PPTitle desc limit ? offset ?";
		@SuppressWarnings("deprecation")
		List<PLASTIC_POTS> availablelist_Z_A = jdbcTemplate.query(query,new Object[] {limit,offset}, (rs,num)->{
			PLASTIC_POTS pp24 = new PLASTIC_POTS();
	        pp24.setPPOID(rs.getString(1));
	        pp24.setPPOTITLE(rs.getString(2));
	        pp24.setPPODESCRIPTION(rs.getString(3));
	        pp24.setPPODIMENSION(rs.getString(4));
	        pp24.setPPO_RATING(rs.getDouble(5));
	        pp24.setPPOPRICE(rs.getString(6));
	        pp24.setPPO_STOCK_AVAILABILITY(rs.getInt(7));
	        pp24.setPPOIMAGES(rs.getString(8));    
	        return pp24;
		});
		
		return availablelist_Z_A;
	}

	@Override
	public List<PLASTIC_POTS> getPlantsByPriceLH(int offset, int limit) {
String query = "SELECT * FROM PLASTIC_POTS where PPO_STOCK_AVAILABILITY=1 ORDER BY CAST(JSON_EXTRACT(PPOPRICE, '$[0].SP') AS UNSIGNED) ASC LIMIT ? OFFSET ?";
		
	    @SuppressWarnings("deprecation")
		List<PLASTIC_POTS> plist = jdbcTemplate.query(query,new Object[] {limit,offset},
	        (rs, num) -> {
	        	PLASTIC_POTS pp24 = new PLASTIC_POTS();
		        pp24.setPPOID(rs.getString(1));
		        pp24.setPPOTITLE(rs.getString(2));
		        pp24.setPPODESCRIPTION(rs.getString(3));
		        pp24.setPPODIMENSION(rs.getString(4));
		        pp24.setPPO_RATING(rs.getDouble(5));
		        pp24.setPPOPRICE(rs.getString(6));
		        pp24.setPPO_STOCK_AVAILABILITY(rs.getInt(7));
		        pp24.setPPOIMAGES(rs.getString(8));    
		        return pp24;
	        });
	    return plist;
	}

	@Override
	public List<PLASTIC_POTS> getPlantsByPriceHL(int offset, int limit) {
String query = "SELECT * FROM PLASTIC_POTS where PPO_STOCK_AVAILABILITY=1 ORDER BY CAST(JSON_EXTRACT(PPOPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
		
	    @SuppressWarnings("deprecation")
		List<PLASTIC_POTS> plist = jdbcTemplate.query(query,new Object[] {limit,offset},
	        (rs, num) -> {
	        	PLASTIC_POTS pp24 = new PLASTIC_POTS();
		        pp24.setPPOID(rs.getString(1));
		        pp24.setPPOTITLE(rs.getString(2));
		        pp24.setPPODESCRIPTION(rs.getString(3));
		        pp24.setPPODIMENSION(rs.getString(4));
		        pp24.setPPO_RATING(rs.getDouble(5));
		        pp24.setPPOPRICE(rs.getString(6));
		        pp24.setPPO_STOCK_AVAILABILITY(rs.getInt(7));
		        pp24.setPPOIMAGES(rs.getString(8));    
		        return pp24;
	        });
	    return plist;
	}

	@Override
	public List<PLASTIC_POTS> sortA_Z(int offset, int limit) {
		String query = "select * from PLASTIC_POTS order by PPOTITLE limit ? offset ?";
		@SuppressWarnings("deprecation")
		List<PLASTIC_POTS> sortlist = jdbcTemplate.query(query,new Object[] {limit,offset}, (rs,num)->{
			PLASTIC_POTS pp24 = new PLASTIC_POTS();
	        pp24.setPPOID(rs.getString(1));
	        pp24.setPPOTITLE(rs.getString(2));
	        pp24.setPPODESCRIPTION(rs.getString(3));
	        pp24.setPPODIMENSION(rs.getString(4));
	        pp24.setPPO_RATING(rs.getDouble(5));
	        pp24.setPPOPRICE(rs.getString(6));
	        pp24.setPPO_STOCK_AVAILABILITY(rs.getInt(7));
	        pp24.setPPOIMAGES(rs.getString(8));    
	        return pp24;
		});
		
		return sortlist;
	}

	@Override
	public List<PLASTIC_POTS> SORTBYPRICE_L_H(int offset, int limit) {
		String query = "SELECT * FROM PLASTIC_POTS order by CAST(JSON_EXTRACT(PPOPRICE, '$[0].SP') AS UNSIGNED) ASC LIMIT ? OFFSET ?";
		
	    @SuppressWarnings("deprecation")
		List<PLASTIC_POTS> plist = jdbcTemplate.query(query,new Object[] {limit,offset},
	        (rs, num) -> {
	        	PLASTIC_POTS pp24 = new PLASTIC_POTS();
		        pp24.setPPOID(rs.getString(1));
		        pp24.setPPOTITLE(rs.getString(2));
		        pp24.setPPODESCRIPTION(rs.getString(3));
		        pp24.setPPODIMENSION(rs.getString(4));
		        pp24.setPPO_RATING(rs.getDouble(5));
		        pp24.setPPOPRICE(rs.getString(6));
		        pp24.setPPO_STOCK_AVAILABILITY(rs.getInt(7));
		        pp24.setPPOIMAGES(rs.getString(8));    
		        return pp24;
	        });
	    return plist;	
	    }

	

	@Override
	public List<PLASTIC_POTS> SORTBYPRICE_H_L(int offset, int limit) {
		String query = "SELECT * FROM PLASTIC_POTS order by CAST(JSON_EXTRACT(PPOPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
		
	    @SuppressWarnings("deprecation")
		List<PLASTIC_POTS> plist = jdbcTemplate.query(query,new Object[] {limit,offset},
	        (rs, num) -> {
	        	PLASTIC_POTS pp24 = new PLASTIC_POTS();
		        pp24.setPPOID(rs.getString(1));
		        pp24.setPPOTITLE(rs.getString(2));
		        pp24.setPPODESCRIPTION(rs.getString(3));
		        pp24.setPPODIMENSION(rs.getString(4));
		        pp24.setPPO_RATING(rs.getDouble(5));
		        pp24.setPPOPRICE(rs.getString(6));
		        pp24.setPPO_STOCK_AVAILABILITY(rs.getInt(7));
		        pp24.setPPOIMAGES(rs.getString(8));    
		        return pp24;
	        });
	    return plist;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public List<PLASTIC_POTS> getLoadedPlantsFilterSortPHL1(int offset, int limit, double from, double to) {
		String query="SELECT * FROM PLASTIC_POTS WHERE JSON_EXTRACT(PPOPRICE, '$[0].SP') BETWEEN ? AND ? ORDER BY cast(JSON_EXTRACT(PPOPRICE, '$[0].SP') as unsigned) DESC LIMIT ? OFFSET ?";
		List<PLASTIC_POTS> plist = jdbcTemplate.query(query,new Object[] {from,to,limit,offset},
		        (rs, num) -> {
		        	PLASTIC_POTS pp24 = new PLASTIC_POTS();
			        pp24.setPPOID(rs.getString(1));
			        pp24.setPPOTITLE(rs.getString(2));
			        pp24.setPPODESCRIPTION(rs.getString(3));
			        pp24.setPPODIMENSION(rs.getString(4));
			        pp24.setPPO_RATING(rs.getDouble(5));
			        pp24.setPPOPRICE(rs.getString(6));
			        pp24.setPPO_STOCK_AVAILABILITY(rs.getInt(7));
			        pp24.setPPOIMAGES(rs.getString(8));    
			        return pp24;
		        });
		    return plist;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<PLASTIC_POTS> getLoadedPlantsFilterSortPLH1(int offset, int limit, double from, double to) {
		String query="SELECT * FROM PLASTIC_POTS WHERE JSON_EXTRACT(PPOPRICE, '$[0].SP') BETWEEN ? AND ? ORDER BY cast(JSON_EXTRACT(PPOPRICE, '$[0].SP') as unsigned) ASC LIMIT ? OFFSET ?";
		List<PLASTIC_POTS> plist = jdbcTemplate.query(query,new Object[] {from,to,limit,offset},
		        (rs, num) -> {
		        	PLASTIC_POTS pp24 = new PLASTIC_POTS();
			        pp24.setPPOID(rs.getString(1));
			        pp24.setPPOTITLE(rs.getString(2));
			        pp24.setPPODESCRIPTION(rs.getString(3));
			        pp24.setPPODIMENSION(rs.getString(4));
			        pp24.setPPO_RATING(rs.getDouble(5));
			        pp24.setPPOPRICE(rs.getString(6));
			        pp24.setPPO_STOCK_AVAILABILITY(rs.getInt(7));
			        pp24.setPPOIMAGES(rs.getString(8));    
			        return pp24;
		        });
		    return plist;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<PLASTIC_POTS> getLoadedPlantFilterSortAZ1(int offset, int limit, double from, double to) {
		String query ="SELECT * FROM PLASTIC_POTS WHERE JSON_EXTRACT(PPOPRICE, '$[0].SP') BETWEEN ? AND ? ORDER BY PPOTITLE ASC LIMIT ? OFFSET ? ";
		List<PLASTIC_POTS> plist = jdbcTemplate.query(query,new Object[] {from,to,limit,offset},
		        (rs, num) -> {
		        	PLASTIC_POTS pp24 = new PLASTIC_POTS();
			        pp24.setPPOID(rs.getString(1));
			        pp24.setPPOTITLE(rs.getString(2));
			        pp24.setPPODESCRIPTION(rs.getString(3));
			        pp24.setPPODIMENSION(rs.getString(4));
			        pp24.setPPO_RATING(rs.getDouble(5));
			        pp24.setPPOPRICE(rs.getString(6));
			        pp24.setPPO_STOCK_AVAILABILITY(rs.getInt(7));
			        pp24.setPPOIMAGES(rs.getString(8));    
			        return pp24;
		        });
		    return plist;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<PLASTIC_POTS> getLoadedPlantFilterSortZA1(int offset, int limit, double from, double to) {
		String query ="SELECT * FROM PLASTIC_POTS WHERE JSON_EXTRACT(PPOPRICE, '$[0].SP') BETWEEN ? AND ? ORDER BY PPOTITLE DESC LIMIT ? OFFSET ? ";
		List<PLASTIC_POTS> plist = jdbcTemplate.query(query,new Object[] {from,to,limit,offset},
		        (rs, num) -> {
		        	PLASTIC_POTS pp24 = new PLASTIC_POTS();
			        pp24.setPPOID(rs.getString(1));
			        pp24.setPPOTITLE(rs.getString(2));
			        pp24.setPPODESCRIPTION(rs.getString(3));
			        pp24.setPPODIMENSION(rs.getString(4));
			        pp24.setPPO_RATING(rs.getDouble(5));
			        pp24.setPPOPRICE(rs.getString(6));
			        pp24.setPPO_STOCK_AVAILABILITY(rs.getInt(7));
			        pp24.setPPOIMAGES(rs.getString(8));    
			        return pp24;
		        });
		    return plist;
	}
	
	
	@SuppressWarnings("deprecation")
	@Override
	public List<PLASTIC_POTS> getLoadedPlantsFilterSortRHL2(int offset, int limit, double rating) {
		String query ="SELECT * FROM PLASTIC_POTS WHERE PPO_RATING = ? ORDER BY cast(JSON_EXTRACT(PPOPRICE, '$[0].SP') as unsigned) DESC LIMIT ? OFFSET ? ";
		List<PLASTIC_POTS> plist = jdbcTemplate.query(query,new Object[] {rating,limit,offset},
		        (rs, num) -> {
		        	PLASTIC_POTS pp24 = new PLASTIC_POTS();
			        pp24.setPPOID(rs.getString(1));
			        pp24.setPPOTITLE(rs.getString(2));
			        pp24.setPPODESCRIPTION(rs.getString(3));
			        pp24.setPPODIMENSION(rs.getString(4));
			        pp24.setPPO_RATING(rs.getDouble(5));
			        pp24.setPPOPRICE(rs.getString(6));
			        pp24.setPPO_STOCK_AVAILABILITY(rs.getInt(7));
			        pp24.setPPOIMAGES(rs.getString(8));    
			        return pp24;
		        });
		    return plist;
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<PLASTIC_POTS> getLoadedPlantsFilterSortRLH2(int offset, int limit, double rating) {
		String query ="SELECT * FROM PLASTIC_POTS WHERE PPO_RATING = ? ORDER BY ORDER BY cast(JSON_EXTRACT(PPOPRICE, '$[0].SP') as unsigned) ASC LIMIT ? OFFSET ? ";
		List<PLASTIC_POTS> plist = jdbcTemplate.query(query,new Object[] {rating,limit,offset},
		        (rs, num) -> {
		        	PLASTIC_POTS pp24 = new PLASTIC_POTS();
			        pp24.setPPOID(rs.getString(1));
			        pp24.setPPOTITLE(rs.getString(2));
			        pp24.setPPODESCRIPTION(rs.getString(3));
			        pp24.setPPODIMENSION(rs.getString(4));
			        pp24.setPPO_RATING(rs.getDouble(5));
			        pp24.setPPOPRICE(rs.getString(6));
			        pp24.setPPO_STOCK_AVAILABILITY(rs.getInt(7));
			        pp24.setPPOIMAGES(rs.getString(8));    
			        return pp24;
		        });
		    return plist;
	}

	@Override
	public List<PLASTIC_POTS> getLoadedPlantsFilterSortRAZ2(int offset, int limit, double rating) {
		String query = "SELECT * FROM PLASTIC_POTS WHERE PPO_RATING = ? ORDER BY PPOTITLE ASC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PLASTIC_POTS> plist = jdbcTemplate.query(query,new Object[] {rating,limit,offset},
		        (rs, num) -> {
		        	PLASTIC_POTS pp24 = new PLASTIC_POTS();
			        pp24.setPPOID(rs.getString(1));
			        pp24.setPPOTITLE(rs.getString(2));
			        pp24.setPPODESCRIPTION(rs.getString(3));
			        pp24.setPPODIMENSION(rs.getString(4));
			        pp24.setPPO_RATING(rs.getDouble(5));
			        pp24.setPPOPRICE(rs.getString(6));
			        pp24.setPPO_STOCK_AVAILABILITY(rs.getInt(7));
			        pp24.setPPOIMAGES(rs.getString(8));    
			        return pp24;
		        });
		    return plist;
	}

	@Override
	public List<PLASTIC_POTS> getLoadedPlantsFilterSortRZA2(int offset, int limit, double rating) {
String query = "SELECT * FROM PLASTIC_POTS WHERE PPO_RATING = ? ORDER BY PTITLE DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PLASTIC_POTS> plist = jdbcTemplate.query(query,new Object[] {rating,limit,offset},
		        (rs, num) -> {
		        	PLASTIC_POTS pp24 = new PLASTIC_POTS();
			        pp24.setPPOID(rs.getString(1));
			        pp24.setPPOTITLE(rs.getString(2));
			        pp24.setPPODESCRIPTION(rs.getString(3));
			        pp24.setPPODIMENSION(rs.getString(4));
			        pp24.setPPO_RATING(rs.getDouble(5));
			        pp24.setPPOPRICE(rs.getString(6));
			        pp24.setPPO_STOCK_AVAILABILITY(rs.getInt(7));
			        pp24.setPPOIMAGES(rs.getString(8));    
			        return pp24;
		        });
		    return plist;
	}

	
	
}
