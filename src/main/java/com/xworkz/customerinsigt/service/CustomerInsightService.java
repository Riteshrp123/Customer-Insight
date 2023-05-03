package com.xworkz.customerinsigt.service;

import org.springframework.ui.Model;

import com.xworkz.customerinsigt.dto.CustomerInsightDto;
import com.xworkz.customerinsigt.entity.CustomerInsightEntity;

public interface CustomerInsightService {

	public boolean save(CustomerInsightDto dto, Model model);

	public CustomerInsightEntity findByEmail(String email);

	public CustomerInsightEntity findByEmailAndPassword(String email, String password, Model model);

	public boolean updateByWrongPasswordCount(String email, int wrongPasswordCount);

	boolean updateAccountStatusByEmail(String acc_status, String email);

	boolean sendMail(String email, CustomerInsightEntity entity);

	public int generateOtp();

	String forgotPassword(String email);

	boolean updateOtpByEmail(int otp, String email);
	
	boolean sendOtpByEmail(int otp,String email);
	
	boolean validateOtpByEmail(int otp,String email);
	
	int getOtpByEmail(String email);
	
	boolean resetPassword(String email,String password,String confirmPassword);
	
	boolean updatePasswordByEmail(String email,String password);

}
