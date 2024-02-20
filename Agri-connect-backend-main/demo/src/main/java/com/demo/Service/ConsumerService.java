package com.demo.Service;

import org.springframework.web.multipart.MultipartFile;

public interface ConsumerService {

	boolean uploadData(String firstname, String lastname,String emailid, String address, String pincode, String state, String gender,
			String whatsApp_Number, String userPassword);

	String getUserIdAfterRegistration(String whatsApp_Number);

}
