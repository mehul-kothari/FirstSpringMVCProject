package com.employeemanagementportal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmployeeLoginDetails {
	@Id
	private int employeeID;
	private String employeePassword; 
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public String getEmployeePassword() {
		return employeePassword;
	}
	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}
	

}
