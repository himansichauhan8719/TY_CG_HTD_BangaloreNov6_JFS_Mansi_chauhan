package com.capgemini.foresterymanagement.bean;

import java.io.Serializable;

import lombok.Data;
@Data
public class LandBean implements Serializable {
	
	private int landId;
	
	private String landLoc;
	
	private int landVal;
	
	private String acqDate;
	
	public String toString() {
		return " landId = " + landId + "\n landLoc = " + landLoc + "\n landVal = " + landVal
				+ "\n acqDate = " + acqDate + "\n";
	}
}
