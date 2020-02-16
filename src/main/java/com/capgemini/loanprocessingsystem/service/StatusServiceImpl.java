package com.capgemini.loanprocessingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.loanprocessingsystem.dao.CustomerDAO;
import com.capgemini.loanprocessingsystem.dao.StatusDAO;
import com.capgemini.loanprocessingsystem.dto.Status;
import com.capgemini.loanprocessingsystem.exceptions.CustomException;
import com.capgemini.loanprocessingsystem.validations.Validations;


@Service
public class StatusServiceImpl implements StatusService{
	@Autowired
	StatusDAO statusDAO;
	@Autowired
	CustomerDAO customerDAO;
	
	
	

	@Override
	public List<Status> getAllStatus() {
		return statusDAO.getAllStatus();

	}

	@Override
	public boolean insertStatus(Status status) {
		
	
		if(Validations.isNumber(status.getApplicationId())){
			if(customerDAO.searchCustomers(status.getApplicationId())!= null) {
				status.setApplicationId(status.getApplicationId());
				//return statusDAO.insertStatus(status);
				
				
		}else {
			throw new CustomException("Appliaction Id unavailable");
		}
		}else {
			throw new CustomException("Invalid data");
		}
		if(	!Validations.isChar(status.getLoanType())) {
			throw new CustomException("Invalid type");
		}

		if(!Validations.isChar(status.getStatus())) {
			throw new CustomException("Invalid data");
		}
		status.setStatusId(status.getApplicationId());
		return statusDAO.insertStatus(status);

	}



	@Override
	public boolean deleteStatus(int statusId) {

		if(!Validations.isNumber(statusId)) {
			throw new CustomException("Invalid Id");
		}
		return statusDAO.deleteStatus(statusId);

	}

	@Override
	public Status searchStatus(int statusId) {
		try {

			if(Validations.isNumber(statusId)){
				return statusDAO.searchStatus(statusId);
			}
		}catch (Exception e) {
			throw new CustomException("Invalid inputs!");
		}
		return null;	
	}

	@Override
	public boolean modifyStatus(int statusId, int applicationId, String status, String loanType) {

		if(!Validations.isNumber(statusId)){
			throw new CustomException("Invalid Id");
		}
		if(	!Validations.isNumber(applicationId) ){
			throw new CustomException("Invalid type");
		}

		if(!Validations.isChar(status)) {
			throw new CustomException("Invalid data");
		}
		if(!Validations.isChar(loanType)) {
			throw new CustomException("Invalid data");
		}

		return statusDAO.modifyStatus(statusId, applicationId, status, loanType);


	}

}
