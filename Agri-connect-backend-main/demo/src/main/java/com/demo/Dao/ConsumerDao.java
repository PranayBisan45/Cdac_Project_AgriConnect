package com.demo.Dao;

import org.springframework.web.multipart.MultipartFile;

public interface ConsumerDao {

	boolean uploadData(String firstname, String lastname, String EmailId,String address, String pincode, String state, String gender,
			String whatsApp_Number, String userPassword);

	String getuseridafterregistration(String whatsApp_Number);

}
