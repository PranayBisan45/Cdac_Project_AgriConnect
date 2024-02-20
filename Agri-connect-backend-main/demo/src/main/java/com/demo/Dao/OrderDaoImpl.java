package com.demo.Dao;

import com.demo.Model.Order_Front;
import com.demo.Model.Order_Products;
import com.demo.Model.POT_PLANTERS;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Boolean insertOrder(List<String> productIDs, List<String> unitPrice, List<String> unitQuantity,
                               String subtotal, String uid,String token) {
        
    	String sql = "CALL Insert_Order(?, ?, ?)";
    	
    	jdbcTemplate.update(sql, uid, subtotal, token);
    	
    	
    	

    	// Retrieve the generated order ID from the result map
    	String orderId = jdbcTemplate.queryForObject("SELECT orderid FROM Orders WHERE userid = ? and token = ?", String.class, uid,token);


        

        // Insert each product into the order
        for (int i = 0; i < productIDs.size(); i++) {
        	String sql2 = "Call Order_products(?,?,?,?)";
        	jdbcTemplate.update(sql2,orderId,productIDs.get(i),unitPrice.get(i),unitQuantity.get(i));
        }

        return true; // Return whatever is appropriate
    }


	@Override
	public List<Order_Front> getallorders(String usrid) {
		String query = "select orderid,ordertotal,datetimedetails from orders where userid = ?";
		
		@SuppressWarnings("deprecation")
		List<Order_Front> olist = jdbcTemplate.query(query, new Object[] {usrid}, (rs,num)->{
			Order_Front of = new Order_Front();
			of.setOrderID(rs.getString(1));
			of.setOrderPrice(rs.getString(2));
			of.setOrderedOn(rs.getString(3));
			
			return of;	
		});
		return olist;
	}

	

	    
	@Override
	public List<Order_Products> getAllProducts(String orderid) {
	    String sql = "SELECT op.productID, op.productQuantity, op.total, " +
	                 "CASE " +
	                 "WHEN EXISTS (SELECT 1 FROM plant_food WHERE PFID = op.productID) THEN 'plant_food' " +
	                 "WHEN EXISTS (SELECT 1 FROM plants WHERE PID = op.productID) THEN 'plants' " +
	                 "WHEN EXISTS (SELECT 1 FROM artificial_plant WHERE APID = op.productID) THEN 'artificial_plant' " +
	                 "WHEN EXISTS (SELECT 1 FROM pebbles_and_stones WHERE PASID = op.productID) THEN 'pebbles_and_stones' " +
	                 "WHEN EXISTS (SELECT 1 FROM plastic_pots WHERE PPOID = op.productID) THEN 'plastic_pots' " +
	                 "WHEN EXISTS (SELECT 1 FROM pot_planters WHERE PPID = op.productID) THEN 'pot_planters' " +
	                 "WHEN EXISTS (SELECT 1 FROM pump_spray WHERE PSID = op.productID) THEN 'pump_spray' " +
	                 "WHEN EXISTS (SELECT 1 FROM seed_bulb WHERE SBID = op.productID) THEN 'seed_bulb' " +
	                 "ELSE 'unknown_table' " +
	                 "END AS table_name " +
	                 "FROM ord_prod op " +
	                 "WHERE op.OrderID = ?";

	    @SuppressWarnings("deprecation")
	    List<Order_Products> products = jdbcTemplate.query(sql, new Object[]{orderid}, (rs, rowNum) -> {
	        String productID = rs.getString("productID");
	        int productQuantity = rs.getInt("productQuantity");
	        String table = rs.getString("table_name");
	        String productImages = "";
	        String productDescription = "";
	        String productTitle = "";

	        // Retrieve product details based on the table name
	        switch (table) {
	        	case "plants":
                productImages = jdbcTemplate.queryForObject("SELECT PIMAGES FROM plants WHERE PID = ?", String.class, productID);
                productDescription = jdbcTemplate.queryForObject("SELECT PDESCRIPTION FROM plants WHERE PID = ?", String.class, productID);
                productTitle = jdbcTemplate.queryForObject("SELECT PTITLE FROM plants WHERE PID = ?", String.class, productID);
                break;
            	case "plant_food":
                productImages = jdbcTemplate.queryForObject("SELECT PFIMAGES FROM plant_food WHERE PFID = ?", String.class, productID);
                productDescription = jdbcTemplate.queryForObject("SELECT PFDESCRIPTION FROM plant_food WHERE PFID = ?", String.class, productID);
                productTitle = jdbcTemplate.queryForObject("SELECT PFTITLE FROM plant_food WHERE PFID = ?", String.class, productID);
                break;
	            case "artificial_plant":
	                productImages = jdbcTemplate.queryForObject("SELECT APIMAGES FROM artificial_plant WHERE APID = ?", String.class, productID);
	                productDescription = jdbcTemplate.queryForObject("SELECT APDESCRIPTION FROM artificial_plant WHERE APID = ?", String.class, productID);
	                productTitle = jdbcTemplate.queryForObject("SELECT APTITLE FROM artificial_plant WHERE APID = ?", String.class, productID);
	                break;
	            case "pebbles_and_stones":
	                productImages = jdbcTemplate.queryForObject("SELECT PASIMAGES FROM pebbles_and_stones WHERE PASID = ?", String.class, productID);
	                productDescription = jdbcTemplate.queryForObject("SELECT PASDESCRIPTION FROM pebbles_and_stones WHERE PASID = ?", String.class, productID);
	                productTitle = jdbcTemplate.queryForObject("SELECT PASTITLE FROM pebbles_and_stones WHERE PASID = ?", String.class, productID);
	                break;
	            case "plastic_pots":
	                productImages = jdbcTemplate.queryForObject("SELECT PPOIMAGES FROM plastic_pots WHERE PPOID = ?", String.class, productID);
	                productDescription = jdbcTemplate.queryForObject("SELECT PPODESCRIPTION FROM plastic_pots WHERE PPOID = ?", String.class, productID);
	                productTitle = jdbcTemplate.queryForObject("SELECT PPOTITLE FROM plastic_pots WHERE PPOID = ?", String.class, productID);
	                break;
	            case "pot_planters":
	                productImages = jdbcTemplate.queryForObject("SELECT PPIMAGES FROM pot_planters WHERE PPID = ?", String.class, productID);
	                productDescription = jdbcTemplate.queryForObject("SELECT PPDESCRIPTION FROM pot_planters WHERE PPID = ?", String.class, productID);
	                productTitle = jdbcTemplate.queryForObject("SELECT PPTITLE FROM pot_planters WHERE PPID = ?", String.class, productID);
	                break;
	            case "pump_spray":
	                productImages = jdbcTemplate.queryForObject("SELECT PSIMAGES FROM pump_spray WHERE PSID = ?", String.class, productID);
	                productDescription = jdbcTemplate.queryForObject("SELECT PSDESCRIPTION FROM pump_spray WHERE PSID = ?", String.class, productID);
	                productTitle = jdbcTemplate.queryForObject("SELECT PSTITLE FROM pump_spray WHERE PSID = ?", String.class, productID);
	                break;
	            case "seed_bulb":
	                productImages = jdbcTemplate.queryForObject("SELECT SBIMAGES FROM seed_bulb WHERE SBID = ?", String.class, productID);
	                productDescription = jdbcTemplate.queryForObject("SELECT SBDESCRIPTION FROM seed_bulb WHERE SBID = ?", String.class, productID);
	                productTitle = jdbcTemplate.queryForObject("SELECT SBTITLE FROM seed_bulb WHERE SBID = ?", String.class, productID);
	                break;
	            default:
	                // Handle unknown table or add custom logic
	                break;
	        }

	        return new Order_Products(productImages, productTitle, productDescription, String.valueOf(productQuantity), productID);
	    });

	    return products;
	}
	    }
	
        
        
	
	
	
	
	
	
	
	
	
	
	
	
	

