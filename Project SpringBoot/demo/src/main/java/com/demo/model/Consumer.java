package com.demo.model;


public class Consumer {

	private String USERID;
	private String Firstname;
	private String Lastname;
	private String EmailId;
	private String Address;
	private String Pincode;
	private String State;
	private String Gender;
	private String WhatsApp_Number;
	private String User_password;
	private byte[] User_profile_image;
	
	public Consumer() {
		super();
	}

	public Consumer(String uSERID, String firstname, String lastname, String emailId, String address, String pincode,
			String state, String gender, String whatsApp_Number, String user_password,
			byte[] user_profile_image) {
		super();
		USERID = uSERID;
		Firstname = firstname;
		Lastname = lastname;
		EmailId = emailId;
		Address = address;
		Pincode = pincode;
		State = state;
		Gender = gender;
		WhatsApp_Number = whatsApp_Number;
		User_password = user_password;
		User_profile_image = user_profile_image;
	}

	public String getUSERID() {
		return USERID;
	}

	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}

	public String getFirstname() {
		return Firstname;
	}

	public void setFirstname(String firstname) {
		Firstname = firstname;
	}

	public String getLastname() {
		return Lastname;
	}

	public void setLastname(String lastname) {
		Lastname = lastname;
	}

	public String getEmailId() {
		return EmailId;
	}

	public void setEmailId(String emailId) {
		EmailId = emailId;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPincode() {
		return Pincode;
	}

	public void setPincode(String pincode) {
		Pincode = pincode;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getWhatsApp_Number() {
		return WhatsApp_Number;
	}

	public void setWhatsApp_Number(String whatsApp_Number) {
		WhatsApp_Number = whatsApp_Number;
	}

	public String getUser_password() {
		return User_password;
	}

	public void setUser_password(String user_password) {
		User_password = user_password;
	}

	public byte[] getUser_profile_image() {
		return User_profile_image;
	}

	public void setUser_profile_image(byte[] imageBytes) {
		User_profile_image = imageBytes;
	}

	@Override
	public String toString() {
		return "Consumer [USERID=" + USERID + ", Firstname=" + Firstname + ", Lastname=" + Lastname + ", EmailId="
				+ EmailId + ", Address=" + Address + ", Pincode=" + Pincode + ", State=" + State + ", Gender=" + Gender
				+ ", WhatsApp_Number=" + WhatsApp_Number + ", User_password=" + User_password + ", User_profile_image="
				+ User_profile_image + "]";
	}
	
	
}