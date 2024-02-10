package com.demo.service;

import java.util.List;

import com.demo.model.Plant_Food;

public interface PlantFoodService {

	List<Plant_Food> getAllProducts();

	Plant_Food getById(String pfid);

	List<Plant_Food> sortA_Z(int offset, int limit);

	List<Plant_Food> sortZ_A(int offset, int limit);

	List<Plant_Food> Availability(int offset, int limit);

}
