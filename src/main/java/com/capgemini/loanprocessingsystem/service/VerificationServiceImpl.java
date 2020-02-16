package com.capgemini.loanprocessingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.loanprocessingsystem.dao.CustomerDAO;
import com.capgemini.loanprocessingsystem.dao.VerificationDAO;
import com.capgemini.loanprocessingsystem.dto.Verification;
import com.capgemini.loanprocessingsystem.exceptions.CustomException;
import com.capgemini.loanprocessingsystem.validations.Validations;

@Service
public class VerificationServiceImpl implements VerificationService{

	@Autowired
	VerificationDAO verificationDAO;
	@Autowired
	CustomerDAO customerDAO;
	@Override
	public List<Verification> getAllVerification() {
		return verificationDAO.getAllVerification();
	}

	@Override
	public boolean insertVerification(Verification verification) {
		if(Validations.isNumber(verification.getApplicationId())) {
			if(customerDAO.searchCustomers(verification.getApplicationId())!=null) {
				verification.setApplicationId(verification.getApplicationId());
			}else {
				throw new CustomException("Application Id not found");
			}
		}else {

			throw new CustomException("Invalid Id");
		}
		if(!Validations.isChar(verification.getStatus())) {
			throw new CustomException("Invalid data ");
		}
		if(!Validations.isChar(verification.getLoanType())) {
			throw new CustomException("Invalid data");

		}
		verification.setVerificationId(verification.getApplicationId());
		return verificationDAO.insertVerification(verification);


	}

	@Override
	public boolean deleteVerification(int verificationId) {
		if(!Validations.isNumber(verificationId)) {
			throw new CustomException("Invalid id");

		}
		return verificationDAO.deleteVerification(verificationId);

	}

	@Override
	public Verification searchVerification(int applicationId) {


		if(!Validations.isNumber(applicationId)) { 
			throw  new CustomException("Invalid Id");
		}
		return verificationDAO.searchVerification(applicationId);
	}

	@Override
	public boolean modifyVerification(int verificationId, int applicationId, String interviewDate, String status,
			String loanType) {
		if(!Validations.isNumber(verificationId)) {
			throw new CustomException("Invalid Id");
		}
		if(!Validations.isNumber(applicationId)) {
			throw new CustomException("Invalid Id");
		}

		if(!Validations.isChar(status)) {
			throw new CustomException("Invalid data");

		}
		return verificationDAO.modifyVerification(verificationId, applicationId, interviewDate, status, loanType);


	}

}