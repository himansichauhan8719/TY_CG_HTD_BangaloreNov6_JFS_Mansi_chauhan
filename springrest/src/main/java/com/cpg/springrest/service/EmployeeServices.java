package com.cpg.springrest.service;

import java.util.List;

import com.cpg.springrest.dto.EmployeeBean;

public interface EmployeeServices {
	
	public EmployeeBean auth(String email, String password);
	public boolean register(EmployeeBean bean);
	public List<EmployeeBean> getEmployees(String Key);
	public boolean changePassword(int id, String password);
	public boolean deleteEmployee(int id);
}
