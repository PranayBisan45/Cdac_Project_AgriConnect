package com.demo.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.Model.Plant_Food;

@Repository
public class PlantFoodDaoImpl implements PlantFoodDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Plant_Food> getAllProducts() {
		List<Plant_Food> plist = jdbcTemplate.query("select * from plant_food", (rs,num)->{
			Plant_Food pfood = new Plant_Food();
			pfood.setPFID(rs.getString(1));
			pfood.setPFTitle(rs.getString(2));
			pfood.setPFDescription(rs.getString(3));
			pfood.setPFWeight(rs.getString(4));
			pfood.setPFRating(rs.getDouble(5));
			pfood.setPFPrice(rs.getString(6));
			pfood.setPFSTOCKAVAILABILITY(rs.getInt(7));
			pfood.setPFImages(rs.getString(8));
			
			return pfood;
		});
		
		return plist;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public Plant_Food findById(String pfid) {
		String query = "select * from plant_food where pfid=?";
		try {
		    return jdbcTemplate.queryForObject(query,new Object[] {pfid},BeanPropertyRowMapper.newInstance(Plant_Food.class));
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
			
	}

	@Override
	public List<Plant_Food> sortA_Z(int offset, int limit) {
		String query = "select * from plant_food order by pftitle limit ? offset ?";
		@SuppressWarnings("deprecation")
		List<Plant_Food> sortlist = jdbcTemplate.query(query,new Object[] {limit,offset}, (rs,num)->{
			Plant_Food pfood = new Plant_Food();
			pfood.setPFID(rs.getString(1));
			pfood.setPFTitle(rs.getString(2));
			pfood.setPFDescription(rs.getString(3));
			pfood.setPFWeight(rs.getString(4));
			pfood.setPFRating(rs.getDouble(5));
			pfood.setPFPrice(rs.getString(6));
			pfood.setPFSTOCKAVAILABILITY(rs.getInt(7));
			pfood.setPFImages(rs.getString(8));
			pfood.setQuantity(rs.getInt(9));
			
			return pfood;
		});
		
		return sortlist;
	}


	@Override
	public List<Plant_Food> sortZ_A(int offset, int limit) {
		String query = "select * from plant_food order by pftitle desc limit ? offset ?";
		@SuppressWarnings("deprecation")
		List<Plant_Food> sortlist = jdbcTemplate.query(query,new Object[] {limit,offset}, (rs,num)->{
			Plant_Food pfood = new Plant_Food();
			pfood.setPFID(rs.getString(1));
			pfood.setPFTitle(rs.getString(2));
			pfood.setPFDescription(rs.getString(3));
			pfood.setPFWeight(rs.getString(4));
			pfood.setPFRating(rs.getDouble(5));
			pfood.setPFPrice(rs.getString(6));
			pfood.setPFSTOCKAVAILABILITY(rs.getInt(7));
			pfood.setPFImages(rs.getString(8));
			
			return pfood;
		});
		
		return sortlist;
	}

	@Override
	public List<Plant_Food> Availability(int offset, int limit) {
		String query = "select * from plant_food where PFSTOCKAVAILABILITY=1 limit ? offset ?";
		@SuppressWarnings("deprecation")
		List<Plant_Food> availablelist = jdbcTemplate.query(query,new Object[] {limit,offset}, (rs,num)->{
			Plant_Food pfood = new Plant_Food();
			pfood.setPFID(rs.getString(1));
			pfood.setPFTitle(rs.getString(2));
			pfood.setPFDescription(rs.getString(3));
			pfood.setPFWeight(rs.getString(4));
			pfood.setPFRating(rs.getDouble(5));
			pfood.setPFPrice(rs.getString(6));
			pfood.setPFSTOCKAVAILABILITY(rs.getInt(7));
			pfood.setPFImages(rs.getString(8));
			
			return pfood;
		});
		
		return availablelist;
	}

	@Override
	public List<Plant_Food> Avail_A_Z(int offset, int limit) {
		String query = "select * from plant_food where PFSTOCKAVAILABILITY=1 order by PfTitle limit ? offset ?";
		@SuppressWarnings("deprecation")
		List<Plant_Food> availablelist_A_Z = jdbcTemplate.query(query,new Object[] {limit,offset}, (rs,num)->{
			Plant_Food pfood = new Plant_Food();
			pfood.setPFID(rs.getString(1));
			pfood.setPFTitle(rs.getString(2));
			pfood.setPFDescription(rs.getString(3));
			pfood.setPFWeight(rs.getString(4));
			pfood.setPFRating(rs.getDouble(5));
			pfood.setPFPrice(rs.getString(6));
			pfood.setPFSTOCKAVAILABILITY(rs.getInt(7));
			pfood.setPFImages(rs.getString(8));
			
			return pfood;
		});
		
		return availablelist_A_Z;
	}

	@Override
	public List<Plant_Food> Avail_Z_A(int offset, int limit) {
		String query = "select * from plant_food where PFSTOCKAVAILABILITY=1 order by PfTitle desc limit ? offset ?";
		@SuppressWarnings("deprecation")
		List<Plant_Food> availablelist_Z_A = jdbcTemplate.query(query,new Object[] {limit,offset}, (rs,num)->{
			Plant_Food pfood = new Plant_Food();
			pfood.setPFID(rs.getString(1));
			pfood.setPFTitle(rs.getString(2));
			pfood.setPFDescription(rs.getString(3));
			pfood.setPFWeight(rs.getString(4));
			pfood.setPFRating(rs.getDouble(5));
			pfood.setPFPrice(rs.getString(6));
			pfood.setPFSTOCKAVAILABILITY(rs.getInt(7));
			pfood.setPFImages(rs.getString(8));
			
			return pfood;
		});
		
		return availablelist_Z_A;
	}

	@Override
	public List<Plant_Food> getPlantsAvailByPriceLH(int offset, int limit) {
String query = "SELECT * FROM plant_food where PFSTOCKAVAILABILITY=1 ORDER BY CAST(JSON_EXTRACT(PFPRICE, '$[0].SP') AS UNSIGNED) ASC LIMIT ? OFFSET ?";
		
	    @SuppressWarnings("deprecation")
		List<Plant_Food> plist = jdbcTemplate.query(query,new Object[] {limit,offset},
	        (rs, num) -> {
	        	Plant_Food pfood = new Plant_Food();
	        	pfood.setPFID(rs.getString(1));
				pfood.setPFTitle(rs.getString(2));
				pfood.setPFDescription(rs.getString(3));
				pfood.setPFWeight(rs.getString(4));
				pfood.setPFRating(rs.getDouble(5));
				pfood.setPFPrice(rs.getString(6));
				pfood.setPFSTOCKAVAILABILITY(rs.getInt(7));
				pfood.setPFImages(rs.getString(8));
	            return pfood;
	        });
	    return plist;
	}

	@Override
	public List<Plant_Food> getPlantsAvailByPriceHL(int offset, int limit) {
String query = "SELECT * FROM plant_food where PFSTOCKAVAILABILITY=1 ORDER BY CAST(JSON_EXTRACT(PFPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
		
	    @SuppressWarnings("deprecation")
		List<Plant_Food> plist = jdbcTemplate.query(query,new Object[] {limit,offset},
	        (rs, num) -> {
	        	Plant_Food pfood = new Plant_Food();
	        	pfood.setPFID(rs.getString(1));
				pfood.setPFTitle(rs.getString(2));
				pfood.setPFDescription(rs.getString(3));
				pfood.setPFWeight(rs.getString(4));
				pfood.setPFRating(rs.getDouble(5));
				pfood.setPFPrice(rs.getString(6));
				pfood.setPFSTOCKAVAILABILITY(rs.getInt(7));
				pfood.setPFImages(rs.getString(8));
	            return pfood;
	        });
	    return plist;
	}

	@Override
	public List<Plant_Food> getPlantsFoodByPrice(int offset, int limit) {
String query = "SELECT * FROM plant_food ORDER BY CAST(JSON_EXTRACT(PFPRICE, '$[0].SP') AS UNSIGNED) ASC LIMIT ? OFFSET ?";
		
	    @SuppressWarnings("deprecation")
		List<Plant_Food> plist = jdbcTemplate.query(query,new Object[] {limit,offset},
	        (rs, num) -> {
	        	Plant_Food pfood = new Plant_Food();
	        	pfood.setPFID(rs.getString(1));
				pfood.setPFTitle(rs.getString(2));
				pfood.setPFDescription(rs.getString(3));
				pfood.setPFWeight(rs.getString(4));
				pfood.setPFRating(rs.getDouble(5));
				pfood.setPFPrice(rs.getString(6));
				pfood.setPFSTOCKAVAILABILITY(rs.getInt(7));
				pfood.setPFImages(rs.getString(8));
	            return pfood;
	        });
	    return plist;
	}

	@Override
	public List<Plant_Food> getPlantsFoodByPriceHL(int offset, int limit) {
String query = "SELECT * FROM plant_food ORDER BY CAST(JSON_EXTRACT(PFPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
		
	    @SuppressWarnings("deprecation")
		List<Plant_Food> plist = jdbcTemplate.query(query,new Object[] {limit,offset},
	        (rs, num) -> {
	        	Plant_Food pfood = new Plant_Food();
	        	pfood.setPFID(rs.getString(1));
				pfood.setPFTitle(rs.getString(2));
				pfood.setPFDescription(rs.getString(3));
				pfood.setPFWeight(rs.getString(4));
				pfood.setPFRating(rs.getDouble(5));
				pfood.setPFPrice(rs.getString(6));
				pfood.setPFSTOCKAVAILABILITY(rs.getInt(7));
				pfood.setPFImages(rs.getString(8));
	            return pfood;
	        });
	    return plist;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Plant_Food> getLoadedPlantsFilterSortPHL1(int offset, int limit, double from, double to) {
		String query="SELECT * FROM plant_food WHERE JSON_EXTRACT(PFPRICE, '$[0].SP') BETWEEN ? AND ? ORDER BY CAST(JSON_EXTRACT(PFPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
		List<Plant_Food> plist = jdbcTemplate.query(query,new Object[] {from,to,limit,offset},(rs, num) -> {
			Plant_Food pfood = new Plant_Food();
        	pfood.setPFID(rs.getString(1));
			pfood.setPFTitle(rs.getString(2));
			pfood.setPFDescription(rs.getString(3));
			pfood.setPFWeight(rs.getString(4));
			pfood.setPFRating(rs.getDouble(5));
			pfood.setPFPrice(rs.getString(6));
			pfood.setPFSTOCKAVAILABILITY(rs.getInt(7));
			pfood.setPFImages(rs.getString(8));
            return pfood;
			});
		return plist;
		}

	@SuppressWarnings("deprecation")
	@Override
	public List<Plant_Food> getLoadedPlantsFoodFilterSortPLH1(int offset, int limit, double from, double to) {
		String query="SELECT * FROM plant_food WHERE JSON_EXTRACT(PFPRICE, '$[0].SP') BETWEEN ? AND ? ORDER BY CAST(JSON_EXTRACT(PFPRICE, '$[0].SP') AS UNSIGNED) ASC LIMIT ? OFFSET ?";
		List<Plant_Food> plist = jdbcTemplate.query(query,new Object[] {from,to,limit,offset},(rs, num) -> {
			Plant_Food pfood = new Plant_Food();
        	pfood.setPFID(rs.getString(1));
			pfood.setPFTitle(rs.getString(2));
			pfood.setPFDescription(rs.getString(3));
			pfood.setPFWeight(rs.getString(4));
			pfood.setPFRating(rs.getDouble(5));
			pfood.setPFPrice(rs.getString(6));
			pfood.setPFSTOCKAVAILABILITY(rs.getInt(7));
			pfood.setPFImages(rs.getString(8));
            return pfood;
			});
		return plist;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Plant_Food> getLoadedPlantFoodFilterSortAZ1(int offset, int limit, double from, double to) {
		String query ="SELECT * FROM plant_food WHERE JSON_EXTRACT(PFPRICE, '$[0].SP') BETWEEN ? AND ? ORDER BY PFTITLE ASC LIMIT ? OFFSET ? ";
		List<Plant_Food> plist = jdbcTemplate.query(query,new Object[] {from,to,limit,offset},(rs, num) -> {
			Plant_Food pfood = new Plant_Food();
        	pfood.setPFID(rs.getString(1));
			pfood.setPFTitle(rs.getString(2));
			pfood.setPFDescription(rs.getString(3));
			pfood.setPFWeight(rs.getString(4));
			pfood.setPFRating(rs.getDouble(5));
			pfood.setPFPrice(rs.getString(6));
			pfood.setPFSTOCKAVAILABILITY(rs.getInt(7));
			pfood.setPFImages(rs.getString(8));
            return pfood;
			});
		return plist;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Plant_Food> getLoadedPlantFoodFilterSortZA1(int offset, int limit, double from, double to) {
		String query ="SELECT * FROM plant_food WHERE JSON_EXTRACT(PFPRICE, '$[0].SP') BETWEEN ? AND ? ORDER BY PFTITLE DESC LIMIT ? OFFSET ? ";
		List<Plant_Food> plist = jdbcTemplate.query(query,new Object[] {from,to,limit,offset},(rs, num) -> {
			Plant_Food pfood = new Plant_Food();
        	pfood.setPFID(rs.getString(1));
			pfood.setPFTitle(rs.getString(2));
			pfood.setPFDescription(rs.getString(3));
			pfood.setPFWeight(rs.getString(4));
			pfood.setPFRating(rs.getDouble(5));
			pfood.setPFPrice(rs.getString(6));
			pfood.setPFSTOCKAVAILABILITY(rs.getInt(7));
			pfood.setPFImages(rs.getString(8));
            return pfood;
			});
		return plist;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Plant_Food> getLoadedPlantsFoodRating(int offset, int limit, double rating) {
		String query = "SELECT * FROM plant_food WHERE PFRATING = ? LIMIT ? OFFSET ?";
		List<Plant_Food> plist = jdbcTemplate.query(query,new Object[] {rating,limit,offset},(rs, num) -> {
			Plant_Food pfood = new Plant_Food();
        	pfood.setPFID(rs.getString(1));
			pfood.setPFTitle(rs.getString(2));
			pfood.setPFDescription(rs.getString(3));
			pfood.setPFWeight(rs.getString(4));
			pfood.setPFRating(rs.getDouble(5));
			pfood.setPFPrice(rs.getString(6));
			pfood.setPFSTOCKAVAILABILITY(rs.getInt(7));
			pfood.setPFImages(rs.getString(8));
            return pfood;
			});
		return plist;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Plant_Food> getLoadedPlantsFoodFilterSortRHL2(int offset, int limit, double rating) {
		String query ="SELECT * FROM plant_food WHERE PRRATING = ? ORDER BY CAST(JSON_EXTRACT(PPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ? ";
		List<Plant_Food> plist = jdbcTemplate.query(query,new Object[] {rating,limit,offset},(rs, num) -> {
			Plant_Food pfood = new Plant_Food();
        	pfood.setPFID(rs.getString(1));
			pfood.setPFTitle(rs.getString(2));
			pfood.setPFDescription(rs.getString(3));
			pfood.setPFWeight(rs.getString(4));
			pfood.setPFRating(rs.getDouble(5));
			pfood.setPFPrice(rs.getString(6));
			pfood.setPFSTOCKAVAILABILITY(rs.getInt(7));
			pfood.setPFImages(rs.getString(8));
            return pfood;
			});
		return plist;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Plant_Food> getLoadedPlantsFoodFilterSortRLH2(int offset, int limit, double rating) {
		String query ="SELECT * FROM plant_food WHERE PFRATING = ? ORDER BY CAST(JSON_EXTRACT(PFPRICE, '$[0].SP') AS UNSIGNED) ASC LIMIT ? OFFSET ? ";
		List<Plant_Food> plist = jdbcTemplate.query(query,new Object[] {rating,limit,offset},(rs, num) -> {
			Plant_Food pfood = new Plant_Food();
        	pfood.setPFID(rs.getString(1));
			pfood.setPFTitle(rs.getString(2));
			pfood.setPFDescription(rs.getString(3));
			pfood.setPFWeight(rs.getString(4));
			pfood.setPFRating(rs.getDouble(5));
			pfood.setPFPrice(rs.getString(6));
			pfood.setPFSTOCKAVAILABILITY(rs.getInt(7));
			pfood.setPFImages(rs.getString(8));
            return pfood;
			});
		return plist;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Plant_Food> getLoadedPlantsFoodFilterSortRAZ2(int offset, int limit, double rating) {
		String query = "SELECT * FROM plant_food WHERE PFRATING = ? ORDER BY PFTITLE ASC LIMIT ? OFFSET ?";
		List<Plant_Food> plist = jdbcTemplate.query(query,new Object[] {rating,limit,offset},(rs, num) -> {
			Plant_Food pfood = new Plant_Food();
        	pfood.setPFID(rs.getString(1));
			pfood.setPFTitle(rs.getString(2));
			pfood.setPFDescription(rs.getString(3));
			pfood.setPFWeight(rs.getString(4));
			pfood.setPFRating(rs.getDouble(5));
			pfood.setPFPrice(rs.getString(6));
			pfood.setPFSTOCKAVAILABILITY(rs.getInt(7));
			pfood.setPFImages(rs.getString(8));
            return pfood;
			});
		return plist;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Plant_Food> getLoadedPlantsFoodFilterSortRZA2(int offset, int limit, double rating) {
		String query = "SELECT * FROM plant_food WHERE PFRATING = ? ORDER BY PFTITLE DESC LIMIT ? OFFSET ?";
		List<Plant_Food> plist = jdbcTemplate.query(query,new Object[] {rating,limit,offset},(rs, num) -> {
				Plant_Food pfood = new Plant_Food();
	        	pfood.setPFID(rs.getString(1));
				pfood.setPFTitle(rs.getString(2));
				pfood.setPFDescription(rs.getString(3));
				pfood.setPFWeight(rs.getString(4));
				pfood.setPFRating(rs.getDouble(5));
				pfood.setPFPrice(rs.getString(6));
				pfood.setPFSTOCKAVAILABILITY(rs.getInt(7));
				pfood.setPFImages(rs.getString(8));
	            return pfood;
				});
			return plist;
	}

	@Override
	public List<Plant_Food> getLoadedPf(int offset, int limit) {
		 String query = "SELECT * FROM Plant_Food LIMIT ? OFFSET ?";
		    
		    @SuppressWarnings("deprecation")
			List<Plant_Food> plist = jdbcTemplate.query(query, new Object[]{limit, offset}, (rs, num) -> {
				Plant_Food pfood = new Plant_Food();
	        	pfood.setPFID(rs.getString(1));
				pfood.setPFTitle(rs.getString(2));
				pfood.setPFDescription(rs.getString(3));
				pfood.setPFWeight(rs.getString(4));
				pfood.setPFRating(rs.getDouble(5));
				pfood.setPFPrice(rs.getString(6));
				pfood.setPFSTOCKAVAILABILITY(rs.getInt(7));
				pfood.setPFImages(rs.getString(8));
	            return pfood;
				});
			return plist;
	
	}
	
	@Override
	public List<Plant_Food> getAllPlantFoodsLoadedByRating(int offset, int limit, double rating) {
String query = "SELECT * FROM Plant_Food where PFRATING = ? LIMIT ? OFFSET ?";
	    
	    @SuppressWarnings("deprecation")
		List<Plant_Food> pp2list = jdbcTemplate.query(query, new Object[]{rating ,limit, offset}, (rs, num) -> {
			Plant_Food pfood = new Plant_Food();
        	pfood.setPFID(rs.getString(1));
			pfood.setPFTitle(rs.getString(2));
			pfood.setPFDescription(rs.getString(3));
			pfood.setPFWeight(rs.getString(4));
			pfood.setPFRating(rs.getDouble(5));
			pfood.setPFPrice(rs.getString(6));
			pfood.setPFSTOCKAVAILABILITY(rs.getInt(7));
			pfood.setPFImages(rs.getString(8));
            return pfood;
			});
		return pp2list;
	}

	@Override
	public List<Plant_Food> getAllPlantFoodsLoadedByPrice(int offset, int limit, double from, double to) {
String query = "SELECT * FROM Plant_Food WHERE JSON_EXTRACT(PFPRICE, '$[0].SP') BETWEEN ? AND ? LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<Plant_Food> pp3list = jdbcTemplate.query(query, new Object[]{from, to ,limit, offset}, (rs, num) -> {
			Plant_Food pfood = new Plant_Food();
        	pfood.setPFID(rs.getString(1));
			pfood.setPFTitle(rs.getString(2));
			pfood.setPFDescription(rs.getString(3));
			pfood.setPFWeight(rs.getString(4));
			pfood.setPFRating(rs.getDouble(5));
			pfood.setPFPrice(rs.getString(6));
			pfood.setPFSTOCKAVAILABILITY(rs.getInt(7));
			pfood.setPFImages(rs.getString(8));
            return pfood;
			});
		return pp3list;
	
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Plant_Food> getAllPlantFoodsLoadedByRatingPrice(int offset, int limit, double rating, double from,
			double to) {
String query = "SELECT * FROM Plant_Food WHERE PFRATING = ? AND JSON_EXTRACT(PFPRICE, '$[0].SP') BETWEEN ? AND ? LIMIT ? OFFSET ?";
		
		
List<Plant_Food> pp4list = jdbcTemplate.query(query, new Object[]{rating, from, to ,limit, offset}, (rs, num) -> {
			Plant_Food pfood = new Plant_Food();
        	pfood.setPFID(rs.getString(1));
			pfood.setPFTitle(rs.getString(2));
			pfood.setPFDescription(rs.getString(3));
			pfood.setPFWeight(rs.getString(4));
			pfood.setPFRating(rs.getDouble(5));
			pfood.setPFPrice(rs.getString(6));
			pfood.setPFSTOCKAVAILABILITY(rs.getInt(7));
			pfood.setPFImages(rs.getString(8));
            return pfood;
			});
		return pp4list;
		}

	@Override
	public List<Plant_Food> getAllPlantFoodsLoadedByRatingStock(int offset, int limit, double rating, int stock) {
String query = "SELECT * FROM Plant_Food WHERE PFRATING = ? AND PFSTOCKAVAILABILITY = ? LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<Plant_Food> pp5list = jdbcTemplate.query(query, new Object[]{rating,stock,limit, offset}, (rs, num) -> {
			Plant_Food pfood = new Plant_Food();
        	pfood.setPFID(rs.getString(1));
			pfood.setPFTitle(rs.getString(2));
			pfood.setPFDescription(rs.getString(3));
			pfood.setPFWeight(rs.getString(4));
			pfood.setPFRating(rs.getDouble(5));
			pfood.setPFPrice(rs.getString(6));
			pfood.setPFSTOCKAVAILABILITY(rs.getInt(7));
			pfood.setPFImages(rs.getString(8));
            return pfood;
			});
		return pp5list;
	}

	@Override
	public List<Plant_Food> getAllPlantFoodsLoadedByPriceStock(int offset, int limit, double from, double to,
			int stock) {
String query = "SELECT * FROM Plant_Food WHERE JSON_EXTRACT(PFPRICE, '$[0].SP') BETWEEN ? AND ? AND PFSTOCKAVAILABILITY = ? LIMIT ? OFFSET ?";
		
		@SuppressWarnings("deprecation")
		List<Plant_Food> pp6list = jdbcTemplate.query(query, new Object[]{from, to,stock,limit, offset}, (rs, num) -> {
			Plant_Food pfood = new Plant_Food();
        	pfood.setPFID(rs.getString(1));
			pfood.setPFTitle(rs.getString(2));
			pfood.setPFDescription(rs.getString(3));
			pfood.setPFWeight(rs.getString(4));
			pfood.setPFRating(rs.getDouble(5));
			pfood.setPFPrice(rs.getString(6));
			pfood.setPFSTOCKAVAILABILITY(rs.getInt(7));
			pfood.setPFImages(rs.getString(8));
            return pfood;
			});
		return pp6list;
	}

	@Override
	public List<Plant_Food> getAllPlantFoodsLoadedByPriceStockRating(int offset, int limit, double from, double to,
			int stock, double rating) {
		String query = "SELECT * FROM PLANT_FOOD WHERE JSON_EXTRACT(PFPRICE, '$[0].SP') BETWEEN ? AND ? AND PFSTOCKAVAILABILITY = ? AND PFRATING = ? LIMIT ? OFFSET ?";
	    @SuppressWarnings("deprecation")
	    List<Plant_Food> pp7list = jdbcTemplate.query(query, new Object[]{from, to, stock, rating, limit, offset}, (rs, num) -> {
	    	Plant_Food pfood = new Plant_Food();
        	pfood.setPFID(rs.getString(1));
			pfood.setPFTitle(rs.getString(2));
			pfood.setPFDescription(rs.getString(3));
			pfood.setPFWeight(rs.getString(4));
			pfood.setPFRating(rs.getDouble(5));
			pfood.setPFPrice(rs.getString(6));
			pfood.setPFSTOCKAVAILABILITY(rs.getInt(7));
			pfood.setPFImages(rs.getString(8));
            return pfood;
			});
		return pp7list;
	}

	@Override
	public List<Plant_Food> getAllPlantFoodLoadedByRatingPriceSORTTITLE_A_Z(int offset, int limit, double rating,
			double from, double to) {
		String query = "SELECT * FROM PLANT_FOOD WHERE PFRATING = ? AND JSON_EXTRACT(PFPRICE, '$[0].SP') BETWEEN ? AND ? Order by PFTITLE LIMIT ? OFFSET ?";
	    @SuppressWarnings("deprecation")
	    List<Plant_Food> pp8list = jdbcTemplate.query(query, new Object[]{rating, from, to ,limit, offset}, (rs, num) -> {
	    	Plant_Food pfood = new Plant_Food();
        	pfood.setPFID(rs.getString(1));
			pfood.setPFTitle(rs.getString(2));
			pfood.setPFDescription(rs.getString(3));
			pfood.setPFWeight(rs.getString(4));
			pfood.setPFRating(rs.getDouble(5));
			pfood.setPFPrice(rs.getString(6));
			pfood.setPFSTOCKAVAILABILITY(rs.getInt(7));
			pfood.setPFImages(rs.getString(8));
            return pfood;
			});
		return pp8list;
	}

	@Override
	public List<Plant_Food> getAllPlantFoodLoadedByRatingPriceSORTTITLE_Z_A(int offset, int limit, double rating,
			double from, double to) {
		String query = "SELECT * FROM PLANT_FOOD WHERE PFRATING = ? AND JSON_EXTRACT(PFPRICE, '$[0].SP') BETWEEN ? AND ? Order by PFTITLE DESC LIMIT ? OFFSET ?";
	    @SuppressWarnings("deprecation")
	    List<Plant_Food> pp9list = jdbcTemplate.query(query, new Object[]{rating, from, to ,limit, offset}, (rs, num) -> {
	    	Plant_Food pfood = new Plant_Food();
        	pfood.setPFID(rs.getString(1));
			pfood.setPFTitle(rs.getString(2));
			pfood.setPFDescription(rs.getString(3));
			pfood.setPFWeight(rs.getString(4));
			pfood.setPFRating(rs.getDouble(5));
			pfood.setPFPrice(rs.getString(6));
			pfood.setPFSTOCKAVAILABILITY(rs.getInt(7));
			pfood.setPFImages(rs.getString(8));
            return pfood;
			});
		return pp9list;
	}

	@Override
	public List<Plant_Food> getAllPlantFoodLoadedByRatingPriceSORTPRICE_L_H(int offset, int limit, double rating,
			double from, double to) {
		String query = "SELECT * FROM PLANT_FOOD WHERE PFRATING = ? AND JSON_EXTRACT(PFPRICE, '$[0].SP') BETWEEN ? AND ?  order by CAST(JSON_EXTRACT(PFPRICE, '$[0].SP') AS UNSIGNED) LIMIT ? OFFSET ?";
	    @SuppressWarnings("deprecation")
	    List<Plant_Food> pp10list = jdbcTemplate.query(query, new Object[]{rating, from, to ,limit, offset}, (rs, num) -> {
	    	Plant_Food pfood = new Plant_Food();
        	pfood.setPFID(rs.getString(1));
			pfood.setPFTitle(rs.getString(2));
			pfood.setPFDescription(rs.getString(3));
			pfood.setPFWeight(rs.getString(4));
			pfood.setPFRating(rs.getDouble(5));
			pfood.setPFPrice(rs.getString(6));
			pfood.setPFSTOCKAVAILABILITY(rs.getInt(7));
			pfood.setPFImages(rs.getString(8));
            return pfood;
			});
		return pp10list;
	}

	@Override
	public List<Plant_Food> getAllPlantFoodLoadedByRatingPriceSORTPRICE_H_L(int offset, int limit, double rating,
			double from, double to) {
		String query = "SELECT * FROM PLANT_FOOD WHERE PFRATING = ? AND JSON_EXTRACT(PFPRICE, '$[0].SP') BETWEEN ? AND ?  order by CAST(JSON_EXTRACT(PFPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
	    @SuppressWarnings("deprecation")
	    List<Plant_Food> pp11list = jdbcTemplate.query(query, new Object[]{rating, from, to ,limit, offset}, (rs, num) -> {
	    	Plant_Food pfood = new Plant_Food();
        	pfood.setPFID(rs.getString(1));
			pfood.setPFTitle(rs.getString(2));
			pfood.setPFDescription(rs.getString(3));
			pfood.setPFWeight(rs.getString(4));
			pfood.setPFRating(rs.getDouble(5));
			pfood.setPFPrice(rs.getString(6));
			pfood.setPFSTOCKAVAILABILITY(rs.getInt(7));
			pfood.setPFImages(rs.getString(8));
            return pfood;
			});
		return pp11list;
	}

	@Override
	public List<Plant_Food> getAllPlantFoodLoadedByRatingStockSORTTITLE_A_Z(int offset, int limit, double rating,
			int stock) {
		String query = "SELECT * FROM PLANT_FOOD WHERE PFRATING = ? AND PFSTOCKAVAILABILITY = ? Order by PFTITLE LIMIT ? OFFSET ?";
	    @SuppressWarnings("deprecation")
	    List<Plant_Food> pp12list = jdbcTemplate.query(query, new Object[]{rating,stock,limit, offset}, (rs, num) -> {
	    	Plant_Food pfood = new Plant_Food();
        	pfood.setPFID(rs.getString(1));
			pfood.setPFTitle(rs.getString(2));
			pfood.setPFDescription(rs.getString(3));
			pfood.setPFWeight(rs.getString(4));
			pfood.setPFRating(rs.getDouble(5));
			pfood.setPFPrice(rs.getString(6));
			pfood.setPFSTOCKAVAILABILITY(rs.getInt(7));
			pfood.setPFImages(rs.getString(8));
            return pfood;
			});
		return pp12list;
	}

	@Override
	public List<Plant_Food> getAllPlantFoodLoadedByRatingStockSORTTITLE_Z_A(int offset, int limit, double rating,
			int stock) {
		String query = "SELECT * FROM PLANT_FOOD WHERE PFRATING = ? AND PFSTOCKAVAILABILITY = ? Order by PFTITLE DESC LIMIT ? OFFSET ?";
	    @SuppressWarnings("deprecation")
	    List<Plant_Food> pp13list = jdbcTemplate.query(query, new Object[]{rating,stock,limit, offset}, (rs, num) -> {
	    	Plant_Food pfood = new Plant_Food();
        	pfood.setPFID(rs.getString(1));
			pfood.setPFTitle(rs.getString(2));
			pfood.setPFDescription(rs.getString(3));
			pfood.setPFWeight(rs.getString(4));
			pfood.setPFRating(rs.getDouble(5));
			pfood.setPFPrice(rs.getString(6));
			pfood.setPFSTOCKAVAILABILITY(rs.getInt(7));
			pfood.setPFImages(rs.getString(8));
            return pfood;
			});
		return pp13list;
	}

	@Override
	public List<Plant_Food> getAllPlantFoodLoadedByRatingStockSORTPRICE_L_H(int offset, int limit, double rating,
			int stock) {
		String query = "SELECT * FROM PLANT_FOOD WHERE PFRATING = ? AND PFSTOCKAVAILABILITY = ?  order by CAST(JSON_EXTRACT(PFPRICE, '$[0].SP') AS UNSIGNED) LIMIT ? OFFSET ?";
	    @SuppressWarnings("deprecation")
	    List<Plant_Food> pp14list = jdbcTemplate.query(query, new Object[]{rating,stock,limit, offset}, (rs, num) -> {
	    	Plant_Food pfood = new Plant_Food();
        	pfood.setPFID(rs.getString(1));
			pfood.setPFTitle(rs.getString(2));
			pfood.setPFDescription(rs.getString(3));
			pfood.setPFWeight(rs.getString(4));
			pfood.setPFRating(rs.getDouble(5));
			pfood.setPFPrice(rs.getString(6));
			pfood.setPFSTOCKAVAILABILITY(rs.getInt(7));
			pfood.setPFImages(rs.getString(8));
            return pfood;
			});
		return pp14list;
	}

	@Override
	public List<Plant_Food> getAllPlantFoodLoadedByRatingStockSORTPRICE_H_L(int offset, int limit, double rating,
			int stock) {
		String query = "SELECT * FROM PLANT_FOOD WHERE PFRATING = ? AND PFSTOCKAVAILABILITY = ?  order by CAST(JSON_EXTRACT(PFPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
	    @SuppressWarnings("deprecation")
	    List<Plant_Food> pp15list = jdbcTemplate.query(query, new Object[]{rating,stock,limit, offset}, (rs, num) -> {
	    	Plant_Food pfood = new Plant_Food();
        	pfood.setPFID(rs.getString(1));
			pfood.setPFTitle(rs.getString(2));
			pfood.setPFDescription(rs.getString(3));
			pfood.setPFWeight(rs.getString(4));
			pfood.setPFRating(rs.getDouble(5));
			pfood.setPFPrice(rs.getString(6));
			pfood.setPFSTOCKAVAILABILITY(rs.getInt(7));
			pfood.setPFImages(rs.getString(8));
            return pfood;
			});
		return pp15list;
	}

	@Override
	public List<Plant_Food> getAllPlantFoodLoadedByPriceStockSORTTITLE_A_Z(int offset, int limit, double from,
			double to, int stock) {
		String query = "SELECT * FROM PLANT_FOOD WHERE JSON_EXTRACT(PFPRICE, '$[0].SP') BETWEEN ? AND ? AND PFSTOCKAVAILABILITY = ? ORDER BY PFTITLE LIMIT ? OFFSET ?";
	    @SuppressWarnings("deprecation")
	    List<Plant_Food> pp16list = jdbcTemplate.query(query, new Object[]{from, to,stock,limit, offset}, (rs, num) -> {
	    	Plant_Food pfood = new Plant_Food();
        	pfood.setPFID(rs.getString(1));
			pfood.setPFTitle(rs.getString(2));
			pfood.setPFDescription(rs.getString(3));
			pfood.setPFWeight(rs.getString(4));
			pfood.setPFRating(rs.getDouble(5));
			pfood.setPFPrice(rs.getString(6));
			pfood.setPFSTOCKAVAILABILITY(rs.getInt(7));
			pfood.setPFImages(rs.getString(8));
            return pfood;
			});
		return pp16list;
	}

	@Override
	public List<Plant_Food> getAllPlantFoodLoadedByPriceStockSORTTITLE_Z_A(int offset, int limit, double from,
			double to, int stock) {
		String query = "SELECT * FROM PLANT_FOOD WHERE JSON_EXTRACT(PFPRICE, '$[0].SP') BETWEEN ? AND ? AND PFSTOCKAVAILABILITY = ? ORDER BY PFTITLE DESC LIMIT ? OFFSET ?";
	    @SuppressWarnings("deprecation")
	    List<Plant_Food> pp17list = jdbcTemplate.query(query, new Object[]{from, to,stock,limit, offset}, (rs, num) -> {
	    	Plant_Food pfood = new Plant_Food();
        	pfood.setPFID(rs.getString(1));
			pfood.setPFTitle(rs.getString(2));
			pfood.setPFDescription(rs.getString(3));
			pfood.setPFWeight(rs.getString(4));
			pfood.setPFRating(rs.getDouble(5));
			pfood.setPFPrice(rs.getString(6));
			pfood.setPFSTOCKAVAILABILITY(rs.getInt(7));
			pfood.setPFImages(rs.getString(8));
            return pfood;
			});
		return pp17list;
	}

	@Override
	public List<Plant_Food> getAllPlantFoodLoadedByPriceStockSORTPRICE_L_H(int offset, int limit, double from,
			double to, int stock) {
		String query = "SELECT * FROM PLANT_FOOD WHERE JSON_EXTRACT(PFPRICE, '$[0].SP') BETWEEN ? AND ? AND PFSTOCKAVAILABILITY = ?  order by CAST(JSON_EXTRACT(PFPRICE, '$[0].SP') AS UNSIGNED) LIMIT ? OFFSET ?";
	    @SuppressWarnings("deprecation")
	    List<Plant_Food> pp18list = jdbcTemplate.query(query, new Object[]{from, to,stock,limit, offset}, (rs, num) -> {
	    	Plant_Food pfood = new Plant_Food();
        	pfood.setPFID(rs.getString(1));
			pfood.setPFTitle(rs.getString(2));
			pfood.setPFDescription(rs.getString(3));
			pfood.setPFWeight(rs.getString(4));
			pfood.setPFRating(rs.getDouble(5));
			pfood.setPFPrice(rs.getString(6));
			pfood.setPFSTOCKAVAILABILITY(rs.getInt(7));
			pfood.setPFImages(rs.getString(8));
            return pfood;
			});
		return pp18list;
	}

	@Override
	public List<Plant_Food> getAllPlantFoodLoadedByPriceStockSORTPRICE_H_L(int offset, int limit, double from,
			double to, int stock) {
		String query = "SELECT * FROM PLANT_FOOD WHERE JSON_EXTRACT(PFPRICE, '$[0].SP') BETWEEN ? AND ? AND PFSTOCKAVAILABILITY = ?  order by CAST(JSON_EXTRACT(PFPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
	    @SuppressWarnings("deprecation")
	    List<Plant_Food> pp19list = jdbcTemplate.query(query, new Object[]{from, to,stock,limit, offset}, (rs, num) -> {
	    	Plant_Food pfood = new Plant_Food();
        	pfood.setPFID(rs.getString(1));
			pfood.setPFTitle(rs.getString(2));
			pfood.setPFDescription(rs.getString(3));
			pfood.setPFWeight(rs.getString(4));
			pfood.setPFRating(rs.getDouble(5));
			pfood.setPFPrice(rs.getString(6));
			pfood.setPFSTOCKAVAILABILITY(rs.getInt(7));
			pfood.setPFImages(rs.getString(8));
            return pfood;
			});
		return pp19list;
	}

	@Override
	public List<Plant_Food> getAllPlantFoodLoadedByPriceStockRatingSORTTITLE_A_Z(int offset, int limit, double from,
			double to, int stock, double rating) {
		String query = "SELECT * FROM PLANT_FOOD WHERE JSON_EXTRACT(PFPRICE, '$[0].SP') BETWEEN ? AND ? AND PFSTOCKAVAILABILITY = ? AND PFRATING = ? ORDER BY PFTITLE LIMIT ? OFFSET ?";
		@SuppressWarnings("deprecation")
		List<Plant_Food> pp20list = jdbcTemplate.query(query, new Object[]{from, to,stock,rating,limit, offset}, (rs, num) -> {
			Plant_Food pfood = new Plant_Food();
        	pfood.setPFID(rs.getString(1));
			pfood.setPFTitle(rs.getString(2));
			pfood.setPFDescription(rs.getString(3));
			pfood.setPFWeight(rs.getString(4));
			pfood.setPFRating(rs.getDouble(5));
			pfood.setPFPrice(rs.getString(6));
			pfood.setPFSTOCKAVAILABILITY(rs.getInt(7));
			pfood.setPFImages(rs.getString(8));
            return pfood;
			});
		return pp20list;
	}

	@Override
	public List<Plant_Food> getAllPlantFoodLoadedByPriceStockRatingSORTTITLE_Z_A(int offset, int limit, double from,
			double to, int stock, double rating) {
		String query = "SELECT * FROM PLANT_FOOD WHERE JSON_EXTRACT(PFPRICE, '$[0].SP') BETWEEN ? AND ? AND PFSTOCKAVAILABILITY = ? AND PFRATING = ? ORDER BY PFTITLE DESC LIMIT ? OFFSET ?";
		@SuppressWarnings("deprecation")
		List<Plant_Food> pp21list = jdbcTemplate.query(query, new Object[]{from, to,stock,rating,limit, offset}, (rs, num) -> {
			Plant_Food pfood = new Plant_Food();
        	pfood.setPFID(rs.getString(1));
			pfood.setPFTitle(rs.getString(2));
			pfood.setPFDescription(rs.getString(3));
			pfood.setPFWeight(rs.getString(4));
			pfood.setPFRating(rs.getDouble(5));
			pfood.setPFPrice(rs.getString(6));
			pfood.setPFSTOCKAVAILABILITY(rs.getInt(7));
			pfood.setPFImages(rs.getString(8));
            return pfood;
			});
		return pp21list;
	}

	@Override
	public List<Plant_Food> getAllPlantFoodLoadedByPriceStockRatingSORTPRICE_L_H(int offset, int limit, double from,
			double to, int stock, double rating) {
		String query = "SELECT * FROM Plant_Food WHERE JSON_EXTRACT(PFPRICE, '$[0].SP') BETWEEN ? AND ? AND PFSTOCKAVAILABILITY = ? AND PFRATING = ?  order by CAST(JSON_EXTRACT(PFPRICE, '$[0].SP') AS UNSIGNED) LIMIT ? OFFSET ?";
		@SuppressWarnings("deprecation")
		List<Plant_Food> pp22list = jdbcTemplate.query(query, new Object[]{from, to,stock,rating,limit, offset}, (rs, num) -> {
			Plant_Food pfood = new Plant_Food();
        	pfood.setPFID(rs.getString(1));
			pfood.setPFTitle(rs.getString(2));
			pfood.setPFDescription(rs.getString(3));
			pfood.setPFWeight(rs.getString(4));
			pfood.setPFRating(rs.getDouble(5));
			pfood.setPFPrice(rs.getString(6));
			pfood.setPFSTOCKAVAILABILITY(rs.getInt(7));
			pfood.setPFImages(rs.getString(8));
            return pfood;
			});
		return pp22list;
	}

	@Override
	public List<Plant_Food> getAllPlantFoodLoadedByPriceStockRatingSORTPRICE_H_L(int offset, int limit, double from,
			double to, int stock, double rating) {
		String query = "SELECT * FROM Plant_Food WHERE JSON_EXTRACT(PFPRICE, '$[0].SP') BETWEEN ? AND ? AND PFSTOCKAVAILABILITY = ? AND PFRATING = ?  order by CAST(JSON_EXTRACT(PFPRICE, '$[0].SP') AS UNSIGNED) DESC LIMIT ? OFFSET ?";
		@SuppressWarnings("deprecation")
		List<Plant_Food> pp23list = jdbcTemplate.query(query, new Object[]{from, to,stock,rating,limit, offset}, (rs, num) -> {
			Plant_Food pfood = new Plant_Food();
        	pfood.setPFID(rs.getString(1));
			pfood.setPFTitle(rs.getString(2));
			pfood.setPFDescription(rs.getString(3));
			pfood.setPFWeight(rs.getString(4));
			pfood.setPFRating(rs.getDouble(5));
			pfood.setPFPrice(rs.getString(6));
			pfood.setPFSTOCKAVAILABILITY(rs.getInt(7));
			pfood.setPFImages(rs.getString(8));
            return pfood;
			});
		return pp23list;
	}
}