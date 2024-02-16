package com.demo.Dao;

public interface ConsumerDao {

	boolean uploadData(String firstname, String lastname, String eMailid, String address, String pincode, String state,
			String gender, String whatsApp_Number, String userPassword);

	String getUID(String wno);

}
