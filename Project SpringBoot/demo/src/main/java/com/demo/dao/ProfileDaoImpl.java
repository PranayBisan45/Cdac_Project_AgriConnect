package com.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class ProfileDaoImpl implements ProfileDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public ResponseEntity<String> editAddress(String newAddress,String uid) {
		
		String str="update Consumer set Address=? where USERID=?";
		jdbcTemplate.update(str,new Object[] {newAddress,
				uid});
		 return new ResponseEntity<>(newAddress, HttpStatus.OK);
	}

}

		
		
	
