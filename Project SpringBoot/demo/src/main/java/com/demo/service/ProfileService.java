package com.demo.service;

import org.springframework.http.ResponseEntity;

public interface ProfileService {

	ResponseEntity<String> editAddress(String newAddress, String uid);

}
