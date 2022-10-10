package com.MarketingApplication2.model;

import java.sql.ResultSet;

public interface DAOService {
	
	public void connectDB();
	
	public boolean varify(String email,String password);
	
	public void saveRegistration(String name,String city,String email,String mobile);
	
	public ResultSet getAllRegistration();
	
	public void DeleteRegistration(String email);
	
	public void UpdateRegistration(String email,String mobile);

}
