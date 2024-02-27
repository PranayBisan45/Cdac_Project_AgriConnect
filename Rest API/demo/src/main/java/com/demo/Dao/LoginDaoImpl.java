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
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;

import com.demo.Model.Login;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


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
    public String generateOtpForgotP(String Phone, String userID) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(datasource).withFunctionName("Forgot_Password_Check_SEND_OTP");

        SqlParameterSource in = new MapSqlParameterSource()
            .addValue("Phone", Phone)
            .addValue("usid", userID);

        String otp = jdbcCall.executeFunction(String.class, in);
        if(otp.length()<6) {
        	otp = otp+"7";
        }

        otpU = otp;
        return otp;
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
	public Boolean updatePassword(String newPassword,String userId) {
        try {
            String sql = "UPDATE consumer SET user_password = ? WHERE userid = ?";
            int rowsAffected = jdbcTemplate.update(sql, newPassword, userId);
            return rowsAffected > 0; // Returns true if at least one row was updated
        } catch (Exception e) {
            // Handle any exceptions here, such as database errors
            e.printStackTrace();
            return false;
        }
    }

	@Override
	public void savelogin(String useriD) {
		
		Map<String, Object> inParams1 = new HashMap<>();
		inParams1.put("p_user_id",useriD);
		jdbcCall.execute(inParams1);
		
	}
    
}
