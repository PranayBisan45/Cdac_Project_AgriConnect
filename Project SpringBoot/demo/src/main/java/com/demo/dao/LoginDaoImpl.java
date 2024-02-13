package com.demo.dao;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;

import com.demo.model.Login;
import com.demo.model.Plant_Food;

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
        String query = "SELECT * FROM consumer WHERE userid=? AND user_passsword=?";
        
        try {
            Login loggedInUser = jdbcTemplate.queryForObject(
                query, new Object[] { uname, upass }, BeanPropertyRowMapper.newInstance(Login.class));
            
            return loggedInUser != null;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }

    @Override
    public String generateOtpForgotP(String email, String userID) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(datasource).withFunctionName("Forgot_Password_Check_SEND_OTP");

        SqlParameterSource in = new MapSqlParameterSource()
            .addValue("email", email)
            .addValue("usid", userID);

        String otp = jdbcCall.executeFunction(String.class, in);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("hrishi.ns25@gmail.com");
        message.setTo(email);
        message.setText("Your OTP is: " + otp);
        message.setSubject("OTP has been sent to you");

        jms.send(message);

        return "success";
    }
}
