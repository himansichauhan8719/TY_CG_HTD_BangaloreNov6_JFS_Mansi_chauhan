package com.capgemini.foresterymanagement.bean;

import java.io.Serializable;

import lombok.Data;
@Data
public class CustomerBean implements Serializable {

	private int custId;
	
	private String custName;
	
	private String custAdd;
	
	private String custTown;
	
	private int custZip;
	
	private String custEmail;
	
	private long custPhone;
	
	@Override
	public String toString() {
		return "CustId = " + custId + "\n CustName = " + custName + "\n CustAdd = "
				+ custAdd + "\n CustTown = " + custTown + "\n CustZip = " + custZip
				+ "\n CustEmail = " + custEmail + "\n CustPhone = " + custPhone + "\n";
	}
	
	
}



