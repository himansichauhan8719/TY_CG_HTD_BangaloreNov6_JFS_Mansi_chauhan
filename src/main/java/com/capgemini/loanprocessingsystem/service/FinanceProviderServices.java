package com.capgemini.loanprocessingsystem.service;

import java.util.ArrayList;

import com.capgemini.loanprocessingsystem.dto.FinanceProviderBean;

public interface FinanceProviderServices {

	public  boolean addFinance(FinanceProviderBean financebean);
	
    public boolean deleteFinance(String loanType);
    
    public boolean modifyFinance(String loanType , FinanceProviderBean financebean);
    
    public FinanceProviderBean getFinance(String loanType);
    
	public ArrayList<FinanceProviderBean> getAllFinance(); 
}
