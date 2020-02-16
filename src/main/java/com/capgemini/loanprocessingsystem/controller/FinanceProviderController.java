package com.capgemini.loanprocessingsystem.controller;

import java.util.Arrays;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.loanprocessingsystem.dto.FinanceProviderBean;
import com.capgemini.loanprocessingsystem.dto.FinanceProviderResponce;
import com.capgemini.loanprocessingsystem.service.FinanceProviderServices;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class FinanceProviderController {

	@Autowired
	FinanceProviderServices financeProviderServices;
	
	@PostMapping(path = "/add-finance", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public FinanceProviderResponce addFinance(@RequestBody FinanceProviderBean financeprovider) {
		FinanceProviderResponce financeProviderResponce = new FinanceProviderResponce();
		if (financeProviderServices.addFinance(financeprovider)) {
			financeProviderResponce.setStatusCode(201);
			financeProviderResponce.setMessage("Success");
			financeProviderResponce.setDescription("Finance Added Successfully");
		}
		return financeProviderResponce;
	}
	
	@DeleteMapping(path = "/delete-finance/{loanType}", produces = MediaType.APPLICATION_JSON_VALUE)
	public FinanceProviderResponce deleteCustomer(@PathVariable("loanType") String loanType) {
		FinanceProviderResponce financeProviderResponce = new FinanceProviderResponce();
		if (financeProviderServices.deleteFinance(loanType)) {
			financeProviderResponce.setStatusCode(201);
			financeProviderResponce.setMessage("Success");
			financeProviderResponce.setDescription("Finance Deleted Successfully");
		}
		return financeProviderResponce;
	}
	
	@GetMapping(path = "/get-all-finance", produces = MediaType.APPLICATION_JSON_VALUE)
	public FinanceProviderResponce getAllFinance() {
		FinanceProviderResponce financeProviderResponse = new FinanceProviderResponce();
		List<FinanceProviderBean> list = financeProviderServices.getAllFinance();
		if (list.size()!=0) {
			financeProviderResponse.setStatusCode(201);
			financeProviderResponse.setMessage("Success");
			financeProviderResponse.setDescription("All Finance Found Successfully");
			financeProviderResponse.setFinanceProviderResponse(list);
		//	return financeProviderResponse;
		}
		return financeProviderResponse;
	}
	
	@GetMapping(path = "/get-finance/{loanType}", produces = MediaType.APPLICATION_JSON_VALUE)
	public FinanceProviderResponce searchCustomer(@PathVariable("loanType") String loanType) {
		FinanceProviderResponce financeProviderResponse = new FinanceProviderResponce();
		FinanceProviderBean financebean = financeProviderServices.getFinance(loanType);
		if (financebean != null) {
			financeProviderResponse.setStatusCode(201);
			financeProviderResponse.setMessage("Success");
			financeProviderResponse.setDescription("Finance Found Successfully");
			financeProviderResponse.setFinanceProviderResponse(Arrays.asList(financebean));
		}
		return financeProviderResponse;
	}
	
	@PutMapping(path = "/modify-finance", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public FinanceProviderResponce modifyFinance(@RequestBody FinanceProviderBean financeprovider) {
		FinanceProviderResponce financeProviderResponse = new FinanceProviderResponce();
		FinanceProviderBean financebean = new  FinanceProviderBean();
		financebean.setLoanType(financeprovider.getLoanType());
		financebean.setLoanTerm(financeprovider.getLoanTerm());
		financebean.setLoanAmount(financeprovider.getLoanAmount());
		financebean.setInterest(financeprovider.getInterest());
		if(financeProviderServices.modifyFinance(financeprovider.getLoanType(), financeprovider)) {
			financeProviderResponse.setStatusCode(201);
			financeProviderResponse.setMessage("Success");
			financeProviderResponse.setDescription("this loan Type Modified Successfully");
		} else {
			financeProviderResponse.setStatusCode(401);
			financeProviderResponse.setMessage("failure");
			financeProviderResponse.setDescription("this loan Type Modify not Success");
		}
		return financeProviderResponse;
	}
	
}
