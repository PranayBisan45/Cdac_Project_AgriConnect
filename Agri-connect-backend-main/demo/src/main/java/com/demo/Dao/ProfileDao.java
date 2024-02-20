package com.demo.Dao;

import com.demo.Model.Consumer;

public interface ProfileDao {

	Consumer getConsumer(String userid);

	Boolean editaddress(String address, String state, String pincode, String userid1);

}
