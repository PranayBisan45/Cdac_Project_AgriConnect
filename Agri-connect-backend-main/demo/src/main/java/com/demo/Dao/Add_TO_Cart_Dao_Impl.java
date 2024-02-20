package com.demo.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.Model.Plant_Food;
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

	@Override
	public Boolean RemoveToCart(String pid) {
		String query="delete from AddToCart where pid=?";
		
		int flag = jdbcTemplate.update(query, pid);
		    if(flag!=0) {
		    	return true;
		    } else {
		    	return false;
		    }
	}

	@Override
	public List<Products> getAll() {
		List<Products> plist = jdbcTemplate.query("select * from AddToCart", (rs,num)->{
			Products p = new Products();
			p.setPid(rs.getString(1));
			p.setPtitle(rs.getString(2));
			p.setPprice(rs.getString(3));
			p.setPimage(rs.getString(4));
			p.setQty(rs.getInt(5));

			return p;
		});
		
		return plist;
	}
}
		