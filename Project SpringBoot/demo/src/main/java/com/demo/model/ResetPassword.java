package com.demo.model;

public class ResetPassword {
	private String whatsApp_Number;
	private String OTP;
	private String NewPassword;
	public ResetPassword() {
		super();
	}
	public ResetPassword(String whatsApp_Number, String oTP, String newPassword) {
		super();
		this.whatsApp_Number = whatsApp_Number;
		OTP = oTP;
		NewPassword = newPassword;
	}
	public String getWhatsApp_Number() {
		return whatsApp_Number;
	}
	public void setWhatsApp_Number(String whatsApp_Number) {
		this.whatsApp_Number = whatsApp_Number;
	}
	public String getOTP() {
		return OTP;
	}
	public void setOTP(String oTP) {
		OTP = oTP;
	}
	public String getNewPassword() {
		return NewPassword;
	}
	public void setNewPassword(String newPassword) {
		NewPassword = newPassword;
	}
	@Override
	public String toString() {
		return "ResetPassword [whatsApp_Number=" + whatsApp_Number + ", OTP=" + OTP + ", NewPassword=" + NewPassword
				+ "]";
	}
}
