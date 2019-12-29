package com.capgemini.foresterymanagement.bean;

import java.io.Serializable;

import lombok.Data;
@Data
public class ContractBean implements Serializable {
	private int prodId;
	private int contNo;
	private int custId;
	private int haulId;
	private String deliDate;
	private String deliDay;
	private int quantity;

	

}
