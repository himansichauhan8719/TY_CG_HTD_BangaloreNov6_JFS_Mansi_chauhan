package com.capgemini.forestrymanagement.forestrybean;

import lombok.Data;

@Data
public class CustomerBean {
      private int customerId;
      private String customerName;
      private String streetAdd1;
      private String streetAdd2;
      private String town;
      private int postalcode;
      private String email;
      private int telephoneNo;
//	public void setCustomerId(int customerId) {
//		this.customerId = customerId;
//	}
//	public void setCustomerName(String customerName) {
//		this.customerName = customerName;
//	}
//	public void setStreetAdd1(String streetAdd1) {
//		this.streetAdd1 = streetAdd1;
//	}
//	public void setStreetAdd2(String streetAdd2) {
//		this.streetAdd2 = streetAdd2;
//	}
//	public void setTown(String town) {
//		this.town = town;
//	}
//	public void setPostalcode(int postalcode) {
//		this.postalcode = postalcode;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public void setTelephoneNo(int telephoneNo) {
//		this.telephoneNo = telephoneNo;
//	}
//	public int getCustomerId() {
//		return customerId;
//	}
//	public String getCustomerName() {
//		return customerName;
//	}
//	public String getStreetAdd1() {
//		return streetAdd1;
//	}
//	public String getStreetAdd2() {
//		return streetAdd2;
//	}
//	public String getTown() {
//		return town;
//	}
//	public int getPostalcode() {
//		return postalcode;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public int getTelephoneNo() {
//		return telephoneNo;
//	}
	@Override
	public String toString() {
		return "CustomerBean [customerId=" + customerId + ", customerName=" + customerName + ", streetAdd1="
				+ streetAdd1 + ", streetAdd2=" + streetAdd2 + ", town=" + town + ", postalcode=" + postalcode
				+ ", email=" + email + ", telephoneNo=" + telephoneNo + "]";
	}
      
}

