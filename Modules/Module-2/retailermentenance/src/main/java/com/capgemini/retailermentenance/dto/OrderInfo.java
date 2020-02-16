package com.capgemini.retailermentenance.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="order_info")
public class OrderInfo {
	
	@Column
	@Id
	@GeneratedValue
	private int orderId;
	
	@Column
	private int productId;
	
	@Column 
	private int userId ;
	

}
