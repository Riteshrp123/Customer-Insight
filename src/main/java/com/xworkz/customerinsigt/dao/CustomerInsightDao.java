package com.xworkz.customerinsigt.dao;

import com.xworkz.customerinsigt.entity.CustomerInsightEntity;

public interface CustomerInsightDao {

	public boolean save(CustomerInsightEntity entity);

	public CustomerInsightEntity findByEmail(String email);

	public CustomerInsightEntity findByEmailAndPassword(String email, String password);

	public boolean updateByWrongPasswordCount(String email, int wrongPasswordCount);

	boolean updateAccountStatusByEmail(String acc_status, String email);

	boolean updateOtpByEmail(int otp, String email);
	
	int  getOtpByEmail(String email);
	
	boolean updatePasswordByEmail(String email,String password);
}
