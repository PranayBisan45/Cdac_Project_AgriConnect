package com.demo.Model;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

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
    

    public Consumer() {
        super();
    }

    public Consumer(String USERID, String firstname, String lastname, String emailId, String address, String pincode,
                    String state, String gender, String whatsApp_Number, String user_password) {
        this.USERID = USERID;
        this.Firstname = firstname;
        this.Lastname = lastname;
        this.EmailId = emailId;
        this.Address = address;
        this.Pincode = pincode;
        this.State = state;
        this.Gender = gender;
        this.WhatsApp_Number = whatsApp_Number;
        this.User_password = user_password;
        
    }

    public String getUSERID() {
        return USERID;
    }

    public void setUSERID(String USERID) {
        this.USERID = USERID;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    public String getEmailId() {
        return EmailId;
    }

    public void setEmailId(String EmailId) {
        this.EmailId = EmailId;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPincode() {
        return Pincode;
    }

    public void setPincode(String Pincode) {
        this.Pincode = Pincode;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getWhatsApp_Number() {
        return WhatsApp_Number;
    }

    public void setWhatsApp_Number(String WhatsApp_Number) {
        this.WhatsApp_Number = WhatsApp_Number;
    }

    public String getUser_password() {
        return User_password;
    }

    public void setUser_password(String User_password) {
        this.User_password = User_password;
    }

    



    @Override
    public String toString() {
        return "Consumer [USERID=" + USERID + ", Firstname=" + Firstname + ", Lastname=" + Lastname + ", EmailId="
                + EmailId + ", Address=" + Address + ", Pincode=" + Pincode + ", State=" + State + ", Gender=" + Gender
                + ", WhatsApp_Number=" + WhatsApp_Number + ", User_password=" + User_password + ", User_profile_image="
           +"]";
    }
}
