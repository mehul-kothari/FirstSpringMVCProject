package com.employeemanagementportal;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Admin {
	
	@Id
	private int AdminId;
	private String Password; 
	public int getAdminId() {
		return AdminId;
	}
	public void setAdminId(int adminId) {
		AdminId = adminId;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	

}
