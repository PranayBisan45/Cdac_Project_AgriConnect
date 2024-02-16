package com.demo.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class ProfileDaoImpl implements ProfileDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public boolean editAddress(String newAddress,String uid) {
		
		String str="update Consumer set Address=? where USERID=?";
		jdbcTemplate.update(str,new Object[] {newAddress,
				uid});
		 return (newAddress!=null)?true:false;
	}

}		
		
	
