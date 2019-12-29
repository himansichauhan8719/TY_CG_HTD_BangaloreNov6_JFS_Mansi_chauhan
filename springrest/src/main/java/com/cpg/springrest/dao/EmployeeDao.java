package com.cpg.springrest.dao;

import java.util.List;

import com.cpg.springrest.dto.EmployeeBean;

public interface EmployeeDao {
	
	public EmployeeBean auth(String email, String password);
	public boolean register(EmployeeBean bean);
	public List<EmployeeBean> getEmployees(String Key);
	public boolean changePassword(int id, String password);
	public boolean deleteEmployee(int id);
	

}
