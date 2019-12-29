package com.capgemini.foresterymanagement.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class ContractBean implements Serializable {

	private int prodId;
	
	private Integer contNo;
	
	private int custId;
	
	private int quantity;
	
	private String deliDate;
	
	@Override
	public String toString() {
		return " contNo = " + contNo + "\n custId = " + custId + "\n prodId = " + prodId
				+ "\n quantity = " + quantity + "\n deliDate = " + deliDate + "\n";
	
	}
}
