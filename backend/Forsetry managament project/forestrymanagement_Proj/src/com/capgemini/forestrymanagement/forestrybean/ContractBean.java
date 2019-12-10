package com.capgemini.forestrymanagement.forestrybean;

import lombok.Data;

@Data
public class ContractBean {
	  private int contractNo;
      private int customerId;
      private int productId;
      private int haulierId;
      private String deliveryDate;
      private int deliveryDay;
      private int quantity;
//	public int getContractNo() {
//		return contractNo;
//	}
//	public int getCustomerId() {
//		return customerId;
//	}
//	public int getProductId() {
//		return productId;
//	}
//	public int getHaulierId() {
//		return haulierId;
//	}
//	public int getDeliveryDate() {
//		return deliveryDate;
//	}
//	public int getDeliveryDay() {
//		return deliveryDay;
//	}
//	public int getQuantity() {
//		return quantity;
//	}
//	public void setContractNo(int contractNo) {
//		this.contractNo = contractNo;
//	}
//	public void setCustomerId(int customerId) {
//		this.customerId = customerId;
//	}
//	public void setProductId(int productId) {
//		this.productId = productId;
//	}
//	public void setHaulierId(int haulierId) {
//		this.haulierId = haulierId;
//	}
//	public void setDeliveryDate(int deliveryDate) {
//		this.deliveryDate = deliveryDate;
//	}
//	public void setDeliveryDay(int deliveryDay) {
//		this.deliveryDay = deliveryDay;
//	}
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}
	@Override
	public String toString() {
		return "ContractBean [contractNo=" + contractNo + ", customerId=" + customerId + ", productId=" + productId
				+ ", haulierId=" + haulierId + ", deliveryDate=" + deliveryDate + ", deliveryDay=" + deliveryDay
				+ ", quantity=" + quantity + "]";
	}
}
