package com.demo.dao;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;

import com.demo.model.Login;

@Repository
public class LoginDaoImpl implements LoginDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource datasource;

    @Autowired
    private JavaMailSender jms;

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
    
    String otp;

    @Override
    public String generateOtpForgotP(String email, String userID) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(datasource).withFunctionName("Forgot_Password_Check_SEND_OTP");

        SqlParameterSource in = new MapSqlParameterSource()
            .addValue("email", email)
            .addValue("usid", userID);

         otp = jdbcCall.executeFunction(String.class, in);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("hrishi.ns25@gmail.com");
        message.setTo(email);
        message.setText("Your OTP is: " + otp);
        message.setSubject("OTP has been sent to you");

        jms.send(message);

        return "success";
    }


	@Override
	public Boolean newPass(String whatsApp_Number, String oTP, String new_Password) {
		if(oTP==otp) {
			
			String str="update consumer set USER_PASSWORD=? where WhatsApp_Number=?";
			jdbcTemplate.update(str,new Object[] {new_Password,whatsApp_Number});
			return true;
		}
		return false;
	}
}
