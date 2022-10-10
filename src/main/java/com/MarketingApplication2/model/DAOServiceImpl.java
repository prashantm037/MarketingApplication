package com.MarketingApplication2.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOServiceImpl implements DAOService{
       private Connection con;
       private Statement stmnt;
       
       
	@Override
	public void connectDB() {
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/marketingapp","root","8861560012@pm");
		stmnt=con.createStatement();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean varify(String email, String password) {
		try {
			ResultSet result = stmnt.executeQuery("select * from login where email='"+email+"' and password='"+password+"'");
		return result.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void saveRegistration(String name, String city, String email, String mobile) {
		try {
			stmnt.executeUpdate("insert into registration values('"+name+"','"+city+"','"+email+"','"+mobile+"')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ResultSet getAllRegistration() {
		try {
			ResultSet result = stmnt.executeQuery("select * from registration");
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void DeleteRegistration(String email) {
		try {
			stmnt.executeUpdate("Delete from registration where email='"+email+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void UpdateRegistration(String email, String mobile) {
		try {
			stmnt.executeUpdate("UPDATE regestration SET mobile='"+mobile+"' where email='"+email+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
