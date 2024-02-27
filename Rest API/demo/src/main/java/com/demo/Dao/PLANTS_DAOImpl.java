package com.demo.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.Model.PLANTS;

@Repository
public class PLANTS_DAOImpl implements PLANTS_DAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<PLANTS> getAllPot_Planters() {
			
		List<PLANTS> pplist = jdbcTemplate.query("Select * from PLANTS",(rs,num)->{
			PLANTS pp = new PLANTS();
			pp.setPID(rs.getString(1));
			pp.setPTITLE(rs.getString(2));
			pp.setPDESCRIPTION(rs.getString(3));
			pp.setPRATING(rs.getDouble(4));
			pp.setPPRICE(rs.getString(5));
			pp.setPSTOCKAVAILABILITY(rs.getInt(6));
			pp.setPIMAGES(rs.getString(7));	
			
			return pp;	
		});
			
		return pplist;
	}

	@Override
	public List<PLANTS> getLoadedPp(int offset, int limit) {
	    String query = "SELECT * FROM PLANTS LIMIT ? OFFSET ?";
	    
	    @SuppressWarnings("deprecation")
		List<PLANTS> pp1list = jdbcTemplate.query(query, new Object[]{limit, offset}, (rs, num) -> {
			PLANTS pp = new PLANTS();
			pp.setPID(rs.getString(1));
			pp.setPTITLE(rs.getString(2));
			pp.setPDESCRIPTION(rs.getString(3));
			pp.setPRATING(rs.getDouble(4));
			pp.setPPRICE(rs.getString(5));
			pp.setPSTOCKAVAILABILITY(rs.getInt(6));
			pp.setPIMAGES(rs.getString(7));	
			pp.setQuantity(rs.getInt(8));
			return pp;	
		});
			
		return pp1list;
	}

	@Override
	public List<PLANTS> getAllPotPlanterLoadedByRating(int offset, int limit, double rating) {
        String query = "SELECT * FROM PLANTS where PRATING = ? LIMIT ? OFFSET ?";
	    
	    @SuppressWarnings("deprecation")
		List<PLANTS> pp2list = jdbcTemplate.query(query, new Object[]{rating ,limit, offset}, (rs, num) -> {
			PLANTS pp = new PLANTS();
			pp.setPID(rs.getString(1));
			pp.setPTITLE(rs.getString(2));
			pp.setPDESCRIPTION(rs.getString(3));
			pp.setPRATING(rs.getDouble(4));
			pp.setPPRICE(rs.getString(5));
			pp.setPSTOCKAVAILABILITY(rs.getInt(6));
			pp.setPIMAGES(rs.getString(7));	
			
			return pp;	
		});
			
		return pp2list;
		}

	@Override
	public List<PLANTS> getAllPotPlanterLoadedByPrice(int offset, int limit, double from, double to) {
		String query = "SELECT * FROM PLANTS WHERE JSON_EXTRACT(PPRICE, '$[0].SP') BETWEEN ? AND ? LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PLANTS> pp3list = jdbcTemplate.query(query, new Object[]{from, to ,limit, offset}, (rs, num) -> {
	        PLANTS pp = new PLANTS();
	        pp.setPID(rs.getString(1));
			pp.setPTITLE(rs.getString(2));
			pp.setPDESCRIPTION(rs.getString(3));
			pp.setPRATING(rs.getDouble(4));
			pp.setPPRICE(rs.getString(5));
			pp.setPSTOCKAVAILABILITY(rs.getInt(6));
			pp.setPIMAGES(rs.getString(7));	
	        return pp;
	    });
		
		return pp3list;
	}

	@Override
	public List<PLANTS> getAllPotPlanterLoadedByRatingPrice(int offset, int limit, double rating, double from,
			double to) {
		
		String query = "SELECT * FROM PLANTS WHERE PRATING = ? AND JSON_EXTRACT(PPRICE, '$[0].SP') BETWEEN ? AND ? LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PLANTS> pp3list = jdbcTemplate.query(query, new Object[]{rating, from, to ,limit, offset}, (rs, num) -> {
			PLANTS pp = new PLANTS();
	        pp.setPID(rs.getString(1));
			pp.setPTITLE(rs.getString(2));
			pp.setPDESCRIPTION(rs.getString(3));
			pp.setPRATING(rs.getDouble(4));
			pp.setPPRICE(rs.getString(5));
			pp.setPSTOCKAVAILABILITY(rs.getInt(6));
			pp.setPIMAGES(rs.getString(7));	
	        return pp;
	    });
		
		return pp3list;
	}

	@Override
	public List<PLANTS> getAllPotPlanterLoadedByRatingStock(int offset, int limit, double rating, int stock) {
		String query = "SELECT * FROM PLANTS WHERE PRATING = ? AND PSTOCKAVAILABILITY = ? LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PLANTS> pp3list = jdbcTemplate.query(query, new Object[]{rating,stock,limit, offset}, (rs, num) -> {
			PLANTS pp = new PLANTS();
	        pp.setPID(rs.getString(1));
			pp.setPTITLE(rs.getString(2));
			pp.setPDESCRIPTION(rs.getString(3));
			pp.setPRATING(rs.getDouble(4));
			pp.setPPRICE(rs.getString(5));
			pp.setPSTOCKAVAILABILITY(rs.getInt(6));
			pp.setPIMAGES(rs.getString(7));	
	        return pp;
	    });
		
		return pp3list;
		
	}

	@Override
	public List<PLANTS> getAllPotPlanterLoadedByPriceStock(int offset, int limit, double from, double to,
			int stock) {
		String query = "SELECT * FROM PLANTS WHERE JSON_EXTRACT(PPRICE, '$[0].SP') BETWEEN ? AND ? AND PSTOCKAVAILABILITY = ? LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PLANTS> pp3list = jdbcTemplate.query(query, new Object[]{from, to,stock,limit, offset}, (rs, num) -> {
			PLANTS pp = new PLANTS();
	        pp.setPID(rs.getString(1));
			pp.setPTITLE(rs.getString(2));
			pp.setPDESCRIPTION(rs.getString(3));
			pp.setPRATING(rs.getDouble(4));
			pp.setPPRICE(rs.getString(5));
			pp.setPSTOCKAVAILABILITY(rs.getInt(6));
			pp.setPIMAGES(rs.getString(7));	
	        return pp;
	    });
		
		return pp3list;
	}

	@Override
	public List<PLANTS> getAllPotPlanterLoadedByPriceStockRating(int offset, int limit, double from, double to,
			int stock, double rating) {
		
		String query = "SELECT * FROM PLANTS WHERE JSON_EXTRACT(PPRICE, '$[0].SP') BETWEEN ? AND ? AND PSTOCKAVAILABILITY = ? AND PRATING = ? LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PLANTS> pp3list = jdbcTemplate.query(query, new Object[]{from, to,stock,rating,limit, offset}, (rs, num) -> {
			PLANTS pp = new PLANTS();
	        pp.setPID(rs.getString(1));
			pp.setPTITLE(rs.getString(2));
			pp.setPDESCRIPTION(rs.getString(3));
			pp.setPRATING(rs.getDouble(4));
			pp.setPPRICE(rs.getString(5));
			pp.setPSTOCKAVAILABILITY(rs.getInt(6));
			pp.setPIMAGES(rs.getString(7));	
	        return pp;
	    });
		
		return pp3list;
		
	}

	@Override
	public List<PLANTS> getAllPotPlanterLoadedByRatingPriceSORTTITLE_A_Z(int offset, int limit, double rating,
			double from, double to) {
		String query = "SELECT * FROM PLANTS WHERE PRATING = ? AND JSON_EXTRACT(PPRICE, '$[0].SP') BETWEEN ? AND ? Order by PTITLE LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PLANTS> pp3list = jdbcTemplate.query(query, new Object[]{rating, from, to ,limit, offset}, (rs, num) -> {
			PLANTS pp = new PLANTS();
	        pp.setPID(rs.getString(1));
			pp.setPTITLE(rs.getString(2));
			pp.setPDESCRIPTION(rs.getString(3));
			pp.setPRATING(rs.getDouble(4));
			pp.setPPRICE(rs.getString(5));
			pp.setPSTOCKAVAILABILITY(rs.getInt(6));
			pp.setPIMAGES(rs.getString(7));	
	        return pp;
	    });
		
		return pp3list;
	}

	@Override
	public List<PLANTS> getAllPotPlanterLoadedByRatingPriceSORTTITLE_Z_A(int offset, int limit, double rating,
			double from, double to) {
		String query = "SELECT * FROM PLANTS WHERE PRATING = ? AND JSON_EXTRACT(PPRICE, '$[0].SP') BETWEEN ? AND ? Order by PTITLE DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PLANTS> pp3list = jdbcTemplate.query(query, new Object[]{rating, from, to ,limit, offset}, (rs, num) -> {
			PLANTS pp = new PLANTS();
	        pp.setPID(rs.getString(1));
			pp.setPTITLE(rs.getString(2));
			pp.setPDESCRIPTION(rs.getString(3));
			pp.setPRATING(rs.getDouble(4));
			pp.setPPRICE(rs.getString(5));
			pp.setPSTOCKAVAILABILITY(rs.getInt(6));
			pp.setPIMAGES(rs.getString(7));	
	        return pp;
	    });
		
		return pp3list;
	}
	
	

	@Override
	public List<PLANTS> getAllPotPlanterLoadedByRatingPriceSORTPRICE_L_H(int offset, int limit, double rating,
			double from, double to) {
		String query = "SELECT * FROM PLANTS WHERE PRATING = ? AND JSON_EXTRACT(PPRICE, '$[0].SP') BETWEEN ? AND ?  order by CAST(JSON_EXTRACT(PPRICE, '$[0].SP') AS UNSIGNED) LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PLANTS> pp3list = jdbcTemplate.query(query, new Object[]{rating, from, to ,limit, offset}, (rs, num) -> {
			PLANTS pp = new PLANTS();
	        pp.setPID(rs.getString(1));
			pp.setPTITLE(rs.getString(2));
			pp.setPDESCRIPTION(rs.getString(3));
			pp.setPRATING(rs.getDouble(4));
			pp.setPPRICE(rs.getString(5));
			pp.setPSTOCKAVAILABILITY(rs.getInt(6));
			pp.setPIMAGES(rs.getString(7));	
	        return pp;
	    });
		
		return pp3list;
	}

	@Override
	public List<PLANTS> getAllPotPlanterLoadedByRatingPriceSORTPRICE_H_L(int offset, int limit, double rating,
			double from, double to) {
String query = "SELECT * FROM PLANTS WHERE PRATING = ? AND JSON_EXTRACT(PPRICE, '$[0].SP') BETWEEN ? AND ?  order by CAST(JSON_EXTRACT(PPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PLANTS> pp3list = jdbcTemplate.query(query, new Object[]{rating, from, to ,limit, offset}, (rs, num) -> {
			PLANTS pp = new PLANTS();
	        pp.setPID(rs.getString(1));
			pp.setPTITLE(rs.getString(2));
			pp.setPDESCRIPTION(rs.getString(3));
			pp.setPRATING(rs.getDouble(4));
			pp.setPPRICE(rs.getString(5));
			pp.setPSTOCKAVAILABILITY(rs.getInt(6));
			pp.setPIMAGES(rs.getString(7));	
	        return pp;
	    });
		
		return pp3list;
	}

	@Override
	public List<PLANTS> getAllPotPlanterLoadedByRatingStockSORTTITLE_A_Z(int offset, int limit, double rating,
			int stock) {
		String query = "SELECT * FROM PLANTS WHERE PRATING = ? AND PSTOCKAVAILABILITY = ? Order by PTITLE LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PLANTS> pp3list = jdbcTemplate.query(query, new Object[]{rating,stock,limit, offset}, (rs, num) -> {
			PLANTS pp = new PLANTS();
	        pp.setPID(rs.getString(1));
			pp.setPTITLE(rs.getString(2));
			pp.setPDESCRIPTION(rs.getString(3));
			pp.setPRATING(rs.getDouble(4));
			pp.setPPRICE(rs.getString(5));
			pp.setPSTOCKAVAILABILITY(rs.getInt(6));
			pp.setPIMAGES(rs.getString(7));	
	        return pp;
	    });
		
		return pp3list;
	}

	@Override
	public List<PLANTS> getAllPotPlanterLoadedByRatingStockSORTTITLE_Z_A(int offset, int limit, double rating,
			int stock) {
		String query = "SELECT * FROM PLANTS WHERE PRATING = ? AND PSTOCKAVAILABILITY = ? Order by PTITLE DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PLANTS> pp3list = jdbcTemplate.query(query, new Object[]{rating,stock,limit, offset}, (rs, num) -> {
			PLANTS pp = new PLANTS();
	        pp.setPID(rs.getString(1));
			pp.setPTITLE(rs.getString(2));
			pp.setPDESCRIPTION(rs.getString(3));
			pp.setPRATING(rs.getDouble(4));
			pp.setPPRICE(rs.getString(5));
			pp.setPSTOCKAVAILABILITY(rs.getInt(6));
			pp.setPIMAGES(rs.getString(7));	
	        return pp;
	    });
		
		return pp3list;
		
	}

	@Override
	public List<PLANTS> getAllPotPlanterLoadedByRatingStockSORTPRICE_L_H(int offset, int limit, double rating,
			int stock) {
		String query = "SELECT * FROM PLANTS WHERE PRATING = ? AND PSTOCKAVAILABILITY = ?  order by CAST(JSON_EXTRACT(PPRICE, '$[0].SP') AS UNSIGNED) LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PLANTS> pp3list = jdbcTemplate.query(query, new Object[]{rating,stock,limit, offset}, (rs, num) -> {
			PLANTS pp = new PLANTS();
	        pp.setPID(rs.getString(1));
			pp.setPTITLE(rs.getString(2));
			pp.setPDESCRIPTION(rs.getString(3));
			pp.setPRATING(rs.getDouble(4));
			pp.setPPRICE(rs.getString(5));
			pp.setPSTOCKAVAILABILITY(rs.getInt(6));
			pp.setPIMAGES(rs.getString(7));	
	        return pp;
	    });
		
		return pp3list;
	}

	@Override
	public List<PLANTS> getAllPotPlanterLoadedByRatingStockSORTPRICE_H_L(int offset, int limit, double rating,
			int stock) {
String query = "SELECT * FROM PLANTS WHERE PRATING = ? AND PSTOCKAVAILABILITY = ?  order by CAST(JSON_EXTRACT(PPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PLANTS> pp3list = jdbcTemplate.query(query, new Object[]{rating,stock,limit, offset}, (rs, num) -> {
			PLANTS pp = new PLANTS();
	        pp.setPID(rs.getString(1));
			pp.setPTITLE(rs.getString(2));
			pp.setPDESCRIPTION(rs.getString(3));
			pp.setPRATING(rs.getDouble(4));
			pp.setPPRICE(rs.getString(5));
			pp.setPSTOCKAVAILABILITY(rs.getInt(6));
			pp.setPIMAGES(rs.getString(7));	
	        return pp;
	    });
		
		return pp3list;
	}

	@Override
	public List<PLANTS> getAllPotPlanterLoadedByPriceStockSORTTITLE_A_Z(int offset, int limit, double from,
			double to, int stock) {
		String query = "SELECT * FROM PLANTS WHERE JSON_EXTRACT(PPRICE, '$[0].SP') BETWEEN ? AND ? AND PSTOCKAVAILABILITY = ? ORDER BY PTITLE LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PLANTS> pp3list = jdbcTemplate.query(query, new Object[]{from, to,stock,limit, offset}, (rs, num) -> {
			PLANTS pp = new PLANTS();
	        pp.setPID(rs.getString(1));
			pp.setPTITLE(rs.getString(2));
			pp.setPDESCRIPTION(rs.getString(3));
			pp.setPRATING(rs.getDouble(4));
			pp.setPPRICE(rs.getString(5));
			pp.setPSTOCKAVAILABILITY(rs.getInt(6));
			pp.setPIMAGES(rs.getString(7));	
	        return pp;
	    });
		
		return pp3list;
		
	}

	@Override
	public List<PLANTS> getAllPotPlanterLoadedByPriceStockSORTTITLE_Z_A(int offset, int limit, double from,
			double to, int stock) {
		String query = "SELECT * FROM PLANTS WHERE JSON_EXTRACT(PPRICE, '$[0].SP') BETWEEN ? AND ? AND PSTOCKAVAILABILITY = ? ORDER BY PTITLE DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PLANTS> pp3list = jdbcTemplate.query(query, new Object[]{from, to,stock,limit, offset}, (rs, num) -> {
			PLANTS pp = new PLANTS();
	        pp.setPID(rs.getString(1));
			pp.setPTITLE(rs.getString(2));
			pp.setPDESCRIPTION(rs.getString(3));
			pp.setPRATING(rs.getDouble(4));
			pp.setPPRICE(rs.getString(5));
			pp.setPSTOCKAVAILABILITY(rs.getInt(6));
			pp.setPIMAGES(rs.getString(7));	
	        return pp;
	    });
		
		return pp3list;
	}

	@Override
	public List<PLANTS> getAllPotPlanterLoadedByPriceStockSORTPRICE_L_H(int offset, int limit, double from,
			double to, int stock) {
		String query = "SELECT * FROM PLANTS WHERE JSON_EXTRACT(PPRICE, '$[0].SP') BETWEEN ? AND ? AND PSTOCKAVAILABILITY = ?  order by CAST(JSON_EXTRACT(PPRICE, '$[0].SP') AS UNSIGNED) LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PLANTS> pp3list = jdbcTemplate.query(query, new Object[]{from, to,stock,limit, offset}, (rs, num) -> {
			PLANTS pp = new PLANTS();
	        pp.setPID(rs.getString(1));
			pp.setPTITLE(rs.getString(2));
			pp.setPDESCRIPTION(rs.getString(3));
			pp.setPRATING(rs.getDouble(4));
			pp.setPPRICE(rs.getString(5));
			pp.setPSTOCKAVAILABILITY(rs.getInt(6));
			pp.setPIMAGES(rs.getString(7));	
	        return pp;
	    });
		
		return pp3list;
	}

	@Override
	public List<PLANTS> getAllPotPlanterLoadedByPriceStockSORTPRICE_H_L(int offset, int limit, double from,
			double to, int stock) {
		String query = "SELECT * FROM PLANTS WHERE JSON_EXTRACT(PPRICE, '$[0].SP') BETWEEN ? AND ? AND PSTOCKAVAILABILITY = ?  order by CAST(JSON_EXTRACT(PPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PLANTS> pp3list = jdbcTemplate.query(query, new Object[]{from, to,stock,limit, offset}, (rs, num) -> {
			PLANTS pp = new PLANTS();
	        pp.setPID(rs.getString(1));
			pp.setPTITLE(rs.getString(2));
			pp.setPDESCRIPTION(rs.getString(3));
			pp.setPRATING(rs.getDouble(4));
			pp.setPPRICE(rs.getString(5));
			pp.setPSTOCKAVAILABILITY(rs.getInt(6));
			pp.setPIMAGES(rs.getString(7));	
	        return pp;
	    });
		
		return pp3list;
	}

	@Override
	public List<PLANTS> getAllPotPlanterLoadedByPriceStockRatingSORTTITLE_A_Z(int offset, int limit, double from,
			double to, int stock, double rating) {
		String query = "SELECT * FROM PLANTS WHERE JSON_EXTRACT(PPRICE, '$[0].SP') BETWEEN ? AND ? AND PSTOCKAVAILABILITY = ? AND PRATING = ? ORDER BY PTITLE LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PLANTS> pp3list = jdbcTemplate.query(query, new Object[]{from, to,stock,rating,limit, offset}, (rs, num) -> {
			PLANTS pp = new PLANTS();
	        pp.setPID(rs.getString(1));
			pp.setPTITLE(rs.getString(2));
			pp.setPDESCRIPTION(rs.getString(3));
			pp.setPRATING(rs.getDouble(4));
			pp.setPPRICE(rs.getString(5));
			pp.setPSTOCKAVAILABILITY(rs.getInt(6));
			pp.setPIMAGES(rs.getString(7));	
	        return pp;
	    });
		
		return pp3list;
	}

	@Override
	public List<PLANTS> getAllPotPlanterLoadedByPriceStockRatingSORTTITLE_Z_A(int offset, int limit, double from,
			double to, int stock, double rating) {
		String query = "SELECT * FROM PLANTS WHERE JSON_EXTRACT(PPRICE, '$[0].SP') BETWEEN ? AND ? AND PSTOCKAVAILABILITY = ? AND PRATING = ? ORDER BY PTITLE DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PLANTS> pp3list = jdbcTemplate.query(query, new Object[]{from, to,stock,rating,limit, offset}, (rs, num) -> {
			PLANTS pp = new PLANTS();
	        pp.setPID(rs.getString(1));
			pp.setPTITLE(rs.getString(2));
			pp.setPDESCRIPTION(rs.getString(3));
			pp.setPRATING(rs.getDouble(4));
			pp.setPPRICE(rs.getString(5));
			pp.setPSTOCKAVAILABILITY(rs.getInt(6));
			pp.setPIMAGES(rs.getString(7));	
	        return pp;
	    });
		
		return pp3list;
	}

	@Override
	public List<PLANTS> getAllPotPlanterLoadedByPriceStockRatingSORTPRICE_L_H(int offset, int limit, double from,
			double to, int stock, double rating) {
		String query = "SELECT * FROM PLANTS WHERE JSON_EXTRACT(PPRICE, '$[0].SP') BETWEEN ? AND ? AND PSTOCKAVAILABILITY = ? AND PRATING = ?  order by CAST(JSON_EXTRACT(PPRICE, '$[0].SP') AS UNSIGNED) LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PLANTS> pp3list = jdbcTemplate.query(query, new Object[]{from, to,stock,rating,limit, offset}, (rs, num) -> {
			PLANTS pp = new PLANTS();
	        pp.setPID(rs.getString(1));
			pp.setPTITLE(rs.getString(2));
			pp.setPDESCRIPTION(rs.getString(3));
			pp.setPRATING(rs.getDouble(4));
			pp.setPPRICE(rs.getString(5));
			pp.setPSTOCKAVAILABILITY(rs.getInt(6));
			pp.setPIMAGES(rs.getString(7));	
	        return pp;
	    });
		
		return pp3list;
	}

	@Override
	public List<PLANTS> getAllPotPlanterLoadedByPriceStockRatingSORTPRICE_H_L(int offset, int limit, double from,
			double to, int stock, double rating) {
		String query = "SELECT * FROM PLANTS WHERE JSON_EXTRACT(PPRICE, '$[0].SP') BETWEEN ? AND ? AND PSTOCKAVAILABILITY = ? AND PRATING = ?  order by CAST(JSON_EXTRACT(PPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PLANTS> pp3list = jdbcTemplate.query(query, new Object[]{from, to,stock,rating,limit, offset}, (rs, num) -> {
			PLANTS pp = new PLANTS();
	        pp.setPID(rs.getString(1));
			pp.setPTITLE(rs.getString(2));
			pp.setPDESCRIPTION(rs.getString(3));
			pp.setPRATING(rs.getDouble(4));
			pp.setPPRICE(rs.getString(5));
			pp.setPSTOCKAVAILABILITY(rs.getInt(6));
			pp.setPIMAGES(rs.getString(7));	
	        return pp;
	    });
		
		return pp3list;
	}

	@SuppressWarnings("deprecation")
	@Override
	public PLANTS findById(String pfid) {
		String query = "select * from PLANTS where PID=?";
		PLANTS pp = new PLANTS();
		try {
		    return jdbcTemplate.queryForObject(query,new Object[] {pfid},BeanPropertyRowMapper.newInstance(PLANTS.class));
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<PLANTS> Availability(int offset, int limit) {
		String query = "select * from PLANTS where PSTOCKAVAILABILITY=1 limit ? offset ?";
		@SuppressWarnings("deprecation")
		List<PLANTS> pp3list = jdbcTemplate.query(query,new Object[] {limit,offset}, (rs,num)->{
			PLANTS pp = new PLANTS();
	        pp.setPID(rs.getString(1));
			pp.setPTITLE(rs.getString(2));
			pp.setPDESCRIPTION(rs.getString(3));
			pp.setPRATING(rs.getDouble(4));
			pp.setPPRICE(rs.getString(5));
			pp.setPSTOCKAVAILABILITY(rs.getInt(6));
			pp.setPIMAGES(rs.getString(7));	
	        return pp;
	    });
		
		return pp3list;
	}
	

	@Override
	public List<PLANTS> sortZ_A(int offset, int limit) {
		String query = "select * from PLANTS order by PTITLE desc limit ? offset ?";
		@SuppressWarnings("deprecation")
		List<PLANTS> pp3list = jdbcTemplate.query(query,new Object[] {limit,offset}, (rs,num)->{
			PLANTS pp = new PLANTS();
	        pp.setPID(rs.getString(1));
			pp.setPTITLE(rs.getString(2));
			pp.setPDESCRIPTION(rs.getString(3));
			pp.setPRATING(rs.getDouble(4));
			pp.setPPRICE(rs.getString(5));
			pp.setPSTOCKAVAILABILITY(rs.getInt(6));
			pp.setPIMAGES(rs.getString(7));	
	        return pp;
	    });
		
		return pp3list;
	}
	
	@Override
	public List<PLANTS> Avail_A_Z(int offset, int limit) {
		String query = "select * from PLANTS where PSTOCKAVAILABILITY=1 order by PPTitle limit ? offset ?";
		@SuppressWarnings("deprecation")
		List<PLANTS> pp3list = jdbcTemplate.query(query,new Object[] {limit,offset}, (rs,num)->{
			PLANTS pp = new PLANTS();
	        pp.setPID(rs.getString(1));
			pp.setPTITLE(rs.getString(2));
			pp.setPDESCRIPTION(rs.getString(3));
			pp.setPRATING(rs.getDouble(4));
			pp.setPPRICE(rs.getString(5));
			pp.setPSTOCKAVAILABILITY(rs.getInt(6));
			pp.setPIMAGES(rs.getString(7));	
	        return pp;
	    });
		
		return pp3list;
	}

	@Override
	public List<PLANTS> Avail_Z_A(int offset, int limit) {
		String query = "select * from PLANTS where PSTOCKAVAILABILITY=1 order by PPTitle desc limit ? offset ?";
		@SuppressWarnings("deprecation")
		List<PLANTS> pp3list = jdbcTemplate.query(query,new Object[] {limit,offset}, (rs,num)->{
			PLANTS pp = new PLANTS();
	        pp.setPID(rs.getString(1));
			pp.setPTITLE(rs.getString(2));
			pp.setPDESCRIPTION(rs.getString(3));
			pp.setPRATING(rs.getDouble(4));
			pp.setPPRICE(rs.getString(5));
			pp.setPSTOCKAVAILABILITY(rs.getInt(6));
			pp.setPIMAGES(rs.getString(7));	
	        return pp;
	    });
		
		return pp3list;
	}

	@Override
	public List<PLANTS> getPlantsByPriceLH(int offset, int limit) {
String query = "SELECT * FROM PLANTS where PSTOCKAVAILABILITY=1 ORDER BY CAST(JSON_EXTRACT(PPRICE, '$[0].SP') AS UNSIGNED) ASC LIMIT ? OFFSET ?";
		
	    @SuppressWarnings("deprecation")
		List<PLANTS> pp3list = jdbcTemplate.query(query,new Object[] {limit,offset},
	        (rs, num) -> {
	        	PLANTS pp = new PLANTS();
		        pp.setPID(rs.getString(1));
				pp.setPTITLE(rs.getString(2));
				pp.setPDESCRIPTION(rs.getString(3));
				pp.setPRATING(rs.getDouble(4));
				pp.setPPRICE(rs.getString(5));
				pp.setPSTOCKAVAILABILITY(rs.getInt(6));
				pp.setPIMAGES(rs.getString(7));	
		        return pp;
		    });
			
			return pp3list;
	}

	@Override
	public List<PLANTS> getPlantsByPriceHL(int offset, int limit) {
String query = "SELECT * FROM PLANTS where PSTOCKAVAILABILITY=1 ORDER BY CAST(JSON_EXTRACT(PPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
		
	    @SuppressWarnings("deprecation")
		List<PLANTS> pp3list = jdbcTemplate.query(query,new Object[] {limit,offset},
	        (rs, num) -> {
	        	PLANTS pp = new PLANTS();
		        pp.setPID(rs.getString(1));
				pp.setPTITLE(rs.getString(2));
				pp.setPDESCRIPTION(rs.getString(3));
				pp.setPRATING(rs.getDouble(4));
				pp.setPPRICE(rs.getString(5));
				pp.setPSTOCKAVAILABILITY(rs.getInt(6));
				pp.setPIMAGES(rs.getString(7));	
		        return pp;
		    });
			
			return pp3list;
	}

	@Override
	public List<PLANTS> sortA_Z(int offset, int limit) {
		String query = "select * from PLANTS order by PTITLE limit ? offset ?";
		@SuppressWarnings("deprecation")
		List<PLANTS> pp3list = jdbcTemplate.query(query,new Object[] {limit,offset}, (rs,num)->{
			PLANTS pp = new PLANTS();
	        pp.setPID(rs.getString(1));
			pp.setPTITLE(rs.getString(2));
			pp.setPDESCRIPTION(rs.getString(3));
			pp.setPRATING(rs.getDouble(4));
			pp.setPPRICE(rs.getString(5));
			pp.setPSTOCKAVAILABILITY(rs.getInt(6));
			pp.setPIMAGES(rs.getString(7));	
	        return pp;
	    });
		
		return pp3list;
	}

	@Override
	public List<PLANTS> SORTBYPRICE_L_H(int offset, int limit) {
		String query = "SELECT * FROM PLANTS order by CAST(JSON_EXTRACT(PPRICE, '$[0].SP') AS UNSIGNED) ASC LIMIT ? OFFSET ?";
		
	    @SuppressWarnings("deprecation")
		List<PLANTS> pp3list = jdbcTemplate.query(query,new Object[] {limit,offset},
	        (rs, num) -> {
	        	PLANTS pp = new PLANTS();
		        pp.setPID(rs.getString(1));
				pp.setPTITLE(rs.getString(2));
				pp.setPDESCRIPTION(rs.getString(3));
				pp.setPRATING(rs.getDouble(4));
				pp.setPPRICE(rs.getString(5));
				pp.setPSTOCKAVAILABILITY(rs.getInt(6));
				pp.setPIMAGES(rs.getString(7));	
		        return pp;
		    });
			
			return pp3list;
	    }

	

	@Override
	public List<PLANTS> SORTBYPRICE_H_L(int offset, int limit) {
		String query = "SELECT * FROM PLANTS order by CAST(JSON_EXTRACT(PPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
		
	    @SuppressWarnings("deprecation")
		List<PLANTS> pp3list = jdbcTemplate.query(query,new Object[] {limit,offset},
	        (rs, num) -> {
	        	PLANTS pp = new PLANTS();
		        pp.setPID(rs.getString(1));
				pp.setPTITLE(rs.getString(2));
				pp.setPDESCRIPTION(rs.getString(3));
				pp.setPRATING(rs.getDouble(4));
				pp.setPPRICE(rs.getString(5));
				pp.setPSTOCKAVAILABILITY(rs.getInt(6));
				pp.setPIMAGES(rs.getString(7));	
		        return pp;
		    });
			
			return pp3list;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public List<PLANTS> getLoadedPlantsFilterSortPHL1(int offset, int limit, double from, double to) {
		String query="SELECT * FROM PLANTS WHERE JSON_EXTRACT(PPRICE, '$[0].SP') BETWEEN ? AND ? ORDER BY cast(JSON_EXTRACT(PPRICE, '$[0].SP') as unsigned) DESC LIMIT ? OFFSET ?";
		List<PLANTS> pp3list = jdbcTemplate.query(query,new Object[] {from,to,limit,offset},
		        (rs, num) -> {
		        	PLANTS pp = new PLANTS();
			        pp.setPID(rs.getString(1));
					pp.setPTITLE(rs.getString(2));
					pp.setPDESCRIPTION(rs.getString(3));
					pp.setPRATING(rs.getDouble(4));
					pp.setPPRICE(rs.getString(5));
					pp.setPSTOCKAVAILABILITY(rs.getInt(6));
					pp.setPIMAGES(rs.getString(7));	
			        return pp;
			    });
				
				return pp3list;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<PLANTS> getLoadedPlantsFilterSortPLH1(int offset, int limit, double from, double to) {
		String query="SELECT * FROM PLANTS WHERE JSON_EXTRACT(PPRICE, '$[0].SP') BETWEEN ? AND ? ORDER BY cast(JSON_EXTRACT(PPRICE, '$[0].SP') as unsigned) ASC LIMIT ? OFFSET ?";
		List<PLANTS> pp3list = jdbcTemplate.query(query,new Object[] {from,to,limit,offset},
		        (rs, num) -> {
		        	PLANTS pp = new PLANTS();
			        pp.setPID(rs.getString(1));
					pp.setPTITLE(rs.getString(2));
					pp.setPDESCRIPTION(rs.getString(3));
					pp.setPRATING(rs.getDouble(4));
					pp.setPPRICE(rs.getString(5));
					pp.setPSTOCKAVAILABILITY(rs.getInt(6));
					pp.setPIMAGES(rs.getString(7));	
			        return pp;
			    });
				
				return pp3list;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<PLANTS> getLoadedPlantFilterSortAZ1(int offset, int limit, double from, double to) {
		String query ="SELECT * FROM PLANTS WHERE JSON_EXTRACT(PPRICE, '$[0].SP') BETWEEN ? AND ? ORDER BY PTITLE ASC LIMIT ? OFFSET ? ";
		List<PLANTS> pp3list = jdbcTemplate.query(query,new Object[] {from,to,limit,offset},
		        (rs, num) -> {
		        	PLANTS pp = new PLANTS();
			        pp.setPID(rs.getString(1));
					pp.setPTITLE(rs.getString(2));
					pp.setPDESCRIPTION(rs.getString(3));
					pp.setPRATING(rs.getDouble(4));
					pp.setPPRICE(rs.getString(5));
					pp.setPSTOCKAVAILABILITY(rs.getInt(6));
					pp.setPIMAGES(rs.getString(7));	
			        return pp;
			    });
				
				return pp3list;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<PLANTS> getLoadedPlantFilterSortZA1(int offset, int limit, double from, double to) {
		String query ="SELECT * FROM PLANTS WHERE JSON_EXTRACT(PPRICE, '$[0].SP') BETWEEN ? AND ? ORDER BY PTITLE DESC LIMIT ? OFFSET ? ";
		List<PLANTS> pp3list = jdbcTemplate.query(query,new Object[] {from,to,limit,offset},
		        (rs, num) -> {
		        	PLANTS pp = new PLANTS();
			        pp.setPID(rs.getString(1));
					pp.setPTITLE(rs.getString(2));
					pp.setPDESCRIPTION(rs.getString(3));
					pp.setPRATING(rs.getDouble(4));
					pp.setPPRICE(rs.getString(5));
					pp.setPSTOCKAVAILABILITY(rs.getInt(6));
					pp.setPIMAGES(rs.getString(7));	
			        return pp;
			    });
				
				return pp3list;
	}
	
	
	@SuppressWarnings("deprecation")
	@Override
	public List<PLANTS> getLoadedPlantsFilterSortRHL2(int offset, int limit, double rating) {
		String query ="SELECT * FROM PLANTS WHERE PRATING = ? ORDER BY cast(JSON_EXTRACT(PPRICE, '$[0].SP') as unsigned) DESC LIMIT ? OFFSET ? ";
		List<PLANTS> pp3list = jdbcTemplate.query(query,new Object[] {rating,limit,offset},
		        (rs, num) -> {
		        	PLANTS pp = new PLANTS();
			        pp.setPID(rs.getString(1));
					pp.setPTITLE(rs.getString(2));
					pp.setPDESCRIPTION(rs.getString(3));
					pp.setPRATING(rs.getDouble(4));
					pp.setPPRICE(rs.getString(5));
					pp.setPSTOCKAVAILABILITY(rs.getInt(6));
					pp.setPIMAGES(rs.getString(7));	
			        return pp;
			    });
				
				return pp3list;
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<PLANTS> getLoadedPlantsFilterSortRLH2(int offset, int limit, double rating) {
		String query ="SELECT * FROM PLANTS WHERE PRATING = ? ORDER BY ORDER BY cast(JSON_EXTRACT(PPRICE, '$[0].SP') as unsigned) ASC LIMIT ? OFFSET ? ";
		List<PLANTS> pp3list = jdbcTemplate.query(query,new Object[] {rating,limit,offset},
		        (rs, num) -> {
		        	PLANTS pp = new PLANTS();
			        pp.setPID(rs.getString(1));
					pp.setPTITLE(rs.getString(2));
					pp.setPDESCRIPTION(rs.getString(3));
					pp.setPRATING(rs.getDouble(4));
					pp.setPPRICE(rs.getString(5));
					pp.setPSTOCKAVAILABILITY(rs.getInt(6));
					pp.setPIMAGES(rs.getString(7));	
			        return pp;
			    });
				
				return pp3list;
	}

	@Override
	public List<PLANTS> getLoadedPlantsFilterSortRAZ2(int offset, int limit, double rating) {
		String query = "SELECT * FROM PLANTS WHERE PRATING = ? ORDER BY PTITLE ASC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PLANTS> pp3list = jdbcTemplate.query(query,new Object[] {rating,limit,offset},
		        (rs, num) -> {
		        	PLANTS pp = new PLANTS();
			        pp.setPID(rs.getString(1));
					pp.setPTITLE(rs.getString(2));
					pp.setPDESCRIPTION(rs.getString(3));
					pp.setPRATING(rs.getDouble(4));
					pp.setPPRICE(rs.getString(5));
					pp.setPSTOCKAVAILABILITY(rs.getInt(6));
					pp.setPIMAGES(rs.getString(7));	
			        return pp;
			    });
				
				return pp3list;
	}

	@Override
	public List<PLANTS> getLoadedPlantsFilterSortRZA2(int offset, int limit, double rating) {
String query = "SELECT * FROM PLANTS WHERE PRATING = ? ORDER BY PTITLE DESC LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<PLANTS> pp3list = jdbcTemplate.query(query,new Object[] {rating,limit,offset},
		        (rs, num) -> {
		        	PLANTS pp = new PLANTS();
			        pp.setPID(rs.getString(1));
					pp.setPTITLE(rs.getString(2));
					pp.setPDESCRIPTION(rs.getString(3));
					pp.setPRATING(rs.getDouble(4));
					pp.setPPRICE(rs.getString(5));
					pp.setPSTOCKAVAILABILITY(rs.getInt(6));
					pp.setPIMAGES(rs.getString(7));	
			        return pp;
			    });
				
				return pp3list;
	}
	
	
}
