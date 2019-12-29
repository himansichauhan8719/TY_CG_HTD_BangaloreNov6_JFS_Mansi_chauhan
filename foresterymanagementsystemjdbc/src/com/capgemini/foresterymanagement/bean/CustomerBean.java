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
}
