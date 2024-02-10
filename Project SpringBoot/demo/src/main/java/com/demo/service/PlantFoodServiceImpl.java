package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.PlantFoodDao;
import com.demo.model.Plant_Food;

@Service
public class PlantFoodServiceImpl implements PlantFoodService {
	
	@Autowired
	private PlantFoodDao pfdao;

	@Override
	public  List<Plant_Food> getAllProducts() {
		return pfdao.getAllProducts();
	}

	@Override
	public Plant_Food getById(String pfid) {
		 return pfdao.findById(pfid);
	}

	@Override
	public List<Plant_Food> sortA_Z(int offset, int limit) {
		return pfdao.sortA_Z(offset, limit);
	}

	@Override
	public List<Plant_Food> sortZ_A(int offset, int limit) {
		return pfdao.sortZ_A(offset, limit);
	}

	@Override
	public List<Plant_Food> Availability(int offset, int limit) {
		return pfdao.Availability(offset,limit);
	}

}
