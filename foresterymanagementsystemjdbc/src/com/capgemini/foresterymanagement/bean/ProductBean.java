package com.capgemini.foresterymanagement.bean;

import java.io.Serializable;

import lombok.Data;
@Data
public class ProductBean implements Serializable {
	private int proId;
	private String proName;
	private int proQuantity;
	private int proCost;
}
