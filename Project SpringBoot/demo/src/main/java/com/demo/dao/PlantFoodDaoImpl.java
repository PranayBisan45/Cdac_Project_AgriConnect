package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.model.Plant_Food;

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
		Plant_Food pfood = new Plant_Food();
		try {
		    return jdbcTemplate.queryForObject("select * from plant_food where pfid=?",new Object[] {pfid},BeanPropertyRowMapper.newInstance(Plant_Food.class));
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
			
	}

	@Override
	public List<Plant_Food> sortA_Z(int offset, int limit) {
		
		@SuppressWarnings("deprecation")
		List<Plant_Food> sortlist = jdbcTemplate.query("select * from plant_food order by pftitle limit ? offset ?",new Object[] {limit,offset}, (rs,num)->{
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
	public List<Plant_Food> sortZ_A(int offset, int limit) {
		@SuppressWarnings("deprecation")
		List<Plant_Food> sortlist = jdbcTemplate.query("select * from plant_food order by pftitle desc limit ? offset ?",new Object[] {limit,offset}, (rs,num)->{
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
		
		@SuppressWarnings("deprecation")
		List<Plant_Food> availablelist = jdbcTemplate.query("select * from plant_food where PFSTOCKAVAILABILITY=1 limit ? offset ?",new Object[] {limit,offset}, (rs,num)->{
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
}
