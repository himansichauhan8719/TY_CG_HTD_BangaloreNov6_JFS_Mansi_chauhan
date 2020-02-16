package com.capgemini.loanprocessingsystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;


@Entity

@Table(name = "financeProvider")
public class FinanceProviderBean {
   
	@Id
	@Column
	private String loanType;
	
	@Column
	private double loanTerm;
	
	@Column
	private double loanAmount;
	
	@Column
	private double interest;

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public double getLoanTerm() {
		return loanTerm;
	}

	public void setLoanTerm(double loanTerm) {
		this.loanTerm = loanTerm;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	
	
	
	
}
