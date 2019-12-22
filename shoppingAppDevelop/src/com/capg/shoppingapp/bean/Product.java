package com.capg.shoppingapp.bean;

import java.io.Serializable;

public class Product implements Serializable {
   private int proId;
   private String proName;
   private String proCost;
   private String proColor;
   private  String description;
   private int NumOfpro;
   
   
public int getProId() {
	return proId;
}
public void setProId(int proId) {
	this.proId = proId;
}
public String getProName() {
	return proName;
}
public void setProName(String proName) {
	this.proName = proName;
}
public String getProCost() {
	return proCost;
}
public void setProCost(String proCost) {
	this.proCost = proCost;
}
public String getProColor() {
	return proColor;
}
public void setProColor(String proColor) {
	this.proColor = proColor;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getNumOfpro() {
	return NumOfpro;
}
public void setNumOfpro(int numOfpro) {
	NumOfpro = numOfpro;
}

   
   
   
}
