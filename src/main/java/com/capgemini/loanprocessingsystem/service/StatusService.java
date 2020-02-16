package com.capgemini.loanprocessingsystem.service;

import java.util.List;

import com.capgemini.loanprocessingsystem.dto.Status;

public interface StatusService {
	public List<Status> getAllStatus();
	public boolean insertStatus(Status status);
	public boolean deleteStatus(int statusId);
	public Status searchStatus(int statusId);
	public boolean modifyStatus(int statusId, int applicationId, 
			String status, String loanType);

}
