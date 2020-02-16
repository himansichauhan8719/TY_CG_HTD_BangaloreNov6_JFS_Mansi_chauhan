package com.capgemini.retailermentenance.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;

@Data
@Entity
@Table(name="product_info")
public class ProductInfo {
	
	@Column
	@Id
	@GeneratedValue
	private int productId;
	
//	@Column
//	private int userId;
	
	@Column(unique=true)
	private String name;
	
	@Column
	private int quantity;
	
	@Column
	private String details;
	
	@Exclude
	
	@ManyToOne
    private UserInfo userInfo;

}
