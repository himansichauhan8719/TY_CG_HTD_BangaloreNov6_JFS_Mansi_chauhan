package com.capgemini.foresterymanagement.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProductBean implements Serializable {

	private int proId;
	
	private String proName;
	
	private String units;
	
	private int proQuantity;

	@Override
	public String toString() {
		return " prodId = " + proId + "\n proName = " + proName + "\n units = " + units
				+ "\n proQuantity = " + proQuantity + "\n";
	}
	
	
}


