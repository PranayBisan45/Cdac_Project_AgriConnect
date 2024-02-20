package com.demo.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.Model.Products;


@Repository
public class Add_TO_Cart_Dao_Impl implements Add_TO_Cart_Dao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Boolean AddTOCart(String pid, String ptitle, String pprice, String pimage, Integer qty) {
		String str="insert into AddTOCart values(?,?,?,?,?)";
		int a=jdbcTemplate.update(str,new Object[] {pid,ptitle,pprice,pimage,qty});
		if(a!=0) {
		return true;
		} else {
			return false;
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public Boolean RemoveToCart(String pid) {
		String query="delete from consumer where userid=?";
		
		    Products flag= jdbcTemplate.queryForObject(query,new Object[] {pid},BeanPropertyRowMapper.newInstance(Products.class));
		    if(flag!=null) {
		    	return true;
		    } else {
		    	return false;
		    }
	}
}
		