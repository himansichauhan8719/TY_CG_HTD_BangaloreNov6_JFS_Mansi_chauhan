package com.capgemini.loanprocessingsystem.dao;

import java.util.List;

import com.capgemini.loanprocessingsystem.dto.Status;

public interface StatusDAO {
	public List<Status> getAllStatus();
	public boolean insertStatus(Status status);
	public boolean deleteStatus(int statusId);
	public Status searchStatus(int statusId);
	public boolean modifyStatus(int statusId, int applicationId, 
			String status, String loanType);


}
