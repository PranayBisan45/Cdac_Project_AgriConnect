package com.demo.Service;

import com.demo.Model.Consumer;

public interface ProfileService {

	Consumer getConsumer(String userid);

	Boolean editAddress(String address, String state, String pincode, String userid1);

}
