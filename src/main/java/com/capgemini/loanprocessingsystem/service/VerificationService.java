package com.capgemini.loanprocessingsystem.service;

import java.util.List;

import com.capgemini.loanprocessingsystem.dto.Verification;

public interface VerificationService {
	public List<Verification> getAllVerification();
	public boolean insertVerification(Verification verification);
	public boolean deleteVerification(int verificationId);
	public Verification searchVerification(int applicationId);
	public boolean modifyVerification(int verificationId, int applicationId, String interviewDate, 
			String status, String loanType);



}
