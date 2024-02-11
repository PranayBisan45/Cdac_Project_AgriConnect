package com.demo.dao;

import java.util.List;

import com.demo.model.Plant_Food;

public interface PlantFoodDao {
	
	List<Plant_Food> getAllProducts();

	Plant_Food findById(String pfid);

	List<Plant_Food> sortA_Z(int offset, int limit);

	List<Plant_Food> sortZ_A(int offset, int limit);

	List<Plant_Food> Availability(int offset, int limit);

}
