package com.capgemini.loanprocessingsystem.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.loanprocessingsystem.dao.FinanceProviderDAO;
import com.capgemini.loanprocessingsystem.dto.FinanceProviderBean;
import com.capgemini.loanprocessingsystem.exceptions.CustomException;
import com.capgemini.loanprocessingsystem.validations.Validations;

@Service
public class FinanceProviderServicesImpl implements FinanceProviderServices{
	@Autowired
	private FinanceProviderDAO financeProvider;

	@Override
	public boolean addFinance(FinanceProviderBean financebean) {

		if(!Validations.isChar(financebean.getLoanType())){
			throw new CustomException("Invalid data");
		}
		if(!Validations.isDouble(financebean.getLoanAmount())){
			throw new CustomException("Invalid data");
		}

		if(!Validations.isDouble(financebean.getInterest())){
			throw new CustomException("Invalid data");
		}
		if( !Validations.isDouble(financebean.getLoanTerm())) {
			throw new CustomException("Invalid data");
		}
		return financeProvider.addFinance(financebean);
	}

	@Override
	public boolean deleteFinance(String loanType) {

		if(!Validations.isChar(loanType))
		{	

			throw new CustomException("Invalid Input!!");
		}
		return financeProvider.deleteFinance(loanType);	
	}

	@Override
	public boolean modifyFinance(String loanType , FinanceProviderBean financebean) {

		if(!Validations.isChar(loanType)){
			throw new CustomException("Invalid data");
		}
		if(!Validations.isDouble(financebean.getLoanAmount())){
			throw new CustomException("Invalid data");
		}

		if(!Validations.isDouble(financebean.getInterest())){
			throw new CustomException("Invalid data");
		}
		if( !Validations.isDouble(financebean.getLoanTerm())) {
			throw new CustomException("Invalid data");
		}
		return financeProvider.modifyFinance(loanType, financebean);
	}




	@Override
	public ArrayList<FinanceProviderBean> getAllFinance() {

		return financeProvider.getAllFinance();
	}

	@Override
	public FinanceProviderBean getFinance(String loanType) {

		if(!Validations.isChar(loanType)) {
			throw new CustomException("Invalid Input!!");

		}

		return financeProvider.getFinance(loanType);
	}
}

