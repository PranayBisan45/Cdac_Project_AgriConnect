package com.demo.dao;

import org.springframework.http.ResponseEntity;


public interface ProfileDao {


	ResponseEntity<String> editAddress(String newAddress, String uid);



}
