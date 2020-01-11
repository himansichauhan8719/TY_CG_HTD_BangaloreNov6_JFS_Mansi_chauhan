package com.capg.retailermaintanance.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="productinfo")
public class Productinfo {
	@Column
	@Id
	@GeneratedValue
	private int proid;
	@Column
	private int userid;
	@Column(unique=true,nullable=false)
	private String proname;
	@Column
	private int quantity;
	@Column
	private String details;
}
