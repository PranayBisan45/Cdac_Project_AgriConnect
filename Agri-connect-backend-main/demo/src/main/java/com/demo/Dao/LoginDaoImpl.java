package com.demo.Dao;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.demo.Model.Login;


@Repository
public class LoginDaoImpl implements LoginDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    
    private SimpleJdbcCall jdbcCall;
    
    @Autowired
    private DataSource datasource;
    
    private String otpU ;
    
    
    public LoginDaoImpl(JdbcTemplate jdbctemplate) {
    	this.jdbcCall = new SimpleJdbcCall(jdbctemplate).withProcedureName("InsertUserLogin"); 
    }

    @Override
    public Boolean Validate(String uname, String upass) {
        String query = "SELECT * FROM consumer WHERE userid=? AND user_password=?";
        
        try {
            @SuppressWarnings("deprecation")
			Login loggedInUser = jdbcTemplate.queryForObject(
                query, new Object[] { uname, upass }, BeanPropertyRowMapper.newInstance(Login.class));
            
            return loggedInUser != null;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }
    
    

    @Override
    public String generateOtpForgotP(String phoneNo, String userID) {
    	
            boolean phoneExists = checkIfExists("WhatsApp_Number", phoneNo);
            boolean userIDExists = checkIfExists("USERID", userID);

            if (phoneExists && userIDExists) {         
            
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(datasource).withFunctionName("Forgot_Password_Check_SEND_OTP");

        SqlParameterSource in = new MapSqlParameterSource()
            .addValue("Phone", phoneNo)
            .addValue("usid", userID);

        String otp = jdbcCall.executeFunction(String.class, in);
        if(otp.length()<6) {
        	otp = otp+"7";
        }

        otpU = otp;
        return otp;
        }
            else {
            	return "UserId or WhatsappNo not found"; 
            }
    }
    

	@Override
	public Boolean verifyOtp(String otp) {
		if(otp.equals(otpU)) {
			return true;
		}else {
			return false;			
		}
	}

	@Override
	public Boolean updatePassword(String newPassword,String uid) {
	    try {
	    	
	    	String sql = "UPDATE consumer SET user_password = ? WHERE USERID = ?";
	        
	        int rowsAffected = jdbcTemplate.update(sql, newPassword,uid);
	        
	        return rowsAffected > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	private boolean checkIfExists(String columnName, String value) {
        String query = "SELECT COUNT(*) FROM consumer WHERE " + columnName + " = ?";
        int count = jdbcTemplate.queryForObject(query, Integer.class, value);
        return count > 0;
    }


	@Override
	public void savelogin(String useriD) {
		
		Map<String, Object> inParams1 = new HashMap<>();
		inParams1.put("p_user_id",useriD);
		jdbcCall.execute(inParams1);
		
	}
    
}
